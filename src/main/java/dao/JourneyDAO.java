/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Journey;
import java.util.List;
import javax.persistence.PersistenceException;

/**
 *
 * @author M
 */
public interface JourneyDAO {

    List<Journey> getJourneys() throws PersistenceException;

    List<Journey> getJourney(Long Id) throws PersistenceException;

    Boolean insertJourney(Journey journey) throws PersistenceException;

    Boolean updateJourney(Journey journey) throws PersistenceException;

    Boolean removeJourney(Journey journey) throws PersistenceException;
}
