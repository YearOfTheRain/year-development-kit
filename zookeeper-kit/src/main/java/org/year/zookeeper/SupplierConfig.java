package org.year.zookeeper;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author YearOfTheRain
 * @create 2024-11-27  17:54
 */
public class SupplierConfig {

    @Bean
    @ConfigurationProperties(prefix = "sys.infos")
//    @ConditionalOnProperty(prefix = "sms", name = "config-type", havingValue = "yaml")
    protected Map<String, Map<String, Object>> infos() {
        return new LinkedHashMap<>();
    }

    @Bean
    @ConfigurationProperties(prefix = "sys")
    protected SysConfig sysConfig() {
        return new SysConfig();
    }


    @Bean
    public String test(SysConfig sysConfig) {
        System.out.println(sysConfig.getCorePoolSize());
        return "test";
    }
}
