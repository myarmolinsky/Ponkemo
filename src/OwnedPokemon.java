import java.util.*;

public class OwnedPokemon {

	private Pokemon pokemon;
	private boolean shiny;
	private String nickname;
	private String gender;
	private int level;
	private int healthIV;
	private int attackIV;
	private int defenseIV;
	private int specialAttackIV;
	private int specialDefenseIV;
	private int speedIV;
	private int healthEV;
	private int attackEV;
	private int defenseEV;
	private int specialAttackEV;
	private int specialDefenseEV;
	private int speedEV;
	private int healthStat;
	private int attackStat;
	private int defenseStat;
	private int specialAttackStat;
	private int specialDefenseStat;
	private int speedStat;
	private String nature;

	public OwnedPokemon(Pokemon pokemon) {
		this.pokemon = pokemon;
		nickname = pokemon.getName();
		level = new Random().nextInt(50) + 1;
		int temp = new Random().nextInt(4096);
		if (temp == 0)
			shiny = true;
		else
			shiny = false;
		if (pokemon.getGenderRatio() < 0)
			gender = "genderless";
		else {
			temp = new Random().nextInt(1000) + 1;
			if ((((double) temp) / 10 ) <= pokemon.getGenderRatio())
				gender = "male";
			else
				gender = "female";
		}
		level = new Random().nextInt(50) + 1;
		healthIV = new Random().nextInt(32);
		attackIV = new Random().nextInt(32);
		defenseIV = new Random().nextInt(32);
		specialAttackIV = new Random().nextInt(32);
		specialDefenseIV = new Random().nextInt(32);
		speedIV = new Random().nextInt(32);
		healthEV = 0;
		attackEV = 0;
		defenseEV = 0;
		specialAttackEV = 0;
		specialDefenseEV = 0;
		speedEV = 0;
		healthStat = 0;
		attackStat = 0;
		defenseStat = 0;
		specialAttackStat = 0;
		specialDefenseStat = 0;
		speedStat = 0;
		switch(new Random().nextInt(25)) {
		case 0:
			nature = "Hardy";
		case 1:
			nature = "Lonely";
		case 2:
			nature = "Brave";
		case 3:
			nature = "Adamant";
		case 4:
			nature = "Naughty";
		case 5:
			nature = "Bold";
		case 6:
			nature = "Docile";
		case 7:
			nature = "Relaxed";
		case 8:
			nature = "Impish";
		case 9:
			nature = "Lax";
		case 10:
			nature = "Timid";
		case 11:
			nature = "Hasty";
		case 12:
			nature = "Serious";
		case 13:
			nature = "Jolly";
		case 14:
			nature = "Naive";
		case 15:
			nature = "Modest";
		case 16:
			nature = "Mild";
		case 17:
			nature = "Quiet";
		case 18:
			nature = "Bashful";
		case 19:
			nature = "Rash";
		case 20:
			nature = "Calm";
		case 21:
			nature = "Gentle";
		case 22:
			nature = "Sassy";
		case 23:
			nature = "Careful";
		case 24:
			nature = "Quirky";
		}
		calculateStats();
	}

	public OwnedPokemon(Pokemon pokemon, int healthIV, int attackIV, int defenseIV, int specialAttackIV, int specialDefenseIV, int speedIV) {
		this.pokemon = pokemon;
		this.nickname = pokemon.getName();
		level = 1;
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
		this.healthIV = healthIV;
		this.attackIV = attackIV;
		this.defenseIV = defenseIV;
		this.specialAttackIV = specialAttackIV;
		this.specialDefenseIV = specialDefenseIV;
		this.speedIV = speedIV;
		calculateStats();
	}

	public OwnedPokemon(OwnedPokemon ownedPokemon) {
		pokemon = ownedPokemon.pokemon;
		nickname = ownedPokemon.nickname;
		shiny = ownedPokemon.shiny;
		gender = ownedPokemon.gender;
		healthIV = ownedPokemon.healthIV;
		attackIV = ownedPokemon.attackIV;
		defenseIV = ownedPokemon.defenseIV;
		specialAttackIV = ownedPokemon.specialAttackIV;
		specialDefenseIV = ownedPokemon.specialDefenseIV;
		speedIV = ownedPokemon.speedIV;
		level = ownedPokemon.level;
		nature = ownedPokemon.nature;
		calculateStats();
	}

