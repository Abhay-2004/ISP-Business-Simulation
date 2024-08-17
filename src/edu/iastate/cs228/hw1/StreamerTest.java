package edu.iastate.cs228.hw1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The StreamerTest class tests the functionalities of the Streamer class to ensure
 * that it correctly determines its current state and predicts its next state based on the
 * conditions defined for a streamer cell in a town grid.
 */
public class StreamerTest {

    private Town t;

    /**
     * This method is invoked before each test. It initializes a new Town instance 
     * with a 4x4 grid to be used in the individual tests.
     */
    @BeforeEach
    void setUp() {
        t = new Town(4, 4);
    }

    /**
     * Tests the who() method of the Streamer class to ensure that it correctly
     * identifies itself as a STREAMER cell.
     */
    @Test
    void testWho() {
        Streamer s = new Streamer(t, 1, 2);
        assertEquals(State.STREAMER, s.who(), "The who() method did not return the correct State");
    }

    /**
     * Tests the next(Town) method of the Streamer class in a scenario where
     * the expected outcome is a transition to a RESELLER cell in the next cycle.
     */
    @Test
    void testNextStateWithOutageOutcome() {
        t.grid[0][0] = new Streamer(t, 0, 0);
        t.grid[0][1] = new Streamer(t, 0, 1);
        t.grid[1][0] = new Reseller(t, 1, 0);
        t.grid[1][1] = new Casual(t, 1, 1);
        assertEquals(State.RESELLER, t.grid[0][0].next(t).who(), "The next() method did not return the correct State");
    }

    /**
     * Tests the next(Town) method of the Streamer class in a scenario where
     * the expected outcome is a transition to a RESELLER cell in the next cycle.
     */
    @Test
    void testNextStateWithStreamerOutcome() {
        t.grid[0][0] = new Streamer(t, 0, 0);
        t.grid[0][1] = new Casual(t, 0, 1);
        t.grid[1][0] = new Reseller(t, 1, 0);
        t.grid[1][1] = new Casual(t, 1, 1);
        assertEquals(State.RESELLER, t.grid[0][0].next(t).who(), "The next() method did not return the correct State");
    }
}
