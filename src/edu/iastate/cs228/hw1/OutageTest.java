package edu.iastate.cs228.hw1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The OutageTest class contains unit tests to validate the behavior of the methods
 * in the Outage class. It tests the functionalities of who() and next() methods 
 * using different scenarios.
 * 
 * @author Abhay Prasanna Rao
 */
public class OutageTest {

    /**
     * A Town object which will be utilized in the test methods to set up different scenarios 
     * for testing the methods of the Outage class.
     */
    private Town t;

    /**
     * Set up method that runs before each test to initialize the Town object with a grid of 4x4.
     */
    @BeforeEach
    void setUp() {
        t = new Town(4, 4);
    }

    /**
     * Test method to validate the behavior of the who() method in the Outage class.
     * It checks if the method correctly identifies the state as OUTAGE.
     */
    @Test
    void testWho() {
        Outage o = new Outage(t, 1, 2);
        assertEquals(State.OUTAGE, o.who(), "The who() method did not return the correct State");
    }

    /**
     * Test method to validate the behavior of the next() method in the Outage class.
     * It checks if the method correctly identifies the next state as EMPTY, according to the business logic defined for an Outage cell.
     */
    @Test
    void testNextState() {
        t.grid[0][0] = new Outage(t, 0, 0);
        t.grid[0][1] = new Reseller(t, 0, 1);
        t.grid[1][0] = new Empty(t, 1, 0);
        t.grid[1][1] = new Empty(t, 1, 1);
        assertEquals(State.EMPTY, t.grid[0][0].next(t).who(), "The next() method did not return the correct State");
    }
}
