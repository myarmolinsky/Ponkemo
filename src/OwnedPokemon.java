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
	private String nature; // there are 25 different natures, each having a different impact on the Pokemon's stats
	private boolean favorite; // Pokemon with favorite set to true get prioritized in the player's pc when it gets sorted
	private int t1PointsInvested;
	private int t2PointsInvested;
	private int t3PointsInvested;
	private int t4PointsInvested;
	private int t5PointsInvested;
	private boolean evoLock;

	public OwnedPokemon(Pokemon pokemon) {
		// this constructor is for making a new Pokemon for the player to catch
		this.pokemon = pokemon;
		nickname = pokemon.getName();
		level = new Random().nextInt(20) + 1; // the Pokemon starts with a random level between 1 and 50
		int temp = new Random().nextInt(4096); // there is a 1/4096 chance that a Pokemon is shiny
		if (temp == 0)
			shiny = true;
		else
			shiny = false;
		if (pokemon.getGenderRatio() < 0)
			gender = "Genderless";
		else {
			temp = new Random().nextInt(1000) + 1;
			// choose a random number out of 1000 and divide it by 10, then compare the resulting double to the Pokemon's gender ratio to determine its gender
			if ((((double) temp) / 10 ) <= pokemon.getGenderRatio())
				gender = "Male";
			else
				gender = "Female";
		}
		level = new Random().nextInt(50) + 1;
		// IVs can be any number 0-31
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
		t1PointsInvested = 0;
		t2PointsInvested = 0;
		t3PointsInvested = 0;
		t4PointsInvested = 0;
		t5PointsInvested = 0;
		evoLock = false;
	}

	public OwnedPokemon(Pokemon pokemon, int healthIV, int attackIV, int defenseIV, int specialAttackIV, int specialDefenseIV, int speedIV, OwnedPokemon oldOne, OwnedPokemon oldTwo) {
		// this constructor is for breeding
		// pokemon is the Pokemon determined to be the baby Pokemon in the breeding session and each IV is the best of both parents
		this.pokemon = pokemon;
		this.nickname = pokemon.getName();
		level = 1; // bred Pokemon start at level 1
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
		// the baby Pokemon has a invested point values equal to the total of the parents' invested point values
		t1PointsInvested = oldOne.t1PointsInvested + oldTwo.t1PointsInvested;
		t2PointsInvested = oldOne.t2PointsInvested + oldTwo.t2PointsInvested;
		t3PointsInvested = oldOne.t3PointsInvested + oldTwo.t3PointsInvested;
		t4PointsInvested = oldOne.t4PointsInvested + oldTwo.t4PointsInvested;
		t5PointsInvested = oldOne.t5PointsInvested + oldTwo.t5PointsInvested;
		evoLock = false;
	}

	public OwnedPokemon(OwnedPokemon ownedPokemon, Pokemon poke) {
		// this constructor is used when evolving a Pokemon or changing its forme
		// everything about the original OwnedPokemon remains the same except its Pokemon data member and its stats which are recalculated due to the new base stats
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
		t1PointsInvested = ownedPokemon.t1PointsInvested;
		t2PointsInvested = ownedPokemon.t2PointsInvested;
		t3PointsInvested = ownedPokemon.t3PointsInvested;
		t4PointsInvested = ownedPokemon.t4PointsInvested;
		t5PointsInvested = ownedPokemon.t5PointsInvested;
		evoLock = false;
	}

	private void calculateStats() {
		// health stat is calculated differently than the other stats
		if (getName().equals("Shedinja")) {
			// Shedinja always has only 1 point for its health stat
			healthStat = 1;
		} else {
			healthStat = (((2 * pokemon.getBaseHealth() + healthIV + (healthEV/4)) * level)/100) + level + 10;
		}
		// the rest of the stats are calculated depending on the nature
		switch(nature) {
		case "Hardy":
		case "Docile":
		case "Serious":
		case "Bashful":
		case "Quirky":
			// Hardy, Docile, Serious, Bashful, and Quirky don't have an impact on how the stats are calculated
			// but every other nature gives one stat a 1.1x multiplier and another stat a .9x multiplier
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

	// stats must be recalculated every time the Pokemon's EVs change
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
		// a Pokemon's IVs can add up to a max total of 186 points
		return (((double)(healthIV + attackIV + defenseIV + specialAttackIV + specialDefenseIV + speedIV)/186) * 100);
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
		// level affects a Pokemon's stats so its stats need to be recalculated when it levels up
		level += 1;
		calculateStats();
	}

	public boolean isFavorite() {
		return favorite;
	}

	public void toggleFavorite() {
		favorite = !favorite;
	}
	
	public int getT1PointsInvested() {
		return t1PointsInvested;
	}
	
	public int getT2PointsInvested() {
		return t2PointsInvested;
	}
	
	public int getT3PointsInvested() {
		return t3PointsInvested;
	}
	
	public int getT4PointsInvested() {
		return t4PointsInvested;
	}
	
	public int getT5PointsInvested() {
		return t5PointsInvested;
	}
	
	public void addT1PointsInvested(int points) {
		t1PointsInvested += points;
	}
	
	public void addT2PointsInvested(int points) {
		t2PointsInvested += points;
	}
	
	public void addT3PointsInvested(int points) {
		t3PointsInvested += points;
	}
	
	public void addT4PointsInvested(int points) {
		t4PointsInvested += points;
	}
	
	public void addT5PointsInvested(int points) {
		t5PointsInvested += points;
	}
	
	public void setT1PointsInvested(int points) {
		t1PointsInvested = points;
	}
	
	public void setT2PointsInvested(int points) {
		t2PointsInvested = points;
	}
	
	public void setT3PointsInvested(int points) {
		t3PointsInvested = points;
	}
	
	public void setT4PointsInvested(int points) {
		t4PointsInvested = points;
	}
	
	public void setT5PointsInvested(int points) {
		t5PointsInvested = points;
	}

	public void refundPoints(Player p) {
		// for when a Pokemon is being recycled
		p.addTier1(t1PointsInvested/2);
		p.addTier2(t2PointsInvested/2);
		p.addTier3(t3PointsInvested/2);
		p.addTier4(t4PointsInvested/2);
		p.addTier5(t5PointsInvested/2);
	}
	
	public boolean isEvoLocked() {
		return evoLock;
	}
	
	public void toggleEvoLock() {
		evoLock = !evoLock;
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
				+ "Speed Stat: " + speedStat + "\n"
				+ "Tier 1 Points Invested: " + t1PointsInvested + "\n"
				+ "Tier 2 Points Invested: " + t2PointsInvested + "\n"
				+ "Tier 3 Points Invested: " + t3PointsInvested + "\n"
				+ "Tier 4 Points Invested: " + t4PointsInvested + "\n"
				+ "Tier 5 Points Invested: " + t5PointsInvested);
		return temp;
	}

	public boolean equals(OwnedPokemon op) {
		// everything must be exactly the same for the OwnedPokemon to be determined to be equal
		if (pokemon.equals(op.pokemon) 
				&& shiny == op.shiny 
				&& attackEV == op.attackEV 
				&& attackIV == op.attackIV
				&& attackStat == op.attackStat
				&& defenseEV == op.defenseEV
				&& defenseIV == op.defenseIV
				&& defenseStat == op.defenseStat
				&& favorite == op.favorite
				&& gender.equals(op.gender)
				&& healthEV == op.healthEV
				&& healthIV == op.healthIV
				&& healthStat == op.healthStat
				&& level == op.level
				&& nature.equals(op.nature)
				&& nickname.equals(op.nickname)
				&& specialAttackEV == op.specialAttackEV
				&& specialAttackIV == op.specialAttackIV
				&& specialAttackStat == op.specialAttackStat
				&& specialDefenseEV == op.specialDefenseEV
				&& specialDefenseIV == op.specialDefenseIV
				&& specialDefenseStat == op.specialDefenseStat
				&& speedEV == op.speedEV
				&& speedIV == op.speedIV
				&& speedStat == op.speedStat)
			return true;
		return false;
	}
}
