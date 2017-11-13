import java.util.AbstractCollection;

/**
 * The class VehicleStorage stores Vehicles in an AbstractCollection and
 * keeps track of the number of vehicles, the space left in the storage,
 * as well as what car should be removed when Remove method is called.
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
	private AbstractCollection<Vehicle> vehicles;

	/**
	 * The constructor for a VehicleStorage takes in a certain number of parameters that are
	 * decided by the Transport that will have a VehicleStorage, such as maxSizeOfOneVehicle,
	 * maxStorageSpace (in sqm), as well as an AbstractCollection to store the Vehicles in.
	 *
	 * The AbstractCollection will determine what behavior the VehicleStorage will have
	 * when vehicles are added or removed (for example FIFO for Queue and LIFO for Stack).
	 * (In other words, polymorphism is utilized in order to keep code duplication to a minimum)
	 *
	 * @param maxStorageSpace is the max number of sqm that the VehicleStorage can load with Vehicles
	 * @param maxSizeOfOneVehicle is the max size of one vehicle to be loaded onto the storage
	 * @param vehicles is the abstract collection that will hold the vehicles
	 */
	public VehicleStorage(double maxStorageSpace, double maxSizeOfOneVehicle, AbstractCollection<Vehicle> vehicles) {
		setMaxStorageSpace(maxStorageSpace);
		setMaxSizeOfOneVehicle(maxSizeOfOneVehicle);
		setVehicles(vehicles);
	}

	/**
	 * @return the AbstractCollection that keeps track of the vehicles loaded
	 * 	onto the VehicleStorage
	 */
	public AbstractCollection<Vehicle> getVehicles() {
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
	public void setVehicles(AbstractCollection<Vehicle> vehicles) {
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

	public int getVehicleCount() {
		return vehicleCount;
	}

	public void setVehicleCount(int vehicleCount) {
		this.vehicleCount = vehicleCount;
	}

	public void addVehicle(Vehicle v) {
		if (vehicleIsSmallerThanMaxSize(v) && vehicleFitsInCurrentSpaceLeft(v)) {
				vehicles.add(v);
				vehicleCount++;
				setCurrentStorageSpaceLeft(getCurrentStorageSpaceLeft() - v.getTransportSize());
		} else {
			System.out.println("Can't load vehicles of specified size onto this VehicleStorage. Max size of one" +
								" vehicle is set to " + getMaxSizeOfOneVehicle() + " and current available space" +
								" is " + getCurrentStorageSpaceLeft() + ".");
		}
		//TODO: change println to catch/throw error
	}

	public void removeVehicle(Vehicle v) {
		if (vehicles.size() != 0) {
			vehicles.remove(v);
			vehicleCount--;
			setCurrentStorageSpaceLeft(getCurrentStorageSpaceLeft() + v.getTransportSize());
		} else {
			System.out.println("There are no more vehicles to remove");
			//TODO: change println to catch/throw error
		}
	}


	private boolean vehicleIsSmallerThanMaxSize(Vehicle v) {
		return (v.getTransportSize() <= maxSizeOfOneVehicle);
	}

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
