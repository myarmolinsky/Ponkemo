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
				breed(p, input, pokedex);
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
		pokedex.add(new Pokemon("Bulbasaur", "Grass", "Poison", 45, 49, 49, 65, 65, 45, 27, new String[] {"monster", "grass"}, 87.5, new String[] {"Bulbasaur", "Ivysaur", "Venusaur"}));
		pokedex.add(new Pokemon("Ivysaur", "Grass", "Poison", 60, 62, 63, 80, 80, 60, 27, new String[] {"monster", "grass"}, 87.5, new String[] {"Bulbasaur", "Ivysaur", "Venusaur"}));
		pokedex.add(new Pokemon("Venusaur", "Grass", "Poison", 80, 82, 83, 100, 100, 80, 27, new String[] {"monster", "grass"}, 87.5, new String[] {"Bulbasaur", "Ivysaur", "Venusaur"}));
		pokedex.add(new Pokemon("Charmander", "Fire", null, 39, 52, 43, 60, 50, 65, 27, new String[] {"monster", "dragon"}, 87.5, new String[] {"Charmander", "Charmeleon", "Charizard"}));
		pokedex.add(new Pokemon("Charmeleon", "Fire", null, 58, 64, 58, 80, 65, 80, 27, new String[] {"monster", "dragon"}, 87.5, new String[] {"Charmander", "Charmeleon", "Charizard"}));
		pokedex.add(new Pokemon("Charizard", "Fire", "Flying", 78, 84, 78, 109, 85, 100, 27, new String[] {"monster", "dragon"}, 87.5, new String[] {"Charmander", "Charmeleon", "Charizard"}));
		pokedex.add(new Pokemon("Squirtle", "Water", null, 44, 48, 65, 50, 64, 43, 27, new String[] {"monster", "water1"}, 87.5, new String[] {"Squirtle", "Wartortle", "Blastoise"}));
		pokedex.add(new Pokemon("Wartortle", "Water", null, 59, 63, 80, 65, 80, 58, 27, new String[] {"monster", "water1"}, 87.5, new String[] {"Squirtle", "Wartortle", "Blastoise"}));
		pokedex.add(new Pokemon("Blastoise", "Water", null, 79, 83, 100, 85, 105, 78, 27, new String[] {"monster", "water1"}, 87.5, new String[] {"Squirtle", "Wartortle", "Blastoise"}));
		pokedex.add(new Pokemon("Caterpie", "Bug", null, 45, 30, 35, 20, 20, 45, 0,  new String[] {"bug"}, 50, new String[] {"Caterpie", "Metapod", "Butterfree"}));
		pokedex.add(new Pokemon("Metapod", "Bug", null, 50, 20, 55, 25, 25, 30, 17, new String[] {"bug"}, 50, new String[] {"Caterpie", "Metapod", "Butterfree"}));
		pokedex.add(new Pokemon("Butterfree", "Bug", "Flying", 60, 45, 50, 90, 80, 70, 27, new String[] {"bug"}, 50, new String[] {"Caterpie", "Metapod", "Butterfree"}));
		pokedex.add(new Pokemon("Weedle", "Bug", "Poison", 40, 35, 30, 20, 20, 50, 0, new String[] {"bug"}, 50, new String[] {"Weedle", "Kakuna", "Beedrill"}));
		pokedex.add(new Pokemon("Kakuna", "Bug", "Poison", 45, 25, 50, 25, 25, 35, 17, new String[] {"bug"}, 50, new String[] {"Weedle", "Kakuna", "Beedrill"}));
		pokedex.add(new Pokemon("Beedrill", "Bug", "Poison", 65, 90, 40, 45, 80, 75, 27, new String[] {"bug"}, 50, new String[] {"Weedle", "Kakuna", "Beedrill"}));
		pokedex.add(new Pokemon("Pidgey", "Normal", "Flying", 40, 45, 40, 35, 35, 56, 0, new String[] {"flying"}, 50, new String[] {"Pidgey", "Pidgeotto", "Pidgeot"}));
		pokedex.add(new Pokemon("Pidgeotto", "Normal", "Flying", 63, 60, 55, 50, 50, 71, 17, new String[] {"flying"}, 50, new String[] {"Pidgey", "Pidgeotto", "Pidgeot"}));
		pokedex.add(new Pokemon("Pidgeot", "Normal", "Flying", 83, 80, 75, 70, 70, 101, 27, new String[] {"flying"}, 50, new String[] {"Pidgey", "Pidgeotto", "Pidgeot"}));
		pokedex.add(new Pokemon("Rattata", "Normal", null, 30, 56, 35, 25, 35, 72, 0, new String[] {"field"}, 50, new String[] {"Rattata", "Raticate"}));
		pokedex.add(new Pokemon("Raticate", "Normal", null, 55, 81, 60, 50, 70, 97, 15, new String[] {"field"}, 50, new String[] {"Rattata", "Raticate"}));
		pokedex.add(new Pokemon("Spearow", "Normal", "Flying", 40, 60, 30, 31, 31, 70, 0, new String[] {"flying"}, 50, new String[] {"Spearow", "Fearow"}));
		pokedex.add(new Pokemon("Fearow", "Normal", "Flying", 65, 90, 65, 61, 61, 100, 19, new String[] {"flying"}, 50, new String[] {"Spearow", "Fearow"}));
		pokedex.add(new Pokemon("Ekans", "Poison", null, 35, 60, 44, 40, 54, 55, 0, new String[] {"field", "dragon"}, 50, new String[] {"Ekans", "Arbok"}));
		pokedex.add(new Pokemon("Arbok", "Poison", null, 60, 95, 69, 65, 79, 80, 19, new String[] {"field", "dragon"}, 50, new String[] {"Ekans", "Arbok"}));
		pokedex.add(new Pokemon("Pikachu", "Electric", null, 35, 55, 40, 50, 50, 90, 6, new String[] {"field", "fairy"}, 50, new String[] {"Pikachu", "Raichu"}));
		pokedex.add(new Pokemon("Raichu", "Electric", null, 60, 90, 55, 90, 80, 110, 21, new String[] {"field", "fairy"}, 50, new String[] {"Pikachu", "Raichu"}));
		pokedex.add(new Pokemon("Sandshrew", "Ground", null, 50, 75, 85, 20, 30, 40, 0, new String[] {"field"}, 50, new String[] {"Sandshrew", "Sandslash"}));
		pokedex.add(new Pokemon("Sandslash", "Ground", null, 75, 100, 110, 45, 55, 65, 19, new String[] {"field"}, 50, new String[] {"Sandshrew", "Sandslash"}));
		pokedex.add(new Pokemon("NidoranF", "Poison", null, 55, 47, 52, 40, 40, 41, 1, new String[] {"monster", "field"}, 0, new String[] {"NidoranF", "Nidorina", "Nidoqueen"}));
		pokedex.add(new Pokemon("Nidorina", "Poison", null, 70, 62, 67, 55, 55, 56, 17, new String[] {"monster", "water1"}, 0, new String[] {"NidoranF", "Nidorina", "Nidoqueen"}));
		pokedex.add(new Pokemon("Nidoqueen", "Poison", "Ground", 90, 82, 87, 75, 85, 76, 27, new String[] {"monster", "water1"}, 0, new String[] {"NidoranF", "Nidorina", "Nidoqueen"}));
		pokedex.add(new Pokemon("NidoranM", "Poison", null, 46, 57, 40, 40, 40, 50, 1, new String[] {"monster", "water1"}, 100, new String[] {"NidoranM", "Nidorino", "Nidoking"}));
		pokedex.add(new Pokemon("Nidorino", "Poison", null, 61, 72, 57, 55, 55, 65, 17, new String[] {"monster", "water1"}, 100, new String[] {"NidoranM", "Nidorino", "Nidoking"}));
		pokedex.add(new Pokemon("Nidoking", "Poison", "Ground", 81, 102, 77, 85, 75, 85, 27, new String[] {"monster", "water1"}, 100, new String[] {"NidoranM", "Nidorino", "Nidoking"}));
		pokedex.add(new Pokemon("Clefairy", "Fairy", null, 70, 45, 48, 60, 65, 35, 11, new String[] {"fairy"}, 25, new String[] {"Clefairy", "Clefable"}));
		pokedex.add(new Pokemon("Clefable", "Fairy", null, 95, 70, 73, 95, 90, 60, 30, new String[] {"fairy"}, 25, new String[] {"Clefairy", "Clefable"}));
		pokedex.add(new Pokemon("Vulpix", "Fire", null, 39, 41, 40, 50, 65, 65, 6, new String[] {"field"}, 25, new String[] {"Vulpix", "Ninetales"}));
		pokedex.add(new Pokemon("Ninetales", "Fire", null, 73, 76, 75, 81, 100, 100, 21, new String[] {"field"}, 25, new String[] {"Vulpix", "Ninetales"}));
		pokedex.add(new Pokemon("Jigglypuff", "Normal", "Fairy", 115, 45, 20, 45, 25, 20, 8, new String[] {"fairy"}, 25, new String[] {"Jigglypuff", "Wigglytuff"}));
		pokedex.add(new Pokemon("Wigglytuff", "Normal", "Fairy", 140, 70, 45, 85, 50, 45, 26, new String[] {"fairy"}, 25, new String[] {"Jigglypuff", "Wigglytuff"}));
		pokedex.add(new Pokemon("Zubat", "Poison", "Flying", 40, 45, 35, 30, 40, 55, 0, new String[] {"flying"}, 50, new String[] {"Zubat", "Golbat"}));
		pokedex.add(new Pokemon("Golbat", "Poison", "Flying", 75, 80, 70, 65, 75, 90, 19, new String[] {"flying"}, 50, new String[] {"Zubat", "Golbat"}));
		pokedex.add(new Pokemon("Oddish", "Grass", "Poison", 45, 50, 55, 75, 65, 30, 0, new String[] {"grass"}, 50, new String[] {"Oddish", "Gloom", "Vileplume"}));
		pokedex.add(new Pokemon("Gloom", "Grass", "Poison", 60, 65, 70, 85, 75, 40, 17, new String[] {"grass"}, 50, new String[] {"Oddish", "Gloom", "Vileplume"}));
		pokedex.add(new Pokemon("Vileplume", "Grass", "Poison", 75, 80, 85, 110, 90, 50, 27, new String[] {"grass"}, 50, new String[] {"Oddish", "Gloom", "Vileplume"}));
		pokedex.add(new Pokemon("Paras", "Bug", "Grass", 35, 70, 55, 45, 55, 25, 6, new String[] {"bug", "grass"}, 50, new String[] {"Paras", "Parasect"}));
		pokedex.add(new Pokemon("Parasect", "Bug", "Grass", 60, 95, 80, 60, 80, 30, 21, new String[] {"bug", "grass"}, 50, new String[] {"Paras", "Parasect"}));
		pokedex.add(new Pokemon("Venonat", "Bug", "Poison", 60, 55, 50, 40, 55, 45, 6, new String[] {"bug"}, 50, new String[] {"Venonat", "Venomoth"}));
		pokedex.add(new Pokemon("Venomoth", "Bug", "Poison", 70, 65, 60, 90, 75, 90, 21, new String[] {"bug"}, 50, new String[] {"Venonat", "Venomoth"}));
		pokedex.add(new Pokemon("Diglett", "Ground", null, 10, 55, 25, 35, 45, 95, 0, new String[] {"field"}, 50, new String[] {"Diglett", "Dugtrio"}));
		pokedex.add(new Pokemon("Dugtrio", "Ground", null, 35, 100, 50, 50, 70, 120, 26, new String[] {"field"}, 50, new String[] {"Diglett", "Dugtrio"}));
		pokedex.add(new Pokemon("Meowth", "Normal", null, 40, 45, 35, 40, 40, 90, 0, new String[] {"field"}, 50, new String[] {"Meowth", "Persian"}));
		pokedex.add(new Pokemon("Persian", "Normal", null, 65, 70, 60, 65, 65, 115, 19, new String[] {"field"}, 50, new String[] {"Meowth", "Persian"}));
		pokedex.add(new Pokemon("Psyduck", "Water", null, 50, 52, 48, 65, 50, 55, 6, new String[] {"field", "water1"}, 50, new String[] {"Psyduck", "Golduck"}));
		pokedex.add(new Pokemon("Golduck", "Water", null, 80, 82, 78, 95, 80, 85, 21, new String[] {"field", "water1"}, 50, new String[] {"Psyduck", "Golduck"}));
		pokedex.add(new Pokemon("Mankey", "Fighting", null, 40, 80, 35, 35, 45, 70, 6, new String[] {"field"}, 50, new String[] {"Mankey", "Primeape"}));
		pokedex.add(new Pokemon("Primeape", "Fighting", null, 65, 100, 60, 60, 70, 95, 21, new String[] {"field"}, 50, new String[] {"Mankey", "Primeape"}));
		pokedex.add(new Pokemon("Growlithe", "Fire", null, 55, 70, 45, 70, 50, 60, 6, new String[] {"field"}, 75, new String[] {"Growlithe", "Arcanine"}));
		pokedex.add(new Pokemon("Arcanine", "Fire", null, 90, 110, 80, 100, 80, 95, 21, new String[] {"field"}, 75, new String[] {"Growlithe", "Arcanine"}));
		pokedex.add(new Pokemon("Poliwag", "Water", null, 40, 50, 40, 40, 40, 90, 0, new String[] {"water1"}, 50, new String[] {"Poliwag", "Poliwhirl", "Poliwrath"}));
		pokedex.add(new Pokemon("Poliwhirl", "Water", null, 65, 65, 65, 50, 50, 90, 17, new String[] {"water1"}, 50, new String[] {"Poliwag", "Poliwhirl", "Poliwrath"}));
		pokedex.add(new Pokemon("Poliwrath", "Water", "Fighting", 90, 95, 95, 70, 90, 70, 27, new String[] {"water1"}, 50, new String[] {"Poliwag", "Poliwhirl", "Poliwrath"}));
		pokedex.add(new Pokemon("Abra", "Psychic", null, 25, 20, 15, 105, 55, 90, 5, new String[] {"human-like"}, 75, new String[] {"Abra", "Kadabra", "Alakazam"}));
		pokedex.add(new Pokemon("Kadabra", "Psychic", null, 40, 35, 30, 120, 70, 105, 18, new String[] {"human-like"}, 75, new String[] {"Abra", "Kadabra", "Alakazam"}));
		pokedex.add(new Pokemon("Alakazam", "Psychic", null, 55, 50, 45, 135, 95, 120, 26, new String[] {"human-like"}, 75, new String[] {"Abra", "Kadabra", "Alakazam"}));
		pokedex.add(new Pokemon("Machop", "Fighting", null, 70, 80, 50, 35, 35, 35, 7, new String[] {"human-like"}, 75, new String[] {"Machop", "Machoke", "Machamp"}));
		pokedex.add(new Pokemon("Machoke", "Fighting", null, 80, 100, 70, 50, 60, 45, 19, new String[] {"human-like"}, 75, new String[] {"Machop", "Machoke", "Machamp"}));
		pokedex.add(new Pokemon("Machamp", "Fighting", null, 90, 130, 80, 65, 85, 55, 27, new String[] {"human-like"}, 75, new String[] {"Machop", "Machoke", "Machamp"}));
		pokedex.add(new Pokemon("Bellsprout", "Grass", "Poison", 50, 75, 35, 70, 30, 40, 0, new String[] {"grass"}, 50, new String[] {"Bellsprout", "Weepinbell", "Victreebel"}));
		pokedex.add(new Pokemon("Weepinbell", "Grass", "Poison", 65, 90, 50, 85, 45, 55, 17, new String[] {"grass"}, 50, new String[] {"Bellsprout", "Weepinbell", "Victreebel"}));
		pokedex.add(new Pokemon("Victreebel", "Grass", "Poison", 80, 105, 65, 100, 70, 70, 27, new String[] {"grass"}, 50, new String[] {"Bellsprout", "Weepinbell", "Victreebel"}));
		pokedex.add(new Pokemon("Tentacool", "Water", "Poison", 40, 40, 35, 50, 100, 70, 6, new String[] {"water3"}, 50, new String[] {"Tentacool", "Tentacruel"}));
		pokedex.add(new Pokemon("Tentacruel", "Water", "Poison", 80, 70, 65, 80, 120, 100, 24, new String[] {"water3"}, 50, new String[] {"Tentacool", "Tentacruel"}));
		pokedex.add(new Pokemon("Geodude", "Rock", "Ground", 40, 80, 100, 30, 30, 20, 0, new String[] {"mineral"}, 50, new String[] {"Geodude", "Graveler", "Golem"}));
		pokedex.add(new Pokemon("Graveler", "Rock", "Ground", 55, 95, 115, 45, 45, 35, 17, new String[] {"mineral"}, 50, new String[] {"Geodude", "Graveler", "Golem"}));
		pokedex.add(new Pokemon("Golem", "Rock", "Ground", 80, 120, 130, 55, 65, 45, 27, new String[] {"mineral"}, 50, new String[] {"Geodude", "Graveler", "Golem"}));
		pokedex.add(new Pokemon("Ponyta", "Fire", null, 50, 85, 55, 65, 65, 90, 6, new String[] {"field"}, 50, new String[] {"Ponyta", "Rapidash"}));
		pokedex.add(new Pokemon("Rapidash", "Fire", null, 65, 100, 70, 80, 80, 105, 24, new String[] {"field"}, 50, new String[] {"Ponyta", "Rapidash"}));
		pokedex.add(new Pokemon("Slowpoke", "Water", "Psychic", 90, 65, 65, 40, 40, 15, 6, new String[] {"monster", "water1"}, 50, new String[] {"Slowpoke", "Slowbro"}));
		pokedex.add(new Pokemon("Slowbro", "Water", "Psychic", 95, 75, 110, 100, 80, 30, 21, new String[] {"monster", "water1"}, 50, new String[] {"Slowpoke", "Slowbro"}));
		pokedex.add(new Pokemon("Magnemite", "Electric", "Steel", 25, 35, 70, 95, 55, 45, 6, new String[] {"mineral"}, -1, new String[] {"Magnemite", "Magneton"}));
		pokedex.add(new Pokemon("Magneton", "Electric", "Steel", 50, 60, 95, 120, 70, 70, 24, new String[] {"mineral"}, -1, new String[] {"Magnemite", "Magneton"}));
		pokedex.add(new Pokemon("Farfetch'd", "Normal", "Flying", 52, 90, 55, 58, 62, 60, 27, new String[] {"field", "flying"}, 50, new String[] {"Farfetch'd"}));
		pokedex.add(new Pokemon("Doduo", "Normal", "Flying", 35, 85, 45, 35, 35, 75, 6, new String[] {"flying"}, 50, new String[] {"Doduo", "Dodrio"}));
		pokedex.add(new Pokemon("Dodrio", "Normal", "Flying", 60, 110, 70, 60, 60, 110, 27, new String[] {"flying"}, 50, new String[] {"Doduo", "Dodrio"}));
		pokedex.add(new Pokemon("Seel", "Water", null, 65, 45, 55, 45, 70, 45, 6, new String[] {"field", "water1"}, 50, new String[] {"Seel", "Dewgong"}));
		pokedex.add(new Pokemon("Dewgong", "Water", "Ice", 90, 70, 80, 70, 95, 70, 21, new String[] {"field", "water1"}, 50, new String[] {"Seel", "Dewgong"}));
		pokedex.add(new Pokemon("Grimer", "Poison", null, 80, 80, 50, 40, 50, 25, 6, new String[] {"amorphous"}, 50, new String[] {"Grimer", "Muk"}));
		pokedex.add(new Pokemon("Muk", "Poison", null, 105, 106, 75, 65, 100, 50, 21, new String[] {"amorphous"}, 50, new String[] {"Grimer", "Muk"}));
		pokedex.add(new Pokemon("Shellder", "Water", null, 30, 65, 100, 45, 25, 40, 6, new String[] {"water3"}, 50, new String[] {"Shellder", "Cloyster"}));
		pokedex.add(new Pokemon("Cloyster", "Water", "Ice", 50, 95, 180, 85, 45, 70, 24, new String[] {"water3"}, 50, new String[] {"Shellder", "Cloyster"}));
		pokedex.add(new Pokemon("Gastly", "Ghost", "Poison", 30, 35, 30, 100, 35, 80, 6, new String[] {"amorphous"}, 50, new String[] {"Gastly", "Haunter", "Gengar"}));
		pokedex.add(new Pokemon("Haunter", "Ghost", "Poison", 45, 50, 45, 115, 55, 95, 19, new String[] {"amorphous"}, 50, new String[] {"Gastly", "Haunter", "Gengar"}));
		pokedex.add(new Pokemon("Gengar", "Ghost", "Poison", 60, 65, 60, 130, 75, 110, 27, new String[] {"amorphous"}, 50, new String[] {"Gastly", "Haunter", "Gengar"}));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null));
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

	private static void breed(Player p, Scanner sc, ArrayList<Pokemon> pokedex) {
		printOwnedPokemon(p);
		breedOne(p, sc, pokedex);
	}

	private static void breedOne(Player p, Scanner sc, ArrayList<Pokemon> pokedex) {
		System.out.println("Enter the number corresponding to the first pokemon you would like to breed, or enter \"0\" to go back to the previos menu.");
		System.out.println();
		String temp = sc.next();
		if (!isNumeric(temp)) {
			System.out.println();
			System.out.println("Input does not match an avalable choice.");
			System.out.println();
			breed(p, sc, pokedex);
		} else {
			int num = Integer.parseInt(temp);
			if (num < 0 || num > p.getPC().size()) {
				System.out.println();
				System.out.println("Input does not match an available choice.");
				System.out.println();
				breed(p, sc, pokedex);
			} else {
				if (num != 0) {
					breedTwo(p, sc, num, pokedex);
				} else {
					System.out.println();
				}
			}
		}
	}

	private static void breedTwo(Player p, Scanner sc, int num, ArrayList<Pokemon> pokedex) {
		System.out.println();
		System.out.println("Enter the number corresponding to the second pokemon you would like to breed, or enter \"0\" to go back to the previos menu.");
		System.out.println();
		String temp = sc.next();
		if (!isNumeric(temp)) {
			System.out.println();
			System.out.println("Input does not match an avalable choice.");
			System.out.println();
			breed(p, sc, pokedex);
		} else {
			int numTwo = Integer.parseInt(temp);
			if (numTwo < 0 || numTwo > p.getPC().size() || num == numTwo) {
				System.out.println();
				System.out.println("Input does not match an available choice.");
				System.out.println();
				breed(p, sc, pokedex);
			} else {
				if (numTwo != 0) {
					if (breedable(p, num, numTwo)) {
						OwnedPokemon oldOne = new OwnedPokemon(p.getPC().get(num - 1));
						OwnedPokemon oldTwo = new OwnedPokemon(p.getPC().get(numTwo - 1));
						Pokemon pokemon;
						if (oldOne.getGender().equals("genderless")) {
							int choose = new Random().nextInt(2);
							if (choose == 0) {
								pokemon = getBabyPokemon(pokedex, oldOne);
							} else
								pokemon = getBabyPokemon(pokedex, oldTwo);
						} else
							if (oldOne.getGender().equals("female")) {
								if (oldOne.getName().equals("NidoranF") || oldOne.getName().equals("Nidorina") || oldOne.getName().equals("Nidoqueen")) {
									int rand = new Random().nextInt(2);
									if (rand == 0)
										pokemon = pokedex.get(28);
									else
										pokemon = pokedex.get(31);
								} else
									pokemon = getBabyPokemon(pokedex, oldOne);
							} else {
								if (oldTwo.getName().equals("NidoranF") || oldTwo.getName().equals("Nidorina") || oldTwo.getName().equals("Nidoqueen")) {
									int rand = new Random().nextInt(2);
									if (rand == 0)
										pokemon = pokedex.get(28);
									else
										pokemon = pokedex.get(31);
								} else
									pokemon = getBabyPokemon(pokedex, oldTwo);
							}
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

	private static Pokemon getBabyPokemon(ArrayList<Pokemon> pokedex, OwnedPokemon poke) {
		for (int i = 0; i < pokedex.size(); i++)
			if (poke.getPokemon().getEvolutionTree()[0].equals(pokedex.get(i).getName()))
				return pokedex.get(i);
		return poke.getPokemon();
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
