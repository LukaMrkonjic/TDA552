import java.util.Stack;

public class CarTransport extends Truck {

    LoadingPlatform loadingPlatform;
    private final int up = 90;
    private final int down = 0;

    public CarTransport() {
        Stack vehicles = new Stack();
        double maxStorageSpace = 100;
        loadingPlatform = new LoadingPlatform();
        loadVehicles(loadingPlatform, up);
        VehicleStorage v = new VehicleStorage(maxStorageSpace, 50, vehicles);
    }

    //TODO: Overload the setAngle method instead of creating a new one(this method)
    public void loadVehicles(LoadingPlatform loadingPlatform, int angle) {
        if (angle == 0 && getCurrentSpeed() == 0) {
            loadingPlatform.setAngle(down);
        } else {
            loadingPlatform.setAngle(angle);
        }
    }

}
