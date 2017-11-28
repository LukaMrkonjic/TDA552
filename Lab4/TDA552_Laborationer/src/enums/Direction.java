package enums;

/**
 * Defines a discrete 2-dimensional direction.
 */
public enum Direction {
    NORTH, EAST, SOUTH, WEST;

    /**
     * Returns the next (counterclockwise) direction from this.
     *
     * @return The new direction.
     */
    public Direction turnLeft() {
        return turn(false);
    }

    /**
     * Returns the next (clockwise) direction from this.
     *
     * @return The new direction.
     */
    public Direction turnRight() {
        return turn(true);
    }

    /**
     * Inverts the direction.
     *
     * @return The inverted direction.
     */
    public Direction flip() {
        return turnRight().turnRight();
    }

    /**
     * <p>Turns clockwise if <code>clockwise</code> is true,
     * turns counterclockwise if <code>clockwise</code> is false.</p>
     *
     * @param clockwise If the car should turn clockwise or not.
     * @return The new direction.
     */
    private Direction turn(boolean clockwise) {
        int direction = clockwise ? 1 : -1;
        int nextOrdinal = (this.ordinal() + direction) % 4;
        nextOrdinal = nextOrdinal >= 0 ? nextOrdinal : nextOrdinal + 4;
        return Direction.values()[nextOrdinal];
    }

}
