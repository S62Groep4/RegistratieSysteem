package service;

import domain.Journey;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.PersistenceException;
import dao.JourneyDAO;
import domain.TransLocation;
import interfaces.TransLocationDto;
import java.util.ArrayList;
import java.util.Collections;

@Stateless
public class JourneyService {

    @Inject
    JourneyDAO journeyDAO;

    public static final List<Journey> activeJourneys = Collections.synchronizedList(new ArrayList<Journey>());
    
    private static final Logger LOGGER = Logger.getLogger(JourneyService.class.getName());

    public JourneyService() {

    }

    public List<Journey> getJourneys() throws PersistenceException {
        try {
            return journeyDAO.getJourneys();
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing getMovements method; {0}", pe.getMessage());
            return null;
        }
    }

    public List<Journey> getJourney(Long Id) throws PersistenceException {
        try {
            return journeyDAO.getJourney(Id);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing getMovement method; {0}", pe.getMessage());
            return null;
        }
    }

    public Boolean insertJourney(Journey journey) throws PersistenceException {
        try {
            return journeyDAO.insertJourney(journey);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing insertMovement method; {0}", pe.getMessage());
            return false;
        }
    }

    public Boolean updateJourney(Journey journey) throws PersistenceException {
        try{
            return journeyDAO.updateJourney(journey);
        }catch(PersistenceException pe){
            LOGGER.log(Level.FINE, "ERROR while performing updateMovement method; {0}", pe.getMessage());
            return false;
        }
    }

    public Boolean removeJourney(Journey journey) throws PersistenceException {
        try{
            return journeyDAO.removeJourney(journey);
        }catch(PersistenceException pe){
            LOGGER.log(Level.FINE, "ERROR while performing removeMovement method; {0}", pe.getMessage());
            return false;
        }
    }
    
    public static void addTransLocation(TransLocationDto transLocationDto) {
        Journey currentJourney = new Journey(new ArrayList<TransLocation>());
        
        for(Journey j : activeJourneys) {
            if(j.getTransLocations() != null && j.getTransLocations().size() > 0) {
                if(j.getTransLocations().get(0).getSerialNumber().equals(transLocationDto.getSerialNumber())) {
                    currentJourney = j;
                    break;
                }
            }
        }
        
        TransLocation transLocation = new TransLocation();
        transLocation.setCountryCode(transLocationDto.getCountryCode());
        transLocation.setDateTime(transLocationDto.getTimestamp());
        transLocation.setLat(Double.parseDouble(transLocationDto.getLat()));
        transLocation.setLon(Double.parseDouble(transLocationDto.getLon()));
        transLocation.setSerialNumber(transLocationDto.getSerialNumber());
        
        currentJourney.getTransLocations().add(transLocation);
        JourneyService.activeJourneys.add(currentJourney);
    }
}
