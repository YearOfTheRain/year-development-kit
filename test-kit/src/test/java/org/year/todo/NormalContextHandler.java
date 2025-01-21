package org.year.todo;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.year.test.todo.core.service.TodoService;

import java.lang.annotation.Annotation;
import java.util.Map;

/**
 * @author YearOfTheRain
 * @create 2025-01-17  10:28
 */
public class NormalContextHandler extends SimpleContextHandler<String, TodoService> {

    @Override
    public TodoService getInstance(String key) {
        return HANDLER_MAP.get(key);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, TodoService> beansOfType = applicationContext.getBeansOfType(TodoService.class);
        for (TodoService service : beansOfType.values()) {
            Annotation[] annotations = service.getClass().getAnnotations();
            for (Annotation annotation : annotations) {
                String name = annotation.annotationType().getName();
            }
        }
        HANDLER_MAP.put("normal", applicationContext.getBean(TodoService.class));
    }
}
