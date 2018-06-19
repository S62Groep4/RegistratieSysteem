/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import interfaces.IJourney;
import interfaces.ISubInvoice;
import interfaces.ITransLocation;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import utildatagenerator.SubInvoice;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author M
 */
public class VehicleTest {

    private static final int logRounds = 12;

    public VehicleTest() {
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
     * Test of getHashedLicensePlate method, of class Vehicle.
     */
    @Test
    public void testGetHashedLicensePlate() {
        System.out.println("getHashedLicensePlate");
        Vehicle instance = new Vehicle();
        instance.setHashedLicensePlate(BCrypt.hashpw("111", BCrypt.gensalt(logRounds)));
        String result = instance.getHashedLicensePlate();
        
        assertEquals(result, instance.getHashedLicensePlate());
    }

    /**
     * Test of getJourneys method, of class Vehicle.
     */
    /*@Test
    public void testGetJourneys() {
        System.out.println("getJourneys");
        Vehicle instance = new Vehicle();

        List<TransLocation> locations = new ArrayList();
        locations.add(new TransLocation(10.2, 11.11, "11-04-2018", "1111231", "Deutschland"));
        Journey journey = new Journey(locations);

        List<Journey> journeys = new ArrayList();
        journeys.add(journey);

        instance.setJourneys(journeys);

        List<Journey> expResult = journeys;
        List<Journey> result = instance.getJourneys();
        assertEquals(expResult.size(), result.size());
    }*/

    /**
     * Test of getSubInvoices method, of class Vehicle.
     */
    @Test
    public void testGetSubInvoices() {
        System.out.println("getSubInvoices");
        Vehicle instance = new Vehicle();

        ISubInvoice subinvoice = new SubInvoice("123123", "Deutschland", Boolean.TRUE, "11-04-2018", 10.22);
        List<ISubInvoice> subinvoices = new ArrayList();
        subinvoices.add(subinvoice);

        instance.setSubInvoices(subinvoices);

        List<ISubInvoice> expResult = subinvoices;
        List<ISubInvoice> result = instance.getSubInvoices();
        assertEquals(expResult.size(), result.size());

    }

    /**
     * Test of setHashedLicensePlate method, of class Vehicle.
     */
    @Test
    public void testSetHashedLicensePlate() {
        System.out.println("setHashedLicensePlate");
        String licensePlate = BCrypt.hashpw("99-ASD-1", BCrypt.gensalt(logRounds));
        Vehicle instance = new Vehicle();
        instance.setHashedLicensePlate(licensePlate);
        assertNotNull(instance.getHashedLicensePlate());
    }

    /**
     * Test of setId method, of class Vehicle.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Long id = 1L;
        Vehicle instance = new Vehicle();
        instance.setId(id);
        assertNotNull(instance.getId());
    }

    /**
     * Test of getId method, of class Vehicle.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Vehicle instance = new Vehicle();
        instance.setId(1L);
        Long expResult = 1L;
        Long result = instance.getId();
        assertEquals(expResult, result);
    }

}
