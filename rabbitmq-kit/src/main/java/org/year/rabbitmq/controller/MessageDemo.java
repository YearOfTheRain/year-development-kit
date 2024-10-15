package org.year.rabbitmq.controller;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author YearOfTheRain
 * @create 2024-10-10  15:14
 */
public class MessageDemo {

    public static class MyApplication implements ApplicationListener<ApplicationEvent> {

        @Override
        public void onApplicationEvent(ApplicationEvent event) {
            System.out.println("=====> MyApplicationListener: "+ event);
        }

    }
}
