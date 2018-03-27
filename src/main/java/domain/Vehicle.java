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
import java.util.List;
import javax.enterprise.inject.Model;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author M
 */
@Entity
@Model
public class Vehicle implements IVehicle, Serializable{
    @Id
    private Long id;
    private String licensePlate = null;
    private List<IJourney> journeys = null;
    private List<ISubInvoice> subInvoices = null;
    
    public Vehicle(){
        
    }
    
    public Vehicle(String licensePlate, List<IJourney> journeys, List<ISubInvoice> subInvoices){
        this.licensePlate = licensePlate;
        this.journeys = journeys;
        this.subInvoices = subInvoices;
    }

    @Override
    public String getHashedLicensePlate() {
        return this.licensePlate;
    }

    @Override
    public List<IJourney> getJourneys() {
        return this.journeys;
    }

    @Override
    public List<ISubInvoice> getSubInvoices() {
        return this.subInvoices;
    }
    
    public void setHashedLicensePlate(String licensePlate){
        this.licensePlate = licensePlate;
    }
    
    public void setJourneys(List<IJourney> journeys){
        this.journeys = journeys;
    }
    
    public void setSubInvoices(List<ISubInvoice> subInvoices){
        this.subInvoices = subInvoices;
    }
    
}
