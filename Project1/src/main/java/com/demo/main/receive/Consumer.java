package com.demo.main.receive;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

/**
 * Consumer class - Consume message from queue
 *  version 1.0 Kalpesh Laddha  
 */

public class Consumer {

	private final static String QUEUE_NAME="RABBIT_MQ";
	public static void main(String[] args) throws Exception {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		System.out.println(" [y] Waiting for messages. To exit press CTRL+C");
		
		/**
		* com.rabbitmq.client.DeliverCallback
		* @FunctionalInterface
		* 	Callback interface to be notified when a message is delivered. Prefer it 
		* over Consumer for a lambda-oriented syntax, if you don't need to implement all the * application callbacks.
		*/

		DeliverCallback deliverCallback = (consumerTag, delivery) -> {
			String message = new String(delivery.getBody(), "UTF-8");
			System.out.println(" [y] Received '" + message + "'");
		};
		channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> { });

	}

}
