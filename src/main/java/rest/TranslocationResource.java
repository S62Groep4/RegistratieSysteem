/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import domain.TransLocation;
import domain.Vehicle;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import service.TransLocationService;

/**
 *
 * @author M
 */
@Stateless
@Path("translocations")
@Produces(MediaType.APPLICATION_JSON)
public class TranslocationResource {

    @Inject
    TransLocationService translocationService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("add")
    public Boolean insertTransLocation(TransLocation translocation) {
        return translocationService.insertTransLocation(translocation);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("update")
    public Boolean updateTransLocation(TransLocation translocation) {
        return translocationService.updateTransLocation(translocation);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("remove")
    public Boolean removeTransLocation(TransLocation translocation) {
        return translocationService.removeTransLocation(translocation);
    }

    @GET
    public List<TransLocation> transLocations() {
        return translocationService.getTransLocations();
    }

    @GET
    @Path("translocation/{datetime}")
    public List<TransLocation> transLocation(@PathParam("datetime") String datetime) {
        return translocationService.getTransLocation(datetime);
    }
}
