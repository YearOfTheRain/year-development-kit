package org.year.zookeeper.order.handler.impl;


import org.springframework.stereotype.Component;
import org.year.zookeeper.order.annotation.OrderTypeHandler;
import org.year.zookeeper.order.entity.OrderEntity;
import org.year.zookeeper.order.handler.AbstractOrderTypeHandler;

/**
 * @desc 活动报名处理
 * @Author: Lei
 * @Date: 2023/1/6
 * @Version 1.0
 */

@Component
@OrderTypeHandler("17")
public class ActivityRegisteTypeHandler extends AbstractOrderTypeHandler {


    @Override
    public int handler(OrderEntity order) {

        return 0;
    }
}
