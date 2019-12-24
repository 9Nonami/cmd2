import java.util.Map;

public class Scene {

    private char[] image;
    private Game game;

    public Scene(Game game, char[] image) {
        this.game = game;
        this.image = image;
    }

    private void copyArr(char[] temp) {
        for (int i = 0; i < image.length; i++) {
            temp[i] = image[i];            
        }
    }

    private void addFrame(char[] edit) {
        for (Map.Entry<Integer, Character> temp : game.getMap().entrySet()) {
            edit[temp.getKey()] = temp.getValue();
        }
    }

    public void render() {

        char[] edit = new char[image.length];
        copyArr(edit);
        addFrame(edit);

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
