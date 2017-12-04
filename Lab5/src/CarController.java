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
	public ArrayList<Vehicle> vehicles = new ArrayList<>(); // A list of cars, modify if needed

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

				if (car.isOutOfBounds(frame.getDrawPanel().getSize())) {
					car.invertDirection();
					car.move();
					car.move();
				}
				// TODO This adds the cars every tick!!!!!!!!!!!!
				// TODO This makes the program slower and slower until it eventually
				// TODO Runs out of memory and crashes. Fix.

				frame.getDrawPanel().getVehiclesToBeDrawn().add(car);
			}
			// repaint() calls the paintComponent method of the panel
			frame.getDrawPanel().repaint();
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