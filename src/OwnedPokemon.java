import java.io.*;
import java.util.*;

public class OwnedPokemon implements Serializable{

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
	private boolean favorite;

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
			gender = "Genderless";
		else {
			temp = new Random().nextInt(1000) + 1;
			if ((((double) temp) / 10 ) <= pokemon.getGenderRatio())
				gender = "Male";
			else
				gender = "Female";
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
			break;
		case 1:
			nature = "Lonely";
			break;
		case 2:
			nature = "Brave";
			break;
		case 3:
			nature = "Adamant";
			break;
		case 4:
			nature = "Naughty";
			break;
		case 5:
			nature = "Bold";
			break;
		case 6:
			nature = "Docile";
			break;
		case 7:
			nature = "Relaxed";
			break;
		case 8:
			nature = "Impish";
			break;
		case 9:
			nature = "Lax";
			break;
		case 10:
			nature = "Timid";
			break;
		case 11:
			nature = "Hasty";
			break;
		case 12:
			nature = "Serious";
			break;
		case 13:
			nature = "Jolly";
			break;
		case 14:
			nature = "Naive";
			break;
		case 15:
			nature = "Modest";
			break;
		case 16:
			nature = "Mild";
			break;
		case 17:
			nature = "Quiet";
			break;
		case 18:
			nature = "Bashful";
			break;
		case 19:
			nature = "Rash";
			break;
		case 20:
			nature = "Calm";
			break;
		case 21:
			nature = "Gentle";
			break;
		case 22:
			nature = "Sassy";
			break;
		case 23:
			nature = "Careful";
			break;
		case 24:
			nature = "Quirky";
			break;
		}
		calculateStats();
		favorite = false;
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
		if (pokemon.getGenderRatio() < 0)
			gender = "Genderless";
		else {
			temp = new Random().nextInt(1000) + 1;
			if ((((double) temp) / 10 ) <= pokemon.getGenderRatio())
				gender = "Male";
			else
				gender = "Female";
		}
		this.healthIV = healthIV;
		this.attackIV = attackIV;
		this.defenseIV = defenseIV;
		this.specialAttackIV = specialAttackIV;
		this.specialDefenseIV = specialDefenseIV;
		this.speedIV = speedIV;
		switch(new Random().nextInt(25)) {
		case 0:
			nature = "Hardy";
			break;
		case 1:
			nature = "Lonely";
			break;
		case 2:
			nature = "Brave";
			break;
		case 3:
			nature = "Adamant";
			break;
		case 4:
			nature = "Naughty";
			break;
		case 5:
			nature = "Bold";
			break;
		case 6:
			nature = "Docile";
			break;
		case 7:
			nature = "Relaxed";
			break;
		case 8:
			nature = "Impish";
			break;
		case 9:
			nature = "Lax";
			break;
		case 10:
			nature = "Timid";
			break;
		case 11:
			nature = "Hasty";
			break;
		case 12:
			nature = "Serious";
			break;
		case 13:
			nature = "Jolly";
			break;
		case 14:
			nature = "Naive";
			break;
		case 15:
			nature = "Modest";
			break;
		case 16:
			nature = "Mild";
			break;
		case 17:
			nature = "Quiet";
			break;
		case 18:
			nature = "Bashful";
			break;
		case 19:
			nature = "Rash";
			break;
		case 20:
			nature = "Calm";
			break;
		case 21:
			nature = "Gentle";
			break;
		case 22:
			nature = "Sassy";
			break;
		case 23:
			nature = "Careful";
			break;
		case 24:
			nature = "Quirky";
			break;
		}
		calculateStats();
		favorite = false;
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
		favorite = ownedPokemon.favorite;
	}

	public OwnedPokemon(OwnedPokemon ownedPokemon, Pokemon poke) {
		pokemon = poke;
		if (ownedPokemon.nickname.equals(ownedPokemon.pokemon.getName()))
			nickname = poke.getName();
		else
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
		favorite = ownedPokemon.favorite;
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

	public String getNature() {
		return nature;
	}

	public void setNature(String nature) {
		this.nature = nature;
	}

	public void levelUp() {
		level += 1;
		calculateStats();
	}
	
	public boolean isFavorite() {
		return favorite;
	}
	
	public void toggleFavorite() {
		favorite = !favorite;
	}

	public String toString() {
		String temp = "";
		if (shiny)
			temp = String.format("SHINY\n");
		if (favorite)
			temp = String.format(temp + "FAVORITE\n");
		temp = String.format(temp + "Name: " + pokemon.getName() + "\n"
				+ "Nickname: " + nickname + "\n"
				+ "Gender: " + gender + "\n"
				+ "Nature: " + nature + "\n"
				+ "Egg Group(s): ");
		boolean first = true;
		for (String s : pokemon.getEggGroup()) {
			if (first) {
				temp = String.format(temp + s);
				first = false;
			} else
				temp = String.format(temp + ", " + s);
		}
		temp = String.format(temp + "\nLevel: " + level + "\n"
				+ "Health IVs: " + healthIV + "\n"
				+ "Attack IVs: " + attackIV + "\n"
				+ "Defense IVs: " + defenseIV + "\n"
				+ "Special Attack IVs: " + specialAttackIV + "\n"
				+ "Special Defense IVs: " + specialDefenseIV + "\n"
				+ "Speed IVs: " + speedIV + "\n"
				+ "Total IV Percentage: " + getTotalIVPercentage() + "%%\n"
				+ "Health Stat: " + healthStat + "\n"
				+ "Attack Stat: " + attackStat + "\n"
				+ "Defense Stat: " + defenseStat + "\n"
				+ "Special Attack Stat: " + specialAttackStat + "\n"
				+ "Special Defense Stat: " + specialDefenseStat + "\n"
				+ "Speed Stat: " + speedStat);
		return temp;
	}
}
