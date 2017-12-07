package TransportModel;

/**
 * Created by lukamrkonjic on 2017-12-05.
 */
public abstract class CarFactory {

    public static Saab95 createSaab95() {
        Saab95 saab95 = new Saab95();
        return saab95;
    }

    public static Volvo240 createVolo240() {
        Volvo240 volvo240 = new Volvo240();
        return volvo240;
    }

    public static Scania createScania() {
        Scania scania = new Scania();
        return scania;
    }

}
