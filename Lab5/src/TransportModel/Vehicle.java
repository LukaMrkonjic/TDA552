package TransportModel;

import java.awt.image.BufferedImage;

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


	public void startIfCars(){

	}
	public void stopIfCars(){

	}
	public void liftBed(){

	}

	public void lowerBed() {

	}

	public void setBed(boolean b){

	}

	public void setTurbo(boolean b){

	}

	public void setLoadingPlatform(boolean b){

	}

}
