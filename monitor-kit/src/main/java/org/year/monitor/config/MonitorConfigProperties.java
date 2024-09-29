package org.year.monitor.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author YearOfTheRain
 * @create 2024-09-28  09:43
 */
@Getter
@Setter
@ConfigurationProperties(prefix = MonitorConfigProperties.PREFIX)
public class MonitorConfigProperties {

    public static final String PREFIX = "year.kit.monitor";

    private Boolean enabled = false;

    private String monitorAppId;

    private String storeType = "MYSQL";


}
