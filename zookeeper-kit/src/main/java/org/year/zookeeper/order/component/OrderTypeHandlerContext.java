package org.year.zookeeper.order.component;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.year.zookeeper.SysConfig;
import org.year.zookeeper.order.annotation.OrderTypeHandler;
import org.year.zookeeper.order.entity.OrderEntity;
import org.year.zookeeper.order.handler.AbstractOrderTypeHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zuozhe
 * @desc
 * @date 2021/11/3
 */
@Component
@Slf4j
public class OrderTypeHandlerContext implements ApplicationContextAware {

    private static final String DEFAULT_HANDLER = "default";


    @Autowired
    private Map<String, Map<String, Object>> infos;

    @Autowired
    private SysConfig sysConfig;

    /**
     * key为orderType，value为class
     */
    private static final Map<String, Object> HANDLER_MAP = new HashMap<>(32);

    public static AbstractOrderTypeHandler getHandlerInstance(String orderType) {
        Object clazz = HANDLER_MAP.get(orderType);
        if (clazz == null || !(clazz instanceof AbstractOrderTypeHandler)) {
            // 采用一个默认的空处理类型
            clazz = HANDLER_MAP.get(DEFAULT_HANDLER);
        }
        return (AbstractOrderTypeHandler)clazz;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        log.info("初始化订单处理器");
        log.info("单处理器{}", infos);
        log.info("单处理器{}", sysConfig);
        // 遍历带有OrderTypeHandler注释的类
        Map<String, Object> beans = applicationContext.getBeansWithAnnotation(OrderTypeHandler.class);
        if (!beans.isEmpty()) {
            for (Object serviceBean : beans.values()) {
                String orderType = serviceBean.getClass().getAnnotation(OrderTypeHandler.class).value();
                HANDLER_MAP.put(orderType, serviceBean);
            }
        }

        // 默认的处理器
        HANDLER_MAP.put(DEFAULT_HANDLER, new AbstractOrderTypeHandler() {
            @Override
            public int handler(OrderEntity order) {
                logger.info("订单[{}]NO[{}]进入 DefaultTypeHandler 处理器", order.getId(), order.getOrderNo());
                return 0;
            }
        });
    }

}