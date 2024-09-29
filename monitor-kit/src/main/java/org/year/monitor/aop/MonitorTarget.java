package org.year.monitor.aop;

import java.lang.annotation.*;

/**
 * 监控目标注解
 * @author YearOfTheRain
 * @create 2024-09-29  08:56
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface MonitorTarget {

    String value();
}
