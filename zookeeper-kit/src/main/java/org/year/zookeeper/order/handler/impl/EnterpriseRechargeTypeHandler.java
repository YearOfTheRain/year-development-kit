package org.year.zookeeper.order.handler.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.year.zookeeper.order.annotation.OrderTypeHandler;
import org.year.zookeeper.order.entity.OrderEntity;
import org.year.zookeeper.order.handler.AbstractOrderTypeHandler;

/**
 * 易管充值
 *
 * @author Administrator
 */
@Component
@OrderTypeHandler("15")
@AllArgsConstructor
@Slf4j
public class EnterpriseRechargeTypeHandler extends AbstractOrderTypeHandler {

    @Override
    public int handler(OrderEntity order) {
        log.info("订单【{}】进入充值订单后置处理逻辑", order.getOrderNo());

        log.info("本次充值【{}】", order.getOriginalPrice());
        return 1;
    }

}
