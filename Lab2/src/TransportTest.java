import org.junit.Test;

import java.awt.*;
import java.awt.geom.Point2D;

import static org.junit.Assert.*;

public class TransportTest {
    @Test
    public void move() throws Exception {

        CarTransport ct = new CarTransport();
        Saab95 Saab = new Saab95();
        CarFerry cf = new CarFerry();
        System.out.println(Saab.getPosition());
        System.out.println(ct.getPosition());
        ct.loadingPlatform.setAngle(0);
        ct.addVehicle(Saab);
        /*
        ct.setEnginePower(200.0);
        ct.setCurrentSpeed(3.0);
        ct.move();
        System.out.println(Saab.getPosition());
        System.out.println(ct.getPosition());
        ct.move();
        ct.setCurrentSpeed(0);
        ct.loadingPlatform.setAngle(90);
        System.out.println(Saab.getPosition());
        System.out.println(ct.getPosition());
        ct.removeVehicle();
        */
        cf.loadingPlatform.setAngle(0);
        cf.addVehicle(ct);
        cf.setEnginePower(200.0);
        cf.setCurrentSpeed(3.0);
        cf.move();
        System.out.println(Saab.getPosition());
        System.out.println(ct.getPosition());
        System.out.println(cf.getPosition());
    }

}