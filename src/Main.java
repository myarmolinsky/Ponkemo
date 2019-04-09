import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ArrayList<Pokemon> pokedex = new ArrayList<>();
		fillPossibilities(pokedex);
		Player p = new Player();
		int[] spawnTracker = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		boolean finished = false;
		while(!finished) {
			System.out.println("Input the number corresponding to your choice:");
			System.out.println("1) Search for Pokemon");
			System.out.println("2) View Owned Pokemon");
			System.out.println("3) Breed Pokemon");
			System.out.println("4) Quit");
			switch(input.nextLine().charAt(0)){
				case '1':
					search(pokedex, p, null);
					break;
				case '2':
					viewOwnedPokemon();
					break;
				case '3':
					breed();
					break;
				case '4':
					finished = true;
					break;
				default:
					System.out.println("Input does not match an available choice.");
			}
		}
		input.close();
	}

	private static void search(ArrayList<Pokemon> pokedex, Player p, int[] spawnTracker) {
		int rand = new Random().nextInt(5);
		if (rand == 0)
			System.out.println("You found nothing. :(");
		else {
			rand = new Random().nextInt(pokedex.size()-1);
			if(spawnTracker[pokedex.get(rand).getSpawnRate()] != pokedex.get(rand).getSpawnRate()) {
				// check if spawn rate of the pokemon has been reached
				// (the rare the pokemon, the higher the the number required to be reached)
				// if the spawn rate has not been reached, increment by 1 and re-search
				spawnTracker[pokedex.get(rand).getSpawnRate()]++;
				search(pokedex, p, spawnTracker);
			} else {
				// if spawn rate HAS been reached, give that pokemon to the player
				spawnTracker[pokedex.get(rand).getSpawnRate()] = 0;
				p.catchPokemon(new OwnedPokemon(pokedex.get(rand)));
			}
		}
	}

	private static void breed() {
		// to be implemented
	}

	private static void viewOwnedPokemon() {
		// to be implemented
	}

	private static void fillPossibilities(ArrayList<Pokemon> pokedex) {
		pokedex.add(new Pokemon("Bulbasaur", "Grass", "Poison", 45, 49, 49, 65, 65, 45, 27, new String[] {"monster", "grass"}, 0.875));
	}
	
}
