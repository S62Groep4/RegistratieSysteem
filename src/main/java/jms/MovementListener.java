package jms;

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
import javax.inject.Inject;
import service.JourneyService;

@Singleton
@Startup
public class MovementListener {

    private Gateway simulationToRegistration;

    @Inject
    private JourneyService journeyService;

    @PostConstruct
    public void init() {
        System.out.println("Movement Listener init");
        try {
            simulationToRegistration = new Gateway();
            simulationToRegistration.channel.queueDeclare("rekeningrijden.simulation.de", true, false, false, null);

            Consumer consumer = new DefaultConsumer(simulationToRegistration.channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    System.out.println("Delivery: " + new String(body));
                    TransLocationDto transLocationDto = new Gson().fromJson(new String(body), TransLocationDto.class);
                    System.out.println("Gson success");
                    journeyService.addTransLocation(transLocationDto);
                    System.out.println("journeyService success");
                }
            };
            simulationToRegistration.channel.basicConsume("rekeningrijden.simulation.de", true, consumer);
        } catch (IOException | TimeoutException ex) {
            ex.printStackTrace();
        }
    }
}
