/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.TransLocation;
import interfaces.ITransLocation;
import java.util.List;
import javax.persistence.PersistenceException;

/**
 *
 * @author M
 */
public interface TransLocationDAO {

    List<TransLocation> getTransLocations() throws PersistenceException;

    List<TransLocation> getTransLocation(String dateTime) throws PersistenceException;

    Boolean insertTransLocation(ITransLocation translocation) throws PersistenceException;

    Boolean updateTransLocation(TransLocation translocation) throws PersistenceException;

    Boolean removeTransLocation(TransLocation translocation) throws PersistenceException;

}
