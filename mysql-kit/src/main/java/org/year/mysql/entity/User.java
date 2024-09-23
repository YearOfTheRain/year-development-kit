package org.year.mysql.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author YearOfTheRain
 * @create 2024-09-12  11:26
 */
@Data
public class User {

    private Integer id;
    private String name;
    private Integer age;
    private String email;
    private LocalDateTime createdAt;
}
