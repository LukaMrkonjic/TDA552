import TransportController.CarController;
import TransportModel.*;
import TransportView.CarView;

import java.io.IOException;
import java.util.ArrayList;

public class TransportApplication {

    //TODO: Ska denna timer vara här?
    private final int delay = 50;  // The delay (ms) corresponds to 20 updates a sec (hz)

    public static void main(String[] args) throws IOException {

        ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();

        Saab95 saab95 = CarFactory.createSaab95();
        Volvo240 volvo240 = CarFactory.createVolo240();
        Scania scania = CarFactory.createScania();

        vehicles.add(saab95);
        vehicles.add(volvo240);
        vehicles.add(scania);

        // Creates model
        //TODO: Skapa bilar med hjälp av Carfactory
        TransportModel tm = new TransportModel(vehicles);

        //TODO: Ändra så att carView inte tar in en frame?:
        // Creates view
        CarView cv = new CarView("CarSim 1.0", tm);

        // Creates controller
        CarController cc = new CarController(tm, cv);

        cc.getTimer().start();

        //Timer timer = new Timer(delay, new TimerListener()); // The timer is started with an listener (see below) that executes the statements each step between delays.

    }
}

/*

		// Instance of this class
		CarController cc = new CarController();

		cc.vehicles.add(new Volvo240());
		cc.vehicles.add(new Scania());
		cc.vehicles.add(new Saab95());

		// Start a new view and send a reference of self
		cc.frame = new CarView("CarSim 1.0", cc);

		// Start the timer
		cc.timer.start();

 */