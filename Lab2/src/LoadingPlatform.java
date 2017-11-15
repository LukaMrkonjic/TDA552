/**
 * The class LoadingPlatform is a platform that a truck, or the like,
 * can have and uses to load vehicles. The loading platform has an angle with
 * a min and a max value. It also has a boolean instance variable that is true if the
 * angle is zero.
 *
 * @author lukamrkonjic, saralandfors, GustafSpjut
 * @version 1.0
 *
 */
public class LoadingPlatform {
	//instance variables
	private int angle;
	private boolean angleIsZero;
	private int maxAngle;
	private int minAngle;
	double speed;

	/**
	 * This primary, standard constructor doesn't take any inputs
	 * and sets the min and max angle to default values 0 and 90
	 * respectively.
	 */
	public LoadingPlatform(double speed) {
		setAngle(0);
		setMaxAngle(90);
		setMinAngle(0);
		speed = this.speed;
	}

	/**
	 * This secondary constructor takes in value for the min and max
	 * values of the LoadingPlatform and sets them accordingly.
	 *
	 * @param maxAngle  the maximum angle for the LoadingPlatform
	 * @param minAngle  the minimum angle for the LoadingPlatform
	 */
	public LoadingPlatform(double speed, int maxAngle, int minAngle) {
		speed = this.speed;
	    setAngle(0);
		setMaxAngle(maxAngle);
		setMinAngle(minAngle);
	}

	/**
	 * This method sets the max angle of the LoadingPlatform.
	 *
	 * @param maxAngle the maximum angle to be set
	 */
	public void setMaxAngle(int maxAngle) {
		this.maxAngle = maxAngle;
	}

	/**
	 * This method returns the max angle of the LoadingPlatform.
	 *
	 * @return the LoadingPlatform's maximum angle
	 */
	public int getMaxAngle() {
		return maxAngle;
	}

	/**
	 * This method sets the min angle of the LoadingPlatform.
	 *
	 * @param minAngle the min angle to set
	 */
	public void setMinAngle(int minAngle){
		this.minAngle = minAngle;
	}

	/**
	 * This method returns the min angle of the LoadingPlatform.
	 *
	 * @return the min angle of the LoadingPlatform
	 */
	public int getMinAngle() {
		return minAngle;
	}

	/**
	 * This method sets the actual angle of the LoadingPlatform.
	 * It also checks whether the set value is equal to zero.
	 * If it is, the boolean instance variable angleIsZero is also
	 * updated to true.
	 *
	 * @param angle the angle to be set
	 */
	public void setAngle(int angle) {
		if (speed == 0) {
			this.angle = angle;

			if (angle == 0) {
				setAngleIsZero(true);
			}
			else {
				setAngleIsZero(false);
			}

		} else {
			System.out.print("Speed must be 0 if angle is 0.");
		}
	}

	/**
	 * This method returns the current angle of the LoadingPlatform.
	 *
	 * @return the current angle of the LoadingPlatform
	 */
	public int getAngle() {
		return angle;
	}

	/**
	 * This method returns the instance variable that indicates
	 * whether the angle of the LoadingPlatform is zero. This method
	 * can be used by vehicles that have a LoadingPlatform, but cannot
	 * .move() unless the angle of the LoadingPlatform is zero.
	 *
	 * @return the boolean that indicates whether the angle is zero
	 */
	public boolean getAngleIsZero() {
		return angleIsZero;
	}

	/**
	 * This is an auxiliary private method that sets the value of the
	 * boolean that indicates whether the LoadingPlatform's angle is zero.
	 * This method is private so that a user cannot set the value
	 * to true even if the angle is not zero. This method is called by
	 * the setAngle()-method.
	 *
	 * @param b the boolean value of whether the angle of the LoadingPlatform is zero
	 */
	//aux. method that cannot be directly changed, except by the LoadingPlatform itself
	private void setAngleIsZero(boolean b) {
		angleIsZero = b;
	}

}
