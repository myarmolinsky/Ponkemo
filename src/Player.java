import java.io.*;
import java.util.*;

public class Player implements Serializable {

	private ArrayList<OwnedPokemon> pc;
	private int tier1Points;
	private int tier2Points;
	private int tier3Points;
	private int tier4Points;
	private int tier5Points;

	public Player() {
		pc = new ArrayList<>();
		tier1Points = 0;
		tier2Points = 0;
		tier3Points = 0;
		tier4Points = 0;
		tier5Points = 0;
	}

	public void addTier1(int num) {
		tier1Points = tier1Points + num;
	}

	public void addTier2(int num) {
		tier2Points = tier2Points + num;
	}

	public void addTier3(int num) {
		tier3Points = tier3Points + num;
	}

	public void addTier4(int num) {
		tier4Points = tier4Points + num;
	}

	public void addTier5(int num) {
		tier5Points = tier5Points + num;
	}
	
	public int getTier1() {
		return tier1Points;
	}

	public void spendTier1(int num) {
		tier1Points -= num;
	}
	
	public int getTier2() {
		return tier2Points;
	}

	public void spendTier2(int num) {
		tier2Points -= num;
	}
	
	public int getTier3() {
		return tier3Points;
	}

	public void spendTier3(int num) {
		tier3Points -= num;
	}
	
	public int getTier4() {
		return tier4Points;
	}

	public void spendTier4(int num) {
		tier4Points -= num;
	}
	
	public int getTier5() {
		return tier5Points;
	}
	
	public void spendTier5(int num) {
		tier5Points -= num;
	}

	public void catchPokemon(OwnedPokemon ownedPokemon) {
		pc.add(ownedPokemon);
	}

	public ArrayList<OwnedPokemon> getPC() {
		return pc;
	}
	
	public String toString() {
		return String.format("Pokemon Owned: " + pc.size() + "\n"
				+ "Tier 1 Points: " + tier1Points + "\n"
				+ "Tier 2 Points: " + tier2Points + "\n"
				+ "Tier 3 Points: " + tier3Points + "\n"
				+ "Tier 4 Points: " + tier4Points + "\n"
				+ "Tier 5 Points: " + tier5Points + "\n");
	}

}
