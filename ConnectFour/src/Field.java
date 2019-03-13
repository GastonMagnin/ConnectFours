
public class Field {
	private int counter = 0;
	public int columns;
	public int rows;
	public int[] field;
	public Field(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		field = new int[rows * columns];
	}
	public int checkState() {
		return 0;
	}
	public boolean addDisc(int column, int player) {
		int count = 0;
		if(column >= columns ) return false;
		while(column < columns * rows && field[column] == 0) {
			column += columns;
			count++;
		}
		if(count <= 0) return false;
		field[column - columns] = player;
		System.out.println(count + "count" + column);
		return true;
	}
	public Player getWinner() {
		return new HumanPlayer();
	}
	public void draw() {
		System.out.println("GAME BOARD " + counter);
		for(int i = 0; i < field.length; i++) {
			System.out.print(" " + field[i] + " ");
			if((i+1) % columns == 0) System.out.println();
		}
		System.out.println();
	}
	public void increaseCounter() {
		counter++;
	}
}
