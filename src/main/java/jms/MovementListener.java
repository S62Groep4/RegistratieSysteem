package jms;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import java.io.IOException;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

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
                    System.out.println("Delivery: " + consumerTag);
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
