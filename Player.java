public class Player {

	private int id;
	private int lastId;
	private char sprite;

	public Player(int id) {
		this.id = id;
		sprite = 'X';
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLastId() {
		return lastId;
	}

	public void setLastId(int lastId) {
		this.lastId = lastId;
	}

	public char getSprite() {
		return sprite;
	}

}