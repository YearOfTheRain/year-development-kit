package org.year.zookeeper.order.handler.impl;

import org.springframework.stereotype.Component;
import org.year.zookeeper.order.annotation.OrderTypeHandler;
import org.year.zookeeper.order.entity.OrderEntity;
import org.year.zookeeper.order.handler.AbstractOrderTypeHandler;

/**
 * 企业购买vip订单后置处理类
 * @author Administrator
 */
@Component
@OrderTypeHandler("7")
public class EnterpriseBuyVipTypeHandler extends AbstractOrderTypeHandler {

    @Override
    public int handler(OrderEntity order) {

        return 1;

    }
}
