import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching it's controller in it's state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of it's components.
 * TODO: Write more actionListeners and wire the rest of the buttons
 **/

public class CarView extends JFrame{
    private static final int X = 800;
    private static final int Y = 800;

    // The controller member
    private CarController carC;
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

    // Constructor
    public CarView(String framename, CarController cc){
        this.carC = cc;


        setDrawPanel(new DrawPanel(X, Y - 240));
		setControlPanel(new JPanel());

		setGasPanel(new JPanel());
		gasSpinner = new JSpinner();
		gasAmount = 0;
		gasLabel = new JLabel("Amount of gas");
		gasButton = new JButton("Gas");
		brakeButton = new JButton("Brake");
		turboOnButton = new JButton("Saab Turbo on");
		turboOffButton = new JButton("Saab Turbo off");
		liftBedButton = new JButton("Scania Lift Bed");
		lowerBedButton = new JButton("Scania Lower Bed");
		startButton = new JButton("Start all cars");
		stopButton = new JButton("Stop all cars");
		initComponents(framename);
    }


    public DrawPanel getDrawPanel() {
        return drawPanel;
    }

    public void setDrawPanel(DrawPanel drawPanel) {
        this.drawPanel = drawPanel;
    }

    // Sets everything in place and fits everything
    // TODO: Take a good look and make sure you understand how these methods and components work
    private void initComponents(String title) {

        this.setTitle(title);
        this.setPreferredSize(new Dimension(X,Y));
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
                gasAmount = (int) ((JSpinner)e.getSource()).getValue();
            }
        });

        getGasPanel().setLayout(new BorderLayout());
		getGasPanel().add(gasLabel, BorderLayout.PAGE_START);
		getGasPanel().add(gasSpinner, BorderLayout.PAGE_END);

        this.add(getGasPanel());

        getControlPanel().setLayout(new GridLayout(2,4));

		getControlPanel().add(gasButton, 0);
		getControlPanel().add(turboOnButton, 1);
		getControlPanel().add(liftBedButton, 2);
		getControlPanel().add(brakeButton, 3);
		getControlPanel().add(turboOffButton, 4);
		getControlPanel().add(lowerBedButton, 5);
		getControlPanel().setPreferredSize(new Dimension((X/2)+4, 200));
        this.add(getControlPanel());
		getControlPanel().setBackground(Color.CYAN);


        getStartButton().setBackground(Color.blue);
		getStartButton().setForeground(Color.green);
		getStartButton().setPreferredSize(new Dimension(X/5-15,200));
        this.add(getStartButton());


        getStopButton().setBackground(Color.red);
		getStopButton().setForeground(Color.black);
		getStopButton().setPreferredSize(new Dimension(X/5-15,200));
        this.add(getStopButton());

        // This actionListener is for the gas button only
        // TODO: Create more for each component as necessary
        getStopButton().addActionListener(new ActionListener() {
        	@Override
			public void actionPerformed(ActionEvent e) {
        		carC.stopAllCars();
			}
		});

		getStartButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				carC.startAllCars();
			}
		});


		getGasButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.gas(gasAmount);
            }
        });

        getBrakeButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.brake(gasAmount);
            }
        });

        getLowerBedButton().addActionListener(new ActionListener() {
        	@Override
			public void actionPerformed(ActionEvent e) {
        		carC.lowerBed();
        	}
		});

        getLiftBedButton().addActionListener(new ActionListener(){
        	@Override
			public void actionPerformed(ActionEvent e) {
        		carC.liftBed();
			}
		});

        // Make the frame pack all it's components by respecting the sizes if possible.
        this.pack();

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
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
}