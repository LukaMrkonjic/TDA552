import TransportController.CarController;
import TransportModel.*;
import TransportView.CarView;
import java.util.ArrayList;

public class TransportApplication {

    //TODO: Ska denna timer vara här?
    private final int delay = 50;  // The delay (ms) corresponds to 20 updates a sec (hz)

    public static void main(String[] args) {

        ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();

        //TODO: Skapa bilar med hjälp av Carfactory
        TransportModel tm = new TransportModel(vehicles);

        CarController cc = new CarController(tm);

        //TODO: Ändra så att carView inte tar in en frame?:
        CarView cv = new CarView("CarSim 1.0", cc);

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