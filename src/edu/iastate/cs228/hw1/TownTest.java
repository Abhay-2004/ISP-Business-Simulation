package edu.iastate.cs228.hw1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Abhay Prasanna Rao
 * This class contains unit tests for the Town class.
 * It verifies the correct functionality of various methods in the Town class.
 */
public class TownTest {

    /**
     * The Town object that will be used for testing.
     * This object is initialized with a grid of size 4x4.
     */
    Town t = new Town(4, 4);

    /**
     * This test verifies the correct functionality of the getLength method in the Town class.
     * It checks whether the method returns the correct length of the town grid.
     */
    @Test
    void testGetLength() {
        assertEquals(4, t.getLength());
    }
}
