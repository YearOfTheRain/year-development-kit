package org.year.monitor.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.year.monitor.interceptor.MonitorInterceptor;

/**
 * @author YearOfTheRain
 * @create 2024-09-28  09:55
 */
@Component
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MonitorInterceptor()).addPathPatterns("/api/**");
    }
}
