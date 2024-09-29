package org.year.monitor.util;


import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;


/**
 * 获取用户真实IP
 * @author Administrator
 */
public class IpUtil {

    private static final Logger logger = LoggerFactory.getLogger(IpUtil.class);

    private IpUtil(){}
    /** ip 检验头 */
    private static final String[] HEADERS = {"Proxy-Client-IP","WL-Proxy-Client-IP","HTTP_CLIENT_IP",
            "HTTP_X_FORWARDED_FOR","X-Real-IP"};
    private static final String UNKNOWN = "unknown";

    /**
     * 获取客户端IP地址
     *
     * @return ip
     */
    public static String getIp() {
        HttpServletRequest request = HttpContextUtil.getHttpServletRequest();
        // 无请求上下文则直接空IP
        if (Objects.isNull(request)) {
            return "";
        }
        // 获取客户端ip，客户端可能经过代理，也可能没经过代理
        String ip = request.getHeader("x-forwarded-for");
        logger.debug("x-forwarded-for ip: {}", ip);
        if (realIp(ip) && ip.contains(",")) {
            // 多次反向代理后会有多个ip值，第一个ip才是真实ip
            ip = ip.split(",")[0];
        }
        // 通过可能的IP参数头获取真实IP
        for (String header : HEADERS){
            ip = IpUtil.getRealIp(ip, header, request);
            // 真实ip则退出循环
            if (realIp(ip)) {
                break;
            }
        }
        // 只能取一个代理IP了
        if (notRealIp(ip)) {
            ip = request.getRemoteAddr();
            logger.debug("getRemoteAddr ip: {}", ip);
        }

        logger.debug("----获取客户端的ip: {}", ip);
        //如果没取到ip，返回""
        return notRealIp(ip) ? "" : ip;
    }

    /**
     * 获取真实IP
     * @param ip ip
     * @param header 请求头
     * @param request 请求对象
     * @return ip
     */
    private static String getRealIp(String ip, String header, HttpServletRequest request) {
        if (notRealIp(ip)) {
            ip = request.getHeader(header);
            String message = header + "ip: {}";
            logger.debug(message, ip);
        }
        return ip;
    }

    /**
     * 非真实IP
     * @param ip ip
     * @return true / false
     */
    private static boolean notRealIp(String ip) {
        return ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip);
    }

    /**
     * 真实IP
     * @param ip ip
     * @return true / false
     */
    private static boolean realIp(String ip) {
        return !notRealIp(ip);
    }

}
