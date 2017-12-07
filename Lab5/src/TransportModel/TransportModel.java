package TransportModel;

import java.util.ArrayList;

/**
 * Created by lukamrkonjic on 2017-12-04.
 */
public class TransportModel {

    private ArrayList<Vehicle> vehicles;

    public TransportModel(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    private <T extends Vehicle> ArrayList<T> getAllOfType(Class<T> type) {
        ArrayList<T> vehicleThingys = new ArrayList<T>();
        for (Vehicle v : vehicles) {
            if (v.getClass() == type) {
                vehicleThingys.add(type.cast(v));

            }
        }
        return vehicleThingys;
    }

    public void stopAllCars() {
        ArrayList<Car> allCars = getAllOfType(Car.class);
        for (Car c : allCars) {
            c.stopEngine();
        }
        //vehicles.
    }

    public void startAllCars() {
        ArrayList<Car> allCars = getAllOfType(Car.class);
        for (Car c : allCars) {
            c.stopEngine();
        }
    }

    public void lowerBed(){
        ArrayList<Truck> allTrucks = getAllOfType(Truck.class);
        for (Truck t : allTrucks) {
            t.lowerBed();
        }
    }
    public void liftBed(){
        ArrayList<Truck> allTrucks = getAllOfType(Truck.class);
        for (Truck t : allTrucks) {
            t.liftBed();
        }
    }
    public void setTurboOn(){
        ArrayList<Saab95> allSaab95 = getAllOfType(Saab95.class);
        for(Saab95 s:allSaab95){
            s.s;
        }
    }

}
