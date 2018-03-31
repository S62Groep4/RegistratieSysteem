/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import domain.Vehicle;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import service.VehicleService;

/**
 *
 * @author M
 */
@Stateless
@Path("vehicles")
@Produces(MediaType.APPLICATION_JSON)
public class VehicleResource {
    
    @Inject
    VehicleService vehicleService;
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void insertVehicle(Vehicle vehicle){
        vehicleService.insertVehicle(vehicle);
    }
    
    @GET
    public List<Vehicle> vehicles(){
        return vehicleService.getAllVehicles();
    }
    
    @GET
    @Path("vehicle/{licenseplate}")
    public List<Vehicle> vehicle(@PathParam("licenseplate") String licenseplate){
        return vehicleService.getVehicle(licenseplate);
    }
}
