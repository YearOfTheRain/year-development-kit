package org.year.zookeeper.order.handler.impl;

import org.springframework.stereotype.Component;
import org.year.zookeeper.order.annotation.OrderTypeHandler;
import org.year.zookeeper.order.entity.OrderEntity;
import org.year.zookeeper.order.handler.AbstractOrderTypeHandler;

/**
 * <p>
 * 学分兑换课程订单处理器
 * </p>
 *
 * @author 张鹏
 * @since 2021-11-16
 */
//@Component
@OrderTypeHandler("9")
public class ExchangeOrderTypeHandler extends AbstractOrderTypeHandler {


    @Override
    public int handler(OrderEntity order) {

        return 0;
    }
}
