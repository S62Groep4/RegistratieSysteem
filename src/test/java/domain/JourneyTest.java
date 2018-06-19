/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import interfaces.ILatLng;
import interfaces.IMovement;
import interfaces.ITransLocation;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
public class JourneyTest {
    
    public JourneyTest() {
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
     * Test of setMovements method, of class Movement.
     */
    @Test
    public void testSetMovements() {
        System.out.println("setMovements");
        List<TransLocation> movements = new ArrayList();
        movements.add(new TransLocation(10.0, 11.11, "11-04-2018", "123", "Berlin"));
        Journey instance = new Journey();
        instance.setTranslocations(movements);
        assertNotNull(instance.getTransLocations());
    }

    /**
     * Test of getMovements method, of class Movement.
     */
    @Test
    public void testGetMovements() {
        System.out.println("getMovements");
        Journey instance = new Journey();
        List<TransLocation> latLngs = new ArrayList();
        latLngs.add(new TransLocation(10.22, 11.33, "11-04-2018", "12313" ,"Berlin"));
        instance.setTranslocations(latLngs);
        
        List<TransLocation> expResult = latLngs;
        List<TransLocation> result = instance.getTransLocations();
        assertEquals(expResult.size(), result.size());
    }
    
}
