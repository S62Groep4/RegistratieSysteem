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

/**
 *
 * @author M
 */
public class LatLngTest {
    
    public LatLngTest() {
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
        LatLng instance = new LatLng();
        instance.setId(Id);
        assertNotNull(instance.getId());
    }

    /**
     * Test of getId method, of class LatLng.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        LatLng instance = new LatLng();
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
        LatLng instance = new LatLng();
        instance.setLat(lat);
        assertNotNull(instance.getLat());
    }

    /**
     * Test of getLat method, of class LatLng.
     */
    @Test
    public void testGetLat() {
        System.out.println("getLat");
        LatLng instance = new LatLng();
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
        LatLng instance = new LatLng();
        instance.setLongValue(longValue);
        assertNotNull(instance.getLongValue());
    }

    /**
     * Test of getLongValue method, of class LatLng.
     */
    @Test
    public void testGetLongValue() {
        System.out.println("getLongValue");
        LatLng instance = new LatLng();
        instance.setLongValue(10.00);
        Double expResult = 10.00;
        Double result = instance.getLongValue();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTime method, of class LatLng.
     */
    @Test
    public void testSetTime() {
        System.out.println("setTime");
        Date time = new Date();
        LatLng instance = new LatLng();
        instance.setTime(time);
        assertNotNull(instance.getTime());
    }

    /**
     * Test of getTime method, of class LatLng.
     */
    @Test
    public void testGetTime() {
        System.out.println("getTime");
        LatLng instance = new LatLng();
        Date expResult = new Date();
        instance.setTime(new Date());
        Date result = instance.getTime();
        assertEquals(expResult, result);
    }

    /**
     * Test of setProvincie method, of class LatLng.
     */
    @Test
    public void testSetProvincie() {
        System.out.println("setProvincie");
        String provincie = "Berlin";
        LatLng instance = new LatLng();
        instance.setProvincie(provincie);
        assertNotNull(instance.getProvincie());
    }

    /**
     * Test of getProvincie method, of class LatLng.
     */
    @Test
    public void testGetProvincie() {
        System.out.println("getProvincie");
        LatLng instance = new LatLng();
        instance.setProvincie("Berlin");
        String expResult = "Berlin";
        String result = instance.getProvincie();
        assertEquals(expResult, result);
    }
    
}
