
public class Field {
	//Round counter
	private int round = 0;
	//Dimensions
	public int columns;
	public int rows;
	//The field
	public int[] field;
	//Constructor that sets the dimensions and creates the field
	public Field(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		field = new int[rows * columns];
	}
	/**
	 * Checks the current gamestate and returns an integer indicating it. Saves the last checked Element in lastId
	 * @return Integer indicating the current gamestate 0: ongoing 1: Playerwin 2: Draw
	 */
	public int checkState() {
		//Initialize variables
		boolean isDraw = true;
		int count = 0;
		int lastId = 0;
		//Check for 4 in a row horizontal
		for(int i = 0; i < field.length; i++) {
			if(field[i] == 0) {
				// If the current field is empty reset the count and set draw to false
				count = 0;
				isDraw = false;
			}
			//if the field is not empty and not the same as the last Id start count at 1
			else if(field[i] != lastId) count = 1;
			//Field is not empty and same as last
			else count++;
			//Update lastId
			lastId = field[i];
			//Check if a player won
			if(count == 4) return lastId;
		}
		//Check for 4 in a row vertical
		int i = 0;
		for(int j = 0; j < field.length; j++) {
			if(field[i] == 0) {
				//Current field is empty reset count and set draw to false
				count = 0;
				isDraw = false;
			}
			//Current field is not empty and not the same as the last
			else if(field[i] != lastId) count = 1;
			//Current field is not empty and same as the last
			else count++;
			//Update lastId
			lastId = field[i];
			//Increase i by 1 row and start at the top of the next column if out of rows
			i += columns;
			if(i >= field.length) i = i % columns + 1;
			//Check if a player won
			if(count >= 4) return lastId;
		}
		
		//Check for 4 in a row diagonal
		//Check top down, dont check last 3 rows because 4 diagonal needs a height of 4
		for(i = 0; i < field.length - 3 * columns; i++) {
			if(field[i] != 0) {
				//Update lastId
				lastId = field[i];
				//Check Left if there are enough columns to the left
				if(i % columns >= 3)
					if(field[i + columns - 1] == lastId && field[i + 2 * columns - 2] == lastId && field[i + 3 * columns - 3] == lastId) return lastId;
				//Check right if there are enough columns to the right
				if(columns - i % columns >= 4)
					if(field[i + columns + 1] == lastId && field[i + 2 * columns + 2] == lastId && field[i + 3 * columns + 3] == lastId) return lastId;
			}
		}
		//if there are no more empty fields left
		if(isDraw) return -1;
		// keep playing 
		return 0;
	}
	/**
	 * Add a disc with playerId to the field
	 * @param column Integer Column in which to place the disc
	 * @param player Integer ID of the player that placed the disc
	 * @return Boolean true if 
	 */
	public boolean addDisc(int column, int player) {
		// Initialize count 
		int currentRow = 0;
		//return false if input invalid
		if(column >= columns ) return false;
		//Go down rows as long as there are still rows left and no discs in that row + column store the lowest possible row in currentRow
		while(column < columns * rows && field[column] == 0) {
			column += columns;
			currentRow++;
		}
		//return false if the column is full
		if(currentRow <= 0) return false;
		//Place the disc 
		field[column - columns] = player;
		return true;
	}
	/**
	 * Print the current state of the field to the screen + round counter
	 */
	public void draw() {
		System.out.println("GAME BOARD " + round);
		for(int i = 0; i < field.length; i++) {
			System.out.print(" " + field[i] + " ");
			if((i+1) % columns == 0) System.out.println();
		}
		System.out.println();
	}
	// Increase round counter
	public void increaseRound() {
		round++;
	}
}
