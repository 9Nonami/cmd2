import java.util.HashMap;
import java.util.Scanner;

public class Game { //colisao

    private HashMap<Integer, Character> map; //frame
    private HashMap<Character, Integer> x;
    private HashMap<Character, Integer> y;
    private HashMap<Integer, Scene> scenes;
    private Scene sceneBasis;
    private int scene;
    private Scanner scanner;
    private String os;
    private Player player;

    //
    private Enemies enemies;
    private EnemyScene enemyScene;



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

        x = new HashMap<Character, Integer>();
        x.put('A', 1);
        x.put('B', 2);
        x.put('C', 3);
        x.put('D', 4);
        x.put('E', 5);
        x.put('F', 6);
        x.put('G', 7);
        x.put('H', 8);
        x.put('I', 9);
        x.put('J', 10);
        x.put('K', 11);
        x.put('L', 12);
        x.put('M', 13);
        x.put('N', 14);
        x.put('O', 15);
        x.put('P', 16);
        x.put('Q', 17);
        x.put('R', 18);
        x.put('S', 19);
        x.put('T', 20);
        x.put('U', 21);
        x.put('V', 22);
        x.put('W', 23);
        x.put('X', 24);
        x.put('Y', 25);
        x.put('Z', 26);
        x.put('a', 27);

        y = new HashMap<Character, Integer>();
        y.put('A', 29);
        y.put('B', 58);
        y.put('C', 87);
        y.put('D', 116);
        y.put('E', 145);
        y.put('F', 174);
        y.put('G', 203);
        y.put('H', 232);
        y.put('I', 261);
        y.put('J', 290);
        y.put('K', 319);


        player = new Player(x.get('A') + y.get('A'));
        player.setLastId(player.getId());

        enemies = new Enemies(); //db com todos inimigos
        enemyScene = new EnemyScene(this); //cena a qual escolhera um inimigo dentre os passados pelo map e fara o u/r

        scanner = new Scanner(System.in);

        os = System.getProperty("os.name").toLowerCase();

        scene = 0;

        scenes = new HashMap<Integer, Scene>();

        //cena 0
        MapScene scene0 = new MapScene(this, Res.CASTEL, new Exit[]{new Exit(x.get('R') + y.get('H'), 1, x.get('N') + y.get('J'))});
        scene0.setEnemies(Res.ZUZU + "_49" + " " + Res.MONSTER + "_99", 0, 4);
        scenes.put(0, scene0);

        //cena 1
        MapScene scene1 = new MapScene(this, Res.INSIDE_CASTEL, new Exit[]{new Exit(x.get('N') + y.get('K'), 0, x.get('R') + y.get('I'))});
        scene1.setNpc(new Npc[]{new Npc(x.get('O') + y.get('B'), 2)});
        scenes.put(1, scene1);

        //cena 2
        TalkScene scene2 = new TalkScene(this, Res.MI, 1, x.get('N') + y.get('B'));
        scene2.setTexts(new String[]{"Hello, darkness!\nMy old friend!", "Wanna play?", "Pretty please?"});
        scenes.put(2, scene2);



        sceneBasis = scenes.get(scene);
    }

    public void start() {
        while(true) {
            sceneBasis.render();
            sceneBasis.update();
        }
    }

    public void changeScene() {
        scene = sceneBasis.getNextScene();
        sceneBasis.reset();
        sceneBasis = scenes.get(scene);
    }

    public void changeScene(Scene scene) {
        sceneBasis.reset();
        sceneBasis = scene;
    }

    public HashMap<Integer, Character> getMap() {
		return map;
    }

    public HashMap<Character, Integer> getX() {
        return x;
    }

    public HashMap<Character, Integer> getY() {
        return y;
    }

    public String getOs() {
        return os;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public Player getPlayer() {
        return player;
    }

    public EnemyScene getEnemyScene() {
        return enemyScene;
    }

    public Enemies getEnemies() {
        return enemies;
    }

    public int getScene() {
        return scene;
    }

}
