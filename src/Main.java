import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ArrayList<Pokemon> pokedex = new ArrayList<>();
		fillPossibilities(pokedex);
		Player p = new Player();
		int[] spawnRateCounter = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		boolean finished = false;
		while(!finished) {
			System.out.println("Input the number corresponding to your choice:");
			System.out.println("1) Search for Pokemon");
			System.out.println("2) View Owned Pokemon");
			System.out.println("3) Breed Pokemon");
			System.out.println("4) Quit");
			System.out.println();
			switch(input.next().charAt(0)){
			case '1':
				System.out.println();
				search(pokedex, p, spawnRateCounter);
				break;
			case '2':
				System.out.println();
				viewOwnedPokemon(p, input);
				break;
			case '3':
				System.out.println();
				breed(p, input);
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
		pokedex.add(new Pokemon("Bulbasaur", "Grass", "Poison", 45, 49, 49, 65, 65, 45, 27, new String[] {"monster", "grass"}, 0.875));
		pokedex.add(new Pokemon("Ivysaur", "Grass", "Poison", 60, 62, 63, 80, 80, 60, 27, new String[] {"monster", "grass"}, 0.875));
		pokedex.add(new Pokemon("Venusaur", "Grass", "Poison", 80, 82, 83, 100, 100, 80, 27, new String[] {"monster", "grass"}, 0.875));
		pokedex.add(new Pokemon("Charmander", "Fire", null, 39, 52, 43, 60, 50, 65, 27, new String[] {"monster", "dragon"}, 0.875));
		pokedex.add(new Pokemon("Charmeleon", "Fire", null, 58, 64, 58, 80, 65, 80, 27, new String[] {"monster", "dragon"}, 0.875));
		pokedex.add(new Pokemon("Charizard", "Fire", "Flying", 78, 84, 78, 109, 85, 100, 27, new String[] {"monster", "dragon"}, 0.875));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0));
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
		printOwnedPokemon(p);
		viewAnotherOwnedPokemon(p, sc);
	}

	private static void printOwnedPokemon(Player p) {
		System.out.println("Your Pokemon:");
		for (int i = 0; i < p.getPC().size(); i++) {
			System.out.println(i + 1 + ") " + p.getPC().get(i).getNickname());
		}
		System.out.println();
	}

	private static void viewAnotherOwnedPokemon(Player p, Scanner sc) {
		System.out.println("Would you like to view any pokemon in particular?");
		System.out.println("1) Enter the number correlating to a pokemon in your PC.");
		System.out.println("2) Enter \"0\" to go back to the previous menu.");
		System.out.println();
		String temp = sc.next();
		if (!isNumeric(temp)) {
			System.out.println();
			System.out.println("Input does not match an avalable choice.");
			System.out.println();
			viewOwnedPokemon(p, sc);
		} else {
			int num = Integer.parseInt(temp);
			if (num < 0 || num >= p.getPC().size() + 1) {
				System.out.println();
				System.out.println("Input does not match an available choice.");
				System.out.println();
				viewOwnedPokemon(p, sc);
			} else {
				if (num != 0) {
					System.out.println();
					System.out.println(p.getPC().get(num - 1));
					System.out.println();
					viewAnotherOwnedPokemon(p, sc);
				} else {
					System.out.println();
				}
			}
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

	private static void breed(Player p, Scanner sc) {
		printOwnedPokemon(p);
		breedOne(p, sc);
	}

	private static void breedOne(Player p, Scanner sc) {
		System.out.println("Enter the number corresponding to the first pokemon you would like to breed, or enter \"0\" to go back to the previos menu.");
		System.out.println();
		String temp = sc.next();
		if (!isNumeric(temp)) {
			System.out.println();
			System.out.println("Input does not match an avalable choice.");
			System.out.println();
			breed(p, sc);
		} else {
			int num = Integer.parseInt(temp);
			if (num < 0 || num > p.getPC().size()) {
				System.out.println();
				System.out.println("Input does not match an available choice.");
				System.out.println();
				breed(p, sc);
			} else {
				if (num != 0) {
					breedTwo(p, sc, num);
				} else {
					System.out.println();
				}
			}
		}
	}

	private static void breedTwo(Player p, Scanner sc, int num) {
		System.out.println();
		System.out.println("Enter the number corresponding to the second pokemon you would like to breed, or enter \"0\" to go back to the previos menu.");
		System.out.println();
		String temp = sc.next();
		if (!isNumeric(temp)) {
			System.out.println();
			System.out.println("Input does not match an avalable choice.");
			System.out.println();
			breed(p, sc);
		} else {
			int numTwo = Integer.parseInt(temp);
			if (numTwo < 0 || numTwo > p.getPC().size() || num == numTwo) {
				System.out.println();
				System.out.println("Input does not match an available choice.");
				System.out.println();
				breed(p, sc);
			} else {
				if (numTwo != 0) {
					if (breedable(p, num, numTwo)) {
						OwnedPokemon oldOne = new OwnedPokemon(p.getPC().get(num - 1));
						OwnedPokemon oldTwo = new OwnedPokemon(p.getPC().get(numTwo - 1));
						Pokemon pokemon;
						if (oldOne.getGender().equals("genderless")) {
							int choose = new Random().nextInt(2);
							if (choose == 0)
								pokemon = oldOne.getPokemon();
							else
								pokemon = oldTwo.getPokemon();
						} else 
							if (oldOne.getGender().equals("female"))
								pokemon = oldOne.getPokemon();
							else
								pokemon = oldTwo.getPokemon();
						int healthIV;
						int attackIV;
						int defenseIV;
						int specialAttackIV;
						int specialDefenseIV;
						int speedIV;
						if (oldOne.getHealthIV() > oldTwo.getHealthIV())
							healthIV = oldOne.getHealthIV();
						else
							healthIV = oldTwo.getHealthIV();
						if (oldOne.getAttackIV() > oldTwo.getAttackIV())
							attackIV = oldOne.getAttackIV();
						else
							attackIV = oldTwo.getAttackIV();
						if (oldOne.getDefenseIV() > oldTwo.getDefenseIV())
							defenseIV = oldOne.getDefenseIV();
						else
							defenseIV = oldTwo.getDefenseIV();
						if (oldOne.getSpecialAttackIV() > oldTwo.getSpecialAttackIV())
							specialAttackIV = oldOne.getSpecialAttackIV();
						else
							specialAttackIV = oldTwo.getSpecialAttackIV();
						if (oldOne.getSpecialDefenseIV() > oldTwo.getSpecialDefenseIV())
							specialDefenseIV = oldOne.getSpecialDefenseIV();
						else
							specialDefenseIV = oldTwo.getSpecialDefenseIV();
						if (oldOne.getSpeedIV() > oldTwo.getSpeedIV())
							speedIV = oldOne.getSpeedIV();
						else
							speedIV = oldTwo.getSpeedIV();
						if (num < numTwo) {
							p.getPC().remove(numTwo - 1);
							p.getPC().remove(num - 1);
						} else {
							p.getPC().remove(num - 1);
							p.getPC().remove(numTwo - 1);
						}
						p.catchPokemon(new OwnedPokemon(pokemon, healthIV, attackIV, defenseIV, specialAttackIV, specialDefenseIV, speedIV));
						System.out.println("Congratulations on your newly bred Pokemon!");
						System.out.println();
					} else {
						System.out.println();
						System.out.println("These two Pokemon are not breedable.");
						System.out.println();
					}
				} else
					System.out.println();
			}
		}
	}

	private static boolean breedable(Player p, int num, int numTwo) {
		boolean temp = false;
		for (int i = 0; i < p.getPC().get(num - 1).getEggGroup().length; i++) {
			for (int j = 0; j < p.getPC().get(numTwo - 1).getEggGroup().length; j++) {
				if (p.getPC().get(num - 1).getEggGroup()[i].equals(p.getPC().get(numTwo - 1).getEggGroup()[j]))
					temp = true;
			}
		}
		if (temp) {
			if ((p.getPC().get(num - 1).getGender().equals("male") && p.getPC().get(numTwo - 1).getGender().equals("female"))
					|| (p.getPC().get(num - 1).getGender().equals("female") && p.getPC().get(numTwo - 1).getGender().equals("male"))
					|| (p.getPC().get(num - 1).getGender().equals("genderless") && p.getPC().get(numTwo - 1).getGender().equals("genderless")))
				return true;
		}
		return false;
	}

}
