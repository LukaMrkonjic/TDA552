package labtwo;

import car.Car;

import javax.swing.*;
import java.awt.*;

/**
 * This panel represent the animated part of the view with the car images.
 */
public class DrawPanel extends JPanel {

    private final CarController cc;

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
        this.cc = cc;
    }

    /**
     * Moves the car in its direction and flips it if a wall collision occurs.
     *
     * @param car The car to move.
     */
    void moveCar(Car car) {

        car.move();

        if (wallCollision(car)) {
            car.stopEngine();

            car.flip();

            switch (car.getDirection()) {

                case NORTH:
                    car.setY(0);
                    break;

                case EAST:
                    car.setX(0);
                    break;

                case SOUTH:
                    car.setY(getHeight() - car.getHeight());
                    break;

                case WEST:
                    car.setX(getWidth() - car.getWidth());
                    break;

            }

            car.startEngine();
        }

    }

    // Checks for wall collision
    private boolean wallCollision(Car car) {

        switch (car.getDirection()) {

            case NORTH:
                return car.getY() < 0;

            case EAST:
                return car.getX() + car.getWidth() > getWidth();

            case SOUTH:
                return car.getY() + car.getHeight() > getHeight();

            case WEST:
                return car.getX() < 0;
        }

        return false;
    }


    /**
     * This method is called each time the panel updates/refreshes/repaints itself
     *
     * @param g The Graphics object to protect.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Car car : cc.cars) {
            g.drawImage(car.getImage(), (int) (car.getX() + 0.5), (int) (car.getY() + 0.5), null); // see javadoc for more info on the parameters
        }
    }
}
