package labtwo;

import car.*;

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

        Car volvo  = CarFactory.createVolvo240();
        Car saab   = CarFactory.createSaab95();
        Car scania = CarFactory.createScania();

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

    public CarController() {
        frame.setGasButtonAction(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gas(100);
            }
        });
        frame.setBrakeButtonAction(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                brake(100);
            }
        });
        frame.setTurboOnButtonAction(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setTurbo(true);
            }
        });
        frame.setTurboOffButtonAction(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setTurbo(false);
            }
        });
        frame.setLiftBedButtonAction(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                liftRamp(true);
            }
        });
        frame.setLowerBedButtonAction(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                liftRamp(false);
            }
        });
        frame.setStartButtonAction(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            for (Car car : cars) {
                car.startEngine();
            }
            }
        });
        frame.setStopButtonAction(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Car car : cars) {
                    car.stopEngine();
                }
            }
        });
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Car car : cars) {
                moveCar(car);
                // repaint() calls the paintComponent method of the panel
                frame.getDrawPanel().repaint();
            }
        }
    }

    /**
     * Calls the gas method for each car once.
     *
     * @param amount The amount of which the car will gas [0, 100].
     */
    public void gas(int amount) {
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
    public  void brake(int amount) {
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
    public void setTurbo(boolean turbo) {

        for (Car car : cars) {
            if (car.isTheSameModel(CarFactory.createSaab95())) {
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
    public void liftRamp(boolean lift) {

        for (Car car : cars) {
            if (car.isTheSameModel(CarFactory.createScania())) {
                Scania scania = (Scania) car;
                if (lift) {
                    scania.setPlatformAngle(70);
                } else {
                    scania.setPlatformAngle(0);
                }
            }
        }
    }

    // Checks for wall collision
    private boolean wallCollision(Car car) {

        switch (car.getDirection()) {

            case NORTH:
                return car.getY() < 0;

            case EAST:
                return car.getX() + car.getWidth() > frame.getWidth();

            case SOUTH:
                return car.getY() + car.getHeight() > frame.getHeight();

            case WEST:
                return car.getX() < 0;
        }

        return false;
    }

    /**
     * Moves the car in its direction and flips it if a wall collision occurs.
     *
     * @param car The car to move.
     */
    void moveCar(Car car) {

        car.move();

        if (wallCollision(car)) {
            car.stopEngine();

            car.flip();

            switch (car.getDirection()) {

                case NORTH:
                    car.setY(0);
                    break;

                case EAST:
                    car.setX(0);
                    break;

                case SOUTH:
                    car.setY(frame.getHeight() - car.getHeight());
                    break;

                case WEST:
                    car.setX(frame.getWidth() - car.getWidth());
                    break;

            }

            car.startEngine();
        }

    }

}