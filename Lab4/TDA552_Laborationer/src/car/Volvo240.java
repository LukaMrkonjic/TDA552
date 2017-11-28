package car;

import java.awt.*;

/**
 * This class is a subclass of Car that represents a Volvo 240.
 */
public class Volvo240 extends Car {

    /**
     * A factor that modifies the speed factor.
     */
    private final static double trimFactor = 1.25;

    /**
     * Calls the super class constructor and
     * sets the specifications to those of a Volvo 240.
     */
    public Volvo240() {
        super(4, 100, Color.BLACK, "Volvo240", "res\\Volvo240.jpg");
    }


    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }

    @Override
    protected void incrementSpeed(double amount) {
        boolean maximized = super.decrementedSpeed(amount) > getEnginePower();
        double increment = maximized ? getEnginePower() : amount;
        super.incrementSpeed(increment);
    }

    @Override
    protected void decrementSpeed(double amount) {
        boolean minimized = super.decrementedSpeed(amount) < 0;
        double decrement = minimized ? 0 : amount;
        super.decrementSpeed(decrement);
    }

}