package cn.year.spring.my_02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author YearOfTheRain
 * @create 2024-11-05  11:01
 */
public class TestDemo02 {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        User bean = context.getBean(User.class);
        bean.setName("1231");
        bean.show();
        context.close();
//        context.registerShutdownHook();
    }
}
