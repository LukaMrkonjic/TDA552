import static org.junit.Assert.*;

/**
 * Created by lukamrkonjic on 2017-11-07.
 */
public class Volvo240Test {
    @org.junit.Test
    public void getSpeedFactor() throws Exception {
        Volvo240 volvo = new Volvo240();
        assertNotNull(volvo);
        assertNotNull(volvo.getSpeedFactor());
        assertEquals(1.25, volvo.getSpeedFactor(), 0.001);
    }

}