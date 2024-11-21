package org.year.zookeeper.order.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.year.zookeeper.order.entity.OrderEntity;

/**
 * @author zuozhe
 * @desc 抽象订单类型处理器
 * @date 2021/11/3
 */
public abstract class AbstractOrderTypeHandler {


    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 订单类型处理抽象方法
     *
     * @param order
     * @return
     */
    public abstract int handler(OrderEntity order);
}
