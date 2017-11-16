
import java.awt.geom.Point2D;
import java.util.LinkedList;

/**
 * The class VehicleStorage stores Vehicles in an LinkedList and
 * keeps track of the number of vehicles and the space left in the storage.
 *
 *
 * @author SaraLandfors
 * @version 1.0
 */
public class VehicleStorage {

	//Instance variables
	private double maxStorageSpace;
	private double currentStorageSpaceLeft;
	private double maxSizeOfOneVehicle;
	private int vehicleCount;
	private LinkedList<Vehicle> vehicles;
	private Point2D.Double position;

	/**
	 * The constructor for a VehicleStorage takes in a certain number of parameters that are
	 * decided by the Transport that will have a VehicleStorage, such as maxSizeOfOneVehicle,
	 * maxStorageSpace (in sqm).
	 *
	 *
	 * @param maxStorageSpace is the max number of sqm that the VehicleStorage can load with Vehicles
	 * @param maxSizeOfOneVehicle is the max size of one vehicle to be loaded onto the storage
	 */
	public VehicleStorage(double maxStorageSpace, double maxSizeOfOneVehicle) {
		setMaxStorageSpace(maxStorageSpace);
		setMaxSizeOfOneVehicle(maxSizeOfOneVehicle);
		setVehicles(new LinkedList<Vehicle>());
	}

	/**
	 *
	 * @return the current position of the VehicleStorage.
	 */
	public Point2D.Double getPosition() {
		return position;
	}

	/**
	 * This method updates the position of the VehicleStorage
	 * and loops through all the vehicles in the storage and
	 * updates their positions.
	 *
	 * @param p the position to set
	 */
	public void setPosition(Point2D.Double p) {
		this.position = p;
		for (Vehicle v : getVehicles()) {
			v.setPosition(p);
		}
	}

	/**
	 * @return the AbstractCollection that keeps track of the vehicles loaded
	 * 	onto the VehicleStorage
	 */
	public LinkedList<Vehicle> getVehicles() {
		return vehicles;
	}

	/**
	 *
	 * @param vehicles sets the AbstractCollection that keeps track
	 *                 of the Vehicles on the VehicleStorage. This parameter
	 *                 will determine the behavior of the addVehicle and removeVehicle
	 *                 methods, as they will behave differently for say a Stack and a
	 *                 Queue which are both subclasses of AbstractCollection
	 */
	public void setVehicles(LinkedList<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}


	/**
	 * @return the maximun storage space of the VehicleStorage
	 */
	public double getMaxStorageSpace() {
		return maxStorageSpace;
	}

	/**
	 * This method updates the maxStorageSpace of the VehicleStorage, but first,
	 * it checks whether the newMaxStorageSpace is smaller than the space currently
	 * used by the stored vehicles. If it is smaller, the method prints an error message.
	 * If it is larger than the space currently used, the maxStorageSpace is updated AND the
	 * currentStorageSpaceLeft is updated correspondingly.
	 *
	 * @param newMaxStorageSpace the new maximum storage space of the VehicleStorage
	 *
	 */
	public void setMaxStorageSpace(double newMaxStorageSpace) {
		if (newStorageSpaceSmallerThanCurrentlyUsedSpace(newMaxStorageSpace)) {
			System.out.println("Remove vehicles before decreasing maxStorageSpace.");
		} else {
			currentStorageSpaceLeft = computeNewStorageSpaceLeft(newMaxStorageSpace);
			this.maxStorageSpace = newMaxStorageSpace;
		}
	}

	/**
	 *
	 * @return the storageSpace left on the VehicleStorage, which is necessary
	 * to know when deciding whether an additional Vehicle can be added to the
	 * Storage or not.
	 */
	public double getCurrentStorageSpaceLeft() {
		return currentStorageSpaceLeft;
	}

	/**
	 *
	 * @param currentStorageSpaceLeft sets the currentStorageSpaceLeft to a new
	 *                                value. This method is private, because it can
	 *                                only be used indirectly by removing or adding a Vehicle
	 *                                to the storage.
	 */
	private void setCurrentStorageSpaceLeft(double currentStorageSpaceLeft) {
		this.currentStorageSpaceLeft = currentStorageSpaceLeft;
	}

	/**
	 *
	 * @return max size of one vehicle for the particular instance of the VehicleStorage
	 */
	public double getMaxSizeOfOneVehicle() {
		return maxSizeOfOneVehicle;
	}

