import java.util.HashMap;

public class Enemies {

	private HashMap<String, Enemy> map;

	//image hp attack deffense speed luck
	//LEVEL todo
	//e se o player tiver a mesma speed que o enemy????????

	public Enemies() {
		map = new HashMap<String, Enemy>();
		map.put(Res.ZUZU, new Enemy(Res.ZUZU_IMAGE, Res.ZUZU, 8, 5, 6, 4, 50));
		map.put(Res.MONSTER, new Enemy(Res.MONSTER_IMAGE, Res.MONSTER, 10, 4, 5, 3, 50));
	}

	public Enemy get(String key) {
		if (map.containsKey(key)) {
			return map.get(key);
		}
		return null;
	}

}