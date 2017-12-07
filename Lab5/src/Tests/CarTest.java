/*
package Tests;

import TransportModel.Saab95;

import java.awt.*;

import static org.junit.Assert.*;

public class CarTest {

	@org.junit.Test
	public void startEngine() throws Exception {
		Saab95 saab95 = new Saab95();
		saab95.startEngine();
		assertEquals(0.1, saab95.getCurrentSpeed(), 0.00001);
	}

	@org.junit.Test
	public void stopEngine() throws Exception {
	}

	@org.junit.Test
	public void incrementSpeed() throws Exception {
	}

	@org.junit.Test
	public void decrementSpeed() throws Exception {
	}

	@org.junit.Test
	public void gas() throws Exception {
	}

	@org.junit.Test
	public void brake() throws Exception {
	}

	@org.junit.Test
	public void move() throws Exception {
	}

	@org.junit.Test
	public void turnRight() throws Exception {
		Saab95 saab95 = new Saab95();

		// Test turning right from North
		saab95.setDirection(new Point(0,1)); //start North
		saab95.turnRight();							//turn right, to East
		Point p = new Point(1,0);						//East direction
		assertEquals(p.getX(), saab95.getDirection().getX(), 0.00001);
		assertEquals(p.getY(), saab95.getDirection().getY(), 0.00001);

		// Test turning right from West
		saab95.setDirection(new Point(-1,0)); //start West
		saab95.turnRight();							//turn right, to North
		p.setLocation(0, 1);					//North direction
		assertEquals(p.getX(), saab95.getDirection().getX(), 0.00001);
		assertEquals(p.getY(), saab95.getDirection().getY(), 0.00001);

		// Test turning right from South
		saab95.setDirection(new Point(0,-1)); //start South
		saab95.turnRight();							//turn right, to West
		p.setLocation(-1, 0);					//West direction
		assertEquals(p.getX(), saab95.getDirection().getX(), 0.00001);
		assertEquals(p.getY(), saab95.getDirection().getY(), 0.00001);

		// Test turning right from East
		saab95.setDirection(new Point(1,0)); //start East
		saab95.turnRight();							//turn right, to South
		p.setLocation(0, -1);					//South direction
		assertEquals(p.getX(), saab95.getDirection().getX(), 0.00001);
		assertEquals(p.getY(), saab95.getDirection().getY(), 0.00001);
	}

	@org.junit.Test
	public void turnLeft() throws Exception {
		Saab95 saab95 = new Saab95();

		// Test turning left from North
		saab95.setDirection(new Point(0,1)); //start North
		saab95.turnLeft();							//turn left, to West
		Point p = new Point(-1,0);						//West direction
		assertEquals(p.getX(), saab95.getDirection().getX(), 0.00001);
		assertEquals(p.getY(), saab95.getDirection().getY(), 0.00001);

		// Test turning left from West
		saab95.setDirection(new Point(-1,0)); //start West
		saab95.turnLeft();							//turn left, to South
		p.setLocation(0, -1);					//South direction
		assertEquals(p.getX(), saab95.getDirection().getX(), 0.00001);
		assertEquals(p.getY(), saab95.getDirection().getY(), 0.00001);

		// Test turning left from South
		saab95.setDirection(new Point(0,-1)); //start South
		saab95.turnLeft();							//turn left, to East
		p.setLocation(1, 0);					//East direction
		assertEquals(p.getX(), saab95.getDirection().getX(), 0.00001);
		assertEquals(p.getY(), saab95.getDirection().getY(), 0.00001);

		// Test turning left from East
		saab95.setDirection(new Point(1,0)); //start East
		saab95.turnLeft();							//turn left, to North
		p.setLocation(0, 1);					//North direction
		assertEquals(p.getX(), saab95.getDirection().getX(), 0.00001);
		assertEquals(p.getY(), saab95.getDirection().getY(), 0.00001);
	}

}
*/