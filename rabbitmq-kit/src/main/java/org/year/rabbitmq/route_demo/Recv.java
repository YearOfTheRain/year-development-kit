package org.year.rabbitmq.route_demo;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

/**
 * @author YearOfTheRain
 * @create 2024-09-24  09:18
 */
public class Recv {

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
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.basicQos(1);
//        channel.exchangeDeclare(EXCHANGE_NAME, "direct",true, false,false,null);
        channel.exchangeDeclare(TOPIC_EXCHANGE_NAME, "topic",true, false,false,null);
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        channel.queueBind(QUEUE_NAME, TOPIC_EXCHANGE_NAME, "*.base");
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println(" [x] Received '" + message + "'");
            channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
        };
        channel.basicConsume(QUEUE_NAME, false, deliverCallback, consumerTag -> { });

    }
}
