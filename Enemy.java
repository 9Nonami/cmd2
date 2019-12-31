public class Enemy {

	private char[] image;



	public Enemy(char[] image) {
		this.image = image;
	}

	public void update() {

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
        }
	}

	//reset?


	//verificar se eh grama / agua e colocar enemies especificos
}