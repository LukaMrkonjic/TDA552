package TransportView;

import TransportModel.TransportModel;
import TransportModel.Vehicle;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching it's controller in it's state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of it's components.
 **/
public class CarView extends JFrame {

    //The carView has access to the  transportModel in order for the DrawPanel to be able
    // to know what vehicles to draw.
    private TransportModel tm;

    //The CarView has two dimensions
    private static final int width = 800;
    private static final int height = 800;

    //This represents the part of the view where the vehicles are drawn.
    private DrawPanel drawPanel;

    //This represents the part of the view where the buttons sit.
    private JPanel controlPanel;

    //Part of the view that allows user to control gas.
    private JPanel gasPanel;
    private JSpinner gasSpinner;
    private int gasAmount;
    private JLabel gasLabel;

    //These are all buttons that allow the user to control behavior of vehicles in
    //the drawPanel
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

    private JButton addCarButton;
    private JButton removeCarButton;


    /**
     * The constructor for CarView
     * @param framename The name of the View
     * @param tm The controller that the view will pass on to its DrawPanel
     *           so that the panel knows what vehicles are in the model
     *           and therefore should be drawn.
     */
    public CarView(String framename, TransportModel tm) {
        this.tm = tm;
        setDrawPanel(new DrawPanel(width, height - 240, tm));
        setControlPanel(new JPanel());

        //Sets gas controller details
        setGasPanel(new JPanel());
        setGasSpinner(new JSpinner());
        setGasAmount(0);
        setGasLabel(new JLabel("Amount of gas"));

        //Sets Buttons
        setGasButton(new JButton("Gas"));
        setBrakeButton(new JButton("Brake"));
        setTurboOnButton(new JButton("Saab Turbo on"));
        setTurboOffButton(new JButton("Saab Turbo off"));
        setLiftBedButton(new JButton("Lift Bed Scania"));
        setLowerBedButton(new JButton("Lower Bed Scania"));
        setStartButton(new JButton("Start all cars"));
        setStopButton(new JButton("Stop all cars"));
        setTurnRightButton(new JButton("Turn Left")); //For UI reasons, the buttons' names are inverted.
        setTurnLeftButton(new JButton("Turn Right")); // This is because of the inverted nature of the x,y-grid of the frame.
        setAddCarButton(new JButton("Add Car"));
        setRemoveCarButton(new JButton( "Remove Car"));

        //Calls a method to set everything in place
        initComponents(framename);
    }

    /**
     * Sets everything in place and fits everything
     */
    private void initComponents(String title) {
        this.setTitle(title);
        this.setPreferredSize(new Dimension(width, height));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        this.add(getDrawPanel());

        SpinnerModel spinnerModel =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        100, //max
                        1);//step
        setGasSpinner(new JSpinner(spinnerModel));

        //TODO: Ska detta verkligen ligga här? Controller, right?
        getGasSpinner().addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner) e.getSource()).getValue();
            }
        });


        getControlPanel().setLayout(new GridLayout(2, 6));

        getControlPanel().add(gasButton, 0);
        getControlPanel().add(turboOnButton, 1);
        getControlPanel().add(liftBedButton, 2);
        getControlPanel().add(turnLeftButton, 3);
        getControlPanel().add(addCarButton, 4);
        getControlPanel().add(startButton, 5);
        getControlPanel().add(brakeButton, 6);
        getControlPanel().add(turboOffButton, 7);
        getControlPanel().add(lowerBedButton, 8);
        getControlPanel().add(turnRightButton, 9);
        getControlPanel().add(removeCarButton, 10);
        getControlPanel().add(stopButton, 11);

        getControlPanel().setPreferredSize(new Dimension((width) - 100, 200));
        this.add(getControlPanel());
        getControlPanel().setBackground(Color.CYAN);

        getGasPanel().setLayout(new BorderLayout());
        getGasPanel().add(gasLabel, BorderLayout.PAGE_START);
        getGasPanel().add(gasSpinner, BorderLayout.PAGE_END);
        getGasPanel().setPreferredSize(new Dimension (100, 200));

        this.add(getGasPanel());

        getStartButton().setBackground(Color.BLUE);
        getStartButton().setForeground(Color.green);

        getStopButton().setBackground(Color.RED);
        getStopButton().setForeground(Color.black);

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

    /**
     * Methods to set actionlisteners to all components.
     * @param action
     */
    public void setGasButtonAction(ActionListener action) {
        this.gasButton.addActionListener(action);
    }

    public void setBrakeButtonAction(ActionListener action) {
        this.brakeButton.addActionListener(action);
    }

    public void setTurboOnButtonAction(ActionListener action) {
        this.turboOnButton.addActionListener(action);
    }

    public void setTurboOffButtonAction(ActionListener action) {
        this.turboOffButton.addActionListener(action);
    }

    public void setLiftBedButtonAction(ActionListener action) {
        this.liftBedButton.addActionListener(action);
    }

    public void setLowerBedButtonAction(ActionListener action) {
        this.lowerBedButton.addActionListener(action);
    }

    public void setStartButtonAction(ActionListener action) {
        this.startButton.addActionListener(action);
    }

    public void setStopButtonAction(ActionListener action) {
        this.stopButton.addActionListener(action);
    }

    public void setAddCarButtonAction(ActionListener action) {
        this.addCarButton.addActionListener(action);
    }

    public void setRemoveCarButtonAction(ActionListener action) {
        this.removeCarButton.addActionListener(action);
    }

    /**
     * Getters and setters for all components.
     * @return
     */
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

    public JButton getAddCarButton() {
        return addCarButton;
    }

    public void setAddCarButton(JButton addCarButton) {
        this.addCarButton = addCarButton;
    }

    public JButton getRemoveCarButton() {
        return removeCarButton;
    }

    public void setRemoveCarButton(JButton removeCarButton) {
        this.removeCarButton = removeCarButton;
    }

    public void setDrawPanel(DrawPanel drawPanel) {
        this.drawPanel = drawPanel;
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    public DrawPanel getDrawPanel() {
        return drawPanel;
    }
}