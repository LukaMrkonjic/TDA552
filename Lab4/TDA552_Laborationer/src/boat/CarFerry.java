package boat;

import car.Car;
import car.CarTransport;
import enums.Direction;
import enums.RampState;
import interfaces.Transport;

import java.util.ArrayList;

/**
 * This class can transport cars.
 */
public class CarFerry implements Transport {

    private final CarTransport transport;

    // Cars
    private final ArrayList<Car> cars;
    private final int maxNumCars;

    /**
     * @param maxNumCars The max number of cars.
     */
    public CarFerry(int maxNumCars) {
        transport = new CarTransport(maxNumCars);
        cars = new ArrayList<>(maxNumCars);
        this.maxNumCars = maxNumCars;
    }

    @Override
    public void move() {
        transport.move();

        for (Car car : cars) {
            car.setX(getX());
            car.setY(getY());
        }
    }

    @Override
    public void turnLeft() {
        transport.turnLeft();
    }

    @Override
    public void turnRight() {
        transport.turnRight();
    }

    @Override
    public void flip() {
        transport.flip();
    }

    @Override
    public void loadCar(Car car) {
        if (cars.size() < maxNumCars && !cars.contains(car)) {
            cars.add(car);
        }
    }

    @Override
    public Car unloadCar() {
        if (cars.size() > 0) {
            return cars.remove(0);
        }
        return null;
    }

    @Override
    public boolean canLoad(Car car) {
        return transport.canLoad(car);
    }

    /**
     * Increments the speed based on the speed factor.
     *
     * @param amount The amount the speed should be increased with.
     */
    public void gas(double amount) {
        transport.gas(amount);
    }

    /**
     * Decrements the speed based on the speed factor.
     *
     * @param amount The amount the speed should be decreased with.
     */
    public void brake(double amount) {
        transport.brake(amount);
    }

    /**
     * Returns the x-position of the ferry.
     *
     * @return The x-position.
     */
    public double getX() {
        return transport.getX();
    }

    /**
     * Returns the y-position of the ferry.
     *
     * @return The y-position.
     */
    public double getY() {
        return transport.getY();
    }

    @Override
    public double getCurrentSpeed() {
        return transport.getCurrentSpeed();
    }

    public int getNumLoadedCars() {
        return cars.size();
    }

    @Override
    public void raiseRamp() {
        transport.raiseRamp();
    }

    @Override
    public void lowerRamp() {
        transport.lowerRamp();
    }

    @Override
    public RampState getRampState() {
        return transport.getRampState();
    }

    /**
     * Returns a factor that modifies the speed adjustment.
     *
     * @return The factor.
     */
    public double getSpeedFactor() {
        return transport.speedFactor();
    }

    /**
     * Returns the direction the ferry is facing.
     *
     * @return The direction the ferry is facing.
     */
    public Direction getDirection() {
        return transport.getDirection();
    }

    /**
     * Sets <code>currentSpeed</code> to <i>0</i>.
     */
    public void stopEngine() {
        transport.stopEngine();
    }

}
