
public class RandomPlayer extends Player {
	public String name = "RandomPlayer";
	@Override
	public int play(Field f) {
		return 1+(int)(Math.random() * f.columns);
		
	}

}
