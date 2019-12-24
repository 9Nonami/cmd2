import java.util.Map;

public class Scene {

    private char[] image;
    private Game game;
    private int player = 36;

    public Scene(Game game, char[] image) {
        this.game = game;
        this.image = image;
    }

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
        edit[player] = 'X';
    }

    public void update() {
        manageInput();
        clearScreen();
    }

    private boolean okMoveX(char x) {
        return game.getX().containsKey(x);
    }

    private boolean okMoveY(char y) {
        return game.getY().containsKey(y);
    }

    private void move(char x, char y) {
        if (okMoveX(x) && okMoveY(y)) {
            player = game.getX().get(x) + game.getY().get(y); 
        }
    }

    private void quit(String res) {
        if (res.equalsIgnoreCase("quit")) {
            System.exit(0);
        }
    }

    private void manageInput() {
        
        String res = game.getScanner().next();

        quit(res);

        char[] splited = res.toCharArray();
        
        if (splited.length == 2) { //2 = x,y
            move(splited[0], splited[1]);
        }

    }

    private void clearScreen() {
        try {

            ProcessBuilder pb = null;

            if (game.getOs().startsWith("l")) {
                pb = new ProcessBuilder("clear");
            } else if (game.getOs().startsWith("w")) {
                pb = new ProcessBuilder("cmd", "/c", "cls");
            }

            pb.inheritIO();
            Process p = pb.start();
            p.waitFor();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void render() {

        char[] edit = new char[image.length];
        copyArr(edit);
        addFrame(edit);
        addPlayer(edit);

        for (int i = 0; i < Res.WIDTH * Res.HEIGHT; i++) {
            if (i != 0 && i % Res.WIDTH == 0) {
                System.out.println("");
            }

            if (edit[i] == Res.BLACK) {
                System.out.print("  ");
            } else if (edit[i] == Res.WHITE) {
                System.out.print("\u2588\u2588");
            } else if (edit[i] == Res.GRAY_25) {
                System.out.print("\u2591\u2591");
            } else if (edit[i] == Res.GRAY_50) {
                System.out.print("\u2592\u2592");
            } else if (edit[i] == Res.GRAY_75) {
                System.out.print("\u2593\u2593");
            } else if (edit[i] == Res.RED) {
                System.out.print("##");
            } else if (edit[i] == Res.GREEN) {
                System.out.print("HH");
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

}
