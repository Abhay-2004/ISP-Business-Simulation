package edu.iastate.cs228.hw1;

/**
 * The Empty class represents a cell that is empty in a town grid. An Empty cell can transition
 * to a Reseller or a Casual depending on the neighboring cells' states defined in the next method.
 * 
 * @author Abhay Prasanna Rao
 */
public class Empty extends TownCell {

    /**
     * Creates a new Empty cell instance in the specified town at the given position.
     *
     * @param p The town where the cell is located.
     * @param r The row position of the cell.
     * @param c The column position of the cell.
     */
    public Empty(Town p, int r, int c) {
        super(p, r, c);
    }

    /**
     * @return The state of the cell, which is EMPTY.
     */
    @Override
    public State who() {
        return State.EMPTY;
    }

    /**
     * Determines the next state of an Empty cell by analyzing its neighboring cells' states.
     *
     * @param new_town_name The new state of the town.
     * @return The new state of the cell.
     */
    @Override
    public TownCell next(Town new_town_name) {
        int[] nCensus = new int[NUM_CELL_TYPE];
        census(nCensus);

        if (nCensus[OUTAGE] + nCensus[EMPTY] <= 1) {
            return new Reseller(new_town_name, row, col);
        }

        return new Casual(new_town_name, row, col);
    }
}
