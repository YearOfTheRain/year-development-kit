package org.year.message.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.year.message.listener.MessageListenerBindTopic;

import java.util.List;

/**
 * 初始化监听
 * @author YearOfTheRain
 * @create 2024-03-18  19:04
 */
@Configuration
public class RedisTopicConfig {

    /**
     * 初始化一个Redis消息监听容器
     * @param connectionFactory
     * @return
     */
    @Bean
    public RedisMessageListenerContainer redisMessageListenerContainer(RedisConnectionFactory connectionFactory, List<MessageListenerBindTopic> messageListenerList) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        // 添加其他配置，如线程池大小等
        messageListenerList.forEach(messageListener -> {
            if (messageListener != null) {
                container.addMessageListener(messageListener, messageListener.getTopic());
            }
        });
        return container;
    }
}
