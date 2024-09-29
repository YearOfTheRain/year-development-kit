/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 * <p>
 * https://www.renren.io
 * <p>
 * 版权所有，侵权必究！
 */

package org.year.monitor.util;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * http上下文
 * @author Administrator
 */
public class HttpContextUtil {

    private HttpContextUtil(){}

    public static HttpServletRequest getHttpServletRequest() {
        RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
        if (attributes == null) {
            return null;
        }
        return ((ServletRequestAttributes) attributes).getRequest();
    }

    public static String getDomain() {
        HttpServletRequest request = getHttpServletRequest();
        if (request == null){
            return "";
        }
        StringBuffer url = request.getRequestURL();
        return url.delete(url.length() - request.getRequestURI().length(), url.length()).toString();
    }

    public static String getServerName() {
        HttpServletRequest request = getHttpServletRequest();
        if (request == null){
            return "";
        }
        return request.getServerName();
    }

    public static String getOrigin() {
        HttpServletRequest request = getHttpServletRequest();
        if (request == null){
            return "";
        }
        return request.getHeader("Origin");
    }
}
