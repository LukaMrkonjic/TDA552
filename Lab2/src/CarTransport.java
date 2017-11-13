import java.util.Stack;

public class CarTransport extends Truck {

    LoadingPlatform loadingPlatform;
    private int up = 90;
    private int down = 0;

    public CarTransport() {
        Stack vehicles = new Stack();
        double maxStorageSpace = 100;
        loadingPlatform.setAngle(up);
        loadingPlatform = new LoadingPlatform();
        VehicleStorage v = new VehicleStorage(maxStorageSpace, 50, vehicles);
    }

    public void setPlatform(int i) {
        if (i == up) {
            loadingPlatform.setAngle(up);
        }
        else if (i == down && getCurrentSpeed() == 0) {
            loadingPlatform.setAngle(down);
        }
        else {
            System.out.println("Platform must be up or down.");
        }
    }

}
