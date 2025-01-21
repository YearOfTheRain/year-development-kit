package year.spring;

import org.springframework.context.annotation.Bean;
import springboot.controller.MySpringApplication;
import springboot.controller.MySpringboot;

@MySpringboot
public class SpringErrotKitApplication {

    public static void main(String[] args) {
        MySpringApplication.run(SpringErrotKitApplication.class);
    }


    @Bean
    public String myName() {
        return "zhangpeng";
    }
}
