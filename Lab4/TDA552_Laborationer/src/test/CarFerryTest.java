package test;

import boat.CarFerry;
import car.Saab95;
import car.Scania;
import car.Volvo240;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarFerryTest {

    @Test
    void loadCar() {

        CarFerry ferry = new CarFerry(3);

        ferry.gas(1);
        while (ferry.getY() > -7.5) {
            ferry.move();
        }
        ferry.stopEngine();
        ferry.lowerRamp();

        Volvo240 volvo = new Volvo240();
        Saab95 saab95 = new Saab95();
        Scania scania = new Scania();
        ferry.loadCar(volvo);
        ferry.loadCar(saab95);
        ferry.loadCar(scania);
        ferry.raiseRamp();

        assertEquals(volvo, ferry.unloadCar());
        assertEquals(saab95, ferry.unloadCar());
        assertEquals(scania, ferry.unloadCar());

        assertNull(ferry.unloadCar());

    }

    @Test
    void unloadCar() {

        CarFerry ferry = new CarFerry(3);

        ferry.gas(1);
        while (ferry.getY() > -7.5) {
            ferry.move();
        }
        ferry.stopEngine();
        ferry.lowerRamp();

        Volvo240 volvo = new Volvo240();
        Saab95 saab95 = new Saab95();
        Scania scania = new Scania();
        ferry.loadCar(volvo);
        ferry.loadCar(saab95);
        ferry.loadCar(scania);

        assertEquals(volvo, ferry.unloadCar());
        assertEquals(saab95, ferry.unloadCar());
        assertEquals(scania, ferry.unloadCar());

        assertNull(ferry.unloadCar());

        assertEquals(0, ferry.getNumLoadedCars());
        
    }

}