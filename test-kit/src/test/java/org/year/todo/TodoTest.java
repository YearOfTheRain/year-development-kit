package org.year.todo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mockito;
import org.year.test.todo.cli.FileStoreRepository;
import org.year.test.todo.core.domain.TodoItem;
import org.year.test.todo.core.parameter.TodoParameter;
import org.year.test.todo.core.repository.TodoRepository;
import org.year.test.todo.core.service.TodoService;

import java.util.Collection;
import java.util.List;


/**
 * @author YearOfTheRain
 * @create 2024-12-06  10:59
 */
public class TodoTest {

    private TodoService service;

    @BeforeEach
    void setUp() {
        TodoRepository repository = new DbRepository();
//        Mockito.when(repository.save(Mockito.any(TodoItem.class))).then(i -> i.getArgument(0));
        service = new TodoService(repository);
    }

    @Test
    void should_add_todo_item() {

        // 执行
        TodoItem todoItem = service.addTodoItem(new TodoParameter("foo"));

        // 断言
        Assertions.assertEquals("foo", todoItem.getContent());

        // 清理
    }

    @Test
    void should_throw_exception_while_parameter_is_empty() {
        Executable executable = () -> {
            // 执行
            service.addTodoItem(null);
        };

        // 断言
        Assertions.assertThrows(IllegalArgumentException.class, executable);
    }


    class DbRepository implements TodoRepository {

        @Override
        public TodoItem save(TodoItem item) {
            return null;
        }

        @Override
        public Collection<TodoItem> findAll() {
            return List.of();
        }
    }


    @Test
    void test111() {
        // 第一步：构建获取处理类

        // 第二步：组建接口类
    }


}
