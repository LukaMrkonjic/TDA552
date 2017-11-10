public abstract class Truck extends Vehicle {

	//instance variables
	LoadingPlatform loadingPlatform;            //The truck has a LoadingPlatform


	/**
	 * Overridden method of setting the speed from superclass Transport.
	 * Reason is because it needs to be checked whether the loadingPlatform's
	 * angle is zero before speed can be non-zero.
	 *
	 * @param currentSpeed Current speed to set.
	 */
	@Override
	public void setCurrentSpeed(double currentSpeed) {
		if (loadingPlatform.getAngleIsZero() == false) {
			System.out.println("Cannot move Scania Truck unless angle of LoadingPlatform is zero");
		} else if (currentSpeed < 0) {
			setCurrentSpeed(0);
		} else if (currentSpeed > getEnginePower()) {
			setCurrentSpeed(getEnginePower());
		} else {
			this.setCurrentSpeed(currentSpeed);
		}

	}

}