	private void calculateStats() {
		healthStat = (((2 * pokemon.getBaseHealth() + healthIV + (healthEV/4)) * level)/100) + level + 10;
		switch(nature) {
			case "Hardy":
			case "Docile":
			case "Serious":
			case "Bashful":
			case "Quirky":
				attackStat = (((2 * pokemon.getBaseAttack() + attackIV + (attackEV/4)) * level)/100) + 5;
				defenseStat = (((2 * pokemon.getBaseDefense() + defenseIV + (defenseEV/4)) * level)/100) + 5;
				specialAttackStat = (((2 * pokemon.getBaseSpecialAttack() + specialAttackIV + (specialAttackEV/4)) * level)/100) + 5;
				specialDefenseStat = (((2 * pokemon.getBaseSpecialDefense() + specialDefenseIV + (specialDefenseEV/4)) * level)/100) + 5;
				speedStat = (((2 * pokemon.getBaseSpeed() + speedIV + (speedEV/4)) * level)/100) + 5;
				break;
			case "Lonely":
				attackStat = (int) (((((2 * pokemon.getBaseAttack() + attackIV + (attackEV/4)) * level)/100) + 5) * 1.1);
				defenseStat = (int) (((((2 * pokemon.getBaseDefense() + defenseIV + (defenseEV/4)) * level)/100) + 5) * .9);
				specialAttackStat = (((2 * pokemon.getBaseSpecialAttack() + specialAttackIV + (specialAttackEV/4)) * level)/100) + 5;
				specialDefenseStat = (((2 * pokemon.getBaseSpecialDefense() + specialDefenseIV + (specialDefenseEV/4)) * level)/100) + 5;
				speedStat = (((2 * pokemon.getBaseSpeed() + speedIV + (speedEV/4)) * level)/100) + 5;
				break;
			case "Brave":
				attackStat = (int) (((((2 * pokemon.getBaseAttack() + attackIV + (attackEV/4)) * level)/100) + 5) * 1.1);
				defenseStat = (((2 * pokemon.getBaseDefense() + defenseIV + (defenseEV/4)) * level)/100) + 5;
				specialAttackStat = (((2 * pokemon.getBaseSpecialAttack() + specialAttackIV + (specialAttackEV/4)) * level)/100) + 5;
				specialDefenseStat = (((2 * pokemon.getBaseSpecialDefense() + specialDefenseIV + (specialDefenseEV/4)) * level)/100) + 5;
				speedStat = (int) (((((2 * pokemon.getBaseSpeed() + speedIV + (speedEV/4)) * level)/100) + 5) * .9);
				break;
			case "Adamant":
				attackStat = (int) (((((2 * pokemon.getBaseAttack() + attackIV + (attackEV/4)) * level)/100) + 5) * 1.1);
				defenseStat = (((2 * pokemon.getBaseDefense() + defenseIV + (defenseEV/4)) * level)/100) + 5;
				specialAttackStat = (int) (((((2 * pokemon.getBaseSpecialAttack() + specialAttackIV + (specialAttackEV/4)) * level)/100) + 5) * .9);
				specialDefenseStat = (((2 * pokemon.getBaseSpecialDefense() + specialDefenseIV + (specialDefenseEV/4)) * level)/100) + 5;
				speedStat = (((2 * pokemon.getBaseSpeed() + speedIV + (speedEV/4)) * level)/100) + 5;
				break;
			case "Naughty":
				attackStat = (int) (((((2 * pokemon.getBaseAttack() + attackIV + (attackEV/4)) * level)/100) + 5) * 1.1);
				defenseStat = (((2 * pokemon.getBaseDefense() + defenseIV + (defenseEV/4)) * level)/100) + 5;
				specialAttackStat = (((2 * pokemon.getBaseSpecialAttack() + specialAttackIV + (specialAttackEV/4)) * level)/100) + 5;
				specialDefenseStat = (int) (((((2 * pokemon.getBaseSpecialDefense() + specialDefenseIV + (specialDefenseEV/4)) * level)/100) + 5) * .9);
				speedStat = (((2 * pokemon.getBaseSpeed() + speedIV + (speedEV/4)) * level)/100) + 5;
				break;
			case "Bold":
				attackStat = (int) (((((2 * pokemon.getBaseAttack() + attackIV + (attackEV/4)) * level)/100) + 5) * .9);
				defenseStat = (int) (((((2 * pokemon.getBaseDefense() + defenseIV + (defenseEV/4)) * level)/100) + 5) * 1.1);
				specialAttackStat = (((2 * pokemon.getBaseSpecialAttack() + specialAttackIV + (specialAttackEV/4)) * level)/100) + 5;
				specialDefenseStat = (((2 * pokemon.getBaseSpecialDefense() + specialDefenseIV + (specialDefenseEV/4)) * level)/100) + 5;
				speedStat = (((2 * pokemon.getBaseSpeed() + speedIV + (speedEV/4)) * level)/100) + 5;
				break;
			case "Relaxed":
				attackStat = (((2 * pokemon.getBaseAttack() + attackIV + (attackEV/4)) * level)/100) + 5;
				defenseStat = (int) (((((2 * pokemon.getBaseDefense() + defenseIV + (defenseEV/4)) * level)/100) + 5) * 1.1);
				specialAttackStat = (((2 * pokemon.getBaseSpecialAttack() + specialAttackIV + (specialAttackEV/4)) * level)/100) + 5;
				specialDefenseStat = (((2 * pokemon.getBaseSpecialDefense() + specialDefenseIV + (specialDefenseEV/4)) * level)/100) + 5;
				speedStat = (int) (((((2 * pokemon.getBaseSpeed() + speedIV + (speedEV/4)) * level)/100) + 5) * .9);
				break;
			case "Impish":
				attackStat = (((2 * pokemon.getBaseAttack() + attackIV + (attackEV/4)) * level)/100) + 5;
				defenseStat = (int) (((((2 * pokemon.getBaseDefense() + defenseIV + (defenseEV/4)) * level)/100) + 5) * 1.1);
				specialAttackStat = (int) (((((2 * pokemon.getBaseSpecialAttack() + specialAttackIV + (specialAttackEV/4)) * level)/100) + 5) * .9);
				specialDefenseStat = (((2 * pokemon.getBaseSpecialDefense() + specialDefenseIV + (specialDefenseEV/4)) * level)/100) + 5;
				speedStat = (((2 * pokemon.getBaseSpeed() + speedIV + (speedEV/4)) * level)/100) + 5;
				break;
			case "Lax":
				attackStat = (((2 * pokemon.getBaseAttack() + attackIV + (attackEV/4)) * level)/100) + 5;
				defenseStat = (int) (((((2 * pokemon.getBaseDefense() + defenseIV + (defenseEV/4)) * level)/100) + 5) * 1.1);
				specialAttackStat = (((2 * pokemon.getBaseSpecialAttack() + specialAttackIV + (specialAttackEV/4)) * level)/100) + 5;
				specialDefenseStat = (int) (((((2 * pokemon.getBaseSpecialDefense() + specialDefenseIV + (specialDefenseEV/4)) * level)/100) + 5) * .9);
				speedStat = (((2 * pokemon.getBaseSpeed() + speedIV + (speedEV/4)) * level)/100) + 5;
				break;
			case "Timid":
				attackStat = (int) (((((2 * pokemon.getBaseAttack() + attackIV + (attackEV/4)) * level)/100) + 5) * .9);
				defenseStat = (((2 * pokemon.getBaseDefense() + defenseIV + (defenseEV/4)) * level)/100) + 5;
				specialAttackStat = (((2 * pokemon.getBaseSpecialAttack() + specialAttackIV + (specialAttackEV/4)) * level)/100) + 5;
				specialDefenseStat = (((2 * pokemon.getBaseSpecialDefense() + specialDefenseIV + (specialDefenseEV/4)) * level)/100) + 5;
				speedStat = (int) (((((2 * pokemon.getBaseSpeed() + speedIV + (speedEV/4)) * level)/100) + 5) * 1.1);
				break;
			case "Hasty":
				attackStat = (((2 * pokemon.getBaseAttack() + attackIV + (attackEV/4)) * level)/100) + 5;
				defenseStat = (int) (((((2 * pokemon.getBaseDefense() + defenseIV + (defenseEV/4)) * level)/100) + 5) * .9);
				specialAttackStat = (((2 * pokemon.getBaseSpecialAttack() + specialAttackIV + (specialAttackEV/4)) * level)/100) + 5;
				specialDefenseStat = (((2 * pokemon.getBaseSpecialDefense() + specialDefenseIV + (specialDefenseEV/4)) * level)/100) + 5;
				speedStat = (int) (((((2 * pokemon.getBaseSpeed() + speedIV + (speedEV/4)) * level)/100) + 5) * 1.1);
				break;
			case "Jolly":
				attackStat = (((2 * pokemon.getBaseAttack() + attackIV + (attackEV/4)) * level)/100) + 5;
				defenseStat = (((2 * pokemon.getBaseDefense() + defenseIV + (defenseEV/4)) * level)/100) + 5;
				specialAttackStat = (int) (((((2 * pokemon.getBaseSpecialAttack() + specialAttackIV + (specialAttackEV/4)) * level)/100) + 5) * .9);
				specialDefenseStat = (((2 * pokemon.getBaseSpecialDefense() + specialDefenseIV + (specialDefenseEV/4)) * level)/100) + 5;
				speedStat = (int) (((((2 * pokemon.getBaseSpeed() + speedIV + (speedEV/4)) * level)/100) + 5) * 1.1);
				break;
			case "Naive":
				attackStat = (((2 * pokemon.getBaseAttack() + attackIV + (attackEV/4)) * level)/100) + 5;
				defenseStat = (((2 * pokemon.getBaseDefense() + defenseIV + (defenseEV/4)) * level)/100) + 5;
				specialAttackStat = (((2 * pokemon.getBaseSpecialAttack() + specialAttackIV + (specialAttackEV/4)) * level)/100) + 5;
				specialDefenseStat = (int) (((((2 * pokemon.getBaseSpecialDefense() + specialDefenseIV + (specialDefenseEV/4)) * level)/100) + 5) * .9);
				speedStat = (int) (((((2 * pokemon.getBaseSpeed() + speedIV + (speedEV/4)) * level)/100) + 5) * 1.1);
				break;
			case "Modest":
				attackStat = (int) (((((2 * pokemon.getBaseAttack() + attackIV + (attackEV/4)) * level)/100) + 5) * .9);
				defenseStat = (((2 * pokemon.getBaseDefense() + defenseIV + (defenseEV/4)) * level)/100) + 5;
				specialAttackStat = (int) (((((2 * pokemon.getBaseSpecialAttack() + specialAttackIV + (specialAttackEV/4)) * level)/100) + 5) * 1.1);
				specialDefenseStat = (((2 * pokemon.getBaseSpecialDefense() + specialDefenseIV + (specialDefenseEV/4)) * level)/100) + 5;
				speedStat = (((2 * pokemon.getBaseSpeed() + speedIV + (speedEV/4)) * level)/100) + 5;
				break;
			case "Mild":
				attackStat = (((2 * pokemon.getBaseAttack() + attackIV + (attackEV/4)) * level)/100) + 5;
				defenseStat = (int) (((((2 * pokemon.getBaseDefense() + defenseIV + (defenseEV/4)) * level)/100) + 5) * .9);
				specialAttackStat = (int) (((((2 * pokemon.getBaseSpecialAttack() + specialAttackIV + (specialAttackEV/4)) * level)/100) + 5) * 1.1);
				specialDefenseStat = (((2 * pokemon.getBaseSpecialDefense() + specialDefenseIV + (specialDefenseEV/4)) * level)/100) + 5;
				speedStat = (((2 * pokemon.getBaseSpeed() + speedIV + (speedEV/4)) * level)/100) + 5;
				break;
			case "Quiet":
				attackStat = (((2 * pokemon.getBaseAttack() + attackIV + (attackEV/4)) * level)/100) + 5;
				defenseStat = (((2 * pokemon.getBaseDefense() + defenseIV + (defenseEV/4)) * level)/100) + 5;
				specialAttackStat = (int) (((((2 * pokemon.getBaseSpecialAttack() + specialAttackIV + (specialAttackEV/4)) * level)/100) + 5) * 1.1);
				specialDefenseStat = (((2 * pokemon.getBaseSpecialDefense() + specialDefenseIV + (specialDefenseEV/4)) * level)/100) + 5;
				speedStat = (int) (((((2 * pokemon.getBaseSpeed() + speedIV + (speedEV/4)) * level)/100) + 5) * .9);
				break;
			case "Rash":
				attackStat = (((2 * pokemon.getBaseAttack() + attackIV + (attackEV/4)) * level)/100) + 5;
				defenseStat = (((2 * pokemon.getBaseDefense() + defenseIV + (defenseEV/4)) * level)/100) + 5;
				specialAttackStat = (int) (((((2 * pokemon.getBaseSpecialAttack() + specialAttackIV + (specialAttackEV/4)) * level)/100) + 5) * 1.1);
				specialDefenseStat = (int) (((((2 * pokemon.getBaseSpecialDefense() + specialDefenseIV + (specialDefenseEV/4)) * level)/100) + 5) * .9);
				speedStat = (((2 * pokemon.getBaseSpeed() + speedIV + (speedEV/4)) * level)/100) + 5;
				break;
			case "Calm":
				attackStat = (int) (((((2 * pokemon.getBaseAttack() + attackIV + (attackEV/4)) * level)/100) + 5) * .9);
				defenseStat = (((2 * pokemon.getBaseDefense() + defenseIV + (defenseEV/4)) * level)/100) + 5;
				specialAttackStat = (((2 * pokemon.getBaseSpecialAttack() + specialAttackIV + (specialAttackEV/4)) * level)/100) + 5;
				specialDefenseStat = (int) (((((2 * pokemon.getBaseSpecialDefense() + specialDefenseIV + (specialDefenseEV/4)) * level)/100) + 5) * 1.1);
				speedStat = (((2 * pokemon.getBaseSpeed() + speedIV + (speedEV/4)) * level)/100) + 5;
				break;
			case "Gentle":
				attackStat = (((2 * pokemon.getBaseAttack() + attackIV + (attackEV/4)) * level)/100) + 5;
				defenseStat = (int) (((((2 * pokemon.getBaseDefense() + defenseIV + (defenseEV/4)) * level)/100) + 5) * .9);
				specialAttackStat = (((2 * pokemon.getBaseSpecialAttack() + specialAttackIV + (specialAttackEV/4)) * level)/100) + 5;
				specialDefenseStat = (int) (((((2 * pokemon.getBaseSpecialDefense() + specialDefenseIV + (specialDefenseEV/4)) * level)/100) + 5) * 1.1);
				speedStat = (((2 * pokemon.getBaseSpeed() + speedIV + (speedEV/4)) * level)/100) + 5;
				break;
			case "Sassy":
				attackStat = (((2 * pokemon.getBaseAttack() + attackIV + (attackEV/4)) * level)/100) + 5;
				defenseStat = (((2 * pokemon.getBaseDefense() + defenseIV + (defenseEV/4)) * level)/100) + 5;
				specialAttackStat = (((2 * pokemon.getBaseSpecialAttack() + specialAttackIV + (specialAttackEV/4)) * level)/100) + 5;
				specialDefenseStat = (int) (((((2 * pokemon.getBaseSpecialDefense() + specialDefenseIV + (specialDefenseEV/4)) * level)/100) + 5) * 1.1);
				speedStat = (int) (((((2 * pokemon.getBaseSpeed() + speedIV + (speedEV/4)) * level)/100) + 5) * .9);
				break;
			case "Careful":
				attackStat = (((2 * pokemon.getBaseAttack() + attackIV + (attackEV/4)) * level)/100) + 5;
				defenseStat = (((2 * pokemon.getBaseDefense() + defenseIV + (defenseEV/4)) * level)/100) + 5;
				specialAttackStat = (int) (((((2 * pokemon.getBaseSpecialAttack() + specialAttackIV + (specialAttackEV/4)) * level)/100) + 5) * .9);
				specialDefenseStat = (int) (((((2 * pokemon.getBaseSpecialDefense() + specialDefenseIV + (specialDefenseEV/4)) * level)/100) + 5) * 1.1);
				speedStat = (((2 * pokemon.getBaseSpeed() + speedIV + (speedEV/4)) * level)/100) + 5;
				break;
		}
	}

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

