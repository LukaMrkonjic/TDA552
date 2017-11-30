package car;

import enums.Direction;
import interfaces.Drawable;
import interfaces.Movable;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * This class has a combination of abstract and non-abstract methods.
 * It defines the core features of a car.
 */
public abstract class Car implements Movable, Drawable {

    /**
     * The direction the car is facing.
     */
    private Direction direction;

    /**
     * The car's x-position.
     */
    private double x;

    /**
     * The car's y-position.
     */
    private double y;

    /**
     * Number of doors on the car.
     */
    private final int nrDoors;

    /**
     * Engine power of the car.
     */
    private final double enginePower;

    /**
     * The current speed of the car.
     */

    private double currentSpeed;

    /**
     * Color of the car.
     */
    private final Color color;

    /**
     * The car model name.
     */
    private final String modelName;

    private BufferedImage image;

    /**
     * Sets the initial direction to NORTH and calls <code>stopEngine()</code>.
     * It initializes the number of doors,
     * the engine power, the color of the car and the model name.
     *
     * @param nrDoors     The number of doors.
     * @param enginePower The engine power.
     * @param color       The color of the car.
     * @param modelName   The model name.
     * @param imagePath   The path to the image which will represent this car in the GUI.
     */
    public Car(int nrDoors, double enginePower, Color color, String modelName, String imagePath) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;

        direction = Direction.EAST;
        stopEngine();

        try {
            image = ImageIO.read(new File(imagePath));
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    /**
     * Sets the initial direction to NORTH and calls <code>stopEngine()</code>.
     * It sets default values for the number of doors,
     * the engine power, the color of the car and the model name.
     */
    public Car() {
        this(4, 100, Color.RED, "Car", "res\\Volvo240.jpg");
    }

    /**
     * Returns the number of doors.
     *
     * @return The number of doors.
     */
    public int getNrDoors() {
        return nrDoors;
    }


    /**
     * Returns the car's engine power.
     *
     * @return The engine power.
     */
    public double getEnginePower() {
        return enginePower;
    }

    /**
     * Returns the car's current speed.
     *
     * @return The current speed.
     */
    @Override
    public double getCurrentSpeed() {
        return currentSpeed;
    }

    /**
     * Returns the car's color.
     *
     * @return The color.
     */
    public Color getColor() {
        return color;
    }

    /**
     * Returns the direction the car is facing.
     *
     * @return The direction the car is facing.
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * Returns the x-position of the car.
     *
     * @return The x-position.
     */
    public double getX() {
        return x;
    }

    /**
     * Returns the y-position of the car.
     *
     * @return The y-position.
     */
    public double getY() {
        return y;
    }

    /**
     * Returns the model name of the car.
     *
     * @return The model name.
     */
    public String getModelName() {
        return modelName;
    }

    /**
     * Sets <code>currentSpeed</code> to <i>0.1</i>.
     */
    public void startEngine() {
        currentSpeed = 0.1;
    }

    /**
     * Sets <code>currentSpeed</code> to <i>0</i>.
     */
    public void stopEngine() {
        currentSpeed = 0;
    }

    /**
     * Returns true if the current speed is not equal to zero.
     *
     * @return If the car is moving.
     */
    public boolean isMoving() {
        return currentSpeed != 0;
    }

    /**
     * Returns a factor that modifies the speed adjustment.
     *
     * @return The factor.
     */
    public abstract double speedFactor();

    /**
     * Increments the speed based on the speed factor.
     *
     * @param amount The amount the speed should be increased with.
     */
    protected void incrementSpeed(double amount) {
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }

    /**
     * Decrements the speed based on the speed factor.
     *
     * @param amount The amount the speed should be decreased with.
     */
    protected void decrementSpeed(double amount) {
        currentSpeed = decrementedSpeed(amount);
    }

    protected double decrementedSpeed(double amount) {
        return getCurrentSpeed() - speedFactor() * amount;
    }

    /**
     * Increments the speed based on the speed factor (calls <code>incrementSpeed()</code>).
     *
     * @param amount The amount the speed should be increased with.
     */
    public void gas(double amount) {
        if (0 <= amount && amount <= 1) {
            incrementSpeed(amount);
            if (currentSpeed > enginePower) {
                currentSpeed = enginePower;
            }
        } else {
            System.err.println("The amount is not in the range [0, 1].");
            if (amount > 1) {
                incrementSpeed(1);
            }
        }
    }

    /**
     * Decrements the speed based on the speed factor (calls <code>decrementSpeed()</code>).
     *
     * @param amount The amount the speed should be decreased with.
     */
    public void brake(double amount) {
        if (0 <= amount && amount <= 1) {
            decrementSpeed(amount);
            if (currentSpeed < 0) {
                currentSpeed = 0;
            }
        } else {
            System.err.println("The amount is not in the range [0, 1].");
            if (amount > 1) {
                decrementSpeed(1);
            }
        }
    }

    /**
     * Moves the car by <code>currentSpeed</code> units in the direction represented by <code>direction</code>.
     */
    @Override
    public void move() {
        switch (direction) {

            case NORTH:
                y -= currentSpeed;
                break;

            case EAST:
                x += currentSpeed;
                break;

            case SOUTH:
                y += currentSpeed;
                break;

            case WEST:
                x -= currentSpeed;
                break;

        }

    }

    /**
     * Turns the car left.
     */
    @Override
    public void turnLeft() {
        direction = direction.turnLeft();
    }

    /**
     * Turns the car right.
     */
    @Override
    public void turnRight() {
        direction = direction.turnRight();
    }

    @Override
    public void flip() {
        direction = direction.flip();
    }

    /**
     * Sets the car's x-position.
     *
     * @param x The x-position.
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Sets the car's y-position.
     *
     * @param y The y-position.
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Returns the width of the car (the car image).
     *
     * @return The width of the car.
     */
    public double getWidth() {
        return image.getWidth();
    }

    /**
     * Returns the height of the car (the car image).
     *
     * @return The height of the car.
     */
    public double getHeight() {
        return image.getHeight();
    }

    /**
     * Returns the image of this car.
     *
     * @return The image.
     */
    public BufferedImage getImage() {
        return image;
    }

    /**
     * Returns if the given car is of the same model as this one.
     *
     * @param car The car.
     * @return If the car is of the same model.
     */
    public boolean isTheSameModel(Car car) {
        return modelName.equals(car.getModelName());
    }

}
