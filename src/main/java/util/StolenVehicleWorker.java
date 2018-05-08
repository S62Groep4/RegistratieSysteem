package util;

import domain.TransLocation;
import java.util.List;


public class StolenVehicleWorker implements Runnable{
    
    private List<String> stolen;
    private TransLocation toTrack;
    
    public StolenVehicleWorker(TransLocation transLocation){
        this.toTrack = transLocation;
    }

    @Override
    public void run() {
        System.out.println("Started a new thread to check if current car is stolen");
        this.stolen = StolenVehicleController.getInstance().getStolen();
        isStolen();
    }
    
    private void isStolen(){
        if(stolen.contains(toTrack.getSerialNumber())){
            //Car is stolen
            System.out.println("Car is stolen, sending translocation data to the police department");
        }else{
            System.out.println("Car was not stolen, normal procedure");
        }
    }

}
