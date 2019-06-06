import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		ArrayList<Pokemon> pokedex = new ArrayList<>();
		// fill pokedex with all pokemon
		fillPossibilities(pokedex);
		boolean finished = false;
		Player p = new Player();
		while(!finished) {
			System.out.println("Would you like to access a new save or a old save?");
			System.out.println("1) New");
			System.out.println("2) Old");
			System.out.println();
			switch(input.nextLine()){
			case "1":
				// if the user chooses to load a new save, just keep the preinitialized new player object and set finished to true
				finished = true;
				System.out.println();
				break;
			case "2":
				// if the user chooses to load an old save, attempt to access the saves.ser file where player data is saved
				// if the file exists, set the player object to the one read from the file
				// if the file does not exist, just keep the preinitialized new player object
				// set finished to true when done
				finished = true;
				try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("saves.ser"));){
					p = (Player) ois.readObject();
					ois.close();
				} catch (Exception e) {

				}
				System.out.println();
				break;
			default:
				System.out.println();
				System.out.println("Input does not match an available choice.");
				System.out.println();
			}
		}
		int[] spawnRateCounter = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		// there are currently 33 different spawn rates, and thus 33 different indexes in the array, one for each spawn rate.
		// this will be further explained in the search method
		finished = false;
		// reset finished to false
		//		p.catchPokemon(new OwnedPokemon(pokedex.get(28)));
		//		p.catchPokemon(new OwnedPokemon(pokedex.get(132)));
		//		p.addTier1(600);
		while(!finished) {
			// while not finished, prompt user what action they would like to take.  User is not finished until they quit
			System.out.println("Input the number corresponding to your choice:");
			System.out.println("1) Search for Pokemon");
			System.out.println("2) View/Edit Owned Pokemon");
			System.out.println("3) Sort PC");
			System.out.println("4) Breed Pokemon");
			System.out.println("5) Train Pokemon");
			System.out.println("6) Recycle Pokemon");
			System.out.println("7) Convert Points");
			System.out.println("8) View Player Data");
			System.out.println("9) Save");
			System.out.println("10) Save Quit");
			System.out.println("0) Quit");
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
				sortPC(p, input);
				break;
			case "4":
				System.out.println();
				breed(p, input, pokedex);
				break;
			case "5":
				System.out.println();
				training(p, input, pokedex);
				break;
			case "6":
				System.out.println();
				recycle(p, input);
				break;
			case "7":
				System.out.println();
				convertPoints(p, input);
				break;
			case "8":
				System.out.println();
				printPlayerData(p);
				break;
			case "9":
				System.out.println();
				System.out.println("Saving ...");
				System.out.println();
				save(p);
				break;
			case "10":
				finished = true;
				System.out.println();
				System.out.println("Saving and Quitting ...");
				save(p);
				break;
			case "0":
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
		// add every pokemon to the pokedex
		pokedex.add(new Pokemon("Bulbasaur", "Grass", "Poison", 45, 49, 49, 65, 65, 45, 27, new String[] {"Monster", "Grass"}, 87.5, new String[] {"Bulbasaur", "Ivysaur", "Venusaur"}, 0, 16));
		pokedex.add(new Pokemon("Ivysaur", "Grass", "Poison", 60, 62, 63, 80, 80, 60, 27, new String[] {"Monster", "Grass"}, 87.5, new String[] {"Bulbasaur", "Ivysaur", "Venusaur"}, 1, 32));
		pokedex.add(new Pokemon("Venusaur", "Grass", "Poison", 80, 82, 83, 100, 100, 80, 27, new String[] {"Monster", "Grass"}, 87.5, new String[] {"Bulbasaur", "Ivysaur", "Venusaur"}, 2, 0));
		pokedex.add(new Pokemon("Charmander", "Fire", null, 39, 52, 43, 60, 50, 65, 27, new String[] {"Monster", "Dragon"}, 87.5, new String[] {"Charmander", "Charmeleon", "Charizard"}, 0, 16));
		pokedex.add(new Pokemon("Charmeleon", "Fire", null, 58, 64, 58, 80, 65, 80, 27, new String[] {"Monster", "Dragon"}, 87.5, new String[] {"Charmander", "Charmeleon", "Charizard"}, 1, 36));
		pokedex.add(new Pokemon("Charizard", "Fire", "Flying", 78, 84, 78, 109, 85, 100, 27, new String[] {"Monster", "Dragon"}, 87.5, new String[] {"Charmander", "Charmeleon", "Charizard"}, 2, 0));
		pokedex.add(new Pokemon("Squirtle", "Water", null, 44, 48, 65, 50, 64, 43, 27, new String[] {"Monster", "Water 1"}, 87.5, new String[] {"Squirtle", "Wartortle", "Blastoise"}, 0, 16));
		pokedex.add(new Pokemon("Wartortle", "Water", null, 59, 63, 80, 65, 80, 58, 27, new String[] {"Monster", "Water 1"}, 87.5, new String[] {"Squirtle", "Wartortle", "Blastoise"}, 1, 36));
		pokedex.add(new Pokemon("Blastoise", "Water", null, 79, 83, 100, 85, 105, 78, 27, new String[] {"Monster", "Water 1"}, 87.5, new String[] {"Squirtle", "Wartortle", "Blastoise"}, 2, 0));
		pokedex.add(new Pokemon("Caterpie", "Bug", null, 45, 30, 35, 20, 20, 45, 0,  new String[] {"Bug"}, 50, new String[] {"Caterpie", "Metapod", "Butterfree"}, 0, 7));
		pokedex.add(new Pokemon("Metapod", "Bug", null, 50, 20, 55, 25, 25, 30, 17, new String[] {"Bug"}, 50, new String[] {"Caterpie", "Metapod", "Butterfree"}, 1, 10));
		pokedex.add(new Pokemon("Butterfree", "Bug", "Flying", 60, 45, 50, 90, 80, 70, 27, new String[] {"Bug"}, 50, new String[] {"Caterpie", "Metapod", "Butterfree"}, 2, 0));
		pokedex.add(new Pokemon("Weedle", "Bug", "Poison", 40, 35, 30, 20, 20, 50, 0, new String[] {"Bug"}, 50, new String[] {"Weedle", "Kakuna", "Beedrill"}, 0, 7));
		pokedex.add(new Pokemon("Kakuna", "Bug", "Poison", 45, 25, 50, 25, 25, 35, 17, new String[] {"Bug"}, 50, new String[] {"Weedle", "Kakuna", "Beedrill"}, 1, 10));
		pokedex.add(new Pokemon("Beedrill", "Bug", "Poison", 65, 90, 40, 45, 80, 75, 27, new String[] {"Bug"}, 50, new String[] {"Weedle", "Kakuna", "Beedrill"}, 2, 0));
		pokedex.add(new Pokemon("Pidgey", "Normal", "Flying", 40, 45, 40, 35, 35, 56, 0, new String[] {"Flying"}, 50, new String[] {"Pidgey", "Pidgeotto", "Pidgeot"}, 0, 18));
		pokedex.add(new Pokemon("Pidgeotto", "Normal", "Flying", 63, 60, 55, 50, 50, 71, 17, new String[] {"Flying"}, 50, new String[] {"Pidgey", "Pidgeotto", "Pidgeot"}, 1, 36));
		pokedex.add(new Pokemon("Pidgeot", "Normal", "Flying", 83, 80, 75, 70, 70, 101, 27, new String[] {"Flying"}, 50, new String[] {"Pidgey", "Pidgeotto", "Pidgeot"}, 2, 0));
		pokedex.add(new Pokemon("Rattata", "Normal", null, 30, 56, 35, 25, 35, 72, 0, new String[] {"Field"}, 50, new String[] {"Rattata", "Raticate"}, 0, 20));
		pokedex.add(new Pokemon("Raticate", "Normal", null, 55, 81, 60, 50, 70, 97, 15, new String[] {"Field"}, 50, new String[] {"Rattata", "Raticate"}, 1, 0));
		pokedex.add(new Pokemon("Spearow", "Normal", "Flying", 40, 60, 30, 31, 31, 70, 0, new String[] {"Flying"}, 50, new String[] {"Spearow", "Fearow"}, 0, 20));
		pokedex.add(new Pokemon("Fearow", "Normal", "Flying", 65, 90, 65, 61, 61, 100, 19, new String[] {"Flying"}, 50, new String[] {"Spearow", "Fearow"}, 1, 0));
		pokedex.add(new Pokemon("Ekans", "Poison", null, 35, 60, 44, 40, 54, 55, 0, new String[] {"Field", "Dragon"}, 50, new String[] {"Ekans", "Arbok"}, 0, 22));
		pokedex.add(new Pokemon("Arbok", "Poison", null, 60, 95, 69, 65, 79, 80, 19, new String[] {"Field", "Dragon"}, 50, new String[] {"Ekans", "Arbok"}, 1, 0));
		pokedex.add(new Pokemon("Pikachu", "Electric", null, 35, 55, 40, 50, 50, 90, 6, new String[] {"Field", "Fairy"}, 50, new String[] {"Pichu", "Pikachu", "Raichu"}, 1, -1));
		pokedex.add(new Pokemon("Raichu", "Electric", null, 60, 90, 55, 90, 80, 110, 21, new String[] {"Field", "Fairy"}, 50, new String[] {"Pichu", "Pikachu", "Raichu"}, 2, 0));
		pokedex.add(new Pokemon("Sandshrew", "Ground", null, 50, 75, 85, 20, 30, 40, 0, new String[] {"Field"}, 50, new String[] {"Sandshrew", "Sandslash"}, 0, 22));
		pokedex.add(new Pokemon("Sandslash", "Ground", null, 75, 100, 110, 45, 55, 65, 19, new String[] {"Field"}, 50, new String[] {"Sandshrew", "Sandslash"}, 1, 0));
		pokedex.add(new Pokemon("NidoranF", "Poison", null, 55, 47, 52, 40, 40, 41, 1, new String[] {"Monster", "Field"}, 0, new String[] {"NidoranF", "Nidorina", "Nidoqueen"}, 0, 16));
		pokedex.add(new Pokemon("Nidorina", "Poison", null, 70, 62, 67, 55, 55, 56, 17, new String[] {"Monster", "Water 1"}, 0, new String[] {"NidoranF", "Nidorina", "Nidoqueen"}, 1, -1));
		pokedex.add(new Pokemon("Nidoqueen", "Poison", "Ground", 90, 82, 87, 75, 85, 76, 27, new String[] {"Monster", "Water 1"}, 0, new String[] {"NidoranF", "Nidorina", "Nidoqueen"}, 2, 0));
		pokedex.add(new Pokemon("NidoranM", "Poison", null, 46, 57, 40, 40, 40, 50, 1, new String[] {"Monster", "Water 1"}, 100, new String[] {"NidoranM", "Nidorino", "Nidoking"}, 0, 16));
		pokedex.add(new Pokemon("Nidorino", "Poison", null, 61, 72, 57, 55, 55, 65, 17, new String[] {"Monster", "Water 1"}, 100, new String[] {"NidoranM", "Nidorino", "Nidoking"}, 1, -1));
		pokedex.add(new Pokemon("Nidoking", "Poison", "Ground", 81, 102, 77, 85, 75, 85, 27, new String[] {"Monster", "Water 1"}, 100, new String[] {"NidoranM", "Nidorino", "Nidoking"}, 2, 0));
		pokedex.add(new Pokemon("Clefairy", "Fairy", null, 70, 45, 48, 60, 65, 35, 11, new String[] {"Fairy"}, 25, new String[] {"Cleffa", "Clefairy", "Clefable"}, 1, -1));
		pokedex.add(new Pokemon("Clefable", "Fairy", null, 95, 70, 73, 95, 90, 60, 30, new String[] {"Fairy"}, 25, new String[] {"Cleffa", "Clefairy", "Clefable"}, 2, 0));
		pokedex.add(new Pokemon("Vulpix", "Fire", null, 39, 41, 40, 50, 65, 65, 6, new String[] {"Field"}, 25, new String[] {"Vulpix", "Ninetales"}, 0, -1));
		pokedex.add(new Pokemon("Ninetales", "Fire", null, 73, 76, 75, 81, 100, 100, 21, new String[] {"Field"}, 25, new String[] {"Vulpix", "Ninetales"}, 1, 0));
		pokedex.add(new Pokemon("Jigglypuff", "Normal", "Fairy", 115, 45, 20, 45, 25, 20, 8, new String[] {"Fairy"}, 25, new String[] {"Igglybuff", "Jigglypuff", "Wigglytuff"}, 1, -1));
		pokedex.add(new Pokemon("Wigglytuff", "Normal", "Fairy", 140, 70, 45, 85, 50, 45, 26, new String[] {"Fairy"}, 25, new String[] {"Igglybuff", "Jigglypuff", "Wigglytuff"}, 2, 0));
		pokedex.add(new Pokemon("Zubat", "Poison", "Flying", 40, 45, 35, 30, 40, 55, 0, new String[] {"Flying"}, 50, new String[] {"Zubat", "Golbat", "Crobat"}, 0, 22));
		pokedex.add(new Pokemon("Golbat", "Poison", "Flying", 75, 80, 70, 65, 75, 90, 19, new String[] {"Flying"}, 50, new String[] {"Zubat", "Golbat", "Crobat"}, 1, -1));
		pokedex.add(new Pokemon("Oddish", "Grass", "Poison", 45, 50, 55, 75, 65, 30, 0, new String[] {"Grass"}, 50, new String[] {"Oddish", "Gloom", "Vileplume", "Bellossom"}, 0, 21));
		pokedex.add(new Pokemon("Gloom", "Grass", "Poison", 60, 65, 70, 85, 75, 40, 17, new String[] {"Grass"}, 50, new String[] {"Oddish", "Gloom", "Vileplume", "Bellossom"}, 1, -1));
		pokedex.add(new Pokemon("Vileplume", "Grass", "Poison", 75, 80, 85, 110, 90, 50, 27, new String[] {"Grass"}, 50, new String[] {"Oddish", "Gloom", "Vileplume", "Bellossom"}, 2, 0));
		pokedex.add(new Pokemon("Paras", "Bug", "Grass", 35, 70, 55, 45, 55, 25, 6, new String[] {"Bug", "Grass"}, 50, new String[] {"Paras", "Parasect"}, 0, 24));
		pokedex.add(new Pokemon("Parasect", "Bug", "Grass", 60, 95, 80, 60, 80, 30, 21, new String[] {"Bug", "Grass"}, 50, new String[] {"Paras", "Parasect"}, 1, 0));
		pokedex.add(new Pokemon("Venonat", "Bug", "Poison", 60, 55, 50, 40, 55, 45, 6, new String[] {"Bug"}, 50, new String[] {"Venonat", "Venomoth"}, 0, 31));
		pokedex.add(new Pokemon("Venomoth", "Bug", "Poison", 70, 65, 60, 90, 75, 90, 21, new String[] {"Bug"}, 50, new String[] {"Venonat", "Venomoth"}, 1, 0));
		pokedex.add(new Pokemon("Diglett", "Ground", null, 10, 55, 25, 35, 45, 95, 0, new String[] {"Field"}, 50, new String[] {"Diglett", "Dugtrio"}, 0, 26));
		pokedex.add(new Pokemon("Dugtrio", "Ground", null, 35, 100, 50, 50, 70, 120, 26, new String[] {"Field"}, 50, new String[] {"Diglett", "Dugtrio"}, 1, 0));
		pokedex.add(new Pokemon("Meowth", "Normal", null, 40, 45, 35, 40, 40, 90, 0, new String[] {"Field"}, 50, new String[] {"Meowth", "Persian"}, 0, 28));
		pokedex.add(new Pokemon("Persian", "Normal", null, 65, 70, 60, 65, 65, 115, 19, new String[] {"Field"}, 50, new String[] {"Meowth", "Persian"}, 1, 0));
		pokedex.add(new Pokemon("Psyduck", "Water", null, 50, 52, 48, 65, 50, 55, 6, new String[] {"Field", "Water 1"}, 50, new String[] {"Psyduck", "Golduck"}, 0, 33));
		pokedex.add(new Pokemon("Golduck", "Water", null, 80, 82, 78, 95, 80, 85, 21, new String[] {"Field", "Water 1"}, 50, new String[] {"Psyduck", "Golduck"}, 1, 0));
		pokedex.add(new Pokemon("Mankey", "Fighting", null, 40, 80, 35, 35, 45, 70, 6, new String[] {"Field"}, 50, new String[] {"Mankey", "Primeape"}, 0, 28));
		pokedex.add(new Pokemon("Primeape", "Fighting", null, 65, 100, 60, 60, 70, 95, 21, new String[] {"Field"}, 50, new String[] {"Mankey", "Primeape"}, 1, 0));
		pokedex.add(new Pokemon("Growlithe", "Fire", null, 55, 70, 45, 70, 50, 60, 6, new String[] {"Field"}, 75, new String[] {"Growlithe", "Arcanine"}, 0, -1));
		pokedex.add(new Pokemon("Arcanine", "Fire", null, 90, 110, 80, 100, 80, 95, 21, new String[] {"Field"}, 75, new String[] {"Growlithe", "Arcanine"}, 1, 0));
		pokedex.add(new Pokemon("Poliwag", "Water", null, 40, 50, 40, 40, 40, 90, 0, new String[] {"Water 1"}, 50, new String[] {"Poliwag", "Poliwhirl", "Poliwrath", "Politoed"}, 0, 25));
		pokedex.add(new Pokemon("Poliwhirl", "Water", null, 65, 65, 65, 50, 50, 90, 17, new String[] {"Water 1"}, 50, new String[] {"Poliwag", "Poliwhirl", "Poliwrath", "Politoed"}, 1, -1));
		pokedex.add(new Pokemon("Poliwrath", "Water", "Fighting", 90, 95, 95, 70, 90, 70, 27, new String[] {"Water 1"}, 50, new String[] {"Poliwag", "Poliwhirl", "Poliwrath", "Politoed"}, 2, 0));
		pokedex.add(new Pokemon("Abra", "Psychic", null, 25, 20, 15, 105, 55, 90, 5, new String[] {"Human-Like"}, 75, new String[] {"Abra", "Kadabra", "Alakazam"}, 0, 16));
		pokedex.add(new Pokemon("Kadabra", "Psychic", null, 40, 35, 30, 120, 70, 105, 18, new String[] {"Human-Like"}, 75, new String[] {"Abra", "Kadabra", "Alakazam"}, 1, -1));
		pokedex.add(new Pokemon("Alakazam", "Psychic", null, 55, 50, 45, 135, 95, 120, 26, new String[] {"Human-Like"}, 75, new String[] {"Abra", "Kadabra", "Alakazam"}, 2, 0));
		pokedex.add(new Pokemon("Machop", "Fighting", null, 70, 80, 50, 35, 35, 35, 7, new String[] {"Human-Like"}, 75, new String[] {"Machop", "Machoke", "Machamp"}, 0, 28));
		pokedex.add(new Pokemon("Machoke", "Fighting", null, 80, 100, 70, 50, 60, 45, 19, new String[] {"Human-Like"}, 75, new String[] {"Machop", "Machoke", "Machamp"}, 1, -1));
		pokedex.add(new Pokemon("Machamp", "Fighting", null, 90, 130, 80, 65, 85, 55, 27, new String[] {"Human-Like"}, 75, new String[] {"Machop", "Machoke", "Machamp"}, 2, 0));
		pokedex.add(new Pokemon("Bellsprout", "Grass", "Poison", 50, 75, 35, 70, 30, 40, 0, new String[] {"Grass"}, 50, new String[] {"Bellsprout", "Weepinbell", "Victreebel"}, 0, 21));
		pokedex.add(new Pokemon("Weepinbell", "Grass", "Poison", 65, 90, 50, 85, 45, 55, 17, new String[] {"Grass"}, 50, new String[] {"Bellsprout", "Weepinbell", "Victreebel"}, 1, -1));
		pokedex.add(new Pokemon("Victreebel", "Grass", "Poison", 80, 105, 65, 100, 70, 70, 27, new String[] {"Grass"}, 50, new String[] {"Bellsprout", "Weepinbell", "Victreebel"}, 2, 0));
		pokedex.add(new Pokemon("Tentacool", "Water", "Poison", 40, 40, 35, 50, 100, 70, 6, new String[] {"Water 3"}, 50, new String[] {"Tentacool", "Tentacruel"}, 0, 30));
		pokedex.add(new Pokemon("Tentacruel", "Water", "Poison", 80, 70, 65, 80, 120, 100, 24, new String[] {"Water 3"}, 50, new String[] {"Tentacool", "Tentacruel"}, 1, 0));
		pokedex.add(new Pokemon("Geodude", "Rock", "Ground", 40, 80, 100, 30, 30, 20, 0, new String[] {"Mineral"}, 50, new String[] {"Geodude", "Graveler", "Golem"}, 0, 25));
		pokedex.add(new Pokemon("Graveler", "Rock", "Ground", 55, 95, 115, 45, 45, 35, 17, new String[] {"Mineral"}, 50, new String[] {"Geodude", "Graveler", "Golem"}, 1, -1));
		pokedex.add(new Pokemon("Golem", "Rock", "Ground", 80, 120, 130, 55, 65, 45, 27, new String[] {"Mineral"}, 50, new String[] {"Geodude", "Graveler", "Golem"}, 2, 0));
		pokedex.add(new Pokemon("Ponyta", "Fire", null, 50, 85, 55, 65, 65, 90, 6, new String[] {"Field"}, 50, new String[] {"Ponyta", "Rapidash"}, 0, 40));
		pokedex.add(new Pokemon("Rapidash", "Fire", null, 65, 100, 70, 80, 80, 105, 24, new String[] {"Field"}, 50, new String[] {"Ponyta", "Rapidash"}, 1, 0));
		pokedex.add(new Pokemon("Slowpoke", "Water", "Psychic", 90, 65, 65, 40, 40, 15, 6, new String[] {"Monster", "Water 1"}, 50, new String[] {"Slowpoke", "Slowbro", "Slowking"}, 0, 37));
		pokedex.add(new Pokemon("Slowbro", "Water", "Psychic", 95, 75, 110, 100, 80, 30, 21, new String[] {"Monster", "Water 1"}, 50, new String[] {"Slowpoke", "Slowbro"}, 1, 0));
		pokedex.add(new Pokemon("Magnemite", "Electric", "Steel", 25, 35, 70, 95, 55, 45, 6, new String[] {"Mineral"}, -1, new String[] {"Magnemite", "Magneton"}, 0, 30));
		pokedex.add(new Pokemon("Magneton", "Electric", "Steel", 50, 60, 95, 120, 70, 70, 24, new String[] {"Mineral"}, -1, new String[] {"Magnemite", "Magneton"}, 1, 0));
		pokedex.add(new Pokemon("Farfetch'd", "Normal", "Flying", 52, 90, 55, 58, 62, 60, 27, new String[] {"Field", "Flying"}, 50, new String[] {"Farfetch'd"}, 0, 0));
		pokedex.add(new Pokemon("Doduo", "Normal", "Flying", 35, 85, 45, 35, 35, 75, 6, new String[] {"Flying"}, 50, new String[] {"Doduo", "Dodrio"}, 0, 31));
		pokedex.add(new Pokemon("Dodrio", "Normal", "Flying", 60, 110, 70, 60, 60, 110, 27, new String[] {"Flying"}, 50, new String[] {"Doduo", "Dodrio"}, 1, 0));
		pokedex.add(new Pokemon("Seel", "Water", null, 65, 45, 55, 45, 70, 45, 6, new String[] {"Field", "Water 1"}, 50, new String[] {"Seel", "Dewgong"}, 0, 34));
		pokedex.add(new Pokemon("Dewgong", "Water", "Ice", 90, 70, 80, 70, 95, 70, 21, new String[] {"Field", "Water 1"}, 50, new String[] {"Seel", "Dewgong"}, 1, 0));
		pokedex.add(new Pokemon("Grimer", "Poison", null, 80, 80, 50, 40, 50, 25, 6, new String[] {"Amorphous"}, 50, new String[] {"Grimer", "Muk"}, 0, 38));
		pokedex.add(new Pokemon("Muk", "Poison", null, 105, 106, 75, 65, 100, 50, 21, new String[] {"Amorphous"}, 50, new String[] {"Grimer", "Muk"}, 1, 0));
		pokedex.add(new Pokemon("Shellder", "Water", null, 30, 65, 100, 45, 25, 40, 6, new String[] {"Water 3"}, 50, new String[] {"Shellder", "Cloyster"}, 0, -1));
		pokedex.add(new Pokemon("Cloyster", "Water", "Ice", 50, 95, 180, 85, 45, 70, 24, new String[] {"Water 3"}, 50, new String[] {"Shellder", "Cloyster"}, 0, 0));
		pokedex.add(new Pokemon("Gastly", "Ghost", "Poison", 30, 35, 30, 100, 35, 80, 6, new String[] {"Amorphous"}, 50, new String[] {"Gastly", "Haunter", "Gengar"}, 0, 25));
		pokedex.add(new Pokemon("Haunter", "Ghost", "Poison", 45, 50, 45, 115, 55, 95, 19, new String[] {"Amorphous"}, 50, new String[] {"Gastly", "Haunter", "Gengar"}, 1, -1));
		pokedex.add(new Pokemon("Gengar", "Ghost", "Poison", 60, 65, 60, 130, 75, 110, 27, new String[] {"Amorphous"}, 50, new String[] {"Gastly", "Haunter", "Gengar"}, 2, 0));
		pokedex.add(new Pokemon("Onix", "Rock", "Ground", 35, 45, 160, 30, 45, 70, 27, new String[] {"Mineral"}, 50, new String[] {"Onix", "Steelix"}, 0, -1));
		pokedex.add(new Pokemon("Drowzee", "Psychic", null, 60, 48, 45, 43, 90, 42, 6, new String[] {"Human-Like"}, 50, new String[] {"Drowzee", "Hypno"}, 0, 26));
		pokedex.add(new Pokemon("Hypno", "Psychic", null, 85, 73, 70, 73, 115, 67, 21, new String[] {"Human-Like"}, 50, new String[] {"Drowzee", "Hypno"}, 1, 0));
		pokedex.add(new Pokemon("Krabby", "Water", null, 30, 105, 90, 25, 25, 50, 2, new String[] {"Water 3"}, 50, new String[] {"Krabby", "Kingler"}, 0, 28));
		pokedex.add(new Pokemon("Kingler", "Water", null, 55, 130, 115, 50, 50, 75, 24, new String[] {"Water 3"}, 50, new String[] {"Krabby", "Kingler"}, 1, 0));
		pokedex.add(new Pokemon("Voltorb", "Electric", null, 40, 30, 50, 55, 55, 100, 6, new String[] {"Mineral"}, -1, new String[] {"Voltorb", "Electrode"}, 0, 30));
		pokedex.add(new Pokemon("Electrode", "Electric", null, 60, 50, 70, 80, 80, 150, 24, new String[] {"Mineral"}, -1, new String[] {"Voltorb", "Electrode"}, 1, 0));
		pokedex.add(new Pokemon("Exeggcute", "Grass", "Psychic", 60, 40, 80, 60, 45, 40, 19, new String[] {"Grass"}, 50, new String[] {"Exeggcute", "Exeggutor"}, 0, -1));
		pokedex.add(new Pokemon("Exeggutor", "Grass", "Psychic", 95, 95, 85, 125, 75, 55, 27, new String[] {"Grass"}, 50, new String[] {"Exeggcute", "Exeggutor"}, 1, 0));
		pokedex.add(new Pokemon("Cubone", "Ground", null, 50, 50, 95, 40, 50, 35, 6, new String[] {"Monster"}, 50, new String[] {"Cubone", "Marowak"}, 0, 28));
		pokedex.add(new Pokemon("Marowak", "Ground", null, 60, 80, 110, 50, 80, 45, 21, new String[] {"Monster"}, 50, new String[] {"Cubone", "Marowak"}, 1, 0));
		pokedex.add(new Pokemon("Hitmonlee", "Fighting", null, 50, 120, 53, 35, 110, 87, 27, new String[] {"Human-Like"}, 100, new String[] {"Tyrogue", "Hitmonlee"}, 1, 0));
		pokedex.add(new Pokemon("Hitmonchan", "Fighting", null, 50, 105, 79, 35, 110, 76, 27, new String[] {"Human-Like"}, 100, new String[] {"Tyrogue", "Hitmonchan"}, 1, 0));
		pokedex.add(new Pokemon("Lickitung", "Normal", null, 90, 55, 75, 60, 75, 30, 27, new String[] {"Monster"}, 50, new String[] {"Lickitung"}, 0, 0));
		pokedex.add(new Pokemon("Koffing", "Poison", null, 40, 65, 95, 60, 45, 35, 6, new String[] {"Amorphous"}, 50, new String[] {"Koffing", "Weezing"}, 0, 35));
		pokedex.add(new Pokemon("Weezing", "Poison", null, 65, 90, 120, 85, 70, 60, 24, new String[] {"Amorphous"}, 50, new String[] {"Koffing", "Weezing"}, 1, 0));
		pokedex.add(new Pokemon("Rhyhorn", "Ground", "Rock", 80, 85, 95, 30, 30, 25, 17, new String[] {"Field", "Monster"}, 50, new String[] {"Rhyhorn", "Rhydon"}, 0, 42));
		pokedex.add(new Pokemon("Rhydon", "Ground", "Rock", 105, 130, 120, 45, 45, 40, 24, new String[] {"Field", "Monster"}, 50, new String[] {"Rhyhorn", "Rhydon"}, 1, 0));
		pokedex.add(new Pokemon("Chansey", "Normal", null, 250, 5, 5, 35, 105, 50, 29, new String[] {"Fairy"}, 0, new String[] {"Chansey", "Blissey"}, 0, -1));
		pokedex.add(new Pokemon("Tangela", "Grass", null, 65, 55, 115, 100, 40, 60, 27, new String[] {"Grass"}, 50, new String[] {"Tangela"}, 0, 0));
		pokedex.add(new Pokemon("Kangaskhan", "Normal", null, 105, 95, 80, 40, 80, 90, 27, new String[] {"Monster"}, 0, new String[] {"Kangaskhan"}, 0, 0));
		pokedex.add(new Pokemon("Horsea", "Water", null, 30, 40, 70, 70, 25, 60, 2, new String[] {"Water 1", "Dragon"}, 50, new String[] {"Horsea", "Seadra", "Kingdra"}, 0, 32));
		pokedex.add(new Pokemon("Seadra", "Water", null, 55, 65, 95, 95, 45, 85, 21, new String[] {"Water 1", "Dragon"}, 50, new String[] {"Horsea", "Seadra", "Kingdra"}, 1, -1));
		pokedex.add(new Pokemon("Goldeen", "Water", null, 45, 67, 60, 35, 50, 63, 2, new String[] {"Water 2"}, 50, new String[] {"Goldeen", "Seaking"}, 0, 33));
		pokedex.add(new Pokemon("Seaking", "Water", null, 80, 92, 65, 65, 80, 68, 24, new String[] {"Water 2"}, 50, new String[] {"Goldeen", "Seaking"}, 1, 0));
		pokedex.add(new Pokemon("Staryu", "Water", null, 30, 45, 55, 70, 55, 85, 2, new String[] {"Water 3"}, -1, new String[] {"Staryu", "Starmie"}, 0, -1));
		pokedex.add(new Pokemon("Starmie", "Water", "Psychic", 60, 75, 85, 100, 85, 115, 24, new String[] {"Water 3"}, -1, new String[] {"Staryu", "Starmie"}, 1, 0));
		pokedex.add(new Pokemon("Mr. Mime", "Psychic", "Fairy", 40, 45, 65, 100, 120, 95, 27, new String[] {"Human-Like"}, 50, new String[] {"Mr. Mime"}, 0, 0));
		pokedex.add(new Pokemon("Scyther", "Bug", "Flying", 70, 110, 80, 55, 80, 105, 27, new String[] {"Bug"}, 50, new String[] {"Scyther", "Scizor"}, 0, -1));
		pokedex.add(new Pokemon("Jynx", "Ice", "Psychic", 65, 50, 35, 115, 95, 95, 27, new String[] {"Human-Like"}, 0, new String[] {"Smoochum", "Jynx"}, 1, 0));
		pokedex.add(new Pokemon("Electabuzz", "Electric", null, 65, 83, 57, 95, 85, 105, 27, new String[] {"Human-Like"}, 75, new String[] {"Elekid", "Electabuzz"}, 1, 0));
		pokedex.add(new Pokemon("Magmar", "Fire", null, 65, 95, 57, 100, 85, 93, 27, new String[] {"Human-Like"}, 75, new String[] {"Magby", "Magmar"}, 1, 0));
		pokedex.add(new Pokemon("Pinsir", "Bug", null, 65, 125, 100, 55, 70, 85, 27, new String[] {"Bug"}, 50, new String[] {"Pinsir"}, 0, 0));
		pokedex.add(new Pokemon("Tauros", "Normal", null, 75, 100, 95, 40, 70, 110, 27, new String[] {"Field"}, 100, new String[] {"Tauros"}, 0, 0));
		pokedex.add(new Pokemon("Magikarp", "Water", null, 20, 10, 55, 15, 20, 80, 0, new String[] {"Water 2", "Dragon"}, 50, new String[] {"Magikarp", "Gyarados"}, 0, 20));
		pokedex.add(new Pokemon("Gyarados", "Water", "Flying", 95, 125, 79, 60, 100, 81, 27, new String[] {"Water 2", "Dragon"}, 50, new String[] {"Magikarp", "Gyarados"}, 1, 0));
		pokedex.add(new Pokemon("Lapras", "Water", "Ice", 130, 85, 80, 85, 95, 60, 27, new String[] {"Water 1", "Monster"}, 50, new String[] {"Lapras"}, 0, 0));
		pokedex.add(new Pokemon("Ditto", "Normal", null, 48, 48, 48, 48, 48, 48, 28, new String[] {"Ditto"}, -1, new String[] {"Ditto"}, 0, 0));
		pokedex.add(new Pokemon("Eevee", "Normal", null, 55, 55, 50, 45, 65, 55, 27, new String[] {"Field"}, 87.5, new String[] {"Eevee", "Vaporeon", "Jolteon", "Flareon", "Espeon", "Umbreon"}, 0, -1));
		pokedex.add(new Pokemon("Vaporeon", "Water", null, 130, 65, 60, 110, 95, 65, 27, new String[] {"Field"}, 87.5, new String[] {"Eevee", "Vaporeon"}, 1, 0));
		pokedex.add(new Pokemon("Jolteon", "Electric", null, 65, 65, 60, 110, 95, 130, 27, new String[] {"Field"}, 87.5, new String[] {"Eevee", "Jolteon"}, 1, 0));
		pokedex.add(new Pokemon("Flareon", "Fire", null, 65, 130, 60, 95, 110, 65, 27, new String[] {"Field"}, 87.5, new String[] {"Eevee", "Flareon"}, 1, 0));
		pokedex.add(new Pokemon("Porygon", "Normal", null, 65, 60, 70, 85, 75, 40, 27, new String[] {"Mineral"}, -1, new String[] {"Porygon", "Porygon2"}, 0, -1));
		pokedex.add(new Pokemon("Omanyte", "Rock", "Water", 35, 40, 100, 90, 55, 35, 27, new String[] {"Water 1", "Water 3"}, 87.5, new String[] {"Omanyte", "Omastar"}, 0, 40));
		pokedex.add(new Pokemon("Omastar", "Rock", "Water", 70, 60, 125, 115, 70, 55, 27, new String[] {"Water 1", "Water 3"}, 87.5, new String[] {"Omanyte", "Omastar"}, 1, 0));
		pokedex.add(new Pokemon("Kabuto", "Rock", "Water", 30, 80, 90, 55, 45, 55, 27, new String[] {"Water 1", "Water 3"}, 87.5, new String[] {"Kabuto", "Kabutops"}, 0, 40));
		pokedex.add(new Pokemon("Kabutops", "Rock", "Water", 60, 115, 105, 65, 70, 80, 27, new String[] {"Water 1", "Water 3"}, 87.5, new String[] {"Kabuto", "Kabutops"}, 1, 0));
		pokedex.add(new Pokemon("Aerodactyl", "Rock", "Flying", 80, 105, 65, 60, 75, 130, 27, new String[] {"Flying"}, 87.5, new String[] {"Aerodactyl"}, 0, 0));
		pokedex.add(new Pokemon("Snorlax", "Normal", null, 160, 110, 65, 65, 110, 30, 30, new String[] {"Monster"}, 87.5, new String[] {"Snorlax"}, 0, 0));
		pokedex.add(new Pokemon("Articuno", "Ice", "Flying", 90, 85, 100, 95, 125, 85, 32, new String[] {"Undiscovered"}, -1, new String[] {"Articuno"}, 0, 0));
		pokedex.add(new Pokemon("Zapdos", "Electric", "Flying", 90, 90, 85, 125, 90, 100, 32, new String[] {"Undiscovered"}, -1, new String[] {"Zapdos"}, 0, 0));
		pokedex.add(new Pokemon("Moltres", "Fire", "Flying", 90, 100, 90, 125, 85, 90, 32, new String[] {"Undiscovered"}, -1, new String[] {"Moltres"}, 0, 0));
		pokedex.add(new Pokemon("Dratini", "Dragon", null, 41, 64, 45, 50, 50, 50, 27, new String[] {"Water 1", "Dragon"}, 50, new String[] {"Dratini", "Dragonair", "Dragonite"}, 0, 30));
		pokedex.add(new Pokemon("Dragonair", "Dragon", null, 61, 84, 65, 70, 70, 70, 27, new String[] {"Water 1", "Dragon"}, 50, new String[] {"Dratini", "Dragonair", "Dragonite"}, 1, 55));
		pokedex.add(new Pokemon("Dragonite", "Dragon", "Flying", 91, 134, 95, 100, 100, 80, 27, new String[] {"Water 1", "Dragon"}, 50, new String[] {"Dratini", "Dragonair", "Dragonite"}, 2, 0));
		pokedex.add(new Pokemon("Mewtwo", "Psychic", null, 106, 110, 90, 154, 90, 130, 32, new String[] {"Undiscovered"}, -1, new String[] {"Mewtwo"}, 0, 0));
		pokedex.add(new Pokemon("Mew", "Psychic", null, 100, 100, 100, 100, 100, 100, 27, new String[] {"Undiscovered"}, -1, new String[] {"Mew"}, 0, 0));
		pokedex.add(new Pokemon("Chikorita", "Grass", null, 45, 49, 65, 49, 65, 45, 27, new String[] {"Monster", "Grass"}, 87.5, new String[] {"Chikorita", "Bayleef", "Meganium"}, 0, 16));
		pokedex.add(new Pokemon("Bayleef", "Grass", null, 60, 62, 80, 63, 80, 60, 27, new String[] {"Monster", "Grass"}, 87.5, new String[] {"Chikorita", "Bayleef", "Meganium"}, 1, 32));
		pokedex.add(new Pokemon("Meganium", "Grass", null, 80, 82, 100, 83, 100, 80, 27, new String[] {"Monster", "Grass"}, 87.5, new String[] {"Chikorita", "Bayleef", "Meganium"}, 2, 0));
		pokedex.add(new Pokemon("Cyndaquil", "Fire", null, 39, 52, 43, 60, 50, 65, 27, new String[] {"Field"}, 87.5, new String[] {"Cynaquil", "Quilava", "Typhlosion"}, 0, 14));
		pokedex.add(new Pokemon("Quilava", "Fire", null, 58, 64, 58, 80, 65, 80, 27, new String[] {"Field"}, 87.5, new String[] {"Cynaquil", "Quilava", "Typhlosion"}, 1, 36));
		pokedex.add(new Pokemon("Typhlosion", "Fire", null, 78, 84, 78, 109, 85, 100, 27, new String[] {"Field"}, 87.5, new String[] {"Cynaquil", "Quilava", "Typhlosion"}, 2, 0));
		pokedex.add(new Pokemon("Totodile", "Water", null, 50, 65, 64, 44, 48, 43, 27, new String[] {"Monster", "Water 1"}, 87.5, new String[] {"Totodile", "Croconaw", "Feraligatr"}, 0, 18));
		pokedex.add(new Pokemon("Croconaw", "Water", null, 65, 80, 80, 59, 63, 58, 27, new String[] {"Monster", "Water 1"}, 87.5, new String[] {"Totodile", "Croconaw", "Feraligatr"}, 1, 30));
		pokedex.add(new Pokemon("Feraligatr", "Water", null, 85, 105, 100, 79, 83, 78, 27, new String[] {"Monster", "Water 1"}, 87.5, new String[] {"Totodile", "Croconaw", "Feraligatr"}, 2, 0));
		pokedex.add(new Pokemon("Sentret", "Normal", null, 35, 46, 34, 35, 45, 20, 0, new String[] {"Field"}, 50, new String[] {"Sentret", "Furret"}, 0, 15));
		pokedex.add(new Pokemon("Furret", "Normal", null, 85, 76, 64, 45, 55, 90, 19, new String[] {"Field"}, 50, new String[] {"Sentret", "Furret"}, 1, 0));
		pokedex.add(new Pokemon("Hoothoot", "Normal", "Flying", 60, 30, 30, 36, 56, 50, 0, new String[] {"Flying"}, 50, new String[] {"Hoothoot", "Noctowl"}, 0, 20));
		pokedex.add(new Pokemon("Noctowl", "Normal", "Flying", 100, 50, 50, 86, 96, 70, 19, new String[] {"Flying"}, 50, new String[] {"Hoothoot", "Noctowl"}, 1, 0));
		pokedex.add(new Pokemon("Ledyba", "Bug", "Flying", 40, 20, 30, 40, 80, 55, 0, new String[] {"Bug"}, 50, new String[] {"Ledyba", "Ledian"}, 0, 18));
		pokedex.add(new Pokemon("Ledian", "Bug", "Flying", 55, 35, 50, 55, 110, 85, 19, new String[] {"Bug"}, 50, new String[] {"Ledyba", "Ledian"}, 1, 0));
		pokedex.add(new Pokemon("Spinarak", "Bug", "Poison", 40, 60, 40, 40, 40, 30, 0, new String[] {"Bug"}, 50, new String[] {"Spinarak", "Ariados"}, 0, 22));
		pokedex.add(new Pokemon("Ariados", "Bug", "Poison", 70, 90, 70, 60, 70, 40, 19, new String[] {"Bug"}, 50, new String[] {"Spinarak", "Ariados"}, 1, 0));
		pokedex.add(new Pokemon("Crobat", "Poison", "Flying", 85, 90, 80, 70, 80, 130, 19, new String[] {"Flying"}, 50, new String[] {"Zubat", "Golbat", "Crobat"}, 2, 0));
		pokedex.add(new Pokemon("Chinchou", "Water", "Electric", 75, 38, 38, 56, 56, 67, 6, new String[] {"Water 2"}, 50, new String[] {"Chinchou", "Lanturn"}, 0, 27));
		pokedex.add(new Pokemon("Lanturn", "Water", "Electric", 125, 58, 58, 76, 76, 67, 21, new String[] {"Water 2"}, 50, new String[] {"Chinchou", "Lanturn"}, 1, 0));
		pokedex.add(new Pokemon("Pichu", "Electric", null, 20, 40, 15, 35, 35, 60, 6, new String[] {"Field", "Fairy"}, 50, new String[] {"Pichu", "Pikachu", "Raichu"}, 0, -1));
		pokedex.add(new Pokemon("Cleffa", "Fairy", null, 50, 25, 28, 45, 55, 15, 11, new String[] {"Fairy"}, 25, new String[] {"Cleffa", "Clefairy", "Clefable"}, 0, -1));
		pokedex.add(new Pokemon("Igglybuff", "Normal", "Fairy", 90, 30, 15, 40, 20, 15, 8, new String[] {"Fairy"}, 25, new String[] {"Igglybuff", "Jigglypuff", "Wigglytuff"}, 0, -1));
		pokedex.add(new Pokemon("Togepi", "Fairy", null, 35, 20, 65, 40, 65, 20, 6, new String[] {"Flying", "Fairy"}, 87.5, new String[] {"Togepi", "Togetic"}, 0, -1));
		pokedex.add(new Pokemon("Togetic", "Fairy", "Flying", 55, 40, 85, 80, 105, 40, 21, new String[] {"Flying", "Fairy"}, 87.5, new String[] {"Togepi", "Togetic"}, 1, 0));
		pokedex.add(new Pokemon("Natu", "Psychic", "Flying", 40, 50, 45, 70, 45, 70, 6, new String[] {"Flying"}, 50, new String[] {"Natu", "Xatu"}, 0, 25));
		pokedex.add(new Pokemon("Xatu", "Psychic", "Flying", 65, 75, 70, 95, 70, 95, 21, new String[] {"Flying"}, 50, new String[] {"Natu", "Xatu"}, 1, 0));
		pokedex.add(new Pokemon("Mareep", "Electric", null, 55, 40, 40, 65, 45, 35, 1, new String[] {"Monster", "Field"}, 50, new String[] {"Mareep", "Flaaffy", "Ampharos"}, 0, 15));
		pokedex.add(new Pokemon("Flaaffy", "Electric", null, 70, 55, 55, 80, 60, 45, 17, new String[] {"Monster", "Field"}, 50, new String[] {"Mareep", "Flaaffy", "Ampharos"}, 1, 30));
		pokedex.add(new Pokemon("Ampharos", "Electric", null, 90, 75, 85, 115, 90, 55, 27, new String[] {"Monster", "Field"}, 50, new String[] {"Mareep", "Flaaffy", "Ampharos"}, 2, 0));
		pokedex.add(new Pokemon("Bellossom", "Grass", null, 75, 80, 95, 90, 100, 50, 27, new String[] {"Grass"}, 50, new String[] {"Oddish", "Gloom", "Vileplume", "Bellossom"}, 2, 0));
		pokedex.add(new Pokemon("Marill", "Water", "Fairy", 70, 20, 50, 20, 50, 40, 6, new String[] {"Water 1", "Fairy"}, 50, new String[] {"Marill", "Azumarill"}, 0, 18));
		pokedex.add(new Pokemon("Azumarill", "Water", "Fairy", 100, 50, 80, 60, 80, 50, 21, new String[] {"Water 1", "Fairy"}, 50, new String[] {"Marill", "Azumarill"}, 1, 0));
		pokedex.add(new Pokemon("Sudowoodo", "Rock", null, 70, 100, 115, 30, 65, 30, 23, new String[] {"Mineral"}, 50, new String[] {"Sudowoodo"}, 0, 0));
		pokedex.add(new Pokemon("Politoed", "Water", null, 90, 75, 75, 90, 100, 70, 27, new String[] {"Water 1"}, 50, new String[] {"Poliwag", "Poliwhirl", "Poliwrath", "Politoed"}, 2, 0));
		pokedex.add(new Pokemon("Hoppip", "Grass", "Flying", 35, 35, 40, 35, 55, 50, 0, new String[] {"Fairy", "Grass"}, 50, new String[] {"Hoppip", "Skiploom", "Jumpluff"}, 0, 18));
		pokedex.add(new Pokemon("Skiploom", "Grass", "Flying", 55, 45, 50, 45, 65, 80, 17, new String[] {"Fairy", "Grass"}, 50, new String[] {"Hoppip", "Skiploom", "Jumpluff"}, 1, 27));
		pokedex.add(new Pokemon("Jumpluff", "Grass", "Flying", 75, 55, 70, 55, 95, 110, 27, new String[] {"Fairy", "Grass"}, 50, new String[] {"Hoppip", "Skiploom", "Jumpluff"}, 2, 0));
		pokedex.add(new Pokemon("Aipom", "Normal", null, 55, 70, 55, 40, 55, 85, 27, new String[] {"Field"}, 50, new String[] {"Aipom"}, 0, 0));
		pokedex.add(new Pokemon("Sunkern", "Grass", null, 30, 30, 30, 30, 30, 30, 1, new String[] {"Grass"}, 50, new String[] {"Sunkern", "Sunflora"}, 0, -1));
		pokedex.add(new Pokemon("Sunflora", "Grass", null, 75, 75, 55, 105, 85, 30, 17, new String[] {"Grass"}, 50, new String[] {"Sunkern", "Sunflora"}, 1, 0));
		pokedex.add(new Pokemon("Yanma", "Bug", "Flying", 65, 65, 45, 75, 45, 95, 21, new String[] {"Bug"}, 50, new String[] {"Yanma"}, 0, 0));
		pokedex.add(new Pokemon("Wooper", "Water", "Ground", 55, 45, 45, 25, 25, 15, 0, new String[] {"Water 1", "Field"}, 50, new String[] {"Wooper", "Quagsire"}, 0, 20));
		pokedex.add(new Pokemon("Quagsire", "Water", "Ground", 95, 85, 85, 65, 65, 35, 19, new String[] {"Water 1", "Field"}, 50, new String[] {"Wooper", "Quagsire"}, 1, 0));
		pokedex.add(new Pokemon("Espeon", "Psychic", null, 65, 65, 60, 130, 95, 110, 27, new String[] {"Field"}, 87.5, new String[] {"Eevee", "Espeon"}, 1, 0));
		pokedex.add(new Pokemon("Umbreon", "Dark", null, 95, 65, 110, 60, 130, 65, 27, new String[] {"Field"}, 87.5, new String[] {"Eevee", "Umbreon"}, 1, 0));
		pokedex.add(new Pokemon("Murkrow", "Dark", "Flying", 60, 85, 42, 85, 42, 91, 29, new String[] {"Flying"}, 50, new String[] {"Murkrow"}, 0, 0));
		pokedex.add(new Pokemon("Slowking", "Water", "Psychic", 95, 75, 80, 100, 110, 30, 22, new String[] {"Monster", "Water 1"}, 50, new String[] {"Slowpoke", "Slowking"}, 1, 0));
		pokedex.add(new Pokemon("Misdreavus", "Ghost", null, 60, 60, 60, 85, 85, 85, 27, new String[] {"Amorphous"}, 50, new String[] {"Misdreavus"}, 0, 0));
		pokedex.add(new Pokemon("Unown", "Psychic", null, 48, 72, 48, 72, 48, 48, 2, new String[] {"Unown"}, -1, new String[] {"Unown"}, 0, 0));
		pokedex.add(new Pokemon("Wobbuffet", "Psychic", null, 190, 33, 58, 33, 58, 33, 27, new String[] {"Amorphous"}, 50, new String[] {"Wobbuffet"}, 0, 0));
		pokedex.add(new Pokemon("Girafarig", "Normal", "Psychic", 70, 80, 65, 90, 65, 85, 24, new String[] {"Field"}, 50, new String[] {"Girafarig"}, 0, 0));
		pokedex.add(new Pokemon("Pineco", "Bug", null, 50, 65, 90, 35, 35, 15, 6, new String[] {"Bug"}, 50, new String[] {"Pineco", "Forretress"}, 0, 31));
		pokedex.add(new Pokemon("Forretress", "Bug", "Steel", 75, 90, 140, 60, 60, 40, 21, new String[] {"Bug"}, 50, new String[] {"Pineco", "Forretress"}, 1, 0));
		pokedex.add(new Pokemon("Dunsparce", "Normal", null, 100, 70, 70, 65, 65, 45, 6, new String[] {"Field"}, 50, new String[] {"Dunsparce"}, 0, 0));
		pokedex.add(new Pokemon("Gligar", "Ground", "Flying", 65, 75, 105, 35, 65, 85, 24, new String[] {"Bug"}, 50, new String[] {"Gligar"}, 0, 0));
		pokedex.add(new Pokemon("Steelix", "Steel", "Ground", 75, 85, 200, 55, 65, 30, 30, new String[] {"Mineral"}, 50, new String[] {"Onix", "Steelix"}, 1, 0));
		pokedex.add(new Pokemon("Snubbull", "Fairy", null, 60, 80, 50, 40, 40, 30, 6, new String[] {"Field", "Fairy"}, 25, new String[] {"Snubbull", "Granbull"}, 0, 23));
		pokedex.add(new Pokemon("Granbull", "Fairy", null, 90, 120, 75, 60, 60, 45, 21, new String[] {"Field", "Fairy"}, 25, new String[] {"Snubbull", "Granbull"}, 1, 0));
		pokedex.add(new Pokemon("Qwilfish", "Water", "Poison", 65, 95, 85, 55, 55, 85, 27, new String[] {"Water 2"}, 50, new String[] {"Qwilfish"}, 0, 0));
		pokedex.add(new Pokemon("Scizor", "Bug", "Steel", 70, 130, 100, 55, 80, 65, 30, new String[] {"Bug"}, 50, new String[] {"Scyther", "Scizor"}, 1, 0));
		pokedex.add(new Pokemon("Shuckle", "Bug", "Rock", 20, 10, 230, 10, 230, 5, 6, new String[] {"Bug"}, 50, new String[] {"Shuckle"}, 0, 0));
		pokedex.add(new Pokemon("Heracross", "Bug", "Fighting", 80, 125, 75, 40, 95, 85, 27, new String[] {"Bug"}, 50, new String[] {"Heracross"}, 0, 0));
		pokedex.add(new Pokemon("Sneasel", "Dark", "Ice", 55, 95, 55, 35, 75, 115, 24, new String[] {"Field"}, 50, new String[] {"Sneasel"}, 0, 0));
		pokedex.add(new Pokemon("Teddiursa", "Normal", null, 60, 80, 50, 50, 50, 40, 17, new String[] {"Field"}, 50, new String[] {"Teddiursa", "Ursaring"}, 0, 30));
		pokedex.add(new Pokemon("Ursaring", "Normal", null, 90, 130, 75, 75, 75, 55, 24, new String[] {"Field"}, 50, new String[] {"Teddiursa", "Ursaring"}, 1, 0));
		pokedex.add(new Pokemon("Slugma", "Fire", null, 40, 40, 40, 70, 40, 20, 6, new String[] {"Amorphous"}, 50, new String[] {"Slugma", "Magcargo"}, 0, 38));
		pokedex.add(new Pokemon("Magcargo", "Fire", "Rock", 60, 50, 120, 90, 80, 30, 21, new String[] {"Amorphous"}, 50, new String[] {"Slugma", "Magcargo"}, 1, 0));
		pokedex.add(new Pokemon("Swinub", "Ice", "Ground", 50, 50, 40, 30, 30, 50, 2, new String[] {"Field"}, 50, new String[] {"Swinub", "Piloswine"}, 0, 33));
		pokedex.add(new Pokemon("Piloswine", "Ice", "Ground", 100, 100, 80, 60, 60, 50, 21, new String[] {"Field"}, 50, new String[] {"Swinub", "Piloswine"}, 1, 0));
		pokedex.add(new Pokemon("Corsola", "Water", "Rock", 65, 55, 95, 65, 95, 35, 24, new String[] {"Water 1", "Water 3"}, 25, new String[] {"Corsola"}, 0, 0));
		pokedex.add(new Pokemon("Remoraid", "Water", null, 35, 65, 35, 65, 35, 65, 6, new String[] {"Water 1", "Water 2"}, 50, new String[] {"Remoraid", "Octillery"}, 0, 25));
		pokedex.add(new Pokemon("Octillery", "Water", null, 75, 105, 75, 105, 75, 45, 21, new String[] {"Water 1", "Water 2"}, 50, new String[] {"Remoraid", "Octillery"}, 1, 0));
		pokedex.add(new Pokemon("Delibird", "Ice", "Flying", 45, 55, 45, 65, 45, 75, 27, new String[] {"Water 1", "Field"}, 50, new String[] {"Delibird"}, 0, 0));
		pokedex.add(new Pokemon("Mantine", "Water", "Flying", 85, 40, 70, 80, 140, 70, 30, new String[] {"Water 1"}, 50, new String[] {"Mantine"}, 0, 0));
		pokedex.add(new Pokemon("Skarmory", "Steel", "Flying", 65, 80, 140, 40, 70, 70, 30, new String[] {"Flying"}, 50, new String[] {"Skarmory"}, 0, 0));
		pokedex.add(new Pokemon("Houndour", "Dark", "Fire", 45, 60, 30, 80, 50, 65, 17, new String[] {"Field"}, 50, new String[] {"Houndour", "Houndoom"}, 0, 24));
		pokedex.add(new Pokemon("Houndoom", "Dark", "Fire", 75, 90, 50, 110, 80, 95, 27, new String[] {"Field"}, 50, new String[] {"Houndour", "Houndoom"}, 1, 0));
		pokedex.add(new Pokemon("Kingdra", "Water", "Dragon", 75, 95, 95, 95, 95, 85, 27, new String[] {"Water 1" , "Dragon"}, 50, new String[] {"Horsea", "Seadra", "Kingdra"}, 2, 0));
		pokedex.add(new Pokemon("Phanpy", "Ground", null, 90, 60, 60, 40, 40, 40, 17, new String[] {"Field"}, 50, new String[] {"Phanpy", "Donphan"}, 0, 25));
		pokedex.add(new Pokemon("Donphan", "Ground", null, 90, 120, 120, 60, 60, 50, 24, new String[] {"Field"}, 50, new String[] {"Phanpy", "Donphan"}, 1, 0));
		pokedex.add(new Pokemon("Porygon2", "Normal", null, 85, 80, 90, 105, 95, 60, 27, new String[] {"Mineral"}, -1, new String[] {"Porygon", "Porygon2"}, 1, 0));
		pokedex.add(new Pokemon("Stantler", "Normal", null, 73, 95, 62, 85, 65, 85, 27, new String[] {"Field"}, 50, new String[] {"Stantler"}, 0, 0));
		pokedex.add(new Pokemon("Smeargle", "Normal", null, 55, 20, 35, 20, 45, 75, 27, new String[] {"Field"}, 50, new String[] {"Smeargle"}, 0, 0));
		pokedex.add(new Pokemon("Tyrogue", "Fighting", null, 35, 35, 35, 35, 35, 35, 21, new String[] {"Human-Like"}, 100, new String[] {"Tyrogue", "Hitmonlee", "Hitmonchan", "Hitmontop"}, 0, 20));
		pokedex.add(new Pokemon("Hitmontop", "Fighting", null, 50, 95, 95, 35, 110, 70, 27, new String[] {"Human-Like"}, 100, new String[] {"Tyrogue", "Hitmontop"}, 1, 0));
		pokedex.add(new Pokemon("Smoochum", "Ice", "Psychic", 45, 30, 10, 85, 65, 65, 27, new String[] {"Human-Like"}, 0, new String[] {"Smoochum", "Jynx"}, 0, 30));
		pokedex.add(new Pokemon("Elekid", "Electric", null, 45, 63, 37, 65, 55, 95, 27, new String[] {"Human-Like"}, 75, new String[] {"Elekid", "Electabuzz"}, 0, 30));
		pokedex.add(new Pokemon("Magby", "Fire", null, 45, 75, 37, 70, 55, 83, 27, new String[] {"Human-Like"}, 75, new String[] {"Magby", "Magmar"}, 0, 30));
		pokedex.add(new Pokemon("Miltank", "Normal", null, 95, 80, 105, 40, 70, 100, 27, new String[] {"Field"}, 0, new String[] {"Miltank"}, 0, 0));
		pokedex.add(new Pokemon("Blissey", "Normal", null, 255, 10, 10, 75, 135, 55, 29, new String[] {"Fairy"}, 0, new String[] {"Chansey", "Blissey"}, 1, 0));
		pokedex.add(new Pokemon("Raikou", "Electric", null, 90, 85, 75, 115, 100, 115, 32, new String[] {"Undiscovered"}, -1, new String[] {"Raikou"}, 0, 0));
		pokedex.add(new Pokemon("Entei", "Fire", null, 115, 115, 85, 90, 75, 100, 32, new String[] {"Undiscovered"}, -1, new String[] {"Entei"}, 0, 0));
		pokedex.add(new Pokemon("Suicune", "Water", null, 100, 75, 115, 90, 115, 85, 32, new String[] {"Undiscovered"}, -1, new String[] {"Suicune"}, 0, 0));
		pokedex.add(new Pokemon("Larvitar", "Rock", "Ground", 50, 64, 50, 45, 50, 41, 27, new String[] {"Monster"}, 50, new String[] {"Larvitar", "Pupitar", "Tyranitar"}, 0, 30));
		pokedex.add(new Pokemon("Pupitar", "Rock", "Ground", 70, 84, 70, 65, 70, 51, 27, new String[] {"Monster"}, 50, new String[] {"Larvitar", "Pupitar", "Tyranitar"}, 1, 55));
		pokedex.add(new Pokemon("Tyranitar", "Rock", "Dark", 100, 134, 110, 95, 100, 61, 27, new String[] {"Monster"}, 50, new String[] {"Larvitar", "Pupitar", "Tyranitar"}, 2, 0));
		pokedex.add(new Pokemon("Lugia", "Psychic", "Flying", 106, 90, 130, 90, 154, 110, 32, new String[] {"Undiscovered"}, -1, new String[] {"Lugia"}, 0, 0));
		pokedex.add(new Pokemon("Ho-Oh", "Fire", "Flying", 106, 130, 90, 110, 154, 90, 32, new String[] {"Undiscovered"}, -1, new String[] {"Ho-Oh"}, 0, 0));
		pokedex.add(new Pokemon("Celebi", "Psychic", "Grass", 100, 100, 100, 100, 100, 100, 32, new String[] {"Undiscovered"}, -1, new String[] {"Celebi"}, 0, 0));
		pokedex.add(new Pokemon("Treecko", "Grass", null, 40, 45, 35, 65, 55, 70, 27, new String[] {"Monster", "Dragon"}, 87.5, new String[] {"Treecko", "Grovyle", "Sceptile"}, 0, 16));
		pokedex.add(new Pokemon("Grovyle", "Grass", null, 50, 65, 45, 85, 65, 95, 27, new String[] {"Monster", "Dragon"}, 87.5, new String[] {"Treecko", "Grovyle", "Sceptile"}, 1, 36));
		pokedex.add(new Pokemon("Sceptile", "Grass", null, 70, 85, 65, 105, 85, 120, 27, new String[] {"Monster", "Dragon"}, 87.5, new String[] {"Treecko", "Grovyle", "Sceptile"}, 2, 0));
		pokedex.add(new Pokemon("Torchic", "Fire", null, 45, 60, 40, 70, 50, 45, 27, new String[] {"Field"}, 87.5, new String[] {"Torchic", "Combusken", "Blaziken"}, 0, 16));
		pokedex.add(new Pokemon("Combusken", "Fire", "Fighting", 60, 85, 60, 85, 60, 55, 27, new String[] {"Field"}, 87.5, new String[] {"Torchic", "Combusken", "Blaziken"}, 1, 36));
		pokedex.add(new Pokemon("Blaziken", "Fire", "Fighting", 80, 120, 70, 110, 70, 80, 27, new String[] {"Field"}, 87.5, new String[] {"Torchic", "Combusken", "Blaziken"}, 2, 0));
		pokedex.add(new Pokemon("Mudkip", "Water", null, 50, 70, 50, 50, 50, 40, 27, new String[] {"Monster", "Water 1"}, 87.5, new String[] {"Mudkip", "Marshtomp", "Swampert"}, 0, 16));
		pokedex.add(new Pokemon("Marshtomp", "Water", "Ground", 70, 85, 70, 60, 70, 50, 27, new String[] {"Monster", "Water 1"}, 87.5, new String[] {"Mudkip", "Marshtomp", "Swampert"}, 1, 36));
		pokedex.add(new Pokemon("Swampert", "Water", "Ground", 100, 110, 90, 85, 90, 60, 27, new String[] {"Monster", "Water 1"}, 87.5, new String[] {"Mudkip", "Marshtomp", "Swampert"}, 2, 0));
		pokedex.add(new Pokemon("Poochyena", "Dark", null, 35, 55, 35, 30, 30, 35, 0, new String[] {"Field"}, 50, new String[] {"Poochyena", "Mightyena"}, 0, 18));
		pokedex.add(new Pokemon("Mightyena", "Dark", null, 70, 90, 70, 60, 60, 70, 15, new String[] {"Field"}, 50, new String[] {"Poochyena", "Mightyena"}, 1, 0));
		pokedex.add(new Pokemon("Zigzagoon", "Normal", null, 38, 30, 41, 30, 41, 60, 0, new String[] {"Field"}, 50, new String[] {"Zigzagoon", "Linoone"}, 0, 20));
		pokedex.add(new Pokemon("Linoone", "Normal", null, 78, 70, 61, 50, 61, 100, 19, new String[] {"Field"}, 50, new String[] {"Zigzagoon", "Linoone"}, 1, 0));
		pokedex.add(new Pokemon("Wurmple", "Bug", null, 45, 45, 35, 20, 30, 20, 0, new String[] {"Bug"}, 50, new String[] {"Wurmple", "Silcoon", "Beautifly", "Cascoon", "Dustox"}, 0, 7));
		pokedex.add(new Pokemon("Silcoon", "Bug", null, 50, 35, 55, 25, 25, 15, 17, new String[] {"Bug"}, 50, new String[] {"Wurmple", "Silcoon", "Beautifly"}, 1, 10));
		pokedex.add(new Pokemon("Beautifly", "Bug", "Flying", 60, 70, 50, 100, 50, 65, 27, new String[] {"Bug"}, 50, new String[] {"Wurmple", "Silcoon", "Beautifly"}, 2, 0));
		pokedex.add(new Pokemon("Cascoon", "Bug", null, 50, 35, 55, 25, 25, 15, 17, new String[] {"Bug"}, 50, new String[] {"Wurmple", "Cascoon", "Dustox"}, 1, 10));
		pokedex.add(new Pokemon("Dustox", "Bug", "Poison", 60, 50, 70, 50, 90, 65, 27, new String[] {"Bug"}, 50, new String[] {"Wurmple", "Cascoon", "Dustox"}, 2, 0));
		pokedex.add(new Pokemon("Lotad", "Water", "Grass", 40, 30, 30, 40, 50, 30, 0, new String[] {"Water 1", "Grass"}, 50, new String[] {"Lotad", "Lombre", "Ludicolo"}, 0, 14));
		pokedex.add(new Pokemon("Lombre", "Water", "Grass", 60, 50, 50, 60, 70, 50, 17, new String[] {"Water 1", "Grass"}, 50, new String[] {"Lotad", "Lombre", "Ludicolo"}, 1, -1));
		pokedex.add(new Pokemon("Ludicolo", "Water", "Grass", 80, 70, 70, 90, 100, 70, 27, new String[] {"Water 1", "Grass"}, 50, new String[] {"Lotad", "Lombre", "Ludicolo"}, 2, 0));
		pokedex.add(new Pokemon("Seedot", "Grass", null, 40, 40, 50, 30, 30, 30, 0, new String[] {"Field", "Grass"}, 50, new String[] {"Seedot", "Nuzleaf", "Shiftry"}, 0, 14));
		pokedex.add(new Pokemon("Nuzleaf", "Grass", "Dark", 70, 70, 40, 60, 40, 60, 17, new String[] {"Field", "Grass"}, 50, new String[] {"Seedot", "Nuzleaf", "Shiftry"}, 1, -1));
		pokedex.add(new Pokemon("Shiftry", "Grass", "Dark", 90, 100, 60, 90, 60, 80, 27, new String[] {"Field", "Grass"}, 50, new String[] {"Seedot", "Nuzleaf", "Shiftry"}, 2, 0));
		pokedex.add(new Pokemon("Taillow", "Normal", "Flying", 40, 55, 30, 30, 30, 85, 5, new String[] {"Flying"}, 50, new String[] {"Taillow", "Swellow"}, 0, 22));
		pokedex.add(new Pokemon("Swellow", "Normal", "Flying", 60, 85, 60, 75, 50, 125, 27, new String[] {"Flying"}, 50, new String[] {"Taillow", "Swellow"}, 1, 0));
		pokedex.add(new Pokemon("Wingull", "Water", "Flying", 40, 30, 30, 55, 30, 85, 6, new String[] {"Water 1", "Flying"}, 50, new String[] {"Wingull", "Pelipper"}, 0, 25));
		pokedex.add(new Pokemon("Pelipper", "Water", "Flying", 60, 50, 100, 95, 70, 65, 27, new String[] {"Water 1", "Flying"}, 50, new String[] {"Wingull", "Pelipper"}, 1, 0));
		pokedex.add(new Pokemon("Ralts", "Psychic", "Fairy", 28, 25, 25, 45, 35, 40, 1, new String[] {"Amorphous"}, 50, new String[] {"Ralts", "Kirlia", "Gardevoir"}, 0, 20));
		pokedex.add(new Pokemon("Kirlia", "Psychic", "Fairy", 38, 35, 35, 65, 55, 50, 17, new String[] {"Amorphous"}, 50, new String[] {"Ralts", "Kirlia", "Gardevoir"}, 1, 30));
		pokedex.add(new Pokemon("Gardevoir", "Psychic", "Fairy", 68, 65, 65, 125, 115, 80, 27, new String[] {"Amorphous"}, 50, new String[] {"Ralts", "Kirlia", "Gardevoir"}, 2, 0));
		pokedex.add(new Pokemon("Surskit", "Bug", "Water", 40, 30, 32, 50, 52, 65, 5, new String[] {"Water 1", "Bug"}, 50, new String[] {"Surskit", "Masquerain"}, 0, 22));
		pokedex.add(new Pokemon("Masquerain", "Bug", "Flying", 70, 60, 62, 100, 82, 80, 21, new String[] {"Water 1", "Bug"}, 50, new String[] {"Surskit", "Masquerain"}, 1, 0));
		pokedex.add(new Pokemon("Shroomish", "Grass", null, 60, 40, 60, 40, 60, 35, 0, new String[] {"Fairy", "Grass"}, 50, new String[] {"Shroomish", "Breloom"}, 0, 23));
		pokedex.add(new Pokemon("Breloom", "Grass", "Fighting", 60, 130, 80, 60, 60, 70, 19, new String[] {"Fairy", "Grass"}, 50, new String[] {"Shroomish", "Breloom"}, 1, 0));
		pokedex.add(new Pokemon("Slakoth", "Normal", null, 60, 60, 60, 35, 35, 30, 0, new String[] {"Field"}, 50, new String[] {"Slakoth", "Vigoroth", "Slaking"}, 0, 18));
		pokedex.add(new Pokemon("Vigoroth", "Normal", null, 80, 80, 80, 55, 55, 90, 17, new String[] {"Field"}, 50, new String[] {"Slakoth", "Vigoroth", "Slaking"}, 1, 36));
		pokedex.add(new Pokemon("Slaking", "Normal", null, 150, 160, 100, 95, 65, 100, 27, new String[] {"Field"}, 50, new String[] {"Slakoth", "Vigoroth", "Slaking"}, 2, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
		pokedex.add(new Pokemon(null, null, null, 0, 0, 0, 0, 0, 0, 0, null, 0, null, 0, 0));
	}

	private static void sortPC(Player p, Scanner input) {
		boolean finished = false;
		while(!finished) {
			System.out.println("How would you like your PC to be sorted?");
			System.out.println("1) Real Name Order");
			System.out.println("2) Nickname Order");
			System.out.println("3) Level Order");
			System.out.println("4) IV Percentage Greatest to Least");
			System.out.println("5) IV Percentage Least to Greatest");
			System.out.println();
			switch(input.nextLine()){
			case "1":
				System.out.println();
				p.chooseOrder("Real Name");
				finished = true;
				break;
			case "2":
				System.out.println();
				p.chooseOrder("Nickame");
				finished = true;
				break;
			case "3":
				System.out.println();
				p.chooseOrder("Level");
				finished = true;
				break;
			case "4":
				System.out.println();
				p.chooseOrder("IV Percentage Descending");
				finished = true;
				break;
			case "5":
				System.out.println();
				p.chooseOrder("IV Percentage Ascending");
				finished = true;
				break;
			default:
				System.out.println();
				System.out.println("Input does not match an available choice.");
				System.out.println();
			}
		}
		System.out.println("PC Re-Sorted");
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
		// there is a 1 in 20 chance that the user catches nothing
		if (rand == 0) {
			System.out.println("You found nothing. :(");
			System.out.println();
		} else {
			rand = new Random().nextInt(pokedex.size());
			if(spawnRateCounter[pokedex.get(rand).getSpawnRate()] != pokedex.get(rand).getSpawnRate()) {
				// check if spawn rate of the pokemon has been reached
				// (the rarer the pokemon, the higher the the number required to be reached)
				// if the spawn rate has not been reached, increment by 1 and re-search
				spawnRateCounter[pokedex.get(rand).getSpawnRate()]++;
				search(pokedex, p, spawnRateCounter);
			} else {
				// if spawn rate HAS been reached, give that pokemon to the player
				spawnRateCounter[pokedex.get(rand).getSpawnRate()] = 0;
				OwnedPokemon op = new OwnedPokemon(pokedex.get(rand));
				p.catchPokemon(op);
				if (op.isShiny())
					System.out.println("You caught a SHINY " + pokedex.get(rand).getName() + "!");
				else
					System.out.println("You caught a " + pokedex.get(rand).getName() + "!");
				System.out.println();
			}
		}
	}

	private static void viewOwnedPokemon(Player p, Scanner input) {
		boolean done = false;
		int startPCIndex = 0;
		int pageLimit = 25;
		int endPCIndex = pageLimit;
		String temp;
		while (!done) {
			printOwnedPokemon(p, startPCIndex, endPCIndex);
			System.out.println("Enter the number corresponding to a Pokemon in your PC to view it or enter \"0\" to go back to the main menu.");
			System.out.println("To see the next " + pageLimit + " pokemon in your pc, enter \"next\" or to see the previous " + pageLimit + " pokemon in your pc, enter \"previous\"");
			System.out.println();
			if (input.hasNext()) {
				temp = input.nextLine();		
				if (!isNumeric(temp)) {
					if (!temp.equals("next") && !temp.equals("previous")) {
						System.out.println();
						System.out.println("Input does not match an available choice.");
						System.out.println();
					} else if (temp.equals("next") && endPCIndex + pageLimit - p.getPC().size() < pageLimit) {
						System.out.println();
						startPCIndex += pageLimit;
						endPCIndex += pageLimit;
					} else if (temp.equals("previous") && startPCIndex - pageLimit >= 0) {
						System.out.println();
						startPCIndex -= pageLimit;
						endPCIndex -= pageLimit;
					} else {
						System.out.println();
						System.out.println("You have reached the limits of your PC.");
						System.out.println();
					}
				} else {
					int num = Integer.parseInt(temp);
					if (num < 0 || num >= p.getPC().size() + 1) {
						System.out.println();
						System.out.println("Input does not match an available choice.");
						System.out.println();
					} else if (num != 0) {
						// print the selected pokemon using its toString() method and ask the user if they want to nickname the pokemon, add the pokemon to favorites, and, finally, if they would like to view another pokemon
						System.out.println();
						System.out.println(p.getPC().get(num - 1));
						System.out.println();
						boolean repeat = false;
						boolean finished = false;
						while (!repeat) {
							System.out.println("Would you like to change anything about this Pokemon?");
							System.out.println("Enter the number corresponding to your choice.");
							System.out.println("1) Nickname");
							System.out.println("2) Favorite Status");
							System.out.println("3) Evolution Lock Status");
							System.out.println("4) View Another Pokemon");
							System.out.println("0) Go Back to Main Menu");
							System.out.println();
							if (input.hasNext())
								switch (input.nextLine()) {
								case "1":
									System.out.println();
									finished = false;
									while (!finished) {
										System.out.println("Would you like to change this Pokemon's nickname?");
										System.out.println("1) Yes");
										System.out.println("2) No");
										System.out.println();
										if (input.hasNext())
											switch (input.nextLine()) {
											case "1":
												System.out.println();
												while (!repeat) {
													System.out.println("What would you like it's nickname to be? (Nicknames must be at least 1 character and a maximum of 20 characters long)");
													System.out.println();
													if (input.hasNext())
														temp = input.nextLine();
													if (temp.length() > 20) {
														System.out.println();
														System.out.println("The name you have input is either less than 1 character ir longer than 20 characters");
														System.out.println();
													} else {
														p.getPC().get(num - 1).setNickname(temp);
														System.out.println();
														System.out.println("Your " + p.getPC().get(num - 1).getPokemon().getName() + " nickname is now " + temp + ".");
													}
												}
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
									break;
								case "2":
									System.out.println();
									finished = false;
									while (!finished) {
										System.out.println("Would you like to toggle this Pokemon's \"Favorite\" status?");
										System.out.println("1) Yes");
										System.out.println("2) No");
										System.out.println();
										if (input.hasNext())
											switch (input.nextLine()) {
											case "1":
												System.out.println();
												p.getPC().get(num - 1).toggleFavorite();
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
									break;
								case "3":
									System.out.println();
									finished = false;
									while (!finished) {
										System.out.println("Would you like to toggle this Pokemon's \"Evolution Lock\" status?");
										System.out.println("1) Yes");
										System.out.println("2) No");
										System.out.println();
										if (input.hasNext())
											switch (input.nextLine()) {
											case "1":
												System.out.println();
												p.getPC().get(num - 1).toggleEvoLock();
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
									break;
								case "4":
									System.out.println();
									finished = false;
									while (!finished) {
										System.out.println("Would you like to view another Pokemon?");
										System.out.println("1) Yes");
										System.out.println("2) No");
										System.out.println();
										if (input.hasNext())
											switch (input.nextLine()) {
											case "1":
												p.sortPC();
												System.out.println();
												finished = true;
												repeat = true;
												break;
											case "2":
												p.sortPC();
												System.out.println();
												finished = true;
												done = true;
												repeat = true;
												break;
											default:
												System.out.println();
												System.out.println("Input does not match an available choice.");
												System.out.println();
											}
									}
									break;
								case "0":
									p.sortPC();
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
		// sort the pc because newly favorited or unfavorited pokemon need to be re-sorted
		p.sortPC();
	}

	private static void breed(Player p, Scanner input, ArrayList<Pokemon> pokedex) {
		// user selects 2 pokemon to breed.  they can only breed if they share an egg group and are opposite genders (or both Genderless)
		boolean done = false;
		int startPCIndex = 0;
		int pageLimit = 25;
		int endPCIndex = pageLimit;
		String temp;
		while (!done) {
			printOwnedPokemon(p, startPCIndex, endPCIndex);
			System.out.println("Enter the number corresponding to the first Pokemon you would like to breed or enter \"0\" to go back to the main menu.");
			System.out.println("To see the next " + pageLimit + " pokemon in your pc, enter \"next\" or to see the previous " + pageLimit + " pokemon in your pc, enter \"previous\"");
			System.out.println();
			if (input.hasNext()) {
				temp = input.nextLine();
				System.out.println();
				if (!isNumeric(temp)) {
					if (!temp.equals("next") && !temp.equals("previous")) {
						System.out.println();
						System.out.println("Input does not match an available choice.");
						System.out.println();
					} else if (temp.equals("next") && endPCIndex + pageLimit - p.getPC().size() < pageLimit) {
						startPCIndex += pageLimit;
						endPCIndex += pageLimit;
					} else if (temp.equals("previous") && startPCIndex - pageLimit >= 0) {
						startPCIndex -= pageLimit;
						endPCIndex -= pageLimit;
					} else {
						System.out.println();
						System.out.println("You have reached the limits of your PC.");
						System.out.println();
					}
				} else {
					int num = Integer.parseInt(temp);
					if (num < 0 || num > p.getPC().size()) {
						System.out.println();
						System.out.println("Input does not match an available choice.");
						System.out.println();
					} else if (num != 0) {
						// pokemon number 1 has been selected, now select pokemon number 2
						boolean finished = false;
						while (!finished) {
							printOwnedPokemon(p, startPCIndex, endPCIndex);
							System.out.println("Enter the number corresponding to the second Pokemon you would like to breed or enter \"0\" to go back to the main menu.");
							System.out.println("To see the next " + pageLimit + " pokemon in your pc, enter \"next\" or to see the previous " + pageLimit + " pokemon in your pc, enter \"previous\"");
							System.out.println();
							temp = input.nextLine();
							if (!isNumeric(temp)) {
								if (!temp.equals("next") && !temp.equals("previous")) {
									System.out.println();
									System.out.println("Input does not match an available choice.");
									System.out.println();
								} else if (temp.equals("next") && endPCIndex + pageLimit - p.getPC().size() < pageLimit) {
									startPCIndex += pageLimit;
									endPCIndex += pageLimit;
								} else if (temp.equals("previous") && startPCIndex - pageLimit >= 0) {
									startPCIndex -= pageLimit;
									endPCIndex -= pageLimit;
								} else {
									System.out.println();
									System.out.println("You have reached the limits of your PC.");
									System.out.println();
								}
							} else {
								int numTwo = Integer.parseInt(temp);
								if (numTwo < 0 || numTwo > p.getPC().size() || num == numTwo) {
									System.out.println();
									System.out.println("Input does not match an available choice.");
									System.out.println();
								} else if (numTwo != 0) {
									// pokemon number 2 has been selected, now check if they are breedable
									OwnedPokemon oldOne = p.getPC().get(num - 1);
									OwnedPokemon oldTwo = p.getPC().get(numTwo - 1);
									boolean breedable = false;
									boolean validEggGroup = false;
									// first check if the egg group is valid.  if at least 1 egg group from pokemon 1 matches an egg group from pokemon 2, then the egg group is valid
									for (int i = 0; i < oldOne.getEggGroup().length; i++)
										for (int j = 0; j < oldTwo.getEggGroup().length; j++)
											if (oldOne.getEggGroup()[i].equals(oldTwo.getEggGroup()[j]))
												validEggGroup = true;
									if (validEggGroup)
										if ((oldOne.getGender().equals("Male") && oldTwo.getGender().equals("Female"))
												|| (oldOne.getGender().equals("Female") && oldTwo.getGender().equals("Male"))
												|| (oldOne.getGender().equals("Genderless") && oldTwo.getGender().equals("Genderless") && !oldOne.getEggGroup()[0].equals("Undiscovered") && !oldTwo.getEggGroup()[0].equals("Undiscovered"))
												|| (oldOne.getEggGroup()[0].equals("Undiscovered") && oldTwo.getEggGroup()[0].equals("Undiscovered")))
											// check if the pokemons' genders are correct for breeding (Female and Male, Male and Female, Genderless and Genderless)
											breedable = true;
									// if either pokemon are a Ditto, they are allowed to breed
									if (oldOne.getEggGroup()[0].equals("Ditto") || oldTwo.getEggGroup()[0].equals("Ditto"))
										breedable = true;
									if (breedable) {
										boolean repeat = true;
										boolean bred = true;
										while (repeat) {
											System.out.println();
											System.out.println("Are you sure you would like to breed these two Pokemon?");
											System.out.println("They will be removed from your PC in the process and the baby will have the best of both parents' IVs.");
											System.out.println("Enter the number corresponding your choice.");
											System.out.println("1) Yes");
											System.out.println("2) No");
											System.out.println();
											if (input.hasNext()) {
												switch (input.nextLine()) {
												case "1":
													repeat = false;
													break;
												case "2":
													System.out.println();
													repeat = false;
													done = true;
													finished = true;
													bred = false;
													break;
												default:
													System.out.println();
													System.out.println("Input does not match an available choice.");
													System.out.println();
												}
											}
										}
										//  figure out what the baby pokemon should be
										if (bred) {
											Pokemon pokemon = oldOne.getPokemon();
											if (oldOne.getEggGroup()[0].equals("Undiscovered")) {
												// if the user is breeding two pokemon from the Undiscovered egg group (which consists of legendary pokemon), they get to choose which one they would like to be the baby pokemon
												repeat = true;
												while (repeat) {
													System.out.println();
													System.out.println("Would you like your baby Pokemon to be a " + oldOne.getName() + " or a " + oldTwo.getName() + "?");
													System.out.println("Enter the number corresponding your choice or enter \"0\" to go back to the main menu.");
													System.out.println("1) " + oldOne.getName());
													System.out.println("2) " + oldTwo.getName());
													System.out.println();
													if (input.hasNext()) {
														switch (input.nextLine()) {
														case "1":
															pokemon = getBabyPokemon(pokedex, oldOne);
															p.catchPokemon(createBabyPokemon(p, num, numTwo, oldOne, oldTwo, pokemon));
															repeat = false;
															break;
														case "2":
															pokemon = getBabyPokemon(pokedex, oldTwo);
															p.catchPokemon(createBabyPokemon(p, num, numTwo, oldOne, oldTwo, pokemon));
															repeat = false;
															break;
														case "0":
															System.out.println();
															repeat = false;
															done = true;
															finished = true;
															bred = false;
															break;
														default:
															System.out.println();
															System.out.println("Input does not match an available choice.");
															System.out.println();
														}
													}
												}
											} else if (oldOne.getEggGroup()[0].equals("Ditto")) {
												//  if one parent is a ditto, the baby pokemon is the first stage of the other parent
												pokemon = getBabyPokemon(pokedex, oldTwo);
												p.catchPokemon(createBabyPokemon(p, num, numTwo, oldOne, oldTwo, pokemon));
											} else if (oldTwo.getEggGroup()[0].equals("Ditto")) {
												pokemon = getBabyPokemon(pokedex, oldOne);
												p.catchPokemon(createBabyPokemon(p, num, numTwo, oldOne, oldTwo, pokemon));
											} else if (oldOne.getGender().equals("Genderless")) {
												//  if the parents are genderless, one of them are chosen randomly and the baby pokemon is the first stage of that parent
												int choose = new Random().nextInt(2);
												if (choose == 0) {
													pokemon = getBabyPokemon(pokedex, oldOne);
													p.catchPokemon(createBabyPokemon(p, num, numTwo, oldOne, oldTwo, pokemon));
												} else {
													pokemon = getBabyPokemon(pokedex, oldTwo);
													p.catchPokemon(createBabyPokemon(p, num, numTwo, oldOne, oldTwo, pokemon));
												}
											} else if (oldOne.getName().equals("NidoranF") || oldOne.getName().equals("Nidorina") || oldOne.getName().equals("Nidoqueen") || oldTwo.getName().equals("NidoranF") || oldTwo.getName().equals("Nidorina") || oldTwo.getName().equals("Nidoqueen")) {
												// special case: if one of the parents is a NidoranF, Nidorina, or Nidoqueen, the baby has a 50-50 chance of being a NidoranF or NidoranM
												int rand = new Random().nextInt(2);
												if (rand == 0) {
													pokemon = pokedex.get(28);
													p.catchPokemon(createBabyPokemon(p, num, numTwo, oldOne, oldTwo, pokemon));
												} else {
													pokemon = pokedex.get(31);
													p.catchPokemon(createBabyPokemon(p, num, numTwo, oldOne, oldTwo, pokemon));
												}
											} else if ((oldOne.getName().equals("Miltank") && oldTwo.getName().equals("Tauros")) || (oldOne.getName().equals("Tauros") && oldTwo.getName().equals("Miltank"))) {
												int rand = new Random().nextInt(2);
												if (rand == 0) {
													pokemon = pokedex.get(240);
													p.catchPokemon(createBabyPokemon(p, num, numTwo, oldOne, oldTwo, pokemon));
												} else {
													pokemon = pokedex.get(127);
													p.catchPokemon(createBabyPokemon(p, num, numTwo, oldOne, oldTwo, pokemon));
												}
											} else {
												pokemon = getBabyPokemon(pokedex, oldTwo);
												p.catchPokemon(createBabyPokemon(p, num, numTwo, oldOne, oldTwo, pokemon));
											}
											// when two pokemon are successfully bred, they make a baby with the best IVs of both parents but...
											// the parents are used up so they need to be removed from the players PC
											// the two pokemon need to be removed in the right order in order to make sure the correct pokemon get removed
											// this means that the pokemon that comes later in the PC needs to be removed first
											if (bred) {
												// don't do this if the player decided not to breed their pokemon
												if (num < numTwo) {
													p.getPC().remove(numTwo - 1);
													p.getPC().remove(num - 1);
												} else {
													p.getPC().remove(num - 1);
													p.getPC().remove(numTwo - 1);
												}
												System.out.println();
												System.out.println("Congratulations on your newly bred " + pokemon.getName() + "!");
												System.out.println();
												done = true;
												finished = true;
											}
										}
									} else {
										System.out.println();
										System.out.println("These two Pokemon are not breedable.");
										System.out.println();
										done = true;
										finished = true;
									}
								} else {
									System.out.println();
									done = true;
									finished = true;
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

	private static OwnedPokemon createBabyPokemon(Player p, int num, int numTwo, OwnedPokemon oldOne, OwnedPokemon oldTwo, Pokemon pokemon) {
		//  create and return a new pokemon which is the baby of the parent chosen in breed()
		//  the baby will have the best IVs of the 2 parents
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
		return new OwnedPokemon(pokemon, healthIV, attackIV, defenseIV, specialAttackIV, specialDefenseIV, speedIV, oldOne, oldTwo);
	}

	private static Pokemon getBabyPokemon(ArrayList<Pokemon> pokedex, OwnedPokemon poke) {
		// search the pokedex for the first stage of the chosen parent pokemon and return it
		// the other return isn't necessary but it's just there because "the if statement might fail and thus the first return may never happen"
		for (int i = 0; i < pokedex.size(); i++)
			if (poke.getPokemon().getEvolutionTree()[0].equals(pokedex.get(i).getName()))
				return pokedex.get(i);
		return poke.getPokemon();
	}

	private static void training(Player p, Scanner input, ArrayList<Pokemon> pokedex) {
		boolean done = false;
		String temp;
		while (!done) {
			System.out.println("Would you like to Level Up a Pokemon, Evolve a Pokemon which requires a Special Condition to Evolve, EV Train a Pokemon, Reset a Pokemon's EVs, or Change a Pokemon's Nature?");
			System.out.println("1) Level Up");
			System.out.println("2) Evolve");
			System.out.println("3) EV Train");
			System.out.println("4) Reset EVs");
			System.out.println("5) Change Nature");
			System.out.println("Enter \"0\" to go back to the main menu.");
			System.out.println();
			if (input.hasNext()) {
				temp = input.nextLine();
				switch (temp) {
				case "1":
					System.out.println();
					levelUp(p, input, pokedex);
					System.out.println();
					done = true;
					break;
				case "2":
					System.out.println();
					evolve(p, input, pokedex);
					System.out.println();
					done = true;
					break;
				case "3":
					System.out.println();
					evTrain(p, input);
					System.out.println();
					done = true;
					break;
				case "4":
					System.out.println();
					resetEVs(p, input);
					System.out.println();
					done = true;
					break;
				case "5":
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

	private static void levelUp(Player p, Scanner input, ArrayList<Pokemon> pokedex) {
		boolean done = false;
		int startPCIndex = 0;
		int pageLimit = 25;
		int endPCIndex = pageLimit;
		String temp;
		while (!done) {
			printOwnedPokemon(p, startPCIndex, endPCIndex);
			System.out.println("Each level-up has a point-cost equal to the Pokemon's current level.");
			System.out.println("Choose the pokemon you want to level up.");
			System.out.println("Enter the number corresponding to a Pokemon in your PC or enter \"0\" to go back to the main menu.");
			System.out.println("To see the next " + pageLimit + " pokemon in your pc, enter \"next\" or to see the previous " + pageLimit + " pokemon in your pc, enter \"previous\"");
			System.out.println();
			if (input.hasNext()) {
				temp = input.nextLine();		
				if (!isNumeric(temp)) {
					if (!temp.equals("next") && !temp.equals("previous")) {
						System.out.println();
						System.out.println("Input does not match an available choice.");
						System.out.println();
					} else if (temp.equals("next") && endPCIndex + pageLimit - p.getPC().size() < pageLimit) {
						System.out.println();
						startPCIndex += pageLimit;
						endPCIndex += pageLimit;
					} else if (temp.equals("previous") && startPCIndex - pageLimit >= 0) {
						System.out.println();
						startPCIndex -= pageLimit;
						endPCIndex -= pageLimit;
					} else {
						System.out.println();
						System.out.println("You have reached the limits of your PC.");
						System.out.println();
					}
				} else {
					int num = Integer.parseInt(temp);
					if (num < 0 || num >= p.getPC().size() + 1) {
						System.out.println();
						System.out.println("Input does not match an available choice.");
						System.out.println();
					} else
						if (num != 0) {
							if (p.getPC().get(num - 1).getLevel() < 100) {
								String typePoints = chooseTypePoints(p, num);
								System.out.println();
								boolean finished = false;
								while (!finished) {
									System.out.println("A level-up for " + p.getPC().get(num - 1).getName() + " will cost you " + p.getPC().get(num - 1).getLevel() + " " + typePoints);
									System.out.println("Enter \"1\" to level up or enter \"0\" to go back to the main menu.");
									System.out.println();
									if (input.hasNext())
										switch (input.nextLine()) {
										case "1":
											// if the user does want to level up the pokemon, check if they have enough points to do so
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
											if (enough)
												// if the user has enough points to level up their pokemon and the pokemon isn't level 100 yet, spend the points and level up the pokemon
												if (p.getPC().get(num - 1).getLevel() < 100) {
													System.out.println();
													switch (typePoints) {
													case "Tier 1 Points":
														p.spendTier1(p.getPC().get(num - 1).getLevel());
														p.getPC().get(num - 1).addT1PointsInvested(p.getPC().get(num - 1).getLevel());
														break;
													case "Tier 2 Points":
														p.spendTier2(p.getPC().get(num - 1).getLevel());
														p.getPC().get(num - 1).addT2PointsInvested(p.getPC().get(num - 1).getLevel());
														break;
													case "Tier 3 Points":
														p.spendTier3(p.getPC().get(num - 1).getLevel());
														p.getPC().get(num - 1).addT3PointsInvested(p.getPC().get(num - 1).getLevel());
														break;
													case "Tier 4 Points":
														p.spendTier4(p.getPC().get(num - 1).getLevel());
														p.getPC().get(num - 1).addT4PointsInvested(p.getPC().get(num - 1).getLevel());
														break;
													case "Tier 5 Points":
														p.spendTier5(p.getPC().get(num - 1).getLevel());
														p.getPC().get(num - 1).addT5PointsInvested(p.getPC().get(num - 1).getLevel());
														break;
													}
													p.getPC().get(num - 1).levelUp();
													System.out.println("Your " + p.getPC().get(num - 1).getName() + " is now level " + p.getPC().get(num - 1).getLevel());
													OwnedPokemon tempPokemon = p.getPC().get(num - 1);
													if (p.getPC().get(num - 1).getLevel() >= p.getPC().get(num - 1).getPokemon().getEvolutionLevel() && p.getPC().get(num - 1).getPokemon().getEvolutionLevel() != 0 && p.getPC().get(num - 1).getPokemon().getEvolutionLevel() != -1) {
														// if the pokemon's evolution level is reached, add its evolution with everything exactly the same as the original to the PC and remove the old one
														if (!p.getPC().get(num - 1).isEvoLocked()) {
															Pokemon poke = p.getPC().get(num - 1).getPokemon();
															if (p.getPC().get(num - 1).getName().equals("Tyrogue")) {
																// Tyrogue can evolve into 3 different pokemon depending on its attack and defense stats
																if (p.getPC().get(num - 1).getAttackStat() > p.getPC().get(num - 1).getDefenseStat()) {
																	poke = pokedex.get(105);
																	OwnedPokemon op = p.getPC().get(num - 1);
																	p.getPC().remove(num - 1);
																	tempPokemon = new OwnedPokemon(op, poke);
																	p.catchPokemon(new OwnedPokemon(op, poke));
																	System.out.println("Congratulations, your Tyrgoue has evolved into a Hitmonlee!");
																} else if (p.getPC().get(num - 1).getAttackStat() < p.getPC().get(num - 1).getDefenseStat()) {
																	poke = pokedex.get(106);
																	OwnedPokemon op = p.getPC().get(num - 1);
																	p.getPC().remove(num - 1);
																	tempPokemon = new OwnedPokemon(op, poke);
																	p.catchPokemon(new OwnedPokemon(op, poke));
																	System.out.println("Congratulations, your Tyrgoue has evolved into a Hitmonchan!");
																} else {
																	poke = pokedex.get(236);
																	OwnedPokemon op = p.getPC().get(num - 1);
																	p.getPC().remove(num - 1);
																	tempPokemon = new OwnedPokemon(op, poke);
																	p.catchPokemon(new OwnedPokemon(op, poke));
																	System.out.println("Congratulations, your Tyrgoue has evolved into a Hitmontop!");
																}
															} else if (p.getPC().get(num - 1).getName().equals("Wurmple")) {
																// Wurmple can evolve into 2 different pokemon
																// the way its determined in the games is practically random so instead I allow the user to choose which pokemon they want their Wurmple to evolve into
																boolean repeat = false;
																OwnedPokemon op;
																while (repeat) {
																	System.out.println();
																	System.out.println("Would you like your Wurmple to evolve into a Silcoon or a Cascoon?");
																	System.out.println("Enter the number corresponding your choice.");
																	System.out.println("1) Silcoon");
																	System.out.println("2) Cascoon");
																	System.out.println();
																	if (input.hasNext()) {
																		switch (input.nextLine()) {
																		case "1":
																			System.out.println();
																			poke = pokedex.get(265);
																			op = p.getPC().get(num - 1);
																			p.getPC().remove(num - 1);
																			tempPokemon = new OwnedPokemon(op, poke);
																			p.catchPokemon(new OwnedPokemon(op, poke));
																			System.out.println("Congratulations, your Wurmple has evolved into a Silcoon!");
																			repeat = false;
																			break;
																		case "2":
																			System.out.println();
																			poke = pokedex.get(267);
																			op = p.getPC().get(num - 1);
																			p.getPC().remove(num - 1);
																			tempPokemon = new OwnedPokemon(op, poke);
																			p.catchPokemon(new OwnedPokemon(op, poke));
																			System.out.println("Congratulations, your Wurmple has evolved into a Cascoon!");
																			repeat = false;
																			break;
																		default:
																			System.out.println();
																			System.out.println("Input does not match an available choice.");
																			System.out.println();
																		}
																	}
																}
															} else {
																for (int i = 0; i < pokedex.size(); i++) {
																	if (pokedex.get(i).getName().equals(p.getPC().get(num - 1).getPokemon().getEvolutionTree()[p.getPC().get(num - 1).getPokemon().getEvolutionStage() + 1]))
																		poke = pokedex.get(i);
																}
																// store the old pokemon in a variable
																OwnedPokemon op = p.getPC().get(num - 1);
																// remove the old pokemon from the player's pc
																p.getPC().remove(num - 1);
																// add the evolved pokemon to the player's pc (everything about the pokemon will remain the same except its "pokemon" data member
																tempPokemon = new OwnedPokemon(op, poke);
																p.catchPokemon(new OwnedPokemon(op, poke));
																System.out.println("Congratulations, your " + op.getName() + " has evolved into a " + poke.getName() + "!");
															}
														}
													}
													p.sortPC();
													// change num to the new index of the pokemon
													num = p.getIndex(tempPokemon) + 1;
													System.out.println();
												} else {
													System.out.println();
													System.out.println("This Pokemon is already level 100.  Make a different choice.");
													System.out.println();
													finished = true;
													done = true;
												} else {
													System.out.println();
													System.out.println("Leveling up this " + p.getPC().get(num - 1).getName() + " costs " + p.getPC().get(num - 1).getLevel() + " " + typePoints);
													System.out.println("You do not have enough " + typePoints + " to level up this Pokemon.");
													System.out.println();
													finished = true;
													done = true;
												}
											break;
										case "0":
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
						} else
							done = true;
				}
			}
		}
	}

	private static void evolve(Player p, Scanner input, ArrayList<Pokemon> pokedex) {
		boolean done = false;
		int startPCIndex = 0;
		int pageLimit = 25;
		int endPCIndex = pageLimit;
		String temp;
		while (!done) {
			printOwnedPokemon(p, startPCIndex, endPCIndex);
			System.out.println("Choose the pokemon you want to evolve.");
			System.out.println("Enter the number corresponding to a Pokemon in your PC or enter \"0\" to go back to the main menu.");
			System.out.println("To see the next " + pageLimit + " pokemon in your pc, enter \"next\" or to see the previous " + pageLimit + " pokemon in your pc, enter \"previous\"");
			System.out.println();
			if (input.hasNext()) {
				temp = input.nextLine();		
				if (!isNumeric(temp)) {
					if (!temp.equals("next") && !temp.equals("previous")) {
						System.out.println();
						System.out.println("Input does not match an available choice.");
						System.out.println();
					} else if (temp.equals("next") && endPCIndex + pageLimit - p.getPC().size() < pageLimit) {
						System.out.println();
						startPCIndex += pageLimit;
						endPCIndex += pageLimit;
					} else if (temp.equals("previous") && startPCIndex - pageLimit >= 0) {
						System.out.println();
						startPCIndex -= pageLimit;
						endPCIndex -= pageLimit;
					} else {
						System.out.println();
						System.out.println("You have reached the limits of your PC.");
						System.out.println();
					}
				} else {
					int num = Integer.parseInt(temp);
					if (num < 0 || num >= p.getPC().size() + 1) {
						System.out.println();
						System.out.println("Input does not match an available choice.");
						System.out.println();
					} else
						if (num != 0)
							if (p.getPC().get(num - 1).getPokemon().getEvolutionLevel() == -1) {
								// Pokemon who evolve via special condition, such as evolution stone, trade, or friendship, have their evolution level set to -1
								// if the Pokemon's evolution level is -1, it will cost the user 100 points corresponding to the Pokemon's tier to evolve the Pokemon
								// as opposed to evolution via level-up, pokemon who evolve via special condition can be evolved whenever the user wants to evolve them as long as the user has enough points corresponing to the Pokemon's tier
								String typePoints = chooseTypePoints(p, num);
								System.out.println();
								boolean finished = false;
								while (!finished) {
									System.out.println("Evolving " + p.getPC().get(num - 1).getName() + " will cost you 100 " + typePoints);
									System.out.println("Enter \"1\" to level up or enter \"0\" to go back to the main menu.");
									System.out.println();
									if (input.hasNext())
										switch (input.nextLine()) {
										case "1":
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
												Pokemon poke;
												OwnedPokemon op;
												if (p.getPC().get(num - 1).getName().equals("Eevee")){
													// Eevee is a special case in special condition evolutions because it itself can evolve into several different Pokemon
													// so the user is given a choice of which Pokemon they would like to evolve their Eevee into
													System.out.println();
													boolean repeat = false;
													while (!repeat) {
														System.out.println("What would you like to evolve you Eevee into?");
														System.out.println("1) Vaporeon");
														System.out.println("2) Jolteon");
														System.out.println("3) Flareon");
														System.out.println("4) Espeon");
														System.out.println("5) Umbreon");
														System.out.println("Enter \"0\" to go back to the main menu.");
														System.out.println();
														poke = p.getPC().get(num - 1).getPokemon();
														if (input.hasNext())
															switch (input.nextLine()) {
															case "1":
																System.out.println();
																p.spendTier4(100);
																poke = pokedex.get(133);
																op = new OwnedPokemon(p.getPC().get(num - 1), poke);
																// remove the old Pokemon
																p.getPC().remove(num - 1);
																// catch the newly evolved version of it which is exactly the same except for the Pokemon data member
																p.catchPokemon(op);
																System.out.println("Congratulations, your Eevee has evolved into a Vaporeon!");
																p.getPC().get(p.getIndex(op)).addT4PointsInvested(100);
																done = true;
																finished = true;
																repeat = true;
																break;
															case "2":
																System.out.println();
																p.spendTier4(100);
																poke = pokedex.get(134);
																op = new OwnedPokemon(p.getPC().get(num - 1), poke);
																p.getPC().remove(num - 1);
																p.catchPokemon(op);
																System.out.println("Congratulations, your Eevee has evolved into a Jolteon!");
																p.getPC().get(p.getIndex(op)).addT4PointsInvested(100);
																done = true;
																finished = true;
																repeat = true;
																break;
															case "3":
																System.out.println();
																p.spendTier4(100);
																poke = pokedex.get(135);
																op = new OwnedPokemon(p.getPC().get(num - 1), poke);
																p.getPC().remove(num - 1);
																p.catchPokemon(op);
																System.out.println("Congratulations, your Eevee has evolved into a Flareon!");
																p.getPC().get(p.getIndex(op)).addT4PointsInvested(100);
																done = true;
																finished = true;
																repeat = true;
																break;
															case "4":
																System.out.println();
																p.spendTier4(100);
																poke = pokedex.get(195);
																op = new OwnedPokemon(p.getPC().get(num - 1), poke);
																p.getPC().remove(num - 1);
																p.catchPokemon(op);
																System.out.println("Congratulations, your Eevee has evolved into a Espeon!");
																p.getPC().get(p.getIndex(op)).addT4PointsInvested(100);
																done = true;
																finished = true;
																repeat = true;
																break;
															case "5":
																System.out.println();
																p.spendTier4(100);
																poke = pokedex.get(196);
																op = new OwnedPokemon(p.getPC().get(num - 1), poke);
																p.getPC().remove(num - 1);
																p.catchPokemon(op);
																System.out.println("Congratulations, your Eevee has evolved into a Umbreon!");
																p.getPC().get(p.getIndex(op)).addT4PointsInvested(100);
																done = true;
																finished = true;
																repeat = true;
																break;
															case "0":
																done = true;
																finished = true;
																repeat = true;
																break;
															default:
																System.out.println();
																System.out.println("Input does not match an available choice.");
																System.out.println();
															}
														System.out.println();
													}
												} else if(p.getPC().get(num - 1).getName().equals("Gloom")){
													// Gloom is another special case in special condition evolutions because it can evolve into 2 different Pokemon
													System.out.println();
													boolean repeat = false;
													while (!repeat) {
														System.out.println("What would you like to evolve you Gloom into?");
														System.out.println("1) Vileplume");
														System.out.println("2) Bellossom");
														System.out.println("Enter \"0\" to go back to the main menu.");
														System.out.println();
														poke = p.getPC().get(num - 1).getPokemon();
														if (input.hasNext())
															switch (input.nextLine()) {
															case "1":
																System.out.println();
																p.spendTier2(100);
																poke = pokedex.get(44);
																op = new OwnedPokemon(p.getPC().get(num - 1), poke);
																p.getPC().remove(num - 1);
																p.catchPokemon(op);
																System.out.println("Congratulations, your Gloom has evolved into a Vileplume!");
																p.getPC().get(p.getIndex(op)).addT2PointsInvested(100);
																done = true;
																finished = true;
																repeat = true;
																break;
															case "2":
																System.out.println();
																p.spendTier2(100);
																poke = pokedex.get(181);
																op = new OwnedPokemon(p.getPC().get(num - 1), poke);
																p.getPC().remove(num - 1);
																p.catchPokemon(op);
																System.out.println("Congratulations, your Gloom has evolved into a Bellossom!");
																p.getPC().get(p.getIndex(op)).addT2PointsInvested(100);
																done = true;
																finished = true;
																repeat = true;
																break;
															case "0":
																done = true;
																finished = true;
																repeat = true;
																break;
															default:
																System.out.println();
																System.out.println("Input does not match an available choice.");
																System.out.println();
															}
														System.out.println();
													}
												} else if(p.getPC().get(num - 1).getPokemon().getName().equals("Poliwhirl")){
													// Poliwhirl is another special case in special condition evolutions because it can evolve into 2 different Pokemon
													System.out.println();
													boolean repeat = false;
													while (!repeat) {
														System.out.println("What would you like to evolve you Poliwhirl into?");
														System.out.println("1) Poliwrath");
														System.out.println("2) Politoed");
														System.out.println("Enter \"0\" to go back to the main menu.");
														System.out.println();
														poke = p.getPC().get(num - 1).getPokemon();
														if (input.hasNext())
															switch (input.nextLine()) {
															case "1":
																System.out.println();
																p.spendTier2(100);
																poke = pokedex.get(61);
																op = new OwnedPokemon(p.getPC().get(num - 1), poke);
																p.getPC().remove(num - 1);
																p.catchPokemon(op);
																System.out.println("Congratulations, your Poliwhirl has evolved into a Poliwrath!");
																p.getPC().get(p.getIndex(op)).addT2PointsInvested(100);
																done = true;
																finished = true;
																repeat = true;
																break;
															case "2":
																System.out.println();
																p.spendTier2(100);
																poke = pokedex.get(185);
																op = new OwnedPokemon(p.getPC().get(num - 1), poke);
																p.getPC().remove(num - 1);
																p.catchPokemon(op);
																System.out.println("Congratulations, your Poliwhirl has evolved into a Politoed!");
																p.getPC().get(p.getIndex(op)).addT2PointsInvested(100);
																done = true;
																finished = true;
																repeat = true;
																break;
															case "0":
																done = true;
																finished = true;
																repeat = true;
																break;
															default:
																System.out.println();
																System.out.println("Input does not match an available choice.");
																System.out.println();
															}
														System.out.println();
													}
												} else {
													boolean repeat = false;
													while (!repeat) {
														System.out.println("Enter \"1\" to evolve " + p.getPC().get(num - 1).getName() + " or \"0\" to go back to the main menu.");
														System.out.println();
														if (input.hasNext()) {
															switch (input.nextLine()) {
															case "1":
																System.out.println();
																switch (typePoints) {
																case "Tier 1 Points":
																	p.spendTier1(100);
																	p.getPC().get(num - 1).addT1PointsInvested(100);
																	break;
																case "Tier 2 Points":
																	p.spendTier2(100);
																	p.getPC().get(num - 1).addT2PointsInvested(100);
																	break;
																case "Tier 3 Points":
																	p.spendTier3(100);
																	p.getPC().get(num - 1).addT3PointsInvested(100);
																	break;
																case "Tier 4 Points":
																	p.spendTier4(100);
																	p.getPC().get(num - 1).addT4PointsInvested(100);
																	break;
																case "Tier 5 Points":
																	p.spendTier5(100);
																	p.getPC().get(num - 1).addT5PointsInvested(100);
																	break;
																}
																poke = p.getPC().get(num - 1).getPokemon();
																for (int i = 0; i < pokedex.size(); i++) {
																	// find the Pokemon the player's chosen Pokemon evolves into
																	if (pokedex.get(i).getName().equals(p.getPC().get(num - 1).getPokemon().getEvolutionTree()[p.getPC().get(num - 1).getPokemon().getEvolutionStage() + 1]))
																		poke = pokedex.get(i);
																}

																String oldName = p.getPC().get(num - 1).getName();
																op = new OwnedPokemon(p.getPC().get(num - 1), poke);
																p.getPC().remove(num - 1);
																p.catchPokemon(op);
																// change num to the index of the newly evolved Pokemon
																num = p.getIndex(op) + 1;
																System.out.println("Congratulations, your " + oldName + " has evolved into a " + p.getPC().get(num - 1).getName() + "!");
																System.out.println();
																done = true;
																finished = true;
																repeat = true;
															case "0":
																done = true;
																finished = true;
																repeat = true;
																break;
															default:
																System.out.println();
																System.out.println("Input does not match an available choice.");
																System.out.println();
															}
														}
													}
												}
											} else {
												System.out.println();
												System.out.println("Evolving " + p.getPC().get(num - 1).getName() + " costs 100 " + typePoints);
												System.out.println("You do not have enough " + typePoints + " to evolve your " + p.getPC().get(num - 1).getName());
												System.out.println();
												finished = true;
												done = true;
											}
											break;
										case "0":
											finished = true;
											done = true;
											break;
										default:
											System.out.println();
											System.out.println("Input does not match an available choice.");
											System.out.println();
										}
								}
							} else if (p.getPC().get(num - 1).getPokemon().getName().equals("Slowpoke")) {
								if (p.getTier1() < 100) {
									boolean repeat = false;
									System.out.println();
									while (!repeat) {
										System.out.println("Enter \"1\" to evolve Slowpoke into Slowking or \"0\" to go back to the main menu.");
										System.out.println();
										if (input.hasNext()) {
											switch (input.nextLine()) {
											case "1":
												System.out.println();
												p.spendTier1(100);
												Pokemon poke = pokedex.get(198);
												OwnedPokemon op = new OwnedPokemon(p.getPC().get(num - 1), poke);
												p.getPC().remove(num - 1);
												p.catchPokemon(op);
												System.out.println("Congratulations, your Slowpoke has evolved into a Slowking!");
												p.getPC().get(p.getIndex(op)).addT1PointsInvested(100);
												done = true;
												repeat = true;
												break;
											case "0":
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
									System.out.println();
									System.out.println("Evolving Slowpoke costs 100 Tier 1 Points");
									System.out.println("You do not have enough Tier 1 Points to evolve your Slowpoke");
									System.out.println();
									done = true;
								}
							} else {
								System.out.println();
								System.out.println("This Pokemon does not require a special condition to evolve.");
								System.out.println();
							}
						else
							done = true;
				}
			}
		}
	}

	private static void evTrain(Player p, Scanner input) {
		boolean done = false;
		int startPCIndex = 0;
		int pageLimit = 25;
		int endPCIndex = pageLimit;
		String temp;
		while (!done) {
			printOwnedPokemon(p, startPCIndex, endPCIndex);
			System.out.println("Choose a Pokemon to EV Train.");
			System.out.println("Enter the number corresponding to a Pokemon in your PC or enter \"0\" to go back to the main menu.");
			System.out.println("To see the next " + pageLimit + " pokemon in your pc, enter \"next\" or to see the previous " + pageLimit + " pokemon in your pc, enter \"previous\"");
			System.out.println();
			if (input.hasNext()) {
				temp = input.nextLine();		
				if (!isNumeric(temp)) {
					if (!temp.equals("next") && !temp.equals("previous")) {
						System.out.println();
						System.out.println("Input does not match an available choice.");
						System.out.println();
					} else if (temp.equals("next") && endPCIndex + pageLimit - p.getPC().size() < pageLimit) {
						System.out.println();
						startPCIndex += pageLimit;
						endPCIndex += pageLimit;
					} else if (temp.equals("previous") && startPCIndex - pageLimit >= 0) {
						System.out.println();
						startPCIndex -= pageLimit;
						endPCIndex -= pageLimit;
					} else {
						System.out.println();
						System.out.println("You have reached the limits of your PC.");
						System.out.println();
					}
				} else {
					int num = Integer.parseInt(temp);
					if (num < 0 || num >= p.getPC().size() + 1) {
						System.out.println();
						System.out.println("Input does not match an available choice.");
						System.out.println();
					} else if (num != 0) {
						System.out.println();
						System.out.println("Your " + p.getPC().get(num - 1).getName() + "'s EVs:");
						System.out.println("Health EV: " + p.getPC().get(num - 1).getHealthEV());
						System.out.println("Attack EV: " + p.getPC().get(num - 1).getAttackEV());
						System.out.println("Defense EV: " + p.getPC().get(num - 1).getDefenseEV());
						System.out.println("Special Attack EV: " + p.getPC().get(num - 1).getSpecialAttackEV());
						System.out.println("Special Defense EV: " + p.getPC().get(num - 1).getSpecialDefenseEV());
						System.out.println("Speed EV: " + p.getPC().get(num - 1).getSpeedEV());
						System.out.println();
						if ((p.getPC().get(num - 1).getHealthEV() + p.getPC().get(num - 1).getAttackEV() + p.getPC().get(num - 1).getDefenseEV() + p.getPC().get(num - 1).getSpecialAttackEV() + p.getPC().get(num - 1).getSpecialDefenseEV() + p.getPC().get(num - 1).getSpeedEV()) < 508) {
							// a Pokemon can have a total of 508 EVs maximum distributed amongst its stats
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
										trainEV(p, input, num, "Health");
										finished = true;
										break;
									case "2":
										System.out.println();
										trainEV(p, input, num, "Attack");
										finished = true;
										break;
									case "3":
										System.out.println();
										trainEV(p, input, num, "Defense");
										finished = true;
										break;
									case "4":
										System.out.println();
										trainEV(p, input, num, "Special Attack");
										finished = true;
										break;
									case "5":
										System.out.println();
										trainEV(p, input, num, "Special Defense");
										finished = true;
										break;
									case "6":
										System.out.println();
										trainEV(p, input, num, "Speed");
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
					} else
						done = true;
				}
			}
		}
	}

	private static void trainEV(Player p, Scanner input, int num, String ev) {
		String typePoints = chooseTypePoints(p, num);
		System.out.println("Each EV Point costs 1 " + typePoints.substring(0, typePoints.length() - 1));
		System.out.println("You can invest a maximum of 252 points into one stat, and a maximum of 508 points total into one Pokemon.");
		boolean invested = false;
		switch(typePoints) {
		case "Tier 1 Points":
			System.out.println("You have " + p.getTier1() + " Tier 1 Points.");
			break;
		case "Tier 2 Points":
			System.out.println("You have " + p.getTier2() + " Tier 2 Points.");
			break;
		case "Tier 3 Points":
			System.out.println("You have " + p.getTier3() + " Tier 3 Points.");
			break;
		case "Tier 4 Points":
			System.out.println("You have " + p.getTier4() + " Tier 4 Points.");
			break;
		case "Tier 5 Points":
			System.out.println("You have " + p.getTier5() + " Tier 5 Points.");
			break;
		}
		switch (ev) {
		case "Health":
			System.out.println("Your " + p.getPC().get(num - 1).getName() + " has " + p.getPC().get(num - 1).getHealthEV() + " Health EVs.");
			break;
		case "Attack":
			System.out.println("Your " + p.getPC().get(num - 1).getName() + " has " + p.getPC().get(num - 1).getAttackEV() + " Attack EVs.");
			break;
		case "Defense":
			System.out.println("Your " + p.getPC().get(num - 1).getName() + " has " + p.getPC().get(num - 1).getDefenseEV() + " Defense EVs.");
			break;
		case "Special Attack":
			System.out.println("Your " + p.getPC().get(num - 1).getName() + " has " + p.getPC().get(num - 1).getSpecialAttackEV() + " Special Attack EVs.");
			break;
		case "Special Defense":
			System.out.println("Your " + p.getPC().get(num - 1).getName() + " has " + p.getPC().get(num - 1).getSpecialDefenseEV() + " Special Defense EVs.");
			break;
		case "Speed":
			System.out.println("Your " + p.getPC().get(num - 1).getName() + " has " + p.getPC().get(num - 1).getSpeedEV() + " Speed EVs.");
			break;
		}
		System.out.println("How many points would you like to invest?");
		System.out.println();
		String temp;
		while (!invested) {
			temp = input.nextLine();
			if (!isNumeric(temp)) {
				System.out.println();
				System.out.println("Input does not match an available choice, please input a valid choice.");
				System.out.println();
			} else {
				int tempNum = Integer.parseInt(temp);
				boolean limit = true;
				int totalEVs = tempNum + p.getPC().get(num - 1).getHealthEV() + p.getPC().get(num - 1).getAttackEV() + p.getPC().get(num - 1).getDefenseEV() + p.getPC().get(num - 1).getSpecialAttackEV() + p.getPC().get(num - 1).getSpecialDefenseEV() + p.getPC().get(num - 1).getSpeedEV();
				// on top of the max for total EVs being 508 points, one stat can only have 252 EV points
				switch(ev) {
				case "Health":
					if (tempNum < 0 || (tempNum + p.getPC().get(num - 1).getHealthEV()) > 252 || totalEVs > 508)
						limit = false;
					break;
				case "Attack":
					if (tempNum < 0 || (tempNum + p.getPC().get(num - 1).getAttackEV()) > 252 ||  totalEVs > 508)
						limit = false;
					break;
				case "Defense":
					if (tempNum < 0 || (tempNum + p.getPC().get(num - 1).getDefenseEV()) > 252 ||  totalEVs > 508)
						limit = false;
					break;
				case "Special Attack":
					if (tempNum < 0 || (tempNum + p.getPC().get(num - 1).getSpecialAttackEV()) > 252 ||  totalEVs > 508)
						limit = false;
					break;
				case "Special Defense":
					if (tempNum < 0 || (tempNum + p.getPC().get(num - 1).getSpecialDefenseEV()) > 252 ||  totalEVs > 508)
						limit = false;
					break;
				case "Speed":
					if (tempNum < 0 || (tempNum + p.getPC().get(num - 1).getSpeedEV()) > 252 ||  totalEVs > 508)
						limit = false;
					break;
				}
				if (limit) {
					System.out.println();
					switch(typePoints) {
					case "Tier 1 Points":
						if (tempNum > p.getTier1())
							System.out.println("You have less points than the number you entered.  Please input a valid choice.");
						else
							invested = true;
						break;
					case "Tier 2 Points":
						if (tempNum > p.getTier2())
							System.out.println("You have less points than the number you entered.  Please input a valid choice.");
						else
							invested = true;
						break;
					case "Tier 3 Points":
						if (tempNum > p.getTier3())
							System.out.println("You have less points than the number you entered.  Please input a valid choice.");
						else
							invested = true;
						break;
					case "Tier 4 Points":
						if (tempNum > p.getTier4())
							System.out.println("You have less points than the number you entered.  Please input a valid choice.");
						else
							invested = true;
						break;
					case "Tier 5 Points":
						if (tempNum > p.getTier5())
							System.out.println("You have less points than the number you entered.  Please input a valid choice.");
						else
							invested = true;
						break;
					}
					if (invested) {
						switch(typePoints) {
						case "Tier 1 Points":
							p.spendTier1(tempNum);
							p.getPC().get(num - 1).addT1PointsInvested(100);
							break;
						case "Tier 2 Points":
							p.spendTier2(tempNum);
							p.getPC().get(num - 1).addT2PointsInvested(100);
							break;
						case "Tier 3 Points":
							p.spendTier3(tempNum);
							p.getPC().get(num - 1).addT3PointsInvested(100);
							break;
						case "Tier 4 Points":
							p.spendTier4(tempNum);
							p.getPC().get(num - 1).addT4PointsInvested(100);
							break;
						case "Tier 5 Points":
							p.spendTier5(tempNum);
							p.getPC().get(num - 1).addT5PointsInvested(100);
							break;
						}
						switch (ev) {
						case "Health":
							p.getPC().get(num - 1).addHealthEV(tempNum);
							System.out.println("Your " + p.getPC().get(num - 1).getName() + " now has " + p.getPC().get(num - 1).getHealthEV() + " Health EVs.");
							break;
						case "Attack":
							p.getPC().get(num - 1).addAttackEV(tempNum);
							System.out.println("Your " + p.getPC().get(num - 1).getName() + " now has " + p.getPC().get(num - 1).getAttackEV() + " Attack EVs.");
							break;
						case "Defense":
							p.getPC().get(num - 1).addDefenseEV(tempNum);
							System.out.println("Your " + p.getPC().get(num - 1).getName() + " now has " + p.getPC().get(num - 1).getDefenseEV() + " Defense EVs.");
							break;
						case "Special Attack":
							p.getPC().get(num - 1).addSpecialAttackEV(tempNum);
							System.out.println("Your " + p.getPC().get(num - 1).getName() + " now has " + p.getPC().get(num - 1).getSpecialAttackEV() + " Special Attack EVs.");
							break;
						case "Special Defense":
							p.getPC().get(num - 1).addSpecialDefenseEV(tempNum);
							System.out.println("Your " + p.getPC().get(num - 1).getName() + " now has " + p.getPC().get(num - 1).getSpecialDefenseEV() + " Special Defense EVs.");
							break;
						case "Speed":
							p.getPC().get(num - 1).addSpeedEV(tempNum);
							System.out.println("Your " + p.getPC().get(num - 1).getName() + " now has " + p.getPC().get(num - 1).getSpeedEV() + " Speed EVs.");
							break;
						}
					}
					System.out.println();
				} else {
					System.out.println();
					System.out.println("The number you have entered is either negative or would make the EV greater than 252 or would make this Pokemon have more than 508 total EVs.  Please input a valid choice.");
					System.out.println();
				}
			}
		}
	}

	private static void resetEVs(Player p, Scanner input) {
		boolean done = false;
		int startPCIndex = 0;
		int pageLimit = 25;
		int endPCIndex = pageLimit;
		String temp;
		while (!done) {
			printOwnedPokemon(p, startPCIndex, endPCIndex);
			System.out.println("Choose a Pokemon whose EVs you would like to reset.");
			System.out.println("NOTE: YOU WILL NOT BE REFUNDED THE POINTS SPENT IN GETTING THE RESET EVS");
			System.out.println("Enter the number corresponding to a Pokemon in your PC or enter \"0\" to go back to the main menu.");
			System.out.println("To see the next " + pageLimit + " pokemon in your pc, enter \"next\" or to see the previous " + pageLimit + " pokemon in your pc, enter \"previous\"");
			System.out.println();
			if (input.hasNext()) {
				temp = input.nextLine();
				if (!isNumeric(temp)) {
					if (!temp.equals("next") && !temp.equals("previous")) {
						System.out.println();
						System.out.println("Input does not match an available choice.");
						System.out.println();
					} else if (temp.equals("next") && endPCIndex + pageLimit - p.getPC().size() < pageLimit) {
						System.out.println();
						startPCIndex += pageLimit;
						endPCIndex += pageLimit;
					} else if (temp.equals("previous") && startPCIndex - pageLimit >= 0) {
						System.out.println();
						startPCIndex -= pageLimit;
						endPCIndex -= pageLimit;
					} else {
						System.out.println();
						System.out.println("You have reached the limits of your PC.");
						System.out.println();
					}
				} else {
					int num = Integer.parseInt(temp);
					if (num < 0 || num >= p.getPC().size() + 1) {
						System.out.println();
						System.out.println("Input does not match an available choice.");
						System.out.println();
					} else if (num != 0) {
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
									done = true;
									repeat = true;
									break;
								default:
									System.out.println();
									System.out.println("Input does not match an available choice.");
									System.out.println();
								}
						}
					} else
						System.out.println();
				}
			}
		}
	}

	private static void changeNature(Player p, Scanner input) {
		boolean done = false;
		int startPCIndex = 0;
		int pageLimit = 25;
		int endPCIndex = pageLimit;
		String temp;
		while (!done) {
			printOwnedPokemon(p, startPCIndex, endPCIndex);
			System.out.println("Choose the pokemon whose nature you want to change.");
			System.out.println("Enter the number corresponding to a Pokemon in your PC or enter \"0\" to go back to the main menu.");
			System.out.println("To see the next " + pageLimit + " pokemon in your pc, enter \"next\" or to see the previous " + pageLimit + " pokemon in your pc, enter \"previous\"");
			System.out.println();
			if (input.hasNext()) {
				temp = input.nextLine();
				if (!isNumeric(temp)) {
					if (!temp.equals("next") && !temp.equals("previous")) {
						System.out.println();
						System.out.println("Input does not match an available choice.");
						System.out.println();
					} else if (temp.equals("next") && endPCIndex + pageLimit - p.getPC().size() < pageLimit) {
						System.out.println();
						startPCIndex += pageLimit;
						endPCIndex += pageLimit;
					} else if (temp.equals("previous") && startPCIndex - pageLimit >= 0) {
						System.out.println();
						startPCIndex -= pageLimit;
						endPCIndex -= pageLimit;
					} else {
						System.out.println();
						System.out.println("You have reached the limits of your PC.");
						System.out.println();
					}
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
								while (!finished)
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
	}

	private static void changeNatureHelper(Player p, int num, Scanner input, String typePoints, String nature) {
		if (p.getPC().get(num - 1).getNature().equals(nature)) {
			System.out.println();
			System.out.println("This Pokemon already has the nature you selected.");
			System.out.println();
		} else {
			System.out.println();
			p.getPC().get(num - 1).setNature(nature);
			switch(typePoints) {
			case "Tier 1 Points":
				p.spendTier1(100);
				p.getPC().get(num - 1).addT1PointsInvested(100);
				break;
			case "Tier 2 Points":
				p.spendTier2(100);
				p.getPC().get(num - 1).addT2PointsInvested(100);
				break;
			case "Tier 3 Points":
				p.spendTier3(100);
				p.getPC().get(num - 1).addT3PointsInvested(100);
				break;
			case "Tier 4 Points":
				p.spendTier4(100);
				p.getPC().get(num - 1).addT4PointsInvested(100);
				break;
			case "Tier 5 Points":
				p.spendTier5(100);
				p.getPC().get(num - 1).addT5PointsInvested(100);
				break;
			}
			System.out.println("Your " + p.getPC().get(num - 1).getName() + " now has a " + nature + " nature.");
			System.out.println();
		}
	}

	private static void recycle(Player p, Scanner input) {
		boolean done = false;
		int startPCIndex = 0;
		int pageLimit = 25;
		int endPCIndex = pageLimit;
		String temp;
		while (!done) {
			printOwnedPokemon(p, startPCIndex, endPCIndex);
			System.out.println("Choose a Pokemon to recycle.");
			System.out.println("You will receive points equal to one tenth of the Pokemon's IV percentage combined with half of the points invested into the Pokemon");
			System.out.println("Enter the number corresponding to a Pokemon in your PC or enter \"0\" to go back to the main menu.");
			System.out.println("To see the next " + pageLimit + " pokemon in your pc, enter \"next\" or to see the previous " + pageLimit + " pokemon in your pc, enter \"previous\"");
			System.out.println();
			if (input.hasNext()) {
				temp = input.nextLine();
				if (!isNumeric(temp)) {
					if (!temp.equals("next") && !temp.equals("previous")) {
						System.out.println();
						System.out.println("Input does not match an available choice.");
						System.out.println();
					} else if (temp.equals("next") && endPCIndex + pageLimit - p.getPC().size() < pageLimit) {
						System.out.println();
						startPCIndex += pageLimit;
						endPCIndex += pageLimit;
					} else if (temp.equals("previous") && startPCIndex - pageLimit >= 0) {
						System.out.println();
						startPCIndex -= pageLimit;
						endPCIndex -= pageLimit;
					} else {
						System.out.println();
						System.out.println("You have reached the limits of your PC.");
						System.out.println();
					}
				} else {
					int num = Integer.parseInt(temp);
					if (num < 0 || num >= p.getPC().size() + 1) {
						System.out.println();
						System.out.println("Input does not match an available choice.");
						System.out.println();
					} else {
						if (num != 0) {
							// the number of points a Pokemon gives you for being recycled is determined by its total IV percentage divided by 10 combined with half the points the player invested into the Pokemon
							// example: if a pokemon has 83.45657% total IV percentage, the player will get 8 points because 83.45657/10 = 8.345657 which is 8 when rounded
							System.out.println();
							System.out.println(p.getPC().get(num - 1));
							System.out.println();
							int numPoints = roundProperlyRecyclePoints(p.getPC().get(num - 1).getTotalIVPercentage()/10);
							if (p.getPC().get(num - 1).isShiny())
								numPoints *= 50;
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
										p.getPC().get(num - 1).refundPoints(p);
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
	}

	private static void convertPoints(Player p, Scanner input) {
		boolean done = false;
		while (!done) {
			System.out.println("You have:");
			System.out.println(p.getTier1() + " Tier 1 Points");
			System.out.println(p.getTier2() + " Tier 2 Points");
			System.out.println(p.getTier3() + " Tier 3 Points");
			System.out.println(p.getTier4() + " Tier 4 Points");
			System.out.println(p.getTier5() + " Tier 5 Points");
			System.out.println();
			System.out.println("How would you like to convert your points?");
			System.out.println("Input the number corresponding to your choice or enter \"0\" to go back to the main menu.");
			System.out.println("1) 100 Tier 1 Points to 10 Tier 2 Points");
			System.out.println("2) 100 Tier 2 Points to 10 Tier 3 Points");
			System.out.println("3) 100 Tier 3 Points to 10 Tier 4 Points");
			System.out.println("4) 100 Tier 4 Points to 10 Tier 5 Points");
			System.out.println("5) 10 Tier 5 Points to 100 Tier 4 Points");
			System.out.println("6) 10 Tier 4 Points to 100 Tier 3 Points");
			System.out.println("7) 10 Tier 3 Points to 100 Tier 2 Points");
			System.out.println("8) 10 Tier 2 Points to 100 Tier 1 Points");
			System.out.println();
			if (input.hasNext()) {
				switch(input.nextLine()) {
				case "1":
					if (p.getTier1() >= 100) {
						p.spendTier1(100);
						p.addTier2(10);	
					} else {
						System.out.println();
						System.out.println("You do not have enough Tier 1 Points to make this conversiuon.");
						System.out.println();
					}
					break;
				case "2":
					if (p.getTier2() >= 100) {
						p.spendTier2(100);
						p.addTier3(10);	
					} else {
						System.out.println();
						System.out.println("You do not have enough Tier 1 Points to make this conversiuon.");
						System.out.println();
					}
					break;
				case "3":
					if (p.getTier3() >= 100) {
						p.spendTier3(100);
						p.addTier4(10);	
					} else {
						System.out.println();
						System.out.println("You do not have enough Tier 1 Points to make this conversiuon.");
						System.out.println();
					}
					break;
				case "4":
					if (p.getTier4() >= 100) {
						p.spendTier4(100);
						p.addTier5(10);	
					} else {
						System.out.println();
						System.out.println("You do not have enough Tier 1 Points to make this conversiuon.");
						System.out.println();
					}
					break;
				case "5":
					if (p.getTier5() >= 10) {
						p.spendTier5(10);
						p.addTier4(100);	
					} else {
						System.out.println();
						System.out.println("You do not have enough Tier 1 Points to make this conversiuon.");
						System.out.println();
					}
					break;
				case "6":
					if (p.getTier4() >= 10) {
						p.spendTier4(10);
						p.addTier3(100);	
					} else {
						System.out.println();
						System.out.println("You do not have enough Tier 1 Points to make this conversiuon.");
						System.out.println();
					}
					break;
				case "7":
					if (p.getTier3() >= 10) {
						p.spendTier3(10);
						p.addTier2(100);	
					} else {
						System.out.println();
						System.out.println("You do not have enough Tier 1 Points to make this conversiuon.");
						System.out.println();
					}
					break;
				case "8":
					if (p.getTier2() >= 10) {
						p.spendTier2(10);
						p.addTier1(100);	
					} else {
						System.out.println();
						System.out.println("You do not have enough Tier 1 Points to make this conversiuon.");
						System.out.println();
					}
					break;
				case "0":
					done = true;
					break;
				default:
					System.out.println();
					System.out.println("Input does not match an available choice.");
					System.out.println();
				}
			}
			if (!done) {
				System.out.println("Would you like to continue converting points?");
				System.out.println("1) Yes");
				System.out.println("2) No");
				System.out.println();
				if (input.hasNext())
					switch (input.nextLine()) {
					case "1":
						System.out.println();
						break;
					case "2":
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

	private static void printOwnedPokemon(Player p, int startPCIndex, int endPCIndex) {
		// go through the user's pc and print every pokemon starting from the startPCIndex and ending right before endPCIndex
		// this allows a page limit so that the user isn't flooded with pokemon
		// if a pokemon is marked as favorite, it will be printed with [FAVORITE] next to it
		System.out.println("Your Pokemon:");
		for (int i = startPCIndex; i < p.getPC().size() && i < endPCIndex; i++)
			if (p.getPC().get(i).getNickname().equals(p.getPC().get(i).getName()))
				if (p.getPC().get(i).isFavorite())
					System.out.println(i + 1 + ") " + p.getPC().get(i).getNickname() + " [FAVORITE]");
				else
					System.out.println(i + 1 + ") " + p.getPC().get(i).getNickname());
			else
				if (p.getPC().get(i).isFavorite())
					System.out.println(i + 1 + ") " + p.getPC().get(i).getNickname() + " (" + p.getPC().get(i).getName() + ")" + " [FAVORITE]");
				else
					System.out.println(i + 1 + ") " + p.getPC().get(i).getNickname() + " (" + p.getPC().get(i).getName() + ")");
		System.out.println();
	}

	private static String chooseTypePoints(Player p, int num) {
		// the tier of points a Pokemon gives when being recycled or requires when being trained is determined by its spawn rate
		// the rarer the Pokemon, the higher tier points it gives
		// Pokemon with the egg group Undiscovered or Ditto are the only ones that grant Tier 5 Points
		// there are 5 possible tiers
		if (p.getPC().get(num - 1).getPokemon().getEggGroup()[0].equals("Undiscovered") || p.getPC().get(num - 1).getPokemon().getEggGroup()[0].equals("Ditto"))
			return "Tier 5 Points";
		if (p.getPC().get(num - 1).getPokemon().getSpawnRate() <= 11)
			return "Tier 1 Points";
		if (p.getPC().get(num - 1).getPokemon().getSpawnRate() <= 17 && p.getPC().get(num - 1).getPokemon().getSpawnRate() > 11)
			return "Tier 2 Points";
		if (p.getPC().get(num - 1).getPokemon().getSpawnRate() <= 24 && p.getPC().get(num - 1).getPokemon().getSpawnRate() > 17)
			return "Tier 3 Points";
		return "Tier 4 Points";
	}

	private static void save(Player p) throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("saves.ser"));
		oos.writeObject(p);
		oos.flush();
		oos.close();
	}

	private static int roundProperlyRecyclePoints(double d) {
		// proper rounding
		if (d >= 0.5 && d < 1.5)
			return 1;
		if (d >= 1.5 && d < 2.5)
			return 2;
		if (d >= 2.5 && d < 3.5)
			return 3;
		if (d >= 3.5 && d < 4.5)
			return 4;
		if (d >= 4.5 && d < 5.5)
			return 5;
		if (d >= 5.5 && d < 6.5)
			return 6;
		if (d >= 6.5 && d < 7.5)
			return 7;
		if (d >= 7.5 && d < 8.5)
			return 8;
		if (d >= 8.5 && d < 9.5)
			return 9;
		if (d > 9.5)
			return 10;
		return 1;
	}

	private static void printPlayerData(Player p) {
		System.out.println(p);
	}
}