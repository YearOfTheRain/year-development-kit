package org.year.zookeeper.order.handler.impl;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.year.zookeeper.order.annotation.OrderTypeHandler;
import org.year.zookeeper.order.entity.OrderEntity;
import org.year.zookeeper.order.handler.AbstractOrderTypeHandler;

@Component
@OrderTypeHandler("8")
@AllArgsConstructor
public class EnterpriseBuyPlaceTypeHandler extends AbstractOrderTypeHandler {



    @Override
    public int handler(OrderEntity order) {

        return 0;
    }
}
