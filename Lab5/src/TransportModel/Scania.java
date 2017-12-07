package TransportModel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * This class represents a TransportModel.Scania truck, which extends the abstract class truck,
 * which extends vehicle, which extends TransportModel.Transport which implements moveable.
 * When a TransportModel.Scania object is created, all instance variables are initialized according
 * to TransportModel.Scania's unique values (see constructor).
 *
 * @author SaraLandfors
 * @version 1.0
 */
public class Scania extends Truck {

    public Scania(String imagePath) throws IOException {
        this.setImage(ImageIO.read(new File(imagePath)));
        setTransportSize(21.2);
        setPosition(new Point(200, 0));    //starting position of a new TransportModel.Scania TransportModel.Truck
        setDirection(new Point(1, 0));    //starting direction set to East
        setSpeedFactor(2);
        setEnginePower(0.8);
        setLoadingPlatform(new LoadingPlatform(getCurrentSpeed()));

        setNrDoors(2);
        setColor(Color.BLUE);
        setModelName("TransportModel.Scania");
        //setLoadingPlatform(new TransportModel.LoadingPlatform(getCurrentSpeed(), 0, 70));
        setCurrentSpeed(0.0);
        setIsMoveable(true);
    }

    @Override
    public void liftBed() {
        getLoadingPlatform().setAngle(0);
    }

    @Override
    public void lowerBed() {
        int maxAngle = getLoadingPlatform().getMaxAngle();
        getLoadingPlatform().setAngle(maxAngle);
    }

    @Override
    public void setBed(boolean b) {
        setLoadingPlatform(b);
    }

    /**
     * Helper method for setBed that is called if there is
     * a TransportModel.Scania vehicle on the frame.
     *
     * @param up true if TransportModel.LoadingPlatform is to be set up, false otherwise
     */
    @Override
    public void setLoadingPlatform(boolean up) {
        if (up) {
            liftBed();
        } else {
            lowerBed();
        }
    }
}

