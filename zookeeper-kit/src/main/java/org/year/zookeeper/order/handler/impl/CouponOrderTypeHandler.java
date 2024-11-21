package org.year.zookeeper.order.handler.impl;


import lombok.AllArgsConstructor;
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
@OrderTypeHandler("11")
@AllArgsConstructor
public class CouponOrderTypeHandler extends AbstractOrderTypeHandler {



    @Override // 优惠券订单具体业务实现
    public int handler(OrderEntity order) {
        // 给用户发放优惠券
        return 0;
    }


}
