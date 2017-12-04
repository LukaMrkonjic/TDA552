import java.awt.*;
import java.awt.geom.Point2D;

public class CarFerry extends Ferry {

    //instance variables
    LoadingPlatform loadingPlatform;
    final int down = 90;
    final int up = 0;
    private VehicleStorage v;


    /**
     * Constructor for CarFerry.
     */
    public CarFerry() {

        setPosition(new Point(0, 0));
        setDirection(new Point(0, 1));
        loadingPlatform = new LoadingPlatform(getCurrentSpeed(), down, up);
        loadingPlatform.setAngle(up);
        setMaxStorageSpace(1000);
        setVehicleStorage(new VehicleStorage(getMaxStorageSpace(), 80));
        setIsMoveable(true);
    }

    public LoadingPlatform getLoadingPlatform() {
        return loadingPlatform;
    }

    public void setLoadingPlatform(LoadingPlatform loadingPlatform) {
        this.loadingPlatform = loadingPlatform;
    }

    public VehicleStorage getVehicleStorage() {
        return v;
    }

    public void setVehicleStorage(VehicleStorage v) {
        this.v = v;
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

    @Override
	public void setPosition(Point position) {
    	super.setPosition(position);
		Point2D.Double p = new Point2D.Double(position.getX(), position.getY());
		//v.setPosition(p);
        if (v != null) {
            v.setPosition(p);
        }
	}

    /**
     * Adds a chosen vehicle to the vehicle storage.
     *
     * @param vehicle the vehicle which will be added to the vehicle storage
     */
    public void addVehicle(Vehicle vehicle) {
        if (vehicle.equals(this)) {
            System.out.print("ERROR: CarFerry cannot add itself!");

            //TODO: överväg att göra detta till en egen hjälpmetod, t ex private bool vehicleIsLoadable():
        } else if (getCurrentSpeed() == 0 && loadingPlatform.getAngleIsZero() && vehicle.getPosition().equals(this.getPosition())) {
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
            v.removeVehicle(0);
        } else {
            System.out.print("Angle and speed must be 0 to remove vehicles.");
        }
    }

}