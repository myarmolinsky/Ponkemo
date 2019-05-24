import java.io.*;
import java.util.*;

public class Player implements Serializable {

	private ArrayList<OwnedPokemon> pc;
	private PriorityQueue<OwnedPokemon> pqpc;
	private int tier1Points;
	private int tier2Points;
	private int tier3Points;
	private int tier4Points;
	private int tier5Points;

	public Player() {
		pc = new ArrayList<>();
		pqpc = new PriorityQueue<>(new IVPercentageDescendingOrder());
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
		sortPC();
	}

	public ArrayList<OwnedPokemon> getPC() {
		return pc;
	}
	
	public void chooseOrder(String order) {
		switch (order) {
		case "Real Name":
			pqpc = new PriorityQueue<>(new NameOrder());
			break;
		case "Nickname":
			pqpc = new PriorityQueue<>(new NicknameOrder());
			break;
		case "Level":
			pqpc = new PriorityQueue<>(new LevelOrder());
			break;
		case "IV Percentage Descending":
			pqpc = new PriorityQueue<>(new IVPercentageDescendingOrder());
			break;
		case "IV Percentage Ascending":
			pqpc = new PriorityQueue<>(new IVPercentageAscendingOrder());
			break;
		}
		sortPC();
	}

	public void sortPC() {
		for (OwnedPokemon o: pc)
			pqpc.add(o);
		ArrayList<OwnedPokemon> favorites = new ArrayList<>();
		ArrayList<OwnedPokemon> nonfavorites = new ArrayList<>();
		while (!pqpc.isEmpty())
			if (pqpc.peek().isFavorite())
				favorites.add(pqpc.poll());
			else
				nonfavorites.add(pqpc.poll());
		pc = new ArrayList<>();
		for (OwnedPokemon o : favorites)
			pc.add(o);
		for (OwnedPokemon o : nonfavorites)
			pc.add(o);
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
