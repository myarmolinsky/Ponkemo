import java.util.*;

public class Player {

	private ArrayList<OwnedPokemon> pc;
	private int tier1RarityPoints;
	private int tier2RarityPoints;
	private int tier3RarityPoints;
	private int tier4RarityPoints;
	private int tier5RarityPoints;

	public Player() {
		pc = new ArrayList<>();
		tier1RarityPoints = 0;
		tier2RarityPoints = 0;
		tier3RarityPoints = 0;
		tier4RarityPoints = 0;
		tier5RarityPoints = 0;
	}

	public void addTier1(int num) {
		tier1RarityPoints = tier1RarityPoints + num;
	}

	public void addTier2(int num) {
		tier2RarityPoints = tier2RarityPoints + num;
	}

	public void addTier3(int num) {
		tier3RarityPoints = tier3RarityPoints + num;
	}

	public void addTier4(int num) {
		tier4RarityPoints = tier4RarityPoints + num;
	}

	public void addTier5(int num) {
		tier5RarityPoints = tier5RarityPoints + num;
	}
	
	public int getTier1() {
		return tier1RarityPoints;
	}
	
	public int getTier2() {
		return tier2RarityPoints;
	}
	
	public int getTier3() {
		return tier3RarityPoints;
	}
	
	public int getTier4() {
		return tier4RarityPoints;
	}
	
	public int getTier5() {
		return tier5RarityPoints;
	}

	public void catchPokemon(OwnedPokemon ownedPokemon) {
		pc.add(ownedPokemon);
	}

	public ArrayList<OwnedPokemon> getPC() {
		return pc;
	}

}
