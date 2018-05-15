/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Vehicle;
import interfaces.IJourney;
import interfaces.ISubInvoice;
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
import org.junit.Ignore;
import domain.Journey;
import utildatagenerator.SubInvoice;
import domain.TransLocation;
import util.DatabaseCleaner;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author M
 */
@Ignore
public class VehicleDAOImplTest {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("RegistratieSysteemTestPU");
    private EntityManager em;
    private EntityTransaction et;

    private static final int logRounds = 12;

    public VehicleDAOImplTest() {
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
        Logger.getLogger(VehicleDAOImplTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        em = emf.createEntityManager();
        et = em.getTransaction();
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
        String expResult = "111";
        String result = instance.getHashedLicensePlate();

        et.begin();
        em.persist(instance);
        et.commit();

        assertEquals(result, em.find(Vehicle.class, instance.getId()).getHashedLicensePlate());

    }

    /**
     * Test of getJourneys method, of class Vehicle.
     */
    @Test
    public void testGetJourneys() {
        System.out.println("getJourneys");
        Vehicle instance = new Vehicle();
        instance.setHashedLicensePlate(BCrypt.hashpw("82-SS-11", BCrypt.gensalt(logRounds)));

        List<ITransLocation> locations = new ArrayList();
        locations.add(new TransLocation(10.2, 11.11, "11-04-2018", "1111231", "Deutschland"));
        IJourney journey = new Journey(locations);

        List<IJourney> journeys = new ArrayList();
        journeys.add(journey);

        instance.setJourneys(journeys);

        List<IJourney> expResult = journeys;
        List<IJourney> result = instance.getJourneys();

        et.begin();
        em.persist(instance);
        et.commit();

        assertEquals(result, em.find(Vehicle.class, instance.getId()).getJourneys());
    }

    /**
     * Test of getSubInvoices method, of class Vehicle.
     */
    @Test
    public void testGetSubInvoices() {
        System.out.println("getSubInvoices");
        Vehicle instance = new Vehicle();
        instance.setHashedLicensePlate(BCrypt.hashpw("99-XXS-1", BCrypt.gensalt(logRounds)));

        ISubInvoice subinvoice = new SubInvoice("123123", "Deutschland", Boolean.TRUE, "11-04-2018", 10.22);
        List<ISubInvoice> subinvoices = new ArrayList();
        subinvoices.add(subinvoice);

        instance.setSubInvoices(subinvoices);

        List<ISubInvoice> expResult = subinvoices;
        List<ISubInvoice> result = instance.getSubInvoices();

        et.begin();
        em.persist(instance);
        et.commit();

        assertEquals(result, em.find(Vehicle.class, instance.getId()).getSubInvoices());
        assertEquals(1, em.find(Vehicle.class, instance.getId()).getSubInvoices().size());

    }

    /**
     * Test of setHashedLicensePlate method, of class Vehicle.
     */
    @Test
    public void testSetHashedLicensePlate() {
        System.out.println("setHashedLicensePlate");
        String licensePlate = BCrypt.hashpw("AAA-BB-C", BCrypt.gensalt(logRounds));
        Vehicle instance = new Vehicle();
        instance.setHashedLicensePlate(licensePlate);

        et.begin();
        em.persist(instance);
        et.commit();

        assertEquals(licensePlate, em.find(Vehicle.class, instance.getId()).getHashedLicensePlate());
    }

    /**
     * Test of setId method, of class Vehicle.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Long id = 1L;
        Vehicle instance = new Vehicle();
        instance.setHashedLicensePlate(BCrypt.hashpw("88-HH-11", BCrypt.gensalt(logRounds)));
        instance.setId(id);

        et.begin();
        em.persist(instance);
        et.commit();

        assertEquals(instance.getId(), em.find(Vehicle.class, instance.getId()).getId());
    }

    /**
     * Test of getId method, of class Vehicle.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Vehicle instance = new Vehicle();
        instance.setHashedLicensePlate(BCrypt.hashpw("00-JJ-88", BCrypt.gensalt(logRounds)));
        instance.setId(1L);
        Long expResult = 1L;
        Long result = instance.getId();

        et.begin();
        em.persist(instance);
        et.commit();

        assertEquals(instance.getId(), em.find(Vehicle.class, instance.getId()).getId());
    }
}
