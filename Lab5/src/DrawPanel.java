import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // Just a single image, TODO: Generalize
    HashMap<String, BufferedImage> images = new HashMap<>();
    // To keep track of a single cars position
    Point carPoint = new Point();
	private ArrayList<Vehicle> vehiclesToBeDrawn = new ArrayList<>();	//so the drawpanel knows what to draw, controlled by CarController


	public ArrayList<Vehicle> getVehiclesToBeDrawn() {
		return vehiclesToBeDrawn;
	}

	public void setVehiclesToBeDrawn(ArrayList<Vehicle> toBeDrawn) {
		this.vehiclesToBeDrawn = toBeDrawn;
	}


    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        addImages();
    }

    private void addImages() {
		// Print an error message in case file is not found with a try/catch block
		try {
			// You can remove the "src\\pics" part if running outside of IntelliJ and
			// everything is in the same main folder.
			// Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
			// if you are starting in IntelliJ.
			// Linux users need to modify \ to / in path string
			images.put("Saab95", ImageIO.read(new File("src/pics/Saab95.jpg")));
			images.put("Scania", ImageIO.read(new File("src/pics/Scania.jpg")));
			images.put("Volvo240", ImageIO.read(new File("src/pics/Volvo240.jpg")));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}


    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Vehicle v : getVehiclesToBeDrawn()) {
			int x = (int) Math.round(v.getPosition().getX());
			int y = (int) Math.round(v.getPosition().getY());
			g.drawImage(images.get(v.getModelName()), x, y, null); // see javadoc for more info on the parameters
		}

    }

}
