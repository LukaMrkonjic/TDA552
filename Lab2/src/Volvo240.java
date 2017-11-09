import java.awt.*;

/**
 * Class for Volvo240, which is a subclass of {@link Car()}, and that implements
 * the interface Moveable.
 *
 * @Author saralandfors, lukamrkonjik, gustafspjut
 * @version 1.0
 *
 */
public class Volvo240 extends Car {

    public final static double trimFactor = 1.25;

    public Volvo240(){
        setNrDoors(4);
        setColor(Color.black);
        setEnginePower(100);
        setModelName("Volvo240");
        stopEngine();
        setPosition(new Point(0,0));
        setSpeedFactor(getSpeedFactor());
    }

    /**
     * @return the speedFactor calculated from engine power and trim factor.
     */
    @Override
    public double getSpeedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }

}
