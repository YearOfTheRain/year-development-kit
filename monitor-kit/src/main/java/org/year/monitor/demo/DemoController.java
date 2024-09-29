package org.year.monitor.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.year.monitor.aop.MonitorTarget;

/**
 * @author YearOfTheRain
 * @create 2024-09-28  09:29
 */
@Slf4j
@RestController
@RequestMapping("/api/demo")
public class DemoController {

    @GetMapping("/hello")
    @MonitorTarget("demo的hello方法")
    public String helloGet() {
        log.info("helloGet");
       return "hello GET";
    }

    @PostMapping("/hello")
    public String helloPost() {
        log.info("helloPost");
        return "hello POST";
    }

    @GetMapping("/info")
    public String infoGet(String userId) {
        log.info("infoGet");
        return "info GET" + userId;
    }
}
