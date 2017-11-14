import java.awt.*;
import java.util.AbstractQueue;
import java.util.LinkedList;
import java.util.Queue;

public class CarFerry extends Ferry {

    LoadingPlatform loadingPlatform;
    int maxSizeOfOneVehicle;

    public CarFerry() {
        maxSizeOfOneVehicle = 80;
        LinkedList<Vehicle> vehicles = new LinkedList<>();
        double maxStorageSpace = 1000;
        loadingPlatform = new LoadingPlatform(getCurrentSpeed());
        VehicleStorage v = new VehicleStorage(maxStorageSpace, maxSizeOfOneVehicle, vehicles);
    }

}