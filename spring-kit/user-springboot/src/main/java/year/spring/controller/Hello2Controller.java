package year.spring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YearOfTheRain
 * @create 2024-12-06  17:39
 */
@RestController
public class Hello2Controller{

    private String myName;

    public Hello2Controller(String myName) {
        this.myName = myName;
    }

//    public Hello2Controller(Integer age) {
//        this.myName = "myName";
//    }

    @RequestMapping(value = "/hi2", method = RequestMethod.GET)
    public String hi2(){
        return myName + " hello world2";
    }
}
