import java.awt.*;

//TODO: fix Javadoc
public interface Movable{

    /**
     * Method that moves the transport in its current direction, and updates
     * its position. The distance it's moved depends on its current speed.
     */
    public void move();

    /**
     * Checks which direction is the transport's current direction:
     * (0, 1) = North
     * (1, 0) = East
     * (0, -1) = South
     * (-1, 0) = West
     * <p>
     * and then updates the direction to to one the transport would have after a left-turn.
     */
    public void turnLeft();

    /**
     * Checks which direction is the transport's current direction:
     * (0, 1) = North
     * (1, 0) = East
     * (0, -1) = South
     * (-1, 0) = West
     * <p>
     * and then updates the direction to to one the transport would have after a right-turn.
     */
    public void turnRight();

}
