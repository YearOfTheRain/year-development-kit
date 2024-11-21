package org.year.zookeeper.order.handler.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.year.zookeeper.order.annotation.OrderTypeHandler;
import org.year.zookeeper.order.entity.OrderEntity;
import org.year.zookeeper.order.handler.AbstractOrderTypeHandler;


@Component
@OrderTypeHandler("2")
public class UserBuyVipTypeHandler extends AbstractOrderTypeHandler {

    @Autowired
    private CompanyCourseAllOrderTypeHandler companyCourseAllOrderTypeHandler;

    /**
     * 用户购买会员后置处理
     *
     * @param order 订单详情
     * @return int
     */
    @Override
    public int handler(OrderEntity order) {
        companyCourseAllOrderTypeHandler.handler(order);
      return 0;
    }
}
