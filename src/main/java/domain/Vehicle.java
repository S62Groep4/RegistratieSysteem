/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import interfaces.IJourney;
import interfaces.ISubInvoice;
import interfaces.IVehicle;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.inject.Model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author M
 */
@Entity
@Model
@NamedQueries({
    @NamedQuery(name = "Vehicle.getAllVehicles",
            query = "SELECT v FROM Vehicle V"),
    @NamedQuery(name = "Vehicle.findByLicenseplate",
            query = "SELECT v FROM Vehicle V "
                    + "WHERE v.licensePlate = :license")
})
public class Vehicle implements IVehicle, Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String licensePlate = null;
    private List<IJourney> journeys = new ArrayList();
    private List<ISubInvoice> subInvoices = new ArrayList();
    //@OneToMany
    //private List<Movement> movements = new ArrayList();
    
    public Vehicle(){
        
    }
    
    public Vehicle(String licensePlate){
        this.licensePlate = licensePlate;
    }

    @Override
    public String getHashedLicensePlate() {
        return this.licensePlate;
    }

    @Override
    public List<IJourney> getJourneys() {
        return this.journeys;
    }
    
    public void setJourneys(List<IJourney> journeys){
        this.journeys = journeys;
    }

    @Override
    public List<ISubInvoice> getSubInvoices() {
        return this.subInvoices;
    }
    
    public void setSubInvoices(List<ISubInvoice> subInvoices){
        this.subInvoices = subInvoices;
    }
    
    public void setHashedLicensePlate(String licensePlate){
        this.licensePlate = licensePlate;
    }    
    
    public void setId(Long id){
        this.id = id;
    }
    
    public Long getId(){
        return this.id;
    }
}
