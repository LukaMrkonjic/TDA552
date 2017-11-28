package labtwo;

import car.Car;
import car.Saab95;
import car.Scania;
import car.Volvo240;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */
public class CarController {

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    /**
     * The frame that represents this instance View of the MVC pattern
     */
    CarView frame;

    /**
     * A list of cars, modify if needed
     */
    ArrayList<Car> cars = new ArrayList<>();

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        Volvo240 volvo = new Volvo240();
        Saab95 saab = new Saab95();
        Scania scania = new Scania();
        saab.setY(100 + volvo.getHeight() + volvo.getY());
        scania.setY(100 + saab.getHeight() + saab.getY());
        cc.cars.add(volvo);
        cc.cars.add(saab);
        cc.cars.add(scania);

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();

    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Car car : cars) {
                frame.drawPanel.moveCar(car);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }

    /**
     * Calls the gas method for each car once.
     *
     * @param amount The amount of which the car will gas [0, 100].
     */
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars) {
            car.gas(gas);
        }
    }

    /**
     * Calls the brake method for each car once.
     *
     * @param amount The amount of which the car will brake [0, 100].
     */
    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Car car : cars) {
            car.brake(brake);
        }
    }

    /**
     * Turns the turbo on/off on all Saab95 cars in the list <code>cars</code>.
     *
     * @param turbo If the turbo should be turned on or off.
     */
    void setTurbo(boolean turbo) {

        for (Car car : cars) {
            if (car.isTheSameModel(new Saab95())) {
                Saab95 saab = (Saab95) car;
                if (turbo) {
                    saab.setTurboOn();
                } else {
                    saab.setTurboOff();
                }
            }
        }
    }

    /**
     * Lifts/lowers the ramps on all Scania trucks in the list <code>cars</code>.
     *
     * @param lift If the ramp should be raised or not.
     */
    void liftRamp(boolean lift) {

        for (Car car : cars) {
            if (car.isTheSameModel(new Scania())) {
                Scania scania = (Scania) car;
                if (lift) {
                    scania.setPlatformAngle(70);
                } else {
                    scania.setPlatformAngle(0);
                }
            }
        }
    }

}
