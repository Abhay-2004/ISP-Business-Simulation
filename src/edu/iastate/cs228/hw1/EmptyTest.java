package edu.iastate.cs228.hw1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The EmptyTest class contains unit tests to verify the behavior of the Empty class methods.
 * It tests the who() method and the next() method under a certain condition to ensure the
 * correct State is returned.
 * 
 * @author Abhay Prasanna Rao
 */
public class EmptyTest {

    /** The Town instance used for testing. */
    Town t;

    /** The Empty instance used for testing. */
    Empty e;

    /**
     * Sets up the testing environment before each test, initializing a new Town and
     * an Empty instance with specified parameters.
     */
    @BeforeEach
    void setUp() {
        t = new Town(4, 4);
        e = new Empty(t, 1, 2);
    }

    /**
     * Tests the who() method of the Empty class to ensure it returns the correct State.
     */
    @Test
    void testWho() {
        assertEquals(State.EMPTY, e.who());
    }

    /**
     * Tests the next() method of the Empty class under a specific condition where 
     * the neighboring cells are of different states, to ensure it returns the expected
     * State after transition.
     */
    @Test
    void testNextStateConditionA() {
        Town localTown = new Town(2, 2);
        localTown.grid[0][0] = new Empty(localTown, 0, 0);
        localTown.grid[0][1] = new Empty(localTown, 0, 1);
        localTown.grid[1][0] = new Casual(localTown, 1, 0);
        localTown.grid[1][1] = new Casual(localTown, 1, 1);
        assertEquals(State.RESELLER, localTown.grid[0][0].next(localTown).who());
    }
}
