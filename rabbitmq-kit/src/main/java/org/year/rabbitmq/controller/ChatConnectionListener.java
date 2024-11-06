package org.year.rabbitmq.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * 星火文案大师
 * @author YearOfTheRain
 * @create 2023-09-06  19:17
 */
@Slf4j
@Data
@RequiredArgsConstructor
public class ChatConnectionListener extends WebSocketListener {

    protected String question;
    protected StringBuilder answer = new StringBuilder();
    protected String userId;
    protected boolean endFlag;

    public ChatConnectionListener(String userId, String question, boolean endFlag) {
        this.question = question;
        this.userId = userId;
        this.endFlag = endFlag;
    }

    @Override
    public void onOpen(WebSocket webSocket, Response response) {
        log.info("建立远程会话连接");
        super.onOpen(webSocket, response);
        new ChatAsyncConnectionThread(webSocket, question).start();
    }

    protected void superOnOpen(WebSocket webSocket, Response response) {
        log.info("仅建立顶级父类的远程会话连接");
        super.onOpen(webSocket, response);
    }

    @Override
    public void onMessage(WebSocket webSocket, String text) {
        log.info("接收到远程会话连接发来的消息");

        JsonParse myJsonParse = new Gson().fromJson(text, JsonParse.class);
        if (myJsonParse.header.code != 0) {
            log.error("发生错误，错误码为[{}],本次请求的sid为[{}],原因为[{}]",
                    myJsonParse.header.code, myJsonParse.header.sid, myJsonParse.header.message);
            webSocket.close(WebSocketUtil.NORMAL_CLOSURE_STATUS, "");
            return;
        }
        List<Text> textList = myJsonParse.payload.choices.text;
        for (Text temp : textList) {
            answer.append(temp.content);
        }
        // 结算扣费，推送扣费消息
        if (Objects.nonNull(myJsonParse.payload.usage)) {

        }
        if (myJsonParse.header.status == 2) {
            // 可以关闭连接，释放资源
            endFlag = true;
        }

    }

    @Override
    public void onClosing(WebSocket webSocket, int code, String reason) {
        log.info("WebSocket onClosing, reason [{}]", reason);
        webSocket.close(WebSocketUtil.NORMAL_CLOSURE_STATUS, null);
        endFlag = true;
    }

    @Override
    public void onFailure(WebSocket webSocket, Throwable t, Response response) {
        log.error("WebSocket onFailure", t);
    }


    /**
     * 异步连接线程
     */
    class ChatAsyncConnectionThread extends Thread {
        private final WebSocket webSocket;
        private final String question;

        public ChatAsyncConnectionThread(WebSocket webSocket, String question) {
            this.webSocket = webSocket;
            this.question = question + "。你的回答最多100字";
        }

        @Override
        public void run() {
            try {
                JSONObject requestJson = new JSONObject();

                JSONObject header = new JSONObject();  // header参数
                header.put("app_id", WebSocketUtil.appid);
                header.put("uid", UUID.randomUUID().toString().substring(0, 10));

                JSONObject parameter = new JSONObject(); // parameter参数
                parameter.put("chat", this.getChatJson());

                JSONObject payload = new JSONObject(); // payload参数
                JSONObject message = new JSONObject();
                message.put("text", this.getQuestionArray());
                payload.put("message", message);


                requestJson.put("header", header);
                requestJson.put("parameter", parameter);
                requestJson.put("payload", payload);

                webSocket.send(requestJson.toString());
                // 等待服务端返回完毕后关闭
                while (!endFlag) {
                    Thread.sleep(200);
                }
            } catch (Exception e) {
                log.error("发送websocket远程请求出现异常", e);
            }finally {
                log.info("异步线程结束，关闭远程连接");
                webSocket.close(WebSocketUtil.NORMAL_CLOSURE_STATUS, "");
            }
        }

        /**
         * 获取chat参数
         *
         * @return JSONObject
         */
        private JSONObject getChatJson() {
            JSONObject chat = new JSONObject();
            chat.put("temperature", 0.5);
            chat.put("max_tokens", 500);
            chat.put("domain", "4.0Ultra");
            return chat;
        }

        private JSONArray getQuestionArray() {
            JSONArray text = new JSONArray();
            RoleContent roleContent;
            // 最新问题
            roleContent = new RoleContent();
            roleContent.role = "user";
            roleContent.content = question;
            text.add(JSON.toJSON(roleContent));
            return text;
        }
    }

    @Data
    class RoleContent {
        String role;
        String content;
        String content_type;
    }

    class JsonParse {
        Header header;
        Payload payload;
    }

    class Header {
        int code;
        int status;
        String sid;
        String message;
    }

    class Payload {
        Choices choices;
        Usage usage;
    }

    class Usage {
        Text text;
    }

    class Choices {
        List<Text> text;
    }

    class Text {
        String role;
        String content;

        Integer question_tokens;
        Integer prompt_tokens;
        Integer completion_tokens;
        Integer total_tokens;
    }
}
