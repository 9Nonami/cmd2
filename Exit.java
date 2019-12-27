public class Exit {

	private int entryPoint;
	private int nextScene;
	private int playerPosition;

	public Exit(int entryPoint, int nextScene, int playerPosition) {
		this.entryPoint = entryPoint;
		this.nextScene = nextScene;
		this.playerPosition = playerPosition;
	}

	public int getEntryPoint() {
		return entryPoint;
	}

	public int getNextScene() {
		return nextScene;
	}

	public int getPlayerPosition() {
		return playerPosition;
	}



}