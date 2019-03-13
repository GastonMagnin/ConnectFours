
public class RandomPlayer extends Player {

	@Override
	public int play(Field f) {
		return 1+(int)(Math.random() * f.columns);
		
	}

}
