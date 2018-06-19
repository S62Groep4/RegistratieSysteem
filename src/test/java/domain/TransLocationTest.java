/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author M
 */
public class TransLocationTest {
    
    public TransLocationTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setId method, of class LatLng.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Long Id = 1L;
        TransLocation instance = new TransLocation();
        instance.setId(Id);
        assertNotNull(instance.getId());
    }

    /**
     * Test of getId method, of class LatLng.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        TransLocation instance = new TransLocation();
        instance.setId(1L);
        Long expResult = 1L;
        Long result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setLat method, of class LatLng.
     */
    @Test
    public void testSetLat() {
        System.out.println("setLat");
        Double lat = 10.00;
        TransLocation instance = new TransLocation();
        instance.setLat(lat);
        assertNotNull(instance.getLat());
    }

    /**
     * Test of getLat method, of class LatLng.
     */
    @Test
    public void testGetLat() {
        System.out.println("getLat");
        TransLocation instance = new TransLocation();
        instance.setLat(10.00);
        Double expResult = 10.00;
        Double result = instance.getLat();
        assertEquals(expResult, result);
    }

    /**
     * Test of setLongValue method, of class LatLng.
     */
    @Test
    public void testSetLongValue() {
        System.out.println("setLongValue");
        Double longValue = 10.00;
        TransLocation instance = new TransLocation();
        instance.setLon(longValue);
        assertNotNull(instance.getLon());
    }

    /**
     * Test of getLongValue method, of class LatLng.
     */
    @Test
    public void testGetLongValue() {
        System.out.println("getLongValue");
        TransLocation instance = new TransLocation();
        instance.setLon(10.00);
        Double expResult = 10.00;
        Double result = instance.getLon();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTime method, of class LatLng.
     */
    @Test
    public void testSetTime() {
        System.out.println("setTime");
        String time = "11-04-2018";
        TransLocation instance = new TransLocation();
        instance.setDateTime(time);
        assertNotNull(instance.getDateTime());
    }

    /**
     * Test of getTime method, of class LatLng.
     */
    @Test
    public void testGetTime() {
        System.out.println("getTime");
        TransLocation instance = new TransLocation();
        String expResult = "11-04-2018";
        instance.setDateTime("11-04-2018");
        String result = instance.getDateTime();
        assertEquals(expResult, result);
    }

    /**
     * Test of setProvincie method, of class LatLng.
     */
    @Test
    public void testSetProvincie() {
        System.out.println("setProvincie");
        String provincie = "Berlin";
        TransLocation instance = new TransLocation();
        instance.setCountryCode(provincie);
        assertNotNull(instance.getCountryCode());
    }

    /**
     * Test of getProvincie method, of class LatLng.
     */
    @Test
    public void testGetProvincie() {
        System.out.println("getProvincie");
        TransLocation instance = new TransLocation();
        instance.setCountryCode("Berlin");
        String expResult = "Berlin";
        String result = instance.getCountryCode();
        assertEquals(expResult, result);
    }
    
}
