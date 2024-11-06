package org.year.rabbitmq.controller;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author YearOfTheRain
 * @create 2024-09-26  18:07
 */
@Deprecated
@Controller
@Slf4j
public class RedirectController {

    @GetMapping("/{path}")
    @Deprecated
    public String redirectUrl(@PathVariable("path") String path) throws IOException {
        // 获取真实地址
//        response.sendRedirect("https://whois.cloud.tencent.com/domain?domain=year.cn");
//        response.setStatus(302);
//        response.getWriter().flush();
        return "redirect:https://whois.cloud.tencent.com/domain?domain=year.cn";
    }


    @PostMapping("/webot/recvd")
    @ResponseBody
    public String recvd(RecData recData){
        log.info("接收数据 {}", recData);
        Map<String, Object> map = new HashMap<>();
        String dd = recData.getContent();
        String wechatName = JSONObject.parseObject(recData.getSource()).getJSONObject("from").getJSONObject("payload").getString("name");
        String stringBuilder = WebSocketUtil.chatConnect("1232", dd).toString();
        log.info("返回数据 {}", stringBuilder);
        String[] split = stringBuilder.split("\n");
        for (String s : split) {
            String body = HttpRequest.post("http://192.168.0.101:3001/webhook/msg/v2?token=PpJXTys2rI_f")
                    .body(
                            "{\n" +
                                    "    \"to\": \""+wechatName+"\",\n" +
                                    "    \"data\": {\n" +
                                    "        \"type\":\"text\",\n" +
                                    "        \"content\": \"" + s + "\"\n" +
                                    "    }\n" +
                                    "}"
                            , "application/json").execute().body();
            log.info("返回body数据 {}", body);
        }

        return "{}";
    }
}
