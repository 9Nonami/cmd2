public class TalkScene extends Scene {

	private String[] texts;
	private int textId;
	private int playerId;


	public TalkScene(Game game, char[] image, int nextScene, int playerId) { //set name / desc.
		super(game, image);
		super.nextScene = nextScene;
		this.playerId = playerId;
		textId = 0;
	}

	public void setTexts(String[] texts) {
		this.texts = texts;
	}

	//UPDATE STUFF ----------------------------------------------
	private void manageInput() {
		if (res.equalsIgnoreCase("n")) { //next
			textId++;
			if (textId == texts.length) {
				player.setId(playerId);
				game.changeScene();
			}
		}
	}

	@Override
	public void update() {
		super.update();
		manageInput();
		clearScreen();
	}
	//-----------------------------------------------------------


	//RENDER STUFF ----------------------------------------------
	private void drawTexts() {
		if (texts != null) {
			System.out.println(texts[textId]);
		}
	}

	@Override
	public void render() {
		drawImage();
		drawTexts();
	}
	//-----------------------------------------------------------


	@Override
	public void reset() {
		textId = 0;
	}


}