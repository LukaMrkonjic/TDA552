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

/**
 * This panel represent the animated part of the view with the car images.
 * It is responsible for updating the view whenever called upon.
 */

public class DrawPanel extends JPanel{
    /**
     * The DrawPanel has a transportModel in order to access the vehicles
     * it is supposed to draw.
     */
	TransportModel tm;

    /**
     * The constructor for the DrawPanel.
     * @param x the x-dimension
     * @param y the y-dimension
     * @param tm the TransportModel that the DrawPanel needs in order to know what vehicles to draw.
     */
    public DrawPanel(int x, int y, TransportModel tm) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        this.tm = tm;
    }

    /**
     * This method is called each time the panel updates/refreshes/repaints itself.
     * This is where the drawPanel accesses the TransportModel in order to find out
     * what to draw.
     * @param g
     */
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
