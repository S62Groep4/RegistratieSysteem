/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Vehicle;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import utildatagenerator.JPA;

/**
 *
 * @author M
 */
@Stateless
@JPA
public class VehicleDAOImpl implements VehicleDAO{

    @PersistenceContext(name = "RegistratieSysteemPU")
    EntityManager em;
    
    @Override
    public List<Vehicle> getVehicle(String hashedLicenceplate) throws PersistenceException {
        return em.createNamedQuery("Vehicle.findByLicenseplate").setParameter("license", hashedLicenceplate).getResultList();
    }

    @Override
    public List<Vehicle> getAllVehicles() throws PersistenceException {
        return em.createNamedQuery("Vehicle.getAllVehicles").getResultList();
    }

    //NOTE returning a bool here is not needed
    @Override
    public boolean updateVehicle(Vehicle vehicle) throws PersistenceException {
        em.merge(vehicle);
        return true;
    }

    @Override
    public boolean removeVehicle(Vehicle vehicle) throws PersistenceException {
        Vehicle managedVehicle = em.find(Vehicle.class, vehicle.getId());
        em.remove(managedVehicle);
        return true;
    }

    @Override
    public boolean insertVehicle(Vehicle vehicle) throws PersistenceException {
        em.persist(vehicle);
        return true;
    }
    
}
