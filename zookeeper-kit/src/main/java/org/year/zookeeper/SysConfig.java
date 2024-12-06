package org.year.zookeeper;

import lombok.Data;

/**
 * @author YearOfTheRain
 * @create 2024-11-28  17:09
 */
@Data
public class SysConfig {

    private Integer coreSize;
    private Integer corePoolSize;
    private Integer maxPoolSize;
    private Integer keepalive;
}