	public String getGender() {
		return gender;
	}

	public int getLevel() {
		return level;
	}

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

	public int getHealthEV() {
		return healthEV;
	}

	public int getAttackEV() {
		return attackEV;
	}
	public int getDefenseEV() {
		return defenseEV;
	}

	public int getSpecialAttackEV() {
		return specialAttackEV;
	}

	public int getSpecialDefenseEV() {
		return specialDefenseEV;
	}

	public int getSpeedEV() {
		return speedEV;
	}

	public void addHealthEV(int num) {
		healthEV += num;
		calculateStats();
	}

	public void addAttackEV(int num) {
		attackEV += num;
		calculateStats();
	}

	public void addDefenseEV(int num) {
		defenseEV += num;
		calculateStats();
	}

	public void addSpecialAttackEV(int num) {
		specialAttackEV += num;
		calculateStats();
	}

	public void addSpecialDefenseEV(int num) {
		specialDefenseEV += num;
		calculateStats();
	}

	public void addSpeedEV(int num) {
		speedEV += num;
		calculateStats();
	}

	public void resetEVs() {
		healthEV = 0;
		attackEV = 0;
		defenseEV = 0;
		specialAttackEV = 0;
		specialDefenseEV = 0;
		speedEV = 0;
		calculateStats();
	}

