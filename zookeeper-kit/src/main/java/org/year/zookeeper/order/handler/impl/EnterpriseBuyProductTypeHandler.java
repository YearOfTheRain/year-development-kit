package org.year.zookeeper.order.handler.impl;


import org.springframework.stereotype.Component;
import org.year.zookeeper.order.annotation.OrderTypeHandler;
import org.year.zookeeper.order.entity.OrderEntity;
import org.year.zookeeper.order.handler.AbstractOrderTypeHandler;

/**
 * 企业购买易管会员VIP
 */
@Component
@OrderTypeHandler("16")
public class EnterpriseBuyProductTypeHandler extends AbstractOrderTypeHandler {


    @Override
    public int handler(OrderEntity order) {

        return 1;

    }


}
