import java.util.*;

public class Pokemon {
	
	private String name;
	private int baseHealth;
	private int baseAttack;
	private int baseDefense;
	private int baseSpecialAttack;
	private int baseSpecialDefense;
	private int baseSpeed;
	private int spawnRate;
	private String eggGroup;
	private String gender;
	private ArrayList<Move> moves;

	public Pokemon(String name, int hp, int atk, int def, int spa, int spd, int spe, int rate, String egg, String gender, Move[] moves) {
		this.name = name;
		baseHealth = hp;
		baseAttack = atk;
		baseDefense = def;
		baseSpecialAttack = spa;
		baseSpecialDefense = spd;
		baseSpeed = spe;
		spawnRate = rate;
		eggGroup = egg;
		this.gender = gender;
		this.moves.addAll(Arrays.asList(moves));
	}
	
	public String getName() {
		return name;
	}
	
	public int getBaseHealth() {
		return baseHealth;
	}
	
	public int getBaseAttack() {
		return baseAttack;
	}
	
	public int getBaseDefense() {
		return baseDefense;
	}
	
	public int getBaseSpecialAttack() {
		return baseSpecialAttack;
	}
	
	public int getBaseSpecialDefense() {
		return baseSpecialDefense;
	}

	public int getBaseSpeed() {
		return baseSpeed;
	}

	public int getSpawnRate() {
		return spawnRate;
	}

	public String getEggGroup() {
		return eggGroup;
	}

	public String getGender() {
		return gender;
	}
	
	public ArrayList<Move> getMoves(){
		return moves;
	}
	
}
