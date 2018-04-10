/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import interfaces.IJourney;
import interfaces.ITransLocation;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.inject.Model;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author M
 */
@Model
@Entity
@NamedQueries({
    @NamedQuery(name = "Journey.getAllJourneys",
            query = "SELECT j FROM Journey j"),
    @NamedQuery(name = "Journey.findJourney",
            query = "SELECT j FROM Journey j "
                    + "WHERE j.Id = :Id")
})
public class Journey implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @OneToMany(mappedBy = "journey", targetEntity = TransLocation.class, cascade = CascadeType.ALL)
    private List<TransLocation> translocations = new ArrayList();
    @ManyToOne(targetEntity = Vehicle.class, cascade = CascadeType.ALL)
    private Vehicle vehicle = new Vehicle();
    
    public Journey(){

    }
    
    public Journey(List<TransLocation> transLocations){
        this.translocations = transLocations;
    }

    public List<TransLocation> getTransLocations() {
        return this.translocations;
    }
    
    public void setTranslocations(List<TransLocation> translocations){
        this.translocations = translocations;
    }
    
    public void setId(Long Id){
        this.Id = Id;
    }
    
    public Long getId(){
        return this.Id;
    }
}
