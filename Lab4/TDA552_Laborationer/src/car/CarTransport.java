package car;


import enums.Direction;
import enums.RampState;
import interfaces.Transport;

import java.awt.*;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * This class is a subclass of Car and can transport cars.
 */
public class CarTransport extends Car implements Transport {

    private RampState rampState;

    // Cars
    private final Deque<Car> cars;
    private final int maxNumCars;

    /**
     * @param maxNumCars The max number of cars.
     */
    public CarTransport(int maxNumCars) {
        super(2, 90, Color.BLUE, "CarTransport2000", "");
        this.maxNumCars = maxNumCars;
        cars = new ArrayDeque<>(maxNumCars);
        rampState = RampState.UP;
    }

    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01;
    }

    @Override
    public void gas(double amount) {
        if (rampState == RampState.UP) {
            super.gas(amount);
        }
    }

    @Override
    public void move() {
        super.move();

        for (Car car : cars) {
            car.setX(getX());
            car.setY(getY());
        }
    }

    @Override
    public void lowerRamp() {
        if (getCurrentSpeed() == 0) {
            rampState = RampState.DOWN;
        }
    }

    @Override
    public void raiseRamp() {
        rampState = RampState.UP;
    }

    @Override
    public void loadCar(Car car) {
        if (canLoad(car)) {
            car.setX(getX());
            car.setY(getY());
            cars.push(car);
        }
    }

    @Override
    public boolean canLoad(Car car) {
        if (car == this || cars.contains(car)) {
            return false;
        }
        return rampState == RampState.DOWN &&
                cars.size() < maxNumCars &&
                isClose(car);
    }

    // Checks if the car is close to the transport
    private boolean isClose(Car car) {

        double close = 15;
        double length = 15;

        boolean isClose = false;

        switch (getDirection()) {

            case NORTH:
                isClose = getY() + length / 2 <= car.getY() &&
                        car.getY() <= getY() + close;
                break;

            case EAST:
                isClose = getX() + length / 2 <= car.getX() &&
                        car.getX() <= getX() + close;
                break;

            case SOUTH:
                isClose = getY() - close <= car.getY() &&
                        car.getY() <= getY() - length / 2;
                break;

            case WEST:
                isClose = getX() - close <= car.getX() &&
                        car.getX() <= getX() - length / 2;
                break;
        }

        return isAligned(car) && isClose;
    }

    // Checks if the car is aligned to the transport
    private boolean isAligned(Car car) {

        double width = 5;
        boolean isAligned;

        if (isVerticallyAligned(this)) {
            isAligned = getX() - width / 2 <= car.getX() &&
                    car.getX() <= getX() + width / 2 &&
                    isVerticallyAligned(car);
        } else {
            isAligned = getY() - width / 2 <= car.getY() &&
                    car.getY() <= getY() + width / 2 &&
                    !isVerticallyAligned(car);

        }
        return isAligned;
    }

    // Checks if the car is facing north or south
    private boolean isVerticallyAligned(Car car) {
        return car.getDirection() == Direction.NORTH ||
                car.getDirection() == Direction.SOUTH;
    }

    @Override
    public Car unloadCar() {
        if (rampState == RampState.DOWN && cars.size() > 0) {
            Car car = cars.pop();
            putCarBehind(car);
            return car;
        }
        return null;
    }


    // Puts the car behind the transport by
    // checking the transport's direction.
    private void putCarBehind(Car car) {
        double close = 10;

        double angle = (1 - getDirection().ordinal()) / 4.0 * 2 * Math.PI;
        double x = Math.cos(angle);
        double y = Math.sin(angle);

        car.setX(getX() + x * close);
        car.setY(getY() + y * close);
    }

    @Override
    public int getNumLoadedCars() {
        return cars.size();
    }

    @Override
    public RampState getRampState() {
        return rampState;
    }

}
