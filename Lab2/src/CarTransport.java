
/**
 * The CarTransport class act like a general ground based vehicle
 * for transporting vehicles. In other words a truck with vehicle storing functionality.
 *
 * @author LukaMrkonjic
 * @version 1.0
 */
public class CarTransport extends Truck {

        LoadingPlatform loadingPlatform;
        int maxStorageSpace;
        int maxSizeOfOneVehicle;
        final int down = 0;
        final int up = 90;
        VehicleStorage v;

    /**
     * The constructor for a CarTransport sets up a default cartransport with
     * a loading platform which has the same speed as the transport and a vehicle storage
     * with a max storage space and a max size per vehicle.
     */
    public CarTransport() {
            maxStorageSpace = 250;
            maxSizeOfOneVehicle = 50;
            loadingPlatform = new LoadingPlatform(getCurrentSpeed());
            setLoadingPlatform(loadingPlatform, up);
            v = new VehicleStorage(maxStorageSpace, maxSizeOfOneVehicle);
    }

    /**
     * Redefines the move function which is inherited from the Transport abstract class.
     * This method override moves the car transport in a direction while also moving
     * the vehicle storage and it's stored cars.
     */
    @Override
    public void move() {
        super.move();
        v.setPosition(this.getPosition());
    }

    //TODO: Overload the setAngle method instead of creating a new one(this method)
    /**
     * Sets a chosen angle for the loading platform which in this case
     * only can be up(90 degrees) or down(0 degrees). Note that the car transport
     * needs to be still(0 mph) for the platform to be lowered down.
     *
     * @param loadingPlatform the car transports loading platform
     * @param angle the angle which is going to be set for the loading platform
     */
    public void setLoadingPlatform(LoadingPlatform loadingPlatform, int angle) {
        if (angle == 0 && getCurrentSpeed() == 0) {
            loadingPlatform.setAngle(down);
        } else {
            loadingPlatform.setAngle(up);

        }
    }

    /**
     * Adds a chosen vehicle to the vehicle storage.
     *
     * @param vehicle the vehicle which will be added to the vehicle storage
     */
    public void addVehicle(Vehicle vehicle) {
        v.addVehicle(vehicle);
    }

    /**
     * Removes the last vehicle in the vehicle storage(linked list).
     * In this way the car transport is LIFO(last in first out).
     */
    public void removeVehicle() {
        v.removeVehicle(v.getVehicles().size()-1);
    }

}
