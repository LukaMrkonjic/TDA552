/*
package test;

import car.CarTransport;
import car.Saab95;
import car.Scania;
import car.Volvo240;
import enums.RampState;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class CarTransportTest {

    @Test
    void move() {
        CarTransport transport = new CarTransport(3);

        transport.gas(1);
        while (transport.getY() > -7.5) {
            transport.move();
        }
        transport.stopEngine();
        transport.lowerRamp();

        Volvo240 volvo = new Volvo240();
        Saab95 saab95 = new Saab95();
        Scania scania = new Scania();
        transport.loadCar(volvo);
        transport.loadCar(saab95);
        transport.loadCar(scania);

        transport.raiseRamp();

        transport.gas(1);
        transport.move();

        assertEquals(transport.getX(), volvo.getX());
        assertEquals(transport.getY(), volvo.getY());

        assertEquals(transport.getX(), saab95.getX());
        assertEquals(transport.getY(), saab95.getY());

        assertEquals(transport.getX(), scania.getX());
        assertEquals(transport.getY(), scania.getY());

    }

    @Test
    void lowerRamp() {

        CarTransport transport = new CarTransport(3);
        transport.lowerRamp();
        assertEquals(RampState.DOWN, transport.getRampState());

        transport.gas(1);
        assertEquals(0, transport.getCurrentSpeed());

        transport.raiseRamp();
        assertEquals(RampState.UP, transport.getRampState());

        transport.gas(1);
        transport.lowerRamp();
        assertEquals(RampState.UP, transport.getRampState());

    }

    @Test
    void loadCar() {

        CarTransport transport = new CarTransport(3);

        transport.gas(1);
        while (transport.getY() > -7.5) {
            transport.move();
        }
        transport.stopEngine();
        transport.lowerRamp();

        Volvo240 volvo = new Volvo240();
        Saab95 saab95 = new Saab95();
        Scania scania = new Scania();
        Scania truck = new Scania();
        transport.loadCar(volvo);
        transport.loadCar(saab95);
        transport.loadCar(scania);
        transport.loadCar(truck);

        assertEquals(scania, transport.unloadCar());

        transport.loadCar(transport);

        assertEquals(saab95, transport.unloadCar());

    }

    @Test
    void unloadCar() {
        CarTransport transport = new CarTransport(3);

        transport.gas(1);
        while (transport.getY() > -7.5) {
            transport.move();
        }
        transport.stopEngine();
        transport.lowerRamp();

        Volvo240 volvo = new Volvo240();
        Saab95 saab95 = new Saab95();
        Scania scania = new Scania();
        transport.loadCar(volvo);
        transport.loadCar(saab95);
        transport.loadCar(scania);

        assertEquals(scania, transport.unloadCar());
        assertEquals(saab95, transport.unloadCar());
        assertEquals(volvo, transport.unloadCar());

        assertNull(transport.unloadCar());

        assertEquals(0, transport.getNumLoadedCars());

    }

    @Test
    void getNumLoadedCars() {
        CarTransport transport = new CarTransport(3);

        assertEquals(0, transport.getNumLoadedCars());

        transport.gas(1);
        while (transport.getY() > -7.5) {
            transport.move();
        }
        transport.stopEngine();
        transport.lowerRamp();

        transport.loadCar(new Volvo240());
        assertEquals(1, transport.getNumLoadedCars());

        transport.loadCar(new Volvo240());
        assertEquals(2, transport.getNumLoadedCars());
    }

}
*/