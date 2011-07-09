package testRabbitMQ;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;

public class Send {

	  private final static String QUEUE_NAME = "hello";

	  public static void main(String[] argv) throws java.io.IOException {
		  	ConnectionFactory factory = new ConnectionFactory();
		    factory.setHost("guest");
		    Connection connection = factory.newConnection();
		    Channel channel = connection.createChannel();
		    
		    channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		    for(int i = 0; i < 1000; i++) {
			    String message = ""+System.currentTimeMillis();
			    channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
			    //System.out.println("Sent current time");
		    }
		    
		    channel.close();
		    connection.close();
	  }
	}