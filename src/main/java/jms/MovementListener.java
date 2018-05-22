package jms;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import interfaces.TransLocationDto;
import java.io.IOException;
import java.util.concurrent.TimeoutException;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import service.JourneyService;

@Startup
@Singleton
public class MovementListener {

    private Gateway simulationToRegistration;

    @PostConstruct
    public void init() {
        System.out.println("Movement Listener init");
        try {
            simulationToRegistration = new Gateway();
            simulationToRegistration.channel.queueDeclare("SimulationToGermany", false, false, false, null);

            Consumer consumer = new DefaultConsumer(simulationToRegistration.channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    System.out.println("Delivery: " + new String(body));
                    TransLocationDto transLocationDto = null;
                    try {
                        transLocationDto = new Gson().fromJson(new String(body), TransLocationDto.class);
                    } catch (JsonSyntaxException e) {
                        System.out.println("Gson error: " + e.getMessage());
                    }
                    System.out.println("Objectmapper success");
                    JourneyService.addTransLocation(transLocationDto);
                }
            };
            simulationToRegistration.channel.basicConsume("SimulationToGermany", true, consumer);
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (TimeoutException ex) {
            ex.printStackTrace();
        }
    }
}
