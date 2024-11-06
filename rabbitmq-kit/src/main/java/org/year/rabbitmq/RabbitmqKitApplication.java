package org.year.rabbitmq;

import jakarta.annotation.Resource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.year.rabbitmq.controller.MessageDemo;

@SpringBootApplication
public class RabbitmqKitApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(RabbitmqKitApplication.class);
//        application.addListeners(event -> {
//            System.out.println("=====> anonymityListener: "+ event);
//        });
//        application.addListeners(new MessageDemo.MyApplication());
        application.run(args);
//        SpringApplication.run(RabbitmqKitApplication.class, args);
    }

    @Resource
    private ApplicationContext applicationContext;

    @Override
    public void run(String... args) throws Exception {
        applicationContext.publishEvent(new ApplicationEvent("23432432"){});
    }
}
