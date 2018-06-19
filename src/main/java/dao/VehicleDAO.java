/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Vehicle;
import java.util.List;
import javax.persistence.PersistenceException;

/**
 *
 * @author M
 */
public interface VehicleDAO {

    List<Vehicle> getVehicle(String hashedLicenceplate) throws PersistenceException;

    List<Vehicle> getAllVehicles() throws PersistenceException;
    
    List<Vehicle> getVehicleByCarTrackerSerial(String carTrackerSerial) throws PersistenceException;

    boolean updateVehicle(Vehicle vehicle) throws PersistenceException;

    boolean removeVehicle(Vehicle vehicle) throws PersistenceException;

    boolean insertVehicle(Vehicle vehicle) throws PersistenceException;
    
}
