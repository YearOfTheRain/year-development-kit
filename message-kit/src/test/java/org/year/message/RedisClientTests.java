package org.year.message;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.year.message.topic.RedisTopicEnum;
import org.year.message.util.MessageListenerUtil;

/**
 * @author YearOfTheRain
 * @create 2024-10-07  10:51
 */
@SpringBootTest
public class RedisClientTests {

    private static final Log LOG = LogFactory.getLog(RedisClientTests.class);

    @Test
    void testConnection() {
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
        configuration.setHostName("server.year.cn");
        configuration.setPort(6379);
        configuration.setDatabase(0);
        configuration.setPassword("123456");
        LettuceConnectionFactory connectionFactory = new LettuceConnectionFactory(configuration);
        connectionFactory.afterPropertiesSet();

        RedisTemplate<String, String> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        template.setDefaultSerializer(StringRedisSerializer.UTF_8);
        template.afterPropertiesSet();

        template.opsForValue().set("foo", "bar");

        LOG.info("Value at foo:" + template.opsForValue().get("foo"));

        connectionFactory.destroy();
    }


    @Test
    void sendTopicMessage() {
        String message = "Hello World!";

        MessageListenerUtil.send(RedisTopicEnum.TEST_MESSAGE.getRedisTopic(), message);
    }
}
