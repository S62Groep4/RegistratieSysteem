package rest;

import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@Path("/stolen")
@Consumes(MediaType.APPLICATION_JSON)
public class StolenVehicleResource {
    
    public Response markAsStolen(String carTrackerSerial){
        
        return Response.ok().build();
    }
}
