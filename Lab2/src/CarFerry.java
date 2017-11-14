import java.awt.*;
import java.util.AbstractQueue;
import java.util.LinkedList;
import java.util.Queue;

public class CarFerry extends Ferry {

    LoadingPlatform loadingPlatform;
    int maxSizeOfOneVehicle;
    VehicleStorage v;

    public CarFerry() {
        maxSizeOfOneVehicle = 80;
        double maxStorageSpace = 1000;
        loadingPlatform = new LoadingPlatform(getCurrentSpeed());
        v = new VehicleStorage(maxStorageSpace, maxSizeOfOneVehicle);
    }

    public void addVehicle(Vehicle vehicle) {
        v.addVehicle(vehicle);
    }

    public void removeVehicle() {
        v.removeVehicle(0);
    }

    @Override
    public void move() {
        super.move();
        v.setPosition(this.getPosition());
    }

}