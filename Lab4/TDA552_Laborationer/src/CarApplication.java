/*
import car.Car;
import car.Saab95;
import car.Scania;
import car.Volvo240;
import labtwo.CarController;
import labtwo.CarView;

import java.util.ArrayList;

public class CarApplication {

    public static void main(String[] args) {
        ArrayList<Car> cars = new ArrayList<>();

        // Creates the model
        Volvo240 volvo = new Volvo240();
        Saab95 saab = new Saab95();
        Scania scania = new Scania();
        saab.setY(100 + volvo.getHeight() + volvo.getY());
        scania.setY(100 + saab.getHeight() + saab.getY());
        cars.add(volvo);
        cars.add(saab);
        cars.add(scania);

        // Creates the controller
        CarController cc = new CarController(cars, frame);

        // Creates the view
        CarView frame = new CarView("CarSim 1.0", cc);
    }

}
*/