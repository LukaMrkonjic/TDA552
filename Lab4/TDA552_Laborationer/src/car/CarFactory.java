package car;

public class CarFactory {

    public static Car createSaab95() {
        Saab95 saab95 = new Saab95("TDA552_Laborationer/res/Saab95.jpg");
        return saab95;
    }

    public static Car createVolvo240() {
        Volvo240 volvo240 = new Volvo240("TDA552_Laborationer/res/Volvo240.jpg");
        return volvo240;
    }

    public static Car createScania() {
        Scania scania = new Scania("TDA552_Laborationer/res/Scania.jpg");
        return scania;
    }

}