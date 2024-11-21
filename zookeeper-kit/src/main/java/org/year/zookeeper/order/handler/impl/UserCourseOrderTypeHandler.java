package org.year.zookeeper.order.handler.impl;

import org.springframework.stereotype.Component;
import org.year.zookeeper.order.annotation.OrderTypeHandler;
import org.year.zookeeper.order.entity.OrderEntity;
import org.year.zookeeper.order.handler.AbstractOrderTypeHandler;

/**
 * @author zuozhe
 * @desc 用户购买课程订单处理器
 * @date 2021/11/3
 */
//@Component
@OrderTypeHandler("1")
public class UserCourseOrderTypeHandler extends AbstractOrderTypeHandler {



    @Override
    public int handler(OrderEntity order) {



        return 1;
    }
}