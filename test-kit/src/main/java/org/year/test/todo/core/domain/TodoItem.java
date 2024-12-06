package org.year.test.todo.core.domain;

import lombok.Data;

/**
 * @author YearOfTheRain
 * @create 2024-12-06  10:51
 */
@Data
public class TodoItem {

    private String content;

    private Long id;

    private Boolean done;

    public TodoItem() {
    }

    public TodoItem(long l, String foo) {
        this.id = l;
        this.content = foo;
    }
}
