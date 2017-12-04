package TransportView;

import TransportModel.Vehicle;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.ArrayList;

/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching it's controller in it's state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of it's components.
 * TODO: Write more actionListeners and wire the rest of the buttons
 **/

public class CarView extends JFrame {
    private static final int X = 800;
    private static final int Y = 800;

    // The controller member
    private DrawPanel drawPanel;

    private JPanel controlPanel;

    private JPanel gasPanel;
    private JSpinner gasSpinner;
    private int gasAmount;
    private JLabel gasLabel;

    private JButton gasButton;
    private JButton brakeButton;

    private JButton turboOnButton;
    private JButton turboOffButton;

    private JButton liftBedButton;
    private JButton lowerBedButton;

    private JButton startButton;
    private JButton stopButton;

    private JButton turnRightButton;
    private JButton turnLeftButton;

    private ArrayList<Vehicle> vehicles; // A list of cars, modify if needed

    // Constructor
    public CarView(String framename, TransportController.CarController cc) {

        vehicles = cc.vehicles;

        setDrawPanel(new DrawPanel(X, Y - 240));
        setControlPanel(new JPanel());

        setGasPanel(new JPanel());
        setGasSpinner(new JSpinner());
        gasAmount = 0;
        gasLabel = new JLabel("Amount of gas");
        gasButton = new JButton("Gas");
        brakeButton = new JButton("Brake");
        turboOnButton = new JButton("Saab Turbo on");
        turboOffButton = new JButton("Saab Turbo off");
        liftBedButton = new JButton("TransportModel.Scania Lift Bed");
        lowerBedButton = new JButton("TransportModel.Scania Lower Bed");
        startButton = new JButton("Start all cars");
        stopButton = new JButton("Stop all cars");
        turnRightButton = new JButton("Turn Left"); //For UI reasons, the buttons' names are inverted.
        turnLeftButton = new JButton("Turn Right"); // This is because of the inverted nature of the x,y-grid of the frame.
        initComponents(framename);
    }


    public DrawPanel getDrawPanel() {
        return drawPanel;
    }

    public void setDrawPanel(DrawPanel drawPanel) {
        this.drawPanel = drawPanel;
    }

