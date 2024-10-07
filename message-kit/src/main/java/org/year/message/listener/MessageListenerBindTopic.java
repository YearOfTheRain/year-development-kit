package org.year.message.listener;

import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.listener.Topic;

/**
 * 消息监听器绑定消费通道
 * @author YearOfTheRain
 * @create 2024-04-24  15:03
 */
public interface MessageListenerBindTopic extends MessageListener {

    /**
     * 获取主题
     * @return 主题
     */
    Topic getTopic();
}
