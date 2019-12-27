public abstract class Scene {

    protected Game game;
    protected char[] image;
    protected int nextScene;
    protected Player player;
    protected String res;

    public Scene(Game game, char[] image) {
        this.game = game;
        this.image = image;
        player = game.getPlayer();
    }

    private void verifyPriorityCommands() {
    	if (res.equalsIgnoreCase("quit")) {
    		System.exit(0);
    	}
    }

    public void update() {
    	res = game.getScanner().next();
    	verifyPriorityCommands();
    }

    public abstract void render();

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

    public abstract void reset();

}