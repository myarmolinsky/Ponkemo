import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ArrayList<Pokemon> pokedex = new ArrayList<>();
		fillPossibilities(pokedex);
		Player p = new Player();
		int[] spawnRateCounter = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		boolean finished = false;
		while(!finished) {
			System.out.println("Input the number corresponding to your choice:");
			System.out.println("1) Search for Pokemon");
			System.out.println("2) View Owned Pokemon");
			System.out.println("3) Breed Pokemon");
			System.out.println("4) Quit");
			System.out.println();
			switch(input.nextLine().charAt(0)){
			case '1':
				System.out.println();
				search(pokedex, p, spawnRateCounter);
				break;
			case '2':
				System.out.println();
				viewOwnedPokemon(p);
				break;
			case '3':
				System.out.println();
				breed();
				break;
			case '4':
				finished = true;
				System.out.println();
				System.out.println("Quitting ...");
				break;
			default:
				System.out.println();
				System.out.println("Input does not match an available choice.");
				System.out.println();
			}
		}
		input.close();
	}	

	private static void fillPossibilities(ArrayList<Pokemon> pokedex) {
		pokedex.add(new Pokemon("Bulbasaur", "Grass", "Poison", 45, 49, 49, 65, 65, 45, 1, new String[] {"monster", "grass"}, 0.875));
	}

	private static void search(ArrayList<Pokemon> pokedex, Player p, int[] spawnRateCounter) {
		int rand = new Random().nextInt(5);
		if (rand == 0) {
			System.out.println("You found nothing. :(");
			System.out.println();
		}
		else {
			rand = new Random().nextInt(pokedex.size());
			if(spawnRateCounter[pokedex.get(rand).getSpawnRate()] != pokedex.get(rand).getSpawnRate()) {
				// check if spawn rate of the pokemon has been reached
				// (the rare the pokemon, the higher the the number required to be reached)
				// if the spawn rate has not been reached, increment by 1 and re-search
				spawnRateCounter[pokedex.get(rand).getSpawnRate()]++;
				search(pokedex, p, spawnRateCounter);
			} else {
				// if spawn rate HAS been reached, give that pokemon to the player
				spawnRateCounter[pokedex.get(rand).getSpawnRate()] = 0;
				p.catchPokemon(new OwnedPokemon(pokedex.get(rand)));
				System.out.println("You caught a " + pokedex.get(rand).getName() + "!");
				System.out.println();
			}
		}
	}

	private static void viewOwnedPokemon(Player p, Scanner sc) {
		System.out.println("Your Pokemon:");
		for (int i = 0; i < p.getPC().size(); i++) {
			System.out.println(i + 1 + ") " + p.getPC().get(i).getNickname());
		}
		System.out.println();
		System.out.println("Would you like to view any pokemon in particular?");
		System.out.println("1) Enter the number correlating to a pokemon in your PC.");
		System.out.println("2) Enter \"0\" to go back to the previous menu.");
		System.out.println();
		String temp = sc.next();
		while(!isNumeric(temp)) {
			System.out.println("Input does not match an avalable choice");
			System.out.println();
			System.out.println("Would you like to view any pokemon in particular?");
			System.out.println("1) Enter the number correlating to a pokemon in your PC.");
			System.out.println("2) Enter \"0\" to go back to the previous menu.");
			System.out.println();
		}
		while(Integer.parseInt(temp) != 0) {
			
		}
	}

	private static boolean isNumeric(String temp) {
		try {
			Integer.parseInt(temp);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	private static void breed() {
		// to be implemented
	}

}
