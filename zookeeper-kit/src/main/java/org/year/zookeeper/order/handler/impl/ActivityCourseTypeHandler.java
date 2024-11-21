package org.year.zookeeper.order.handler.impl;


import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.year.zookeeper.order.annotation.OrderTypeHandler;
import org.year.zookeeper.order.entity.OrderEntity;
import org.year.zookeeper.order.handler.AbstractOrderTypeHandler;

/**
 * @desc 活动购买课程处理
 * @Author: Nuo
 * @Date: 2021/11/8 9:39
 * @Version 1.0
 */

@Component
@OrderTypeHandler("3")
@RequiredArgsConstructor
public class ActivityCourseTypeHandler extends AbstractOrderTypeHandler {
    private String userName;
    private int age;

    @Autowired
    private CompanyCourseAllOrderTypeHandler companyCourseAllOrderTypeHandler;
    @Autowired
    private UserBuyVipTypeHandler userBuyVipTypeHandler;


    @Override // 活动订单具体业务实现
    public int handler(OrderEntity order) {
        // 参加了活动的
        if (order.getActivityId() != null) {
            companyCourseAllOrderTypeHandler.handler(order);
        }
        userBuyVipTypeHandler.handler(order);
        return 0;
    }



}
