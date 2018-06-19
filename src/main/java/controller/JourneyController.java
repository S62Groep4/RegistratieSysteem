/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.Journey;
import java.io.Serializable;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import service.JourneyService;

@Named
@ViewScoped
public class JourneyController implements Serializable {
    
    @Inject
    private JourneyService journeyService;
    
    public List<Journey> getActiveJourneys() {
        System.out.println("get journeys " + journeyService.activeJourneys.size());
        return journeyService.activeJourneys;
    }
    
    public void endJourney(String cartrackerId) {
        System.out.println("End journey: " + cartrackerId);
        journeyService.endJourney(cartrackerId);
    }
}
