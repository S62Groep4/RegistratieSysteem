/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import domain.Journey;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.PersistenceException;
import dao.JourneyDAO;

/**
 *
 * @author M
 */
@Stateless
public class JourneyService {

    @Inject
    JourneyDAO journeyDAO;

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
}
