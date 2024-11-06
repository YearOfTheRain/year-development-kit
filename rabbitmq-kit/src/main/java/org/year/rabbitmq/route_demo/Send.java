package org.year.rabbitmq.route_demo;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

/**
 * @author YearOfTheRain
 * @create 2024-09-24  08:43
 */
public class Send {

    private final static String EXCHANGE_NAME = "route_exchange";
    private final static String QUEUE_NAME = "route_demo";

    private final static String TOPIC_EXCHANGE_NAME = "topic_exchange";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("server.year.cn");
        factory.setPort(5674);

        factory.setVirtualHost("/test");
        factory.setUsername("admin");
        factory.setPassword("admin123456");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
//                channel.exchangeDeclare(EXCHANGE_NAME, "direct", true, false, null);
                channel.exchangeDeclare(TOPIC_EXCHANGE_NAME, "topic", true, false, null);
                String result = "base";
                String message = result + " 8888888!";
                channel.basicPublish(TOPIC_EXCHANGE_NAME, result, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes());
                System.out.println(" [x] Sent '" + message + "'");
        }
    }
}
