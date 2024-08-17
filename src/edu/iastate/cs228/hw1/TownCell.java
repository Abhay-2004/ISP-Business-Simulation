package edu.iastate.cs228.hw1;
/**
 * @author Abhay Prasanna Rao
 * Represents a cell in a town grid.
 * Each cell can be one of five types: RESELLER, EMPTY, CASUAL, OUTAGE, or STREAMER.
 */
public abstract class TownCell {

	protected Town plain;
	protected int row;
	protected int col;

	protected static final int RESELLER = 0;
	protected static final int EMPTY = 1;
	protected static final int CASUAL = 2;
	protected static final int OUTAGE = 3;
	protected static final int STREAMER = 4;

	public static final int NUM_CELL_TYPE = 5;

	public static final int[] nCensus = new int[NUM_CELL_TYPE];
	 /**
     * Creates a new TownCell with the specified town, row, and column.
     *
     * @param p the town the cell is in
     * @param r the row position of the cell
     * @param c the column position of the cell
     */

	public TownCell(Town p, int r, int c) {
		plain = p;
		row = r;
		col = c;
	}

	/**
     * Counts the number of each type of cell in the neighborhood around this cell.
     * The census results are stored in the provided array.
     *
     * @param nCensus an array to hold the census results
     */
	public void census(int[] nCensus) {
	    
	    // Reset census data using a loop to improve maintainability
	    for (int i = 0; i < NUM_CELL_TYPE; i++) {
	        nCensus[i] = 0;
	    }
	    
	    int width = plain.getWidth();
	    int length = plain.getLength();
	    
	    // Define the boundaries for the loop to make the code more readable
	    int rowStart = Math.max(0, row - 1);
	    int rowEnd = Math.min(length - 1, row + 1);
	    int colStart = Math.max(0, col - 1);
	    int colEnd = Math.min(width - 1, col + 1);
	    
	    // Loop through the neighboring cells including the cell itself
	    for (int i = rowStart; i <= rowEnd; i++) {
	        for (int j = colStart; j <= colEnd; j++) {
	            
	            // Skip the current cell to avoid counting it in the census
	            if (i == row && j == col) {
	                continue;
	            }
	            
	            switch (plain.grid[i][j].who()) {
	                case CASUAL:
	                    nCensus[CASUAL] += 1;
	                    break;
	                case RESELLER:
	                    nCensus[RESELLER] += 1;
	                    break;
	                case EMPTY:
	                    nCensus[EMPTY] += 1;
	                    break;
	                case OUTAGE:
	                    nCensus[OUTAGE] += 1;
	                    break;
	                case STREAMER:
	                    nCensus[STREAMER] += 1;
	                    break;
	            }
	        }
	    }
	}


	/**
	 * Gets the identity of the cell.
	 * 
	 * @return State
	 */
	public abstract State who();

	/**
	 * Determines the cell type in the next cycle.
	 * 
	 * @param town of the next cycle
	 * @return TownCell
	 */
	public abstract TownCell next(Town tNew);
}