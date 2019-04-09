import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		ArrayList<Pokemon> pokedex = new ArrayList<>();
		fillPossibilities(pokedex);
		Scanner input = new Scanner(System.in);
		boolean finished = false;
		while(!finished) {
			System.out.println("Input the number corresponding to your choice:");
			System.out.println("1) Search for Pokemon");
			System.out.println("2) View Owned Pokemon");
			System.out.println("3) Breed Pokemon");
			System.out.println("4) Quit");
			switch(input.nextLine().charAt(0)){
				case '1':
					search();
					break;
				case '2':
					viewOwned();
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

	private static void breed() {
		// to be implemented
	}

	private static void viewOwned() {
		// to be implemented
	}

	private static void search() {
		// to be implemented
	}

	private static void fillPossibilities(ArrayList<Pokemon> pokedex) {
		pokedex.add(new Pokemon("Bulbasaur", "Grass", "Poison", 45, 49, 49, 65, 65, 45, 27, new String[] {"monster", "grass"}, 0.875));
	}
	
}
