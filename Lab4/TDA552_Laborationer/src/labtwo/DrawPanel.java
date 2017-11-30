package labtwo;

import car.Car;
import interfaces.Drawable;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * This panel represent the animated part of the view with the car images.
 */
public class DrawPanel extends JPanel {

    private ArrayList<Drawable> drawableList;

    /**
     * Initializes the panel.
     *
     * @param width  The width of the panel.
     * @param height The height of the panel.
     * @param cc     The car controller.
     */
    public DrawPanel(int width, int height, CarController cc) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.green);
        this.drawableList = new ArrayList<>();
    }

    /**
     * This method is called each time the panel updates/refreshes/repaints itself
     *
     * @param g The Graphics object to protect.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Drawable car : drawableList) {
            g.drawImage(car.getImage(), (int) (car.getX() + 0.5), (int) (car.getY() + 0.5), null);
        }

    }

    public void addDrawable(Drawable drawable) {
        drawableList.add(drawable);
    }
}
