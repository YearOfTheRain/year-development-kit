package org.year.zookeeper.order.annotation;

import java.lang.annotation.*;

/**
 * @author zuozhe
 * @desc 自定义注解，标识订单类型
 * @date 2021/11/3
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface OrderTypeHandler {

    String value();
}