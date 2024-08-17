/**
 * @author Abhay Prasanna Rao
 */
package edu.iastate.cs228.hw1;

/**
 * The Casual class represents a Casual cell type in a town grid.
 */
public class Casual extends TownCell {

    /**
     * Constructor that initializes the Casual cell with the given town, row, and column parameters.
     *
     * @param p   The town where the cell is located.
     * @param r   The row index of the cell.
     * @param c   The column index of the cell.
     */
    public Casual(Town p, int r, int c) {
        super(p, r, c);
    }

    /**
     * Gets the state of the Casual cell.
     *
     * @return The CASUAL state.
     */
    @Override
    public State who() {
        return State.CASUAL;
    }

    /**
     * Determines the next cell after one cycle based on the census counts of the neighboring cells.
     *
     * @param tNew  The new town state after one cycle.
     * @return The new cell state after one cycle.
     */
    @Override
    public TownCell next(Town tNew) {

        // Array to hold the census counts of different cell types
        int[] censusCounts = new int[NUM_CELL_TYPE];

        // Get the census counts of the neighboring cells
        census(censusCounts);

        // Threshold values for determining the next cell state
        final int THRESHOLD_EMPTY_OUTAGE = 1;
        final int THRESHOLD_RESELLER = 0;
        final int THRESHOLD_STREAMER = 0;
        final int THRESHOLD_CASUAL = 5;

        if (censusCounts[OUTAGE] + censusCounts[EMPTY] <= THRESHOLD_EMPTY_OUTAGE) {
            return new Reseller(tNew, row, col);
        }
        if (censusCounts[RESELLER] > THRESHOLD_RESELLER) {
            return new Outage(tNew, row, col);
        }
        if (censusCounts[STREAMER] > THRESHOLD_STREAMER || censusCounts[CASUAL] >= THRESHOLD_CASUAL) {
            return new Streamer(tNew, row, col);
        }
        return new Casual(tNew, row, col);
    }
}
