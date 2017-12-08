package TransportModel;

import java.io.IOException;
import java.util.ArrayList;
import TransportModel.CarFactory;

import static TransportModel.CarFactory.createSaab95;

/**
 *
 *
 * Created by lukamrkonjic on 2017-12-04.
 * Updated by saralandfors on 2017-12-08.
 */
public class TransportModel {
    // Instance variables
    private ArrayList<Vehicle> vehicles;

    /**
     * The constructor that takes an arraylist of vehicles as an input parameter.
     * This allows for the application's starting position to be changed (the TransportApplication
     * can be easily changed to have a different ArrayList of vehicles as a starting position.)
     * @param vehicles
     */
    public TransportModel(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    /**
     *
     * @return the vehicles in the transportModel.
     */
    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    /**
     * Private auxilliary method that allows for the model to access vehicles of a
     * specific type.
     * @param type The class of the objects to be returned. The returned list will be all objects of
     *             the specified type including all subclasses.
     * @param <T>
     * @return  An arraylist with all objects of the specified type.
     */
    private <T extends Vehicle> ArrayList<T> getAllOfType(Class<T> type) {
        ArrayList<T> vehicleThingys = new ArrayList<T>();
        for (Vehicle v : vehicles) {
            if (type.isInstance(v)) {
                vehicleThingys.add(type.cast(v));
            }
        }
        return vehicleThingys;
    }

    /**
     * Stops the engines of all cars in the model.
     */
    public void stopAllCars() {
        ArrayList<Car> allCars = getAllOfType(Car.class);
        for (Car c : allCars) {
            c.stopEngine();
        }
    }

    /**
     * Starts the engines of all cars in the model, provided their
     * engines weren't already on.
     */
    public void startAllCars() {
        ArrayList<Car> allCars = getAllOfType(Car.class);
        for (Car c : allCars) {
            if (c.getCurrentSpeed() == 0) {
                c.startEngine();
            }
        }
    }

    /**
     * Lowers the loading beds of all trucks.
     */
    public void lowerBed() {
        ArrayList<Truck> allTrucks = getAllOfType(Truck.class);
        for (Truck t : allTrucks) {
            t.getLoadingPlatform().setAngle(t.getLoadingPlatform().getMaxAngle());
        }
    }

    /**
     * Lifts the loading beds of all trucks.
     */
    public void liftBed() {
        ArrayList<Truck> allTrucks = getAllOfType(Truck.class);
        for (Truck t : allTrucks) {
            t.getLoadingPlatform().setAngle(0);
        }
    }

    /**
     * Turns all vehicles left.
     */
    public void turnLeft() {
        for (Vehicle v : vehicles) {
            v.turnLeft();
        }
    }

    /**
     * Turns all vehicles right.
     */
    public void turnRight() {
        for (Vehicle v : vehicles) {
            v.turnRight();
        }
    }

    /**
     * Increases the speed of all vehicles in the model.
     * @param amount the amount by how much to accelerate
     */
    public void gas(int amount) {
        for (Vehicle v : vehicles) {
            v.gas(amount / 100d);
        }
    }

    /**
     * Decreases the speed of all vehicles in the model.
     * @param amount how much to brake.
     */
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
    public void setLoadingPlatform() {

    }

    //Currently not "playing" out the class in order to find out if it has a turbo or not.
    //Not sure how to do that and not necessary at this point.

    /**
     * Turns on turbo for all Saab95s.
     */
    public void setTurboOn() {
        ArrayList<Saab95> allSaab95 = getAllOfType(Saab95.class);
        for (Saab95 s : allSaab95) {
            s.setTurbo(true);
        }
    }

    /**
     * Turns off Turbo for all Saab95s.
     */
    public void setTurboOff() {
        ArrayList<Saab95> allSaab95 = getAllOfType(Saab95.class);
        for (Saab95 s : allSaab95) {
            s.setTurbo(false);
        }
    }

    /**
     * Adds a new Saab95 to the model.
     * @throws IOException
     */
    public void addCar() throws IOException {
        try {
            if (getAllOfType(Car.class).size() < 10) {
                getVehicles().add(createSaab95());
            }
        }
        catch (IOException e) {
            System.out.print("Can't create new Saab");
        }
    }

    /**
     * Removes a car from the model, according to a FIFO principle.
     */
    public void removeCar(){
        ArrayList<Car> allCars = getAllOfType(Car.class);
            if (allCars.size() != 0) {
                getVehicles().remove(allCars.get(allCars.size() - 1));
            }
    }

}
