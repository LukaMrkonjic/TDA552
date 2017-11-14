import java.util.Stack;

public class CarTransport extends Truck {

    LoadingPlatform loadingPlatform;

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

        loadingPlatform = new LoadingPlatform();
        setLoadingPlatform(loadingPlatform, up);
        VehicleStorage v = new VehicleStorage(maxStorageSpace, 50, vehicles);
    }

    //TODO: Overload the setAngle method instead of creating a new one(this method)
    public void setLoadingPlatform(LoadingPlatform loadingPlatform, int angle) {
        if (angle == 0 && getCurrentSpeed() == 0) {
            loadingPlatform.setAngle(down);
        } else {
            loadingPlatform.setAngle(angle);

        }
    }

}
