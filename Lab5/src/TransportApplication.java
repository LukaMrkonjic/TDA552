import TransportController.CarController;
import TransportModel.*;
import TransportView.CarView;
import java.io.IOException;
import java.util.ArrayList;

public class TransportApplication {


    public static void main(String[] args) throws IOException {
        ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();

        //Creates and adds vehicles to arraylist
        vehicles.add(CarFactory.createSaab95());
        vehicles.add(CarFactory.createVolo240());
        vehicles.add(CarFactory.createScania());

        // Creates model
        TransportModel tm = new TransportModel(vehicles);

        // Creates view
        CarView cv = new CarView("CarSim 1.0", tm);

        // Creates controller
        CarController cc = new CarController(tm, cv);

        //starts program
        cc.getTimer().start();
    }
}
