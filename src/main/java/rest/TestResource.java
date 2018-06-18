/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;
import dto.TransLocationDTO;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.concurrent.TimeoutException;
import java.util.logging.Logger;

/**
 *
 * @author Sjoerd
 */
@Stateless
@Path("test")
@Produces(MediaType.APPLICATION_JSON)
public class TestResource {

    private static final Logger LOGGER = Logger.getLogger(TransLocationDTO.class.getName());


    @Inject
    private Event<TransLocationDTO> eventOnes;


    @GET
    public String test() throws IOException, TimeoutException {
        TransLocationDTO eventOne = new TransLocationDTO();
        eventOne.setCountryCode("DE");
    //    eventOnes.fire(eventOne);
   //     testMethode(eventOne);
        send(eventOne);
        return "test";
    }



    private final String QUEUE_NAME = "rekeningrijden.police.translocation";



    private void send(TransLocationDTO location) throws IOException, TimeoutException {

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
