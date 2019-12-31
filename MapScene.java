import java.util.Map;
import java.util.Random;

public class MapScene extends Scene {

    private Exit[] exits;
    private Npc[] npcs;

    //
    private boolean containsMonsters; //set monsters type "uno, dos, tres" >> contains = true
    private int random; //deixar na cena do enemy
    //private int monsterEncounterRate;
    //private boolean monsterAtSpecificTile;
    //private char monsterTile;

    private boolean containsEnemies;
    
    private boolean hasEncounterTile;
    private char encounterTile;
    
    private String enemies;



    public MapScene(Game game, char[] image, Exit[] exits) {
        super(game, image);
        this.exits = exits;
        containsMonsters = false;
    }

    public void setNpc(Npc[] npcs) {
        this.npcs = npcs;
    }

    //del
    public void setContainsMonsters(boolean containsMonsters) {
        this.containsMonsters = containsMonsters;
    }

    public void setEnemies(String enemies) {
        containsEnemies = true;
        this.enemies = enemies;
    }

    public void setEnemies(char encounterTile, String enemies) {
        containsEnemies = true;
        hasEncounterTile = true;
        this.encounterTile = encounterTile;
        this.enemies = enemies;
    }





    //UPDATE STUFF ----------------------------------------------
    private boolean move(int newId) {
        player.setLastId(player.getId());
        player.setId(newId);
        return true;
    }

    private boolean isGoingToEncounterAMonster(int newId) { //fix //specific tile
        if (containsMonsters) {
            if (player.getId() != newId) {
                random = new Random().nextInt(10);
                if (random < 3) { //definir essa parada aqui
                    player.setId(newId);
                    game.getEnemyScene().setNextScene(game.getScene()); //isso aqui esta atribuindo a cena para a qual coltar
                    //pirulei
                    //getEnemyScene().configureEnemies(enemies); //"uno_10 dos_90"
                    game.changeScene(game.getEnemyScene());
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isGoingToTalkWithNpc(int newId) {
        if (npcs != null) {
            for (Npc temp : npcs) {
                if (newId == temp.getId()) {
                    nextScene = temp.getNextScene();
                    game.changeScene();
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean isGoingToExit(int newId) {
        for (int i = 0; i < exits.length; i++) {
            if (exits[i].getEntryPoint() == newId) {
                nextScene = exits[i].getNextScene();
                player.setId(exits[i].getPlayerPosition());
                game.changeScene();
                return true;
            }
        }
        return false;
    }    

    private boolean isValidMove(char[] splitted) {
        return game.getX().containsKey(splitted[0]) && game.getY().containsKey(splitted[1]);
    }

    private void manageInput() {
        char[] splitted = res.toCharArray();
        if (splitted.length == 2) {
            if (isValidMove(splitted)) {
                int newId = game.getX().get(splitted[0]) + game.getY().get(splitted[1]);
                if (isGoingToExit(newId)) {

                } else if (isGoingToTalkWithNpc(newId)) {
                   
                } else if (isGoingToEncounterAMonster(newId)) {

                } else if (move(newId)){
                    
                }
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

        System.out.println("lastId: " + player.getLastId() + ", Id: " + player.getId() + " random: " + random);
    }
    //-----------------------------------------------------------


    @Override
    public void reset() {

    }

}