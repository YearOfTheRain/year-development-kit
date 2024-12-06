package org.year.test.todo.cli;

import org.year.test.todo.core.domain.TodoItem;
import org.year.test.todo.core.repository.TodoRepository;

import java.util.*;

/**
 * @author YearOfTheRain
 * @create 2024-12-06  15:32
 */
public class FileStoreRepository implements TodoRepository {

    private final List<TodoItem> store = new ArrayList<>(10);

    @Override
    public TodoItem save(TodoItem item) {
        store.add(item);
        return item;
    }

    @Override
    public Collection<TodoItem> findAll() {
        return store;
    }
}
