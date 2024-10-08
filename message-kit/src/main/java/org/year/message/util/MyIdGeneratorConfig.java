package org.year.message.util;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.IdUtil;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;

/**
 * @author YearOfTheRain
 * @create 2024-10-08  08:52
 */
@Slf4j
public class MyIdGeneratorConfig implements IdentifierGenerator {

    /**
     * 终端ID
     */
    public static long WORKER_ID = 1;

    /**
     * 数据中心id
     */
    public static long DATACENTER_ID = 1;

    private Snowflake snowflake = IdUtil.createSnowflake(WORKER_ID, DATACENTER_ID);

    @PostConstruct
    public void init() {
        WORKER_ID = NetUtil.ipv4ToLong(NetUtil.getLocalhostStr()) % 30;
        log.info("当前机器的workId:{}", WORKER_ID);
    }

    public synchronized long snowflakeId() {
        return snowflake.nextId();
    }

    public synchronized long snowflakeId(long workerId, long datacenterId) {
        Snowflake snowflake = IdUtil.createSnowflake(workerId, datacenterId);
        return snowflake.nextId();
    }


    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object)
            throws HibernateException {
        return snowflakeId(WORKER_ID, DATACENTER_ID);
    }
}
