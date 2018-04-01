/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import domain.Journey;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.PersistenceException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import service.JourneyService;

/**
 *
 * @author M
 */
@Stateless
@Path("journeys")
@Produces(MediaType.APPLICATION_JSON)
public class JourneyResource {

    @Inject
    JourneyService journeyService;

    @GET
    public List<Journey> Journeys() throws PersistenceException {
        return journeyService.getJourneys();
    }

    @GET
    @Path("journey/{Id}")
    public List<Journey> Journey(@PathParam("Id") Long Id) throws PersistenceException {
        return journeyService.getJourney(Id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("add")
    public Boolean insertJourney(Journey journey) throws PersistenceException {
        return journeyService.insertJourney(journey);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("update")
    public Boolean updateJourney(Journey journey) throws PersistenceException {
        return journeyService.updateJourney(journey);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("remove")
    public Boolean removeJourney(Journey journey) throws PersistenceException {
        return journeyService.removeJourney(journey);
    }
}
