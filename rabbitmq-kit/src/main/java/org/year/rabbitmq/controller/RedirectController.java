package org.year.rabbitmq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;

/**
 * @author YearOfTheRain
 * @create 2024-09-26  18:07
 */
@Deprecated
@Controller
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
}
