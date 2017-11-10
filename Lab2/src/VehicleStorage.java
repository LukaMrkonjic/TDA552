import java.util.AbstractCollection;

public class VehicleStorage {


	//Instance variables
	private double maxStorageSpace;
	private double currentStorageSpaceLeft;
	private double maxSizeOfOneVehicle;
	private int vehicleCount;
	private AbstractCollection<Vehicle> vehicles;

	public VehicleStorage(double maxStorageSpace, double maxSizeOfOneVehicle, AbstractCollection<Vehicle> vehicles) {
		setMaxStorageSpace(maxStorageSpace);
		setMaxSizeOfOneVehicle(maxSizeOfOneVehicle);
		setVehicles(vehicles);
	}

	public AbstractCollection<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(AbstractCollection<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}


	public double getMaxStorageSpace() {
		return maxStorageSpace;
	}

	public void setMaxStorageSpace(double maxStorageSpace) {
		this.maxStorageSpace = maxStorageSpace;
	}

	public double getCurrentStorageSpaceLeft() {
		return currentStorageSpaceLeft;
	}

	public void setCurrentStorageSpaceLeft(double currentStorageSpaceLeft) {
		this.currentStorageSpaceLeft = currentStorageSpaceLeft;
	}

	public double getMaxSizeOfOneVehicle() {
		return maxSizeOfOneVehicle;
	}

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

	//TODO: create removeVehicle

	private boolean vehicleIsSmallerThanMaxSize(Vehicle v) {
		return (v.getTransportSize() <= maxSizeOfOneVehicle);
	}

	private boolean vehicleFitsInCurrentSpaceLeft(Vehicle v) {
		return (v.getTransportSize() <= getCurrentStorageSpaceLeft());
	}


}
