package org.year.monitor.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.year.monitor.util.IpUtil;

import java.lang.reflect.Method;

/**
 * 监控拦截器
 * @author YearOfTheRain
 * @create 2024-09-28  08:38
 */
@Slf4j
public class MonitorInterceptor implements HandlerInterceptor, Ordered {

    /**
     * 拦截解析指定访问
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("preHandle");
        if (handler instanceof HandlerMethod handlerMethod) {
            String ip = IpUtil.getIp();
            Method method = handlerMethod.getMethod();
            String name = method.getName();
            log.info("ip:{} . name: {}", ip, name);
        }
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("postHandle");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public int getOrder() {
        return LOWEST_PRECEDENCE - 10;
    }
}
