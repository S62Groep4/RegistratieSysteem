/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import interfaces.IJourney;
import interfaces.ISubInvoice;
import interfaces.ITransLocation;
import interfaces.IVehicle;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.inject.Model;
import javax.persistence.CascadeType;
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
public class Vehicle implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String licensePlate = null;
    private List<ISubInvoice> subInvoices = new ArrayList();
    
    @OneToMany(targetEntity = Journey.class, cascade = CascadeType.ALL)
    private List<Journey> journeys = new ArrayList();
    
    public Vehicle(){
        
    }
    
    public Vehicle(String licensePlate){
        this.licensePlate = licensePlate;
    }

    public String getHashedLicensePlate() {
        return this.licensePlate;
    }

    public List<Journey> getJourneys() {
        return this.journeys;
    }
    
    public void setJourneys(List<Journey> journeys){
        this.journeys = journeys;
    }

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
