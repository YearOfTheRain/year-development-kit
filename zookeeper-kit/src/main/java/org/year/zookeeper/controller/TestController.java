package org.year.zookeeper.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YearOfTheRain
 * @create 2024-11-15  14:34
 */
@RequestMapping("/test")
@RestController
@Slf4j
public class TestController {

    private List<User> list = new ArrayList<>();

    @GetMapping("/test")
    public String getTestString() {
        User user = new User();
        user.setName("123");
        list.add(user);
        return "123213";
    }

    @GetMapping("/remove")
    public String remove() {
        list = new ArrayList<>();
        return "remove";
    }

    @GetMapping("/use")
    public String use() {
        return "use";
    }

    @PostMapping("/save")
    public String save(@RequestBody SaveRequest request) {
        log.info("save {}", request);
        return "save success";
    }


}
