package org.year.zookeeper.order.handler.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.year.zookeeper.order.annotation.OrderTypeHandler;
import org.year.zookeeper.order.entity.OrderEntity;
import org.year.zookeeper.order.handler.AbstractOrderTypeHandler;

/**
 * 用户充值订单后置处理逻辑
 *
 * @author YEAR
 * @version v1.0
 * @program jy-retail-service
 * @date 2021-11-14 16:53
 */
//@Component
@OrderTypeHandler("10")
@AllArgsConstructor
@Slf4j
public class UserRechargeHandler extends AbstractOrderTypeHandler {



    @Override
    public int handler(OrderEntity order) {
        log.info("订单【{}】进入充值订单后置处理逻辑", order.getOrderNo());


            return 1;
        }



}
