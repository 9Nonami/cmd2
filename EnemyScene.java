import java.util.Random;

public class EnemyScene extends Scene {

	private Enemy enemy;



	public EnemyScene(Game game) {
		super(game);
	}

	public void configureEnemies(String enemies) {
		String[] splitted = enemies.split(" ");
		if (splitted.length > 1) {
			//
			int[] ranges = new int[splitted.length];
			String[] names = new String[splitted.length];

			for (int i = 0; i < splitted.length; i++) {
				String[] tempDuo = splitted[i].split("_");
				names[i] = tempDuo[0];
				ranges[i] = Integer.parseInt(tempDuo[1]);
			}

			int random = new Random().nextInt(100); //0~99

			for (int i = 0; i < ranges.length; i++) {
				//
				if (random < ranges[i]) {
					enemy = game.getEnemies().get(names[i]);
					break;
				}
			}
		} else {
			String[] temp = enemies.split("_");
			enemy = game.getEnemies().get(temp[0]);
		}
	}

	@Override
	public void update() {
		super.update();
		if (res.equalsIgnoreCase("run")) {
			game.changeScene();
		}
		//enemy.update(res);
		clearScreen();
	}

	@Override
	public void render() {
		drawImage(); //del, nao tem imagem
		//enemy.render();
	}

	@Override
	public void reset() {
		//enemy.reset(); //??
	}


	//level de acordo com o do player

}