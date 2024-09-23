package org.year.mysql.jdbc;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.year.mysql.entity.User;

import java.util.List;

/**
 * @author YearOfTheRain
 * @create 2024-09-12  11:39
 */
@SpringBootTest
@Slf4j
public class JdbcUserServiceTest {

    @Autowired
    private UserService userService;


    @Test
    void createAndList() {
        for (int i = 0; i < 100; i++) {
            User user = new User();
            user.setName("111" + i);
            user.setAge(23 + i);
            user.setEmail(i + "111@qq.com");

            Integer saved = userService.save(user);
            log.info("save result {}" ,saved);

            List<User> userList = userService.listAll();
            log.info("list result {}" , userList);
        }

    }
}
