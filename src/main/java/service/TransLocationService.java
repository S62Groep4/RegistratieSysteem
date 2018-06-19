/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dao.TransLocationDAO;
import dao.VehicleDAO;
import domain.TransLocation;
import domain.Vehicle;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.PersistenceException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

/**
 *
 * @author M
 */
@Stateless
public class TransLocationService {

    @Inject
    TransLocationDAO translocationDAO;
    
    @Inject
    VehicleDAO vehicleDAO;

    private static final Logger LOGGER = Logger.getLogger(JourneyService.class.getName());

    public TransLocationService() {
    }

    public List<TransLocation> getTransLocations() throws PersistenceException {
        try {
            return translocationDAO.getTransLocations();
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing getTranslocations method; {0}", pe.getMessage());
            return null;
        }
    }

    public List<TransLocation> getTransLocation(String dateTime) throws PersistenceException {
        try {
            return translocationDAO.getTransLocation(dateTime);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing getTranslocation method; {0}", pe.getMessage());
            return null;
        }
    }

    public Boolean insertTransLocation(TransLocation translocation) throws PersistenceException {
        try {
            //Check if the translocation comes from a stolen vehicle
            return translocationDAO.insertTransLocation(translocation);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing insertTranslocation method; {0}", pe.getMessage());
            return false;
        }
    }

    public Boolean updateTransLocation(TransLocation translocation) throws PersistenceException {
        try {
            return translocationDAO.updateTransLocation(translocation);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing updateTranslocation method; {0}", pe.getMessage());
            return false;
        }
    }

    public Boolean removeTransLocation(TransLocation translocation) throws PersistenceException {
        try {
            return translocationDAO.removeTransLocation(translocation);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing removeTranslocation method; {0}", pe.getMessage());
            return false;
        }
    }
    
    public void isMonitored(TransLocation transLocation){
        try{
            Vehicle vehicle = vehicleDAO.getVehicleByCarTrackerSerial(transLocation.getSerialNumber()).get(0);
            if(vehicle.isMonitored()){
                postTransLocation(transLocation);
            }
        }catch(PersistenceException pe){
            LOGGER.log(Level.FINE, "ERROR while performing isStolen method; {0}", pe.getMessage());
        }
    }
    
    public void postTransLocation(TransLocation transLocation){
        try {
            //TODO; add politiesysteem endpoint url
            String url = "";
            
            HttpClient client = HttpClientBuilder.create().build();
            HttpPost post = new HttpPost(url);
            
            Gson gson = new GsonBuilder().create();
            String json = gson.toJson(transLocation);
            StringEntity entity = new StringEntity(json);
            post.setEntity(entity);
            
            post.setHeader("Accept", "application/json");
            post.setHeader("Content-type", "application/json");
            
            //TODO; show results of response
            HttpResponse response = client.execute(post);
            
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(TransLocationService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TransLocationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
