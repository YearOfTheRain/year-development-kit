package org.year.zookeeper.order.handler.impl;

import org.springframework.stereotype.Component;
import org.year.zookeeper.order.annotation.OrderTypeHandler;
import org.year.zookeeper.order.entity.OrderEntity;
import org.year.zookeeper.order.handler.AbstractOrderTypeHandler;

/**
 * <p>
 * 企业购买课程到企业名下订单处理器
 * </p>
 *
 * @author 张鹏
 * @since 2021-11-10
 */
@Component
@OrderTypeHandler("6")
public class CompanyCourseAllOrderTypeHandler extends AbstractOrderTypeHandler {


    @Override
    public int handler(OrderEntity order) {

        return 0;
    }

}
