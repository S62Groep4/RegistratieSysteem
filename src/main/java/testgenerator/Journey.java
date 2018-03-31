/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testgenerator;

import interfaces.IJourney;
import interfaces.ITransLocation;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
public class Journey implements IJourney, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private List<ITransLocation> translocations;
    
    public Journey(){

    }
    
    public Journey(List<ITransLocation> transLocations){
        this.translocations = transLocations;
    }

    @Override
    public List<ITransLocation> getTransLocations() {
        return this.translocations;
    }
    
    public void setTranslocations(List<ITransLocation> translocations){
        this.translocations = translocations;
    }
}
