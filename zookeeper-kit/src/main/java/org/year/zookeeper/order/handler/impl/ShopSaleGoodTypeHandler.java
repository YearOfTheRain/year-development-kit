package org.year.zookeeper.order.handler.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.year.zookeeper.order.annotation.OrderTypeHandler;
import org.year.zookeeper.order.entity.OrderEntity;
import org.year.zookeeper.order.handler.AbstractOrderTypeHandler;

/**
 * 壹企采商品购买后置处理逻辑
 * @author YearOfTheRain
 * @create 2023-09-19  09:26
 */
//@Component
@OrderTypeHandler("35")
@Slf4j
@RequiredArgsConstructor
public class ShopSaleGoodTypeHandler extends AbstractOrderTypeHandler {

    /**
     * 壹企采商品的后置处理方法
     * 整体流程：
     *  后台代买-->生成审核记录-->财务审核-->线下到款|余额购买-->走下单购买逻辑
     *  -->支付逻辑-->支付成功-->购买后的特殊处理
     * @param order
     * @return
     */
    @Override
    public int handler(OrderEntity order) {
        log.info("-------订单[{}]进入壹企采商品购买后置处理逻辑-------", order.getId());
        return 0;
    }
}
