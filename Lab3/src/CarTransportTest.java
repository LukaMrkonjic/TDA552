import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by lukamrkonjic on 2017-11-15.
 */
public class CarTransportTest {

    @Test
    public void move() throws Exception {
        CarTransport carTransport = new CarTransport();
        carTransport.move();
        carTransport.setSpeedFactor(10);
        assertArrayEquals(carTransport.getPosition().getX());
    }

    @Test
    public void setCurrentSpeed() throws Exception {

    }

    @Test
    public void addVehicle() throws Exception {

    }

    @Test
    public void removeVehicle() throws Exception {

    }

}