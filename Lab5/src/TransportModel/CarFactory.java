package TransportModel;

import java.io.IOException;

/**
 * Created by lukamrkonjic on 2017-12-05.
 */
public abstract class CarFactory {

    public static Saab95 createSaab95() throws IOException {
        Saab95 saab95 = new Saab95("src//pics//Saab95.jpg");
        return saab95;
    }

    public static Volvo240 createVolo240() throws IOException {
        Volvo240 volvo240 = new Volvo240("src//pics//Volvo240.jpg");
        return volvo240;
    }

    public static Scania createScania() throws IOException {
        Scania scania = new Scania("src//pics//Scania.jpg");
        return scania;
    }

}
