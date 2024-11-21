package org.year.zookeeper.order.handler.impl;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.year.zookeeper.order.annotation.OrderTypeHandler;
import org.year.zookeeper.order.entity.OrderEntity;
import org.year.zookeeper.order.handler.AbstractOrderTypeHandler;

/**
 * 数字产品购买后置处理逻辑
 * @author YearOfTheRain
 * @create 2023-09-19  09:26
 */
@Component
@OrderTypeHandler("30")
@Slf4j
@RequiredArgsConstructor
public class TechProductTypeHandler extends AbstractOrderTypeHandler {

    @Override
    public int handler(OrderEntity order) {
        log.info("-------订单[{}]进入数字产品购买后置处理逻辑-------", order.getId());


        return 0;
    }


}
