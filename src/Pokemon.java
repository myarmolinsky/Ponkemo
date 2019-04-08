import java.util.*;

public class Pokemon {

	private String name;
	private String type1;
	private String type2;
	private int baseHealth;
	private int baseAttack;
	private int baseDefense;
	private int baseSpecialAttack;
	private int baseSpecialDefense;
	private int baseSpeed;
	private int spawnRate; //32 possible
	private String eggGroup;
	private int genderRatio;
	private ArrayList<Move> levelUpMoves;
	private ArrayList<Move> breedingMoves;
	private ArrayList<Move> tutorMoves;


	public Pokemon(String name, String type1, String type2, int hp, int atk, int def, int spa, int spd, int spe, int spawnRate, 
			String egg, int genderRatio, Move[] lUpMoves, Move[] breedMoves, Move[] tutorMoves) {
		this.name = name;
		this.type1 = type1;
		this.type2 = type2;
		baseHealth = hp;
		baseAttack = atk;
		baseDefense = def;
		baseSpecialAttack = spa;
		baseSpecialDefense = spd;
		baseSpeed = spe;
		this.spawnRate = spawnRate;
		eggGroup = egg;
		this.genderRatio = genderRatio;
		levelUpMoves.addAll(Arrays.asList(lUpMoves));
		breedingMoves.addAll(Arrays.asList(breedMoves));
		this.tutorMoves.addAll(Arrays.asList(tutorMoves));
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

	public int getGenderRatio() {
		return genderRatio;
	}

	public ArrayList<Move> getLevelUpMoves(){
		return levelUpMoves;
	}
	
	public ArrayList<Move> getBreedingMoves(){
		return breedingMoves;
	}
	
	public ArrayList<Move> getTutorMoves(){
		return tutorMoves;
	}

	public String getType1() {
		return type1;
	}

	public String getType2() {
		return type2;
	}

}
