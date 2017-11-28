package interfaces;

/**
 * Makes an object movable.
 */
public interface Movable {

    /**
     * Moves the object in the direction that it faces.
     */
    void move();

    /**
     * Turns the object left.
     */
    void turnLeft();

    /**
     * Turns the object right.
     */
    void turnRight();

    /**
     * Inverts the object's direction.
     */
    void flip();

    /**
     * Returns the current speed.
     *
     * @return The current speed.
     */
    double getCurrentSpeed();

}
