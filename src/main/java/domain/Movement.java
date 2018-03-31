/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.inject.Model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author M
 */
@Model
@Entity
public class Movement implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private List<LatLng> movements = null;
    
    public Movement(){
        
    }
    
    public Movement(List<LatLng> movements){
        this.movements = new ArrayList();
    }
    
    public void setMovements(List<LatLng> movements){
        this.movements = movements;
    }
    
    public List<LatLng> getMovements(){
        return this.movements;
    }
}
