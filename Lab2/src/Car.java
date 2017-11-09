import java.awt.*;
import java.awt.geom.Point2D;


/**
 * The following class serves as a default, abstract class for a car.
 * A car has a set of variables defining numerous factors such as speed, number or doors etc.
 * It also has getters and setters for all listed variables.
 *
 * @author lukamrkonjic, saralandfors, GustafSpjut
 *
 */
public abstract class Car implements Movable {

    // instance variables
    private Point2D.Double position;
    private Point direction;s
    private double speedFactor;
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name

    /**
     * @return the current position.
     */
    public Point2D.Double getPosition() {
        return position;
    }

    /**
     * @param position position to set, as a Point.
     */
    public void setPosition(Point position) {
    	Point2D.Double p = new Point2D.Double(position.getX(), position.getY());
        this.position = p;
    }

	/**
	 * @param position to set, as a Point2D.Double.
	 */

	public void setPosition(Point2D.Double position) {
    	this.position = position;
	}

    /**
     * @return current direction as a vector in (x,y), where x and
     * y take on values between -1 and 1.
     */
    public Point getDirection() {
        return direction;
    }

    /**
     * @param direction direction to set.
     */
    public void setDirection(Point direction) {
        this.direction = direction;
    }

    /**
     * @return car speedfactor.
     */
    public double getSpeedFactor() {
        return speedFactor;
    }

    /**
     * @param speedFactor speedfactor to set.
     */
    public void setSpeedFactor(double speedFactor) {
        if (speedFactor < 0) {
            System.out.println("speedFactor must be a double equal to or larger than 0");
        } else {
            this.speedFactor = speedFactor;
        }
    }

    /**
     * @param nrDoors Number of doors to set.
     */
    public void setNrDoors(int nrDoors) {
        this.nrDoors = nrDoors;
    }

    /**
     * @param enginePower Engine power to set.
     */
    public void setEnginePower(double enginePower) {
        this.enginePower = enginePower;
    }

    /**
     * @return car model name.
     */
    public String getModelName() {
        return modelName;
    }

    /**
     * @param modelName Cars model name to set.
     */
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    /**
     * @return number of car doors.
     */
    public int getNrDoors() {
        return nrDoors;
    }

    /**
     * @return engine power.
     */
    public double getEnginePower() {
        return enginePower;
    }

    /**
     * @return current car speed.
     */
    public double getCurrentSpeed() {
        return currentSpeed;
    }

    /**
     * @param currentSpeed Current speed to set.
     */
    public void setCurrentSpeed(double currentSpeed) {
		if (currentSpeed < 0) {
			setCurrentSpeed(0);
		} else if (currentSpeed > getEnginePower()) {
			setCurrentSpeed(getEnginePower());
		} else {
			this.currentSpeed = currentSpeed;
		}
	}

    /**
     * @return car color.
     */
    public Color getColor() {
        return color;
    }

    /**
     * @param clr Color to set.
     */
    public void setColor(Color clr) {
        color = clr;
    }

    /**
     * Starts engine and sets current speed to 0.1.
     */
    public void startEngine() {
        setCurrentSpeed(0.1);
    }

    /**
     * Stops engine and sets current speed to 0.
     */
    public void stopEngine() {
    	setCurrentSpeed(0);
    }

    /**
     * Increments speed with a variable amount.
     */
    public void incrementSpeed(double amount) {
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor * amount, enginePower);
    }

    /**
     * Decrements speed with a variable amount.
     */
    public void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor * amount, 0);
    }

    public void gas(double amount) {
        if (amount < 0 || amount > 1) {
            //TODO: create exception instead???
            System.out.println("Method gas() must be called with parameter between 0 and 1, inclusive");
        } else {
            incrementSpeed(amount);
        }
    }

    public void brake(double amount) {
        decrementSpeed(amount);
    }

    /**
     * Method that moves the Volvo240 in its current direction, and updates
     * its position. The distance it's moved depends on its current speed.
     */
    public void move() {
        double x, y;
        x = getPosition().getX();
        y = getPosition().getY();

        x = x + getCurrentSpeed() * getDirection().getX();
        y = y + getCurrentSpeed() * getDirection().getY();

        Point2D.Double newPosition = new Point2D.Double(x, y);
        setPosition(newPosition);
    }

    /**
     * Checks which direction is the vehicle's current direction:
     * (0, 1) = North
     * (1, 0) = East
     * (0, -1) = South
     * (-1, 0) = West
     * <p>
     * and then updates the direction to to one the vehicle would have after a right-turn.
     */
    public void turnRight() {
        if (getDirection().getX() == 0 && getDirection().getY() == 1) {            //Check North
            getDirection().setLocation(1, 0);
        } else if (getDirection().getX() == 1 && getDirection().getY() == 0) {     //Check East
            this.getDirection().setLocation(0, -1);
        } else if (getDirection().getX() == 0 && getDirection().getY() == -1) {    //Check South
            this.getDirection().setLocation(-1, 0);
        } else if (getDirection().getX() == -1 && getDirection().getY() == 0) {    //Check West
            this.getDirection().setLocation(0, 1);
        } else {
            //TODO: implement error if direction is any other direction than North, East, South, West
        }
    }

    /**
     * Checks which direction is the vehicle's current direction:
     * (0, 1) = North
     * (1, 0) = East
     * (0, -1) = South
     * (-1, 0) = West
     * <p>
     * and then updates the direction to to one the vehicle would have after a left-turn.
     */
    public void turnLeft() {
        if (getDirection().getX() == 0 && getDirection().getY() == 1) {            //Check North
            getDirection().setLocation(-1, 0);
        } else if (getDirection().getX() == 1 && getDirection().getY() == 0) {     //Check East
            getDirection().setLocation(0, 1);
        } else if (getDirection().getX() == 0 && getDirection().getY() == -1) {    //Check South
			getDirection().setLocation(1, 0);
        } else if (getDirection().getX() == -1 && getDirection().getY() == 0) {    //Check West
			getDirection().setLocation(0, -1);
		} else {
        	//TODO: Fix for case of invalid direction
		}
    }
}
