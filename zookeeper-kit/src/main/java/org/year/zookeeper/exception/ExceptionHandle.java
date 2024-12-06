package org.year.zookeeper.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author YearOfTheRain
 * @create 2024-11-22  09:13
 */
@RestControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(Exception.class)
    public String handleException(Exception e) {
        return "error";
    }
}
