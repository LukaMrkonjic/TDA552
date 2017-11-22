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

	private final int delay = 50;  // The delay (ms) corresponds to 20 updates a sec (hz)
	private Timer timer = new Timer(delay, new TimerListener()); // The timer is started with an listener (see below) that executes the statements each step between delays.
	CarView frame; // The frame that represents this instance View of the MVC pattern
	ArrayList<Vehicle> vehicles = new ArrayList<>(); // A list of cars, modify if needed

	public static void main(String[] args) {
		// Instance of this class
		CarController cc = new CarController();

		cc.vehicles.add(new Volvo240());
		cc.vehicles.add(new Scania());
		cc.vehicles.add(new Saab95());

		//Update positions of vehicles
		//for(int v = 0; v < cc.vehicles.size(); v ++) {
		//	Point2D.Double updatedPos = new Point2D.Double();
		//	cc.vehicles.get(v).setPosition(v *);
		//}

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
			for (Vehicle car : vehicles) {
				car.move();

				if (isOutOfBounds(car)) {
					invertDirection(car);
					car.move();
					car.move();
				}

				frame.getDrawPanel().getVehiclesToBeDrawn().add(car);

			}
			// repaint() calls the paintComponent method of the panel
			frame.getDrawPanel().repaint();
		}
	}


	private void invertDirection(Vehicle v) {
		Point direction = v.getDirection();
		direction.x = - 1 * direction.x;
		direction.y = - 1 * direction.y;
		v.setDirection(direction);
	}

	private boolean isOutOfBounds(Vehicle v) {
		Point2D.Double position = v.getPosition();
		if (xIsOutOfBounds(position) || yIsOutOfBounds(position)) {
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
		for (Vehicle car : vehicles) {
			car.gas(gas);
		}
	}

	void stopAllCars() {
		for (Vehicle v : getVehicles()) {
			if( v instanceof Car) {
				v.stopEngine();
			}
		}
	}

	void startAllCars() {
		for (Vehicle v : getVehicles()) {
			if( v instanceof Car) {
				v.startEngine();
			}
		}
	}

	void brake(int amount) {
		double brake = ((double) amount) / 100;
		for (Vehicle car : vehicles) {
			car.brake(brake);
		}
	}

	public void lowerBed() {
		  setBed(false);
	}

	//TODO: snygga till den här koden (dela upp i flera funktioner)
	private void setBed(boolean up) {
		for(Vehicle v : getVehicles() ) {
			if (v instanceof Scania) {
				Scania s = (Scania) v;
				if (up) {
					s.getLoadingPlatform().setAngle(0);
				} else {
					int maxAngle = s.getLoadingPlatform().getMaxAngle();
					s.getLoadingPlatform().setAngle(maxAngle);
				}
	    	}
	    }
	}

	public void liftBed() {
		setBed(true);
	}

	public ArrayList<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(ArrayList<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}


}