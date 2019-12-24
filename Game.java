import java.util.HashMap;

public class Game {

	private HashMap<Integer, Character> map;
	private Scene scene;


	public Game() {
		map = new HashMap<Integer, Character>();
        map.put(0, ' ');
        map.put(1, 'A');
        map.put(2, 'B');
        map.put(3, 'C');
        map.put(4, 'D');
        map.put(5, 'E');
        map.put(6, 'F');
        map.put(7, 'G');
        map.put(8, 'H');
        map.put(9, 'I');
        map.put(10, 'J');
        map.put(11, 'K');
        map.put(12, 'L');
        map.put(13, 'M');
        map.put(14, 'N');
        map.put(15, 'O');
        map.put(16, 'P');
        map.put(17, 'Q');
        map.put(18, 'R');
        map.put(19, 'S');
        map.put(20, 'T');
        map.put(21, 'U');
        map.put(22, 'V');
        map.put(23, 'W');
        map.put(24, 'X');
        map.put(25, 'Y');
        map.put(26, 'Z');
        map.put(27, 'a');
        map.put(28, ' ');

        map.put(29, 'A');
        map.put(57, 'A');

        map.put(58, 'B');
        map.put(86, 'B');

        map.put(87, 'C');
        map.put(115, 'C');

        map.put(116, 'D');
        map.put(144, 'D');

        map.put(145, 'E');
        map.put(173, 'E');

        map.put(174, 'F');
        map.put(202, 'F');

        map.put(203, 'G');
        map.put(231, 'G');

        map.put(232, 'H');
        map.put(260, 'H');

        map.put(261, 'I');
        map.put(289, 'I');

        map.put(290, 'J');
        map.put(318, 'J');

        map.put(319, 'K');
        map.put(347, 'K');

        map.put(348, ' ');
        map.put(349, 'A');
        map.put(350, 'B');
        map.put(351, 'C');
        map.put(352, 'D');
        map.put(353, 'E');
        map.put(354, 'F');
        map.put(355, 'G');
        map.put(356, 'H');
        map.put(357, 'I');
        map.put(358, 'J');
        map.put(359, 'K');
        map.put(360, 'L');
        map.put(361, 'M');
        map.put(362, 'N');
        map.put(363, 'O');
        map.put(364, 'P');
        map.put(365, 'Q');
        map.put(366, 'R');
        map.put(367, 'S');
        map.put(368, 'T');
        map.put(369, 'U');
        map.put(370, 'V');
        map.put(371, 'W');
        map.put(372, 'X');
        map.put(373, 'Y');
        map.put(374, 'Z');
        map.put(375, 'a');
        map.put(376, ' ');

        scene = new Scene(this, Res.chess);
	}

	public void update() {}

	public void render() {
		scene.render();
	}

	public HashMap<Integer, Character> getMap() {
		return map;
	}


}