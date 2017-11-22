public abstract class Truck extends Vehicle {

	//instance variables
	private LoadingPlatform loadingPlatform;            //The truck has a LoadingPlatform


	/**
	 * @param loadingPlatform the LoadingPlatform to be set for the truck
	 */
	public void setLoadingPlatform(LoadingPlatform loadingPlatform) {
		this.loadingPlatform = loadingPlatform;
	}

	public LoadingPlatform getLoadingPlatform() {
		return loadingPlatform;
	}

	/**
	 * Overridden method of setting the speed from superclass Transport.
	 * Reason is because it needs to be checked whether the loadingPlatform's
	 * angle is zero before speed can be non-zero.
	 *
	 * @param currentSpeed Current speed to set.
	 */
	@Override
	public void setCurrentSpeed(double currentSpeed) {
		if (getLoadingPlatform().getAngleIsZero() == false) {
			System.out.println("Cannot move  Truck unless angle of LoadingPlatform is zero");
		} else if (currentSpeed < 0) {
			setCurrentSpeed(0);
		} else if (currentSpeed > getEnginePower()) {
			setCurrentSpeed(getEnginePower());
		} else {
			super.setCurrentSpeed(currentSpeed);
			//this.setCurrentSpeed(currentSpeed);
		}
	}

	@Override
	public void move() {
		if (loadingPlatform.getAngleIsZero()) {
			super.move();
		}
	}

}

