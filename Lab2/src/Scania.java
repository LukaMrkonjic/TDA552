import java.awt.*;
import static java.awt.Color.*;

public class Scania extends Truck {

	public Scania() {
		setPosition(new Point(50,50)); 	//starting position of a new Scania Truck
		setDirection(new Point(1,0)); 	//starting direction set to East
		setSpeedFactor(2);
		setEnginePower(0.8);
		setCurrentSpeed(0.0);
		setNrDoors(2);
		setColor(Color.BLUE);
		setModelName("Tekno Scania 142H");
		loadingPlatform = new LoadingPlatform(0,70);
	}


}

