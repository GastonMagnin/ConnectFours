import java.util.Scanner;
public class Game {
	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		(new Game()).init();
	}
	public void init() {
		Player player1 = new HumanPlayer(getString("What is your Name?"));
		Player player2 = (getBoolean("Do you want to play vs. a friend?")) ? new HumanPlayer(getString("What is your Name?")) : new RandomPlayer();
		Field field = new Field(getInt("rows:"), getInt("columns:"));
		gameLoop(player1, player2, field);
	}
	public void gameLoop(Player player1, Player player2, Field field) {
		boolean currentPlayer = (int)(Math.random() * 2) > 0 ? true : false;
		Player current;
		int pos;
		do {
			current = currentPlayer ? player1 : player2;
			do {
				pos = current.play(field);
			}while(!field.addDisc(pos, current.getId()));
			field.increaseRound();
			currentPlayer = !currentPlayer;
			field.draw();
		}while(field.checkState() == 0);
		if(field.checkState() == -1) {
			System.out.println("Draw!");
		}else {
			System.out.println((field.checkState() == player1.getId() ? player1 : player2).getName() + " won!");
		}
	}
	public boolean getBoolean(String question) {
		String answer = "";
		do {
			System.out.println(question + " [y/n]");
			try {
				answer = sc.next();
			}catch(Exception e ) {
				if(sc.hasNext()) sc.nextLine();
			}
		}while(!(answer.toLowerCase().equals("y") || answer.toLowerCase().equals("n")));
		return answer.toLowerCase().equals("y") ? true : false;
	}
	public int getInt(String question) {
		int output = -1;
		do {
			System.out.println(question);
			try {
				output = sc.nextInt();
			}catch(Exception e) {
				//Flush Scanner
				if(sc.hasNext()) sc.nextLine();
			}
		}while(output < 1);
		return output;
	}
	public String getString(String question) {
		String output = "";
		do {
			System.out.println(question);
			try {
				output = sc.next();
			}catch(Exception e) {
				//Flush Scanner
				if(sc.hasNext()) sc.nextLine();
			}
		}while(output == "");
		return output;
	}
}
