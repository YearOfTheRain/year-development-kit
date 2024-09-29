/**
 * Copyright (c) 2018 人人开源 All rights reserved.
 * <p>
 * https://www.renren.io
 * <p>
 * 版权所有，侵权必究！
 */

package org.year.monitor.aop;

import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.year.monitor.module.domain.CustomerMonitorInfo;
import org.year.monitor.util.HttpContextUtil;

import java.lang.reflect.Method;

/**
 * 监控切面逻辑
 * @author YearOfTheRain
 * @create 2024-09-29  08:56
 */
@Aspect
@Component
@Order(Ordered.LOWEST_PRECEDENCE - 300)
public class MonitorTargetAspect {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Pointcut("@annotation(org.year.monitor.aop.MonitorTarget) " +
            "|| @within(org.year.monitor.aop.MonitorTarget)")
    public void pointCut() {
        // 切点表达式
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        HttpServletRequest httpServletRequest = HttpContextUtil.getHttpServletRequest();
        if (httpServletRequest == null) {
            logger.warn("HttpServletRequest为null，可能不是web端调用，监控逻辑终止");
            return point.proceed();
        }

        MethodSignature signature = (MethodSignature) point.getSignature();
//        Class<?> targetClass = point.getTarget().getClass();
        Method method = signature.getMethod();

        MonitorTarget methodDataSource = method.getAnnotation(MonitorTarget.class);

        // 构建请求参数
        CustomerMonitorInfo customerMonitorInfo = new CustomerMonitorInfo();
        customerMonitorInfo.setWebAccessInfo(httpServletRequest);



        return point.proceed();
    }
}