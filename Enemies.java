import java.util.HashMap;

public class Enemies {

	private HashMap<String, Enemy> map;



	public Enemies() {
		map = new HashMap<String, Enemy>();
		map.put("zuzu", new Enemy(Res.ZUZU)); //como saber qual key existe no jogo?
	}

	public Enemy get(String key) {
		if (map.containsKey(key)) {
			return map.get(key);
		}
		return null;
	}

}