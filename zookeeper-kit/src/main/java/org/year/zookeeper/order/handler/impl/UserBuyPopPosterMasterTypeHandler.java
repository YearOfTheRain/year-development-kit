package org.year.zookeeper.order.handler.impl;

import org.springframework.stereotype.Component;
import org.year.zookeeper.order.annotation.OrderTypeHandler;
import org.year.zookeeper.order.entity.OrderEntity;
import org.year.zookeeper.order.handler.AbstractOrderTypeHandler;


/**
 * 购买POP海报大师
 * @deprecated  2023/10/18 17:10:42 全部转移至数字产品进行购买
 * @author Administrator
 */
@Component
@OrderTypeHandler("22")
@Deprecated
public class UserBuyPopPosterMasterTypeHandler extends AbstractOrderTypeHandler {

    /**
     * 用户购买会员后置处理
     *
     * @param order 订单详情
     * @return int
     */
    @Override
    public int handler(OrderEntity order) {
        // 发送公众号模板消息
        return 1;
    }
}
