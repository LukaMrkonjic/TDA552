import java.awt.*;
import java.awt.geom.Point2D;

import static org.junit.Assert.*;

public class Saab95Test {
    Saab95 saab = new Saab95();
    @org.junit.Test
    public void getSpeedFactor() throws Exception {

        assertEquals(1.25, saab.getSpeedFactor(), 0.001);
    }

    @org.junit.Test
    public void move() throws Exception {
        saab.incrementSpeed(1);
        saab.move();
        Point2D afterMoveExp= new Point2D.Double(0,1);
        Point2D afterMoveAct=new Point2D.Double();
        afterMoveAct=saab.getPosition();
        assertEquals(afterMoveExp, afterMoveAct);
    }

    @org.junit.Test
    public void turnRight() throws Exception {
    }

    @org.junit.Test
    public void turnLeft() throws Exception {
    }

}