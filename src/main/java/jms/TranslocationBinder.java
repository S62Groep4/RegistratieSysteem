package jms;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import domain.TransLocation;
import net.reini.rabbitmq.cdi.*;

import javax.enterprise.context.Dependent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

//@Dependent
public class TranslocationBinder extends EventBinder {
    private final String queName = "rekeningrijden.police.translocation";
    private static final Logger LOGGER = Logger.getLogger(TransLocation.class.getName());


    @Override
    protected void bindEvents() {


        bind(TransLocation.class)
                .toQueue(this.queName)
                .withDecoder(new Decoder<TransLocation>() {
                    @Override
                    public TransLocation decode(byte[] bytes) throws DecodeException {
                        String data = new String(bytes);
                        ObjectMapper mapper = new ObjectMapper();

                        Gson gson = new Gson();
                        TransLocation locationObject =  gson.fromJson(data, TransLocation.class);
                        return locationObject;

                    }

                    @Override
                    public boolean willDecode(String s) {
                        return s.equals("text/plain");
                    }
                }).autoAck();
    }
}


