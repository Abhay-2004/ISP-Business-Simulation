package edu.iastate.cs228.hw1;

/**
 * @author Abhay Prasanna Rao
 * The Reseller class represents a reseller cell in a town grid. 
 * It extends the TownCell class and overrides the who and next methods.
 */
public class Reseller extends TownCell{

    /**
     * Constructor that initializes a new Reseller instance with the given town, row, and column values.
     *
     * @param p The town where the cell is located.
     * @param r The row index of the cell in the town grid.
     * @param c The column index of the cell in the town grid.
     */
    public Reseller(Town p, int r, int c) {
        super(p, r, c);
    }

    /**
     * Returns the state of the cell, which is RESELLER.
     *
     * @return The state of the cell.
     */
    @Override
    public State who() {
        return State.RESELLER;
    }

    /**
     * Determines the next state of the cell by applying the rules of the simulation.
     * @param tNew The new town grid.
     * @return The new state of the cell.
     */
    @Override
    public TownCell next(Town tNew) {
        int[] nCensus = new int[NUM_CELL_TYPE];
        census(nCensus);
        if(nCensus[CASUAL] <= 3 || nCensus[EMPTY] >= 3) {
            return new Empty(tNew, row, col);
        }
        if(nCensus[CASUAL] >= 5) {
            return new Streamer(tNew, row, col);
        } 
        return new Reseller(tNew, row, col);
    }
}
