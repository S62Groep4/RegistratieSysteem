/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utildatagenerator;

import dao.JourneyDAO;
import dao.TransLocationDAO;
import domain.TransLocation;
import domain.Journey;
import dao.VehicleDAO;
import domain.Vehicle;
import interfaces.ISubInvoice;
import interfaces.ITransLocation;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author M
 */
//@Startup
@Singleton
public class init {

    @Inject
    VehicleDAO vehicleDAO;
    
    @Inject
    JourneyDAO journeyDAO;
    
    @Inject
    TransLocationDAO translocationDAO;

    private List<TransLocation> transLocations = null;
    private TransLocation transLocation1 = null;
    private TransLocation transLocation2 = null;
    private TransLocation transLocation3 = null;
    private TransLocation transLocation4 = null;
    private TransLocation transLocation5 = null;

    private List<Vehicle> vehicles = null;
    private List<Journey> journeys = null;

    private List<ISubInvoice> subInvoices1 = null;
    private List<ISubInvoice> subInvoices2 = null;
    private List<ISubInvoice> subInvoices3 = null;
    private List<ISubInvoice> subInvoices4 = null;
    private List<ISubInvoice> subInvoices5 = null;

    private static final int logRounds = 12;
    
    @PostConstruct
    public void init() {
        System.out.println("CREATE TEST DATA");
//        createJourneys();
//        createSubInvoices();
//        createCars();
    }

//    public void createCars() {
//
//        vehicles = new ArrayList();
//
//        vehicles.add(new Vehicle(BCrypt.hashpw("XF-SX-94", BCrypt.gensalt(logRounds))));
//        vehicles.add(new Vehicle(BCrypt.hashpw("GS-89-RT", BCrypt.gensalt(logRounds))));
//        vehicles.add(new Vehicle(BCrypt.hashpw("GF-TE-84", BCrypt.gensalt(logRounds))));
//        vehicles.add(new Vehicle(BCrypt.hashpw("22-AS-87", BCrypt.gensalt(logRounds))));
//        vehicles.add(new Vehicle(BCrypt.hashpw("1-GsV-54", BCrypt.gensalt(logRounds))));
//        vehicles.add(new Vehicle(BCrypt.hashpw("W-A1A-31", BCrypt.gensalt(logRounds))));
//        vehicles.add(new Vehicle(BCrypt.hashpw("13-HG-22", BCrypt.gensalt(logRounds))));
//        vehicles.add(new Vehicle(BCrypt.hashpw("11-JJH-9", BCrypt.gensalt(logRounds))));
//
//        for (Vehicle vehicle : vehicles) {
//            vehicleDAO.insertVehicle(vehicle);
//        }
//    }
//
//    public void createJourneys() {
//
//        journeys = new ArrayList();
//
//        transLocations = new ArrayList();
//        transLocation1 = new TransLocation(11.12, 32.44, "12-04-2018", "3234322", "Deutschland");
//        transLocation2 = new TransLocation(31.33, 43.98, "13-04-2018", "654322", "Deutschland");
//        transLocation3 = new TransLocation(43.54, 55.77, "14-04-2018", "86754", "Deutschland");
//        transLocation4 = new TransLocation(65.45, 47.44, "11-04-2018", "876454", "Deutschland");
//        transLocation5 = new TransLocation(38.87, 95.32, "15-04-2018", "3436755", "Deutschland");
//
//        transLocations.add(transLocation1);
//        transLocations.add(transLocation2);
//        transLocations.add(transLocation3);
//        transLocations.add(transLocation4);
//        transLocations.add(transLocation5);
//        journeys.add(new Journey(transLocations));
//        
//        for(ITransLocation translocation : transLocations){
//            translocationDAO.insertTransLocation(translocation);
//        }
//        
//        for(Journey journey : journeys){
//            journeyDAO.insertJourney(journey);
//        }
//    }
//
//    public void createSubInvoices() {
//        subInvoices1 = new ArrayList();
//        subInvoices2 = new ArrayList();
//        subInvoices3 = new ArrayList();
//        subInvoices4 = new ArrayList();
//        subInvoices5 = new ArrayList();
//
//        subInvoices1.add(new SubInvoice("1231232", "Deutschland", Boolean.TRUE, "12-04-2018", 122.0));
//        subInvoices2.add(new SubInvoice("45545433", "Deutschland", Boolean.TRUE, "13-04-2018", 110.0));
//        subInvoices3.add(new SubInvoice("5375765", "Deutschland", Boolean.FALSE, "14-04-2018", 320.0));
//        subInvoices4.add(new SubInvoice("575644", "Deutschland", Boolean.FALSE, "11-04-2018", 220.0));
//        subInvoices5.add(new SubInvoice("4646547", "Deutschland", Boolean.TRUE, "15-04-2018", 210.0));
//    }
}
