/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.TransLocation;
import interfaces.ITransLocation;
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
public class TransLocationImpl implements TransLocationDAO {

    @PersistenceContext(name = "RegistratieSysteemPU")
    EntityManager em;

    @Override
    public List<TransLocation> getTransLocations() throws PersistenceException {
        return em.createNamedQuery("Translocation.getAllTranslocations").getResultList();
    }

    @Override
    public List<TransLocation> getTransLocation(String dateTime) throws PersistenceException {
        return em.createNamedQuery("Translocation.findTranslocation").setParameter("dateTime", dateTime).getResultList();
    }

    @Override
    public Boolean insertTransLocation(ITransLocation translocation) throws PersistenceException {
        em.persist(translocation);
        return true;
    }

    @Override
    public Boolean updateTransLocation(TransLocation translocation) throws PersistenceException {
        em.merge(translocation);
        return true;
    }

    @Override
    public Boolean removeTransLocation(TransLocation translocation) throws PersistenceException {
        TransLocation managedTranslocation = em.find(TransLocation.class, translocation.getId());
        em.remove(managedTranslocation);
        return true;
    }

}
