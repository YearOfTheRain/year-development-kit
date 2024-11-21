package org.year.zookeeper.order.handler.impl;

import org.springframework.stereotype.Component;
import org.year.zookeeper.order.annotation.OrderTypeHandler;
import org.year.zookeeper.order.entity.OrderEntity;
import org.year.zookeeper.order.handler.AbstractOrderTypeHandler;

/**
 * <p>
 * 企业购买课程学习名额订单处理器
 * </p>
 *
 * @author 张鹏
 * @since 2021-11-10
 */
@Component
@OrderTypeHandler("5")
public class CompanyCourseQuotaOrderTypeHandler extends AbstractOrderTypeHandler {


    @Override
    public int handler(OrderEntity order) {

        return 0;
    }


}
