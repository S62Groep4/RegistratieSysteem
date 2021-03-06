/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Journey;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

/**
 *
 * @author M
 */
@Stateless
public class JourneyDAOImpl implements JourneyDAO {
        
    @PersistenceContext(name = "RegistratieSysteemPU")
    EntityManager em;
    
    @Override
    public List<Journey> getJourneys() throws PersistenceException {
        return em.createNamedQuery("Journey.getAllJourneys").getResultList();
    }

    @Override
    public List<Journey> getJourney(Long Id) throws PersistenceException {
        return em.createNamedQuery("Journey.findJourney").setParameter("Id", Id).getResultList();
    }

    @Override
    public Boolean insertJourney(Journey journey) throws PersistenceException {
        em.persist(journey);
        return true;
    }

    @Override
    public Boolean updateJourney(Journey journey) throws PersistenceException {
        em.merge(journey);
        return true;
    }

    @Override
    public Boolean removeJourney(Journey journey) throws PersistenceException {
        Journey managedJourney = em.find(Journey.class, journey.getId());
        em.remove(managedJourney);
        return true;
    }
    
}
