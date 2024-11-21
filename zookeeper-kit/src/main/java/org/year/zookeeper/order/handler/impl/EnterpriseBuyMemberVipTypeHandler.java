package org.year.zookeeper.order.handler.impl;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.year.zookeeper.order.annotation.OrderTypeHandler;
import org.year.zookeeper.order.entity.OrderEntity;
import org.year.zookeeper.order.handler.AbstractOrderTypeHandler;

/**
 * 购买易管会员卡
 */
@Slf4j
@Component
@OrderTypeHandler("14")
public class EnterpriseBuyMemberVipTypeHandler extends AbstractOrderTypeHandler {


    @Override

    public int handler(OrderEntity order) {

        return 1;

    }

}
