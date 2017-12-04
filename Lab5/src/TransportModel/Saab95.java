package TransportModel;

import java.awt.*;

/**
 * Class for TransportModel.Saab95, which is a subclass of {@link Car()}, and that implements
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
        setModelName("TransportModel.Saab95");
        stopEngine();
        setPosition(new Point(100,0));
        setDirection(new Point(0,1));
        setSpeedFactor(getSpeedFactor());
        setIsMoveable(true);
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

    @Override
    public void setTurbo(boolean b) {
        turboOn = b;
    }

}
