package TransportController;

import TransportModel.Vehicle;
import TransportView.CarView;
import TransportModel.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

/**
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
*/

public class CarController {
	// member fields:

	private TransportModel tm;
	private TransportView.CarView frame; // The frame that represents this instance View of the MVC pattern
	private int gasAmount; //The controller must get the gas amount from the View
	private final int delay = 50;  // The delay (ms) corresponds to 20 updates a sec (hz)
	private Timer timer; // The timer is started with an listener (see below) that executes the statements each step between delays.


	public CarController(TransportModel tm, CarView frame) {
		this.tm = tm;
		this.frame = frame;

		setTimer(new Timer(delay, new TimerListener));

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
		frame.getAddCarButton().addActionListener(addCar);
		frame.getRemoveCarButton().addActionListener(removeCar);
	}


	/** Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    *
	 */
	private class TimerListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			gasAmount = frame.getGasAmount();
			for (Vehicle car : tm.getVehicles()) {
				car.move();
				if (car.isOutOfBounds(frame.getDrawPanel().getSize())) {
					car.invertDirection();
					car.move();
					car.move();
				}
			}
			// repaint() calls the paintComponent method of the panel
			frame.getDrawPanel().repaint();
		}
	}

	/**
	 * @return the frame's vehicles
	 */
	public ArrayList<Vehicle> getVehicles() {
		return tm.getVehicles();
	}

	/**
	 * @param vehicles sets the frame's vehicles
	 */
	public void setVehicles(ArrayList<Vehicle> vehicles) {
		tm.setVehicles(vehicles);
	}

	/**
	 * @return the timer
	 */
	public Timer getTimer() {
		return timer;
	}

	/**
	 * @param timer to be set
	 */
	public void setTimer(Timer timer) {
		this.timer = timer;
	}

	/**
	 * ActionListeners ---------------------------------
	 */
	ActionListener addCar = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				tm.addCar();
			}
			catch (IOException e1) {
				System.out.print("Can't add car");
			}
		}
	};

	ActionListener removeCar = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			tm.removeCar();
		}
	};

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
}