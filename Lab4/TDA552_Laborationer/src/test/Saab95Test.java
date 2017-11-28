package test;

import car.Saab95;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class Saab95Test {

    @Test
    void speedFactor() {
        Saab95 c = new Saab95();
        assertEquals(1.25, c.speedFactor());
        c.setTurboOn();
        assertEquals(1.25 * 1.3, c.speedFactor());
    }

}