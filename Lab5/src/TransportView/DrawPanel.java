package TransportView;

import TransportModel.TransportModel;
import TransportModel.Vehicle;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // Just a single image, TODO: Generalize
    // To keep track of a single cars position
    Point carPoint = new Point();

	private ArrayList<Vehicle> vehiclesToBeDrawn = new ArrayList<>();	//so the drawpanel knows what to draw, controlled by TransportController.CarController

	public ArrayList<Vehicle> getVehiclesToBeDrawn() {
		return vehiclesToBeDrawn;
	}

	TransportModel tm;

	public void setVehiclesToBeDrawn(ArrayList<Vehicle> vehiclesToBeDrawn) {
		this.vehiclesToBeDrawn = vehiclesToBeDrawn;
	}

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, TransportModel tm) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        this.tm = tm;
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		for (Vehicle v : tm.getVehicles()) {
			int x = (int) Math.round(v.getPosition().getX());
			int y = (int) Math.round(v.getPosition().getY());
			g.drawImage(v.getImage(), x, y, null); // see javadoc for more info on the parameters
		}

    }

}
