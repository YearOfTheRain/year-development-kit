package org.year.message.topic;

/**
 * 获取缓存key服务类
 * @author YearOfTheRain
 * @create 2024-05-15  10:55
 */
public interface ICacheKeyService {

    /**
     * 获取缓存key
     * @param uniqueId 唯一ID
     * @return 缓存key
     */
    default String getCacheKey(String uniqueId) {
        return getCacheKey("default", uniqueId);
    }

    /**
     * 获取缓存key
     * @param businessType 业务类型
     * @param uniqueId 唯一ID
     * @return 缓存key
     */
    String getCacheKey(String businessType, String uniqueId);
}
