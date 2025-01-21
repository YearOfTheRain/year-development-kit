package org.year.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * @author YearOfTheRain
 * @create 2024-12-19  18:20
 */
@RequiredArgsConstructor
@AutoConfiguration
@EnableConfigurationProperties(WxWebConfig.class)
@ConditionalOnProperty(prefix = "wx.pc", name = {"appId", "secret"})
@Slf4j
public class WxPcConfig {

    private final WxWebConfig wxWebConfig;

    @Bean
    public String appIDDDDD() {
        log.info("appIDDDDD:{}", wxWebConfig.getAppId());
        return wxWebConfig.getAppId();
    }
}
