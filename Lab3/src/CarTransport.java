import java.awt.*;
import java.awt.geom.Point2D;

/**
 * The CarTransport class act like a general ground based vehicle
 * for transporting vehicles. In other words a truck with vehicle storing functionality.
 *
 * @author LukaMrkonjic
 * @version 1.0
 */
public class CarTransport extends Truck {
		//Instance variables

        final int down = 90;
        final int up = 0;

        VehicleStorage v;

    /**
     * The constructor for a CarTransport sets up a default car transport with
     * a loading platform which has the same speed as the transport and a vehicle storage
     * with a max storage space and a max size per vehicle.
     */
    public CarTransport() {
        setTransportSize(45);
		setMaxStorageSpace(250);
        setPosition(new Point(0,0));
        setDirection(new Point(0,1));
		setLoadingPlatform(new LoadingPlatform(getCurrentSpeed(), down, up));
		getLoadingPlatform().setAngle(up);
		v = new VehicleStorage(getMaxStorageSpace(), 40);
		setIsMoveable(true);
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

	@Override
	public void setPosition(Point position) {
		super.setPosition(position);
		Point2D.Double p = new Point2D.Double(position.getX(), position.getY());
		v.setPosition(p);
	}

    /**
     * Redefines the setCurrentSpeed function so that the loading platform also has a speed factor;
     *
     * @param speed the speed to be set.
     */
    @Override
    public void setCurrentSpeed(double speed) {
        super.setCurrentSpeed(speed);
        getLoadingPlatform().speed = speed;
    }

    /**
     * Adds a chosen vehicle to the vehicle storage.
     *
     * @param vehicle the vehicle which will be added to the vehicle storage
     */
    public void addVehicle(Vehicle vehicle) {
    	if (vehicle.equals(this)) {
    		System.out.print("ERROR: CarTransport cannot add itself!");

    		//TODO: överväg att göra detta till en egen hjälpmetod, t ex private bool vehicleIsLoadable():
		} else if (getCurrentSpeed() == 0 && getLoadingPlatform().getAngleIsZero() && vehicle.getPosition().equals(this.getPosition())) {
            v.addVehicle(vehicle);
        } else {
            System.out.print("Angle and speed must be 0 to load vehicles.");
        }
    }

    /**
     * Removes the last vehicle in the vehicle storage(linked list).
     * In this way the car transport is LIFO(last in first out).
     */
    public void removeVehicle() {
        if (getCurrentSpeed() == 0 && getLoadingPlatform().getAngle() == 90) {
			v.removeVehicle(v.getVehicles().size()-1);
        } else {
            System.out.print("Angle and speed must be 0 to remove vehicles.");
        }
    }

}
