package com.demo.rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumer {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();


        DeliverCallback deliverCallback = new DeliverCallback() {
            public void handle(String consumerTag, Delivery delivery) throws IOException {
                String message = new String(delivery.getBody());
                System.out.println("Massage received  - " + message);
            }
        };

        channel.basicConsume("queue-1", true, deliverCallback, new CancelCallback() {
            public void handle(String consumerTag) throws IOException {
            }
        });
    }
}
