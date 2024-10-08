package org.year.message;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class MessageKitApplication {

    public static void main(String[] args) {
        SpringApplication.run(MessageKitApplication.class, args);
    }

}