    /**
     * Sets everything in place and fits everything
     */
    private void initComponents(String title) {

        this.setTitle(title);
        this.setPreferredSize(new Dimension(X, Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        this.add(getDrawPanel());

        SpinnerModel spinnerModel =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        100, //max
                        1);//step
        setGasSpinner(new JSpinner(spinnerModel));
        getGasSpinner().addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner) e.getSource()).getValue();
            }
        });

        getGasPanel().setLayout(new BorderLayout());
        getGasPanel().add(gasLabel, BorderLayout.PAGE_START);
        getGasPanel().add(gasSpinner, BorderLayout.PAGE_END);

        this.add(getGasPanel());

        getControlPanel().setLayout(new GridLayout(2, 4));

        getControlPanel().add(gasButton, 0);
        getControlPanel().add(turboOnButton, 1);
        getControlPanel().add(liftBedButton, 2);
        getControlPanel().add(turnLeftButton, 3);
        getControlPanel().add(brakeButton, 4);
        getControlPanel().add(turboOffButton, 5);
        getControlPanel().add(lowerBedButton, 6);
        getControlPanel().add(turnRightButton, 7);

        getControlPanel().setPreferredSize(new Dimension((X / 2) + 4, 200));
        this.add(getControlPanel());
        getControlPanel().setBackground(Color.CYAN);


        getStartButton().setBackground(Color.blue);
        getStartButton().setForeground(Color.green);
        getStartButton().setPreferredSize(new Dimension(X / 5 - 15, 200));
        this.add(getStartButton());


        getStopButton().setBackground(Color.red);
        getStopButton().setForeground(Color.black);
        getStopButton().setPreferredSize(new Dimension(X / 5 - 15, 200));
        this.add(getStopButton());


        getTurnLeftButton().addActionListener(e -> {
            for (Vehicle car : vehicles) {
                car.turnLeft();
            }
        });

        getTurnRightButton().addActionListener(e -> {
            for (Vehicle car : vehicles) {
                car.turnRight();
            }
        });

        getStopButton().addActionListener(e -> {
            for (Vehicle v : vehicles) {
                v.stopIfCars();
            }
        });

        getStartButton().addActionListener(e -> {
            for (Vehicle v : vehicles) {
                v.startIfCars();
            }
        });

        getTurboOnButton().addActionListener(e -> {
            for (Vehicle v : vehicles) {
                v.setTurbo(true);
            }
        });

        getTurboOffButton().addActionListener(e -> {
            for (Vehicle v : vehicles) {
                v.setTurbo(false);
            }
        });

        getGasButton().addActionListener(e -> {
            for (Vehicle v : vehicles) {
                v.gas(gasAmount / 100d);
            }
        });

        getBrakeButton().addActionListener(e -> {
            for (Vehicle v : vehicles) {
                v.brake(gasAmount / 100d);
            }
        });

        getLowerBedButton().addActionListener(e -> {
            for (Vehicle v : vehicles) {
                v.setBed(false);
            }
        });

        getLiftBedButton().addActionListener(e -> {
            for (Vehicle v : vehicles) {
                v.setBed(true);
            }
        });

        // Make the frame pack all it's components by respecting the sizes if possible.
        this.pack();

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public JPanel getControlPanel() {
        return controlPanel;
    }

    public void setControlPanel(JPanel controlPanel) {
        this.controlPanel = controlPanel;
    }

    public JPanel getGasPanel() {
        return gasPanel;
    }

    public void setGasPanel(JPanel gasPanel) {
        this.gasPanel = gasPanel;
    }

    public JSpinner getGasSpinner() {
        return gasSpinner;
    }

    public void setGasSpinner(JSpinner gasSpinner) {
        this.gasSpinner = gasSpinner;
    }

    public int getGasAmount() {
        return gasAmount;
    }

    public void setGasAmount(int gasAmount) {
        this.gasAmount = gasAmount;
    }

    public JLabel getGasLabel() {
        return gasLabel;
    }

    public void setGasLabel(JLabel gasLabel) {
        this.gasLabel = gasLabel;
    }

    public JButton getGasButton() {
        return gasButton;
    }

    public void setGasButton(JButton gasButton) {
        this.gasButton = gasButton;
    }

    public JButton getBrakeButton() {
        return brakeButton;
    }

    public void setBrakeButton(JButton brakeButton) {
        this.brakeButton = brakeButton;
    }

    public JButton getTurboOnButton() {
        return turboOnButton;
    }

    public void setTurboOnButton(JButton turboOnButton) {
        this.turboOnButton = turboOnButton;
    }

    public JButton getTurboOffButton() {
        return turboOffButton;
    }

    public void setTurboOffButton(JButton turboOffButton) {
        this.turboOffButton = turboOffButton;
    }

    public JButton getLiftBedButton() {
        return liftBedButton;
    }

    public void setLiftBedButton(JButton liftBedButton) {
        this.liftBedButton = liftBedButton;
    }

    public JButton getLowerBedButton() {
        return lowerBedButton;
    }

    public void setLowerBedButton(JButton lowerBedButton) {
        this.lowerBedButton = lowerBedButton;
    }

    public JButton getStartButton() {
        return startButton;
    }

    public void setStartButton(JButton startButton) {
        this.startButton = startButton;
    }

    public JButton getStopButton() {
        return stopButton;
    }

    public void setStopButton(JButton stopButton) {
        this.stopButton = stopButton;
    }

    public JButton getTurnRightButton() {
        return turnRightButton;
    }

    public void setTurnRightButton(JButton turnRightButton) {
        this.turnRightButton = turnRightButton;
    }

    public JButton getTurnLeftButton() {
        return turnLeftButton;
    }

    public void setTurnLeftButton(JButton turnLeftButton) {
        this.turnLeftButton = turnLeftButton;
    }

}