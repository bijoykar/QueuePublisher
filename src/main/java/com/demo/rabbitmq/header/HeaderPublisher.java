package com.demo.rabbitmq.header;

import com.rabbitmq.client.AMQP.*;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

public class HeaderPublisher {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        com.rabbitmq.client.Connection connection =factory.newConnection();
        com.rabbitmq.client.Channel channel =connection.createChannel();

        String message = "Header msg in queue";
        Map<String, Object> headerMap =     new HashMap<String, Object>();
        headerMap.put("item1","mob");
        headerMap.put("item2","television");

        BasicProperties br = new BasicProperties();
        br = br.builder().headers(headerMap).build();



        channel.basicPublish("Header-Exchange","", br,message.getBytes());

        channel.close();
        connection.close();
    }
}
