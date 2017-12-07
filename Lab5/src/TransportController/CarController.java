package TransportController;

import TransportModel.Vehicle;
import TransportView.CarView;
import TransportModel.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
*/

public class CarController {
	// member fields:

	TransportModel tm;
	TransportView.CarView frame; // The frame that represents this instance View of the MVC pattern
	int gasAmount;
	public ArrayList<Vehicle> vehicles;

	public CarController(TransportModel tm, CarView frame) {
		this.tm = tm;
		this.frame = frame;
		this.vehicles = tm.getVehicles();

		frame.getTurnLeftButton().addActionListener(turnLeft);
		frame.getTurnRightButton().addActionListener(turnRight);
		frame.getStartButton().addActionListener(startIfCars);
		frame.getStopButton().addActionListener(stopIfCars);
		frame.getTurboOffButton().addActionListener(turboOff);
		frame.getTurboOnButton().addActionListener(turboOn);
		frame.getGasButton().addActionListener(gas);
		frame.getBrakeButton().addActionListener(brake);
		frame.getLowerBedButton().addActionListener(bedFalse);
		frame.getLiftBedButton().addActionListener(bedTrue);
	}

	private final int delay = 50;  // The delay (ms) corresponds to 20 updates a sec (hz)
	private Timer timer = new Timer(delay, new TimerListener()); // The timer is started with an listener (see below) that executes the statements each step between delays.

	/** Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    *
	 */
	private class TimerListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			gasAmount = frame.getGasAmount();

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

	ActionListener turnLeft = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			tm.turnLeft();
		}
	};

	ActionListener turnRight = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			tm.turnRight();
		}
	};

	ActionListener stopIfCars = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			tm.stopAllCars();
		}
	};

	ActionListener startIfCars = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			tm.startAllCars();
		}
	};

	ActionListener turboOn = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			tm.setTurboOn();
		}
	};

	ActionListener turboOff = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			tm.setTurboOff();
		}
	};

	ActionListener gas = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			tm.gas(gasAmount);
		}
	};


	ActionListener brake = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			tm.brake(gasAmount);
		}
	};

	ActionListener bedFalse = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			tm.setBedTOFalse();
		}
	};

	ActionListener bedTrue = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			tm.setBedToTrue();
		}
	};

	public Timer getTimer() {
		return timer;
	}

}