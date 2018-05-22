package rest;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import service.VehicleService;

@Stateless
@Path("/stolen")
@Consumes(MediaType.APPLICATION_JSON)
public class StolenVehicleResource {
    
    @Inject
    VehicleService vehicleService;
    
    @Path("/{carTrackerSerial}")
    public Response markAsMonitored(@PathParam("carTrackerSerial") String carTrackerSerial){
        vehicleService.markVehicleMonitored(carTrackerSerial);
        return Response.ok().build();
    }
}
