package edu.iastate.cs228.hw1;

/**
 * The Outage class represents a cell in a town grid where there is an outage.
 * This cell type will transition to an empty cell in the next iteration of the simulation.
 * It extends the TownCell class and overrides the who and next methods.
 * 
 * @author Abhay Prasanna Rao
 */
public class Outage extends TownCell {
    
    /**
     * Constructor that creates a new Outage cell with specified coordinates (r, c) in a given town.
     * It utilizes the constructor of the superclass TownCell to initialize the cell.
     * 
     * @param p The town where the cell is located
     * @param r The row position of the cell in the town grid
     * @param c The column position of the cell in the town grid
     */
    public Outage(Town p, int r, int c) {
        super(p, r, c);
    }

    /**
     * Returns the state of the cell, which is OUTAGE in this case.
     * 
     * @return The state of the cell, represented as an enum value from the State enumeration
     */
    @Override
    public State who() {
        return State.OUTAGE;
    }

    /**
     * Determines the next state of the cell. For an Outage cell, it will transition to an Empty cell in the next iteration of the simulation.
     * 
     * @param town_name_new_inp The new town grid that will be affected by the state transition
     * @return A new Empty cell representing the state of the cell in the next iteration
     */
    @Override
    public TownCell next(Town town_name_new_inp) {
        return new Empty(town_name_new_inp,row,col);
    }
}
