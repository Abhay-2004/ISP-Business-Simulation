package edu.iastate.cs228.hw1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

import java.util.NoSuchElementException;


/**
 * The Town class represents a 2D grid of different types of cells.
 * These cells can be of types: Casual, Streamer, Reseller, Empty, and Outage.
 * The class provides functionality to initialize the town from a file or to 
 * randomly initialize it using a given seed.
 * 
 * @author Abhay Prasanna Rao
 */
public class Town {

	private int length, width;  // Dimensions of the grid
	public TownCell[][] grid;  // 2D array to hold the town cells

	/**
	 * Constructor to initialize an empty grid of given dimensions.
	 * 
	 * @param width The width of the grid.
	 * @param length The length of the grid.
	 */
	public Town(int width, int length) {
		this.length = width;
		this.width = length;
		grid = new TownCell[width][length];
	}

	/**
	 * Constructor to initialize the grid from a given input file.
	 * The file should have the width and length of the grid followed by 
	 * grid data. Each cell in the grid is represented by a single character.
	 * 
	 * @param f_name The name of the input file.
	 * @throws FileNotFoundException If the file is not found.
	 */

	public Town(String f_name) throws FileNotFoundException {
	    File file = new File(f_name);
	    
	    try (Scanner scan = new Scanner(file)) {
	        this.width = scan.nextInt();
	        this.length = scan.nextInt();
	        
	        scan.nextLine(); 

	        grid = new TownCell[width][length];
	        
	        for(int x = 0; x < width; x++) {
	            for(int y = 0; y < length; y++) {
	                if (!scan.hasNext()) {
	                    throw new IllegalArgumentException("Error: File Format!");
	                }
	                String cellType = scan.next();
	                switch(cellType) {
	                    case "C":
	                        grid[x][y] = new Casual(this, x, y);
	                        break;
	                    case "S":
	                        grid[x][y] = new Streamer(this, x, y);
	                        break;
	                    case "R":
	                        grid[x][y] = new Reseller(this, x, y);
	                        break;
	                    case "E":
	                        grid[x][y] = new Empty(this, x, y);
	                        break;
	                    case "O":
	                        grid[x][y] = new Outage(this, x, y);
	                        break;
	                    default:
	                        throw new IllegalArgumentException("File contains invalid cell type: " + cellType);
	                }
	            }
	            if (x < width - 1) {
	                scan.nextLine();  
	            }
	        }
	    } catch (NoSuchElementException e) {
	        throw new IllegalArgumentException("File format incorrect:", e);
	    }
	}




	/**
	 * Returns width of the grid.
	 * @return
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Returns length of the grid.
	 * @return
	 */
	public int getLength() {
		return length;
	}

	/**
	 * Randomly initializes the town grid using the given seed.
	 * Each cell in the grid is assigned a random type.
	 * 
	 * @param seed Seed for the random number generator.
	 */
	public void randomInit(int seed) {
		Random rand = new Random(seed);

		for(int x = 0; x < width; x++)
		{
			for(int y = 0; y < length; y++)
			{
				int randval = rand.nextInt(5);
				switch(randval) {
					case TownCell.CASUAL:
						grid[x][y] = new Casual(this, x, y);
						break;

					case TownCell.STREAMER:
						grid[x][y] = new Streamer(this,x,y);
						break;

					case TownCell.RESELLER:
						grid[x][y] = new Reseller(this, x, y);
						break;

					case TownCell.EMPTY:
						grid[x][y] = new Empty(this,x,y);
						break;

					case TownCell.OUTAGE:
						grid[x][y] = new Outage(this,x,y);
						break;
				}
			}
		}


	}

	/**
	 * Returns a string representation of the town grid.
	 * Each cell is represented by its first character.
	 * 
	 * @return string representation of the grid.
	 */
	@Override
	public String toString() {
		String name_of_file = "";

		for(int x = 0; x < width; x++)
		{
			for(int y = 0; y < length; y++)
			{
				name_of_file += grid[x][y].who().toString().charAt(0) + " ";
			}
			name_of_file += "\n";

		}


		return name_of_file;
	}

}