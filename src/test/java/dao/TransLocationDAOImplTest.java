/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.TransLocation;
import interfaces.ITransLocation;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
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
public class TransLocationDAOImplTest {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("RegistratieSysteemTestPU");
    private EntityManager em;
    private EntityTransaction et;

    public TransLocationDAOImplTest() {
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
            Logger.getLogger(TransLocationDAOImplTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        em = emf.createEntityManager();
        et = em.getTransaction();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of setId method, of class LatLng.
     */
//    @Test
//    public void testSetId() {
//        System.out.println("setId");
//        Long Id = 1L;
//        TransLocation instance = new TransLocation();
//        instance.setId(Id);
//        
//        et.begin();
//        em.persist(instance);
//        et.commit();
//        
//        assertEquals(instance.getId(), em.find(TransLocation.class, instance.getId()).getId());
//    }
//
//    /**
//     * Test of getId method, of class LatLng.
//     */
//    @Test
//    public void testGetId() {
//        System.out.println("getId");
//        TransLocation instance = new TransLocation();
//        instance.setId(2L);
//        Long expResult = 2L;
//        Long result = instance.getId();
//        
//        et.begin();
//        em.persist(instance);
//        et.commit();
//        
//        assertEquals(expResult, em.find(TransLocation.class, instance.getId()).getId());
//    }
//
//    /**
//     * Test of setLat method, of class LatLng.
//     */
//    @Test
//    public void testSetLat() {
//        System.out.println("setLat");
//        Double lat = 10.00;
//        TransLocation instance = new TransLocation();
//        instance.setLat(lat);
//        
//        et.begin();
//        em.persist(instance);
//        et.commit();
//        
//        assertEquals(instance.getLat(), em.find(TransLocation.class, instance.getId()).getLat());
//    }
//
//    /**
//     * Test of getLat method, of class LatLng.
//     */
//    @Test
//    public void testGetLat() {
//        System.out.println("getLat");
//        TransLocation instance = new TransLocation();
//        instance.setLat(10.00);
//        Double expResult = 10.00;
//        Double result = instance.getLat();
//        
//        et.begin();
//        em.persist(instance);
//        et.commit();
//        
//        assertEquals(expResult, em.find(TransLocation.class, instance.getId()).getLat());
//    }
//
//    /**
//     * Test of setLongValue method, of class LatLng.
//     */
//    @Test
//    public void testSetLongValue() {
//        System.out.println("setLongValue");
//        Double longValue = 10.00;
//        TransLocation instance = new TransLocation();
//        instance.setLon(longValue);
//        
//        et.begin();
//        em.persist(instance);
//        et.commit();
//        
//        assertEquals(instance.getLon(), em.find(TransLocation.class, instance.getId()).getLon());
//    }
//
//    /**
//     * Test of getLongValue method, of class LatLng.
//     */
//    @Test
//    public void testGetLongValue() {
//        System.out.println("getLongValue");
//        TransLocation instance = new TransLocation();
//        instance.setLon(10.00);
//        Double expResult = 10.00;
//        Double result = instance.getLon();
//        
//        et.begin();
//        em.persist(instance);
//        et.commit();
//        
//        assertEquals(expResult, em.find(TransLocation.class, instance.getId()).getLon());
//    }
//
//    /**
//     * Test of setTime method, of class LatLng.
//     */
//    @Test
//    public void testSetTime() {
//        System.out.println("setTime");
//        String time = "11-04-2018";
//        TransLocation instance = new TransLocation();
//        instance.setDateTime(time);
//        
//        et.begin();
//        em.persist(instance);
//        et.commit();
//        
//        assertEquals(instance.getDateTime(), em.find(TransLocation.class, instance.getId()).getDateTime());
//    }
//
//    /**
//     * Test of getTime method, of class LatLng.
//     */
//    @Test
//    public void testGetTime() {
//        System.out.println("getTime");
//        TransLocation instance = new TransLocation();
//        String expResult = "11-04-2018";
//        instance.setDateTime("11-04-2018");
//        String result = instance.getDateTime();
//        
//        et.begin();
//        em.persist(instance);
//        et.commit();
//        
//        assertEquals(expResult, em.find(TransLocation.class, instance.getId()).getDateTime());
//    }
//
//    /**
//     * Test of setProvincie method, of class LatLng.
//     */
//    @Test
//    public void testSetCountryCode() {
//        System.out.println("setProvincie");
//        String provincie = "Berlin";
//        TransLocation instance = new TransLocation();
//        instance.setCountryCode(provincie);
//        
//        et.begin();
//        em.persist(instance);
//        et.commit();
//        
//        assertEquals(instance.getCountryCode(), em.find(TransLocation.class, instance.getId()).getCountryCode());
//    }
//
//    /**
//     * Test of getProvincie method, of class LatLng.
//     */
//    @Test
//    public void testGetCountryCode() {
//        System.out.println("getProvincie");
//        TransLocation instance = new TransLocation();
//        instance.setCountryCode("Berlin");
//        String expResult = "Berlin";
//        String result = instance.getCountryCode();
//        
//        et.begin();
//        em.persist(instance);
//        et.commit();
//        
//        assertEquals(expResult, em.find(TransLocation.class, instance.getId()).getCountryCode());
//    }
}
