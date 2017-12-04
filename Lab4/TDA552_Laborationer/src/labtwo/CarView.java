package labtwo;

import car.Car;
import interfaces.Drawable;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching it's controller in it's state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of it's components.
 **/

public class CarView extends JFrame {
    private static final int width = 800;
    private static final int height = 800;

    public DrawPanel getDrawPanel() {
        return drawPanel;
    }

    final private DrawPanel drawPanel;

    private final JPanel controlPanel = new JPanel();

    private final JPanel gasPanel = new JPanel();
    private JSpinner gasSpinner = new JSpinner();
    private int gasAmount = 100;
    private final JLabel gasLabel = new JLabel("Amount of gas");

    private final JButton gasButton = new JButton("Gas");
    private final JButton brakeButton = new JButton("Brake");
    private final JButton turboOnButton = new JButton("Saab Turbo on");
    private final JButton turboOffButton = new JButton("Saab Turbo off");
    private final JButton liftBedButton = new JButton("Raise Lift Bed");
    private final JButton lowerBedButton = new JButton("Lower Lift Bed");

    private final JButton startButton = new JButton("Start all cars");
    private final JButton stopButton = new JButton("Stop all cars");

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

    public int getDrawPanelHeight() {
        return drawPanel.getHeight();
    }

    public int getDrawPanelwidth() {
        return drawPanel.getWidth();
    }

    public void addDrawable(Drawable drawable) {
        drawPanel.addDrawable(drawable);
    }

    public void repaintDrawPanel() {
        getDrawPanel().repaint();
    }

    /**
     * Initializes the CarView.
     *
     * @param frameName The frame name.
     * @param cc        The car controller.
     */
    public CarView(String frameName, CarController cc) {
        drawPanel = new DrawPanel(width, height - 240, cc);
        //this.carController = cc;
        initComponents(frameName);
    }

    // Sets everything in place and fits everything
    private void initComponents(String title) {

        this.setTitle(title);
        this.setPreferredSize(new Dimension(width, height));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        this.add(drawPanel);

        //------------ Component Initializes ------------//

        SpinnerModel spinnerModel =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        100, //max
                        1);//step
        gasSpinner = new JSpinner(spinnerModel);
        gasSpinner.setValue(gasAmount);
        gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner) e.getSource()).getValue();
            }
        });

        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);

        this.add(gasPanel);

        controlPanel.setLayout(new GridLayout(2, 4));

        controlPanel.add(gasButton, 0);
        controlPanel.add(turboOnButton, 1);
        controlPanel.add(liftBedButton, 2);
        controlPanel.add(brakeButton, 3);
        controlPanel.add(turboOffButton, 4);
        controlPanel.add(lowerBedButton, 5);
        controlPanel.setPreferredSize(new Dimension((width / 2) + 4, 200));
        this.add(controlPanel);
        controlPanel.setBackground(Color.CYAN);


        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        startButton.setPreferredSize(new Dimension(width / 5 - 15, 200));
        this.add(startButton);


        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension(width / 5 - 15, 200));
        this.add(stopButton);

        //------------ Action Listeners ------------//

//        gasButton.addActionListener(e -> carController.gas(gasAmount));
//
//        brakeButton.addActionListener(e -> carController.brake(gasAmount));
//
//        turboOnButton.addActionListener(e -> {
//            carController.setTurbo(true);
//        });
//        turboOffButton.addActionListener(e -> {
//            carController.setTurbo(false);
//        });
//
//        liftBedButton.addActionListener(e -> {
//            carController.liftRamp(true);
//        });
//        lowerBedButton.addActionListener(e -> {
//            carController.liftRamp(false);
//        });
//
//        startButton.addActionListener(e -> {
//            for (Car car : carController.cars) {
//                car.startEngine();
//            }
//        });
//
//        stopButton.addActionListener(e -> {
//            for (Car car : carController.cars) {
//                car.stopEngine();
//            }
//        });

        //------------ Frame Initialization ------------//

        // Make the frame pack all it's components by respecting the sizes if possible.
        this.pack();

        this.setResizable(false);

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
