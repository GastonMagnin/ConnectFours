import java.util.Scanner;
public class HumanPlayer extends Player {
	private static Scanner sc = new Scanner(System.in);
	public HumanPlayer() {
		super();
	}
	public HumanPlayer(String name) {
		super();
		this.name = name;
	}
	@Override
	public int play(Field f) {
		//Ask the user for an integer Input, repeat until a valid input is given
		int output = -1;
		do {
			System.out.println("Please enter a column:");
			try {
				output = sc.nextInt();
			}catch(Exception e) {
				//Flush Scanner
				if(sc.hasNext()) sc.nextLine();
			}
		}while(output <= 0 || output > f.columns);
		return output - 1;
	}
	
	

}
