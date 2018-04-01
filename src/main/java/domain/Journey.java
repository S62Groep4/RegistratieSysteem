/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import interfaces.IJourney;
import interfaces.ITransLocation;
import java.io.Serializable;
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
@Model
@Entity
@NamedQueries({
    @NamedQuery(name = "Journey.getAllJourneys",
            query = "SELECT j FROM Journey j"),
    @NamedQuery(name = "Journey.findJourney",
            query = "SELECT j FROM Journey j "
                    + "WHERE j.Id = :Id")
})
public class Journey implements IJourney, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    //@OneToMany(mappedBy = "journey")
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
    
    public void setId(Long Id){
        this.Id = Id;
    }
    
    public Long getId(){
        return this.Id;
    }
}
