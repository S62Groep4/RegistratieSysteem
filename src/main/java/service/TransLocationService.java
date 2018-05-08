/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.JourneyDAO;
import dao.TransLocationDAO;
import domain.TransLocation;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.PersistenceException;
import util.StolenVehicleController;
import util.StolenVehicleWorker;

/**
 *
 * @author M
 */
@Stateless
public class TransLocationService {

    @Inject
    TransLocationDAO translocationDAO;

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
            Thread t = new Thread(new StolenVehicleWorker(translocation));
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
}
