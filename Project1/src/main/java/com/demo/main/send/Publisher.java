package com.demo.main.send;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * Publisher class - publish message to queue
 *  version 1.0 Kalpesh Laddha  
 */

public class Publisher {
	
	private final static String QUEUE_NAME="RABBIT_MQ";
	
	public static void main(String[] args) {
		ConnectionFactory factory  = new ConnectionFactory();
		factory.setHost("localhost");
		
		try(
			Connection connection = factory.newConnection();
			Channel channel = connection.createChannel();
				){
			/**
			 *The connection abstracts the socket connection, and takes care of protocol version negotiation and 
			 *authentication and so on for us. Here we connect to a RabbitMQ node on the local machine - hence the 
			 * "localhost". If we wanted to connect to a node on a different machine we'd simply specify its 
			 * hostname or IP address here.
			 * 
			 * Next we create a channel, which is where most of the API for getting things done resides. 
			 * 
			 * Using a try-with-resources statement because both Connection and Channel implement java.io.Closeable
			 * so that we dont required to closed the connection. 
			 * 
			 * Now we need to declare the queue where we can post the message. 
			 **/

			channel.queueDeclare(QUEUE_NAME, false, false, false, null);
			/**
			 * Open Declaration DeclareOk 
			 * com.rabbitmq.client.Channel.queueDeclare(String queue, boolean durable, boolean exclusive, boolean autoDelete, Map<String, Object> arguments) throws IOException
			 * Declare a queue
			 * Parameters:
			 * 	queue the name of the queue
			 * 	durable true if we are declaring a durable queue (the queue will survive a server restart)
			 * 	exclusive true if we are declaring an exclusive queue (restricted to this connection)
			 * 	autoDelete true if we are declaring an autodelete queue (server will delete it when no longer in use)
			 * 	arguments other properties (construction arguments) for the queue
			 * Returns:
			 * 	a declaration-confirm method to indicate the queue was successfully declared
			 **/
			String message="***** Welcome to Rabbit MQ Session Final*****";
			/**
			 *com.rabbitmq.client.Channel.basicPublish(String exchange, String routingKey, BasicProperties props, byte[] body) throws IOException
			 *	Publish a message.
			 *Parameters:
			 *	exchange the exchange to publish the message to
			 *	routingKey the routing key
			 *	props other properties for the message - routing headers etc
			 *	body the message body 
			 */
			channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
			System.out.println("[x] Message sent -> "+message);
		}
		catch(Exception e) {
			
		}
	}

}
