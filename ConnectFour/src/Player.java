
public abstract class Player {
	private String name ="";
	private int id;
	public static int counter = 1;
	public Player() {
		id = counter++;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public abstract int play(Field f);
	public int getId() {
		return id;
	}
}
