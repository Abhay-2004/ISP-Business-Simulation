/**
 * @author Abhay Prasanna Rao
 * 
 * Unit tests for the Casual class, checking the correct functioning of its methods.
 */
package edu.iastate.cs228.hw1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CasualTest {
    Town t;
    Casual c;

    /**
     * Sets up a new Town and Casual object before each test is run.
     */
    @BeforeEach
    void setUp() {
        t = new Town(4, 4);
        c = new Casual(t, 1, 2);
    }

    /**
     * Test to ensure the 'who' method returns the correct State for a Casual object.
     */
    @Test
    void testWho() {
        assertEquals(State.CASUAL, c.who());
    }

    /**
     * Test case to check the 'next' method's return value under a certain condition with a predefined grid that includes a Streamer cell.
     */
    @Test
    void testNextStateConditionA() {
        Town localTown = new Town(2, 2);
        localTown.grid[0][0] = new Casual(localTown, 0, 0);
        localTown.grid[0][1] = new Streamer(localTown, 0, 1);
        localTown.grid[1][0] = new Casual(localTown, 1, 0);
        localTown.grid[1][1] = new Casual(localTown, 1, 1);
        assertEquals(State.RESELLER, localTown.grid[0][0].next(localTown).who());
    }

    /**
     * Test case to check the 'next' method's return value under certain conditions, and also check the profit calculation in the ISPBusiness class.
     */
    @Test
    void testNextStateConditionB() {
        Town localTown = new Town(2, 2);
        localTown.grid[0][0] = new Casual(localTown, 0, 0);
        localTown.grid[0][1] = new Casual(localTown, 0, 1);
        localTown.grid[1][0] = new Casual(localTown, 1, 0);
        localTown.grid[1][1] = new Casual(localTown, 1, 1);
        assertEquals(State.RESELLER, localTown.grid[0][0].next(localTown).who());
        
        Town t2 = new Town(2, 2);
        
        for (int i = 0; i < t2.getLength(); i++) {
            for (int j = 0; j < t2.getWidth(); j++) {
                t2.grid[i][j] = new Casual(t2, i, j);
            }
        }
        t2.toString();
        assertEquals(4, ISPBusiness.getProfit(t2)); 
    }
}
