import java.util.*;

public class Player {
	
	private ArrayList<Pokemon> pokedex;
	private ArrayList<OwnedPokemon> pc;
	
	public Player() {
		pokedex = new ArrayList<>();
		pc = new ArrayList<>();
	}

	public void catchPokemon(OwnedPokemon ownedPokemon) {
		pc.add(ownedPokemon);
	}

}
