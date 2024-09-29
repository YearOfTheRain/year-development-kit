package org.year.monitor.module.domain;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Data;
import org.year.monitor.util.IpUtil;

import java.time.LocalDateTime;

/**
 * 监控信息
 * @author YearOfTheRain
 * @create 2024-09-29  09:23
 */
@Data
public class CustomerMonitorInfo {

    /** 访问时间 */
    private LocalDateTime accessTime;
    /** 访问地址 */
    private String accessUrl;
    /** 访问IP */
    private String accessIp;
    /** 访问方法 */
    private String accessMethod;
    /** 访问用户代理 */
    private String accessUserAgent;
    /** 访问引用 */
    private String accessReferer;
    /** 访问服务名称 */
    private String accessServerName;
    /** 访问域名 */
    private String accessDomain;
    /** 访问设备 */
    private String accessDevice;
    /** 访问浏览器 */
    private String accessBrowser;
    /** 访问区域 */
    private String accessRegion;
    /** 访问操作系统 */
    private String accessOperationSystem;


    public void setWebAccessInfo(HttpServletRequest request) {
        this.accessUrl = request.getRequestURI();
        this.accessIp = IpUtil.getIp();
        this.accessMethod = request.getMethod();
        this.accessUserAgent = request.getHeader("User-Agent");
        this.accessReferer = request.getHeader("Referer");
        this.accessServerName = request.getServerName();
        this.accessDomain = request.getHeader("Host");
        this.accessTime = LocalDateTime.now();
        this.accessDomain = request.getHeader("Domain");
    }


}
