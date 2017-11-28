package interfaces;

import car.Car;
import enums.RampState;

/**
 * The interface for objects that can contain collections of <code>Car</code>.
 */
public interface Transport extends Movable {

    /**
     * Checks if the transport can load a car.
     *
     * @param car The car in question.
     * @return If the transport can load the car.
     */
    boolean canLoad(Car car);

    /**
     * Loads a car onto the transport.
     *
     * @param car The car to load.
     */
    void loadCar(Car car);

    /**
     * Unloads a car from the transport and returns it.
     *
     * @return The unloaded car.
     */
    Car unloadCar();

    /**
     * Returns the number of loaded cars.
     *
     * @return The number of loaded cars.
     */
    int getNumLoadedCars();

    /**
     * Raises the ramp.
     */
    void raiseRamp();

    /**
     * Lowers the ramp if the current speed is equal to zero.
     */
    void lowerRamp();

    /**
     * Returns the current ramp state.
     *
     * @return The ramp state.
     */
    RampState getRampState();



}
