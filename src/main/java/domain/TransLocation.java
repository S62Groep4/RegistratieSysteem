/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import interfaces.ITransLocation;
import java.io.Serializable;
import java.util.ArrayList;
import javax.enterprise.inject.Model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author M
 */
@Model
@Entity
@NamedQueries({
    @NamedQuery(name = "Translocation.getAllTranslocations",
            query = "SELECT t from TransLocation t"),
    @NamedQuery(name = "Translocation.findTranslocation",
            query = "SELECT t from TransLocation t "
                    + "WHERE t.dateTime = :dateTime")
})
public class TransLocation implements ITransLocation, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double lat = null;
    private Double lon = null;
    private String dateTime = null;
    private String serialNumber = null;
    private String countryCode = null;
    
    //@ManyToOne
    //private Journey journey = null;

    public TransLocation() {

    }

    public TransLocation(Double lat, Double lon, String dateTime, String serialNumber,
            String countryCode) {
        this.lat = lat;
        this.lon = lon;
        this.dateTime = dateTime;
        this.serialNumber = serialNumber;
        this.countryCode = countryCode;
        //this.journey = new Journey();
    }

    public void setLat(Double lat){
        this.lat = lat;
    }
    
    @Override
    public Double getLat() {
        return this.lat;
    }

    public void setLon(Double lon){
        this.lon = lon;
    }
    
    @Override
    public Double getLon() {
        return this.lon;
    }
    
    public void setDateTime(String dateTime){
        this.dateTime = dateTime;
    }

    @Override
    public String getDateTime() {
        return this.dateTime;
    }

    public void setSerialNumber(String serialNumber){
        this.serialNumber = serialNumber;
    }
    
    @Override
    public String getSerialNumber() {
        return this.serialNumber;
    }

    public void setCountryCode(String countryCode){
        this.countryCode = countryCode;
    }
    
    @Override
    public String getCountryCode() {
        return this.countryCode;
    }
    
    public void setId(Long id){
        this.id = id;
    }
    
    public Long getId(){
        return this.id;
    }
}
