package edu.iastate.cs228.hw1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Abhay Prasanna Rao
 * This class contains tests for the Reseller class, ensuring that its methods function correctly.
 */
public class ResellerTest {

    /**
     * Town instance that is used in the test methods.
     */
    private Town t;

    /**
     * Setup method that initializes a new 4x4 town before each test is run.
     */
    @BeforeEach
    void setUp() {
        t = new Town(4, 4);
    }

    /**
     * Test method to verify that the who() method of the Reseller class returns the correct state.
     */
    @Test
    void testWho() {
        Reseller r = new Reseller(t, 1, 2);
        assertEquals(State.RESELLER, r.who(), "The who() method did not return the correct State");
    }

    /**
     * Test method to verify that the next() method of the Reseller class returns the correct next state.
     * In this case, it checks that a reseller surrounded by casual cells correctly changes to an empty cell.
     */
    @Test
    void testNextState() {
        t.grid[0][0] = new Reseller(t, 0, 0);
        t.grid[0][1] = new Casual(t, 0, 1);
        t.grid[1][0] = new Casual(t, 1, 0);
        t.grid[1][1] = new Casual(t, 1, 1);
        assertEquals(State.EMPTY, t.grid[0][0].next(t).who(), "The next() method did not return the correct State");
    }
}
