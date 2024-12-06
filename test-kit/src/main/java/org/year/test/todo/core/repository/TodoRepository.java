package org.year.test.todo.core.repository;

import org.year.test.todo.core.domain.TodoItem;

import java.util.Collection;

/**
 * @author YearOfTheRain
 * @create 2024-12-06  10:56
 */
public interface TodoRepository {


    TodoItem save(TodoItem item);

    Collection<TodoItem> findAll();
}
