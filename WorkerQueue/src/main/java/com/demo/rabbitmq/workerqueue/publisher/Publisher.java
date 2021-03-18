package com.demo.rabbitmq.workerqueue.publisher;

import java.time.LocalTime;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Publisher {

	private final static String QUEUE_NAME="RABBIT_MQ";

	public static void main(String[] args) {
		ConnectionFactory factory  = new ConnectionFactory();
		factory.setHost("localhost");
		LocalTime time = LocalTime.now();
		try(
				Connection connection = factory.newConnection();
				Channel channel = connection.createChannel();
				){

			channel.queueDeclare(QUEUE_NAME, false, false, false, null);
			String message= time+"First..................";
			String message1= time+"Second";
			String message2= time+"Third";
			String message3= time+"Four......";
			String message4= time+"Five";
			String message5= time+"Six";
			
			channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
			channel.basicPublish("", QUEUE_NAME, null, message1.getBytes());
			channel.basicPublish("", QUEUE_NAME, null, message2.getBytes());
			channel.basicPublish("", QUEUE_NAME, null, message3.getBytes());
			channel.basicPublish("", QUEUE_NAME, null, message4.getBytes());
			channel.basicPublish("", QUEUE_NAME, null, message5.getBytes());
			System.out.println("[x] Message sent -> "+time+"'");
		}
		catch(Exception e) {

		}
	}
}
