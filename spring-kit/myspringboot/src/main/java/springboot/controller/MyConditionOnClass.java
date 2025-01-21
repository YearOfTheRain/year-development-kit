package springboot.controller;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author YearOfTheRain
 * @create 2025-01-03  16:52
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Conditional(CheckClassCondition.class)
public @interface MyConditionOnClass {

    String value();
}
