package org.year.rabbitmq.controller;

import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.springframework.stereotype.Component;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author YearOfTheRain
 * @create 2023-09-06  18:52
 */
@Slf4j
@Component
public class WebSocketUtil {

    public static final int NORMAL_CLOSURE_STATUS = 1000;

    public static final String hostUrl = "https://spark-api.xf-yun.com/v4.0/chat";
    public static final String appid = "eb304787";
    public static final String apiSecret = "NTM5Njk2NTg5NjYzZTk4NzUwN2E3OGRl";
    public static final String apiKey = "64803969c662398cb6041bf62d75f636";

    /**
     * 建立用户会话连接
     * @param userId
     * @param question
     * @return
     */
    public static StringBuilder chatConnect(String userId, String question) {
        String authUrl;
        try {
            String defaultUrl = "";
//            String defaultUrl = DictUtils.getDefaultDynamicDict(DynamicDictNameEnum.DEFAULT_BIG_MODEL_CHAT_URL);
            defaultUrl = StrUtil.isBlank(defaultUrl) ? hostUrl : defaultUrl;
            authUrl = getAuthUrl(defaultUrl, apiKey, apiSecret);
        } catch (Exception e) {
            log.error("组装请求参数发生异常", e);
            throw new RuntimeException("组装请求参数发生异常");
        }
        OkHttpClient client = new OkHttpClient.Builder().build();
        String url = authUrl.replace("http://", "ws://").replace("https://", "wss://");
        Request request = new Request.Builder().url(url).build();
        ChatConnectionListener listener = new ChatConnectionListener(userId, question, false);
        client.newWebSocket(request, listener);
        while (!listener.isEndFlag()) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                log.error("线程休眠异常", e);
            }
        }
        // 递归重复调用
        if (StrUtil.isBlank(listener.getAnswer().toString())) {
            return chatConnect(userId, question);
        }
        return listener.getAnswer();
    }

    /**
     * 权限认证拼接
     * @param hostUrl
     * @param apiKey
     * @param apiSecret
     * @return
     * @throws Exception
     */
    public static String getAuthUrl(String hostUrl, String apiKey, String apiSecret) throws Exception {
        URL url = new URL(hostUrl);
        // 时间
        SimpleDateFormat format = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
        format.setTimeZone(TimeZone.getTimeZone("GMT"));
        String date = format.format(new Date());
        // 拼接
        String preStr = "host: " + url.getHost() + "\n" +
                "date: " + date + "\n" +
                "GET " + url.getPath() + " HTTP/1.1";
        Mac mac = Mac.getInstance("hmacsha256");
        SecretKeySpec spec = new SecretKeySpec(apiSecret.getBytes(StandardCharsets.UTF_8), "hmacsha256");
        mac.init(spec);

        byte[] hexDigits = mac.doFinal(preStr.getBytes(StandardCharsets.UTF_8));
        // Base64加密
        String sha = Base64.getEncoder().encodeToString(hexDigits);
        // 拼接
        String authorization = String.format("api_key=\"%s\", algorithm=\"%s\", headers=\"%s\", signature=\"%s\"", apiKey, "hmac-sha256", "host date request-line", sha);
        // 拼接地址
        HttpUrl httpUrl = Objects.requireNonNull(HttpUrl.parse("https://" + url.getHost() + url.getPath())).newBuilder().//
                addQueryParameter("authorization", Base64.getEncoder().encodeToString(authorization.getBytes(StandardCharsets.UTF_8))).//
                addQueryParameter("date", date).//
                addQueryParameter("host", url.getHost()).//
                build();
        return httpUrl.toString();
    }
}



