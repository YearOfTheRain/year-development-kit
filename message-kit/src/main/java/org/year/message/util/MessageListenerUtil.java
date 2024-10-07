package org.year.message.util;

import com.alibaba.fastjson.JSONObject;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * 消息监听通用工具类
 * @author YearOfTheRain
 * @create 2024-10-07  15:12
 */
public class MessageListenerUtil {

    private MessageListenerUtil() {
    }

    private static final RedisTemplate redisTemplate = SpringUtils.getBean(RedisTemplate.class);

    /**
     * 发送监听消息
     * @param channel 发送通道
     * @param messageContextStr 消息内容（字符串）
     */
    public static void send(String channel, String messageContextStr) {
        redisTemplate.convertAndSend(channel, messageContextStr);
    }

    /**
     * 反序列化消息内容
     * @param messageBody
     * @return
     */
    public static String deserialize(byte[] messageBody){
        return (String) redisTemplate.getValueSerializer().deserialize(messageBody);
    }

    /**
     * 反序列化消息内容
     * @param messageBody
     * @param cls
     * @return
     * @param <T>
     */
    public static <T> T deserialize(byte[] messageBody, Class<T> cls) {
        return JSONObject.parseObject(deserialize(messageBody), cls);
    }

}
