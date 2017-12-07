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
    }

    public void startAllCars() {
        ArrayList<Car> allCars = getAllOfType(Car.class);
        for (Car c : allCars) {
            c.stopEngine();
        }
    }

    public void lowerBed() {
        ArrayList<Truck> allTrucks = getAllOfType(Truck.class);
        for (Truck t : allTrucks) {
            t.getLoadingPlatform().setAngle(t.getLoadingPlatform().getMaxAngle());
        }
    }

    public void liftBed() {
        ArrayList<Truck> allTrucks = getAllOfType(Truck.class);
        for (Truck t : allTrucks) {
            t.getLoadingPlatform().setAngle(0);
        }
    }

    public void turnLeft() {
        for (Vehicle v : vehicles) {
            v.turnLeft();
        }
    }

    public void turnRight() {
        for (Vehicle v : vehicles) {
            v.turnRight();
        }
    }

    public void gas(int amount) {
        for (Vehicle v : vehicles) {
            v.gas(amount / 100d);
        }
    }

    public void brake(int amount) {
        for (Vehicle v : vehicles) {
            v.brake(amount / 100d);
        }
    }

    public void setBedTOFalse() {
        for (Vehicle v : vehicles) {
            v.setBed(false);
        }
    }
    public void setBedToTrue(){
        for (Vehicle v:vehicles){
            v.setBed(true);
        }
    }

    //TODO
    public void setLodingPlatform() {

    }

    //Currently not "playing" out the class in order to find out if it has a turbo or not.
    //Not sure how to do that and not necessary at this point.
    public void setTurboOn() {
        ArrayList<Saab95> allSaab95 = getAllOfType(Saab95.class);
        for (Saab95 s : allSaab95) {
            s.setTurbo(true);
        }
    }

    public void setTurboOff() {
        ArrayList<Saab95> allSaab95 = getAllOfType(Saab95.class);
        for (Saab95 s : allSaab95) {
            s.setTurbo(false);
        }
    }

}
