package org.year.message.topic;

import org.year.message.util.SpringUtils;

/**
 * redis的订阅渠道
 * @author YearOfTheRain
 * @create 2024-03-18  18:59
 */
public enum RedisTopicEnum {

    TEST_MESSAGE("test_message", SpringUtils.getActiveProfile())

    ;
    /** 主题 */
    private String topic;
    /** 描述 */
    private String describe;

    RedisTopicEnum(String topic, String describe) {
        this.topic = topic;
        this.describe = describe;
    }

    public String getRedisTopic() {
        return RedisCacheKeyTemplateEnum.TOPIC.getCacheKey(topic, SpringUtils.getActiveProfile());
    }

}
