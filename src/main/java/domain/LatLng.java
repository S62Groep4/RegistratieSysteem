/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import interfaces.ILatLng;
import java.io.Serializable;
import java.util.Date;
import javax.enterprise.inject.Model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author M
 */
/*
@Model
@Entity
public class LatLng implements ILatLng, Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private Double lat = null;
    private Double longValue = null;
    private Date time = null;
    private String provincie = null;
    @ManyToOne
    private LatLng latLng = null;

    public LatLng(){
        
    }
    
    public LatLng(Double lat, Double longValue, Date time, String provincie){
        this.lat = lat;
        this.longValue = longValue;
        this.time = time;
        this.provincie = provincie;
    }
    
    public void setId(Long Id){
        this.Id = Id;
    }
    
    public Long getId(){
        return this.Id;
    }
    
    public void setLat(Double lat){
        this.lat = lat;
    }
    
    @Override
    public Double getLat() {
        return this.lat;
    }

    public void setLongValue(Double longValue){
        this.longValue = longValue;
    }
    
    @Override
    public Double getLongValue() {
        return this.longValue;
    }

    public void setTime(Date time){
        this.time = time;
    }
    
    @Override
    public Date getTime() {
        return this.time;
    }
    
    public void setProvincie(String provincie){
        this.provincie = provincie;
    }

    @Override
    public String getProvincie() {
        return this.provincie;
    }
}
*/