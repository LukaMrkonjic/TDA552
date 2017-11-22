import java.awt.*;

/**
 * Class for Saab95, which is a subclass of {@link Car()}, and that implements
 * the interface Moveable.
 *
 * @Author saralandfors, lukamrkonjik, gustafspjut
 * @version 1.0
 *
 */
public class Saab95 extends Car {

    private boolean turboOn;

    public Saab95(){
        setTransportSize(8.1);
        setNrDoors(2);
        setColor(Color.red);
        setEnginePower(125);
	    setTurboOff();
        setModelName("Saab95");
        stopEngine();
        setPosition(new Point(0,100));
        setDirection(new Point(0,1));
        setSpeedFactor(getSpeedFactor());
        setIsMoveable(true);
    }

    /**
     * Sets instance variable turboOn to true.
     */
    public void setTurboOn() {
        turboOn = true;
    }

    /**
     * Sets the instance variable turboOn to false.
     */
    public void setTurboOff() {
        turboOn = false;
    }

    /**
     * @return    the speedFactor as calculated from enginePower, and turboOn
     */
    @Override
    public double getSpeedFactor() {
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }

}
