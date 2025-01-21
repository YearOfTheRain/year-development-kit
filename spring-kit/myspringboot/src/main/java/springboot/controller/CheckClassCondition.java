package springboot.controller;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

/**
 * @author YearOfTheRain
 * @create 2025-01-03  16:52
 */
public class CheckClassCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Map<String, Object> annotationAttributes = metadata.getAnnotationAttributes(MyConditionOnClass.class.getName());
        String value = (String) annotationAttributes.get("value");
        try {
            context.getClassLoader().loadClass(value);
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }
}
