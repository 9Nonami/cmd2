import java.util.Map;

public class MapScene extends Scene {

	private Exit[] exits;
    private Npc[] npcs;

	public MapScene(Game game, char[] image, Exit[] exits) {
		super(game, image);
		this.exits = exits;
	}

    public void setNpc(Npc[] npcs) {
        this.npcs = npcs;
    }


	//UPDATE STUFF ----------------------------------------------
	private void verifyNpcs() {
        if (npcs != null) {
            for (Npc temp : npcs) {
                if (player.getId() == temp.getId()) {
                    nextScene = temp.getNextScene();
                    player.setId(player.getLastId());
                    game.changeScene();
                    break;
                }
            }
        }
    }

    private void move(int newId) {
        player.setLastId(player.getId());
        player.setId(newId);
    }

    private boolean isAtExit(int newId){
        for (int i = 0; i < exits.length; i++) {
            if (exits[i].getEntryPoint() == newId) {
                nextScene = exits[i].getNextScene();
                player.setId(exits[i].getPlayerPosition());
                return true;
            }
        }
        return false;
    }

	private boolean okMoveX(char x) {
        return game.getX().containsKey(x);
    }

    private boolean okMoveY(char y) {
        return game.getY().containsKey(y);
    }

	private void verifyMovement(char[] splitted) {
        if (splitted.length == 2) { //2 = x,y
        	if (okMoveX(splitted[0]) && okMoveY(splitted[1])) {
            	int newId = game.getX().get(splitted[0]) + game.getY().get(splitted[1]);
            	if (isAtExit(newId)) {
                	game.changeScene();
            	} else {
                	move(newId);
            	}
        	}
    	}
    }

	private void manageInput() {
        char[] splitted = res.toCharArray();
        verifyMovement(splitted); //return, nao precisa verificar o npc
        verifyNpcs();
    }

	@Override
	public void update() {
		super.update();
		manageInput();
		clearScreen();
	}
	//-----------------------------------------------------------


	//RENDER STUFF ----------------------------------------------
	private void copyArr(char[] edit) {
        for (int i = 0; i < image.length; i++) {
            edit[i] = image[i];            
        }
    }

    private void addFrame(char[] edit) {
        for (Map.Entry<Integer, Character> temp : game.getMap().entrySet()) {
            edit[temp.getKey()] = temp.getValue();
        }
    }

    private void addPlayer(char[] edit) {
        edit[player.getId()] = player.getSprite();
    }

    private void addNpcs(char[] edit) {
        if (npcs != null) {
            for (Npc temp : npcs) {
                edit[temp.getId()] = temp.getSprite();
            }
        }
    }

    private void drawImage(char[] edit) {
    	for (int i = 0; i < Res.WIDTH * Res.HEIGHT; i++) {
            if (i != 0 && i % Res.WIDTH == 0) {
                System.out.println("");
            }

            if (edit[i] == Res.BLACK) {
                System.out.print("  ");
            } else if (edit[i] == Res.WHITE) {
                System.out.print("\u2588\u2588");
            } else if (edit[i] == Res.GRAY_25) {
                System.out.print("\u2593\u2593");
            } else if (edit[i] == Res.GRAY_50) {
                System.out.print("\u2592\u2592");
            } else if (edit[i] == Res.GRAY_75) {
                System.out.print("\u2591\u2591");
            } else if (edit[i] == Res.RED) {
                System.out.print("##");
            } else if (edit[i] == Res.GREEN) {
                System.out.print("H ");
            } else if (edit[i] == Res.BLUE) {
                System.out.print("\\\\");
            } else if (edit[i] == Res.PINK) {
                System.out.print("\u259E\u259E");
            } else if (edit[i] == Res.YELLOW) {
                System.out.print("||");
            } else {
                System.out.print(edit[i] + " ");
            }

        }
        System.out.println("");
    }

	@Override
	public void render() {
		char[] edit = new char[image.length];
        copyArr(edit);
        addFrame(edit);
        addPlayer(edit);
        addNpcs(edit);
        drawImage(edit);
	}
	//-----------------------------------------------------------


	@Override
	public void reset() {

	}

}