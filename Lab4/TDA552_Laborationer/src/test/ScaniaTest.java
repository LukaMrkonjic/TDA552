package test;

import car.Scania;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by phiwar on 2017-11-03.
 */
class ScaniaTest {

    @Test
    void setPlatformAngle() {
        Scania truck = new Scania();

        double angle = 45;
        truck.setPlatformAngle(angle);
        assertEquals(angle, truck.getPlatformAngle());

        double angle1 = 90;
        truck.setPlatformAngle(angle1);
        assertEquals(angle, truck.getPlatformAngle());

        truck.gas(1);
        assertEquals(0, truck.getCurrentSpeed());

        truck.setPlatformAngle(0);
        truck.gas(1);
        assertEquals(0.9, truck.getCurrentSpeed());
    }

}