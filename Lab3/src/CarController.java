import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;

    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Vehicle> cars = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.cars.add(new Volvo240());
        cc.cars.add(new Scania());
        cc.cars.add(new Saab95());

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
            for (Vehicle car : cars) {
                car.move();

                if (isOutOfBounds(car)) {
					invertDirection(car);
					car.move();
					car.move();
				}

				int x = (int) Math.round(car.getPosition().getX());
				int y = (int) Math.round(car.getPosition().getY());

                frame.getDrawPanel().moveIt(x, y);
                // repaint() calls the paintComponent method of the panel
                frame.getDrawPanel().repaint();
            }
        }
    }



    private void invertDirection(Vehicle v) {
    	Point direction = v.getDirection();
    	direction.x = -1 * direction.x;
		direction.y = -1 * direction.y;
		v.setDirection(direction);
	}

    private boolean isOutOfBounds(Vehicle v) {
		Point2D.Double position = v.getPosition();
		if(xIsOutOfBounds(position) || yIsOutOfBounds(position) ) {
			return true;
		} else {
			return false;
		}
	}

	private boolean xIsOutOfBounds(Point2D.Double p) {
    	double x = p.getX();
    	if (x < 0 || x > frame.getDrawPanel().getSize().getWidth() - 100) {
    		return true;
		} else {
    		return false;
		}
	}

	private boolean yIsOutOfBounds(Point2D.Double p) {
		double y = p.getY();
    	if (y < 0 || y > frame.getDrawPanel().getSize().getHeight() - 60) {
			return true;
		} else {
			return false;
		}
	}

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : cars) {
            car.gas(gas);
        }
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle car : cars) {
            car.brake(brake);
        }
    }
}
