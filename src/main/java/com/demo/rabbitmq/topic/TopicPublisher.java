package com.demo.rabbitmq.topic;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class TopicPublisher {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection =factory.newConnection();
        Channel channel =connection.createChannel();

        String message = "topic msg in queue";

        channel.basicPublish("Topic-Exchange","tv.mobile.ac", null,message.getBytes());

        channel.close();
        connection.close();
    }
}
