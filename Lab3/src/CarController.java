import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.util.ArrayList;

/**
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

	/**
	 * Main program that creates three vehicles and adds them to the frame.
	 * @param args
	 */
	public static void main(String[] args) {
		// Instance of this class
		CarController cc = new CarController();

		cc.vehicles.add(new Volvo240());
		cc.vehicles.add(new Scania());
		cc.vehicles.add(new Saab95());

		// Start a new view and send a reference of self
		cc.frame = new CarView("CarSim 1.0", cc);

		// Start the timer
		cc.timer.start();
	}

	/** Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    *
	 */
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

	/**
	 * This method inverts the direction of a vehicle.
	 * @param v the vehicle that will get an inverted direction
	 */
	private void invertDirection(Vehicle v) {
		Point direction = v.getDirection();
		direction.x = - 1 * direction.x;
		direction.y = - 1 * direction.y;
		v.setDirection(direction);
	}

	/**
	 * This method checks whether a vehicle is out of bounds in the
	 * window.
	 * @param v the vehicle to be checked
	 * @return a boolean that is true if the vehicle is out of bounds
	 * 			and false otherwise.
	 */
	private boolean isOutOfBounds(Vehicle v) {
		Point2D.Double position = v.getPosition();
		if (xIsOutOfBounds(position) || yIsOutOfBounds(position)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @param p the point for which the x-coordinate will be checked
	 * @return a boolean that is true if the x-coordinate is out of bounds
	 */
	private boolean xIsOutOfBounds(Point2D.Double p) {
		double x = p.getX();
		if (x < 0 || x > frame.getDrawPanel().getSize().getWidth() - 100) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @param p the point for which the y-coordinate will be checked
	 * @return a boolean that is true if the y-coordinate is out of bounds
	 */
	private boolean yIsOutOfBounds(Point2D.Double p) {
		double y = p.getY();
		if (y < 0 || y > frame.getDrawPanel().getSize().getHeight() - 60) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @param amount the amount of gas that will be applied to all
	 *               vehicles in the frame
	 */
	void gas(int amount) {
		double gas = ((double) amount) / 100;
		for (Vehicle car : vehicles) {
			car.gas(gas);
		}
	}

	/**
	 * This method checks all vehicles on the frame and sets their speed
	 * to zero if they are cars.
	 */
	void stopAllCars() {
		for (Vehicle v : getVehicles()) {
			if( v instanceof Car) {
				v.stopEngine();
			}
		}
	}

	/**
	 * This method checks all vehicles on the frame and sets their speed
	 * to 0.1 if they are cars.
	 */
	void startAllCars() {
		for (Vehicle v : getVehicles()) {
			if( v instanceof Car) {
				v.startEngine();
			}
		}
	}

	/**
	 * @param amount the amount by which all vehicles' speed will be reduced.
	 */
	void brake(int amount) {
		double brake = ((double) amount) / 100;
		for (Vehicle car : vehicles) {
			car.brake(brake);
		}
	}

	/**
	 *
	 * @param b a boolean that is true if Turbo should be turned on, and
	 *          false otherwise. Only applies to the Saab95s on the frame.
	 */
	public void setTurbo(boolean b){
		for (Vehicle v : getVehicles()) {
			if (v instanceof Saab95) {
				Saab95 s = (Saab95) v;
				if (b) {
					s.setTurboOn();
				} else {
					s.setTurboOff();
				}
			}
		}


	}

	/**
	 * Invokes turnLeft for all vehicles in the frame.
	 */
	public void turnLeft() {
		for (Vehicle car : vehicles) {
			car.turnLeft();
		}
	}

	/**
	 * Invokes turnRight for all vehicles in the frame.
	 */
	public void turnRight() {
		for (Vehicle car : vehicles) {
			car.turnRight();
		}
	}

	/**
	 * Lowers the bed of the LoadingPlatform.
	 */
	public void lowerBed() {
		  setBed(false);
	}

	/**
	 * Raises the bed of the LoadingPlatform.
	 */
	public void liftBed() {
		setBed(true);
	}

	/**
	 * Helper method of lowerBed() and liftBed().
	 * @param up true if bed should be up and false if
	 *           bed should be down.
	 */
	private void setBed(boolean up) {
		for(Vehicle v : getVehicles() ) {
			if (v instanceof Scania) {
				Scania s = (Scania) v;
				setLoadingPlatform(up, s);
	    	}
	    }
	}

	/**
	 * Helper method for setBed that is called if there is
	 * a Scania vehicle on the frame.
	 * @param up true if LoadingPlatform is to be set up, false otherwise
	 * @param s the Scania vehicle to perform the method on
	 */
	private void setLoadingPlatform(boolean up, Scania s) {
		if (up) {
			s.getLoadingPlatform().setAngle(0);
		} else {
			int maxAngle = s.getLoadingPlatform().getMaxAngle();
			s.getLoadingPlatform().setAngle(maxAngle);
		}
	}

	/**
	 * @return the frame's vehicles
	 */
	public ArrayList<Vehicle> getVehicles() {
		return vehicles;
	}

	/**
	 * @param vehicles sets the frame's vehicles
	 */
	public void setVehicles(ArrayList<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}


}