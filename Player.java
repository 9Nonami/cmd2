import java.util.Random;

public class Player {

	private int id;
	private int lastId;
	private char sprite;

	private int hp;
	private int attack;
	private int deffense;
	private int speed;
	private int luck;
	private boolean alive;

	private int level;
	private int exp;

	private boolean successfulAttack;
	private boolean enoughAttack;
	private int damage;



	public Player(int id) {
		this.id = id;
		sprite = 'X';

		//--load

		hp = 10;
		attack = 20; //5
		deffense = 6;
		speed = 5;
		luck = 100; //50
		alive = true;

		exp = 0;
		level = 0;
	}

	public void attack(Enemy enemy) {
		if (alive) {
			int random = new Random().nextInt(100);
			if (random < getLuck()) {
				successfulAttack = true;
				if (attack > enemy.getDeffense()) {
					enoughAttack = true;
					damage = attack - enemy.getDeffense();
					enemy.setHp(enemy.getHp() - damage);
					if (enemy.getHp() <= 0) {
						enemy.setAlive(false);
						enemy.setHp(0);
					}	
				} else {
					enoughAttack = false;
				}
			} else {
				successfulAttack = false;
			}
		}
	}

	public void displayBattleLog() {
		if (successfulAttack) {
			System.out.println("Player" + Res.SUCCESS_MESSAGE);
			if (enoughAttack) {
				System.out.println("Damage: " + damage);
			} else {
				System.out.println("Player" + Res.NOT_ENOUGH_ATTACK_MESSAGE);
			}
		} else {
			System.out.println("Player" + Res.FAIL_MESSAGE);
		}
		System.out.println("");
		successfulAttack = false;
		enoughAttack = false;
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

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDeffense() {
		return deffense;
	}

	public void setDeffense(int deffense) {
		this.deffense = deffense;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public int getLuck() {
		int luckIncrement = 0;
		if (level < 10) {
			luckIncrement = 5;
		} else if (level < 20) {
			luckIncrement = 10;
		} else if (level < 30) {
			luckIncrement = 15;
		} else if (level < 40) {
			luckIncrement = 20;
		} else if (level < 50) {
			luckIncrement = 25;
		} else if (level < 60) {
			luckIncrement = 30;
		} else if (level < 70) {
			luckIncrement = 35;
		} else if (level < 80) {
			luckIncrement = 40;
		} else if (level < 90) {
			luckIncrement = 45;
		} else if (level <= 100) { //todo
			luckIncrement = 50;
		}
		return luck + luckIncrement;
	}

	public void levelUp(int enemyExp) {
		if (level < 5) {
			exp += enemyExp;
			if (exp >= 80 && level < 5) {
				up();
			} else if (exp >= 40 && level < 4) {
				up();
			} else if (exp >= 20 && level < 3) {
				up();
			} else if (exp >= 10 && level < 2) {
				up();
			} else if (exp >= 5 && level < 1) {
				up();
			}
		}
	}

	private void up() {
		level++;
		hp++;
		attack++;
		deffense++;
		speed++;
		luck++;
	}

	public int getLevel() {
		return level;
	}

}