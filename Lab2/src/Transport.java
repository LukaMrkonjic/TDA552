import java.awt.*;
import java.awt.geom.Point2D;

public abstract class Transport implements Movable {

    //instance variables
    private Point2D.Double position;
    private Point direction;
    private double speedFactor;
    private double enginePower; // Engine power of the transport
    private double currentSpeed; // The current speed of the transport
    private Color color; // Color of the transport
    private String modelName; // The transport model name
	private double transportSize;
	private double storageSpace;
    private double maxStorageSpace;
    //TODO: Create a transportSize instance variable to be used by the vehicles that load on vehicles?


    public double getMaxStorageSpace() {
        return maxStorageSpace;
    }

    public void setMaxStorageSpace(double maxStorageSpace) {
        this.maxStorageSpace = maxStorageSpace;
    }

    /**
     * @return the current position.
     */
    public Point2D.Double getPosition() {
        return position;
    }

    /**
     *
     * @return the size of the vehicle
     */
    public double getTransportSize() {
        return transportSize;
    }

    /**
     *
     * @param transportSize size of object
     */
    public void setTransportSize(double transportSize) {
        this.transportSize = transportSize;
    }

    /**
     *
     * @param storageSpace available storage space
     */
    public void setStorageSpace(double storageSpace) {
        this.storageSpace = storageSpace;
    }

    /**
     *
     * @return the remaining storage space
     */
    public double getStorageSpace() {
        return storageSpace;
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
     * @param enginePower Engine power to set.
     */
    public void setEnginePower(double enginePower) {
        this.enginePower = enginePower;
    }

    /**
     * @return transport model name.
     */
    public String getModelName() {
        return modelName;
    }

    /**
     * @param modelName Transport's model name to set.
     */
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    /**
     * @return engine power.
     */
    public double getEnginePower() {
        return enginePower;
    }

    /**
     * @return current transport speed.
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
     * @return transport color.
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
     * Method that moves the transport in its current direction, and updates
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
     * Checks which direction is the transport's current direction:
     * (0, 1) = North
     * (1, 0) = East
     * (0, -1) = South
     * (-1, 0) = West
     * <p>
     * and then updates the direction to to one the transport would have after a right-turn.
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
     * Checks which direction is the transport's current direction:
     * (0, 1) = North
     * (1, 0) = East
     * (0, -1) = South
     * (-1, 0) = West
     * <p>
     * and then updates the direction to to one the transport would have after a left-turn.
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


