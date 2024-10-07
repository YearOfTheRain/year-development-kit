package org.year.message.listener.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.Topic;
import org.springframework.stereotype.Component;
import org.year.message.listener.MessageListenerBindTopic;
import org.year.message.topic.RedisTopicEnum;
import org.year.message.util.MessageListenerUtil;

/**
 * @author YearOfTheRain
 * @create 2024-10-07  16:31
 */
@Component
@Slf4j
public class TestMessageListener implements MessageListenerBindTopic {

    @Override
    public Topic getTopic() {
        return ChannelTopic.of(RedisTopicEnum.TEST_MESSAGE.getRedisTopic());
    }

    @Override
    public void onMessage(Message message, byte[] pattern) {
        // 获取消息内容
        String messageContextStr = MessageListenerUtil.deserialize(message.getBody());

        log.info("messageContextStr: {}", messageContextStr);
        // CLASS messageContext = MessageListenerUtil.deserialize(message.getBody(), CLASS);

    }
}
