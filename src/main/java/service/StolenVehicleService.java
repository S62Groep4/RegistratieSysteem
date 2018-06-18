package service;

import com.google.gson.Gson;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;
import interfaces.TransLocationDto;

import javax.ejb.Stateless;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Stateless

public class StolenVehicleService {
    private final String QUEUE_NAME = "rekeningrijden.police.translocation";



    public void PublishLocation(TransLocationDto location) throws IOException, TimeoutException {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.24.99");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, true, false, false, null);

        Gson gson = new Gson();

        // 2. Java object to JSON, and assign to a String
        String message = gson.toJson(location);



        channel.basicPublish( "", QUEUE_NAME,
                MessageProperties.PERSISTENT_TEXT_PLAIN,
                message.getBytes());
        System.out.println(" [x] Sent '" + message + "'");

        channel.close();
        connection.close();
    }
}
