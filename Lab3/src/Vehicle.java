
public abstract class Vehicle extends Transport {
	// instance variables
	private int nrDoors; // Number of doors on the car

	/**
	 * @return number of car doors.
	 */
	public int getNrDoors() {
		return nrDoors;
	}

	/**
	 * @param nrDoors Number of doors to set.
	 */
	public void setNrDoors(int nrDoors) {
		this.nrDoors = nrDoors;
	}
}
