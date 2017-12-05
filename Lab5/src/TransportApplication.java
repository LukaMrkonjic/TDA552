package TransportApplication;
import TransportController.CarController;
import TransportView.CarView;
import javax.swing.*;

public class TransportApplication {

    //TODO: Ska denna timer vara här?
    private final int delay = 50;  // The delay (ms) corresponds to 20 updates a sec (hz)


    public static void main(String[] args) {

        //TODO: Skapa bilar med hjälp av Carfactory
        CarModel cm = new CarModel();
        CarController cc = new CarController(cm);

        //TODO: Ändra så att carView inte tar in en frame?:
        CarView cv = new CarView();
        Timer timer = new Timer(delay, new TimerListener()); // The timer is started with an listener (see below) that executes the statements each step between delays.
    }
}
