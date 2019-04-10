import java.util.*;

public class OwnedPokemon {

	private Pokemon pokemon;
	private boolean shiny;
	private String nickname;
	private String gender;
//	private int level;
	private int healthIV;
	private int attackIV;
	private int defenseIV;
	private int specialAttackIV;
	private int specialDefenseIV;
	private int speedIV;
	//	private int healthEV;
	//	private int attackEV;
	//	private int defenseEV;
	//	private int specialAttackEV;
	//	private int specialDefenseEV;
	//	private int speedEV;
	//	private int healthStat;
	//	private int attackStat;
	//	private int defenseStat;
	//	private int specialAttackStat;
	//	private int specialDefenseStat;
	//	private int speedStat;

	public OwnedPokemon(Pokemon pokemon) {
		this.pokemon = pokemon;
		nickname = pokemon.getName();
//		level = new Random().nextInt(50) + 1;
		int temp = new Random().nextInt(1000);
		if (temp == 0)
			shiny = true;
		else
			shiny = false;
		if (pokemon.getGenderRatio() < 0) {
			gender = "genderless";
		} else {
			temp = new Random().nextInt(100) + 1;
			if (temp/100 <= pokemon.getGenderRatio())
				gender = "male";
			else
				gender = "female";
		}
		healthIV = new Random().nextInt(32);
		attackIV = new Random().nextInt(32);
		defenseIV = new Random().nextInt(32);
		specialAttackIV = new Random().nextInt(32);
		specialDefenseIV = new Random().nextInt(32);
		speedIV = new Random().nextInt(32);
		//		healthEV = 0;
		//		attackEV = 0;
		//		defenseEV = 0;
		//		specialAttackEV = 0;
		//		specialDefenseEV = 0;
		//		speedEV = 0;
		//		healthStat = 0;
		//		attackStat = 0;
		//		defenseStat = 0;
		//		specialAttackStat = 0;
		//		specialDefenseStat = 0;
		//		speedStat = 0;
		//		calculateStats();
	}

	//	private void calculateStats() {
	//		// to be implemented
	//	}

	public Pokemon getPokemon() {
		return pokemon;
	}

	public boolean isShiny() {
		return shiny;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nick) {
		nickname = nick;
	}

//	public int getLevel() {
//		return level;
//	}

	public int getHealthIV() {
		return healthIV;
	}

	public int getAttackIV() {
		return attackIV;
	}

	public int getDefenseIV() {
		return defenseIV;
	}

	public int getSpecialAttackIV() {
		return specialAttackIV;
	}

	public int getSpecialDefenseIV() {
		return specialDefenseIV;
	}

	public int getSpeedIV() {
		return speedIV;
	}

	//	public int getHealthEV() {
	//		return healthEV;
	//	}
	//
	//	public void setHealthEV(int healthEV) {
	//		this.healthEV = healthEV;
	//	}
	//
	//	public int getAttackEV() {
	//		return attackEV;
	//	}
	//
	//	public void setAttackEV(int attackEV) {
	//		this.attackEV = attackEV;
	//	}
	//
	//	public int getDefenseEV() {
	//		return defenseEV;
	//	}
	//
	//	public void setDefenseEV(int defenseEV) {
	//		this.defenseEV = defenseEV;
	//	}
	//
	//	public int getSpecialAttackEV() {
	//		return specialAttackEV;
	//	}
	//
	//	public void setSpecialAttackEV(int specialAttackEV) {
	//		this.specialAttackEV = specialAttackEV;
	//	}
	//
	//	public int getSpecialDefenseEV() {
	//		return specialDefenseEV;
	//	}
	//
	//	public void setSpecialDefenseEV(int specialDefenseEV) {
	//		this.specialDefenseEV = specialDefenseEV;
	//	}
	//
	//	public int getSpeedEV() {
	//		return speedEV;
	//	}
	//
	//	public void setSpeedEV(int speedEV) {
	//		this.speedEV = speedEV;
	//	}
	//
	//	public int getHealthStat() {
	//		return healthStat;
	//	}
	//
	//	public int getAttackStat() {
	//		return attackStat;
	//	}
	//
	//	public int getDefenseStat() {
	//		return defenseStat;
	//	}
	//
	//	public int getSpecialAttackStat() {
	//		return specialAttackStat;
	//	}
	//
	//	public int getSpecialDefenseStat() {
	//		return specialDefenseStat;
	//	}
	//
	//	public int getSpeedStat() {
	//		return speedStat;
	//	}

	public String toString() {
		if (shiny)
			return String.format("SHINY\n"
					+ "Name: " + pokemon.getName() + "\n"
					+ "Nickname: " + nickname + "\n"
					+ "Gender: " + gender + "\n"
					+ "Health IVs: " + healthIV + "\n"
					+ "Attack IVs: " + attackIV + "\n"
					+ "Defense IVs: " + defenseIV + "\n"
					+ "Special Attack IVs: " + specialAttackIV + "\n"
					+ "Special Defense IVs: " + specialDefenseIV + "\n"
					+ "Speed IVs: " + speedIV + "\n");
		return String.format("Name: " + pokemon.getName() + "\n"
				+ "Nickname: " + nickname + "\n"
				+ "Gender: " + gender + "\n"
				+ "Health IVs: " + healthIV + "\n"
				+ "Attack IVs: " + attackIV + "\n"
				+ "Defense IVs: " + defenseIV + "\n"
				+ "Special Attack IVs: " + specialAttackIV + "\n"
				+ "Special Defense IVs: " + specialDefenseIV + "\n"
				+ "Speed IVs: " + speedIV + "\n");
	}

}
