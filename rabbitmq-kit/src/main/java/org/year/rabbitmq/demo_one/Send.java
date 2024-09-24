package org.year.rabbitmq.demo_one;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
/**
 * @author YearOfTheRain
 * @create 2024-09-24  08:43
 */
public class Send {

    private final static String QUEUE_NAME = "hello";
    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("server.year.cn");
        factory.setPort(5674);

        factory.setVirtualHost("/test");
        factory.setUsername("admin");
        factory.setPassword("admin123456");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
                channel.queueDeclare(QUEUE_NAME, false, false, false, null);
                String message = "Hello World12312312313123123232!";
                channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
                System.out.println(" [x] Sent '" + message + "'");
        }
    }
}
