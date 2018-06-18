package service;

import dao.JourneyDAO;
import domain.Journey;
import domain.TransLocation;
import interfaces.TransLocationDto;

import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.PersistenceException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

@Stateless
@Singleton
public class JourneyService {

    @Inject
    JourneyDAO journeyDAO;

    @Inject
    private StolenVehicleService stolenVehicleService;


    public static final List<Journey> activeJourneys = Collections.synchronizedList(new ArrayList<Journey>());

    private static final List<String> stolenVehicles = Collections.synchronizedList(new ArrayList<String>());

    private static final Logger LOGGER = Logger.getLogger(JourneyService.class.getName());

    public JourneyService() {

    }

    public List<Journey> getJourneys() throws PersistenceException {
        try {
            return journeyDAO.getJourneys();
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing getMovements method; {0}", pe.getMessage());
            return null;
        }
    }

    public List<Journey> getJourney(Long Id) throws PersistenceException {
        try {
            return journeyDAO.getJourney(Id);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing getMovement method; {0}", pe.getMessage());
            return null;
        }
    }

    public Boolean insertJourney(Journey journey) throws PersistenceException {
        try {
            return journeyDAO.insertJourney(journey);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing insertMovement method; {0}", pe.getMessage());
            return false;
        }
    }

    public Boolean updateJourney(Journey journey) throws PersistenceException {
        try {
            return journeyDAO.updateJourney(journey);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing updateMovement method; {0}", pe.getMessage());
            return false;
        }
    }

    public Boolean removeJourney(Journey journey) throws PersistenceException {
        try {
            return journeyDAO.removeJourney(journey);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing removeMovement method; {0}", pe.getMessage());
            return false;
        }
    }

    public void addTransLocation(TransLocationDto transLocationDto) {
        Journey currentJourney = null;

        for (Journey j : this.activeJourneys) {
            if (j.getTransLocations() != null && j.getTransLocations().size() > 0) {
                if (j.getTransLocations().get(0).getSerialNumber().equals(transLocationDto.getSerialNumber())) {
                    currentJourney = j;
                    break;
                }
            }
        }

        TransLocation transLocation = new TransLocation();
        transLocation.setCountryCode(transLocationDto.getCountryCode());
        transLocation.setDateTime(transLocationDto.getDateTime());
        transLocation.setLat(transLocationDto.getLat());
        transLocation.setLon(transLocationDto.getLon());
        transLocation.setSerialNumber(transLocationDto.getSerialNumber());

        if (currentJourney != null) {
            currentJourney.getTransLocations().add(transLocation);
            transLocation.setJourney(currentJourney);
        } else {
            Journey newJourney = new Journey(new ArrayList<TransLocation>());
            newJourney.getTransLocations().add(transLocation);
            transLocation.setJourney(newJourney);
            this.activeJourneys.add(newJourney);
        }


        if (stolenVehicles.contains(transLocation.getSerialNumber())) {
            try {
                stolenVehicleService.PublishLocation(transLocationDto);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                LOGGER.log(Level.FINE, "ERROR while performing publish stolen vehicle method; {0}", e.getMessage());
            }
        }

        System.out.println("Journeys: " + activeJourneys.size());
    }

    public void endJourney(String cartrackerId) {
        Journey journeyToEnd = null;
        for (Journey j : activeJourneys) {
            if (j.getTransLocations() != null && j.getTransLocations().size() > 0) {
                if (j.getTransLocations().get(0).getSerialNumber().equals(cartrackerId)) {
                    journeyToEnd = j;
                    break;
                }
            }
        }

        activeJourneys.remove(journeyToEnd);

        journeyToEnd.setCartracker(journeyToEnd.getTransLocations().get(0).getSerialNumber());

        insertJourney(journeyToEnd);

    }

    public void AddStolenVehicle(String id) {
        if (!stolenVehicles.contains(id)) {
            stolenVehicles.add(id);
        }
    }

    public void removeAsStolenVehicle(String id) {
        if (stolenVehicles.contains(id)) {
            stolenVehicles.remove(id);
        }
    }


}
