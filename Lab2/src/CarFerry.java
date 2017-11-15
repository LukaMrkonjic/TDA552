import java.awt.geom.Point2D;

public class CarFerry extends Ferry {

    LoadingPlatform loadingPlatform;
    int maxSizeOfOneVehicle;
    double maxStorageSpace;
    final int down = 90;
    final int up = 0;
    VehicleStorage v;

    public CarFerry() {
        maxStorageSpace = 1000;
        maxSizeOfOneVehicle = 80;
        loadingPlatform = new LoadingPlatform(getCurrentSpeed());
        loadingPlatform.setAngle(up);
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

    /**
     * Redefines the setCurrentSpeed function so that the loading platform also has a speed factor;
     *
     * @param speed the speed to be set.
     */
    @Override
    public void setCurrentSpeed(double speed) {
        super.setCurrentSpeed(speed);
        loadingPlatform.speed = speed;
    }

    /**
     * Adds a chosen vehicle to the vehicle storage.
     *
     * @param vehicle the vehicle which will be added to the vehicle storage
     */
    public void addVehicle(Vehicle vehicle) {
        if (getCurrentSpeed() == 0 && loadingPlatform.getAngle() == 90 && vehicle.getPosition() == this.getPosition()) {
            v.addVehicle(vehicle);
        } else {
            System.out.print("Angle and speed must be 0 to load vehicles.");
        }
    }

    /**
     * Removes the last vehicle in the vehicle storage(linked list).
     * In this way the car transport is FIFO(first in first out).
     */
    public void removeVehicle() {
        if (getCurrentSpeed() == 0 && loadingPlatform.getAngle() == 90) {
            Vehicle removedVehicle = v.removeVehicle(0);
            removedVehicle.setPosition(new Point2D.Double(getPosition().getX(), getPosition().getY()));
        } else {
            System.out.print("Angle and speed must be 0 to remove vehicles.");
        }
    }

}