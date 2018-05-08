package util;

import domain.TransLocation;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Lock;
import static javax.ejb.LockType.READ;
import static javax.ejb.LockType.WRITE;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Startup
public class StolenVehicleController {
    
    private List<String> stolen;
    
    private static volatile StolenVehicleController instance = null;
    
    @Lock(READ)
    public List<String> getStolen(){
        return this.stolen;
    }
    
    @Lock(WRITE)
    public void addStolenCarTrackerSerial(String carTrackerSerial){
        stolen.add(carTrackerSerial);
    }
    
    public static StolenVehicleController getInstance(){
        if(instance == null){
            synchronized(StolenVehicleController.class){
                if(instance == null){
                    instance = new StolenVehicleController();
                }
            }
        }
        return instance;
    }
    
    private StolenVehicleController(){
        
        //TODO:
        //Get stored data from last session from the database.
        //Make rest call
        stolen = new ArrayList<>();
    }
    
    public void sendLocationData(TransLocation transLocation){
        
    }
    
    

}
