package car;

import java.awt.*;

/**
 * This class is a subclass of Car that represents a Scania truck.
 * It has a loading platform.
 */
public class Scania extends Car {

    private double platformAngle;

    /**
     * Calls the super class constructor and
     * sets the specifications to those of a Scania truck.
     */
    public Scania(String imagePath) {
        super(2, 90, Color.RED, "Scania", imagePath);
    }

    @Override
    public void startEngine() {
        if (allowDriving()) {
            super.startEngine();
        }
    }

    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01;
    }

    @Override
    protected void incrementSpeed(double amount) {
        if (allowDriving()) {
            super.incrementSpeed(amount);
        }
    }

    private boolean allowDriving() {
        return platformAngle == 0;
    }

    /**
     * Returns the loading platform angle.
     *
     * @return The angle.
     */
    public double getPlatformAngle() {
        return platformAngle;
    }

    /**
     * Sets the loading platform angle (in the range [0, 70])
     * if the truck is not moving.
     *
     * @param angle The new angle.
     */
    public void setPlatformAngle(double angle) {
        if (!isMoving()) {
            if (0 <= angle && angle <= 70) {
                platformAngle = angle;
            }
        }
    }

}
