import java.util.*;

public class Player {
	
	private ArrayList<OwnedPokemon> pc;
	
	public Player() {
		pc = new ArrayList<>();
	}

	public void catchPokemon(OwnedPokemon ownedPokemon) {
		pc.add(ownedPokemon);
	}

	public ArrayList<OwnedPokemon> getPC() {
		return pc;
	}

}
