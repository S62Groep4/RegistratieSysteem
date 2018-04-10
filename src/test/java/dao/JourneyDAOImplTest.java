/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Journey;
import domain.TransLocation;
import interfaces.ITransLocation;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import util.DatabaseCleaner;

/**
 *
 * @author M
 */
public class JourneyDAOImplTest {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("RegistratieSysteemTestPU");
    private EntityManager em;
    private EntityTransaction et;

    public JourneyDAOImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        try {
            new DatabaseCleaner(emf.createEntityManager()).clean();
        } catch (SQLException ex) {
        Logger.getLogger(JourneyDAOImplTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        em = emf.createEntityManager();
        et = em.getTransaction();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testSetTranslocations() {
        System.out.println("setTranslocations");
        List<ITransLocation> translocations = new ArrayList();
        translocations.add(new TransLocation(10.0, 11.11, "11-04-2018", "123", "Berlin"));
        Journey journey = new Journey(translocations);
        journey.setTranslocations(translocations);
        
        et.begin();
        em.persist(journey);
        et.commit();

        assertEquals(1, em.find(Journey.class, journey.getId()).getTransLocations().size());
    }

    /**
     * Test of getMovements method, of class Movement.
     */
    @Test
    public void testGetTranslocations() {
        System.out.println("getTranslocations");
        Journey instance = new Journey();
        List<ITransLocation> translocations = new ArrayList();
        translocations.add(new TransLocation(10.22, 11.33, "11-04-2018", "12313", "Berlin"));
        instance.setTranslocations(translocations);

        List<ITransLocation> expResult = translocations;
        List<ITransLocation> result = instance.getTransLocations();

        et.begin();
        em.persist(instance);
        et.commit();
        
        assertEquals(result, em.find(Journey.class, instance.getId()).getTransLocations());
    }
}
