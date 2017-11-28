package test;

import car.Car;
import enums.Direction;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by phiwar on 2017-11-02.
 */
public class CarTest {

    @org.junit.jupiter.api.Test
    void startEngine() {
        Car c = new MockCar();
        c.startEngine();
        assertEquals(0.1, c.getCurrentSpeed());
    }

    @org.junit.jupiter.api.Test
    void stopEngine() {
        Car c = new MockCar();
        c.stopEngine();
        assertEquals(0, c.getCurrentSpeed());
    }

    @org.junit.jupiter.api.Test
    void gas() {
        MockCar c = new MockCar();
        double amount = 1;
        c.gas(amount);
        assertEquals(amount, c.getCurrentSpeed());

        double speed = 100;
        while (c.getCurrentSpeed() < speed) {
            c.gas(amount);
        }
        c.gas(amount);
        assertEquals(100, c.getCurrentSpeed());
    }

    @org.junit.jupiter.api.Test
    void brake() {
        MockCar c = new MockCar();
        c.brake(-1);
        assertEquals(0, c.getCurrentSpeed());

        double speed = 100;
        while (c.getCurrentSpeed() < speed) {
            c.gas(1);
        }
        c.brake(1);
        assertEquals(99, c.getCurrentSpeed());

        c.stopEngine();
        c.brake(1);
        assertEquals(0, c.getCurrentSpeed());

    }

    @org.junit.jupiter.api.Test
    void move() {

        MockCar c = new MockCar();
        double speed = 5;
        while (c.getCurrentSpeed() < speed) {
            c.gas(1);
        }

        // Direction is initially default, i.e. NORTH

        // Facing west
        c.turnLeft();
        c.move();
        assertEquals(-speed, c.getX());

        // Facing south
        c.turnLeft();
        c.move();
        assertEquals(speed, c.getY());

        // Facing east
        c.turnLeft();
        c.move();
        assertEquals(0, c.getX());

        // Facing north
        c.turnLeft();
        c.move();
        assertEquals(0, c.getY());

    }

    @org.junit.jupiter.api.Test
    void turnLeft() {
        MockCar c = new MockCar();

        // Direction is default, i.e. NORTH

        c.turnLeft();
        assertEquals(Direction.WEST, c.getDirection());

        c.turnLeft();
        assertEquals(Direction.SOUTH, c.getDirection());

        c.turnLeft();
        assertEquals(Direction.EAST, c.getDirection());

        c.turnLeft();
    }

    @org.junit.jupiter.api.Test
    void turnRight() {
        MockCar c = new MockCar();

        // Direction is default, i.e. NORTH

        c.turnRight();
        assertEquals(Direction.EAST, c.getDirection());

        c.turnRight();
        assertEquals(Direction.SOUTH, c.getDirection());

        c.turnRight();
        assertEquals(Direction.WEST, c.getDirection());

        c.turnRight();
        assertEquals(Direction.NORTH, c.getDirection());
    }

}

class MockCar extends Car {

    public MockCar() {
        super();
    }

    @Override
    public double speedFactor() {
        return 1;
    }

//    @Override
//    protected void incrementSpeed(double amount) {
//        currentSpeed += amount;
//    }

//    @Override
//    protected void decrementSpeed(double amount) {
//        currentSpeed -= amount;
//    }

//    public void setCurrentSpeed(double speed) {
//        currentSpeed = speed;
//    }

}