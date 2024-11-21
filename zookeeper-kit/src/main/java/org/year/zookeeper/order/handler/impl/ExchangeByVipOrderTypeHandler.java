package org.year.zookeeper.order.handler.impl;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.year.zookeeper.order.annotation.OrderTypeHandler;
import org.year.zookeeper.order.entity.OrderEntity;
import org.year.zookeeper.order.handler.AbstractOrderTypeHandler;

/**
 * @desc 优惠券订单具体业务实现
 * @Author: Nuo
 * @Date: 2021/11/8 9:39
 * @Version 1.0
 */

@Component
@OrderTypeHandler("12")
@AllArgsConstructor
public class ExchangeByVipOrderTypeHandler extends AbstractOrderTypeHandler {
    @Autowired
    private CompanyCourseAllOrderTypeHandler companyCourseAllOrderTypeHandler;

    @Override // 优惠券订单具体业务实现
    public int handler(OrderEntity order) {
        companyCourseAllOrderTypeHandler.handler(order);
        return 1;
    }


}
