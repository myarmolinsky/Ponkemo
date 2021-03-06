import java.io.*;

public class Pokemon implements Serializable{

	private String name;
	private String type1;
	private String type2;
	private int baseHealth;
	private int baseAttack;
	private int baseDefense;
	private int baseSpecialAttack;
	private int baseSpecialDefense;
	private int baseSpeed;
	private int spawnRate; //33 possible; the higher the spawnRate, the rarer the Pokemon
	private String[] eggGroup;
	private double genderRatio;
	private String[] evolutionTree;
	private int evolutionStage; // the stage the Pokemon is at in its evolution tree; 0 means it's first in its tree, 1 means second, etc.
	private int evolutionLevel; // -1 means special condition for evolution, 0 means the Pokemon does not evolve, any other number is the level the Pokemon evolves at

	public Pokemon(String name, String type1, String type2, int hp, int atk, int def, int spa, int spd, int spe, 
			int spawnRate, String[] eggGroup, double genderRatio, String[] evoTree, int evoStage, int evoLevel) {
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
		this.eggGroup = eggGroup;
		this.genderRatio = genderRatio;
		evolutionTree = evoTree;
		evolutionStage = evoStage;
		evolutionLevel = evoLevel;
	}

	public String getName() {
		return name;
	}

	public String getType1() {
		return type1;
	}

	public String getType2() {
		return type2;
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

	public String[] getEggGroup() {
		return eggGroup;
	}

	public double getGenderRatio() {
		return genderRatio;
	}

	public String[] getEvolutionTree() {
		return evolutionTree;
	}

	public int getEvolutionStage() {
		return evolutionStage;
	}

	public int getEvolutionLevel() {
		return evolutionLevel;
	}

	public boolean equals(Pokemon pokemon) {
		// 2 different Pokemon cannot have the same name so all that needs to be compared to see if we're looking at 2 of the same Pokemon is whether their names are the same
		if (name.equals(name))
			return true;
		return false;
	}

}
