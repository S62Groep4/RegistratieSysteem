/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.VehicleDAO;
import domain.Vehicle;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.PersistenceException;

/**
 *
 * @author M
 */
@Stateless
public class VehicleService {

    @Inject
    VehicleDAO vehicleDAO;

    private static final Logger LOGGER = Logger.getLogger(VehicleService.class.getName());

    public VehicleService() {

    }

    public boolean insertVehicle(Vehicle vehicle) {
        try {
            vehicleDAO.insertVehicle(vehicle);
            return true;
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing insertVehicle method; {0}", pe.getMessage());
            return false;
        }
    }

    public boolean updateVehicle(Vehicle vehicle) {
        try {
            vehicleDAO.updateVehicle(vehicle);
            return true;
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing updateVehicle method; {0}", pe.getMessage());
            return false;
        }
    }

    public boolean removeVehicle(Vehicle vehicle) {
        try {
            vehicleDAO.removeVehicle(vehicle);
            return true;
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing removeVehicle method; {0}", pe.getMessage());
            return false;
        }
    }

    public List<Vehicle> getVehicle(String hashedLicenseplate) {
        try {
            return vehicleDAO.getVehicle(hashedLicenseplate);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing getVehicle method; {0}", pe.getMessage());
            return null;
        }
    }

    public List<Vehicle> getAllVehicles() {
        try {
            return vehicleDAO.getAllVehicles();
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing getAllVehicles method; {0}", pe.getMessage());
            return null;
        }
    }
    
    public void markVehicleMonitored(String carTrackerSerial){
        try{
            Vehicle managedVehicle = vehicleDAO.getVehicleByCarTrackerSerial(carTrackerSerial).get(0);
            managedVehicle.setIsMonitored(true);
            this.updateVehicle(managedVehicle);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing markVehicleMonitored method; {0}", pe.getMessage());
        }
    }
}
