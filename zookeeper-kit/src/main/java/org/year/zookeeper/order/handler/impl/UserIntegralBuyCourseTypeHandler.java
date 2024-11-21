package org.year.zookeeper.order.handler.impl;


import org.springframework.stereotype.Component;
import org.year.zookeeper.order.annotation.OrderTypeHandler;
import org.year.zookeeper.order.entity.OrderEntity;
import org.year.zookeeper.order.handler.AbstractOrderTypeHandler;

/**
 * @author Administrator
 */
//@Component
@OrderTypeHandler("9")
public class UserIntegralBuyCourseTypeHandler extends AbstractOrderTypeHandler {



    @Override
    public int handler(OrderEntity order) {

        return 1;
    }
}
