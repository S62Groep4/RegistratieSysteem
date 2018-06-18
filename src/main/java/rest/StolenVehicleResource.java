package rest;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.databind.ObjectMapper;
import service.JourneyService;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

@Stateless
@Path("/stolen")
@Consumes(MediaType.APPLICATION_JSON)
public class StolenVehicleResource {

    @Inject
    private JourneyService journeyService;

    @Path("/{carTrackerSerial}")
    @POST
    public Response markAsMonitored(@PathParam("carTrackerSerial") String carTrackerSerial){
      //  vehicleService.markVehicleMonitored(carTrackerSerial);
        journeyService.AddStolenVehicle(carTrackerSerial);
        return Response.ok().build();
    }

    @Path("/{carTrackerSerial}")
    @DELETE
    public Response deleteAsMonitored(@PathParam("carTrackerSerial") String carTrackerSerial){
      //  vehicleService.markVehicleMonitored(carTrackerSerial);
        journeyService.removeAsStolenVehicle(carTrackerSerial);
        return Response.ok().build();
    }

    private List<String> updateStolenVehicles() throws IOException {
        String uri =
                "http://localhost:8080/PolitieSysteem";
        URL url = new URL(uri);
        HttpURLConnection connection =
                (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/xml");

        ObjectMapper mapper = new ObjectMapper();
        List<String> jsonMap = mapper.readValue(connection.getInputStream(), List.class);

          connection.disconnect();

        return jsonMap;

    }
}
