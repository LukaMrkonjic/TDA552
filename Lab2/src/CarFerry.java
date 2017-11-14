import java.awt.*;
import java.util.AbstractQueue;
import java.util.LinkedList;
import java.util.Queue;

public class CarFerry extends Ferry {

    LoadingPlatform loadingPlatform;

    public CarFerry() {
        LinkedList<Vehicle> vehicles = new LinkedList<Vehicle>();
        double maxStorageSpace = 1000;
        loadingPlatform = new LoadingPlatform();
        VehicleStorage v = new VehicleStorage(maxStorageSpace, 50, vehicles);
    }

}
