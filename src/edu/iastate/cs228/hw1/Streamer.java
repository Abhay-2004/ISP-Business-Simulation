package edu.iastate.cs228.hw1;

/**
 * @author Abhay Prasanna Rao
 * The Streamer class is a type of TownCell that represents a streamer cell in a town grid.
 * It overrides the abstract methods who() and next(Town) defined in TownCell to implement
 * the behaviors specific to a streamer cell: it can potentially transform into a Reseller, 
 * an Outage, or remain as a Streamer in the next cycle of the grid update.
 */
public class Streamer extends TownCell {

    /**
     * Constructor that initializes a new Streamer instance with the specified town,
     * row and column values.
     *
     * @param p The town in which the cell is located
     * @param r The row index of the cell in the town grid
     * @param c The column index of the cell in the town grid
     */
    public Streamer(Town p, int r, int c) {
        super(p, r, c);
    }

    /**
     * Returns the state representing this cell type, which is STREAMER.
     *
     * @return State representing a Streamer cell
     */
    @Override
    public State who() {
        return State.STREAMER;
    }

    /**
     * Determines the Streamer cell's next state by examining the neighboring cells (obtained through census).
     * Based on the specific conditions met, it returns a new instance of the next appropriate state for this cell.
     *
     * @param name_town The new town grid being formed
     * @return A new TownCell instance representing the next state of this cell
     */
    @Override
    public TownCell next(Town name_town) {
        int[] nCensus = new int[NUM_CELL_TYPE];
        census(nCensus);

        if(nCensus[OUTAGE] + nCensus[EMPTY] <= 1){
            return new Reseller(name_town, row, col);
        }
        else if(nCensus[RESELLER] > 0) {
            return new Outage(name_town, row, col);
        }
        else if(nCensus[OUTAGE] > 0) {
            return new Empty(name_town, row, col);
        }

        return new Streamer(name_town, row, col);
    }
}
