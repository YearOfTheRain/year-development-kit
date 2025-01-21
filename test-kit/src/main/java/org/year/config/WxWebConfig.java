package org.year.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * wx网页应用
 *
 * @author feishu
 */
@Data
@ConfigurationProperties(prefix = "wx.pc")
public class WxWebConfig {
    /**
     * 设置网页应用的appid
     */
    private String appId;
    /**
     * 设置网页应用的app secret
     */
    private String secret;
}
