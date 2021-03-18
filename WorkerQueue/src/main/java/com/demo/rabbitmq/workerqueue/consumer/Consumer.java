package com.demo.rabbitmq.workerqueue.consumer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

public class Consumer {

	private final static String QUEUE_NAME="RABBIT_MQ";
	public static void main(String[] args) throws Exception {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		System.out.println(" [y] Waiting for messages. To exit press CTRL+C");
		
		DeliverCallback deliverCallback = (consumerTag, delivery) -> {
			String message = new String(delivery.getBody(), "UTF-8");
			System.out.println(" [y] Received '" + message + "'");
			try {
				doCall(message);
			} catch(Exception e) {
				
			} finally {
				System.out.println("[y] End ");
			}
		};
		boolean autoAcknowledge = true;
		channel.basicConsume(QUEUE_NAME, autoAcknowledge, deliverCallback, consumerTag -> { });

	}
	private static void doCall(String message) throws InterruptedException {
		
		for(char ch : message.toCharArray()) {
			if(ch == '.')
				Thread.sleep(5000);
		}
		
	}

}
