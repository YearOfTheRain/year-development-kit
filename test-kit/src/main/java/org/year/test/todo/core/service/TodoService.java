package org.year.test.todo.core.service;

import org.year.test.todo.core.domain.TodoItem;
import org.year.test.todo.core.parameter.TodoParameter;
import org.year.test.todo.core.repository.TodoRepository;

import java.util.List;

/**
 * 服务类
 * @author YearOfTheRain
 * @create 2024-12-06  10:50
 */
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public TodoItem addTodoItem(TodoParameter todoParameter) {
        if (todoParameter == null) {
            throw new IllegalArgumentException("Null or empty content is not allowed");
        }

        final TodoItem todoItem = new TodoItem();
        todoItem.setContent(todoParameter.content());
        return todoRepository.save(todoItem);
    }

    public void makeTodoItemDone(Long id) {

    }

    public List<TodoItem> list() {
        return todoRepository.findAll().stream().toList();
    }


}
