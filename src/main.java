import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		ArrayList<Pokemon> pokedex = new ArrayList<>();
		fillPossibilities(pokedex);
	}

	private static void fillPossibilities(ArrayList<Pokemon> pokedex) {
		pokedex.add(new Pokemon("Bulbasaur", "Grass", "Poison", 45, 49, 49, 65, 65, 45, 27, null, 0, null, null, null));
	}
	
}
