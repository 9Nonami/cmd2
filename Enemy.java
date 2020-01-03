//ESTA CLASSE PRECISA APENAS ARMAZENAR O BASICO DE UM INIMIGO
//COM OS STATUS-BASE
//O LEVEL E OS STATUS SAO AJUSTADOS NA CENA

import java.util.Random;

public class Enemy {

	private char[] image;
	private String name;
	private int hp;
	private int attack;
	private int deffense;
	private int speed;
	private int luck;
	private boolean alive;

	private boolean successfulAttack;
	private boolean enoughAttack;
	private int damage;



	public Enemy(char[] image, String name, int hp, int attack, int deffense, int speed, int luck) {
		this.image = image;
		this.name = name;
		this.hp = hp;
		this.attack = attack;
		this.deffense = deffense;
		this.speed = speed;
		this.luck = luck;
		alive = true;
	}

	public void attack(Player player) {
		if (alive) {
			int random = new Random().nextInt(100);
			if (random < luck) {
				successfulAttack = true;
				if (attack > player.getDeffense()) {
					enoughAttack = true;
					damage = attack - player.getDeffense();
					player.setHp(player.getHp() - damage);
					if (player.getHp() <= 0) {
						player.setAlive(false);
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
			System.out.println(name + Res.SUCCESS_MESSAGE);
			if (enoughAttack) {
				System.out.println("Damage: " + damage);
			} else {
				System.out.println(name + Res.NOT_ENOUGH_ATTACK_MESSAGE);
			}
		} else {
			System.out.println(name + Res.FAIL_MESSAGE);
		}
		System.out.println("");
		successfulAttack = false;
		enoughAttack = false;
	}

	public void render() {
		if(image != null) {
            for (int i = 0; i < Res.WIDTH * Res.HEIGHT; i++) {
                if (i != 0 && i % Res.WIDTH == 0) {
                    System.out.println("");
                }

                if (image[i] == Res.BLACK) {
                    System.out.print("  ");
                } else if (image[i] == Res.WHITE) {
                    System.out.print("\u2588\u2588");
                } else if (image[i] == Res.GRAY_25) {
                    System.out.print("\u2593\u2593");
                } else if (image[i] == Res.GRAY_50) {
                    System.out.print("\u2592\u2592");
                } else if (image[i] == Res.GRAY_75) {
                    System.out.print("\u2591\u2591");
                } else if (image[i] == Res.RED) {
                    System.out.print("##");
                } else if (image[i] == Res.GREEN) {
                    System.out.print("H ");
                } else if (image[i] == Res.BLUE) {
                    System.out.print("\\\\");
                } else if (image[i] == Res.PINK) {
                    System.out.print("\u259E\u259E");
                } else if (image[i] == Res.YELLOW) {
                    System.out.print("||");
                } else {
                    System.out.print(image[i] + " ");
                }

            }
            System.out.println("");
        } else {
        	System.out.println("NULL IMAGE");
        }
	}

	public char[] getImage() {
		return image;
	}

	public String getName() {
		return name;
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

	public int getLuck() {
		return luck;
	}

	public void setLuck(int luck) {
		this.luck = luck;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public int getLuckIncrement(int level) {
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
		return luckIncrement;
	}

	//verificar se eh grama / agua e colocar enemies especificos
}