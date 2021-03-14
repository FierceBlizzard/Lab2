import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PieceScoobyTest {
    @Test
    void testingScoobyMethods(){
        System.out.println("Testing Symbol");
        PieceScooby scooby = new PieceScooby();
        assertEquals("S",scooby.getSymbol());

        System.out.println("Testing Snacks");
        assertEquals(0, scooby.getNumScoobySnacks());
        scooby.collectScoobySnacks(5);
        assertEquals(4, scooby.getNumScoobySnacks());
        scooby.collectScoobySnacks(-1);
        assertEquals(4, scooby.getNumScoobySnacks());

        System.out.println("Testing Entangle and eatScoobySnacks");
        assertFalse(scooby.isEntangled());
        scooby.entangle();
        assertTrue(scooby.isEntangled());
        scooby.collectScoobySnacks(-1);
        assertTrue(scooby.isEntangled());
        scooby.collectScoobySnacks(3);
        assertFalse(scooby.isEntangled());
        assertEquals(6,scooby.getNumScoobySnacks());

    }

    @Test
    public void test_spawn(){
        System.out.println("Testing spawn");
        PieceScooby scooby = new PieceScooby("SD",10,true,false,true);
        PieceScooby scrappy = scooby.spawn();

        assertEquals(10,scrappy.getNumScoobySnacks());
        assertTrue(scrappy.isEntangled());

        assertFalse(scrappy.isHidden());
        assertFalse(scrappy.canSpawn());

        assertEquals("SD",scrappy.getSymbol());
    }
}
