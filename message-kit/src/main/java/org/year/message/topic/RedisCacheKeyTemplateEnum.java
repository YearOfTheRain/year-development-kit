package org.year.message.topic;

/**
 * redis 缓存key 模板枚举
 * @author YearOfTheRain
 * @create 2024-05-15  10:59
 */
public enum RedisCacheKeyTemplateEnum implements ICacheKeyService {

    /** 枚举值 模板中第一占位符指代 businessType 第二个占位符指代 uniqueId */
    // 简单锁
    SIMPLE_LOCK("lock:simple:%s:%s"),
    // 临时缓存
    TEMP_CACHE("cache:temp:%s:%s"),
    // 主题
    TOPIC("topic:%s:%s"),
    ;

    /** 替换模板 */
    private final String template;

    RedisCacheKeyTemplateEnum(String template) {
        this.template = template;
    }


    @Override
    public String getCacheKey(String businessType, String uniqueId) {
        return String.format(template, businessType, uniqueId);
    }
}
