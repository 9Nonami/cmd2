public class Npc {

	private char sprite;
	private int id;
	private int nextScene;

	public Npc(int id, int nextScene) {
		this.id = id;
		this.nextScene = nextScene;
		sprite = 'N';
	}


	public char getSprite() {
		return sprite;
	}

	public int getId() {
		return id;
	}

	public int getNextScene() {
		return nextScene;
	}

}