	public int getHealthStat() {
		return healthStat;
	}

	public int getAttackStat() {
		return attackStat;
	}

	public int getDefenseStat() {
		return defenseStat;
	}

	public int getSpecialAttackStat() {
		return specialAttackStat;
	}

	public int getSpecialDefenseStat() {
		return specialDefenseStat;
	}

	public int getSpeedStat() {
		return speedStat;
	}

	public double getTotalIVPercentage() {
		return ((((double)(healthIV + attackIV + defenseIV + specialAttackIV + specialDefenseIV + speedIV))/186) * 100);
	}

	public String[] getEggGroup() {
		return pokemon.getEggGroup();
	}

	public String getName() {
		return pokemon.getName();
	}

	public String toString() {
		if (shiny)
			return String.format("SHINY\n"
					+ "Name: " + pokemon.getName() + "\n"
					+ "Nickname: " + nickname + "\n"
					+ "Gender: " + gender + "\n"
					+ "Nature:" + nature + "\n"
					+ "Health IVs: " + healthIV + "\n"
					+ "Attack IVs: " + attackIV + "\n"
					+ "Defense IVs: " + defenseIV + "\n"
					+ "Special Attack IVs: " + specialAttackIV + "\n"
					+ "Special Defense IVs: " + specialDefenseIV + "\n"
					+ "Speed IVs: " + speedIV + "\n"
					+ "Total IV Percentage: " + getTotalIVPercentage() + "%%");
		return String.format("Name: " + pokemon.getName() + "\n"
				+ "Nickname: " + nickname + "\n"
				+ "Gender: " + gender + "\n"
				+ "Nature:" + nature + "\n"
				+ "Health IVs: " + healthIV + "\n"
				+ "Attack IVs: " + attackIV + "\n"
				+ "Defense IVs: " + defenseIV + "\n"
				+ "Special Attack IVs: " + specialAttackIV + "\n"
				+ "Special Defense IVs: " + specialDefenseIV + "\n"
				+ "Speed IVs: " + speedIV + "\n"
				+ "Total IV Percentage: " + getTotalIVPercentage() + "%%");
	}

}
