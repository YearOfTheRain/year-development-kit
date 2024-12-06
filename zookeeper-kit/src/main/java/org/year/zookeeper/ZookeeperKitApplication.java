package org.year.zookeeper;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

@SpringBootApplication
@Component
@Slf4j
public class ZookeeperKitApplication {


    public static void main(String[] args) {
        SpringApplication.run(ZookeeperKitApplication.class, args);
        System.out.println("启动成功");
    }

    @EventListener
    void init(ContextRefreshedEvent event) {
        log.info("初始化{}", event);
        //打印banner
        System.out.println("-----------------额wirei哦为若为日哦讹误日哦额我-");
    }

}