	/**
	 *
	 * @param maxSizeOfOneVehicle the max size to be set as the maximum
	 *                            size of one vehicle on the VehicleStorage
	 */
	public void setMaxSizeOfOneVehicle(double maxSizeOfOneVehicle) {
		this.maxSizeOfOneVehicle = maxSizeOfOneVehicle;
	}

	/**
	 *
	 * @return the number of vehicles currently on the VehicleStorage
	 */
	public int getVehicleCount() {
		return vehicleCount;
	}

	/**
	 * Sets the number of vehicles on the VehicleStorage. Method
	 * is private, because method should only be called by adding
	 * or removing vehicles, or by constructor.
	 *
	 * @param vehicleCount the number of vehicles to be set on the VehicleStorage
	 */
	private void setVehicleCount(int vehicleCount) {
		this.vehicleCount = vehicleCount;
	}

	/**
	 * This method adds a vehicle to the VehicleStorage if there is room for
	 * the vehicle, and if the vehicle is not larger than the maximum size of one
	 * vehicle. It also updates the numberOfVehicles.
	 *
	 * @param v the vehicle to be added
	 */
	public void addVehicle(Vehicle v) {
		if (vehicleIsSmallerThanMaxSize(v) && vehicleFitsInCurrentSpaceLeft(v)) {
			vehicles.add(v);
			vehicleCount++;
			setCurrentStorageSpaceLeft(getCurrentStorageSpaceLeft() - v.getTransportSize());
			v.setIsMoveable(false);
		} else {
			System.out.println("Can't load vehicles of specified size onto this VehicleStorage. Max size of one" +
					" vehicle is set to " + getMaxSizeOfOneVehicle() + " and current available space" +
					" is " + getCurrentStorageSpaceLeft() + ".");
		}
		//TODO: change println to catch/throw error
	}

	/**
	 * This method removes a vehicle at the index specified
	 * by the method call.
	 *
	 * @param i the index of the vehicle to be removed
	 */
	public void removeVehicle(int i) {
		if (vehicles.size() != 0) {
			Vehicle v = vehicles.remove(i);
			vehicleCount--;
			setCurrentStorageSpaceLeft(getCurrentStorageSpaceLeft() + v.getTransportSize());

			double newX, newY;
			newX = getPosition().getX() - 10;
			newY = getPosition().getY() - 10;
			v.setPosition(new Point2D.Double(newX, newY));
			v.setIsMoveable(true);
		} else {
			System.out.println("There are no more vehicles to remove");
			//TODO: change println to catch/throw error

		}
	}


	/**
	 * This method checks whether the vehicle to be added is smaller than
	 * the max size of one vehicle for the vehicle storage.
	 *
	 * @param v the vehicle to check size of
	 * @return a boolean that is true if the vehicle can be added
	 * to the VehicleStorage, and false otherwise
	 */
	private boolean vehicleIsSmallerThanMaxSize(Vehicle v) {
		return (v.getTransportSize() <= maxSizeOfOneVehicle);
	}

	/**
	 * This method checks if a new vehicle fits in the space that's left
	 * in the Vehicle Storage.
	 *
	 * @param v the vehicle to check whether it fits in the remaining space
	 * @return a boolean that is true if the vehicle does fit, and false
	 * otherwise
	 */
	private boolean vehicleFitsInCurrentSpaceLeft(Vehicle v) {
		return (v.getTransportSize() <= getCurrentStorageSpaceLeft());
	}

	/**
	 * Auxiliary method to help setMaxStorageSpace decide whether the new
	 * maxStorageSpace is allowed, or whether it is smaller than the space
	 * currently used by the vehicles on the VehicleStorage.
	 *
	 * @param newStorageSpace the new value for maxStorageSpace
	 * @return true if the newStorageSpace is smaller than the space currently used,
	 * 			false if there is no such problem.
	 */
	private boolean newStorageSpaceSmallerThanCurrentlyUsedSpace(double newStorageSpace) {
		return (newStorageSpace < (this.maxStorageSpace - currentStorageSpaceLeft));
	}

	/**
	 * Auxiliary method for setMaxStorageSpace that helps compute and return the new
	 * value for the currentStorageSpaceLeft-variable. Private because it will only be
	 * used by another method within the class.
	 *
	 * @param newStorageSpace the updated MaxStorageSpace on which the currentSpaceLeft will depend
	 * @return the computed new value for the currentStorageSpaceLeft
	 */
	private double computeNewStorageSpaceLeft(double newStorageSpace) {
		double newStorageSpaceLeft;
		newStorageSpaceLeft = currentStorageSpaceLeft - (this.getMaxStorageSpace() - newStorageSpace);
		return newStorageSpaceLeft;
	}

}