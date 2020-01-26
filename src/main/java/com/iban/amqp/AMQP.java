package com.iban.amqp;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;

import java.io.IOException;
import java.util.concurrent.TimeoutException;


public class AMQP {
	
	//@Value("${spring.rabbitmq.host}")
	private static String host = "rabbit";
	
	//@Value("${spring.rabbitmq.queue}")
	private static String queue = "iban/email";
	
	ConnectionFactory factory = new ConnectionFactory();
	Connection connection;
	Channel channel;
	
	public AMQP() {
	}

	public ConnectionFactory getFactory() {
		return factory;
	}

	public void setFactory(ConnectionFactory factory) {
		this.factory = factory;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public Channel getChannel() {
		return channel;
	}
	
	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	public static String getHost() {
		return host;
	}

	public static String getQueue() {
		return queue;
	}

	public boolean publishMessage(String msg)  {
	    
	    factory.setHost(host);
	    try {
			connection = factory.newConnection();
			channel = connection.createChannel();
			channel.queueDeclare(queue, false, false, false, null);
			channel.basicPublish("", queue, null, msg.getBytes());
			System.out.println("Message was published to the queue...");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error occurred, " + e);
			return false;
		} catch (TimeoutException e) {
			e.printStackTrace();
			System.out.println("Error occurred, " + e);
			return false;
		}
	    return true;
	}
}
