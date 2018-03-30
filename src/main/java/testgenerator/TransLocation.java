/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testgenerator;

import interfaces.ITransLocation;
import java.io.Serializable;
import javax.enterprise.inject.Model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author M
 */
@Model
@Entity
public class TransLocation implements ITransLocation, Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double lat = null;
    private Double lon = null;
    private String dateTime = null;
    private String serialNumber = null;
    private String countryCode = null;
    
    public TransLocation(){
        
    }
    
    public TransLocation(Double lat, Double lon, String dateTime, String serialNumber,
            String countryCode){
        this.lat = lat;
        this.lon = lon;
        this.dateTime = dateTime;
        this.serialNumber = serialNumber;
        this.countryCode = countryCode;
    }
    
    @Override
    public Double getLat() {
        return this.lat;
    }

    @Override
    public Double getLon() {
        return this.lon;
    }

    @Override
    public String getDateTime() {
        return this.dateTime;
    }

    @Override
    public String getSerialNumber() {
        return this.serialNumber;
    }

    @Override
    public String getCountryCode() {
        return this.countryCode;
    }
}
