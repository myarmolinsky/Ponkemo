import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ArrayList<Pokemon> pokedex = new ArrayList<>();
		fillPossibilities(pokedex);
		Player p = new Player();
		int[] spawnRateCounter = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		boolean finished = false;
		//		p.catchPokemon(new OwnedPokemon(pokedex.get(28)));
		//		p.catchPokemon(new OwnedPokemon(pokedex.get(31)));
		p.addTier1(600);
		while(!finished) {
			System.out.println("Input the number corresponding to your choice:");
			System.out.println("1) Search for Pokemon");
			System.out.println("2) View Owned Pokemon");
			System.out.println("3) Breed Pokemon");
			System.out.println("4) Train Pokemon");
			System.out.println("5) Recycle Pokemon");
			System.out.println("6) View Player Data");
			System.out.println("7) Quit");
			System.out.println();
			switch(input.nextLine()){
			case "1":
				System.out.println();
				search(pokedex, p, spawnRateCounter);
				break;
			case "2":
				System.out.println();
				viewOwnedPokemon(p, input);
				break;
			case "3":
				System.out.println();
				breed(p, input, pokedex);
				break;
			case "4":
				System.out.println();
				training(p, input);
				break;
			case "5":
				System.out.println();
				recycle(p, input);
				break;
			case "6":
				System.out.println();
				printPlayerData(p);
				break;
			case "7":
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
		pokedex.add(new Pokemon("Onix", "Rock", "Ground", 35, 45, 160, 30, 45, 70, 27, new String[] {"mineral"}, 50, new String[] {"Onix"}));
		pokedex.add(new Pokemon("Drowzee", "Psychic", null, 60, 48, 45, 43, 90, 42, 6, new String[] {"human-like"}, 50, new String[] {"Drowzee", "Hypno"}));
		pokedex.add(new Pokemon("Hypno", "Psychic", null, 85, 73, 70, 73, 115, 67, 21, new String[] {"human-like"}, 50, new String[] {"Drowzee", "Hypno"}));
		pokedex.add(new Pokemon("Krabby", "Water", null, 30, 105, 90, 25, 25, 50, 2, new String[] {"water3"}, 50, new String[] {"Krabby", "Kingler"}));
		pokedex.add(new Pokemon("Kingler", "Water", null, 55, 130, 115, 50, 50, 75, 24, new String[] {"water3"}, 50, new String[] {"Krabby", "Kingler"}));
		pokedex.add(new Pokemon("Voltorb", "Electric", null, 40, 30, 50, 55, 55, 100, 6, new String[] {"mineral"}, -1, new String[] {"Voltorb", "Electrode"}));
		pokedex.add(new Pokemon("Electrode", "Electric", null, 60, 50, 70, 80, 80, 150, 24, new String[] {"mineral"}, -1, new String[] {"Voltorb", "Electrode"}));
		pokedex.add(new Pokemon("Exeggcute", "Grass", "Psychic", 60, 40, 80, 60, 45, 40, 19, new String[] {"grass"}, 50, new String[] {"Exeggcute", "Exeggutor"}));
		pokedex.add(new Pokemon("Exeggutor", "Grass", "Psychic", 95, 95, 85, 125, 75, 55, 27, new String[] {"grass"}, 50, new String[] {"Exeggcute", "Exeggutor"}));
		pokedex.add(new Pokemon("Cubone", "Ground", null, 50, 50, 95, 40, 50, 35, 6, new String[] {"monster"}, 50, new String[] {"Cubone", "Marowak"}));
		pokedex.add(new Pokemon("Marowak", "Ground", null, 60, 80, 110, 50, 80, 45, 21, new String[] {"monster"}, 50, new String[] {"Cubone", "Marowak"}));
		pokedex.add(new Pokemon("Hitmonlee", "Fighting", null, 50, 120, 53, 35, 110, 87, 27, new String[] {"human-like"}, 100, new String[] {"Hitmonlee"})); // figure out fix for evolution tree when tyrogue is added
		pokedex.add(new Pokemon("Hitmonchan", "Fighting", null, 50, 105, 79, 35, 110, 76, 27, new String[] {"human-like"}, 100, new String[] {"Hitmonchan"})); // figure out fix for evolution tree when tyrogue is added
		pokedex.add(new Pokemon("Lickitung", "Normal", null, 90, 55, 75, 60, 75, 30, 27, new String[] {"monster"}, 50, new String[] {"Lickitung"}));
		pokedex.add(new Pokemon("Koffing", "Poison", null, 40, 65, 95, 60, 45, 35, 6, new String[] {"amorphous"}, 50, new String[] {"Koffing", "Weezing"}));
		pokedex.add(new Pokemon("Weezing", "Poison", null, 65, 90, 120, 85, 70, 60, 24, new String[] {"amorphous"}, 50, new String[] {"Koffing", "Weezing"}));
		pokedex.add(new Pokemon("Rhyhorn", "Ground", "Rock", 80, 85, 95, 30, 30, 25, 17, new String[] {"field", "monster"}, 50, new String[] {"Rhyhorn", "Rhydon"}));
		pokedex.add(new Pokemon("Rhydon", "Ground", "Rock", 105, 130, 120, 45, 45, 40, 24, new String[] {"field", "monster"}, 50, new String[] {"Rhyhorn", "Rhydon"}));
		pokedex.add(new Pokemon("Chansey", "Normal", null, 250, 5, 5, 35, 105, 50, 29, new String[] {"fairy"}, 0, new String[] {"Chansey"}));
		pokedex.add(new Pokemon("Tangela", "Grass", null, 65, 55, 115, 100, 40, 60, 27, new String[] {"grass"}, 50, new String[] {"Tangela"}));
		pokedex.add(new Pokemon("Kangaskhan", "Normal", null, 105, 95, 80, 40, 80, 90, 27, new String[] {"monster"}, 0, new String[] {"Kangaskhan"}));
		pokedex.add(new Pokemon("Horsea", "Water", null, 30, 40, 70, 70, 25, 60, 2, new String[] {"water1", "dragon"}, 50, new String[] {"Horsea", "Seadra"}));
		pokedex.add(new Pokemon("Seadra", "Water", null, 55, 65, 95, 95, 45, 85, 21, new String[] {"water1", "dragon"}, 50, new String[] {"Horsea", "Seadra"}));
		pokedex.add(new Pokemon("Goldeen", "Water", null, 45, 67, 60, 35, 50, 63, 2, new String[] {"water2"}, 50, new String[] {"Goldeen", "Seaking"}));
		pokedex.add(new Pokemon("Seaking", "Water", null, 80, 92, 65, 65, 80, 68, 24, new String[] {"water2"}, 50, new String[] {"Goldeen", "Seaking"}));
		pokedex.add(new Pokemon("Staryu", "Water", null, 30, 45, 55, 70, 55, 85, 2, new String[] {"water3"}, -1, new String[] {"Staryu", "Starmie"}));
		pokedex.add(new Pokemon("Starmie", "Water", "Psychic", 60, 75, 85, 100, 85, 115, 24, new String[] {"water3"}, -1, new String[] {"Staryu", "Starmie"}));
		pokedex.add(new Pokemon("Mr. Mime", "Psychic", "Fairy", 40, 45, 65, 100, 120, 95, 27, new String[] {"human-like"}, 50, new String[] {"Mr. Mime"}));
		pokedex.add(new Pokemon("Scyther", "Bug", "Flying", 70, 110, 80, 55, 80, 105, 27, new String[] {"bug"}, 50, new String[] {"Scyther"}));
		pokedex.add(new Pokemon("Jynx", "Ice", "Psychic", 65, 50, 35, 115, 95, 95, 27, new String[] {"human-like"}, 0, new String[] {"Jynx"}));
		pokedex.add(new Pokemon("Electabuzz", "Electric", null, 65, 83, 57, 95, 85, 105, 27, new String[] {"human-like"}, 75, new String[] {"Electabuzz"}));
		pokedex.add(new Pokemon("Magmar", "Fire", null, 65, 95, 57, 100, 85, 93, 27, new String[] {"human-like"}, 75, new String[] {"Magmar"}));
		pokedex.add(new Pokemon("Pinsir", "Bug", null, 65, 125, 100, 55, 70, 85, 27, new String[] {"bug"}, 50, new String[] {"Pinsir"}));
		pokedex.add(new Pokemon("Tauros", "Normal", null, 75, 100, 95, 40, 70, 110, 27, new String[] {"field"}, 100, new String[] {"Tauros"}));
		pokedex.add(new Pokemon("Magikarp", "Water", null, 20, 10, 55, 15, 20, 80, 0, new String[] {"water2", "dragon"}, 50, new String[] {"Magikarp", "Gyarados"}));
		pokedex.add(new Pokemon("Gyarados", "Water", "Flying", 95, 125, 79, 60, 100, 81, 27, new String[] {"water2", "dragon"}, 50, new String[] {"Magikarp", "Gyarados"}));
		pokedex.add(new Pokemon("Lapras", "Water", "Ice", 130, 85, 80, 85, 95, 60, 27, new String[] {"water1", "monster"}, 50, new String[] {"Lapras"}));
		pokedex.add(new Pokemon("Ditto", "Normal", null, 48, 48, 48, 48, 48, 48, 28, new String[] {"ditto"}, -1, new String[] {"Ditto"}));
		pokedex.add(new Pokemon("Eevee", "Normal", null, 55, 55, 50, 45, 65, 55, 27, new String[] {"field"}, 87.5, new String[] {"Eevee", "Vaporeon", "Jolteon", "Flareon"}));
		pokedex.add(new Pokemon("Vaporeon", "Water", null, 130, 65, 60, 110, 95, 65, 27, new String[] {"field"}, 87.5, new String[] {"Eevee", "Vaporeon", "Jolteon", "Flareon"}));
		pokedex.add(new Pokemon("Jolteon", "Electric", null, 65, 65, 60, 110, 95, 130, 27, new String[] {"field"}, 87.5, new String[] {"Eevee", "Vaporeon", "Jolteon", "Flareon"}));
		pokedex.add(new Pokemon("Flareon", "Fire", null, 65, 130, 60, 95, 110, 65, 27, new String[] {"field"}, 87.5, new String[] {"Eevee", "Vaporeon", "Jolteon", "Flareon"}));
		pokedex.add(new Pokemon("Porygon", "Normal", null, 65, 60, 70, 85, 75, 40, 27, new String[] {"mineral"}, -1, new String[] {"Porygon"}));
		pokedex.add(new Pokemon("Omanyte", "Rock", "Water", 35, 40, 100, 90, 55, 35, 27, new String[] {"water1", "water3"}, 87.5, new String[] {"Omanyte", "Omastar"}));
		pokedex.add(new Pokemon("Omastar", "Rock", "Water", 70, 60, 125, 115, 70, 55, 27, new String[] {"water1", "water3"}, 87.5, new String[] {"Omanyte", "Omastar"}));
		pokedex.add(new Pokemon("Kabuto", "Rock", "Water", 30, 80, 90, 55, 45, 55, 27, new String[] {"water1", "water3"}, 87.5, new String[] {"Kabuto", "Kabutops"}));
		pokedex.add(new Pokemon("Kabutops", "Rock", "Water", 60, 115, 105, 65, 70, 80, 27, new String[] {"water1", "water3"}, 87.5, new String[] {"Kabuto", "Kabutops"}));
		pokedex.add(new Pokemon("Aerodactyl", "Rock", "Flying", 80, 105, 65, 60, 75, 130, 27, new String[] {"flying"}, 87.5, new String[] {"Aerodactyl"}));
		pokedex.add(new Pokemon("Snorlax", "Normal", null, 160, 110, 65, 65, 110, 30, 30, new String[] {"monster"}, 87.5, new String[] {"Snorlax"}));
		pokedex.add(new Pokemon("Articuno", "Ice", "Flying", 90, 85, 100, 95, 125, 85, 32, new String[] {"undiscovered"}, -1, new String[] {"Articuno"}));
		pokedex.add(new Pokemon("Zapdos", "Electric", "Flying", 90, 90, 85, 125, 90, 100, 32, new String[] {"undiscovered"}, -1, new String[] {"Zapdos"}));
		pokedex.add(new Pokemon("Moltres", "Fire", "Flying", 90, 100, 90, 125, 85, 90, 32, new String[] {"undiscovered"}, -1, new String[] {"Moltres"}));
		pokedex.add(new Pokemon("Dratini", "Dragon", null, 41, 64, 45, 50, 50, 50, 27, new String[] {"water1", "dragon"}, 50, new String[] {"Dratini", "Dragonair", "Dragonite"}));
		pokedex.add(new Pokemon("Dragonair", "Dragon", null, 61, 84, 65, 70, 70, 70, 27, new String[] {"water1", "dragon"}, 50, new String[] {"Dratini", "Dragonair", "Dragonite"}));
		pokedex.add(new Pokemon("Dragonite", "Dragon", "Flying", 91, 134, 95, 100, 100, 80, 27, new String[] {"water1", "dragon"}, 50, new String[] {"Dratini", "Dragonair", "Dragonite"}));
		pokedex.add(new Pokemon("Mewtwo", "Psychic", null, 106, 110, 90, 154, 90, 130, 32, new String[] {"undiscovered"}, -1, new String[] {"Mewtwo"}));
		pokedex.add(new Pokemon("Mew", "Psychic", null, 100, 100, 100, 100, 100, 100, 27, new String[] {"undiscovered"}, -1, new String[] {"Mew"}));
	}

	private static void printOwnedPokemon(Player p) {
		System.out.println("Your Pokemon:");
		for (int i = 0; i < p.getPC().size(); i++) {
			System.out.println(i + 1 + ") " + p.getPC().get(i).getNickname());
		}
		System.out.println();
	}

	private static boolean isNumeric(String temp) {
		try {
			Integer.parseInt(temp);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	private static void search(ArrayList<Pokemon> pokedex, Player p, int[] spawnRateCounter) {
		int rand = new Random().nextInt(20);
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

	private static void viewOwnedPokemon(Player p, Scanner input) {
		boolean done = false;
		boolean first = true;
		String temp;
		while (!done) {
			printOwnedPokemon(p);
			System.out.println("Enter the number corresponding to a Pokemon in your PC to view it or enter \"0\" to go back to the main menu.");
			System.out.println();
			if (input.hasNext()) {
				if (first) {
					temp = input.nextLine();
					temp = input.nextLine();
					first = false;
				} else 
					temp = input.nextLine();
				if (!isNumeric(temp)) {
					System.out.println();
					System.out.println("CALLED");
					System.out.println("Input does not match an available choice.");
					System.out.println();
				} else {
					int num = Integer.parseInt(temp);
					if (num < 0 || num >= p.getPC().size() + 1) {
						System.out.println();
						System.out.println("Input does not match an available choice.");
						System.out.println();
					} else {
						if (num != 0) {
							System.out.println();
							System.out.println(p.getPC().get(num - 1));
							System.out.println();
							boolean repeat = false;
							while (!repeat) {
								System.out.println("Would you like to view another Pokemon?");
								System.out.println("1) Yes");
								System.out.println("2) No");
								System.out.println();
								if (input.hasNext())
									switch (input.nextLine()) {
									case "1":
										System.out.println();
										repeat = true;
										break;
									case "2":
										System.out.println();
										done = true;
										repeat = true;
										break;
									default:
										System.out.println();
										System.out.println("Input does not match an available choice.");
										System.out.println();
									}
							}
						} else {
							System.out.println();
							done = true;
						}
					}
				}
			}
		}
	}

	private static void breed(Player p, Scanner input, ArrayList<Pokemon> pokedex) {
		boolean done = false;
		boolean first = true;
		String temp;
		while (!done) {
			printOwnedPokemon(p);
			System.out.println("Enter the number corresponding to the first Pokemon you would like to breed, or enter \"0\" to go back to the previos menu.");
			System.out.println();
			if (first) {
				temp = input.nextLine();
				temp = input.nextLine();
				first = false;
			} else 
				temp = input.nextLine();
			if (!isNumeric(temp)) {
				System.out.println();
				System.out.println("Input does not match an available choice.");
				System.out.println();
			} else {
				int num = Integer.parseInt(temp);
				if (num < 0 || num > p.getPC().size()) {
					System.out.println();
					System.out.println("Input does not match an available choice.");
					System.out.println();
				} else {
					if (num != 0) {
						System.out.println();
						System.out.println("Enter the number corresponding to the second Pokemon you would like to breed, or enter \"0\" to go back to the main menu.");
						System.out.println();
						temp = input.nextLine();
						if (!isNumeric(temp)) {
							System.out.println();
							System.out.println("Input does not match an available choice.");
							System.out.println();
						} else {
							int numTwo = Integer.parseInt(temp);
							if (numTwo < 0 || numTwo > p.getPC().size() || num == numTwo) {
								System.out.println();
								System.out.println("Input does not match an available choice.");
								System.out.println();
							} else {
								if (numTwo != 0) {
									boolean breedable = false;
									boolean validEggGroup = false;
									for (int i = 0; i < p.getPC().get(num - 1).getEggGroup().length; i++)
										for (int j = 0; j < p.getPC().get(numTwo - 1).getEggGroup().length; j++)
											if (p.getPC().get(num - 1).getEggGroup()[i].equals(p.getPC().get(numTwo - 1).getEggGroup()[j]))
												validEggGroup = true;
									if (validEggGroup) {
										if ((p.getPC().get(num - 1).getGender().equals("male") && p.getPC().get(numTwo - 1).getGender().equals("female"))
												|| (p.getPC().get(num - 1).getGender().equals("female") && p.getPC().get(numTwo - 1).getGender().equals("male"))
												|| (p.getPC().get(num - 1).getGender().equals("genderless") && p.getPC().get(numTwo - 1).getGender().equals("genderless")))
											breedable = true;
										if (p.getPC().get(num - 1).getEggGroup()[0].equals("undiscovered") 
												&& p.getPC().get(numTwo - 1).getEggGroup()[0].equals("undiscovered") 
												&& !p.getPC().get(numTwo - 1).getName().equals(p.getPC().get(num - 1).getName()))
											breedable = false;
									}
									if (p.getPC().get(num - 1).getEggGroup()[0].equals("ditto"))
										breedable = true;
									if (p.getPC().get(numTwo - 1).getEggGroup()[0].equals("ditto"))
										breedable = true;
									if (breedable) {
										OwnedPokemon oldOne = new OwnedPokemon(p.getPC().get(num - 1));
										OwnedPokemon oldTwo = new OwnedPokemon(p.getPC().get(numTwo - 1));
										Pokemon pokemon;
										boolean ditto = false;
										for (int i = 0; i < oldOne.getEggGroup().length; i++)
											if (oldOne.getEggGroup()[i].equals("ditto")) {
												pokemon = getBabyPokemon(pokedex, oldTwo);
												ditto = true;
												p.catchPokemon(createBabyPokemon(p, pokedex, num, numTwo, oldOne, oldTwo, pokemon));
												System.out.println();
												System.out.println("Congratulations on your newly bred Pokemon!");
												System.out.println();
												done = true;
											}
										if (!ditto)
											for (int i = 0; i < oldTwo.getEggGroup().length; i++)
												if (oldTwo.getEggGroup()[i].equals("ditto")) {
													pokemon = getBabyPokemon(pokedex, oldOne);
													ditto = true;
													p.catchPokemon(createBabyPokemon(p, pokedex, num, numTwo, oldOne, oldTwo, pokemon));
													System.out.println();
													System.out.println("Congratulations on your newly bred Pokemon!");
													System.out.println();
													done = true;
												}
										if (!ditto)
											if (oldOne.getGender().equals("genderless")) {
												int choose = new Random().nextInt(2);
												if (choose == 0) {
													pokemon = getBabyPokemon(pokedex, oldOne);
													p.catchPokemon(createBabyPokemon(p, pokedex, num, numTwo, oldOne, oldTwo, pokemon));
													System.out.println();
													System.out.println("Congratulations on your newly bred Pokemon!");
													System.out.println();
													done = true;
												} else {
													pokemon = getBabyPokemon(pokedex, oldTwo);
													p.catchPokemon(createBabyPokemon(p, pokedex, num, numTwo, oldOne, oldTwo, pokemon));
													System.out.println();
													System.out.println("Congratulations on your newly bred Pokemon!");
													System.out.println();
													done = true;
												}
											} else
												if (oldOne.getGender().equals("female")) {
													if (oldOne.getName().equals("NidoranF") || oldOne.getName().equals("Nidorina") || oldOne.getName().equals("Nidoqueen")) {
														int rand = new Random().nextInt(2);
														if (rand == 0) {
															pokemon = pokedex.get(28);
															p.catchPokemon(createBabyPokemon(p, pokedex, num, numTwo, oldOne, oldTwo, pokemon));
															System.out.println();
															System.out.println("Congratulations on your newly bred Pokemon!");
															System.out.println();
															done = true;
														} else {
															pokemon = pokedex.get(31);
															p.catchPokemon(createBabyPokemon(p, pokedex, num, numTwo, oldOne, oldTwo, pokemon));
															System.out.println();
															System.out.println("Congratulations on your newly bred Pokemon!");
															System.out.println();
															done = true;
														}
													} else {
														pokemon = getBabyPokemon(pokedex, oldOne);
														p.catchPokemon(createBabyPokemon(p, pokedex, num, numTwo, oldOne, oldTwo, pokemon));
														System.out.println();
														System.out.println("Congratulations on your newly bred Pokemon!");
														System.out.println();
														done = true;
													}
												} else {
													if (oldTwo.getName().equals("NidoranF") || oldTwo.getName().equals("Nidorina") || oldTwo.getName().equals("Nidoqueen")) {
														int rand = new Random().nextInt(2);
														if (rand == 0) {
															pokemon = pokedex.get(28);
															p.catchPokemon(createBabyPokemon(p, pokedex, num, numTwo, oldOne, oldTwo, pokemon));
															System.out.println();
															System.out.println("Congratulations on your newly bred Pokemon!");
															System.out.println();
															done = true;
														} else {
															pokemon = pokedex.get(31);
															p.catchPokemon(createBabyPokemon(p, pokedex, num, numTwo, oldOne, oldTwo, pokemon));
															System.out.println();
															System.out.println("Congratulations on your newly bred Pokemon!");
															System.out.println();
															done = true;
														}
													} else {
														pokemon = getBabyPokemon(pokedex, oldTwo);
														p.catchPokemon(createBabyPokemon(p, pokedex, num, numTwo, oldOne, oldTwo, pokemon));
														System.out.println();
														System.out.println("Congratulations on your newly bred Pokemon!");
														System.out.println();
														done = true;
													}
												}
									} else {
										System.out.println();
										System.out.println("These two Pokemon are not breedable.");
										System.out.println();
										done = true;
									}
								} else {
									System.out.println();
									done = true;
								}
							}
						}
					} else {
						System.out.println();
						done = true;
					}
				}
			}
		}
	}

	private static OwnedPokemon createBabyPokemon(Player p, ArrayList<Pokemon> pokedex, int num, int numTwo, OwnedPokemon oldOne, OwnedPokemon oldTwo, Pokemon pokemon) {
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
		return new OwnedPokemon(pokemon, healthIV, attackIV, defenseIV, specialAttackIV, specialDefenseIV, speedIV);
	}

	private static Pokemon getBabyPokemon(ArrayList<Pokemon> pokedex, OwnedPokemon poke) {
		for (int i = 0; i < pokedex.size(); i++)
			if (poke.getPokemon().getEvolutionTree()[0].equals(pokedex.get(i).getName()))
				return pokedex.get(i);
		return poke.getPokemon();
	}

	private static void training(Player p, Scanner input) {
		boolean done = false;
		String temp = "";
		while (!done) {
			System.out.println("Would you like to Level Up a Pokemon, EV Train a Pokemon, Reset a Pokemon's EVs, or Change a Pokemon's Nature?");
			System.out.println("1) Level Up");
			System.out.println("2) EV Train");
			System.out.println("3) Reset EVs");
			System.out.println("4) Change Nature");
			System.out.println("Enter \"0\" to go back to the main menu.");
			System.out.println();
			if (input.hasNext()) {
				temp = input.nextLine();
				switch (temp) {
				case "1":
					System.out.println();
					levelUp(p, input);
					System.out.println();
					done = true;
					break;
				case "2":
					System.out.println();
					evTrain(p, input);
					System.out.println();
					done = true;
					break;
				case "3":
					System.out.println();
					resetEVs(p, input);
					System.out.println();
					done = true;
					break;
				case "4":
					System.out.println();
					changeNature(p, input);
					System.out.println();
					break;
				case "0":
					System.out.println();
					done = true;
					break;
				default:
					System.out.println();
					System.out.println("Input does not match an available choice.");
					System.out.println();
				}
			}
		}
	}

	private static void levelUp(Player p, Scanner input) {
		boolean done = false;
		while (!done) {
			printOwnedPokemon(p);
			System.out.println("Choose the pokemon you want to level up.");
			System.out.println("Enter the number corresponding to a Pokemon in your PC or enter \"0\" to go back to the main menu.");
			System.out.println();
			String temp = input.nextLine();
			if (!isNumeric(temp)) {
				System.out.println();
				System.out.println("Input does not match an available choice.");
				System.out.println();
			} else {
				int num = Integer.parseInt(temp);
				if (num < 0 || num >= p.getPC().size() + 1) {
					System.out.println();
					System.out.println("Input does not match an available choice.");
					System.out.println();
				} else {
					if (num != 0) {
						if (p.getPC().get(num - 1).getLevel() < 100) {
							String typePoints = chooseTypePoints(p, num);
							System.out.println();
							System.out.println("Each level-up has a point-cost equal to the Pokemon's current level.");
							boolean finished = false;
							while (!finished) {
								System.out.println("A level-up for this Pokemon will cost you " + p.getPC().get(num - 1).getLevel() + " " + typePoints);
								System.out.println("Enter \"1\" to level up or enter \"0\" to go back to the main menu.");
								System.out.println();
								if (input.hasNext())
									switch (input.nextLine()) {
									case "1":
										boolean enough = true;
										switch (typePoints) {
										case "Tier 1 Points":
											if (p.getTier1() < p.getPC().get(num - 1).getLevel())
												enough = false;
											break;
										case "Tier 2 Points":
											if (p.getTier2() < p.getPC().get(num - 1).getLevel())
												enough = false;
											break;
										case "Tier 3 Points":
											if (p.getTier3() < p.getPC().get(num - 1).getLevel())
												enough = false;
											break;
										case "Tier 4 Points":
											if (p.getTier4() < p.getPC().get(num - 1).getLevel())
												enough = false;
											break;
										case "Tier 5 Points":
											if (p.getTier5() < p.getPC().get(num - 1).getLevel())
												enough = false;
											break;
										}
										if (enough) {
											if (p.getPC().get(num - 1).getLevel() < 100) {
												levelUpHelper(p, input, num, typePoints);
											} else {
												System.out.println();
												System.out.println("This Pokemon is already level 100.  Make a different choice.");
												System.out.println();
												finished = true;
												done = true;
											}
										} else {
											System.out.println();
											System.out.println("Leveling up this Pokemon costs " + p.getPC().get(num - 1).getLevel() + " " + typePoints);
											System.out.println("You do not have enough " + typePoints + " to level up this Pokemon");
											System.out.println();
											finished = true;
											done = true;
										}
										break;
									case "0":
										System.out.println();
										finished = true;
										done = true;
										break;
									default:
										System.out.println();
										System.out.println("Input does not match an available choice.");
										System.out.println();
									}
							}
						} else {
							System.out.println();
							System.out.println("This Pokemon is already level 100.  Make a different choice.");
							System.out.println();
						}
					} else {
						done = true;
					}
				}
			}
		}
	}

	private static void levelUpHelper(Player p, Scanner input, int num, String typePoints) {
		if (typePoints.equals("Tier 1 Points")) {
			System.out.println();
			p.spendTier1(p.getPC().get(num - 1).getLevel());
			p.getPC().get(num - 1).levelUp();
			System.out.println("Your " + p.getPC().get(num - 1).getName() + " is now level " + p.getPC().get(num - 1).getLevel());
			System.out.println();
		}
		if (typePoints.equals("Tier 2 Points")) {
			System.out.println();
			p.spendTier2(p.getPC().get(num - 1).getLevel());
			p.getPC().get(num - 1).levelUp();
			System.out.println("Your " + p.getPC().get(num - 1).getName() + " is now level " + p.getPC().get(num - 1).getLevel());
			System.out.println();
		}
		if (typePoints.equals("Tier 3 Points")) {
			System.out.println();
			p.spendTier3(p.getPC().get(num - 1).getLevel());
			p.getPC().get(num - 1).levelUp();
			System.out.println("Your " + p.getPC().get(num - 1).getName() + " is now level " + p.getPC().get(num - 1).getLevel());
			System.out.println();
		}
		if (typePoints.equals("Tier 4 Points")) {
			System.out.println();
			p.spendTier4(p.getPC().get(num - 1).getLevel());
			p.getPC().get(num - 1).levelUp();
			System.out.println("Your " + p.getPC().get(num - 1).getName() + " is now level " + p.getPC().get(num - 1).getLevel());
			System.out.println();
		}
		if (typePoints.equals("Tier 5 Points")) {
			System.out.println();
			p.spendTier5(p.getPC().get(num - 1).getLevel());
			p.getPC().get(num - 1).levelUp();
			System.out.println("Your " + p.getPC().get(num - 1).getName() + " is now level " + p.getPC().get(num - 1).getLevel());
			System.out.println();
		}
	}

	private static void evTrain(Player p, Scanner input) {
		boolean done = false;
		while (!done) {
			printOwnedPokemon(p);
			System.out.println("Choose a Pokemon to EV Train.");
			System.out.println("Enter the number corresponding to a Pokemon in your PC or enter \"0\" to go back to the main menu.");
			System.out.println();
			String temp = input.nextLine();
			if (!isNumeric(temp)) {
				System.out.println();
				System.out.println("Input does not match an available choice.");
				System.out.println();
			} else {
				int num = Integer.parseInt(temp);
				if (num < 0 || num >= p.getPC().size() + 1) {
					System.out.println();
					System.out.println("Input does not match an available choice.");
					System.out.println();
				} else {
					if (num != 0) {
						System.out.println();
						System.out.println("Your " + p.getPC().get(num - 1).getName() + "'s EVs:");
						System.out.println("Health EV: " + p.getPC().get(num - 1).getHealthEV());
						System.out.println("Attack EV: " + p.getPC().get(num - 1).getAttackEV());
						System.out.println("Defense EV: " + p.getPC().get(num - 1).getDefenseEV());
						System.out.println("Special Attack EV: " + p.getPC().get(num - 1).getSpecialAttackEV());
						System.out.println("Special Defense EV: " + p.getPC().get(num - 1).getSpecialDefenseEV());
						System.out.println("Speed EV: " + p.getPC().get(num - 1).getSpeedEV());
						System.out.println();
						if ((p.getPC().get(num - 1).getHealthEV() + p.getPC().get(num - 1).getAttackEV() + p.getPC().get(num - 1).getDefenseEV() + p.getPC().get(num - 1).getSpecialAttackEV() + p.getPC().get(num - 1).getSpecialDefenseEV() + p.getPC().get(num - 1).getSpeedEV()) != 508) {
							boolean finished = false;
							while (!finished) {
								System.out.println("Which stat would you like to EV Train?");
								System.out.println("1) Health");
								System.out.println("2) Attack");
								System.out.println("3) Defense");
								System.out.println("4) Special Attack");
								System.out.println("5) Special Defense");
								System.out.println("6) Speed");
								System.out.println("Enter \"0\" to cancel.");
								System.out.println();
								if (input.hasNext()) {
									switch (input.nextLine()) {
									case "1":
										System.out.println();
										trainHealthEV(p, input, num);
										finished = true;
										break;
									case "2":
										System.out.println();
										trainAttackEV(p, input, num);
										finished = true;
										break;
									case "3":
										System.out.println();
										trainDefenseEV(p, input, num);
										finished = true;
										break;
									case "4":
										System.out.println();
										trainSpecialAttackEV(p, input, num);
										finished = true;
										break;
									case "5":
										System.out.println();
										trainSpecialDefenseEV(p, input, num);
										finished = true;
										break;
									case "6":
										System.out.println();
										trainSpeedEV(p, input, num);
										finished = true;
										break;
									case "0":
										System.out.println();
										finished = true;
										break;
									default:
										System.out.println();
										System.out.println("Input does not match an available choice.");
										System.out.println();
									}
								}
							}
							boolean repeat = false;
							while (!repeat) {
								System.out.println("Would you like to EV Train another Pokemon?");
								System.out.println("1) Yes");
								System.out.println("2) No");
								System.out.println();
								if (input.hasNext())
									switch (input.nextLine()) {
									case "1":
										System.out.println();
										repeat = true;
										break;
									case "2":
										System.out.println();
										done = true;
										repeat = true;
										break;
									default:
										System.out.println();
										System.out.println("Input does not match an available choice.");
										System.out.println();
									}
							}
						} else {
							System.out.println("This Pokemon already has 508 EV points.");
							System.out.println();
							boolean repeat = false;
							while (!repeat) {
								System.out.println("Would you like to EV Train another Pokemon?");
								System.out.println("1) Yes");
								System.out.println("2) No");
								System.out.println();
								if (input.hasNext())
									switch (input.nextLine()) {
									case "1":
										System.out.println();
										repeat = true;
										break;
									case "2":
										System.out.println();
										done = true;
										repeat = true;
										break;
									default:
										System.out.println();
										System.out.println("Input does not match an available choice.");
										System.out.println();
									}
							}
						}
					} else {
						done = true;
					}
				}
			}
		}
	}

	private static void trainHealthEV(Player p, Scanner input, int num) {
		String typePoints = chooseTypePoints(p, num);
		System.out.println("Each EV Point costs 1 " + typePoints.substring(0, typePoints.length() - 1));
		System.out.println("You can invest a maximum of 252 points into one stat, and a maximum of 508 points into one Pokemon.");
		boolean invested = false;
		if (typePoints.equals("Tier 1 Points")) {
			System.out.println("You have " + p.getTier1() + " Tier 1 Points.");
			System.out.println("Your " + p.getPC().get(num - 1).getName() + " has " + p.getPC().get(num - 1).getHealthEV() + " Health EVs.");
			System.out.println("How many points would you like to invest?");
			System.out.println();
			while (!invested) {
				String temp = input.nextLine();
				if (!isNumeric(temp)) {
					System.out.println();
					System.out.println("Input does not match an available choice, please input a valid choice.");
					System.out.println();
				} else {
					int tempNum = Integer.parseInt(temp);
					if (tempNum < 0 || (tempNum + p.getPC().get(num - 1).getHealthEV()) > 252 || (tempNum + p.getPC().get(num - 1).getHealthEV() + p.getPC().get(num - 1).getAttackEV() + p.getPC().get(num - 1).getDefenseEV() + p.getPC().get(num - 1).getSpecialAttackEV() + p.getPC().get(num - 1).getSpecialDefenseEV() + p.getPC().get(num - 1).getSpeedEV()) > 508) {
						System.out.println();
						System.out.println("The number you have entered is either negative or would make the EV greater than 252 or would make this Pokemon have more than 508 total EVs.  Please input a valid choice.");
						System.out.println();
					} else {
						if (tempNum > p.getTier1()) {
							System.out.println();
							System.out.println("You have less points than the number you entered.  Please input a valid choice.");
							System.out.println();
						} else {
							System.out.println();
							p.getPC().get(num - 1).addHealthEV(tempNum);
							p.spendTier1(tempNum);
							invested = true;
							System.out.println("Your " + p.getPC().get(num - 1).getName() + " now has " + p.getPC().get(num - 1).getHealthEV() + " Health EVs.");
							System.out.println();
						}
					}
				}
			}
		}
		if (typePoints.equals("Tier 2 Points")) {
			System.out.println("You have " + p.getTier2() + " Tier 2 Points.");
			System.out.println("Your " + p.getPC().get(num - 1).getName() + " has " + p.getPC().get(num - 1).getHealthEV() + " Health EVs.");
			System.out.println("How many points would you like to invest?");
			System.out.println();
			while (!invested) {
				String temp = input.nextLine();
				if (!isNumeric(temp)) {
					System.out.println();
					System.out.println("Input does not match an available choice, please input a valid choice.");
					System.out.println();
				} else {
					int tempNum = Integer.parseInt(temp);
					if (tempNum < 0 || (tempNum + p.getPC().get(num - 1).getHealthEV()) > 252 || (tempNum + p.getPC().get(num - 1).getHealthEV() + p.getPC().get(num - 1).getAttackEV() + p.getPC().get(num - 1).getDefenseEV() + p.getPC().get(num - 1).getSpecialAttackEV() + p.getPC().get(num - 1).getSpecialDefenseEV() + p.getPC().get(num - 1).getSpeedEV()) > 508) {
						System.out.println();
						System.out.println("The number you have entered is either negative or would make the EV greater than 252 or would make this Pokemon have more than 508 total EVs.  Please input a valid choice.");
						System.out.println();
					} else {
						if (tempNum > p.getTier2()) {
							System.out.println();
							System.out.println("You have less points than the number you entered.  Please input a valid choice.");
							System.out.println();
						} else {
							System.out.println();
							p.getPC().get(num - 1).addHealthEV(tempNum);
							p.spendTier2(tempNum);
							invested = true;
							System.out.println("Your " + p.getPC().get(num - 1).getName() + " now has " + p.getPC().get(num - 1).getHealthEV() + " Health EVs.");
							System.out.println();
						}
					}
				}
			}
		}
		if (typePoints.equals("Tier 3 Points")) {
			System.out.println("You have " + p.getTier3() + " Tier 3 Points.");
			System.out.println("Your " + p.getPC().get(num - 1).getName() + " has " + p.getPC().get(num - 1).getHealthEV() + " Health EVs.");
			System.out.println("How many points would you like to invest?");
			System.out.println();
			while (!invested) {
				String temp = input.nextLine();
				if (!isNumeric(temp)) {
					System.out.println();
					System.out.println("Input does not match an available choice, please input a valid choice.");
					System.out.println();
				} else {
					int tempNum = Integer.parseInt(temp);
					if (tempNum < 0 || (tempNum + p.getPC().get(num - 1).getHealthEV()) > 252  || (tempNum + p.getPC().get(num - 1).getHealthEV() + p.getPC().get(num - 1).getAttackEV() + p.getPC().get(num - 1).getDefenseEV() + p.getPC().get(num - 1).getSpecialAttackEV() + p.getPC().get(num - 1).getSpecialDefenseEV() + p.getPC().get(num - 1).getSpeedEV()) > 508) {
						System.out.println();
						System.out.println("The number you have entered is either negative or would make the EV greater than 252 or would make this Pokemon have more than 508 total EVs.  Please input a valid choice.");
						System.out.println();
					} else {
						if (tempNum > p.getTier3()) {
							System.out.println();
							System.out.println("You have less points than the number you entered.  Please input a valid choice.");
							System.out.println();
						} else {
							System.out.println();
							p.getPC().get(num - 1).addHealthEV(tempNum);
							p.spendTier3(tempNum);
							invested = true;
							System.out.println("Your " + p.getPC().get(num - 1).getName() + " now has " + p.getPC().get(num - 1).getHealthEV() + " Health EVs.");
							System.out.println();
						}
					}
				}
			}
		}
		if (typePoints.equals("Tier 4 Points")) {
			System.out.println("You have " + p.getTier4() + " Tier 4 Points.");
			System.out.println("Your " + p.getPC().get(num - 1).getName() + " has " + p.getPC().get(num - 1).getHealthEV() + " Health EVs.");
			System.out.println("How many points would you like to invest?");
			System.out.println();
			while (!invested) {
				String temp = input.nextLine();
				if (!isNumeric(temp)) {
					System.out.println();
					System.out.println("Input does not match an available choice, please input a valid choice.");
					System.out.println();
				} else {
					int tempNum = Integer.parseInt(temp);
					if (tempNum < 0 || (tempNum + p.getPC().get(num - 1).getHealthEV()) > 252  || (tempNum + p.getPC().get(num - 1).getHealthEV() + p.getPC().get(num - 1).getAttackEV() + p.getPC().get(num - 1).getDefenseEV() + p.getPC().get(num - 1).getSpecialAttackEV() + p.getPC().get(num - 1).getSpecialDefenseEV() + p.getPC().get(num - 1).getSpeedEV()) > 508) {
						System.out.println();
						System.out.println("The number you have entered is either negative or would make the EV greater than 252 or would make this Pokemon have more than 508 total EVs.  Please input a valid choice.");
						System.out.println();
					} else {
						if (tempNum > p.getTier4()) {
							System.out.println();
							System.out.println("You have less points than the number you entered.  Please input a valid choice.");
							System.out.println();
						} else {
							System.out.println();
							p.getPC().get(num - 1).addHealthEV(tempNum);
							p.spendTier4(tempNum);
							invested = true;
							System.out.println("Your " + p.getPC().get(num - 1).getName() + " now has " + p.getPC().get(num - 1).getHealthEV() + " Health EVs.");
							System.out.println();
						}
					}
				}
			}
		}
		if (typePoints.equals("Tier 5 Points")) {
			System.out.println("You have " + p.getTier5() + " Tier 5 Points.");
			System.out.println("Your " + p.getPC().get(num - 1).getName() + " has " + p.getPC().get(num - 1).getHealthEV() + " Health EVs.");
			System.out.println("How many points would you like to invest?");
			System.out.println();
			while (!invested) {
				String temp = input.nextLine();
				if (!isNumeric(temp)) {
					System.out.println();
					System.out.println("Input does not match an available choice, please input a valid choice.");
					System.out.println();
				} else {
					int tempNum = Integer.parseInt(temp);
					if (tempNum < 0 || (tempNum + p.getPC().get(num - 1).getHealthEV()) > 252  || (tempNum + p.getPC().get(num - 1).getHealthEV() + p.getPC().get(num - 1).getAttackEV() + p.getPC().get(num - 1).getDefenseEV() + p.getPC().get(num - 1).getSpecialAttackEV() + p.getPC().get(num - 1).getSpecialDefenseEV() + p.getPC().get(num - 1).getSpeedEV()) > 508) {
						System.out.println();
						System.out.println("The number you have entered is either negative or would make the EV greater than 252 or would make this Pokemon have more than 508 total EVs.  Please input a valid choice.");
						System.out.println();
					} else {
						if (tempNum > p.getTier5()) {
							System.out.println();
							System.out.println("You have less points than the number you entered.  Please input a valid choice.");
							System.out.println();
						} else {
							System.out.println();
							p.getPC().get(num - 1).addHealthEV(tempNum);
							p.spendTier5(tempNum);
							invested = true;
							System.out.println("Your " + p.getPC().get(num - 1).getName() + " now has " + p.getPC().get(num - 1).getHealthEV() + " Health EVs.");
							System.out.println();
						}
					}
				}
			}
		}
	}

	private static void trainAttackEV(Player p, Scanner input, int num) {
		String typePoints = chooseTypePoints(p, num);
		System.out.println("Each EV Point costs 1 " + typePoints.substring(0, typePoints.length() - 1));
		System.out.println("You can invest a maximum of 252 points into one stat, and a maximum of 508 points into one Pokemon.");
		boolean invested = false;
		if (typePoints.equals("Tier 1 Points")) {
			System.out.println("You have " + p.getTier1() + " Tier 1 Points.");
			System.out.println("Your " + p.getPC().get(num - 1).getName() + " has " + p.getPC().get(num - 1).getAttackEV() + " Attack EVs.");
			System.out.println("How many points would you like to invest?");
			System.out.println();
			while (!invested) {
				String temp = input.nextLine();
				if (!isNumeric(temp)) {
					System.out.println();
					System.out.println("Input does not match an available choice, please input a valid choice.");
					System.out.println();
				} else {
					int tempNum = Integer.parseInt(temp);
					if (tempNum < 0 || (tempNum + p.getPC().get(num - 1).getAttackEV()) > 252  || (tempNum + p.getPC().get(num - 1).getHealthEV() + p.getPC().get(num - 1).getAttackEV() + p.getPC().get(num - 1).getDefenseEV() + p.getPC().get(num - 1).getSpecialAttackEV() + p.getPC().get(num - 1).getSpecialDefenseEV() + p.getPC().get(num - 1).getSpeedEV()) > 508) {
						System.out.println();
						System.out.println("The number you have entered is either negative or would make the EV greater than 252 or would make this Pokemon have more than 508 total EVs.  Please input a valid choice.");
						System.out.println();
					} else {
						if (tempNum > p.getTier1()) {
							System.out.println();
							System.out.println("You have less points than the number you entered.  Please input a valid choice.");
							System.out.println();
						} else {
							System.out.println();
							p.getPC().get(num - 1).addAttackEV(tempNum);
							p.spendTier1(tempNum);
							invested = true;
							System.out.println("Your " + p.getPC().get(num - 1).getName() + " now has " + p.getPC().get(num - 1).getAttackEV() + " Attack EVs.");
							System.out.println();
						}
					}
				}
			}
		}
		if (typePoints.equals("Tier 2 Points")) {
			System.out.println("You have " + p.getTier2() + " Tier 2 Points.");
			System.out.println("Your " + p.getPC().get(num - 1).getName() + " has " + p.getPC().get(num - 1).getAttackEV() + " Attack EVs.");
			System.out.println("How many points would you like to invest?");
			System.out.println();
			while (!invested) {
				String temp = input.nextLine();
				if (!isNumeric(temp)) {
					System.out.println();
					System.out.println("Input does not match an available choice, please input a valid choice.");
					System.out.println();
				} else {
					int tempNum = Integer.parseInt(temp);
					if (tempNum < 0 || (tempNum + p.getPC().get(num - 1).getAttackEV()) > 252  || (tempNum + p.getPC().get(num - 1).getHealthEV() + p.getPC().get(num - 1).getAttackEV() + p.getPC().get(num - 1).getDefenseEV() + p.getPC().get(num - 1).getSpecialAttackEV() + p.getPC().get(num - 1).getSpecialDefenseEV() + p.getPC().get(num - 1).getSpeedEV()) > 508) {
						System.out.println();
						System.out.println("The number you have entered is either negative or would make the EV greater than 252 or would make this Pokemon have more than 508 total EVs.  Please input a valid choice.");
						System.out.println();
					} else {
						if (tempNum > p.getTier2()) {
							System.out.println();
							System.out.println("You have less points than the number you entered.  Please input a valid choice.");
							System.out.println();
						} else {
							System.out.println();
							p.getPC().get(num - 1).addAttackEV(tempNum);
							p.spendTier2(tempNum);
							invested = true;
							System.out.println("Your " + p.getPC().get(num - 1).getName() + " now has " + p.getPC().get(num - 1).getAttackEV() + " Attack EVs.");
							System.out.println();
						}
					}
				}
			}
		}
		if (typePoints.equals("Tier 3 Points")) {
			System.out.println("You have " + p.getTier3() + " Tier 3 Points.");
			System.out.println("Your " + p.getPC().get(num - 1).getName() + " has " + p.getPC().get(num - 1).getAttackEV() + " Attack EVs.");
			System.out.println("How many points would you like to invest?");
			System.out.println();
			while (!invested) {
				String temp = input.nextLine();
				if (!isNumeric(temp)) {
					System.out.println();
					System.out.println("Input does not match an available choice, please input a valid choice.");
					System.out.println();
				} else {
					int tempNum = Integer.parseInt(temp);
					if (tempNum < 0 || (tempNum + p.getPC().get(num - 1).getAttackEV()) > 252  || (tempNum + p.getPC().get(num - 1).getHealthEV() + p.getPC().get(num - 1).getAttackEV() + p.getPC().get(num - 1).getDefenseEV() + p.getPC().get(num - 1).getSpecialAttackEV() + p.getPC().get(num - 1).getSpecialDefenseEV() + p.getPC().get(num - 1).getSpeedEV()) > 508) {
						System.out.println();
						System.out.println("The number you have entered is either negative or would make the EV greater than 252 or would make this Pokemon have more than 508 total EVs.  Please input a valid choice.");
						System.out.println();
					} else {
						if (tempNum > p.getTier3()) {
							System.out.println();
							System.out.println("You have less points than the number you entered.  Please input a valid choice.");
							System.out.println();
						} else {
							System.out.println();
							p.getPC().get(num - 1).addAttackEV(tempNum);
							p.spendTier3(tempNum);
							invested = true;
							System.out.println("Your " + p.getPC().get(num - 1).getName() + " now has " + p.getPC().get(num - 1).getAttackEV() + " Attack EVs.");
							System.out.println();
						}
					}
				}
			}
		}
		if (typePoints.equals("Tier 4 Points")) {
			System.out.println("You have " + p.getTier4() + " Tier 4 Points.");
			System.out.println("Your " + p.getPC().get(num - 1).getName() + " has " + p.getPC().get(num - 1).getAttackEV() + " Attack EVs.");
			System.out.println("How many points would you like to invest?");
			System.out.println();
			while (!invested) {
				String temp = input.nextLine();
				if (!isNumeric(temp)) {
					System.out.println();
					System.out.println("Input does not match an available choice, please input a valid choice.");
					System.out.println();
				} else {
					int tempNum = Integer.parseInt(temp);
					if (tempNum < 0 || (tempNum + p.getPC().get(num - 1).getAttackEV()) > 252  || (tempNum + p.getPC().get(num - 1).getHealthEV() + p.getPC().get(num - 1).getAttackEV() + p.getPC().get(num - 1).getDefenseEV() + p.getPC().get(num - 1).getSpecialAttackEV() + p.getPC().get(num - 1).getSpecialDefenseEV() + p.getPC().get(num - 1).getSpeedEV()) > 508) {
						System.out.println();
						System.out.println("The number you have entered is either negative or would make the EV greater than 252 or would make this Pokemon have more than 508 total EVs.  Please input a valid choice.");
						System.out.println();
					} else {
						if (tempNum > p.getTier4()) {
							System.out.println();
							System.out.println("You have less points than the number you entered.  Please input a valid choice.");
							System.out.println();
						} else {
							System.out.println();
							p.getPC().get(num - 1).addAttackEV(tempNum);
							p.spendTier4(tempNum);
							invested = true;
							System.out.println("Your " + p.getPC().get(num - 1).getName() + " now has " + p.getPC().get(num - 1).getAttackEV() + " Attack EVs.");
							System.out.println();
						}
					}
				}
			}
		}
		if (typePoints.equals("Tier 5 Points")) {
			System.out.println("You have " + p.getTier5() + " Tier 5 Points.");
			System.out.println("Your " + p.getPC().get(num - 1).getName() + " has " + p.getPC().get(num - 1).getAttackEV() + " Attack EVs.");
			System.out.println("How many points would you like to invest?");
			System.out.println();
			while (!invested) {
				String temp = input.nextLine();
				if (!isNumeric(temp)) {
					System.out.println();
					System.out.println("Input does not match an available choice, please input a valid choice.");
					System.out.println();
				} else {
					int tempNum = Integer.parseInt(temp);
					if (tempNum < 0 || (tempNum + p.getPC().get(num - 1).getAttackEV()) > 252  || (tempNum + p.getPC().get(num - 1).getHealthEV() + p.getPC().get(num - 1).getAttackEV() + p.getPC().get(num - 1).getDefenseEV() + p.getPC().get(num - 1).getSpecialAttackEV() + p.getPC().get(num - 1).getSpecialDefenseEV() + p.getPC().get(num - 1).getSpeedEV()) > 508) {
						System.out.println();
						System.out.println("The number you have entered is either negative or would make the EV greater than 252 or would make this Pokemon have more than 508 total EVs.  Please input a valid choice.");
						System.out.println();
					} else {
						if (tempNum > p.getTier5()) {
							System.out.println();
							System.out.println("You have less points than the number you entered.  Please input a valid choice.");
							System.out.println();
						} else {
							System.out.println();
							p.getPC().get(num - 1).addAttackEV(tempNum);
							p.spendTier5(tempNum);
							invested = true;
							System.out.println("Your " + p.getPC().get(num - 1).getName() + " now has " + p.getPC().get(num - 1).getAttackEV() + " Attack EVs.");
							System.out.println();
						}
					}
				}
			}
		}
	}

	private static void trainDefenseEV(Player p, Scanner input, int num) {
		String typePoints = chooseTypePoints(p, num);
		System.out.println("Each EV Point costs 1 " + typePoints.substring(0, typePoints.length() - 1));
		System.out.println("You can invest a maximum of 252 points into one stat, and a maximum of 508 points into one Pokemon.");
		boolean invested = false;
		if (typePoints.equals("Tier 1 Points")) {
			System.out.println("You have " + p.getTier1() + " Tier 1 Points.");
			System.out.println("Your " + p.getPC().get(num - 1).getName() + " has " + p.getPC().get(num - 1).getDefenseEV() + " Defense EVs.");
			System.out.println("How many points would you like to invest?");
			System.out.println();
			while (!invested) {
				String temp = input.nextLine();
				if (!isNumeric(temp)) {
					System.out.println();
					System.out.println("Input does not match an available choice, please input a valid choice.");
					System.out.println();
				} else {
					int tempNum = Integer.parseInt(temp);
					if (tempNum < 0 || (tempNum + p.getPC().get(num - 1).getDefenseEV()) > 252  || (tempNum + p.getPC().get(num - 1).getHealthEV() + p.getPC().get(num - 1).getAttackEV() + p.getPC().get(num - 1).getDefenseEV() + p.getPC().get(num - 1).getSpecialAttackEV() + p.getPC().get(num - 1).getSpecialDefenseEV() + p.getPC().get(num - 1).getSpeedEV()) > 508) {
						System.out.println();
						System.out.println("The number you have entered is either negative or would make the EV greater than 252 or would make this Pokemon have more than 508 total EVs.  Please input a valid choice.");
						System.out.println();
					} else {
						if (tempNum > p.getTier1()) {
							System.out.println();
							System.out.println("You have less points than the number you entered.  Please input a valid choice.");
							System.out.println();
						} else {
							System.out.println();
							p.getPC().get(num - 1).addDefenseEV(tempNum);
							p.spendTier1(tempNum);
							invested = true;
							System.out.println("Your " + p.getPC().get(num - 1).getName() + " now has " + p.getPC().get(num - 1).getDefenseEV() + " Defense EVs.");
							System.out.println();
						}
					}
				}
			}
		}
		if (typePoints.equals("Tier 2 Points")) {
			System.out.println("You have " + p.getTier2() + " Tier 2 Points.");
			System.out.println("Your " + p.getPC().get(num - 1).getName() + " has " + p.getPC().get(num - 1).getDefenseEV() + " Defense EVs.");
			System.out.println("How many points would you like to invest?");
			System.out.println();
			while (!invested) {
				String temp = input.nextLine();
				if (!isNumeric(temp)) {
					System.out.println();
					System.out.println("Input does not match an available choice, please input a valid choice.");
					System.out.println();
				} else {
					int tempNum = Integer.parseInt(temp);
					if (tempNum < 0 || (tempNum + p.getPC().get(num - 1).getDefenseEV()) > 252  || (tempNum + p.getPC().get(num - 1).getHealthEV() + p.getPC().get(num - 1).getAttackEV() + p.getPC().get(num - 1).getDefenseEV() + p.getPC().get(num - 1).getSpecialAttackEV() + p.getPC().get(num - 1).getSpecialDefenseEV() + p.getPC().get(num - 1).getSpeedEV()) > 508) {
						System.out.println();
						System.out.println("The number you have entered is either negative or would make the EV greater than 252 or would make this Pokemon have more than 508 total EVs.  Please input a valid choice.");
						System.out.println();
					} else {
						if (tempNum > p.getTier2()) {
							System.out.println();
							System.out.println("You have less points than the number you entered.  Please input a valid choice.");
							System.out.println();
						} else {
							System.out.println();
							p.getPC().get(num - 1).addDefenseEV(tempNum);
							p.spendTier2(tempNum);
							invested = true;
							System.out.println("Your " + p.getPC().get(num - 1).getName() + " now has " + p.getPC().get(num - 1).getDefenseEV() + " Defense EVs.");
							System.out.println();
						}
					}
				}
			}
		}
		if (typePoints.equals("Tier 3 Points")) {
			System.out.println("You have " + p.getTier3() + " Tier 3 Points.");
			System.out.println("Your " + p.getPC().get(num - 1).getName() + " has " + p.getPC().get(num - 1).getDefenseEV() + " Defense EVs.");
			System.out.println("How many points would you like to invest?");
			System.out.println();
			while (!invested) {
				String temp = input.nextLine();
				if (!isNumeric(temp)) {
					System.out.println();
					System.out.println("Input does not match an available choice, please input a valid choice.");
					System.out.println();
				} else {
					int tempNum = Integer.parseInt(temp);
					if (tempNum < 0 || (tempNum + p.getPC().get(num - 1).getDefenseEV()) > 252  || (tempNum + p.getPC().get(num - 1).getHealthEV() + p.getPC().get(num - 1).getAttackEV() + p.getPC().get(num - 1).getDefenseEV() + p.getPC().get(num - 1).getSpecialAttackEV() + p.getPC().get(num - 1).getSpecialDefenseEV() + p.getPC().get(num - 1).getSpeedEV()) > 508) {
						System.out.println();
						System.out.println("The number you have entered is either negative or would make the EV greater than 252 or would make this Pokemon have more than 508 total EVs.  Please input a valid choice.");
						System.out.println();
					} else {
						if (tempNum > p.getTier3()) {
							System.out.println();
							System.out.println("You have less points than the number you entered.  Please input a valid choice.");
							System.out.println();
						} else {
							System.out.println();
							p.getPC().get(num - 1).addDefenseEV(tempNum);
							p.spendTier3(tempNum);
							invested = true;
							System.out.println("Your " + p.getPC().get(num - 1).getName() + " now has " + p.getPC().get(num - 1).getDefenseEV() + " Defense EVs.");
							System.out.println();
						}
					}
				}
			}
		}
		if (typePoints.equals("Tier 4 Points")) {
			System.out.println("You have " + p.getTier4() + " Tier 4 Points.");
			System.out.println("Your " + p.getPC().get(num - 1).getName() + " has " + p.getPC().get(num - 1).getDefenseEV() + " Defense EVs.");
			System.out.println("How many points would you like to invest?");
			System.out.println();
			while (!invested) {
				String temp = input.nextLine();
				if (!isNumeric(temp)) {
					System.out.println();
					System.out.println("Input does not match an available choice, please input a valid choice.");
					System.out.println();
				} else {
					int tempNum = Integer.parseInt(temp);
					if (tempNum < 0 || (tempNum + p.getPC().get(num - 1).getDefenseEV()) > 252  || (tempNum + p.getPC().get(num - 1).getHealthEV() + p.getPC().get(num - 1).getAttackEV() + p.getPC().get(num - 1).getDefenseEV() + p.getPC().get(num - 1).getSpecialAttackEV() + p.getPC().get(num - 1).getSpecialDefenseEV() + p.getPC().get(num - 1).getSpeedEV()) > 508) {
						System.out.println();
						System.out.println("The number you have entered is either negative or would make the EV greater than 252 or would make this Pokemon have more than 508 total EVs.  Please input a valid choice.");
						System.out.println();
					} else {
						if (tempNum > p.getTier4()) {
							System.out.println();
							System.out.println("You have less points than the number you entered.  Please input a valid choice.");
							System.out.println();
						} else {
							System.out.println();
							p.getPC().get(num - 1).addDefenseEV(tempNum);
							p.spendTier4(tempNum);
							invested = true;
							System.out.println("Your " + p.getPC().get(num - 1).getName() + " now has " + p.getPC().get(num - 1).getDefenseEV() + " Defense EVs.");
							System.out.println();
						}
					}
				}
			}
		}
		if (typePoints.equals("Tier 5 Points")) {
			System.out.println("You have " + p.getTier5() + " Tier 5 Points.");
			System.out.println("Your " + p.getPC().get(num - 1).getName() + " has " + p.getPC().get(num - 1).getDefenseEV() + " Defense EVs.");
			System.out.println("How many points would you like to invest?");
			System.out.println();
			while (!invested) {
				String temp = input.nextLine();
				if (!isNumeric(temp)) {
					System.out.println();
					System.out.println("Input does not match an available choice, please input a valid choice.");
					System.out.println();
				} else {
					int tempNum = Integer.parseInt(temp);
					if (tempNum < 0 || (tempNum + p.getPC().get(num - 1).getDefenseEV()) > 252  || (tempNum + p.getPC().get(num - 1).getHealthEV() + p.getPC().get(num - 1).getAttackEV() + p.getPC().get(num - 1).getDefenseEV() + p.getPC().get(num - 1).getSpecialAttackEV() + p.getPC().get(num - 1).getSpecialDefenseEV() + p.getPC().get(num - 1).getSpeedEV()) > 508) {
						System.out.println();
						System.out.println("The number you have entered is either negative or would make the EV greater than 252 or would make this Pokemon have more than 508 total EVs.  Please input a valid choice.");
						System.out.println();
					} else {
						if (tempNum > p.getTier5()) {
							System.out.println();
							System.out.println("You have less points than the number you entered.  Please input a valid choice.");
							System.out.println();
						} else {
							System.out.println();
							p.getPC().get(num - 1).addDefenseEV(tempNum);
							p.spendTier5(tempNum);
							invested = true;
							System.out.println("Your " + p.getPC().get(num - 1).getName() + " now has " + p.getPC().get(num - 1).getDefenseEV() + " Defense EVs.");
							System.out.println();
						}
					}
				}
			}
		}
	}

	private static void trainSpecialAttackEV(Player p, Scanner input, int num) {
		String typePoints = chooseTypePoints(p, num);
		System.out.println("Each EV Point costs 1 " + typePoints.substring(0, typePoints.length() - 1));
		System.out.println("You can invest a maximum of 252 points into one stat, and a maximum of 508 points into one Pokemon.");
		boolean invested = false;
		if (typePoints.equals("Tier 1 Points")) {
			System.out.println("You have " + p.getTier1() + " Tier 1 Points.");
			System.out.println("Your " + p.getPC().get(num - 1).getName() + " has " + p.getPC().get(num - 1).getSpecialAttackEV() + " Special Attack EVs.");
			System.out.println("How many points would you like to invest?");
			System.out.println();
			while (!invested) {
				String temp = input.nextLine();
				if (!isNumeric(temp)) {
					System.out.println();
					System.out.println("Input does not match an available choice, please input a valid choice.");
					System.out.println();
				} else {
					int tempNum = Integer.parseInt(temp);
					if (tempNum < 0 || (tempNum + p.getPC().get(num - 1).getSpecialAttackEV()) > 252  || (tempNum + p.getPC().get(num - 1).getHealthEV() + p.getPC().get(num - 1).getAttackEV() + p.getPC().get(num - 1).getDefenseEV() + p.getPC().get(num - 1).getSpecialAttackEV() + p.getPC().get(num - 1).getSpecialDefenseEV() + p.getPC().get(num - 1).getSpeedEV()) > 508) {
						System.out.println();
						System.out.println("The number you have entered is either negative or would make the EV greater than 252 or would make this Pokemon have more than 508 total EVs.  Please input a valid choice.");
						System.out.println();
					} else {
						if (tempNum > p.getTier1()) {
							System.out.println();
							System.out.println("You have less points than the number you entered.  Please input a valid choice.");
							System.out.println();
						} else {
							System.out.println();
							p.getPC().get(num - 1).addSpecialAttackEV(tempNum);
							p.spendTier1(tempNum);
							invested = true;
							System.out.println("Your " + p.getPC().get(num - 1).getName() + " now has " + p.getPC().get(num - 1).getSpecialAttackEV() + " Special Attack EVs.");
							System.out.println();
						}
					}
				}
			}
		}
		if (typePoints.equals("Tier 2 Points")) {
			System.out.println("You have " + p.getTier2() + " Tier 2 Points.");
			System.out.println("Your " + p.getPC().get(num - 1).getName() + " has " + p.getPC().get(num - 1).getSpecialAttackEV() + " Special Attack EVs.");
			System.out.println("How many points would you like to invest?");
			System.out.println();
			while (!invested) {
				String temp = input.nextLine();
				if (!isNumeric(temp)) {
					System.out.println();
					System.out.println("Input does not match an available choice, please input a valid choice.");
					System.out.println();
				} else {
					int tempNum = Integer.parseInt(temp);
					if (tempNum < 0 || (tempNum + p.getPC().get(num - 1).getSpecialAttackEV()) > 252  || (tempNum + p.getPC().get(num - 1).getHealthEV() + p.getPC().get(num - 1).getAttackEV() + p.getPC().get(num - 1).getDefenseEV() + p.getPC().get(num - 1).getSpecialAttackEV() + p.getPC().get(num - 1).getSpecialDefenseEV() + p.getPC().get(num - 1).getSpeedEV()) > 508) {
						System.out.println();
						System.out.println("The number you have entered is either negative or would make the EV greater than 252 or would make this Pokemon have more than 508 total EVs.  Please input a valid choice.");
						System.out.println();
					} else {
						if (tempNum > p.getTier2()) {
							System.out.println();
							System.out.println("You have less points than the number you entered.  Please input a valid choice.");
							System.out.println();
						} else {
							System.out.println();
							p.getPC().get(num - 1).addSpecialAttackEV(tempNum);
							p.spendTier2(tempNum);
							invested = true;
							System.out.println("Your " + p.getPC().get(num - 1).getName() + " now has " + p.getPC().get(num - 1).getSpecialAttackEV() + " Special Attack EVs.");
							System.out.println();
						}
					}
				}
			}
		}
		if (typePoints.equals("Tier 3 Points")) {
			System.out.println("You have " + p.getTier3() + " Tier 3 Points.");
			System.out.println("Your " + p.getPC().get(num - 1).getName() + " has " + p.getPC().get(num - 1).getSpecialAttackEV() + " Special Attack EVs.");
			System.out.println("How many points would you like to invest?");
			System.out.println();
			while (!invested) {
				String temp = input.nextLine();
				if (!isNumeric(temp)) {
					System.out.println();
					System.out.println("Input does not match an available choice, please input a valid choice.");
					System.out.println();
				} else {
					int tempNum = Integer.parseInt(temp);
					if (tempNum < 0 || (tempNum + p.getPC().get(num - 1).getSpecialAttackEV()) > 252  || (tempNum + p.getPC().get(num - 1).getHealthEV() + p.getPC().get(num - 1).getAttackEV() + p.getPC().get(num - 1).getDefenseEV() + p.getPC().get(num - 1).getSpecialAttackEV() + p.getPC().get(num - 1).getSpecialDefenseEV() + p.getPC().get(num - 1).getSpeedEV()) > 508) {
						System.out.println();
						System.out.println("The number you have entered is either negative or would make the EV greater than 252 or would make this Pokemon have more than 508 total EVs.  Please input a valid choice.");
						System.out.println();
					} else {
						if (tempNum > p.getTier3()) {
							System.out.println();
							System.out.println("You have less points than the number you entered.  Please input a valid choice.");
							System.out.println();
						} else {
							System.out.println();
							p.getPC().get(num - 1).addSpecialAttackEV(tempNum);
							p.spendTier3(tempNum);
							invested = true;
							System.out.println("Your " + p.getPC().get(num - 1).getName() + " now has " + p.getPC().get(num - 1).getSpecialAttackEV() + " Special Attack EVs.");
							System.out.println();
						}
					}
				}
			}
		}
		if (typePoints.equals("Tier 4 Points")) {
			System.out.println("You have " + p.getTier4() + " Tier 4 Points.");
			System.out.println("Your " + p.getPC().get(num - 1).getName() + " has " + p.getPC().get(num - 1).getSpecialAttackEV() + " Special Attack EVs.");
			System.out.println("How many points would you like to invest?");
			System.out.println();
			while (!invested) {
				String temp = input.nextLine();
				if (!isNumeric(temp)) {
					System.out.println();
					System.out.println("Input does not match an available choice, please input a valid choice.");
					System.out.println();
				} else {
					int tempNum = Integer.parseInt(temp);
					if (tempNum < 0 || (tempNum + p.getPC().get(num - 1).getSpecialAttackEV()) > 252  || (tempNum + p.getPC().get(num - 1).getHealthEV() + p.getPC().get(num - 1).getAttackEV() + p.getPC().get(num - 1).getDefenseEV() + p.getPC().get(num - 1).getSpecialAttackEV() + p.getPC().get(num - 1).getSpecialDefenseEV() + p.getPC().get(num - 1).getSpeedEV()) > 508) {
						System.out.println();
						System.out.println("The number you have entered is either negative or would make the EV greater than 252 or would make this Pokemon have more than 508 total EVs.  Please input a valid choice.");
						System.out.println();
					} else {
						if (tempNum > p.getTier4()) {
							System.out.println();
							System.out.println("You have less points than the number you entered.  Please input a valid choice.");
							System.out.println();
						} else {
							System.out.println();
							p.getPC().get(num - 1).addSpecialAttackEV(tempNum);
							p.spendTier4(tempNum);
							invested = true;
							System.out.println("Your " + p.getPC().get(num - 1).getName() + " now has " + p.getPC().get(num - 1).getSpecialAttackEV() + " Special Attack EVs.");
							System.out.println();
						}
					}
				}
			}
		}
		if (typePoints.equals("Tier 5 Points")) {
			System.out.println("You have " + p.getTier5() + " Tier 5 Points.");
			System.out.println("Your " + p.getPC().get(num - 1).getName() + " has " + p.getPC().get(num - 1).getSpecialAttackEV() + " Special Attack EVs.");
			System.out.println("How many points would you like to invest?");
			System.out.println();
			while (!invested) {
				String temp = input.nextLine();
				if (!isNumeric(temp)) {
					System.out.println();
					System.out.println("Input does not match an available choice, please input a valid choice.");
					System.out.println();
				} else {
					int tempNum = Integer.parseInt(temp);
					if (tempNum < 0 || (tempNum + p.getPC().get(num - 1).getSpecialAttackEV()) > 252  || (tempNum + p.getPC().get(num - 1).getHealthEV() + p.getPC().get(num - 1).getAttackEV() + p.getPC().get(num - 1).getDefenseEV() + p.getPC().get(num - 1).getSpecialAttackEV() + p.getPC().get(num - 1).getSpecialDefenseEV() + p.getPC().get(num - 1).getSpeedEV()) > 508) {
						System.out.println();
						System.out.println("The number you have entered is either negative or would make the EV greater than 252 or would make this Pokemon have more than 508 total EVs.  Please input a valid choice.");
						System.out.println();
					} else {
						if (tempNum > p.getTier5()) {
							System.out.println();
							System.out.println("You have less points than the number you entered.  Please input a valid choice.");
							System.out.println();
						} else {
							System.out.println();
							p.getPC().get(num - 1).addSpecialAttackEV(tempNum);
							p.spendTier5(tempNum);
							invested = true;
							System.out.println("Your " + p.getPC().get(num - 1).getName() + " now has " + p.getPC().get(num - 1).getSpecialAttackEV() + " Special Attack EVs.");
							System.out.println();
						}
					}
				}
			}
		}
	}

	private static void trainSpecialDefenseEV(Player p, Scanner input, int num) {
		String typePoints = chooseTypePoints(p, num);
		System.out.println("Each EV Point costs 1 " + typePoints.substring(0, typePoints.length() - 1));
		System.out.println("You can invest a maximum of 252 points into one stat, and a maximum of 508 points into one Pokemon.");
		boolean invested = false;
		if (typePoints.equals("Tier 1 Points")) {
			System.out.println("You have " + p.getTier1() + " Tier 1 Points.");
			System.out.println("Your " + p.getPC().get(num - 1).getName() + " has " + p.getPC().get(num - 1).getSpecialDefenseEV() + " Special Defense EVs.");
			System.out.println("How many points would you like to invest?");
			System.out.println();
			while (!invested) {
				String temp = input.nextLine();
				if (!isNumeric(temp)) {
					System.out.println();
					System.out.println("Input does not match an available choice, please input a valid choice.");
					System.out.println();
				} else {
					int tempNum = Integer.parseInt(temp);
					if (tempNum < 0 || (tempNum + p.getPC().get(num - 1).getSpecialDefenseEV()) > 252  || (tempNum + p.getPC().get(num - 1).getHealthEV() + p.getPC().get(num - 1).getAttackEV() + p.getPC().get(num - 1).getDefenseEV() + p.getPC().get(num - 1).getSpecialAttackEV() + p.getPC().get(num - 1).getSpecialDefenseEV() + p.getPC().get(num - 1).getSpeedEV()) > 508) {
						System.out.println();
						System.out.println("The number you have entered is either negative or would make the EV greater than 252 or would make this Pokemon have more than 508 total EVs.  Please input a valid choice.");
						System.out.println();
					} else {
						if (tempNum > p.getTier1()) {
							System.out.println();
							System.out.println("You have less points than the number you entered.  Please input a valid choice.");
							System.out.println();
						} else {
							System.out.println();
							p.getPC().get(num - 1).addSpecialDefenseEV(tempNum);
							p.spendTier1(tempNum);
							invested = true;
							System.out.println("Your " + p.getPC().get(num - 1).getName() + " now has " + p.getPC().get(num - 1).getSpecialDefenseEV() + " Special Defense EVs.");
							System.out.println();
						}
					}
				}
			}
		}
		if (typePoints.equals("Tier 2 Points")) {
			System.out.println("You have " + p.getTier2() + " Tier 2 Points.");
			System.out.println("Your " + p.getPC().get(num - 1).getName() + " has " + p.getPC().get(num - 1).getSpecialDefenseEV() + " Special Defense EVs.");
			System.out.println("How many points would you like to invest?");
			System.out.println();
			while (!invested) {
				String temp = input.nextLine();
				if (!isNumeric(temp)) {
					System.out.println();
					System.out.println("Input does not match an available choice, please input a valid choice.");
					System.out.println();
				} else {
					int tempNum = Integer.parseInt(temp);
					if (tempNum < 0 || (tempNum + p.getPC().get(num - 1).getSpecialDefenseEV()) > 252  || (tempNum + p.getPC().get(num - 1).getHealthEV() + p.getPC().get(num - 1).getAttackEV() + p.getPC().get(num - 1).getDefenseEV() + p.getPC().get(num - 1).getSpecialAttackEV() + p.getPC().get(num - 1).getSpecialDefenseEV() + p.getPC().get(num - 1).getSpeedEV()) > 508) {
						System.out.println();
						System.out.println("The number you have entered is either negative or would make the EV greater than 252 or would make this Pokemon have more than 508 total EVs.  Please input a valid choice.");
						System.out.println();
					} else {
						if (tempNum > p.getTier2()) {
							System.out.println();
							System.out.println("You have less points than the number you entered.  Please input a valid choice.");
							System.out.println();
						} else {
							System.out.println();
							p.getPC().get(num - 1).addSpecialDefenseEV(tempNum);
							p.spendTier2(tempNum);
							invested = true;
							System.out.println("Your " + p.getPC().get(num - 1).getName() + " now has " + p.getPC().get(num - 1).getSpecialDefenseEV() + " Special Defense EVs.");
							System.out.println();
						}
					}
				}
			}
		}
		if (typePoints.equals("Tier 3 Points")) {
			System.out.println("You have " + p.getTier3() + " Tier 3 Points.");
			System.out.println("Your " + p.getPC().get(num - 1).getName() + " has " + p.getPC().get(num - 1).getSpecialDefenseEV() + " Special Defense EVs.");
			System.out.println("How many points would you like to invest?");
			System.out.println();
			while (!invested) {
				String temp = input.nextLine();
				if (!isNumeric(temp)) {
					System.out.println();
					System.out.println("Input does not match an available choice, please input a valid choice.");
					System.out.println();
				} else {
					int tempNum = Integer.parseInt(temp);
					if (tempNum < 0 || (tempNum + p.getPC().get(num - 1).getSpecialDefenseEV()) > 252  || (tempNum + p.getPC().get(num - 1).getHealthEV() + p.getPC().get(num - 1).getAttackEV() + p.getPC().get(num - 1).getDefenseEV() + p.getPC().get(num - 1).getSpecialAttackEV() + p.getPC().get(num - 1).getSpecialDefenseEV() + p.getPC().get(num - 1).getSpeedEV()) > 508) {
						System.out.println();
						System.out.println("The number you have entered is either negative or would make the EV greater than 252 or would make this Pokemon have more than 508 total EVs.  Please input a valid choice.");
						System.out.println();
					} else {
						if (tempNum > p.getTier3()) {
							System.out.println();
							System.out.println("You have less points than the number you entered.  Please input a valid choice.");
							System.out.println();
						} else {
							System.out.println();
							p.getPC().get(num - 1).addSpecialDefenseEV(tempNum);
							p.spendTier3(tempNum);
							invested = true;
							System.out.println("Your " + p.getPC().get(num - 1).getName() + " now has " + p.getPC().get(num - 1).getSpecialDefenseEV() + " Special Defense EVs.");
							System.out.println();
						}
					}
				}
			}
		}
		if (typePoints.equals("Tier 4 Points")) {
			System.out.println("You have " + p.getTier4() + " Tier 4 Points.");
			System.out.println("Your " + p.getPC().get(num - 1).getName() + " has " + p.getPC().get(num - 1).getSpecialDefenseEV() + " Special Defense EVs.");
			System.out.println("How many points would you like to invest?");
			System.out.println();
			while (!invested) {
				String temp = input.nextLine();
				if (!isNumeric(temp)) {
					System.out.println();
					System.out.println("Input does not match an available choice, please input a valid choice.");
					System.out.println();
				} else {
					int tempNum = Integer.parseInt(temp);
					if (tempNum < 0 || (tempNum + p.getPC().get(num - 1).getSpecialDefenseEV()) > 252  || (tempNum + p.getPC().get(num - 1).getHealthEV() + p.getPC().get(num - 1).getAttackEV() + p.getPC().get(num - 1).getDefenseEV() + p.getPC().get(num - 1).getSpecialAttackEV() + p.getPC().get(num - 1).getSpecialDefenseEV() + p.getPC().get(num - 1).getSpeedEV()) > 508) {
						System.out.println();
						System.out.println("The number you have entered is either negative or would make the EV greater than 252 or would make this Pokemon have more than 508 total EVs.  Please input a valid choice.");
						System.out.println();
					} else {
						if (tempNum > p.getTier4()) {
							System.out.println();
							System.out.println("You have less points than the number you entered.  Please input a valid choice.");
							System.out.println();
						} else {
							System.out.println();
							p.getPC().get(num - 1).addSpecialDefenseEV(tempNum);
							p.spendTier4(tempNum);
							invested = true;
							System.out.println("Your " + p.getPC().get(num - 1).getName() + " now has " + p.getPC().get(num - 1).getSpecialDefenseEV() + " Special Defense EVs.");
							System.out.println();
						}
					}
				}
			}
		}
		if (typePoints.equals("Tier 5 Points")) {
			System.out.println("You have " + p.getTier5() + " Tier 5 Points.");
			System.out.println("Your " + p.getPC().get(num - 1).getName() + " has " + p.getPC().get(num - 1).getSpecialDefenseEV() + " Special Defense EVs.");
			System.out.println("How many points would you like to invest?");
			System.out.println();
			while (!invested) {
				String temp = input.nextLine();
				if (!isNumeric(temp)) {
					System.out.println();
					System.out.println("Input does not match an available choice, please input a valid choice.");
					System.out.println();
				} else {
					int tempNum = Integer.parseInt(temp);
					if (tempNum < 0 || (tempNum + p.getPC().get(num - 1).getSpecialDefenseEV()) > 252  || (tempNum + p.getPC().get(num - 1).getHealthEV() + p.getPC().get(num - 1).getAttackEV() + p.getPC().get(num - 1).getDefenseEV() + p.getPC().get(num - 1).getSpecialAttackEV() + p.getPC().get(num - 1).getSpecialDefenseEV() + p.getPC().get(num - 1).getSpeedEV()) > 508) {
						System.out.println();
						System.out.println("The number you have entered is either negative or would make the EV greater than 252 or would make this Pokemon have more than 508 total EVs.  Please input a valid choice.");
						System.out.println();
					} else {
						if (tempNum > p.getTier5()) {
							System.out.println();
							System.out.println("You have less points than the number you entered.  Please input a valid choice.");
							System.out.println();
						} else {
							System.out.println();
							p.getPC().get(num - 1).addSpecialDefenseEV(tempNum);
							p.spendTier5(tempNum);
							invested = true;
							System.out.println("Your " + p.getPC().get(num - 1).getName() + " now has " + p.getPC().get(num - 1).getSpecialDefenseEV() + " Special Defense EVs.");
							System.out.println();
						}
					}
				}
			}
		}
	}

	private static void trainSpeedEV(Player p, Scanner input, int num) {
		String typePoints = chooseTypePoints(p, num);
		System.out.println("Each EV Point costs 1 " + typePoints.substring(0, typePoints.length() - 1));
		System.out.println("You can invest a maximum of 252 points into one stat, and a maximum of 508 points into one Pokemon.");
		boolean invested = false;
		if (typePoints.equals("Tier 1 Points")) {
			System.out.println("You have " + p.getTier1() + " Tier 1 Points.");
			System.out.println("Your " + p.getPC().get(num - 1).getName() + " has " + p.getPC().get(num - 1).getSpeedEV() + " Speed EVs.");
			System.out.println("How many points would you like to invest?");
			System.out.println();
			while (!invested) {
				String temp = input.nextLine();
				if (!isNumeric(temp)) {
					System.out.println();
					System.out.println("Input does not match an available choice, please input a valid choice.");
					System.out.println();
				} else {
					int tempNum = Integer.parseInt(temp);
					if (tempNum < 0 || (tempNum + p.getPC().get(num - 1).getSpeedEV()) > 252  || (tempNum + p.getPC().get(num - 1).getHealthEV() + p.getPC().get(num - 1).getAttackEV() + p.getPC().get(num - 1).getDefenseEV() + p.getPC().get(num - 1).getSpecialAttackEV() + p.getPC().get(num - 1).getSpecialDefenseEV() + p.getPC().get(num - 1).getSpeedEV()) > 508) {
						System.out.println();
						System.out.println("The number you have entered is either negative or would make the EV greater than 252 or would make this Pokemon have more than 508 total EVs.  Please input a valid choice.");
						System.out.println();
					} else {
						if (tempNum > p.getTier1()) {
							System.out.println();
							System.out.println("You have less points than the number you entered.  Please input a valid choice.");
							System.out.println();
						} else {
							System.out.println();
							p.getPC().get(num - 1).addSpeedEV(tempNum);
							p.spendTier1(tempNum);
							invested = true;
							System.out.println("Your " + p.getPC().get(num - 1).getName() + " now has " + p.getPC().get(num - 1).getSpeedEV() + " Speed EVs.");
							System.out.println();
						}
					}
				}
			}
		}
		if (typePoints.equals("Tier 2 Points")) {
			System.out.println("You have " + p.getTier2() + " Tier 2 Points.");
			System.out.println("Your " + p.getPC().get(num - 1).getName() + " has " + p.getPC().get(num - 1).getSpeedEV() + " Speed EVs.");
			System.out.println("How many points would you like to invest?");
			System.out.println();
			while (!invested) {
				String temp = input.nextLine();
				if (!isNumeric(temp)) {
					System.out.println();
					System.out.println("Input does not match an available choice, please input a valid choice.");
					System.out.println();
				} else {
					int tempNum = Integer.parseInt(temp);
					if (tempNum < 0 || (tempNum + p.getPC().get(num - 1).getSpeedEV()) > 252  || (tempNum + p.getPC().get(num - 1).getHealthEV() + p.getPC().get(num - 1).getAttackEV() + p.getPC().get(num - 1).getDefenseEV() + p.getPC().get(num - 1).getSpecialAttackEV() + p.getPC().get(num - 1).getSpecialDefenseEV() + p.getPC().get(num - 1).getSpeedEV()) > 508) {
						System.out.println();
						System.out.println("The number you have entered is either negative or would make the EV greater than 252 or would make this Pokemon have more than 508 total EVs.  Please input a valid choice.");
						System.out.println();
					} else {
						if (tempNum > p.getTier2()) {
							System.out.println();
							System.out.println("You have less points than the number you entered.  Please input a valid choice.");
							System.out.println();
						} else {
							System.out.println();
							p.getPC().get(num - 1).addSpeedEV(tempNum);
							p.spendTier2(tempNum);
							invested = true;
							System.out.println("Your " + p.getPC().get(num - 1).getName() + " now has " + p.getPC().get(num - 1).getSpeedEV() + " Speed EVs.");
							System.out.println();
						}
					}
				}
			}
		}
		if (typePoints.equals("Tier 3 Points")) {
			System.out.println("You have " + p.getTier3() + " Tier 3 Points.");
			System.out.println("Your " + p.getPC().get(num - 1).getName() + " has " + p.getPC().get(num - 1).getSpeedEV() + " Speed EVs.");
			System.out.println("How many points would you like to invest?");
			System.out.println();
			while (!invested) {
				String temp = input.nextLine();
				if (!isNumeric(temp)) {
					System.out.println();
					System.out.println("Input does not match an available choice, please input a valid choice.");
					System.out.println();
				} else {
					int tempNum = Integer.parseInt(temp);
					if (tempNum < 0 || (tempNum + p.getPC().get(num - 1).getSpeedEV()) > 252  || (tempNum + p.getPC().get(num - 1).getHealthEV() + p.getPC().get(num - 1).getAttackEV() + p.getPC().get(num - 1).getDefenseEV() + p.getPC().get(num - 1).getSpecialAttackEV() + p.getPC().get(num - 1).getSpecialDefenseEV() + p.getPC().get(num - 1).getSpeedEV()) > 508) {
						System.out.println();
						System.out.println("The number you have entered is either negative or would make the EV greater than 252 or would make this Pokemon have more than 508 total EVs.  Please input a valid choice.");
						System.out.println();
					} else {
						if (tempNum > p.getTier3()) {
							System.out.println();
							System.out.println("You have less points than the number you entered.  Please input a valid choice.");
							System.out.println();
						} else {
							System.out.println();
							p.getPC().get(num - 1).addSpeedEV(tempNum);
							p.spendTier3(tempNum);
							invested = true;
							System.out.println("Your " + p.getPC().get(num - 1).getName() + " now has " + p.getPC().get(num - 1).getSpeedEV() + " Speed EVs.");
							System.out.println();
						}
					}
				}
			}
		}
		if (typePoints.equals("Tier 4 Points")) {
			System.out.println("You have " + p.getTier4() + " Tier 4 Points.");
			System.out.println("Your " + p.getPC().get(num - 1).getName() + " has " + p.getPC().get(num - 1).getSpeedEV() + " Speed EVs.");
			System.out.println("How many points would you like to invest?");
			System.out.println();
			while (!invested) {
				String temp = input.nextLine();
				if (!isNumeric(temp)) {
					System.out.println();
					System.out.println("Input does not match an available choice, please input a valid choice.");
					System.out.println();
				} else {
					int tempNum = Integer.parseInt(temp);
					if (tempNum < 0 || (tempNum + p.getPC().get(num - 1).getSpeedEV()) > 252  || (tempNum + p.getPC().get(num - 1).getHealthEV() + p.getPC().get(num - 1).getAttackEV() + p.getPC().get(num - 1).getDefenseEV() + p.getPC().get(num - 1).getSpecialAttackEV() + p.getPC().get(num - 1).getSpecialDefenseEV() + p.getPC().get(num - 1).getSpeedEV()) > 508) {
						System.out.println();
						System.out.println("The number you have entered is either negative or would make the EV greater than 252 or would make this Pokemon have more than 508 total EVs.  Please input a valid choice.");
						System.out.println();
					} else {
						if (tempNum > p.getTier4()) {
							System.out.println();
							System.out.println("You have less points than the number you entered.  Please input a valid choice.");
							System.out.println();
						} else {
							System.out.println();
							p.getPC().get(num - 1).addSpeedEV(tempNum);
							p.spendTier4(tempNum);
							invested = true;
							System.out.println("Your " + p.getPC().get(num - 1).getName() + " now has " + p.getPC().get(num - 1).getSpeedEV() + " Speed EVs.");
							System.out.println();
						}
					}
				}
			}
		}
		if (typePoints.equals("Tier 5 Points")) {
			System.out.println("You have " + p.getTier5() + " Tier 5 Points.");
			System.out.println("Your " + p.getPC().get(num - 1).getName() + " has " + p.getPC().get(num - 1).getSpeedEV() + " Speed EVs.");
			System.out.println("How many points would you like to invest?");
			System.out.println();
			while (!invested) {
				String temp = input.nextLine();
				if (!isNumeric(temp)) {
					System.out.println();
					System.out.println("Input does not match an available choice, please input a valid choice.");
					System.out.println();
				} else {
					int tempNum = Integer.parseInt(temp);
					if (tempNum < 0 || (tempNum + p.getPC().get(num - 1).getSpeedEV()) > 252  || (tempNum + p.getPC().get(num - 1).getHealthEV() + p.getPC().get(num - 1).getAttackEV() + p.getPC().get(num - 1).getDefenseEV() + p.getPC().get(num - 1).getSpecialAttackEV() + p.getPC().get(num - 1).getSpecialDefenseEV() + p.getPC().get(num - 1).getSpeedEV()) > 508) {
						System.out.println();
						System.out.println("The number you have entered is either negative or would make the EV greater than 252 or would make this Pokemon have more than 508 total EVs.  Please input a valid choice.");
						System.out.println();
					} else {
						if (tempNum > p.getTier5()) {
							System.out.println();
							System.out.println("You have less points than the number you entered.  Please input a valid choice.");
							System.out.println();
						} else {
							System.out.println();
							p.getPC().get(num - 1).addSpeedEV(tempNum);
							p.spendTier5(tempNum);
							invested = true;
							System.out.println("Your " + p.getPC().get(num - 1).getName() + " now has " + p.getPC().get(num - 1).getSpeedEV() + " Speed EVs.");
							System.out.println();
						}
					}
				}
			}
		}
	}

	private static void resetEVs(Player p, Scanner input) {
		boolean done = false;
		while (!done) {
			printOwnedPokemon(p);
			System.out.println("Choose a Pokemon whose EVs you would like to reset.");
			System.out.println("NOTE: YOU WILL NOT BE REFUNDED THE POINTS SPENT IN GETTING THE RESET EVS");
			System.out.println("Enter the number corresponding to a Pokemon in your PC or enter \"0\" to go back to the main menu.");
			System.out.println();
			String temp = input.nextLine();
			if (!isNumeric(temp)) {
				System.out.println();
				System.out.println("Input does not match an available choice.");
				System.out.println();
			} else {
				int num = Integer.parseInt(temp);
				if (num < 0 || num >= p.getPC().size() + 1) {
					System.out.println();
					System.out.println("Input does not match an available choice.");
					System.out.println();
				} else {
					if (num != 0) {
						System.out.println();
						System.out.println("Your " + p.getPC().get(num - 1).getName() + "'s EVs:");
						System.out.println("Health EV: " + p.getPC().get(num - 1).getHealthEV());
						System.out.println("Attack EV: " + p.getPC().get(num - 1).getAttackEV());
						System.out.println("Defense EV: " + p.getPC().get(num - 1).getDefenseEV());
						System.out.println("Special Attack EV: " + p.getPC().get(num - 1).getSpecialAttackEV());
						System.out.println("Special Defense EV: " + p.getPC().get(num - 1).getSpecialDefenseEV());
						System.out.println("Speed EV: " + p.getPC().get(num - 1).getSpeedEV());
						System.out.println();
						boolean finished = false;
						while (!finished) {
							System.out.println("Would you like to reset " + p.getPC().get(num - 1).getName() + "'s EVs?");
							System.out.println();
							System.out.println("1) Yes");
							System.out.println("2) No");
							System.out.println();
							if (input.hasNext())
								switch (input.nextLine()) {
								case "1":
									System.out.println();
									p.getPC().get(num - 1).resetEVs();
									System.out.println("Your " + p.getPC().get(num - 1).getName() + "'s EVs have been reset.");
									System.out.println();
									finished = true;
									break;
								case "2":
									System.out.println();
									finished = true;
									break;
								default:
									System.out.println();
									System.out.println("Input does not match an available choice.");
									System.out.println();
								}
						}
						System.out.println();
						boolean repeat = false;
						while (!repeat) {
							System.out.println("Would you like to reset another Pokemon's EVs?");
							System.out.println("1) Yes");
							System.out.println("2) No");
							System.out.println();
							if (input.hasNext())
								switch (input.nextLine()) {
								case "1":
									System.out.println();
									repeat = true;
									break;
								case "2":
									System.out.println();
									done = true;
									repeat = true;
									break;
								default:
									System.out.println();
									System.out.println("Input does not match an available choice.");
									System.out.println();
								}
						}
					} else {
						System.out.println();
					}
				}
			}
		}
	}



	private static void changeNature(Player p, Scanner input) {
		boolean done = false;
		while (!done) {
			printOwnedPokemon(p);
			System.out.println("Choose the pokemon whose nature you want to change.");
			System.out.println("Enter the number corresponding to a Pokemon in your PC or enter \"0\" to go back to the main menu.");
			System.out.println();
			String temp = input.nextLine();
			if (!isNumeric(temp)) {
				System.out.println();
				System.out.println("Input does not match an available choice.");
				System.out.println();
			} else {
				int num = Integer.parseInt(temp);
				if (num < 0 || num >= p.getPC().size() + 1) {
					System.out.println();
					System.out.println("Input does not match an available choice.");
					System.out.println();
				} else {
					if (num != 0) {
						String typePoints = chooseTypePoints(p, num);
						boolean enough = true;
						switch (typePoints) {
						case "Tier 1 Points":
							if (p.getTier1() < 100)
								enough = false;
							break;
						case "Tier 2 Points":
							if (p.getTier2() < 100)
								enough = false;
							break;
						case "Tier 3 Points":
							if (p.getTier3() < 100)
								enough = false;
							break;
						case "Tier 4 Points":
							if (p.getTier4() < 100)
								enough = false;
							break;
						case "Tier 5 Points":
							if (p.getTier5() < 100)
								enough = false;
							break;
						}
						if (enough) {
							System.out.println();
							System.out.println("Changing this Pokemon's nature costs 100 " + typePoints);
							System.out.println("Which nature would you like this Pokemon to have?");
							System.out.println("1) Hardy");
							System.out.println("2) Lonely");
							System.out.println("3) Brave");
							System.out.println("4) Adamant");
							System.out.println("5) Naughty");
							System.out.println("6) Bold");
							System.out.println("7) Docile");
							System.out.println("8) Relaxed");
							System.out.println("9) Impish");
							System.out.println("10) Lax");
							System.out.println("11) Timid");
							System.out.println("12) Hasty");
							System.out.println("13) Serious");
							System.out.println("14) Jolly");
							System.out.println("15) Naive");
							System.out.println("16) Modest");
							System.out.println("17) Mild");
							System.out.println("18) Quiet");
							System.out.println("19) Bashful");
							System.out.println("20) Rash");
							System.out.println("21) Calm");
							System.out.println("22) Gentle");
							System.out.println("23) Sassy");
							System.out.println("24) Careful");
							System.out.println("25) Quirky");
							System.out.println("Enter \"0\" to go back to the main menu.");
							System.out.println();
							boolean finished = false;
							while (!finished) {
								if (input.hasNext())
									switch(input.nextLine()) {
									case "1":
										changeNatureHelper(p, num, input, typePoints, "Hardy");
										done = true;
										finished = true;
										break;
									case "2":
										changeNatureHelper(p, num, input, typePoints, "Lonely");
										done = true;
										finished = true;
										break;
									case "3":
										changeNatureHelper(p, num, input, typePoints, "Brave");
										done = true;
										finished = true;
										break;
									case "4":
										changeNatureHelper(p, num, input, typePoints, "Adamant");
										done = true;
										finished = true;
										break;
									case "5":
										changeNatureHelper(p, num, input, typePoints, "Naughty");
										done = true;
										finished = true;
										break;
									case "6":
										changeNatureHelper(p, num, input, typePoints, "Bold");
										done = true;
										finished = true;
										break;
									case "7":
										changeNatureHelper(p, num, input, typePoints, "Docile");
										done = true;
										finished = true;
										break;
									case "8":
										changeNatureHelper(p, num, input, typePoints, "Relaxed");
										done = true;
										finished = true;
										break;
									case "9":
										changeNatureHelper(p, num, input, typePoints, "Impish");
										done = true;
										finished = true;
										break;
									case "10":
										changeNatureHelper(p, num, input, typePoints, "Lax");
										done = true;
										finished = true;
										break;
									case "11":
										changeNatureHelper(p, num, input, typePoints, "Timid");
										done = true;
										finished = true;
										break;
									case "12":
										changeNatureHelper(p, num, input, typePoints, "Hasty");
										done = true;
										finished = true;
										break;
									case "13":
										changeNatureHelper(p, num, input, typePoints, "Serious");
										done = true;
										finished = true;
										break;
									case "14":
										changeNatureHelper(p, num, input, typePoints, "Jolly");
										done = true;
										finished = true;
										break;
									case "15":
										changeNatureHelper(p, num, input, typePoints, "Naive");
										done = true;
										finished = true;
										break;
									case "16":
										changeNatureHelper(p, num, input, typePoints, "Modest");
										done = true;
										finished = true;
										break;
									case "17":
										changeNatureHelper(p, num, input, typePoints, "Mild");
										done = true;
										finished = true;
										break;
									case "18":
										changeNatureHelper(p, num, input, typePoints, "Quiet");
										done = true;
										finished = true;
										break;
									case "19":
										changeNatureHelper(p, num, input, typePoints, "Bashful");
										done = true;
										finished = true;
										break;
									case "20":
										changeNatureHelper(p, num, input, typePoints, "Rash");
										done = true;
										finished = true;
										break;
									case "21":
										changeNatureHelper(p, num, input, typePoints, "Calm");
										done = true;
										finished = true;
										break;
									case "22":
										changeNatureHelper(p, num, input, typePoints, "Gentle");
										done = true;
										finished = true;
										break;
									case "23":
										changeNatureHelper(p, num, input, typePoints, "Sassy");
										done = true;
										finished = true;
										break;
									case "24":
										changeNatureHelper(p, num, input, typePoints, "Careful");
										done = true;
										finished = true;
										break;
									case "25":
										changeNatureHelper(p, num, input, typePoints, "Quirky");
										done = true;
										finished = true;
										break;
									case "0":
										System.out.println();
										done = true;
										finished = true;
										break;
									default:
										System.out.println();
										System.out.println("Input does not match an available choice.");
										System.out.println();
									}
							}
						} else {
							System.out.println();
							System.out.println("Changing this Pokemon's nature costs 100 " + typePoints);
							System.out.println("You do not have enough " + typePoints + " to change this Pokemon's nature");
							System.out.println();
							done = true;
						}
					} else {
						System.out.println();
						done = true;
					}
				}
			}
		}
	}

	private static void changeNatureHelper(Player p, int num, Scanner input, String typePoints, String nature) {
		if (p.getPC().get(num - 1).getNature().equals(nature)) {
			System.out.println();
			System.out.println("This Pokemon already has the nature you selected.");
			System.out.println();
		} else {
			if (typePoints.equals("Tier 1 Points")) {
				System.out.println();
				p.getPC().get(num - 1).setNature(nature);
				p.spendTier1(100);
				System.out.println("Your " + p.getPC().get(num - 1).getName() + " now has a " + nature + " nature.");
			}
			if (typePoints.equals("Tier 2 Points")) {
				System.out.println();
				p.getPC().get(num - 1).setNature(nature);
				p.spendTier2(100);
				System.out.println("Your " + p.getPC().get(num - 1).getName() + " now has a " + nature + " nature.");
				System.out.println();
			}
			if (typePoints.equals("Tier 3 Points")) {
				System.out.println();
				p.getPC().get(num - 1).setNature(nature);
				p.spendTier3(100);
				System.out.println("Your " + p.getPC().get(num - 1).getName() + " now has a " + nature + " nature.");
				System.out.println();
			}
			if (typePoints.equals("Tier 4 Points")) {
				System.out.println();
				p.getPC().get(num - 1).setNature(nature);
				p.spendTier4(100);
				System.out.println("Your " + p.getPC().get(num - 1).getName() + " now has a " + nature + " nature.");
				System.out.println();
			}
			if (typePoints.equals("Tier 5 Points")) {
				System.out.println();
				p.getPC().get(num - 1).setNature(nature);
				p.spendTier5(100);
				System.out.println("Your " + p.getPC().get(num - 1).getName() + " now has a " + nature + " nature.");
				System.out.println();
			}
		}
	}

	private static void recycle(Player p, Scanner input) {
		boolean done = false;
		boolean first = true;
		String temp;
		while (!done) {
			printOwnedPokemon(p);
			System.out.println("Choose a Pokemon to recycle.");
			System.out.println("Enter the number corresponding to a Pokemon in your PC or enter \"0\" to go back to the main menu.");
			System.out.println();
			if (first) {
				temp = input.nextLine();
				temp = input.nextLine();
				first = false;
			} else 
				temp = input.nextLine();
			if (!isNumeric(temp)) {
				System.out.println();
				System.out.println("Input does not match an available choice.");
				System.out.println();
			} else {
				int num = Integer.parseInt(temp);
				if (num < 0 || num >= p.getPC().size() + 1) {
					System.out.println();
					System.out.println("Input does not match an available choice.");
					System.out.println();
				} else {
					if (num != 0) {
						System.out.println();
						System.out.println(p.getPC().get(num - 1));
						System.out.println();
						int numPoints = roundProperlyRecyclePoints(p.getPC().get(num - 1).getTotalIVPercentage()/10);
						String typePoints = chooseTypePoints(p, num);
						boolean finished = false;
						while (!finished) {
							System.out.println("Are you sure you would like to recycle this pokemon?  You will receive " + numPoints + " " + typePoints);
							System.out.println();
							System.out.println("Input the number corresponding to your choice:");
							System.out.println("1) Yes");
							System.out.println("2) No");
							System.out.println();
							if (input.hasNext())
								switch (input.nextLine()) {
								case "1":
									System.out.println();
									if (typePoints.equals("Tier 1 Points")) {
										p.addTier1(numPoints);
										System.out.println("You now have " + p.getTier1() + " Tier 1 Points.");
									}
									if (typePoints.equals("Tier 2 Points")) {
										p.addTier2(numPoints);
										System.out.println("You now have " + p.getTier2() + " Tier 2 Points.");
									}
									if (typePoints.equals("Tier 3 Points")) {
										p.addTier3(numPoints);
										System.out.println("You now have " + p.getTier3() + " Tier 3 Points.");
									}
									if (typePoints.equals("Tier 4 Points")) {
										p.addTier4(numPoints);
										System.out.println("You now have " + p.getTier4() + " Tier 4 Points.");
									}
									if (typePoints.equals("Tier 5 Points")) {
										p.addTier5(numPoints);
										System.out.println("You now have " + p.getTier5() + " Tier 5 Points.");
									}
									p.getPC().remove(num - 1);
									System.out.println();
									finished = true;
									break;
								case "2":
									System.out.println();
									finished = true;
									break;
								default:
									System.out.println();
									System.out.println("Input does not match an available choice.");
									System.out.println();
								}
						}
						boolean repeat = false;
						while (!repeat) {
							System.out.println("Would you like to choose another Pokemon to recycle?");
							System.out.println("1) Yes");
							System.out.println("2) No");
							System.out.println();
							if (input.hasNext())
								switch (input.nextLine()) {
								case "1":
									System.out.println();
									repeat = true;
									break;
								case "2":
									System.out.println();
									done = true;
									repeat = true;
									break;
								default:
									System.out.println();
									System.out.println("Input does not match an available choice.");
									System.out.println();
								}
						}
					} else {
						System.out.println();
						done = true;
					}
				}
			}
		}
	}

	private static String chooseTypePoints(Player p, int num) {
		if (p.getPC().get(num - 1).getPokemon().getSpawnRate() <= 11)
			return "Tier 1 Points";
		if (p.getPC().get(num - 1).getPokemon().getSpawnRate() <= 17 && p.getPC().get(num - 1).getPokemon().getSpawnRate() > 11)
			return "Tier 2 Points";
		if (p.getPC().get(num - 1).getPokemon().getSpawnRate() <= 22 && p.getPC().get(num - 1).getPokemon().getSpawnRate() > 17)
			return "Tier 3 Points";
		if (p.getPC().get(num - 1).getPokemon().getSpawnRate() <= 28 && p.getPC().get(num - 1).getPokemon().getSpawnRate() > 22)
			return "Tier 4 Points";
		return "Tier 5 Points";
	}

	private static int roundProperlyRecyclePoints(double d) {
		if (d >= 0.5 && d < 1.5) {
			return 1;
		}
		if (d >= 1.5 && d < 2.5) {
			return 2;
		}
		if (d >= 2.5 && d < 3.5) {
			return 3;
		}
		if (d >= 3.5 && d < 4.5) {
			return 4;
		}
		if (d >= 4.5 && d < 5.5) {
			return 5;
		}
		if (d >= 5.5 && d < 6.5) {
			return 6;
		}
		if (d >= 6.5 && d < 7.5) {
			return 7;
		}
		if (d >= 7.5 && d < 8.5) {
			return 8;
		}
		if (d >= 8.5 && d < 9.5) {
			return 9;
		}
		if (d > 9.5) {
			return 10;
		}
		return 1;
	}

	private static void printPlayerData(Player p) {
		System.out.println(p);
	}

}