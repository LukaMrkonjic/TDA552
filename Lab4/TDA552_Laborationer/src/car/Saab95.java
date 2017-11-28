package car;

import java.awt.*;

/**
 * This class is a subclass of Car that represents a Saab 95.
 */
public class Saab95 extends Car {

    private boolean turboOn;

    /**
     * Calls the super class constructor and
     * sets the specifications to those of a Saab 95.
     */
    public Saab95() {
        super(2, 125, Color.RED, "Saab95", "res\\Saab95.jpg");
        turboOn = false;
    }

    /**
     * Enables turbo which modifies the speed factor by a factor of <i>1.3</i> when <code>speedFactor()</code> is called
     */
    public void setTurboOn() {
        turboOn = true;
    }

    /**
     * Disables turbo (does not multiply the speed factor with anything related to turbo).
     */
    public void setTurboOff() {
        turboOn = false;
    }

    @Override
    public double speedFactor() {
        double turbo = 1;
        if (turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }

}
