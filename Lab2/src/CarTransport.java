import java.util.LinkedList;
import java.util.Stack;

public class CarTransport extends Truck {

        LoadingPlatform loadingPlatform;
        int maxStorageSpace;
        int maxSizeOfOneVehicle;
        final int down = 0;
        final int up = 90;
        VehicleStorage v;

    public CarTransport() {
            maxStorageSpace = 250;
            maxSizeOfOneVehicle = 50;
            loadingPlatform = new LoadingPlatform(getCurrentSpeed());
            setLoadingPlatform(loadingPlatform, up);
            v = new VehicleStorage(maxStorageSpace, maxSizeOfOneVehicle);
    }

    @Override
    public void move() {
        super.move();
            v.setPosition(this.getPosition());
    }

    //TODO: Overload the setAngle method instead of creating a new one(this method)
    public void setLoadingPlatform(LoadingPlatform loadingPlatform, int angle) {
        if (angle == 0 && getCurrentSpeed() == 0) {
            loadingPlatform.setAngle(down);
        } else {
            loadingPlatform.setAngle(angle);

        }
    }

    public void addVehicle(Vehicle vehicle) {
        v.addVehicle(vehicle);
    }

    public void removeVehicle() {
        v.removeVehicle(v.getVehicles().size());
    }

}
