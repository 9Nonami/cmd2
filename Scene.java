public abstract class Scene {

    protected Game game;
    protected char[] image;
    protected int nextScene;
    protected Player player;
    protected String res;



    public Scene(Game game) {
        this.game = game;
        player = game.getPlayer();
    }

    public Scene(Game game, char[] image) {
        this.game = game;
        this.image = image;
        player = game.getPlayer();
    }

    public void setImage(char[] image) {
        this.image = image;
    }

    private void verifyPriorityCommands() {
    	if (res.equalsIgnoreCase("quit")) {
    		System.exit(0);
    	}
    }

    public void update() {
    	res = game.getScanner().nextLine();
    	verifyPriorityCommands();
    }

    public abstract void render();

    public void drawImage() {
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
        }
    }

    protected void clearScreen() {
        try {

            ProcessBuilder pb = null;

            if (game.getOs().startsWith("l")) {
                pb = new ProcessBuilder("clear");
            } else if (game.getOs().startsWith("w")) {
                pb = new ProcessBuilder("cmd", "/c", "cls");
            } else {
            	System.out.println("os error");
            	System.exit(0);
            }

            pb.inheritIO();
            Process p = pb.start();
            p.waitFor();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getNextScene() {
    	return nextScene;
    }

    public void setNextScene(int nextScene) {
        this.nextScene = nextScene;
    }

    public abstract void reset();

}