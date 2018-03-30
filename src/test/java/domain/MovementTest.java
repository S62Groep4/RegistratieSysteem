/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import interfaces.ILatLng;
import interfaces.IMovement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
public class MovementTest {
    
    public MovementTest() {
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
        List<LatLng> movements = new ArrayList();
        movements.add(new LatLng(10.0, 11.11, new Date(), "Berlin"));
        Movement instance = new Movement();
        instance.setMovements(movements);
        assertNotNull(instance.getMovements());
    }

    /**
     * Test of getMovements method, of class Movement.
     */
    @Test
    public void testGetMovements() {
        System.out.println("getMovements");
        Movement instance = new Movement();
        List<LatLng> latLngs = new ArrayList();
        latLngs.add(new LatLng(10.22, 11.33, new Date(), "Berlin"));
        instance.setMovements(latLngs);
        
        List<LatLng> expResult = latLngs;
        List<LatLng> result = instance.getMovements();
        assertEquals(expResult.size(), result.size());
    }
    
}
