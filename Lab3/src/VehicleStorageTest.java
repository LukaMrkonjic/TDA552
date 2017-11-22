import org.junit.Test;

import java.awt.geom.Point2D;
import java.util.LinkedList;

import static org.junit.Assert.*;

public class VehicleStorageTest {
	@Test
	public void setPosition() throws Exception {
		VehicleStorage vehicleStorage = new VehicleStorage(1000, 4);
		vehicleStorage.setPosition(new Point2D.Double(2.2,3.2));
		assertNotNull(vehicleStorage.getPosition());
		assertEquals((2.2), vehicleStorage.getPosition().getX(), 0.0001);
		assertEquals((3.2), vehicleStorage.getPosition().getY(), 0.0001);
	}

	@Test
	public void addVehicle() throws Exception {
		VehicleStorage vehicleStorage = new VehicleStorage(1000, 4);
		Volvo240 volvo = new Volvo240();
		//Test whether struct for keeping vehicles works
		vehicleStorage.addVehicle(volvo);
		LinkedList<Vehicle> vehicleList = new LinkedList<>();
		vehicleList.add(volvo);
		assertEquals(vehicleList, vehicleStorage.getVehicles());


		//Test whether currentStorageSpaceLeft is updated correctly
		double storageLeft = vehicleStorage.getMaxStorageSpace() - volvo.getTransportSize();
		assertEquals(storageLeft, vehicleStorage.getCurrentStorageSpaceLeft(), 0.0001);

		//Test whether vehicleCount is updated correctly
		int vehicleCount = 1;
		assertEquals(vehicleCount, vehicleStorage.getVehicleCount(), 0.0001);
	}

	@Test
	public void removeVehicle() throws Exception {
		VehicleStorage vehicleStorage = new VehicleStorage(1000, 4);
		Volvo240 volvo = new Volvo240();
		vehicleStorage.addVehicle(volvo);

		vehicleStorage.removeVehicle(0);
		LinkedList<Vehicle> emptyList = new LinkedList<>();

		assertEquals(emptyList, vehicleStorage.getVehicles());
	}
}