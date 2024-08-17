package edu.iastate.cs228.hw1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The ISPBusinessTest class contains tests for the ISPBusiness class.
 * It tests the getProfit method under different scenarios, including a town full of Casual, Reseller, and Streamer cells.
 * 
 * @author Abhay Prasanna Rao
 */
public class ISPBusinessTest {

    /** 
     * The town object to be used in the tests. 
     */
    Town t;

    /**
     * This method sets up a 4x4 town grid before each test.
     */
    @BeforeEach
    void setup() {
        t = new Town(4, 4);
    }

    /**
     * This test checks the getProfit method with a town grid full of Casual cells.
     * It sets all cells to Casual and then checks that the profit equals to the number of cells.
     */
    @Test
    void testProfitWithFullCasual() {
        for (int i = 0; i < t.getLength(); i++) {
            for (int j = 0; j < t.getWidth(); j++) {
                t.grid[i][j] = new Casual(t, i, j);
            }
        }

        // Assuming each Casual cell gives a profit of 1, and there are 16 cells
        assertEquals(16, ISPBusiness.getProfit(t));
    }

    /**
     * This test checks the getProfit method with a town grid full of Reseller cells.
     * It sets all cells to Reseller and then checks that the profit is 0, as Reseller cells are assumed not to generate profit.
     */
    @Test
    void testProfitWithFullReseller() {
        for (int i = 0; i < t.getLength(); i++) {
            for (int j = 0; j < t.getWidth(); j++) {
                t.grid[i][j] = new Reseller(t, i, j);
            }
        }

        // Assuming Reseller cells do not generate profit
        assertEquals(0, ISPBusiness.getProfit(t));
    }

    /**
     * This test checks the getProfit method with a town grid full of Streamer cells.
     * It sets all cells to Streamer and then checks that the profit is 0, as Streamer cells are assumed not to generate profit.
     */
    @Test
    void testProfitWithFullStreamer() {
        for (int i = 0; i < t.getLength(); i++) {
            for (int j = 0; j < t.getWidth(); j++) {
                t.grid[i][j] = new Streamer(t, i, j);
            }
        }

        // Assuming Streamer cells do not generate profit
        assertEquals(0, ISPBusiness.getProfit(t));
    }
}
