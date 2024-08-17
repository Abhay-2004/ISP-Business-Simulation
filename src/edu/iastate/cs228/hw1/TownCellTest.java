package edu.iastate.cs228.hw1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.jupiter.api.Test;

/**
 * @author Abhay Prasanna Rao
 * Unit tests for the TownCell class.
 * This class contains methods to test the behavior of the TownCell class's methods,
 * ensuring they work as expected.
 */
class TownCellTest {
    Town t;
    
    /**
     * This method initializes a new Town object using a file before each test.
     * The file contains the information needed to create the Town object.
     * 
     * @throws FileNotFoundException if the file specified cannot be found
     */
    @Before
    public void initialize() throws FileNotFoundException
    {
        t = new Town("file.txt");
    }
    
    /**
     * This test method verifies that the census() method in the TownCell class functions correctly.
     * It tests a specific case where it expects the next state of a cell at position (1,1) to be EMPTY.
     */
    @Test
    public void testCensus() 
    {
        String str = t.grid[1][1].next(t).who().toString();
        assertEquals("", State.EMPTY.toString(), str); 
    }
}
