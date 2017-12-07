package TransportModel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Class for TransportModel.Volvo240, which is a subclass of {@link Car()}, and that implements
 * the interface Moveable.
 *
 * @Author saralandfors, lukamrkonjik, gustafspjut
 * @version 1.0
 *
 */
public class Volvo240 extends Car {

    public final static double trimFactor = 1.25;

    public Volvo240(String imagePath) throws IOException {
        this.setImage(ImageIO.read(new File(imagePath)));
        setNrDoors(4);
        setColor(Color.black);
        setEnginePower(100);
        setModelName("TransportModel.Volvo240");
        stopEngine();
        setPosition(new Point(0,0));
        setSpeedFactor(getSpeedFactor());
        setTransportSize(4);
		setIsMoveable(true);
		setDirection(new Point(0,-1));
    }

    /**
     * @return the speedFactor calculated from engine power and trim factor.
     */
    @Override
    public double getSpeedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }

}
