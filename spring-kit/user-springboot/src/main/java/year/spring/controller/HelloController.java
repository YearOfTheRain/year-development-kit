package year.spring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YearOfTheRain
 * @create 2024-12-06  17:39
 */
@RestController
public class HelloController {

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String hi(){
        return "hello world";
    }
}
