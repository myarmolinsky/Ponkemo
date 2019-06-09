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
		pokedex.add(new Pokemon("Magnemite", "Electric", "Steel", 25, 35, 70, 95, 55, 45, 6, new String[] {"Mineral"}, -1, new String[] {"Magnemite", "Magneton", "Magnezone"}, 0, 30));
		pokedex.add(new Pokemon("Magneton", "Electric", "Steel", 50, 60, 95, 120, 70, 70, 24, new String[] {"Mineral"}, -1, new String[] {"Magnemite", "Magneton", "Magnezone"}, 1, -1));
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
		pokedex.add(new Pokemon("Lickitung", "Normal", null, 90, 55, 75, 60, 75, 30, 27, new String[] {"Monster"}, 50, new String[] {"Lickitung", "Lickilicky"}, 0, 0));
		pokedex.add(new Pokemon("Koffing", "Poison", null, 40, 65, 95, 60, 45, 35, 6, new String[] {"Amorphous"}, 50, new String[] {"Koffing", "Weezing"}, 0, 35));
		pokedex.add(new Pokemon("Weezing", "Poison", null, 65, 90, 120, 85, 70, 60, 24, new String[] {"Amorphous"}, 50, new String[] {"Koffing", "Weezing"}, 1, 0));
		pokedex.add(new Pokemon("Rhyhorn", "Ground", "Rock", 80, 85, 95, 30, 30, 25, 17, new String[] {"Field", "Monster"}, 50, new String[] {"Rhyhorn", "Rhydon", "Rhyperior"}, 0, 42));
		pokedex.add(new Pokemon("Rhydon", "Ground", "Rock", 105, 130, 120, 45, 45, 40, 24, new String[] {"Field", "Monster"}, 50, new String[] {"Rhyhorn", "Rhydon", "Rhyperior"}, 1, -1));
		pokedex.add(new Pokemon("Chansey", "Normal", null, 250, 5, 5, 35, 105, 50, 29, new String[] {"Fairy"}, 0, new String[] {"Happiny", "Chansey", "Blissey"}, 1, -1));
		pokedex.add(new Pokemon("Tangela", "Grass", null, 65, 55, 115, 100, 40, 60, 27, new String[] {"Grass"}, 50, new String[] {"Tangela", "Tangrowth"}, 0, -1));
		pokedex.add(new Pokemon("Kangaskhan", "Normal", null, 105, 95, 80, 40, 80, 90, 27, new String[] {"Monster"}, 0, new String[] {"Kangaskhan"}, 0, 0));
		pokedex.add(new Pokemon("Horsea", "Water", null, 30, 40, 70, 70, 25, 60, 2, new String[] {"Water 1", "Dragon"}, 50, new String[] {"Horsea", "Seadra", "Kingdra"}, 0, 32));
		pokedex.add(new Pokemon("Seadra", "Water", null, 55, 65, 95, 95, 45, 85, 21, new String[] {"Water 1", "Dragon"}, 50, new String[] {"Horsea", "Seadra", "Kingdra"}, 1, -1));
		pokedex.add(new Pokemon("Goldeen", "Water", null, 45, 67, 60, 35, 50, 63, 2, new String[] {"Water 2"}, 50, new String[] {"Goldeen", "Seaking"}, 0, 33));
		pokedex.add(new Pokemon("Seaking", "Water", null, 80, 92, 65, 65, 80, 68, 24, new String[] {"Water 2"}, 50, new String[] {"Goldeen", "Seaking"}, 1, 0));
		pokedex.add(new Pokemon("Staryu", "Water", null, 30, 45, 55, 70, 55, 85, 2, new String[] {"Water 3"}, -1, new String[] {"Staryu", "Starmie"}, 0, -1));
		pokedex.add(new Pokemon("Starmie", "Water", "Psychic", 60, 75, 85, 100, 85, 115, 24, new String[] {"Water 3"}, -1, new String[] {"Staryu", "Starmie"}, 1, 0));
		pokedex.add(new Pokemon("Mr. Mime", "Psychic", "Fairy", 40, 45, 65, 100, 120, 95, 27, new String[] {"Human-Like"}, 50, new String[] {"Mime Jr.", "Mr. Mime"}, 1, 0));
		pokedex.add(new Pokemon("Scyther", "Bug", "Flying", 70, 110, 80, 55, 80, 105, 27, new String[] {"Bug"}, 50, new String[] {"Scyther", "Scizor"}, 0, -1));
		pokedex.add(new Pokemon("Jynx", "Ice", "Psychic", 65, 50, 35, 115, 95, 95, 27, new String[] {"Human-Like"}, 0, new String[] {"Smoochum", "Jynx"}, 1, 0));
		pokedex.add(new Pokemon("Electabuzz", "Electric", null, 65, 83, 57, 95, 85, 105, 27, new String[] {"Human-Like"}, 75, new String[] {"Elekid", "Electabuzz", "Electivire"}, 1, -1));
		pokedex.add(new Pokemon("Magmar", "Fire", null, 65, 95, 57, 100, 85, 93, 27, new String[] {"Human-Like"}, 75, new String[] {"Magby", "Magmar", "Magmortar"}, 1, -1));
		pokedex.add(new Pokemon("Pinsir", "Bug", null, 65, 125, 100, 55, 70, 85, 27, new String[] {"Bug"}, 50, new String[] {"Pinsir"}, 0, 0));
		pokedex.add(new Pokemon("Tauros", "Normal", null, 75, 100, 95, 40, 70, 110, 27, new String[] {"Field"}, 100, new String[] {"Tauros"}, 0, 0));
		pokedex.add(new Pokemon("Magikarp", "Water", null, 20, 10, 55, 15, 20, 80, 0, new String[] {"Water 2", "Dragon"}, 50, new String[] {"Magikarp", "Gyarados"}, 0, 20));
		pokedex.add(new Pokemon("Gyarados", "Water", "Flying", 95, 125, 79, 60, 100, 81, 27, new String[] {"Water 2", "Dragon"}, 50, new String[] {"Magikarp", "Gyarados"}, 1, 0));
		pokedex.add(new Pokemon("Lapras", "Water", "Ice", 130, 85, 80, 85, 95, 60, 27, new String[] {"Water 1", "Monster"}, 50, new String[] {"Lapras"}, 0, 0));
		pokedex.add(new Pokemon("Ditto", "Normal", null, 48, 48, 48, 48, 48, 48, 28, new String[] {"Ditto"}, -1, new String[] {"Ditto"}, 0, 0));
		pokedex.add(new Pokemon("Eevee", "Normal", null, 55, 55, 50, 45, 65, 55, 27, new String[] {"Field"}, 87.5, new String[] {"Eevee", "Vaporeon", "Jolteon", "Flareon", "Espeon", "Umbreon", "Leafeon", "Glaceon"}, 0, -1));
		pokedex.add(new Pokemon("Vaporeon", "Water", null, 130, 65, 60, 110, 95, 65, 27, new String[] {"Field"}, 87.5, new String[] {"Eevee", "Vaporeon"}, 1, 0));
		pokedex.add(new Pokemon("Jolteon", "Electric", null, 65, 65, 60, 110, 95, 130, 27, new String[] {"Field"}, 87.5, new String[] {"Eevee", "Jolteon"}, 1, 0));
		pokedex.add(new Pokemon("Flareon", "Fire", null, 65, 130, 60, 95, 110, 65, 27, new String[] {"Field"}, 87.5, new String[] {"Eevee", "Flareon"}, 1, 0));
		pokedex.add(new Pokemon("Porygon", "Normal", null, 65, 60, 70, 85, 75, 40, 27, new String[] {"Mineral"}, -1, new String[] {"Porygon", "Porygon2", "Porygon-Z"}, 0, -1));
		pokedex.add(new Pokemon("Omanyte", "Rock", "Water", 35, 40, 100, 90, 55, 35, 27, new String[] {"Water 1", "Water 3"}, 87.5, new String[] {"Omanyte", "Omastar"}, 0, 40));
		pokedex.add(new Pokemon("Omastar", "Rock", "Water", 70, 60, 125, 115, 70, 55, 27, new String[] {"Water 1", "Water 3"}, 87.5, new String[] {"Omanyte", "Omastar"}, 1, 0));
		pokedex.add(new Pokemon("Kabuto", "Rock", "Water", 30, 80, 90, 55, 45, 55, 27, new String[] {"Water 1", "Water 3"}, 87.5, new String[] {"Kabuto", "Kabutops"}, 0, 40));
		pokedex.add(new Pokemon("Kabutops", "Rock", "Water", 60, 115, 105, 65, 70, 80, 27, new String[] {"Water 1", "Water 3"}, 87.5, new String[] {"Kabuto", "Kabutops"}, 1, 0));
		pokedex.add(new Pokemon("Aerodactyl", "Rock", "Flying", 80, 105, 65, 60, 75, 130, 27, new String[] {"Flying"}, 87.5, new String[] {"Aerodactyl"}, 0, 0));
		pokedex.add(new Pokemon("Snorlax", "Normal", null, 160, 110, 65, 65, 110, 30, 30, new String[] {"Monster"}, 87.5, new String[] {"Munchlax", "Snorlax"}, 1, 0));
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
		pokedex.add(new Pokemon("Togepi", "Fairy", null, 35, 20, 65, 40, 65, 20, 6, new String[] {"Flying", "Fairy"}, 87.5, new String[] {"Togepi", "Togetic", "Togekiss"}, 0, -1));
		pokedex.add(new Pokemon("Togetic", "Fairy", "Flying", 55, 40, 85, 80, 105, 40, 21, new String[] {"Flying", "Fairy"}, 87.5, new String[] {"Togepi", "Togetic", "Togekiss"}, 1, -1));
		pokedex.add(new Pokemon("Natu", "Psychic", "Flying", 40, 50, 45, 70, 45, 70, 6, new String[] {"Flying"}, 50, new String[] {"Natu", "Xatu"}, 0, 25));
		pokedex.add(new Pokemon("Xatu", "Psychic", "Flying", 65, 75, 70, 95, 70, 95, 21, new String[] {"Flying"}, 50, new String[] {"Natu", "Xatu"}, 1, 0));
		pokedex.add(new Pokemon("Mareep", "Electric", null, 55, 40, 40, 65, 45, 35, 1, new String[] {"Monster", "Field"}, 50, new String[] {"Mareep", "Flaaffy", "Ampharos"}, 0, 15));
		pokedex.add(new Pokemon("Flaaffy", "Electric", null, 70, 55, 55, 80, 60, 45, 17, new String[] {"Monster", "Field"}, 50, new String[] {"Mareep", "Flaaffy", "Ampharos"}, 1, 30));
		pokedex.add(new Pokemon("Ampharos", "Electric", null, 90, 75, 85, 115, 90, 55, 27, new String[] {"Monster", "Field"}, 50, new String[] {"Mareep", "Flaaffy", "Ampharos"}, 2, 0));
		pokedex.add(new Pokemon("Bellossom", "Grass", null, 75, 80, 95, 90, 100, 50, 27, new String[] {"Grass"}, 50, new String[] {"Oddish", "Gloom", "Vileplume", "Bellossom"}, 2, 0));
		pokedex.add(new Pokemon("Marill", "Water", "Fairy", 70, 20, 50, 20, 50, 40, 6, new String[] {"Water 1", "Fairy"}, 50, new String[] {"Azurill", "Marill", "Azumarill"}, 1, 18));
		pokedex.add(new Pokemon("Azumarill", "Water", "Fairy", 100, 50, 80, 60, 80, 50, 21, new String[] {"Water 1", "Fairy"}, 50, new String[] {"Azurill", "Marill", "Azumarill"}, 2, 0));
		pokedex.add(new Pokemon("Sudowoodo", "Rock", null, 70, 100, 115, 30, 65, 30, 23, new String[] {"Mineral"}, 50, new String[] {"Bonsly", "Sudowoodo"}, 1, 0));
		pokedex.add(new Pokemon("Politoed", "Water", null, 90, 75, 75, 90, 100, 70, 27, new String[] {"Water 1"}, 50, new String[] {"Poliwag", "Poliwhirl", "Poliwrath", "Politoed"}, 2, 0));
		pokedex.add(new Pokemon("Hoppip", "Grass", "Flying", 35, 35, 40, 35, 55, 50, 0, new String[] {"Fairy", "Grass"}, 50, new String[] {"Hoppip", "Skiploom", "Jumpluff"}, 0, 18));
		pokedex.add(new Pokemon("Skiploom", "Grass", "Flying", 55, 45, 50, 45, 65, 80, 17, new String[] {"Fairy", "Grass"}, 50, new String[] {"Hoppip", "Skiploom", "Jumpluff"}, 1, 27));
		pokedex.add(new Pokemon("Jumpluff", "Grass", "Flying", 75, 55, 70, 55, 95, 110, 27, new String[] {"Fairy", "Grass"}, 50, new String[] {"Hoppip", "Skiploom", "Jumpluff"}, 2, 0));
		pokedex.add(new Pokemon("Aipom", "Normal", null, 55, 70, 55, 40, 55, 85, 27, new String[] {"Field"}, 50, new String[] {"Aipom", "Ambipom"}, 0, -1));
		pokedex.add(new Pokemon("Sunkern", "Grass", null, 30, 30, 30, 30, 30, 30, 1, new String[] {"Grass"}, 50, new String[] {"Sunkern", "Sunflora"}, 0, -1));
		pokedex.add(new Pokemon("Sunflora", "Grass", null, 75, 75, 55, 105, 85, 30, 17, new String[] {"Grass"}, 50, new String[] {"Sunkern", "Sunflora"}, 1, 0));
		pokedex.add(new Pokemon("Yanma", "Bug", "Flying", 65, 65, 45, 75, 45, 95, 21, new String[] {"Bug"}, 50, new String[] {"Yanma", "Yanmega"}, 0, -1));
		pokedex.add(new Pokemon("Wooper", "Water", "Ground", 55, 45, 45, 25, 25, 15, 0, new String[] {"Water 1", "Field"}, 50, new String[] {"Wooper", "Quagsire"}, 0, 20));
		pokedex.add(new Pokemon("Quagsire", "Water", "Ground", 95, 85, 85, 65, 65, 35, 19, new String[] {"Water 1", "Field"}, 50, new String[] {"Wooper", "Quagsire"}, 1, 0));
		pokedex.add(new Pokemon("Espeon", "Psychic", null, 65, 65, 60, 130, 95, 110, 27, new String[] {"Field"}, 87.5, new String[] {"Eevee", "Espeon"}, 1, 0));
		pokedex.add(new Pokemon("Umbreon", "Dark", null, 95, 65, 110, 60, 130, 65, 27, new String[] {"Field"}, 87.5, new String[] {"Eevee", "Umbreon"}, 1, 0));
		pokedex.add(new Pokemon("Murkrow", "Dark", "Flying", 60, 85, 42, 85, 42, 91, 29, new String[] {"Flying"}, 50, new String[] {"Murkrow", "Honchkrow"}, 0, -1));
		pokedex.add(new Pokemon("Slowking", "Water", "Psychic", 95, 75, 80, 100, 110, 30, 22, new String[] {"Monster", "Water 1"}, 50, new String[] {"Slowpoke", "Slowking"}, 1, 0));
		pokedex.add(new Pokemon("Misdreavus", "Ghost", null, 60, 60, 60, 85, 85, 85, 27, new String[] {"Amorphous"}, 50, new String[] {"Misdreavus", "Mismagius"}, 0, -1));
		pokedex.add(new Pokemon("Unown", "Psychic", null, 48, 72, 48, 72, 48, 48, 2, new String[] {"Unown"}, -1, new String[] {"Unown"}, 0, 0));
		pokedex.add(new Pokemon("Wobbuffet", "Psychic", null, 190, 33, 58, 33, 58, 33, 27, new String[] {"Amorphous"}, 50, new String[] {"Wynaut", "Wobbuffet"}, 1, 0));
		pokedex.add(new Pokemon("Girafarig", "Normal", "Psychic", 70, 80, 65, 90, 65, 85, 24, new String[] {"Field"}, 50, new String[] {"Girafarig"}, 0, 0));
		pokedex.add(new Pokemon("Pineco", "Bug", null, 50, 65, 90, 35, 35, 15, 6, new String[] {"Bug"}, 50, new String[] {"Pineco", "Forretress"}, 0, 31));
		pokedex.add(new Pokemon("Forretress", "Bug", "Steel", 75, 90, 140, 60, 60, 40, 21, new String[] {"Bug"}, 50, new String[] {"Pineco", "Forretress"}, 1, 0));
		pokedex.add(new Pokemon("Dunsparce", "Normal", null, 100, 70, 70, 65, 65, 45, 6, new String[] {"Field"}, 50, new String[] {"Dunsparce"}, 0, 0));
		pokedex.add(new Pokemon("Gligar", "Ground", "Flying", 65, 75, 105, 35, 65, 85, 24, new String[] {"Bug"}, 50, new String[] {"Gligar", "Gliscor"}, 0, -1));
		pokedex.add(new Pokemon("Steelix", "Steel", "Ground", 75, 85, 200, 55, 65, 30, 30, new String[] {"Mineral"}, 50, new String[] {"Onix", "Steelix"}, 1, 0));
		pokedex.add(new Pokemon("Snubbull", "Fairy", null, 60, 80, 50, 40, 40, 30, 6, new String[] {"Field", "Fairy"}, 25, new String[] {"Snubbull", "Granbull"}, 0, 23));
		pokedex.add(new Pokemon("Granbull", "Fairy", null, 90, 120, 75, 60, 60, 45, 21, new String[] {"Field", "Fairy"}, 25, new String[] {"Snubbull", "Granbull"}, 1, 0));
		pokedex.add(new Pokemon("Qwilfish", "Water", "Poison", 65, 95, 85, 55, 55, 85, 27, new String[] {"Water 2"}, 50, new String[] {"Qwilfish"}, 0, 0));
		pokedex.add(new Pokemon("Scizor", "Bug", "Steel", 70, 130, 100, 55, 80, 65, 30, new String[] {"Bug"}, 50, new String[] {"Scyther", "Scizor"}, 1, 0));
		pokedex.add(new Pokemon("Shuckle", "Bug", "Rock", 20, 10, 230, 10, 230, 5, 6, new String[] {"Bug"}, 50, new String[] {"Shuckle"}, 0, 0));
		pokedex.add(new Pokemon("Heracross", "Bug", "Fighting", 80, 125, 75, 40, 95, 85, 27, new String[] {"Bug"}, 50, new String[] {"Heracross"}, 0, 0));
		pokedex.add(new Pokemon("Sneasel", "Dark", "Ice", 55, 95, 55, 35, 75, 115, 24, new String[] {"Field"}, 50, new String[] {"Sneasel", "Weavile"}, 0, -1));
		pokedex.add(new Pokemon("Teddiursa", "Normal", null, 60, 80, 50, 50, 50, 40, 17, new String[] {"Field"}, 50, new String[] {"Teddiursa", "Ursaring"}, 0, 30));
		pokedex.add(new Pokemon("Ursaring", "Normal", null, 90, 130, 75, 75, 75, 55, 24, new String[] {"Field"}, 50, new String[] {"Teddiursa", "Ursaring"}, 1, 0));
		pokedex.add(new Pokemon("Slugma", "Fire", null, 40, 40, 40, 70, 40, 20, 6, new String[] {"Amorphous"}, 50, new String[] {"Slugma", "Magcargo"}, 0, 38));
		pokedex.add(new Pokemon("Magcargo", "Fire", "Rock", 60, 50, 120, 90, 80, 30, 21, new String[] {"Amorphous"}, 50, new String[] {"Slugma", "Magcargo"}, 1, 0));
		pokedex.add(new Pokemon("Swinub", "Ice", "Ground", 50, 50, 40, 30, 30, 50, 2, new String[] {"Field"}, 50, new String[] {"Swinub", "Piloswine", "Mamoswine"}, 0, 33));
		pokedex.add(new Pokemon("Piloswine", "Ice", "Ground", 100, 100, 80, 60, 60, 50, 21, new String[] {"Field"}, 50, new String[] {"Swinub", "Piloswine", "Mamoswine"}, 1, -1));
		pokedex.add(new Pokemon("Corsola", "Water", "Rock", 65, 55, 95, 65, 95, 35, 24, new String[] {"Water 1", "Water 3"}, 25, new String[] {"Corsola"}, 0, 0));
		pokedex.add(new Pokemon("Remoraid", "Water", null, 35, 65, 35, 65, 35, 65, 6, new String[] {"Water 1", "Water 2"}, 50, new String[] {"Remoraid", "Octillery"}, 0, 25));
		pokedex.add(new Pokemon("Octillery", "Water", null, 75, 105, 75, 105, 75, 45, 21, new String[] {"Water 1", "Water 2"}, 50, new String[] {"Remoraid", "Octillery"}, 1, 0));
		pokedex.add(new Pokemon("Delibird", "Ice", "Flying", 45, 55, 45, 65, 45, 75, 27, new String[] {"Water 1", "Field"}, 50, new String[] {"Delibird"}, 0, 0));
		pokedex.add(new Pokemon("Mantine", "Water", "Flying", 85, 40, 70, 80, 140, 70, 30, new String[] {"Water 1"}, 50, new String[] {"Mantyke", "Mantine"}, 1, 0));
		pokedex.add(new Pokemon("Skarmory", "Steel", "Flying", 65, 80, 140, 40, 70, 70, 30, new String[] {"Flying"}, 50, new String[] {"Skarmory"}, 0, 0));
		pokedex.add(new Pokemon("Houndour", "Dark", "Fire", 45, 60, 30, 80, 50, 65, 17, new String[] {"Field"}, 50, new String[] {"Houndour", "Houndoom"}, 0, 24));
		pokedex.add(new Pokemon("Houndoom", "Dark", "Fire", 75, 90, 50, 110, 80, 95, 27, new String[] {"Field"}, 50, new String[] {"Houndour", "Houndoom"}, 1, 0));
		pokedex.add(new Pokemon("Kingdra", "Water", "Dragon", 75, 95, 95, 95, 95, 85, 27, new String[] {"Water 1" , "Dragon"}, 50, new String[] {"Horsea", "Seadra", "Kingdra"}, 2, 0));
		pokedex.add(new Pokemon("Phanpy", "Ground", null, 90, 60, 60, 40, 40, 40, 17, new String[] {"Field"}, 50, new String[] {"Phanpy", "Donphan"}, 0, 25));
		pokedex.add(new Pokemon("Donphan", "Ground", null, 90, 120, 120, 60, 60, 50, 24, new String[] {"Field"}, 50, new String[] {"Phanpy", "Donphan"}, 1, 0));
		pokedex.add(new Pokemon("Porygon2", "Normal", null, 85, 80, 90, 105, 95, 60, 27, new String[] {"Mineral"}, -1, new String[] {"Porygon", "Porygon2", "Porygon-Z"}, 1, -1));
		pokedex.add(new Pokemon("Stantler", "Normal", null, 73, 95, 62, 85, 65, 85, 27, new String[] {"Field"}, 50, new String[] {"Stantler"}, 0, 0));
		pokedex.add(new Pokemon("Smeargle", "Normal", null, 55, 20, 35, 20, 45, 75, 27, new String[] {"Field"}, 50, new String[] {"Smeargle"}, 0, 0));
		pokedex.add(new Pokemon("Tyrogue", "Fighting", null, 35, 35, 35, 35, 35, 35, 21, new String[] {"Human-Like"}, 100, new String[] {"Tyrogue", "Hitmonlee", "Hitmonchan", "Hitmontop"}, 0, 20));
		pokedex.add(new Pokemon("Hitmontop", "Fighting", null, 50, 95, 95, 35, 110, 70, 27, new String[] {"Human-Like"}, 100, new String[] {"Tyrogue", "Hitmontop"}, 1, 0));
		pokedex.add(new Pokemon("Smoochum", "Ice", "Psychic", 45, 30, 10, 85, 65, 65, 27, new String[] {"Human-Like"}, 0, new String[] {"Smoochum", "Jynx"}, 0, 30));
		pokedex.add(new Pokemon("Elekid", "Electric", null, 45, 63, 37, 65, 55, 95, 27, new String[] {"Human-Like"}, 75, new String[] {"Elekid", "Electabuzz", "Electivire"}, 0, 30));
		pokedex.add(new Pokemon("Magby", "Fire", null, 45, 75, 37, 70, 55, 83, 27, new String[] {"Human-Like"}, 75, new String[] {"Magby", "Magmar", "Magmortar"}, 0, 30));
		pokedex.add(new Pokemon("Miltank", "Normal", null, 95, 80, 105, 40, 70, 100, 27, new String[] {"Field"}, 0, new String[] {"Miltank"}, 0, 0));
		pokedex.add(new Pokemon("Blissey", "Normal", null, 255, 10, 10, 75, 135, 55, 29, new String[] {"Fairy"}, 0, new String[] {"Happiny", "Chansey", "Blissey"}, 2, 0));
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
		pokedex.add(new Pokemon("Ralts", "Psychic", "Fairy", 28, 25, 25, 45, 35, 40, 1, new String[] {"Amorphous"}, 50, new String[] {"Ralts", "Kirlia", "Gardevoir", "Gallade"}, 0, 20));
		pokedex.add(new Pokemon("Kirlia", "Psychic", "Fairy", 38, 35, 35, 65, 55, 50, 17, new String[] {"Amorphous"}, 50, new String[] {"Ralts", "Kirlia", "Gardevoir", "Gallade"}, 1, 30));
		pokedex.add(new Pokemon("Gardevoir", "Psychic", "Fairy", 68, 65, 65, 125, 115, 80, 27, new String[] {"Amorphous"}, 50, new String[] {"Ralts", "Kirlia", "Gardevoir"}, 2, 0));
		pokedex.add(new Pokemon("Surskit", "Bug", "Water", 40, 30, 32, 50, 52, 65, 5, new String[] {"Water 1", "Bug"}, 50, new String[] {"Surskit", "Masquerain"}, 0, 22));
		pokedex.add(new Pokemon("Masquerain", "Bug", "Flying", 70, 60, 62, 100, 82, 80, 21, new String[] {"Water 1", "Bug"}, 50, new String[] {"Surskit", "Masquerain"}, 1, 0));
		pokedex.add(new Pokemon("Shroomish", "Grass", null, 60, 40, 60, 40, 60, 35, 0, new String[] {"Fairy", "Grass"}, 50, new String[] {"Shroomish", "Breloom"}, 0, 23));
		pokedex.add(new Pokemon("Breloom", "Grass", "Fighting", 60, 130, 80, 60, 60, 70, 19, new String[] {"Fairy", "Grass"}, 50, new String[] {"Shroomish", "Breloom"}, 1, 0));
		pokedex.add(new Pokemon("Slakoth", "Normal", null, 60, 60, 60, 35, 35, 30, 0, new String[] {"Field"}, 50, new String[] {"Slakoth", "Vigoroth", "Slaking"}, 0, 18));
		pokedex.add(new Pokemon("Vigoroth", "Normal", null, 80, 80, 80, 55, 55, 90, 17, new String[] {"Field"}, 50, new String[] {"Slakoth", "Vigoroth", "Slaking"}, 1, 36));
		pokedex.add(new Pokemon("Slaking", "Normal", null, 150, 160, 100, 95, 65, 100, 27, new String[] {"Field"}, 50, new String[] {"Slakoth", "Vigoroth", "Slaking"}, 2, 0));
		pokedex.add(new Pokemon("Nincada", "Bug", "Ground", 31, 45, 90, 30, 30, 40, 0, new String[] {"Bug"}, 50, new String[] {"Nincada", "Ninjask", "Shedinja"}, 0, 20));
		pokedex.add(new Pokemon("Ninjask", "Bug", "Flying", 61, 90, 45, 50, 50, 160, 17, new String[] {"Bug"}, 50, new String[] {"Nincada", "Ninjask"}, 1, 0));
		pokedex.add(new Pokemon("Shedinja", "Bug", "Ghost", 1, 90, 45, 30, 30, 40, 27, new String[] {"Mineral"}, -1, new String[] {"Nincada", "Shedinja"}, 1, 0));
		pokedex.add(new Pokemon("Whismur", "Normal", null, 64, 51, 23, 51, 23, 28, 6, new String[] {"Monster", "Field"}, 50, new String[] {"Whismur", "Loudred", "Exploud"}, 0, 20));
		pokedex.add(new Pokemon("Loudred", "Normal", null, 84, 71, 43, 71, 43, 48, 17, new String[] {"Monster", "Field"}, 50, new String[] {"Whismur", "Loudred", "Exploud"}, 1, 40));
		pokedex.add(new Pokemon("Exploud", "Normal", null, 104, 91, 63, 91, 73, 68, 27, new String[] {"Monster", "Field"}, 50, new String[] {"Whismur", "Loudred", "Exploud"}, 2, 0));
		pokedex.add(new Pokemon("Makuhita", "Fighting", null, 72, 60, 30, 20, 30, 25, 5, new String[] {"Human-Like"}, 75, new String[] {"Makuhita", "Hariyama"}, 0, 24));
		pokedex.add(new Pokemon("Hariyama", "Fighting", null, 144, 120, 60, 40, 60, 50, 7, new String[] {"Human-Like"}, 75, new String[] {"Makuhita", "Hariyama"}, 1, 0));
		pokedex.add(new Pokemon("Azurill", "Normal", "Fairy", 50, 20, 40, 20, 40, 20, 11, new String[] {"Water 1", "Fairy"}, 25, new String[] {"Azurill", "Marill", "Azumarill"}, 0, -1));
		pokedex.add(new Pokemon("Nosepass", "Rock", null, 30, 45, 135, 45, 90, 30, 0, new String[] {"Mineral"}, 50, new String[] {"Nosepass", "Probopass"}, 0, -1));
		pokedex.add(new Pokemon("Skitty", "Normal", null, 50, 45, 45, 35, 35, 50, 0, new String[] {"Field", "Fairy"}, 25, new String[] {"Skitty", "Delcatty"}, 0, -1));
		pokedex.add(new Pokemon("Delcatty", "Normal", null, 70, 65, 65, 55, 55, 90, 24, new String[] {"Field", "Fairy"}, 25, new String[] {"Skitty", "Delcatty"}, 1, 0));
		pokedex.add(new Pokemon("Sableye", "Dark", "Ghost", 50, 75, 75, 65, 65, 50, 27, new String[] {"Human-Like"}, 50, new String[] {"Sableye"}, 0, 0));
		pokedex.add(new Pokemon("Mawile", "Steel", "Fairy", 50, 85, 85, 55, 55, 50, 27, new String[] {"Field", "Fairy"}, 50, new String[] {"Mawile"}, 0, 0));
		pokedex.add(new Pokemon("Aron", "Steel", "Rock", 50, 70, 100, 40, 40, 30, 7, new String[] {"Monster"}, 50, new String[] {"Aron", "Lairon", "Aggron"}, 0, 32));
		pokedex.add(new Pokemon("Lairon", "Steel", "Rock", 60, 90, 140, 50, 50, 40, 19, new String[] {"Monster"}, 50, new String[] {"Aron", "Lairon", "Aggron"}, 1, 42));
		pokedex.add(new Pokemon("Aggron", "Steel", "Rock", 70, 110, 180, 60, 60, 50, 27, new String[] {"Monster"}, 50, new String[] {"Aron", "Lairon", "Aggron"}, 2, 0));
		pokedex.add(new Pokemon("Meditite", "Fighting", "Psychic", 30, 40, 55, 40, 55, 60, 7, new String[] {"Human-Like"}, 50, new String[] {"Meditite", "Medicham"}, 0, 37));
		pokedex.add(new Pokemon("Medicham", "Fighting", "Psychic", 60, 60, 75, 60, 75, 80, 19, new String[] {"Human-Like"}, 50, new String[] {"Meditite", "Medicham"}, 1, 0));
		pokedex.add(new Pokemon("Electrike", "Electric", null, 40, 45, 40, 65, 40, 65, 17, new String[] {"Field"}, 50, new String[] {"Electrike", "Manectric"}, 0, 26));
		pokedex.add(new Pokemon("Manectric", "Electric", null, 70, 75, 60, 105, 60, 105, 27, new String[] {"Field"}, 50, new String[] {"Electrike", "Manectric"}, 1, 0));
		pokedex.add(new Pokemon("Plusle", "Electric", null, 60, 50, 40, 85, 75, 95, 5, new String[] {"Fairy"}, 50, new String[] {"Plusle"}, 0, 0));
		pokedex.add(new Pokemon("Minun", "Electric", null, 60, 40, 50, 75, 85, 95, 5, new String[] {"Fairy"}, 50, new String[] {"Minun"}, 0, 0));
		pokedex.add(new Pokemon("Volbeat", "Bug", null, 65, 73, 75, 47, 85, 85, 11, new String[] {"Bug", "Human-Like"}, 100, new String[] {"Volbeat"}, 0, 0));
		pokedex.add(new Pokemon("Illumise", "Bug", null, 65, 47, 75, 73, 85, 85, 11, new String[] {"Bug", "Human-Like"}, 0, new String[] {"Illumise"}, 0, 0));
		pokedex.add(new Pokemon("Roselia", "Grass", "Poison", 50, 60, 45, 100, 80, 65, 11, new String[] {"Fairy", "Grass"}, 50, new String[] {"Budew", "Roselia", "Roserade"}, 1, -1));
		pokedex.add(new Pokemon("Gulpin", "Poison", null, 70, 43, 53, 43, 53, 40, 2, new String[] {"Amorphous"}, 50, new String[] {"Gulpin", "Swalot"}, 0, 26));
		pokedex.add(new Pokemon("Swalot", "Poison", null, 100, 73, 83, 73, 83, 55, 21, new String[] {"Amorphous"}, 50, new String[] {"Gulpin", "Swalot"}, 1, 0));
		pokedex.add(new Pokemon("Carvanha", "Water", "Dark", 45, 90, 20, 65, 20, 65, 2, new String[] {"Water 2"}, 50, new String[] {"Carvanha", "Sharpedo"}, 0, 30));
		pokedex.add(new Pokemon("Sharpedo", "Water", "Dark", 70, 120, 40, 95, 40, 95, 24, new String[] {"Water 2"}, 50, new String[] {"Carvanha", "Sharpedo"}, 1, 0));
		pokedex.add(new Pokemon("Wailmer", "Water", null, 130, 70, 35, 70, 35, 60, 16, new String[] {"Field", "Water 2"}, 50, new String[] {"Wailmer", "Wailord"}, 0, 40));
		pokedex.add(new Pokemon("Wailord", "Water", null, 170, 90, 45, 90, 45, 60, 24, new String[] {"Field", "Water 2"}, 50, new String[] {"Wailmer", "Wailord"}, 1, 0));
		pokedex.add(new Pokemon("Numel", "Fire", "Ground", 60, 60, 40, 65, 45, 35, 0, new String[] {"Field"}, 50, new String[] {"Numel", "Camerupt"}, 0, 33));
		pokedex.add(new Pokemon("Camerupt", "Fire", "Ground", 70, 100, 70, 105, 75, 40, 11, new String[] {"Field"}, 50, new String[] {"Numel", "Camerupt"}, 1, 0));
		pokedex.add(new Pokemon("Torkoal", "Fire", null, 70, 85, 140, 85, 70, 20, 19, new String[] {"Field"}, 50, new String[] {"Torkoal"}, 0, 0));
		pokedex.add(new Pokemon("Spoink", "Psychic", null, 60, 25, 35, 70, 80, 60, 0, new String[] {"Field"}, 50, new String[] {"Spoink", "Grumpig"}, 0, 32));
		pokedex.add(new Pokemon("Grumpig", "Psychic", null, 80, 45, 65, 90, 110, 80, 24, new String[] {"Field"}, 50, new String[] {"Spoink", "Grumpig"}, 1, 0));
		pokedex.add(new Pokemon("Spinda", "Normal", null, 60, 60, 60, 60, 60, 60, 0, new String[] {"Field", "Human-Like"}, 50, new String[] {"Spinda"}, 0, 0));
		pokedex.add(new Pokemon("Trapinch", "Ground", null, 45, 100, 45, 45, 45, 10, 0, new String[] {"Bug"}, 50, new String[] {"Trapinch", "Vibrava", "Flygon"}, 0, 35));
		pokedex.add(new Pokemon("Vibrava", "Ground", "Dragon", 50, 70, 50, 50, 50, 70, 17, new String[] {"Bug"}, 50, new String[] {"Trapinch", "Vibrava", "Flygon"}, 1, 45));
		pokedex.add(new Pokemon("Flygon", "Ground", "Dragon", 80, 100, 80, 80, 80, 100, 27, new String[] {"Bug"}, 50, new String[] {"Trapinch", "Vibrava", "Flygon"}, 2, 0));
		pokedex.add(new Pokemon("Cacnea", "Grass", null, 50, 85, 40, 85, 40, 35, 6, new String[] {"Grass", "Human-Like"}, 50, new String[] {"Cacnea", "Cacturne"}, 0, 32));
		pokedex.add(new Pokemon("Cacturne", "Grass", "Dark", 70, 115, 60, 115, 60, 55, 24, new String[] {"Grass", "Human-Like"}, 50, new String[] {"Cacnea", "Cacturne"}, 1, 0));
		pokedex.add(new Pokemon("Swablu", "Normal", "Flying", 45, 40, 60, 40, 75, 50, 0, new String[] {"Flying", "Dragon"}, 50, new String[] {"Swablu", "Altaria"}, 0, 35));
		pokedex.add(new Pokemon("Altaria", "Dragon", "Flying", 75, 70, 90, 70, 105, 80, 27, new String[] {"Flying", "Dragon"}, 50, new String[] {"Swablu", "Altaria"}, 1, 0));
		pokedex.add(new Pokemon("Zangoose", "Normal", null, 73, 115, 60, 60, 60, 90, 19, new String[] {"Field"}, 50, new String[] {"Zangoose"}, 0, 0));
		pokedex.add(new Pokemon("Seviper", "Poison", null, 73, 100, 60, 100, 60, 65, 19, new String[] {"Field", "Dragon"}, 50, new String[] {"Seviper"}, 0, 0));
		pokedex.add(new Pokemon("Lunatone", "Rock", "Psychic", 90, 55, 65, 95, 85, 70, 27, new String[] {"Mineral"}, -1, new String[] {"Lunatone"}, 0, 0));
		pokedex.add(new Pokemon("Solrock", "Rock", "Psychic", 90, 95, 85, 55, 65, 70, 27, new String[] {"Mineral"}, -1, new String[] {"Solrock"}, 0, 0));
		pokedex.add(new Pokemon("Barboach", "Water", "Ground", 50, 48, 43, 46, 41, 60, 6, new String[] {"Water 2"}, 50, new String[] {"Barboach", "Whiscash"}, 0, 30));
		pokedex.add(new Pokemon("Whiscash", "Water", "Ground", 110, 78, 73, 76, 71, 60, 21, new String[] {"Water 2"}, 50, new String[] {"Barboach", "Whiscash"}, 1, 0));
		pokedex.add(new Pokemon("Corphish", "Water", null, 43, 80, 65, 50, 35, 35, 4, new String[] {"Water 1", "Water 3"}, 50, new String[] {"Corphish", "Crawdaunt"}, 0, 30));
		pokedex.add(new Pokemon("Crawdaunt", "Water", "Dark", 63, 120, 85, 90, 55, 55, 10, new String[] {"Water 1", "Water 3"}, 50, new String[] {"Corphish", "Crawdaunt"}, 1, 0));
		pokedex.add(new Pokemon("Baltoy", "Ground", "Psychic", 40, 40, 55, 40, 70, 55, 0, new String[] {"Mineral"}, -1, new String[] {"Baltoy", "Claydol"}, 0, 36));
		pokedex.add(new Pokemon("Claydol", "Ground", "Psychic", 60, 70, 105, 70, 120, 75, 19, new String[] {"Mineral"}, -1, new String[] {"Baltoy", "Claydol"}, 1, 0));
		pokedex.add(new Pokemon("Lileep", "Rock", "Grass", 66, 41, 77, 61, 87, 23, 27, new String[] {"Water 3"}, 87.5, new String[] {"Lileep", "Cradily"}, 0, 40));
		pokedex.add(new Pokemon("Cradily", "Rock", "Grass", 86, 81, 97, 81, 107, 43, 27, new String[] {"Water 3"}, 87.5, new String[] {"Lileep", "Cradily"}, 1, 0));
		pokedex.add(new Pokemon("Anorith", "Rock", "Bug", 45, 95, 50, 40, 50, 75, 27, new String[] {"Water 3"}, 87.5, new String[] {"Anorith", "Armaldo"}, 0, 40));
		pokedex.add(new Pokemon("Armaldo", "Rock", "Bug", 75, 125, 100, 70, 80, 45, 27, new String[] {"Water 3"}, 87.5, new String[] {"Anorith", "Armaldo"}, 1, 0));
		pokedex.add(new Pokemon("Feebas", "Water", null, 20, 15, 20, 10, 55, 80, 0, new String[] {"Water 1", "Dragon"}, 50, new String[] {"Feebas", "Milotic"}, 0, -1));
		pokedex.add(new Pokemon("Milotic", "Water", null, 95, 60, 79, 100, 125, 81, 24, new String[] {"Water 1", "Dragon"}, 50, new String[] {"Feebas", "Milotic"}, 1, 0));
		pokedex.add(new Pokemon("Castform", "Normal", null, 70, 70, 70, 70, 70, 70, 27, new String[] {"Fairy", "Amorphous"}, 50, new String[] {"Castform"}, 0, 0));
		pokedex.add(new Pokemon("Kecleon", "Normal", null, 60, 90, 70, 60, 120, 40, 5, new String[] {"Field"}, 50, new String[] {"Kecleon"}, 0, 0));
		pokedex.add(new Pokemon("Shuppet", "Ghost", null, 44, 75, 35, 63, 33, 45, 2, new String[] {"Amorphous"}, 50, new String[] {"Shuppet", "Banette"}, 0, 37));
		pokedex.add(new Pokemon("Banette", "Ghost", null, 64, 115, 65, 83, 63, 65, 27, new String[] {"Amorphous"}, 50, new String[] {"Shuppet", "Banette"}, 1, 0));
		pokedex.add(new Pokemon("Duskull", "Ghost", null, 20, 40, 90, 30, 90, 25, 6, new String[] {"Amorphous"}, 50, new String[] {"Duskull", "Dusclops", "Dusknoir"}, 0, 37));
		pokedex.add(new Pokemon("Dusclops", "Ghost", null, 40, 70, 130, 60, 130, 25, 19, new String[] {"Amorphous"}, 50, new String[] {"Duskull", "Dusclops", "Dusknoir"}, 1, -1));
		pokedex.add(new Pokemon("Tropius", "Grass", "Flying", 99, 68, 83, 72, 87, 51, 5, new String[] {"Monster", "Grass"}, 50, new String[] {"Tropius"}, 0, 0));
		pokedex.add(new Pokemon("Chimecho", "Psychic", null, 65, 50, 70, 95, 80, 65, 27, new String[] {"Amorphous"}, 50, new String[] {"Chingling", "Chimecho"}, 1, 0));
		pokedex.add(new Pokemon("Absol", "Dark", null, 65, 130, 60, 75, 60, 75, 29, new String[] {"Field"}, 50, new String[] {"Absol"}, 0, 0));
		pokedex.add(new Pokemon("Wynaut", "Psychic", null, 95, 23, 48, 23, 48, 23, 16, new String[] {"Amorphous"}, 50, new String[] {"Wynaut", "Wobbuffet"}, 0, 15));
		pokedex.add(new Pokemon("Snorunt", "Ice", null, 50, 50, 50, 50, 50, 50, 6, new String[] {"Fairy", "Mineral"}, 50, new String[] {"Snorunt", "Glalie", "Froslass"}, 0, 42));
		pokedex.add(new Pokemon("Glalie", "Ice", null, 80, 80, 80, 80, 80, 80, 21, new String[] {"Fairy", "Mineral"}, 50, new String[] {"Snorunt", "Glalie"}, 1, 0));
		pokedex.add(new Pokemon("Spheal", "Ice", "Water", 70, 40, 50, 55, 50, 25, 0, new String[] {"Water 1", "Field"}, 50, new String[] {"Spheal", "Sealeo", "Walrein"}, 0, 32));
		pokedex.add(new Pokemon("Sealeo", "Ice", "Water", 90, 60, 70, 75, 70, 45, 17, new String[] {"Water 1", "Field"}, 50, new String[] {"Spheal", "Sealeo", "Walrein"}, 1, 44));
		pokedex.add(new Pokemon("Walrein", "Ice", "Water", 110, 80, 90, 95, 90, 65, 27, new String[] {"Water 1", "Field"}, 50, new String[] {"Spheal", "Sealeo", "Walrein"}, 2, 0));
		pokedex.add(new Pokemon("Clamperl", "Water", null, 35, 64, 85, 74, 55, 32, 0, new String[] {"Water 1"}, 50, new String[] {"Clamperl", "Huntail", "Gorebyss"}, 0, -1));
		pokedex.add(new Pokemon("Huntail", "Water", null, 55, 104, 105, 94, 75, 52, 24, new String[] {"Water 1"}, 50, new String[] {"Clamperl", "Huntail", "Gorebyss"}, 1, 0));
		pokedex.add(new Pokemon("Gorebyss", "Water", null, 55, 84, 105, 114, 75, 52, 24, new String[] {"Water 1"}, 50, new String[] {"Clamperl", "Huntail", "Gorebyss"}, 1, 0));
		pokedex.add(new Pokemon("Relicanth", "Water", "Rock", 100, 90, 130, 45, 65, 55, 30, new String[] {"Water 1", "Water 2"}, 87.5, new String[] {"Relicanth"}, 0, 0));
		pokedex.add(new Pokemon("Luvdisc", "Water", null, 43, 30, 55, 40, 65, 97, 2, new String[] {"Water 2"}, 25, new String[] {"Luvdisc"}, 0, 0));
		pokedex.add(new Pokemon("Bagon", "Dragon", null, 45, 75, 60, 40, 30, 50, 27, new String[] {"Dragon"}, 50, new String[] {"Bagon", "Shelgon", "Salamence"}, 0, 30));
		pokedex.add(new Pokemon("Shelgon", "Dragon", null, 65, 95, 100, 60, 50, 50, 27, new String[] {"Dragon"}, 50, new String[] {"Bagon", "Shelgon", "Salamence"}, 1, 50));
		pokedex.add(new Pokemon("Salamence", "Dragon", "Flying", 95, 135, 80, 110, 80, 100, 27, new String[] {"Dragon"}, 50, new String[] {"Bagon", "Shelgon", "Salamence"}, 2, 0));
		pokedex.add(new Pokemon("Beldum", "Steel", "Psychic", 40, 55, 80, 35, 60, 30, 32, new String[] {"Mineral"}, -1, new String[] {"Beldum", "Metang", "Metagross"}, 0, 20));
		pokedex.add(new Pokemon("Metang", "Steel", "Psychic", 60, 75, 100, 55, 80, 50, 32, new String[] {"Mineral"}, -1, new String[] {"Beldum", "Metang", "Metagross"}, 1, 45));
		pokedex.add(new Pokemon("Metagross", "Steel", "Psychic", 80, 135, 130, 95, 90, 70, 32, new String[] {"Mineral"}, -1, new String[] {"Beldum", "Metang", "Metagross"}, 2, 0));
		pokedex.add(new Pokemon("Regirock", "Rock", null, 80, 100, 200, 50, 100, 50, 32, new String[] {"Undiscovered"}, -1, new String[] {"Regirock"}, 0, 0));
		pokedex.add(new Pokemon("Regice", "Ice", null, 80, 50, 100, 100, 200, 50, 32, new String[] {"Undiscovered"}, -1, new String[] {"Regice"}, 0, 0));
		pokedex.add(new Pokemon("Registeel", "Steel", null, 80, 75, 150, 75, 150, 50, 32, new String[] {"Undiscovered"}, -1, new String[] {"Registeel"}, 0, 0));
		pokedex.add(new Pokemon("Latias", "Dragon", "Psychic", 80, 80, 90, 110, 130, 110, 32, new String[] {"Undiscovered"}, 0, new String[] {"Latias"}, 0, 0));
		pokedex.add(new Pokemon("Latios", "Dragon", "Psychic", 80, 90, 80, 130, 110, 110, 32, new String[] {"Undiscovered"}, 100, new String[] {"Latios"}, 0, 0));
		pokedex.add(new Pokemon("Kyogre", "Water", null, 100, 100, 90, 150, 140, 90, 32, new String[] {"Undiscovered"}, -1, new String[] {"Kyogre"}, 0, 0));
		pokedex.add(new Pokemon("Groudon", "Ground", null, 100, 150, 140, 100, 90, 90, 32, new String[] {"Undiscovered"}, -1, new String[] {"Groudon"}, 0, 0));
		pokedex.add(new Pokemon("Rayquaza", "Dragon", "Flying", 105, 150, 90, 150, 90, 95, 27, new String[] {"Undiscovered"}, -1, new String[] {"Rayquaza"}, 0, 0));
		pokedex.add(new Pokemon("Jirachi", "Steel", "Psychic", 100, 100, 100, 100, 100, 100, 32, new String[] {"Undiscovered"}, -1, new String[] {"Jirachi"}, 0, 0));
		pokedex.add(new Pokemon("DeoxysN", "Psychic", null, 50, 150, 50, 150, 50, 150, 32, new String[] {"Undiscovered"}, -1, new String[] {"DeoxysN"}, 0, 0)); // 385:385
		pokedex.add(new Pokemon("DeoxysA", "Psychic", null, 50, 180, 20, 180, 20, 150, 32, new String[] {"Undiscovered"}, -1, new String[] {"DeoxysA"}, 0, 0)); // 386:385
		pokedex.add(new Pokemon("DeoxysD", "Psychic", null, 50, 70, 160, 70, 160, 90, 32, new String[] {"Undiscovered"}, -1, new String[] {"DeoxysD"}, 0, 0)); // 387:385
		pokedex.add(new Pokemon("DeoxysS", "Psychic", null, 50, 95, 90, 95, 90, 180, 32, new String[] {"Undiscovered"}, -1, new String[] {"DeoxysS"}, 0, 0)); // 388:385
		pokedex.add(new Pokemon("Turtwig", "Grass", null, 55, 68, 64, 45, 55, 31, 27, new String[] {"Monster", "Grass"}, 87.5, new String[] {"Turtwig", "Grotle", "Torterra"}, 0, 18));
		pokedex.add(new Pokemon("Grotle", "Grass", null, 75, 89, 85, 55, 65, 36, 27, new String[] {"Monster", "Grass"}, 87.5, new String[] {"Turtwig", "Grotle", "Torterra"}, 1, 32));
		pokedex.add(new Pokemon("Torterra", "Grass", "Ground", 95, 109, 105, 75, 85, 56, 27, new String[] {"Monster", "Grass"}, 87.5, new String[] {"Turtwig", "Grotle", "Torterra"}, 2, 0));
		pokedex.add(new Pokemon("Chimchar", "Fire", null, 44, 58, 44, 58, 44, 61, 27, new String[] {"Field", "Human-Like"}, 87.5, new String[] {"Chimchar", "Monferno", "Infernape"}, 0, 14));
		pokedex.add(new Pokemon("Monferno", "Fire", "Fighting", 64, 78, 52, 78, 52, 81, 27, new String[] {"Field", "Human-Like"}, 87.5, new String[] {"Chimchar", "Monferno", "Infernape"}, 1, 36));
		pokedex.add(new Pokemon("Infernape", "Fire", "Fighting", 76, 104, 71, 104, 71, 108, 27, new String[] {"Field", "Human-Like"}, 87.5, new String[] {"Chimchar", "Monferno", "Infernape"}, 2, 0));
		pokedex.add(new Pokemon("Piplup", "Water", null, 53, 51, 53, 61, 56, 40, 27, new String[] {"Water 1", "Field"}, 87.5, new String[] {"Piplup", "Prinplup", "Empoleon"}, 0, 16));
		pokedex.add(new Pokemon("Prinplup", "Water", null, 64, 66, 68, 81, 76, 50, 27, new String[] {"Water 1", "Field"}, 87.5, new String[] {"Piplup", "Prinplup", "Empoleon"}, 1, 36));
		pokedex.add(new Pokemon("Empoleon", "Water", "Steel", 84, 86, 88, 111, 101, 60, 27, new String[] {"Water 1", "Field"}, 87.5, new String[] {"Piplup", "Prinplup", "Empoleon"}, 2, 0));
		pokedex.add(new Pokemon("Starly", "Normal", "Flying", 40, 55, 30, 30, 30, 60, 0, new String[] {"Flying"}, 50, new String[] {"Starly", "Staravia", "Staraptor"}, 0, 14));
		pokedex.add(new Pokemon("Staravia", "Normal", "Flying", 55, 75, 50, 40, 40, 80, 17, new String[] {"Flying"}, 50, new String[] {"Starly", "Staravia", "Staraptor"}, 1, 34));
		pokedex.add(new Pokemon("Staraptor", "Normal" ,"Flying", 85, 120, 70, 50, 60, 100, 27, new String[] {"Flying"}, 50, new String[] {"Starly", "Staravia", "Staraptor"}, 2, 0));
		pokedex.add(new Pokemon("Bidoof", "Normal", null, 59, 45, 40, 35, 40, 31, 0, new String[] {"Water 1", "Field"}, 50, new String[] {"Bidoof", "Bibarel"}, 0, 15));
		pokedex.add(new Pokemon("Bibarel", "Normal", "Water", 79, 85, 60, 55, 60, 71, 15, new String[] {"Water 1", "Field"}, 50, new String[] {"Bidoof", "Bibarel"}, 1, 0));
		pokedex.add(new Pokemon("Kricketot", "Bug", null, 37, 25, 41, 25, 41, 25, 0, new String[] {"Bug"}, 50, new String[] {"Kricketot", "Kricketune"}, 0, 10));
		pokedex.add(new Pokemon("Kricketune", "Bug", null, 77, 85, 51, 55, 51, 65, 27, new String[] {"Bug"}, 50, new String[] {"Kricketot", "Kricketune"}, 1, 0));
		pokedex.add(new Pokemon("Shinx", "Electric", null, 45, 65, 34, 40, 34, 45, 1, new String[] {"Field"}, 50, new String[] {"Shinx", "Luxio", "Luxray"}, 0, 15));
		pokedex.add(new Pokemon("Luxio", "Electric", null, 60, 85, 49, 60, 49, 60, 17, new String[] {"Field"}, 50, new String[] {"Shinx", "Luxio", "Luxray"}, 1, 30));
		pokedex.add(new Pokemon("Luxray", "Electric", null, 80, 120, 79, 95, 79, 70, 27, new String[] {"Field"}, 50, new String[] {"Shinx", "Luxio", "Luxray"}, 2, 0));
		pokedex.add(new Pokemon("Budew", "Grass", "Poison", 40, 30, 35, 50, 70, 55, 0, new String[] {"Fairy", "Grass"}, 50, new String[] {"Budew", "Roselia", "Roserade"}, 0, -1));
		pokedex.add(new Pokemon("Roserade", "Grass", "Poison", 60, 70, 65, 125, 105, 90, 21, new String[] {"Fairy", "Grass"}, 50, new String[] {"Budew", "Roselia", "Roserade"}, 2, 0));
		pokedex.add(new Pokemon("Cranidos", "Rock", null, 67, 125, 40, 30, 30, 58, 27, new String[] {"Monster"}, 87.5, new String[] {"Cranidos", "Rampardos"}, 0, 30));
		pokedex.add(new Pokemon("Rampardos", "Rock", null, 97, 165, 60, 65, 50, 58, 27, new String[] {"Monster"}, 87.5, new String[] {"Cranidos", "Rampardos"}, 1, 0));
		pokedex.add(new Pokemon("Shieldon", "Rock", "Steel", 30, 42, 118, 42, 88, 30, 27, new String[] {"Monster"}, 87.5, new String[] {"Shieldon", "Bastiodon"}, 0, 30));
		pokedex.add(new Pokemon("Bastiodon", "Rock", "Steel", 60, 52, 168, 47, 138, 30, 27, new String[] {"Monster"}, 87.5, new String[] {"Shieldon", "Bastiodon"}, 1, 0));
		pokedex.add(new Pokemon("Burmy", "Bug", null, 40, 29, 45, 29, 45, 36, 17, new String[] {"Bug"}, 50, new String[] {"Burmy", "WormadamP", "WormadamS", "WormadamT", "Mothim"}, 0, 20));
		pokedex.add(new Pokemon("WormadamP", "Bug", "Grass", 60, 59, 85, 79, 105, 36, 27, new String[] {"Bug"}, 0, new String[] {"Burmy", "WormadamP"}, 1, 0)); // 415:412
		pokedex.add(new Pokemon("WormadamS", "Bug", "Ground", 60, 79, 105, 59, 85, 36, 27, new String[] {"Bug"}, 0, new String[] {"Burmy", "WormadamS"}, 1, 0)); // 416:412
		pokedex.add(new Pokemon("WormadamT", "Bug", "Steel", 60, 69, 95, 69, 95, 36, 27, new String[] {"Bug"}, 0, new String[] {"Burmy", "WormadamT"}, 1, 0)); // 417:412
		pokedex.add(new Pokemon("Mothim", "Bug", "Flying", 70, 94, 50, 94, 50, 66, 27, new String[] {"Bug"}, 100, new String[] {"Burmy", "Mothim"}, 1, 0)); // 418:413
		pokedex.add(new Pokemon("Combee", "Bug", "Flying", 30, 30, 42, 30, 42, 70, 17, new String[] {"Bug"}, 87.5, new String[] {"Combee", "Vespiquen"}, 0, 21));
		pokedex.add(new Pokemon("Vespiquen", "Bug", "Flying", 70, 80, 102, 80, 102, 40, 27, new String[] {"Bug"}, 0, new String[] {"Combee", "Vespiquen"}, 1, 0));
		pokedex.add(new Pokemon("Pachirisu", "Electric", null, 60, 45, 70, 45, 90, 95, 5, new String[] {"Field", "Fairy"}, 50, new String[] {"Pachirisu"}, 0, 0));
		pokedex.add(new Pokemon("Buizel", "Water", null, 55, 65, 35, 60, 30, 85, 6, new String[] {"Water 1", "Field"}, 50, new String[] {"Buizel", "Floatzel"}, 0, 26));
		pokedex.add(new Pokemon("Floatzel", "Water", null, 85, 105, 55, 85, 50, 115, 21, new String[] {"Water 1", "Field"}, 50, new String[] {"Buizel", "Floatzel"}, 1, 0));
		pokedex.add(new Pokemon("Cherubi", "Grass", null, 45, 35, 45, 62, 53, 35, 6, new String[] {"Fairy", "Grass"}, 50, new String[] {"Cherubi", "Cherrim"}, 0, 25));
		pokedex.add(new Pokemon("Cherrim", "Grass", null, 70, 60, 70, 87, 78, 85, 21, new String[] {"Fairy", "Grass"}, 50, new String[] {"Cherubi", "Cherrim"}, 1, 0));
		pokedex.add(new Pokemon("Shellos", "Water", null, 76, 48, 48, 57, 62, 34, 6, new String[] {"Water 1", "Amorphous"}, 50, new String[] {"Shellos", "Gastrodon"}, 0, 30));
		pokedex.add(new Pokemon("Gastrodon", "Water", "Ground", 111, 83, 68, 92, 82, 39, 21, new String[] {"Water 1", "Amorphous"}, 50, new String[] {"Shellos", "Gastrodon"}, 1, 0));
		pokedex.add(new Pokemon("Ambipom", "Normal", null, 75, 100, 66, 60, 66, 115, 27, new String[] {"Field"}, 50, new String[] {"Aipom", "Ambipom"}, 1, 0));
		pokedex.add(new Pokemon("Drifloon", "Ghost", "Flying", 90, 50, 34, 60, 44, 70, 16, new String[] {"Amorphous"}, 50, new String[] {"Drifloon", "Drifblim"}, 0, 28));
		pokedex.add(new Pokemon("Drifblim", "Ghost", "Flying", 150, 80, 44, 90, 54, 80, 24, new String[] {"Amorphous"}, 50, new String[] {"Drifloon", "Drifblim"}, 1, 0));
		pokedex.add(new Pokemon("Buneary", "Normal", null, 55, 66, 44, 44, 56, 85, 6, new String[] {"Field", "Human-Like"}, 50, new String[] {"Buneary", "Lopunny"}, 0, -1));
		pokedex.add(new Pokemon("Lopunny", "Normal", null, 65, 76, 84, 54, 96, 105, 24, new String[] {"Field", "Human-Like"}, 50, new String[] {"Buneary", "Lopunny"}, 1, 0));
		pokedex.add(new Pokemon("Mismagius", "Ghost", null, 60, 60, 60, 105, 105, 105, 27, new String[] {"Amorphous"}, 50, new String[] {"Misdreavus", "Mismagius"}, 1, 0));
		pokedex.add(new Pokemon("Honchkrow", "Dark", "Flying", 100, 125, 52, 105, 52, 71, 29, new String[] {"Flying"}, 50, new String[] {"Murkrow", "Honchkrow"}, 1, 0));
		pokedex.add(new Pokemon("Glameow", "Normal", null, 49, 55, 42, 42, 37, 85, 6, new String[] {"Field"}, 25, new String[] {"Glameow", "Purugly"}, 0, 38));
		pokedex.add(new Pokemon("Purugly", "Normal", null, 71, 82, 64, 64, 59, 112, 21, new String[] {"Field"}, 25, new String[] {"Glameow", "Purugly"}, 1, 0));
		pokedex.add(new Pokemon("Chingling", "Psychic", null, 45, 30, 50, 65, 50, 45, 17, new String[] {"Amorphous"}, 50, new String[] {"Chingling", "Chimecho"}, 0, -1));
		pokedex.add(new Pokemon("Stunky", "Poison", "Dark", 63, 63, 47, 41, 41, 74, 2, new String[] {"Field"}, 50, new String[] {"Stunky", "Skuntank"}, 0, 34));
		pokedex.add(new Pokemon("Skuntank", "Poison", "Dark", 103, 93, 67, 71, 61, 84, 24, new String[] {"Field"}, 50, new String[] {"Stunky", "Skuntank"}, 1, 0));
		pokedex.add(new Pokemon("Bronzor", "Steel", "Psychic", 57, 24, 86, 24, 86, 23, 0, new String[] {"Mineral"}, -1, new String[] {"Bronzor", "Bronzong"}, 0, 33));
		pokedex.add(new Pokemon("Bronzong", "Steel", "Psychic", 67, 89, 116, 79, 116, 33, 19, new String[] {"Mineral"}, -1, new String[] {"Bronzor", "Bronzong"}, 1, 0));
		pokedex.add(new Pokemon("Bonsly", "Rock", null, 50, 80, 95, 10, 45, 10, 0, new String[] {"Mineral"}, 50, new String[] {"Bonsly", "Sudowoodo"}, 0, -1));
		pokedex.add(new Pokemon("Mime Jr.", "Psychic", "Fairy", 20, 25, 45, 70, 90, 60, 12, new String[] {"Human-Like"}, 50, new String[] {"Mime Jr.", "Mr. Mime"}, 0, -1));
		pokedex.add(new Pokemon("Happiny", "Normal", null, 100, 5, 5, 15, 65, 30, 14, new String[] {"Fairy"}, 0, new String[] {"Happiny", "Chansey", "Blissey"}, 0, -1));
		pokedex.add(new Pokemon("Chatot", "Normal", "Flying", 76, 65, 45, 92, 42, 91, 29, new String[] {"Flying"}, 50, new String[] {"Chatot"}, 0, 0));
		pokedex.add(new Pokemon("Spiritomb", "Ghost", "Dark", 50, 92, 108, 92, 108, 35, 18, new String[] {"Amorphous"}, 50, new String[] {"Spiritomb"}, 0, 0));
		pokedex.add(new Pokemon("Gible", "Dragon", "Ground", 58, 70, 45, 40, 45, 42, 27, new String[] {"Monster", "Dragon"}, 50, new String[] {"Gible", "Gabite", "Garchomp"}, 0, 24));
		pokedex.add(new Pokemon("Gabite", "Dragon", "Ground", 68, 90, 65, 50, 55, 82, 27, new String[] {"Monster", "Dragon"}, 50, new String[] {"Gible", "Gabite", "Garchomp"}, 1, 48));
		pokedex.add(new Pokemon("Garchomp", "Dragon", "Ground", 108, 130, 95, 80, 85, 102, 27, new String[] {"Monster", "Dragon"}, 50, new String[] {"Gible", "Gabite", "Garchomp"}, 2, 0));
		pokedex.add(new Pokemon("Munchlax", "Normal", null, 135, 85, 40, 40, 85, 5, 26, new String[] {"Monster"}, 87.5, new String[] {"Munchlax", "Snorlax"}, 0, -1));
		pokedex.add(new Pokemon("Riolu", "Fighting", null, 40, 70, 40, 35, 40, 60, 21, new String[] {"Field", "Human-Like"}, 87.5, new String[] {"Riolu", "Lucario"}, 0, -1));
		pokedex.add(new Pokemon("Lucario", "Fighting", "Steel", 70, 110, 70, 115, 70, 90, 27, new String[] {"Field", "Human-Like"}, 87.5, new String[] {"Riolu", "Lucario"}, 1, 0));
		pokedex.add(new Pokemon("Hippopotas", "Ground", null, 68, 72, 78, 38, 42, 32, 13, new String[] {"Field"}, 50, new String[] {"Hippopotas", "Hippowdon"}, 0, 34));
		pokedex.add(new Pokemon("Hippowdon", "Ground", null, 108, 112, 118, 68, 72, 47, 24, new String[] {"Field"}, 50, new String[] {"Hippopotas", "Hippowdon"}, 1, 0));
		pokedex.add(new Pokemon("Skorupi", "Poison", "Bug", 40, 50, 90, 30, 55, 65, 17, new String[] {"Bug", "Water 3"}, 50, new String[] {"Skorupi", "Drapion"}, 0, 40));
		pokedex.add(new Pokemon("Drapion", "Poison", "Dark", 70, 90, 110, 60, 75, 95, 27, new String[] {"Bug", "Water 3"}, 50, new String[] {"Skorupi", "Drapion"}, 1, 0));
		pokedex.add(new Pokemon("Croagunk", "Poison", "Fighting", 48, 61, 40, 61, 40 ,50, 13, new String[] {"Human-Like"}, 50, new String[] {"Croagunk", "Toxicroak"}, 0, 37));
		pokedex.add(new Pokemon("Toxicroak", "Poison", "Fighting", 83, 106, 65, 86, 65, 85, 21, new String[] {"Human-Like"}, 50, new String[] {"Croagunk", "Toxicroak"}, 1, 0));
		pokedex.add(new Pokemon("Carnivine", "Grass", null, 74, 100, 72, 90, 72, 46, 5, new String[] {"Grass"}, 50, new String[] {"Carnivine"}, 0, 0));
		pokedex.add(new Pokemon("Finneon", "Water", null, 49, 49, 56, 49, 61, 66, 6, new String[] {"Water 2"}, 50, new String[] {"Finneon", "Lumineon"}, 0, 31));
		pokedex.add(new Pokemon("Lumineon", "Water", null, 69, 69, 76, 69, 86, 91, 21, new String[] {"Water 2"}, 50, new String[] {"Finneon", "Lumineon"}, 1, 0));
		pokedex.add(new Pokemon("Mantyke", "Water", "Flying", 45, 20, 50, 60, 120, 50, 30, new String[] {"Water 1"}, 50, new String[] {"Mantyke", "Mantine"}, 0, -1));
		pokedex.add(new Pokemon("Snover", "Grass", "Ice", 60, 62, 50, 62, 60, 40, 17, new String[] {"Monster", "Grass"}, 50, new String[] {"Snover", "Abomasnow"}, 0, 40));
		pokedex.add(new Pokemon("Abomasnow", "Grass", "Ice", 90, 92, 75, 92, 85, 60, 24, new String[] {"Monster", "Grass"}, 50, new String[] {"Snover", "Abomasnow"}, 1, 0));
		pokedex.add(new Pokemon("Weavile", "Dark", "Ice", 70, 120, 65, 45, 85, 125, 27, new String[] {"Field"}, 50, new String[] {"Sneasel", "Weavile"}, 1, 0));
		pokedex.add(new Pokemon("Magnezone", "Electric", "Steel", 70, 70, 115, 130, 90, 60, 29, new String[] {"Mineral"}, -1, new String[] {"Magnemite", "Magneton", "Magnezone"}, 2, 0));
		pokedex.add(new Pokemon("Lickilicky", "Normal", null, 110, 85, 95, 80, 95, 50, 29, new String[] {"Monster"}, 50, new String[] {"Lickitung", "Lickilicky"}, 1, 0));
		pokedex.add(new Pokemon("Rhyperior", "Ground", "Rock", 115, 140, 130, 55, 55, 40, 29, new String[] {"Monster", "Field"}, 50, new String[] {"Rhyhorn", "Rhydon", "Rhyperior"}, 2, 0));
		pokedex.add(new Pokemon("Tangrowth", "Grass", null, 100, 100, 125, 110, 50, 50, 29, new String[] {"Grass"}, 50, new String[] {"Tangela", "Tangrowth"}, 1, 0));
		pokedex.add(new Pokemon("Electivire", "Electric", null, 75, 123, 67, 95, 85, 95, 29, new String[] {"Human-Like"}, 75, new String[] {"Elekid", "Electabuzz", "Electivire"}, 2, 0));
		pokedex.add(new Pokemon("Magmortar", "Fire", null, 75, 95, 67, 125, 95, 83, 29, new String[] {"Human-Like"}, 75, new String[] {"Magby", "Magmar", "Magmortar"}, 2, 0));
		pokedex.add(new Pokemon("Togekiss", "Fairy", "Flying", 85, 50, 95, 120, 115, 80, 29, new String[] {"Flying", "Fairy"}, 87.5, new String[] {"Togepi", "Togetic", "Togekiss"}, 2, 0));
		pokedex.add(new Pokemon("Yanmega", "Bug", "Flying", 86, 76, 86, 116, 56, 95, 29, new String[] {"Bug"}, 50, new String[] {"Yanma", "Yanmega"}, 1, 0));
		pokedex.add(new Pokemon("Leafeon", "Grass", null, 65, 110, 130, 60, 65, 95, 27, new String[] {"Field"}, 87.5, new String[] {"Eevee", "Leafeon"}, 1, 0));
		pokedex.add(new Pokemon("Glaceon", "Ice", null, 65, 60, 110, 130, 95, 65, 27, new String[] {"Field"}, 87.5, new String[] {"Eevee", "Glaceon"}, 1, 0));
		pokedex.add(new Pokemon("Gliscor", "Ground", "Flying", 75, 97, 125, 45, 75, 95, 29, new String[] {"Bug"}, 50, new String[] {"Gligar", "Gliscor"}, 1, 0));
		pokedex.add(new Pokemon("Mamoswine", "Ice", "Ground", 110, 130, 80, 70, 60, 80, 26, new String[] {"Field"}, 50, new String[] {"Swinub", "Piloswine", "Mamoswine"}, 2, 0));
		pokedex.add(new Pokemon("Porygon-Z", "Normal", null, 85, 80, 70, 135, 75, 90, 29, new String[] {"Mineral"}, -1, new String[] {"Porygon", "Porygon2", "Porygon-Z"}, 2, 0));
		pokedex.add(new Pokemon("Gallade", "Psychic", "Fighting", 68, 125, 65, 65, 115, 80, 27, new String[] {"Amorphous"}, 100, new String[] {"Ralts", "Kirlia", "Gallade"}, 2, 0));
		pokedex.add(new Pokemon("Probopass", "Rock", "Steel", 60, 55, 145, 75, 150, 40, 24, new String[] {"Mineral"}, -1, new String[] {"Nosepass", "Probopass"}, 1, 0));
		pokedex.add(new Pokemon("Dusknoir", "Ghost", null, 45, 100, 135, 65, 135, 45, 27, new String[] {"Amorphous"}, 50, new String[] {"Duskull", "Dusclops", "Dusknoir"}, 2, 0));
		pokedex.add(new Pokemon("Froslass", "Ice", "Ghost", 70, 80, 70, 80, 70, 110, 21, new String[] {"Fairy", "Mineral"}, 0, new String[] {"Snorunt", "Froslass"}, 1, 0));
		pokedex.add(new Pokemon("Rotom", "Electric", "Ghost", 50, 50, 77, 95, 77, 91, 27, new String[] {"Amorphous"}, -1, new String[] {"Rotom"}, 0, 0)); // 483:479
		pokedex.add(new Pokemon("RotomH", "Electric", "Fire", 50, 65, 107, 105, 107, 86, 27, new String[] {"Amorphous"}, -1, new String[] {"RotomH"}, 0, 0)); // 484:479
		pokedex.add(new Pokemon("RotomW", "Electric", "Water", 50, 65, 107, 105, 107, 86, 27, new String[] {"Amorphous"}, -1, new String[] {"RotomW"}, 0, 0)); // 485:479
		pokedex.add(new Pokemon("RotomFr", "Electric", "Ice", 50, 65, 107, 105, 107, 86, 27, new String[] {"Amorphous"}, -1, new String[] {"RotomFr"}, 0, 0)); // 486:479
		pokedex.add(new Pokemon("RotomFa", "Electric", "Flying", 50, 65, 107, 105, 107, 86, 27, new String[] {"Amorphous"}, -1, new String[] {"RotomFa"}, 0, 0)); // 487:479
		pokedex.add(new Pokemon("RotomM", "Electric", "Grass", 50, 65, 107, 105, 107, 86, 27, new String[] {"Amorphous"}, -1, new String[] {"RotomM"}, 0, 0)); // 488:479
		pokedex.add(new Pokemon("Uxie", "Psychic", null, 75, 75, 130, 75, 130, 95, 32, new String[] {"Undiscovered"}, -1, new String[] {"Uxie"}, 0, 0));
		pokedex.add(new Pokemon("Mesprit", "Psychic", null, 80, 105, 105, 105, 105, 80, 32, new String[] {"Undiscovered"}, -1, new String[] {"Mesprit"}, 0, 0));
		pokedex.add(new Pokemon("Azelf", "Psychic", null, 75, 120, 70, 125, 70, 115, 32, new String[] {"Undiscovered"}, -1, new String[] {"Azelf"}, 0, 0));
		pokedex.add(new Pokemon("Dialga", "Steel", "Dragon", 100, 120, 120, 150, 100, 90, 32, new String[] {"Undiscovered"}, -1, new String[] {"Dialga"}, 0, 0));
		pokedex.add(new Pokemon("Palkia", "Water", "Dragon", 90, 120, 100, 150, 120, 100, 32, new String[] {"Undiscovered"}, -1, new String[] {"Palkia"}, 0, 0));
		pokedex.add(new Pokemon("Heatran", "Fire", "Steel", 91, 90, 106, 130, 106, 77, 32, new String[] {"Undiscovered"}, 50, new String[] {"Heatran"}, 0, 0));
		pokedex.add(new Pokemon("Regigigas", "Normal", null, 110, 160, 110, 80, 110, 100, 32, new String[] {"Undiscovered"}, -1, new String[] {"Regigigas"}, 0, 0));
		pokedex.add(new Pokemon("GiratinaA", "Ghost", "Dragon", 150, 100, 120, 100, 120, 90, 32, new String[] {"Undiscovered"}, -1, new String[] {"GiratinaA"}, 0, 0)); // 496:487
		pokedex.add(new Pokemon("GiratinaO", "Ghost", "Dragon", 150, 120, 100, 120, 100, 90, 32, new String[] {"Undiscovered"}, -1, new String[] {"GiratinaO"}, 0, 0)); // 497:487
		pokedex.add(new Pokemon("Cresselia", "Psychic", null, 120, 70, 120, 75, 130, 85, 32, new String[] {"Undiscovered"}, 0, new String[] {"Cresselia"}, 0, 0));
		pokedex.add(new Pokemon("Phione", "Water", null, 80, 80, 80, 80, 80, 80, 29, new String[] {"Water 1", "Fairy"}, -1, new String[] {"Phione"}, 0, 0));
		pokedex.add(new Pokemon("Manaphy", "Water", null, 100, 100, 100, 100, 100, 100, 32, new String[] {"Water 1", "Fairy"}, -1, new String[] {"Manaphy"}, 0, 0));
		pokedex.add(new Pokemon("Darkrai", "Dark", null, 70, 90, 90, 135, 90, 125, 32, new String[] {"Undiscovered"}, -1, new String[] {"Darkrai"}, 0, 0));
		pokedex.add(new Pokemon("ShayminL", "Grass", null, 100, 100, 100, 100, 100, 100, 27, new String[] {"Undiscovered"}, -1, new String[] {"ShayminL"}, 0, 0)); // 502:492
		pokedex.add(new Pokemon("ShayminS", "Grass", "Flying", 100, 103, 75, 120, 75, 127, 27, new String[] {"Undiscovered"}, -1, new String[] {"ShayminS"}, 0, 0)); // 503:492
		pokedex.add(new Pokemon("Arceus", "Normal", null, 120, 120, 120, 120, 120, 120, 32, new String[] {"Undiscovered"}, -1, new String[] {"Arceus"}, 0, 0));
		pokedex.add(new Pokemon("Victini", "Psychic", "Fire", 100, 100, 100, 100, 100, 100, 32, new String[] {"Undiscovered"}, -1, new String[] {"Victini"}, 0, 0));
		pokedex.add(new Pokemon("Snivy", "Grass", null, 45, 45, 55, 45, 55, 63, 27, new String[] {"Field", "Grass"}, 87.5, new String[] {"Snivy", "Servine", "Serperior"}, 0, 17));
		pokedex.add(new Pokemon("Servine", "Grass", null, 60, 60, 75, 60, 75, 83, 27, new String[] {"Field", "Grass"}, 87.5, new String[] {"Snivy", "Servine", "Serperior"}, 1, 36));
		pokedex.add(new Pokemon("Serperior", "Grass", null, 75, 75 ,95, 75, 95, 113, 27, new String[] {"Field", "Grass"}, 87.5, new String[] {"Snivy", "Servine", "Serperior"}, 2, 0));
		pokedex.add(new Pokemon("Tepig", "Fire", null, 65, 63, 45, 45, 45, 45, 27, new String[] {"Field"}, 87.5, new String[] {"Tepig", "Pignite", "Emboar"}, 0, 17));
		pokedex.add(new Pokemon("Pignite", "Fire", "Fighting", 90, 93, 55, 70, 55, 55, 27, new String[] {"Field"}, 87.5, new String[] {"Tepig", "Pignite", "Emboar"}, 1, 36));
		pokedex.add(new Pokemon("Emboar", "Fire", "Fighting", 110, 123, 65, 100, 65, 65, 27, new String[] {"Field"}, 87.5, new String[] {"Tepig", "Pignite", "Emboar"}, 2, 0));
		pokedex.add(new Pokemon("Oshawott", "Water", null, 55, 55, 45, 63, 45, 45, 27, new String[] {"Field"}, 87.5, new String[] {"Oshawott", "Dewott", "Samurott"}, 0, 17));
		pokedex.add(new Pokemon("Dewott", "Water", null, 75, 75, 60, 83, 60, 60, 27, new String[] {"Field"}, 87.5, new String[] {"Oshawott", "Dewott", "Samurott"}, 1, 36));
		pokedex.add(new Pokemon("Samurott", "Water", null, 95, 100, 85, 108, 70, 70, 27, new String[] {"Field"}, 87.5, new String[] {"Oshawott", "Dewott", "Samurott"}, 2, 0));
		pokedex.add(new Pokemon("Patrat", "Normal", null, 45, 55, 39, 35, 39, 42, 0, new String[] {"Field"}, 50, new String[] {"Patrat", "Watchog"}, 0, 20));
		pokedex.add(new Pokemon("Watchog", "Normal", null, 60, 85, 69, 60, 69, 77, 0, new String[] {"Field"}, 50, new String[] {"Patrat", "Watchog"}, 1, 0));
		pokedex.add(new Pokemon("Lillipup", "Normal", null, 45, 60, 45, 25, 45, 55, 0, new String[] {"Field"}, 50, new String[] {"Lillipup", "Herdier", "Stoutland"}, 0, 16));
		pokedex.add(new Pokemon("Herdier", "Normal", null, 65, 80, 65, 35, 65, 60, 17, new String[] {"Field"}, 50, new String[] {"Lillipup", "Herdier", "Stoutland"}, 1, 32));
		pokedex.add(new Pokemon("Stoutland", "Normal", null, 85, 110, 90, 45, 90, 80, 27, new String[] {"Field"}, 50, new String[] {"Lillipup", "Herdier", "Stoutland"}, 2, 0));
		pokedex.add(new Pokemon("Purrloin", "Dark", null, 41, 50, 37, 50, 37, 66, 0, new String[] {"Field"}, 50, new String[] {"Purrloin", "Liepard"}, 0, 20));
		pokedex.add(new Pokemon("Liepard", "Dark", null, 64, 88, 50, 88, 50, 106, 19, new String[] {"Field"}, 50, new String[] {"Purrloin", "Liepard"}, 1, 0));
		pokedex.add(new Pokemon("Pansage", "Grass", null, 50, 53, 48, 53, 48, 64, 6, new String[] {"Field"}, 87.5, new String[] {"Pansage", "Simisage"}, 0, -1));
		pokedex.add(new Pokemon("Simisage", "Grass", null, 75, 98, 63, 98, 63, 101, 21, new String[] {"Field"}, 87.5, new String[] {"Pansage", "Simisage"}, 1, 0));
		pokedex.add(new Pokemon("Pansear", "Fire", null, 50, 53, 48, 53, 48, 64, 6, new String[] {"Field"}, 87.5, new String[] {"Pansear", "Simisear"}, 0, -1));
		pokedex.add(new Pokemon("Simisear", "Fire", null, 75, 98, 63, 98, 63, 101, 21, new String[] {"Field"}, 87.5, new String[] {"Pansear", "Simisear"}, 1, 0));
		pokedex.add(new Pokemon("Panpour", "Water", null, 50, 53, 48, 53, 48, 64, 6, new String[] {"Field"}, 87.5, new String[] {"Panpour", "Simipour"}, 0, -1));
		pokedex.add(new Pokemon("Simipour", "Water", null, 75, 98, 63, 98, 63, 101, 21, new String[] {"Field"}, 87.5, new String[] {"Panpour", "Simipour"}, 1, 0));
		pokedex.add(new Pokemon("Munna", "Psychic", null, 76, 25, 45, 67, 55, 24, 6, new String[] {"Field"}, 50, new String[] {"Munna", "Musharna"}, 0, -1));
		pokedex.add(new Pokemon("Musharna", "Psychic", null, 116, 55, 85, 107, 95, 29, 21, new String[] {"Field"}, 50, new String[] {"Munna", "Musharna"}, 1, 0));
		pokedex.add(new Pokemon("Pidove", "Normal", "Flying", 50, 55, 50, 36, 30, 43, 0, new String[] {"Flying"}, 50, new String[] {"Pidove", "Tranquill", "Unfezant"}, 0, 21));
		pokedex.add(new Pokemon("Tranquill", "Normal", "Flying", 62, 77, 62, 50, 42, 65, 17, new String[] {"Flying"}, 50, new String[] {"Pidove", "Tranquill", "Unfezant"}, 1, 32));
		pokedex.add(new Pokemon("Unfezant", "Normal", "Flying", 80, 115, 80, 65, 55, 93, 27, new String[] {"Flying"}, 50, new String[] {"Pidove", "Tranquill", "Unfezant"}	, 2, 0));
		pokedex.add(new Pokemon("Blitzle", "Electric", null, 45, 60, 32, 50, 32, 76, 6, new String[] {"Field"}, 50, new String[] {"Blitzle", "Zebstrika"}, 0, 27));
		pokedex.add(new Pokemon("Zebstrika", "Electric", null, 75, 100, 63, 80, 63, 116, 21, new String[] {"Field"}, 50, new String[] {"Blitzle", "Zebstrika"}, 1, 0));
		pokedex.add(new Pokemon("Roggenrola", "Rock", null, 55, 75, 85, 25, 25, 15, 0, new String[] {"Mineral"}, 50, new String[] {"Roggenrola", "Boldore", "Gigalith"}, 0, 25));
		pokedex.add(new Pokemon("Boldore", "Rock", null, 70, 105, 105, 50, 40, 20, 17, new String[] {"Mineral"}, 50, new String[] {"Roggenrola", "Boldore", "Gigalith"}, 1, -1));
		pokedex.add(new Pokemon("Gigalith", "Rock", null, 85, 135, 130, 60, 80, 25, 27, new String[] {"Mineral"}, 50, new String[] {"Roggenrola", "Boldore", "Gigalith"}, 2, 0));
		pokedex.add(new Pokemon("Woobat", "Psychic", "Flying", 65, 45, 43, 55, 43, 72, 6, new String[] {"Field", "Flying"}, 50, new String[] {"Woobat", "Swoobat"}, 0, -1));
		pokedex.add(new Pokemon("Swoobat", "Psychic", "Flying", 67, 57, 55, 77, 55, 114, 27, new String[] {"Field", "Flying"}, 50, new String[] {"Woobat", "Swoobat"}, 1, 0));
		pokedex.add(new Pokemon("Drilbur", "Ground", null, 60, 85, 40, 30, 45, 68, 17, new String[] {"Field"}, 50, new String[] {"Drilbur", "Excadrill"}, 0, 31));
		pokedex.add(new Pokemon("Excadrill", "Ground", "Steel", 110, 135, 60, 50, 65, 88, 24, new String[] {"Field"}, 50, new String[] {"Drilbur", "Excadrill"}, 1, 0));
		pokedex.add(new Pokemon("Audino", "Normal", null, 103, 60, 86, 60, 86, 50, 0, new String[] {"Fairy"}, 50, new String[] {"Audino"}, 0, 0));
		pokedex.add(new Pokemon("Timburr", "Fighting", null, 75, 80, 55, 25, 35, 35, 7, new String[] {"Human-Like"}, 75, new String[] {"Timburr", "Gurdurr", "Conkeldurr"}, 0, 25));
		pokedex.add(new Pokemon("Gurdurr", "Fighting", null, 85, 105, 85, 40, 50, 40, 19, new String[] {"Human-Like"}, 75, new String[] {"Timburr", "Gurdurr", "Conkeldurr"}, 1, -1));
		pokedex.add(new Pokemon("Conkeldurr", "Fighting", null, 105, 140, 95, 55, 65, 45, 27, new String[] {"Human-Like"}, 75, new String[] {"Timburr", "Gurdurr", "Conkeldurr"}, 2, 0));
		pokedex.add(new Pokemon("Tympole", "Water", null, 50, 50, 40, 50, 40, 60, 0, new String[] {"Water 1"}, 50, new String[] {"Tympole", "Palpitoad", "Seismitoad"}, 0, 25));
		pokedex.add(new Pokemon("Palpitoad", "Water", "Ground", 75, 65, 55, 65, 55, 69, 17, new String[] {"Water 1"}, 50, new String[] {"Tympole", "Palpitoad", "Seismitoad"}, 1, 36));
		pokedex.add(new Pokemon("Seismitoad", "Water", "Ground", 105, 95, 75, 85, 75, 74, 27, new String[] {"Water 1"}, 50, new String[] {"Tympole", "Palpitoad", "Seismitoad"}, 2, 0));
		pokedex.add(new Pokemon("Throh", "Fighting", null, 120, 100, 85, 30, 85, 45, 27, new String[] {"Human-Like"}, 100, new String[] {"Throh"}, 0, 0));
		pokedex.add(new Pokemon("Sawk", "Fighting", null, 75, 125, 75, 30, 75, 85, 27, new String[] {"Human-Like"}, 100, new String[] {"Sawk"}, 0, 0));
		pokedex.add(new Pokemon("Sewaddle", "Bug", "Grass", 45, 53, 70, 40, 60, 42, 0, new String[] {"Bug"}, 50, new String[] {"Sewaddle", "Swadloon", "Leavanny"}, 0, 20));
		pokedex.add(new Pokemon("Swadloon", "Bug", "Grass", 55, 63, 90, 50, 80, 42, 17, new String[] {"Bug"}, 50, new String[] {"Sewaddle", "Swadloon", "Leavanny"}, 1, -1));
		pokedex.add(new Pokemon("Leavanny", "Bug", "Grass", 75, 103, 80, 70, 80, 92, 27, new String[] {"Bug"}, 50, new String[] {"Sewaddle", "Swadloon", "Leavanny"}, 2, 0));
		pokedex.add(new Pokemon("Venipede", "Bug", "Poison", 30, 45, 59, 30, 39, 57, 0, new String[] {"Bug"}, 50, new String[] {"Venipede", "Whirlipede", "Scolipede"}, 0, 22));
		pokedex.add(new Pokemon("Whirlipede", "Bug", "Poison", 40, 55, 99, 40, 79, 47, 17, new String[] {"Bug"}, 50, new String[] {"Venipede", "Whirlipede", "Scolipede"}, 1, 30));
		pokedex.add(new Pokemon("Scolipede", "Bug", "Poison", 60, 100, 89, 55, 69, 112, 27, new String[] {"Bug"}, 50, new String[] {"Venipede", "Whirlipede", "Scolipede"}, 2, 0));
		pokedex.add(new Pokemon("Cottonee", "Grass", "Fairy", 40, 27, 60, 37, 50, 66, 6, new String[] {"Grass", "Fairy"}, 50, new String[] {"Cottonee", "Whimsicott"}, 0, -1));
		pokedex.add(new Pokemon("Whimsicott", "Grass", "Fairy", 60, 67, 85, 77, 75, 116, 21, new String[] {"Grass", "Fairy"}, 50, new String[] {"Cottonee", "Whimsicott"}, 1, 0));
		pokedex.add(new Pokemon("Petilil", "Grass", null, 45, 35, 50, 70, 50, 30, 6, new String[] {"Grass"}, 0, new String[] {"Petilil", "Lilligant"}, 0, -1));
		pokedex.add(new Pokemon("Lilligant", "Grass", null, 70, 60, 75, 110, 75, 90, 21, new String[] {"Grass"}, 0, new String[] {"Petilil", "Lilligant"}, 1, 0));
		pokedex.add(new Pokemon("Basculin", "Water", null, 70, 92, 65, 80, 55, 98, 30, new String[] {"Water 2"}, 50, new String[] {"Basculin"}, 0, 0));
		pokedex.add(new Pokemon("Sandile", "Ground", "Dark", 50, 72, 35, 35, 35, 65, 7, new String[] {"Field"}, 50, new String[] {"Sandile", "Krokorok", "Krookodile"}, 0, 29));
		pokedex.add(new Pokemon("Krokorok", "Ground", "Dark", 60, 82, 45, 45, 45, 74, 19, new String[] {"Field"}, 50, new String[] {"Sandile", "Krokorok", "Krookodile"}, 1, 40));
		pokedex.add(new Pokemon("Krookodile", "Ground", "Dark", 95, 117, 80, 65, 70, 92, 27, new String[] {"Field"}, 50, new String[] {"Sandile", "Krokorok", "Krookodile"}, 2, 0));
		pokedex.add(new Pokemon("Darumaka", "Fire", null, 70, 90, 45, 15, 45, 50, 17, new String[] {"Field"}, 50, new String[] {"Darumaka", "Darmanitan", "DarmanitanZ"}, 0, 35));
		pokedex.add(new Pokemon("Darmanitan", "Fire", null, 105, 140, 55, 30, 55, 95, 24, new String[] {"Field"}, 50, new String[] {"Darumaka", "Darmanitan"}, 1, 0)); // 566:555
		pokedex.add(new Pokemon("DarmanitanZ", "Fire", "Psychic", 105, 30, 105, 140, 105, 55, 24, new String[] {"Field"}, 50, new String[] {"Darumaka", "DarmanitanZ"}, 1, 0)); // 567:555
		pokedex.add(new Pokemon("Maractus", "Grass", null, 75, 86, 67, 106, 67, 60, 0, new String[] {"Grass"}, 50, new String[] {"Maractus"}, 0, 0));
		pokedex.add(new Pokemon("Dwebble", "Bug", "Rock", 50, 65, 85, 35, 35, 55, 6, new String[] {"Bug", "Mineral"}, 50, new String[] {"Dwebble", "Crustle"}, 0, 34));
		pokedex.add(new Pokemon("Crustle", "Bug", "Rock", 70, 105, 125, 65, 75, 45, 21, new String[] {"Bug", "Mineral"}, 50, new String[] {"Dwebble", "Crustle"}, 1, 0));
		pokedex.add(new Pokemon("Scraggy", "Dark", "Fighting", 50, 75, 70, 35, 70, 48, 7, new String[] {"Field", "Dragon"}, 50, new String[] {"Scraggy", "Scrafty"}, 0, 39));
		pokedex.add(new Pokemon("Scrafty", "Dark", "Fighting", 65, 90, 115, 45, 115, 58, 19, new String[] {"Field", "Dragon"}, 50, new String[] {"Scraggy", "Scrafty"}, 1, 0));
		pokedex.add(new Pokemon("Sigilyph", "Psychic", "Flying", 72, 58, 80, 103, 80, 97, 27, new String[] {"Flying"}, 50, new String[] {"Sigilyph"}, 0, 0));
		pokedex.add(new Pokemon("Yamask", "Ghost", null, 38, 30, 85, 55, 65, 30, 6, new String[] {"Mineral", "Amorphous"}, 50, new String[] {"Yamask", "Cofagrigus"}, 0, 34));
		pokedex.add(new Pokemon("Cofagrigus", "Ghost", null, 58, 50, 145, 95, 105, 30, 19, new String[] {"Mineral", "Amorphous"}, 50, new String[] {"Yamask", "Cofagrigus"}, 1, 0));
		pokedex.add(new Pokemon("Tirtouga", "Water", "Rock", 54, 78, 103, 53, 45, 22, 27, new String[] {"Water 1", "Water 3"}, 87.5, new String[] {"Tirtouga", "Carracosta"}, 0, 37));
		pokedex.add(new Pokemon("Carracosta", "Water", "Rock", 74, 108, 133, 83, 65, 32, 27, new String[] {"Water 1", "Water 3"}, 87.5, new String[] {"Tirtouga", "Carracosta"}, 1, 0));
		pokedex.add(new Pokemon("Archen", "Rock", "Flying", 55, 112, 45, 74, 45, 70, 27, new String[] {"Flying", "Water 3"}, 87.5, new String[] {"Archen", "Archeops"}, 0, 37));
		pokedex.add(new Pokemon("Archeops", "Rock", "Flying", 75, 140, 65, 112, 65, 110, 27, new String[] {"Flying", "Water 3"}, 87.5, new String[] {"Archen", "Archeops"}, 1, 0));
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
		boolean searched = false;
		int num = -1;
		while (!done) {
			if (searched) {
				viewPokemonHelper(p, num, input);
				boolean finished = false;
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
							searched = false;
							finished = true;
							break;
						case "2":
							p.sortPC();
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
				printOwnedPokemon(p, startPCIndex, endPCIndex);
				System.out.println("Enter the number corresponding to a Pokemon in your PC to view it or enter \"0\" to go back to the main menu.");
				System.out.println("To see the next " + pageLimit + " pokemon in your pc, enter \"next\" or to see the previous " + pageLimit + " pokemon in your pc, enter \"previous\"");
				System.out.println("If you would like to search for a specific Pokemon, enter \"search\".");
				System.out.println();
				if (input.hasNext()) {
					temp = input.nextLine();		
					if (!isNumeric(temp)) {
						if (!temp.equals("search")) {
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
							boolean repeat = true;
							while (repeat) {
								System.out.println();
								System.out.println("Enter the name of the Pokemon you would like to search for or enter \"0\" to exit search mode.");
								System.out.println();
								if (input.hasNext()) {
									temp = input.nextLine();
									if (temp.equals("0")) {
										System.out.println();
										repeat = false;
									} else {
										ArrayList<OwnedPokemon> opArr = new ArrayList<>();
										for (OwnedPokemon op: p.getPC())
											if (op.getName().equals(temp))
												opArr.add(op);
										if (opArr.size() == 0) {
											System.out.println();
											System.out.println("There are no Pokemon with that name in your PC.");
										} else {
											startPCIndex = 0;
											endPCIndex = pageLimit;
											boolean searching = true;
											while (searching) {
												System.out.println();
												printSearchedPokemon(opArr, startPCIndex, endPCIndex);
												System.out.println("Enter the number corresponding to a Pokemon in your PC to view it or enter \"0\" to go back to the main menu.");
												System.out.println("To see the next " + pageLimit + " pokemon in your pc, enter \"next\" or to see the previous " + pageLimit + " pokemon in your pc, enter \"previous\"");
												System.out.println("If you would like to try a new search, \"0\".");
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
													} else if (Integer.parseInt(temp) < 0 || Integer.parseInt(temp) >= opArr.size() + 1) {
														System.out.println();
														System.out.println("Input does not match an available choice.");
														System.out.println();
													} else if (Integer.parseInt(temp) == 0)
														searching = false;
													else {
														searched = true;
														searching = false;
														repeat = false;
														num = p.getIndex(opArr.get(Integer.parseInt(temp) - 1)) + 1;
													}
												}
											}
										}
									}
								}
							}
						}
					} else {
						num = Integer.parseInt(temp);
						if (num < 0 || num >= p.getPC().size() + 1) {
							System.out.println();
							System.out.println("Input does not match an available choice.");
							System.out.println();
						} else if (num != 0) {
							// print the selected pokemon using its toString() method and ask the user if they want to nickname the pokemon, add the pokemon to favorites, and, finally, if they would like to view another pokemon
							viewPokemonHelper(p, num, input);System.out.println();
							boolean finished = false;
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
										searched = false;
										finished = true;
										break;
									case "2":
										p.sortPC();
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
							done = true;
						}
					}
				}
			}
		}
		// sort the pc because newly favorited or unfavorited pokemon need to be re-sorted
		p.sortPC();
	}

	private static void viewPokemonHelper(Player p, int num, Scanner input) {
		System.out.println();
		System.out.println(p.getPC().get(num - 1));
		System.out.println();
		String temp;
		boolean repeat = false;
		boolean finished = false;
		while (!repeat) {
			System.out.println("Would you like to change anything about this Pokemon?");
			System.out.println("Enter the number corresponding to your choice.");
			System.out.println("1) Nickname");
			System.out.println("2) Favorite Status");
			System.out.println("3) Evolution Lock Status");
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
									if (input.hasNext()) {
										temp = input.nextLine();
										if (temp.length() > 20) {
											System.out.println();
											System.out.println("The name you have input is either less than 1 character ir longer than 20 characters");
											System.out.println();
										} else {
											p.getPC().get(num - 1).setNickname(temp);
											System.out.println();
											System.out.println("Your " + p.getPC().get(num - 1).getPokemon().getName() + " nickname is now " + temp + ".");
											repeat = true;
										}	
									}
								}
								System.out.println();
								repeat = false;
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
				case "0":
					p.sortPC();
					System.out.println();
					repeat = true;
					break;
				default:
					System.out.println();
					System.out.println("Input does not match an available choice.");
					System.out.println();
				}
		}
	}

	private static void printSearchedPokemon(ArrayList<OwnedPokemon> opArr, int startPCIndex, int endPCIndex) {
		System.out.println("Your Pokemon:");
		for (int i = startPCIndex; i < opArr.size() && i < endPCIndex; i++)
			if (opArr.get(i).getNickname().equals(opArr.get(i).getName()))
				if (opArr.get(i).isFavorite())
					System.out.println(i + 1 + ") " + opArr.get(i).getNickname() + " [FAVORITE]");
				else
					System.out.println(i + 1 + ") " + opArr.get(i).getNickname());
			else
				if (opArr.get(i).isFavorite())
					System.out.println(i + 1 + ") " + opArr.get(i).getNickname() + " (" + opArr.get(i).getName() + ")" + " [FAVORITE]");
				else
					System.out.println(i + 1 + ") " + opArr.get(i).getNickname() + " (" + opArr.get(i).getName() + ")");
		System.out.println();
	}

	private static void breed(Player p, Scanner input, ArrayList<Pokemon> pokedex) {
		// user selects 2 pokemon to breed.  they can only breed if they share an egg group and are opposite genders (or both Genderless)
		boolean done = false;
		int startPCIndex = 0;
		int pageLimit = 25;
		int endPCIndex = pageLimit;
		String temp;
		boolean searched = false;
		int num = -1;
		while (!done) {
			if (searched) {
				breedHelper(p, pokedex, num, input);
				done = true;
			} else {
				printOwnedPokemon(p, startPCIndex, endPCIndex);
				System.out.println("Enter the number corresponding to the first Pokemon you would like to breed or enter \"0\" to go back to the main menu.");
				System.out.println("To see the next " + pageLimit + " pokemon in your pc, enter \"next\" or to see the previous " + pageLimit + " pokemon in your pc, enter \"previous\"");
				System.out.println("If you would like to search for a specific Pokemon, enter \"search\".");
				System.out.println();
				if (input.hasNext()) {
					temp = input.nextLine();
					if (!isNumeric(temp)) {
						if (!temp.equals("search")) {
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
							boolean repeat = true;
							while (repeat) {
								System.out.println();
								System.out.println("Enter the name of the Pokemon you would like to search for or enter \"0\" to exit search mode.");
								System.out.println();
								if (input.hasNext()) {
									temp = input.nextLine();
									if (temp.equals("0")) {
										System.out.println();
										repeat = false;
									} else {
										ArrayList<OwnedPokemon> opArr = new ArrayList<>();
										for (OwnedPokemon op: p.getPC())
											if (op.getName().equals(temp))
												opArr.add(op);
										if (opArr.size() == 0) {
											System.out.println();
											System.out.println("There are no Pokemon with that name in your PC.");
										} else {
											startPCIndex = 0;
											endPCIndex = pageLimit;
											boolean searching = true;
											while (searching) {
												System.out.println();
												printSearchedPokemon(opArr, startPCIndex, endPCIndex);
												System.out.println("Enter the number corresponding to a Pokemon in your PC to view it or enter \"0\" to go back to the main menu.");
												System.out.println("To see the next " + pageLimit + " pokemon in your pc, enter \"next\" or to see the previous " + pageLimit + " pokemon in your pc, enter \"previous\"");
												System.out.println("If you would like to try a new search, \"0\".");
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
													} else if (Integer.parseInt(temp) < 0 || Integer.parseInt(temp) >= opArr.size() + 1) {
														System.out.println();
														System.out.println("Input does not match an available choice.");
														System.out.println();
													} else if (Integer.parseInt(temp) == 0)
														searching = false;
													else {
														System.out.println();
														System.out.println(opArr.get(Integer.parseInt(temp) - 1));
														System.out.println();
														System.out.println("Are you sure you would like to use this Pokemon for breeding?");
														System.out.println("1) Yes");
														System.out.println("2) No");
														System.out.println();
														if (input.hasNext()) {
															switch (input.nextLine()) {
															case "1":
																searched = true;
																searching = false;
																repeat = false;
																num = p.getIndex(opArr.get(Integer.parseInt(temp) - 1)) + 1;
																break;
															case "2":
																break;
															default:
																System.out.println();
																System.out.println("Input does not match an available choice.");
																System.out.println();
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					} else {
						num = Integer.parseInt(temp);
						if (num < 0 || num > p.getPC().size()) {
							System.out.println();
							System.out.println("Input does not match an available choice.");
							System.out.println();
						} else if (num != 0) {
							System.out.println();
							System.out.println(p.getPC().get(Integer.parseInt(temp) - 1));
							System.out.println();
							System.out.println("Are you sure you would like to use this Pokemon for breeding?");
							System.out.println("1) Yes");
							System.out.println("2) No");
							System.out.println();
							if (input.hasNext()) {
								switch (input.nextLine()) {
								case "1":
									done = true;
									num = p.getIndex(p.getPC().get(Integer.parseInt(temp) - 1)) + 1;
									breedHelper(p, pokedex, num, input);
									break;
								case "2":
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

	private static void breedHelper(Player p, ArrayList<Pokemon> pokedex, int num, Scanner input) {
		// pokemon number 1 has been selected, now select pokemon number 2
		int startPCIndex = 0;
		int pageLimit = 25;
		int endPCIndex = pageLimit;
		String temp;
		int numTwo = -1;
		boolean searched = false;
		boolean finished = false;
		while (!finished) {
			if (searched) {
				breedHelper2(p, pokedex, num, numTwo, input);
				finished = true;
			} else {
				System.out.println();
				printOwnedPokemon(p, startPCIndex, endPCIndex);
				System.out.println("Enter the number corresponding to the second Pokemon you would like to breed or enter \"0\" to go back to the main menu.");
				System.out.println("To see the next " + pageLimit + " pokemon in your pc, enter \"next\" or to see the previous " + pageLimit + " pokemon in your pc, enter \"previous\"");
				System.out.println();
				if (input.hasNext()) {
					temp = input.nextLine();
					if (!isNumeric(temp)) {
						if (!temp.equals("search")) {
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
							boolean repeat = true;
							while (repeat) {
								System.out.println();
								System.out.println("Enter the name of the Pokemon you would like to search for or enter \"0\" to exit search mode.");
								System.out.println();
								if (input.hasNext()) {
									temp = input.nextLine();
									if (temp.equals("0")) {
										System.out.println();
										repeat = false;
									} else {
										ArrayList<OwnedPokemon> opArr = new ArrayList<>();
										for (OwnedPokemon op: p.getPC())
											if (op.getName().equals(temp))
												opArr.add(op);
										if (opArr.size() == 0) {
											System.out.println();
											System.out.println("There are no Pokemon with that name in your PC.");
										} else {
											startPCIndex = 0;
											endPCIndex = pageLimit;
											boolean searching = true;
											while (searching) {
												System.out.println();
												printSearchedPokemon(opArr, startPCIndex, endPCIndex);
												System.out.println("Enter the number corresponding to a Pokemon in your PC to view it or enter \"0\" to go back to the main menu.");
												System.out.println("To see the next " + pageLimit + " pokemon in your pc, enter \"next\" or to see the previous " + pageLimit + " pokemon in your pc, enter \"previous\"");
												System.out.println("If you would like to try a new search, \"0\".");
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
													} else if (Integer.parseInt(temp) < 0 || Integer.parseInt(temp) >= opArr.size() + 1) {
														System.out.println();
														System.out.println("Input does not match an available choice.");
														System.out.println();
													} else if (Integer.parseInt(temp) == 0)
														searching = false;
													else {
														System.out.println();
														System.out.println(opArr.get(Integer.parseInt(temp) - 1));
														System.out.println();
														System.out.println("Are you sure you would like to use this Pokemon for breeding?");
														System.out.println("1) Yes");
														System.out.println("2) No");
														System.out.println();
														if (input.hasNext()) {
															switch (input.nextLine()) {
															case "1":
																searched = true;
																searching = false;
																repeat = false;
																numTwo = p.getIndex(opArr.get(Integer.parseInt(temp) - 1)) + 1;
																break;
															case "2":
																break;
															default:
																System.out.println();
																System.out.println("Input does not match an available choice.");
																System.out.println();
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					} else {
						numTwo = Integer.parseInt(temp);
						if (numTwo < 0 || numTwo > p.getPC().size()) {
							System.out.println();
							System.out.println("Input does not match an available choice.");
							System.out.println();
						} else if (numTwo != 0) {
							System.out.println();
							System.out.println(p.getPC().get(Integer.parseInt(temp) - 1));
							System.out.println();
							System.out.println("Are you sure you would like to use this Pokemon for breeding?");
							System.out.println("1) Yes");
							System.out.println("2) No");
							if (input.hasNext()) {
								switch (input.nextLine()) {
								case "1":
									searched = true;
									num = p.getIndex(p.getPC().get(Integer.parseInt(temp) - 1)) + 1;
									break;
								case "2":
									break;
								default:
									System.out.println();
									System.out.println("Input does not match an available choice.");
									System.out.println();
								}
							}
							System.out.println();
							breedHelper2(p, pokedex, num, numTwo, input);
							finished = true;
						} else {
							System.out.println();
							finished = true;
						}
					}
				}
			}
		}
	}

	private static void breedHelper2(Player p, ArrayList<Pokemon> pokedex, int num, int numTwo, Scanner input) {
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
			if ((oldOne.getGender().equals("Male") && oldTwo.getGender().equals("Female") && !oldOne.getEggGroup()[0].equals("Undiscovered") && !oldTwo.getEggGroup()[0].equals("Undiscovered"))
					|| (oldOne.getGender().equals("Female") && oldTwo.getGender().equals("Male") && !oldOne.getEggGroup()[0].equals("Undiscovered") && !oldTwo.getEggGroup()[0].equals("Undiscovered"))
					|| (oldOne.getGender().equals("Genderless") && oldTwo.getGender().equals("Genderless") && !oldOne.getEggGroup()[0].equals("Undiscovered") && !oldTwo.getEggGroup()[0].equals("Undiscovered"))
					|| (oldOne.getEggGroup()[0].equals("Undiscovered") && oldTwo.getEggGroup()[0].equals("Undiscovered") && !oldOne.getName().equals("Latias") && !oldOne.getName().equals("Latios") && !oldTwo.getName().equals("Latias") && !oldTwo.getName().equals("Latios"))
					|| (oldOne.getName().equals("Latias") && oldTwo.getName().equals("Latios"))
					|| (oldOne.getName().equals("Latios") && oldTwo.getName().equals("Latias"))
					|| (oldOne.getName().equals("Heatran") && oldOne.getGender().equals("Male") && oldTwo.getName().equals("Heatran") && oldOne.getGender().equals("Female"))
					|| (oldOne.getName().equals("Heatran") && oldOne.getGender().equals("Female") && oldTwo.getName().equals("Heatran") && oldOne.getGender().equals("Male")))
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
				if (oldOne.getName().equals("Latias") || oldOne.getName().equals("Latios")) {
					// if the user is breeding two pokemon from the Undiscovered egg group (which consists of legendary pokemon), they get to choose which one they would like to be the baby pokemon
					repeat = true;
					while (repeat) {
						System.out.println();
						System.out.println("Would you like your baby Pokemon to be a Latias or a Latios?");
						System.out.println("Enter the number corresponding your choice or enter \"0\" to go back to the main menu.");
						System.out.println("1) Latias");
						System.out.println("2) Latios");
						System.out.println();
						if (input.hasNext()) {
							switch (input.nextLine()) {
							case "1":
								pokemon = getBabyPokemon(pokedex, new OwnedPokemon(pokedex.get(379)));
								repeat = false;
								break;
							case "2":
								pokemon = getBabyPokemon(pokedex, new OwnedPokemon(pokedex.get(380)));
								repeat = false;
								break;
							case "0":
								System.out.println();
								repeat = false;
								bred = false;
								break;
							default:
								System.out.println();
								System.out.println("Input does not match an available choice.");
								System.out.println();
							}
						}
					}
				} else if (oldOne.getEggGroup()[0].equals("Undiscovered")) {
					if (oldOne.getName().equals("Heatran")) {
						pokemon = pokedex.get(494);
					} else {
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
									pokemon = oldOne.getPokemon();
									repeat = false;
									break;
								case "2":
									pokemon = oldTwo.getPokemon();
									repeat = false;
									break;
								case "0":
									System.out.println();
									repeat = false;
									bred = false;
									break;
								default:
									System.out.println();
									System.out.println("Input does not match an available choice.");
									System.out.println();
								}
							}
						}
					}
				} else if (oldOne.getEggGroup()[0].equals("Ditto")) {
					//  if one parent is a ditto, the baby pokemon is the first stage of the other parent
					pokemon = getBabyPokemon(pokedex, oldTwo);
				} else if (oldTwo.getEggGroup()[0].equals("Ditto")) {
					pokemon = getBabyPokemon(pokedex, oldOne);
				} else if (oldOne.getGender().equals("Genderless")) {
					//  if the parents are genderless, one of them are chosen randomly and the baby pokemon is the first stage of that parent
					int choose = new Random().nextInt(2);
					if (choose == 0) {
						pokemon = getBabyPokemon(pokedex, oldOne);
					} else {
						pokemon = getBabyPokemon(pokedex, oldTwo);
					}
				} else if (oldOne.getName().equals("NidoranF") || oldOne.getName().equals("Nidorina") || oldOne.getName().equals("Nidoqueen") || oldTwo.getName().equals("NidoranF") || oldTwo.getName().equals("Nidorina") || oldTwo.getName().equals("Nidoqueen")) {
					// special case: if one of the parents is a NidoranF, Nidorina, or Nidoqueen, the baby has a 50-50 chance of being a NidoranF or NidoranM
					int rand = new Random().nextInt(2);
					if (rand == 0) {
						pokemon = pokedex.get(28);
					} else {
						pokemon = pokedex.get(31);
					}
				} else if ((oldOne.getName().equals("Miltank") && oldTwo.getName().equals("Tauros")) || (oldOne.getName().equals("Tauros") && oldTwo.getName().equals("Miltank"))) {
					int rand = new Random().nextInt(2);
					if (rand == 0) {
						pokemon = pokedex.get(240);
					} else {
						pokemon = pokedex.get(127);
					}
				} else if ((oldOne.getName().equals("Volbeat") && oldTwo.getName().equals("Illumise")) || (oldOne.getName().equals("Volbeat") && oldTwo.getName().equals("Illumise"))) {
					int rand = new Random().nextInt(2);
					if (rand == 0) {
						pokemon = pokedex.get(312);
					} else {
						pokemon = pokedex.get(313);
					}
				} else {
					if (oldOne.getGender().equals("Female"))
						pokemon = getBabyPokemon(pokedex, oldTwo);
					else
						pokemon = getBabyPokemon(pokedex, oldTwo);
				}	
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
				}
				p.catchPokemon(createBabyPokemon(p, oldOne, oldTwo, pokemon));
				// when two pokemon are successfully bred, they make a baby with the best IVs of both parents but...
				// the parents are used up so they need to be removed from the players PC
				// the two pokemon need to be removed in the right order in order to make sure the correct pokemon get removed
				// this means that the pokemon that comes later in the PC needs to be removed first
			}
		} else {
			System.out.println("These two Pokemon are not breedable.");
			System.out.println();
		}
	}

	private static OwnedPokemon createBabyPokemon(Player p, OwnedPokemon oldOne, OwnedPokemon oldTwo, Pokemon pokemon) {
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
			System.out.println("6) Change Forme");
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
				case "6":
					System.out.println();
					changeForme(p, pokedex, input);
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
		boolean searched = false;
		int num = -1;
		String temp;
		while (!done) {
			if (searched) {
				levelUpHelper(p, pokedex, num, input);
				done = true;
			} else {
				printOwnedPokemon(p, startPCIndex, endPCIndex);
				System.out.println("Each level-up has a point-cost equal to the Pokemon's current level.");
				System.out.println("Choose the pokemon you want to level up.");
				System.out.println("Enter the number corresponding to a Pokemon in your PC or enter \"0\" to go back to the main menu.");
				System.out.println("To see the next " + pageLimit + " pokemon in your pc, enter \"next\" or to see the previous " + pageLimit + " pokemon in your pc, enter \"previous\"");
				System.out.println("If you would like to search for a specific Pokemon, enter \"search\".");
				System.out.println();
				if (input.hasNext()) {
					temp = input.nextLine();		
					if (!isNumeric(temp)) {
						if (!temp.equals("search")) {
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
							boolean repeat = true;
							while (repeat) {
								System.out.println();
								System.out.println("Enter the name of the Pokemon you would like to search for or enter \"0\" to exit search mode.");
								System.out.println();
								if (input.hasNext()) {
									temp = input.nextLine();
									if (temp.equals("0")) {
										System.out.println();
										repeat = false;
									} else {
										ArrayList<OwnedPokemon> opArr = new ArrayList<>();
										for (OwnedPokemon op: p.getPC())
											if (op.getName().equals(temp))
												opArr.add(op);
										if (opArr.size() == 0) {
											System.out.println();
											System.out.println("There are no Pokemon with that name in your PC.");
										} else {
											startPCIndex = 0;
											endPCIndex = pageLimit;
											boolean searching = true;
											while (searching) {
												System.out.println();
												printSearchedPokemon(opArr, startPCIndex, endPCIndex);
												System.out.println("Enter the number corresponding to a Pokemon in your PC to view it or enter \"0\" to go back to the main menu.");
												System.out.println("To see the next " + pageLimit + " pokemon in your pc, enter \"next\" or to see the previous " + pageLimit + " pokemon in your pc, enter \"previous\"");
												System.out.println("If you would like to try a new search, \"0\".");
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
													} else if (Integer.parseInt(temp) < 0 || Integer.parseInt(temp) >= opArr.size() + 1) {
														System.out.println();
														System.out.println("Input does not match an available choice.");
														System.out.println();
													} else if (Integer.parseInt(temp) == 0)
														searching = false;
													else {
														searched = true;
														searching = false;
														repeat = false;
														num = p.getIndex(opArr.get(Integer.parseInt(temp) - 1)) + 1;
													}
												}
											}
										}
									}
								}
							}
						}
					} else {
						num = Integer.parseInt(temp);
						if (num < 0 || num >= p.getPC().size() + 1) {
							System.out.println();
							System.out.println("Input does not match an available choice.");
							System.out.println();
						} else
							if (num != 0) {
								levelUpHelper(p, pokedex, num, input);
								done = true;
							} else
								done = true;
					}
				}
			}
		}
	}

	private static void levelUpHelper(Player p, ArrayList<Pokemon> pokedex, int num, Scanner input) {
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
										} else if (p.getPC().get(num - 1).getName().equals("Nincada")) {
											// Nincada evolves into 2 pokemon, as in 1 pokemon becomes 2, unlike pokemon like wurmple who only evolve into 1 of its 2 possible evolutions
											// however, I have decided to give the player the choice of which of the two pokemon they will get
											// meaning they wont get both Ninjask and Shedinja, only one
											boolean repeat = false;
											OwnedPokemon op;
											while (repeat) {
												System.out.println();
												System.out.println("Would you like your Nincada to evolve into a Ninjask or a Shedinja?");
												System.out.println("Enter the number corresponding your choice.");
												System.out.println("1) Ninjask");
												System.out.println("2) Shedinja");
												System.out.println();
												if (input.hasNext()) {
													switch (input.nextLine()) {
													case "1":
														System.out.println();
														poke = pokedex.get(290);
														op = p.getPC().get(num - 1);
														p.getPC().remove(num - 1);
														tempPokemon = new OwnedPokemon(op, poke);
														p.catchPokemon(new OwnedPokemon(op, poke));
														System.out.println("Congratulations, your Nincada has evolved into a Ninjask!");
														repeat = false;
														break;
													case "2":
														System.out.println();
														poke = pokedex.get(291);
														op = p.getPC().get(num - 1);
														p.getPC().remove(num - 1);
														tempPokemon = new OwnedPokemon(op, poke);
														p.catchPokemon(new OwnedPokemon(op, poke));
														System.out.println("Congratulations, your Nincada has evolved into a Shedinja!");
														repeat = false;
														break;
													default:
														System.out.println();
														System.out.println("Input does not match an available choice.");
														System.out.println();
													}
												}
											}
										} else if (p.getPC().get(num - 1).getName().equals("Burmy")) {
											// Burmy evolves into Mothim if its a male and Wormadam if its a female
											OwnedPokemon op;
											if (p.getPC().get(num - 1).getGender().equals("Male")) {
												poke = pokedex.get(418);
												op = p.getPC().get(num - 1);
												p.getPC().remove(num - 1);
												tempPokemon = new OwnedPokemon(op, poke);
												p.catchPokemon(new OwnedPokemon(op, poke));
												System.out.println("Congratulations, your Burmy has evolved into a Mothim!");
											} else {
												// Burmy has 3 different formes but they don't have an impact on it until it becomes a Wormadam
												// The player is given a choice of which forme to evolve their Burmy into and they can change it using the Change Forme option in Training
												boolean repeat = false;
												while (repeat) {
													System.out.println();
													System.out.println("Would you like your Burmy to evolve into a Wormadam Plant Cloak, Wormadam Sandy Cloak, or a Wormadam Trash Cloak?");
													System.out.println("Enter the number corresponding your choice.");
													System.out.println("1) Wormadam Plant Cloak");
													System.out.println("2) Wormadam Sandy Cloak");
													System.out.println("3) Wormadam Trash Cloak");
													System.out.println();
													if (input.hasNext()) {
														switch (input.nextLine()) {
														case "1":
															System.out.println();
															poke = pokedex.get(415);
															op = p.getPC().get(num - 1);
															p.getPC().remove(num - 1);
															tempPokemon = new OwnedPokemon(op, poke);
															p.catchPokemon(new OwnedPokemon(op, poke));
															System.out.println("Congratulations, your Burmy has evolved into a Wormadam Plant Cloak!");
															repeat = false;
															break;
														case "2":
															System.out.println();
															poke = pokedex.get(416);
															op = p.getPC().get(num - 1);
															p.getPC().remove(num - 1);
															tempPokemon = new OwnedPokemon(op, poke);
															p.catchPokemon(new OwnedPokemon(op, poke));
															System.out.println("Congratulations, your Burmy has evolved into a Wormadam Sandy Cloak!");
															repeat = false;
															break;
														case "3":
															System.out.println();
															poke = pokedex.get(417);
															op = p.getPC().get(num - 1);
															p.getPC().remove(num - 1);
															tempPokemon = new OwnedPokemon(op, poke);
															p.catchPokemon(new OwnedPokemon(op, poke));
															System.out.println("Congratulations, your Burmy has evolved into a Wormadam Trash Cloak!");
															repeat = false;
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
											if (p.getPC().get(num - 1).getName().equals("Combee") && p.getPC().get(num - 1).getGender().equals("Male")) {
												// this is empty because male Combee cannot evolve but female Combee can so the point is if its a Combee and its a male, do nothing
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
							} else {
								System.out.println("Leveling up this " + p.getPC().get(num - 1).getName() + " costs " + p.getPC().get(num - 1).getLevel() + " " + typePoints);
								System.out.println("You do not have enough " + typePoints + " to level up this Pokemon.");
								System.out.println();
								finished = true;
							}
						break;
					case "0":
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
			System.out.println("This Pokemon is already level 100.  Make a different choice.");
			System.out.println();
		}
	}

	private static void evolve(Player p, Scanner input, ArrayList<Pokemon> pokedex) {
		boolean done = false;
		int startPCIndex = 0;
		int pageLimit = 25;
		int endPCIndex = pageLimit;
		boolean searched = false;
		String temp;
		int num = -1;
		while (!done) {
			if (searched) {
				evolveHelper(p, pokedex, num, input);
				done = true;
			} else {
				printOwnedPokemon(p, startPCIndex, endPCIndex);
				System.out.println("Choose the pokemon you want to evolve.");
				System.out.println("Enter the number corresponding to a Pokemon in your PC or enter \"0\" to go back to the main menu.");
				System.out.println("To see the next " + pageLimit + " pokemon in your pc, enter \"next\" or to see the previous " + pageLimit + " pokemon in your pc, enter \"previous\"");
				System.out.println("If you would like to search for a specific Pokemon, enter \"search\".");
				System.out.println();
				if (input.hasNext()) {
					temp = input.nextLine();		
					if (!isNumeric(temp)) {
						if (!temp.equals("search")) {
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
							boolean repeat = true;
							while (repeat) {
								System.out.println();
								System.out.println("Enter the name of the Pokemon you would like to search for or enter \"0\" to exit search mode.");
								System.out.println();
								if (input.hasNext()) {
									temp = input.nextLine();
									if (temp.equals("0")) {
										System.out.println();
										repeat = false;
									} else {
										ArrayList<OwnedPokemon> opArr = new ArrayList<>();
										for (OwnedPokemon op: p.getPC())
											if (op.getName().equals(temp))
												opArr.add(op);
										if (opArr.size() == 0) {
											System.out.println();
											System.out.println("There are no Pokemon with that name in your PC.");
										} else {
											startPCIndex = 0;
											endPCIndex = pageLimit;
											boolean searching = true;
											while (searching) {
												System.out.println();
												printSearchedPokemon(opArr, startPCIndex, endPCIndex);
												System.out.println("Enter the number corresponding to a Pokemon in your PC to view it or enter \"0\" to go back to the main menu.");
												System.out.println("To see the next " + pageLimit + " pokemon in your pc, enter \"next\" or to see the previous " + pageLimit + " pokemon in your pc, enter \"previous\"");
												System.out.println("If you would like to try a new search, \"0\".");
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
													} else if (Integer.parseInt(temp) < 0 || Integer.parseInt(temp) >= opArr.size() + 1) {
														System.out.println();
														System.out.println("Input does not match an available choice.");
														System.out.println();
													} else if (Integer.parseInt(temp) == 0)
														searching = false;
													else {
														searched = true;
														searching = false;
														repeat = false;
														num = p.getIndex(opArr.get(Integer.parseInt(temp) - 1)) + 1;
													}
												}
											}
										}
									}
								}
							}
						}
					} else {
						num = Integer.parseInt(temp);
						if (num < 0 || num >= p.getPC().size() + 1) {
							System.out.println();
							System.out.println("Input does not match an available choice.");
							System.out.println();
						} else
							if (num != 0) {
								evolveHelper(p, pokedex, num, input);
								done = true;
							} else
								done = true;
					}
				}
			}
		}
	}

	private static void evolveHelper(Player p, ArrayList<Pokemon> pokedex, int num, Scanner input) {
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
									System.out.println("6) Leafeon");
									System.out.println("7) Glaceon");
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
											finished = true;
											repeat = true;
											break;
										case "6":
											System.out.println();
											p.spendTier4(100);
											poke = pokedex.get(474);
											op = new OwnedPokemon(p.getPC().get(num - 1), poke);
											p.getPC().remove(num - 1);
											p.catchPokemon(op);
											System.out.println("Congratulations, your Eevee has evolved into a Leafeon!");
											p.getPC().get(p.getIndex(op)).addT4PointsInvested(100);
											finished = true;
											repeat = true;
											break;
										case "7":
											System.out.println();
											p.spendTier4(100);
											poke = pokedex.get(475);
											op = new OwnedPokemon(p.getPC().get(num - 1), poke);
											p.getPC().remove(num - 1);
											p.catchPokemon(op);
											System.out.println("Congratulations, your Eevee has evolved into a Glaceon!");
											p.getPC().get(p.getIndex(op)).addT4PointsInvested(100);
											finished = true;
											repeat = true;
											break;
										case "0":
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
											finished = true;
											repeat = true;
											break;
										case "0":
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
							} else if(p.getPC().get(num - 1).getName().equals("Poliwhirl")){
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
											finished = true;
											repeat = true;
											break;
										case "0":
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
							} else if (p.getPC().get(num - 1).getName().equals("Clamperl")) {
								// Clamperl is another special case in special condition evolutions because it can evolve into 2 different Pokemon
								System.out.println();
								boolean repeat = false;
								while (!repeat) {
									System.out.println("What would you like to evolve you Clamperl into?");
									System.out.println("1) Huntail");
									System.out.println("2) Gorebyss");
									System.out.println("Enter \"0\" to go back to the main menu.");
									System.out.println();
									poke = p.getPC().get(num - 1).getPokemon();
									if (input.hasNext())
										switch (input.nextLine()) {
										case "1":
											System.out.println();
											p.spendTier1(100);
											poke = pokedex.get(366);
											op = new OwnedPokemon(p.getPC().get(num - 1), poke);
											p.getPC().remove(num - 1);
											p.catchPokemon(op);
											System.out.println("Congratulations, your Clamperl has evolved into a Huntail!");
											p.getPC().get(p.getIndex(op)).addT1PointsInvested(100);
											finished = true;
											repeat = true;
											break;
										case "2":
											System.out.println();
											p.spendTier1(100);
											poke = pokedex.get(367);
											op = new OwnedPokemon(p.getPC().get(num - 1), poke);
											p.getPC().remove(num - 1);
											p.catchPokemon(op);
											System.out.println("Congratulations, your Clamperl has evolved into a Gorebyss!");
											p.getPC().get(p.getIndex(op)).addT1PointsInvested(100);
											finished = true;
											repeat = true;
											break;
										case "0":
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
											finished = true;
											repeat = true;
										case "0":
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
						}
						break;
					case "0":
						finished = true;
						break;
					default:
						System.out.println();
						System.out.println("Input does not match an available choice.");
						System.out.println();
					}
			}
		} else if (p.getPC().get(num - 1).getName().equals("Slowpoke")) {
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
							repeat = true;
							break;
						case "0":
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
			}
		} else if (p.getPC().get(num - 1).getName().equals("Kirlia") && p.getPC().get(num - 1).getGender().equals("Male")) {
			if (p.getTier2() >= 100) {
				System.out.println();
				p.spendTier2(100);
				Pokemon poke = pokedex.get(479);
				OwnedPokemon op = new OwnedPokemon(p.getPC().get(num - 1), poke);
				p.getPC().remove(num - 1);
				p.catchPokemon(op);
				System.out.println("Congratulations, your Kirlia has evolved into a Gallade!");
				p.getPC().get(p.getIndex(op)).addT2PointsInvested(100);
			} else {
				System.out.println();
				System.out.println("Evolving Kirlia costs 100 Tier 2 Points");
				System.out.println("You do not have enough Tier 2 Points to evolve your Kirlia");
				System.out.println();
			}
		} else if (p.getPC().get(num - 1).getName().equals("Snorunt") && p.getPC().get(num - 1).getGender().equals("Female")) {
			if (p.getTier1() >= 100) {
				System.out.println();
				p.spendTier1(100);
				Pokemon poke = pokedex.get(482);
				OwnedPokemon op = new OwnedPokemon(p.getPC().get(num - 1), poke);
				p.getPC().remove(num - 1);
				p.catchPokemon(op);
				System.out.println("Congratulations, your Snorunt has evolved into a Froslass!");
				p.getPC().get(p.getIndex(op)).addT1PointsInvested(100);
			} else {
				System.out.println();
				System.out.println("Evolving Snorunt costs 100 Tier 1 Points");
				System.out.println("You do not have enough Tier 1 Points to evolve your Snorunt");
				System.out.println();
			}
		} else {
			System.out.println();
			System.out.println("This Pokemon does not require a special condition to evolve.");
		}
	}

	private static void evTrain(Player p, Scanner input) {
		boolean done = false;
		int startPCIndex = 0;
		int pageLimit = 25;
		int endPCIndex = pageLimit;
		boolean searched = false;
		int num = -1;
		String temp;
		while (!done) {
			if (searched) {
				evTrainHelper(p, num, input);
				done = true;
			} else {
				printOwnedPokemon(p, startPCIndex, endPCIndex);
				System.out.println("Choose a Pokemon to EV Train.");
				System.out.println("Enter the number corresponding to a Pokemon in your PC or enter \"0\" to go back to the main menu.");
				System.out.println("To see the next " + pageLimit + " pokemon in your pc, enter \"next\" or to see the previous " + pageLimit + " pokemon in your pc, enter \"previous\"");
				System.out.println("If you would like to search for a specific Pokemon, enter \"search\".");
				System.out.println();
				if (input.hasNext()) {
					temp = input.nextLine();		
					if (!isNumeric(temp)) {
						if (!temp.equals("search")) {
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
							boolean repeat = true;
							while (repeat) {
								System.out.println();
								System.out.println("Enter the name of the Pokemon you would like to search for or enter \"0\" to exit search mode.");
								System.out.println();
								if (input.hasNext()) {
									temp = input.nextLine();
									if (temp.equals("0")) {
										System.out.println();
										repeat = false;
									} else {
										ArrayList<OwnedPokemon> opArr = new ArrayList<>();
										for (OwnedPokemon op: p.getPC())
											if (op.getName().equals(temp))
												opArr.add(op);
										if (opArr.size() == 0) {
											System.out.println();
											System.out.println("There are no Pokemon with that name in your PC.");
										} else {
											startPCIndex = 0;
											endPCIndex = pageLimit;
											boolean searching = true;
											while (searching) {
												System.out.println();
												printSearchedPokemon(opArr, startPCIndex, endPCIndex);
												System.out.println("Enter the number corresponding to a Pokemon in your PC to view it or enter \"0\" to go back to the main menu.");
												System.out.println("To see the next " + pageLimit + " pokemon in your pc, enter \"next\" or to see the previous " + pageLimit + " pokemon in your pc, enter \"previous\"");
												System.out.println("If you would like to try a new search, \"0\".");
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
													} else if (Integer.parseInt(temp) < 0 || Integer.parseInt(temp) >= opArr.size() + 1) {
														System.out.println();
														System.out.println("Input does not match an available choice.");
														System.out.println();
													} else if (Integer.parseInt(temp) == 0)
														searching = false;
													else {
														searched = true;
														searching = false;
														repeat = false;
														num = p.getIndex(opArr.get(Integer.parseInt(temp) - 1)) + 1;
													}
												}
											}
										}
									}
								}
							}
						}
					} else {
						num = Integer.parseInt(temp);
						if (num < 0 || num >= p.getPC().size() + 1) {
							System.out.println();
							System.out.println("Input does not match an available choice.");
							System.out.println();
						} else if (num != 0) {
							evTrainHelper(p, num, input);
							done = true;
						} else
							done = true;
					}
				}
			}
		}
	}

	private static void evTrainHelper(Player p, int num, Scanner input) {
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
		boolean searched = false;
		int num = -1;
		String temp;
		while (!done) {
			if (searched) {
				resetEVsHelper(p, num, input);
				done = true;
			} else {
				printOwnedPokemon(p, startPCIndex, endPCIndex);
				System.out.println("Choose a Pokemon whose EVs you would like to reset.");
				System.out.println("NOTE: YOU WILL NOT BE REFUNDED THE POINTS SPENT IN GETTING THE RESET EVS");
				System.out.println("Enter the number corresponding to a Pokemon in your PC or enter \"0\" to go back to the main menu.");
				System.out.println("To see the next " + pageLimit + " pokemon in your pc, enter \"next\" or to see the previous " + pageLimit + " pokemon in your pc, enter \"previous\"");
				System.out.println("If you would like to search for a specific Pokemon, enter \"search\".");
				System.out.println();
				if (input.hasNext()) {
					temp = input.nextLine();
					if (!isNumeric(temp)) {
						if (!temp.equals("search")) {
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
							boolean repeat = true;
							while (repeat) {
								System.out.println();
								System.out.println("Enter the name of the Pokemon you would like to search for or enter \"0\" to exit search mode.");
								System.out.println();
								if (input.hasNext()) {
									temp = input.nextLine();
									if (temp.equals("0")) {
										System.out.println();
										repeat = false;
									} else {
										ArrayList<OwnedPokemon> opArr = new ArrayList<>();
										for (OwnedPokemon op: p.getPC())
											if (op.getName().equals(temp))
												opArr.add(op);
										if (opArr.size() == 0) {
											System.out.println();
											System.out.println("There are no Pokemon with that name in your PC.");
										} else {
											startPCIndex = 0;
											endPCIndex = pageLimit;
											boolean searching = true;
											while (searching) {
												System.out.println();
												printSearchedPokemon(opArr, startPCIndex, endPCIndex);
												System.out.println("Enter the number corresponding to a Pokemon in your PC to view it or enter \"0\" to go back to the main menu.");
												System.out.println("To see the next " + pageLimit + " pokemon in your pc, enter \"next\" or to see the previous " + pageLimit + " pokemon in your pc, enter \"previous\"");
												System.out.println("If you would like to try a new search, \"0\".");
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
													} else if (Integer.parseInt(temp) < 0 || Integer.parseInt(temp) >= opArr.size() + 1) {
														System.out.println();
														System.out.println("Input does not match an available choice.");
														System.out.println();
													} else if (Integer.parseInt(temp) == 0)
														searching = false;
													else {
														searched = true;
														searching = false;
														repeat = false;
														num = p.getIndex(opArr.get(Integer.parseInt(temp) - 1)) + 1;
													}
												}
											}
										}
									}
								}
							}
						}
					} else {
						num = Integer.parseInt(temp);
						if (num < 0 || num >= p.getPC().size() + 1) {
							System.out.println();
							System.out.println("Input does not match an available choice.");
							System.out.println();
						} else if (num != 0) {
							resetEVsHelper(p, num, input);
							done = true;
						} else
							System.out.println();
					}
				}
			}
		}
	}

	private static void resetEVsHelper(Player p, int num, Scanner input) {
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
					repeat = true;
					break;
				default:
					System.out.println();
					System.out.println("Input does not match an available choice.");
					System.out.println();
				}
		}
	}

	private static void changeNature(Player p, Scanner input) {
		boolean done = false;
		int startPCIndex = 0;
		int pageLimit = 25;
		int endPCIndex = pageLimit;
		boolean searched = false;
		int num = -1;
		String temp;
		while (!done) {
			if (searched) {
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
				printOwnedPokemon(p, startPCIndex, endPCIndex);
				System.out.println("Enter the number corresponding to a Pokemon in your PC to view it or enter \"0\" to go back to the main menu.");
				System.out.println("To see the next " + pageLimit + " pokemon in your pc, enter \"next\" or to see the previous " + pageLimit + " pokemon in your pc, enter \"previous\"");
				System.out.println("If you would like to search for a specific Pokemon, enter \"search\".");
				System.out.println();
				if (input.hasNext()) {
					temp = input.nextLine();		
					if (!isNumeric(temp)) {
						if (!temp.equals("search")) {
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
							boolean repeat = true;
							while (repeat) {
								System.out.println();
								System.out.println("Enter the name of the Pokemon you would like to search for or enter \"0\" to exit search mode.");
								System.out.println();
								if (input.hasNext()) {
									temp = input.nextLine();
									if (temp.equals("0")) {
										System.out.println();
										repeat = false;
									} else {
										ArrayList<OwnedPokemon> opArr = new ArrayList<>();
										for (OwnedPokemon op: p.getPC())
											if (op.getName().equals(temp))
												opArr.add(op);
										if (opArr.size() == 0) {
											System.out.println();
											System.out.println("There are no Pokemon with that name in your PC.");
										} else {
											startPCIndex = 0;
											endPCIndex = pageLimit;
											boolean searching = true;
											while (searching) {
												System.out.println();
												printSearchedPokemon(opArr, startPCIndex, endPCIndex);
												System.out.println("Enter the number corresponding to a Pokemon in your PC to view it or enter \"0\" to go back to the main menu.");
												System.out.println("To see the next " + pageLimit + " pokemon in your pc, enter \"next\" or to see the previous " + pageLimit + " pokemon in your pc, enter \"previous\"");
												System.out.println("If you would like to try a new search, \"0\".");
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
													} else if (Integer.parseInt(temp) < 0 || Integer.parseInt(temp) >= opArr.size() + 1) {
														System.out.println();
														System.out.println("Input does not match an available choice.");
														System.out.println();
													} else if (Integer.parseInt(temp) == 0)
														searching = false;
													else {
														searched = true;
														searching = false;
														repeat = false;
														num = p.getIndex(opArr.get(Integer.parseInt(temp) - 1)) + 1;
													}
												}
											}
										}
									}
								}
							}
						}
					} else {
						num = Integer.parseInt(temp);
						if (num < 0 || num >= p.getPC().size() + 1) {
							System.out.println();
							System.out.println("Input does not match an available choice.");
							System.out.println();
						} else if (num != 0) {
							// print the selected pokemon using its toString() method and ask the user if they want to nickname the pokemon, add the pokemon to favorites, and, finally, if they would like to view another pokemon
							num = Integer.parseInt(temp);
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
										done = true;
									}
								} else {
									done = true;
								}
							}
						} else {
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

	private static void changeForme(Player p, ArrayList<Pokemon> pokedex, Scanner input) {
		boolean done = false;
		int startPCIndex = 0;
		int pageLimit = 25;
		int endPCIndex = pageLimit;
		String temp;
		ArrayList<OwnedPokemon> opArr = new ArrayList<>();
		for (OwnedPokemon op: p.getPC())
			if (op.getName().equals("DeoxysN") || op.getName().equals("DeoxysA") || op.getName().equals("DeoxysD") || op.getName().equals("DeoxysS")
					|| op.getName().equals("WormadamP") || op.getName().equals("WormadamS") || op.getName().equals("WormadamT") 
					|| op.getName().equals("Rotom") || op.getName().equals("RotomH") || op.getName().equals("RotomW") || op.getName().equals("RotomFr") || op.getName().equals("RotomFa") || op.getName().equals("RotomM")
					|| op.getName().equals("GiratinaA") || op.getName().equals("GiratinaO")
					|| op.getName().equals("Darmanitan") || op.getName().equals("DarmanitanZ"))
				opArr.add(op);
		if (opArr.size() == 0) {
			System.out.println();
			System.out.println("There are no Pokemon in your PC who can change Forme outside of battle.");
			System.out.println();
		} else {
			while (!done) {
				printSearchedPokemon(opArr, startPCIndex, endPCIndex);
				System.out.println("Choose the Pokemon whose Forme you want to change.");
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
								num = p.getIndex(opArr.get(num - 1)) + 1;
								if (p.getPC().get(num - 1).getName().equals("WormadamP") || p.getPC().get(num - 1).getName().equals("WormadamS") || p.getPC().get(num - 1).getName().equals("WormadamT")) {
									boolean enough = true;
									if (p.getTier4() < 100)
										enough = false;
									if (enough) {
										System.out.println();
										System.out.println("Changing Wormadam's forme costs 100 Tier 4 Points");
										System.out.println("Which forme would you like this Pokemon to have?");
										System.out.println("1) Wormadam Plant Cloak");
										System.out.println("2) Wormadam Sandy Cloak");
										System.out.println("3) Wormadam Trash Cloak");
										System.out.println("Enter \"0\" to go back to the main menu.");
										System.out.println();
										boolean finished = false;
										OwnedPokemon op = p.getPC().get(num - 1);
										Pokemon poke;
										while (!finished)
											if (input.hasNext()) {
												switch(temp) {
												case "1":
													if (!op.getName().equals("WormadamP")) {
														poke = pokedex.get(415);
														p.spendTier4(100);
														p.getPC().get(num - 1).addT4PointsInvested(100);
														op = p.getPC().get(num - 1);
														p.getPC().remove(num - 1);
														p.catchPokemon(new OwnedPokemon(op, poke));
														done = true;
														finished = true;
													} else {
														System.out.println();
														System.out.println("Wormadam is already this forme.");
														System.out.println();
													}
													break;
												case "2":
													if (!op.getName().equals("WormadamS")) {
														poke = pokedex.get(416);
														p.spendTier4(100);
														p.getPC().get(num - 1).addT4PointsInvested(100);
														op = p.getPC().get(num - 1);
														p.getPC().remove(num - 1);
														p.catchPokemon(new OwnedPokemon(op, poke));
														done = true;
														finished = true;
													} else {
														System.out.println();
														System.out.println("Wormadam is already this forme.");
														System.out.println();
													}
													break;
												case "3":
													if (!op.getName().equals("WormadamT")) {
														poke = pokedex.get(417);
														p.spendTier4(100);
														p.getPC().get(num - 1).addT4PointsInvested(100);
														op = p.getPC().get(num - 1);
														p.getPC().remove(num - 1);
														p.catchPokemon(new OwnedPokemon(op, poke));
														done = true;
														finished = true;
													} else {
														System.out.println();
														System.out.println("Wormadam is already this forme.");
														System.out.println();
													}
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
										System.out.println("Changing this Pokemon's Forme costs 100 Tier 5 Points");
										System.out.println("You do not have enough Tier 5 Points to change this Pokemon's forme");
										System.out.println();
										done = true;
									}
								} else if (p.getPC().get(num - 1).getName().equals("Rotom") || p.getPC().get(num - 1).getName().equals("RotomH") || p.getPC().get(num - 1).getName().equals("RotomW") || p.getPC().get(num - 1).getName().equals("RotomFr") || p.getPC().get(num - 1).getName().equals("RotomFa") || p.getPC().get(num - 1).getName().equals("RotomM")) {
									num = p.getIndex(opArr.get(num - 1)) + 1;
									boolean enough = true;
									if (p.getTier4() < 100)
										enough = false;
									if (enough) {
										System.out.println();
										System.out.println("Changing Rotom's forme costs 100 Tier 4 Points");
										System.out.println("Which forme would you like this Pokemon to have?");
										System.out.println("1) Rotom");
										System.out.println("2) RotomH");
										System.out.println("3) RotomW");
										System.out.println("4) RotomFr");
										System.out.println("5) RotomFa");
										System.out.println("6) RotomM");
										System.out.println("Enter \"0\" to go back to the main menu.");
										System.out.println();
										boolean finished = false;
										OwnedPokemon op = p.getPC().get(num - 1);
										Pokemon poke;
										while (!finished)
											if (input.hasNext()) {
												switch(temp) {
												case "1":
													if (!op.getName().equals("Rotom")) {
														poke = pokedex.get(483);
														p.spendTier4(100);
														p.getPC().get(num - 1).addT4PointsInvested(100);
														op = p.getPC().get(num - 1);
														p.getPC().remove(num - 1);
														p.catchPokemon(new OwnedPokemon(op, poke));
														done = true;
														finished = true;
													} else {
														System.out.println();
														System.out.println("Rotom is already this forme.");
														System.out.println();
													}
													break;
												case "2":
													if (!op.getName().equals("RotomH")) {
														poke = pokedex.get(484);
														p.spendTier4(100);
														p.getPC().get(num - 1).addT4PointsInvested(100);
														op = p.getPC().get(num - 1);
														p.getPC().remove(num - 1);
														p.catchPokemon(new OwnedPokemon(op, poke));
														done = true;
														finished = true;
													} else {
														System.out.println();
														System.out.println("Rotom is already this forme.");
														System.out.println();
													}
													break;
												case "3":
													if (!op.getName().equals("RotomW")) {
														poke = pokedex.get(485);
														p.spendTier4(100);
														p.getPC().get(num - 1).addT4PointsInvested(100);
														op = p.getPC().get(num - 1);
														p.getPC().remove(num - 1);
														p.catchPokemon(new OwnedPokemon(op, poke));
														done = true;
														finished = true;
													} else {
														System.out.println();
														System.out.println("Rotom is already this forme.");
														System.out.println();
													}
													break;
												case "4":
													if (!op.getName().equals("RotomFr")) {
														poke = pokedex.get(486);
														p.spendTier4(100);
														p.getPC().get(num - 1).addT4PointsInvested(100);
														op = p.getPC().get(num - 1);
														p.getPC().remove(num - 1);
														p.catchPokemon(new OwnedPokemon(op, poke));
														done = true;
														finished = true;
													} else {
														System.out.println();
														System.out.println("Rotom is already this forme.");
														System.out.println();
													}
													break;
												case "5":
													if (!op.getName().equals("RotomFa")) {
														poke = pokedex.get(487);
														p.spendTier4(100);
														p.getPC().get(num - 1).addT4PointsInvested(100);
														op = p.getPC().get(num - 1);
														p.getPC().remove(num - 1);
														p.catchPokemon(new OwnedPokemon(op, poke));
														done = true;
														finished = true;
													} else {
														System.out.println();
														System.out.println("Rotom is already this forme.");
														System.out.println();
													}
													break;
												case "6":
													if (!op.getName().equals("RotomM")) {
														poke = pokedex.get(488);
														p.spendTier4(100);
														p.getPC().get(num - 1).addT4PointsInvested(100);
														op = p.getPC().get(num - 1);
														p.getPC().remove(num - 1);
														p.catchPokemon(new OwnedPokemon(op, poke));
														done = true;
														finished = true;
													} else {
														System.out.println();
														System.out.println("Rotom is already this forme.");
														System.out.println();
													}
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
										System.out.println("Changing this Pokemon's Forme costs 100 Tier 5 Points");
										System.out.println("You do not have enough Tier 5 Points to change this Pokemon's forme");
										System.out.println();
										done = true;
									}
								} else if (p.getPC().get(num - 1).getName().equals("GiratinaA") || p.getPC().get(num - 1).getName().equals("GiratinaO")) {
									num = p.getIndex(opArr.get(num - 1)) + 1;
									boolean enough = true;
									if (p.getTier5() < 100)
										enough = false;
									if (enough) {
										System.out.println();
										System.out.println("Changing Giratina's forme costs 100 Tier 5 Points");
										System.out.println("Which forme would you like this Pokemon to have?");
										System.out.println("1) GiratinaA");
										System.out.println("2) GiratinaO");
										System.out.println("Enter \"0\" to go back to the main menu.");
										System.out.println();
										boolean finished = false;
										OwnedPokemon op = p.getPC().get(num - 1);
										Pokemon poke;
										while (!finished)
											if (input.hasNext()) {
												switch(temp) {
												case "1":
													if (!op.getName().equals("GiratinaA")) {
														poke = pokedex.get(496);
														p.spendTier5(100);
														p.getPC().get(num - 1).addT5PointsInvested(100);
														op = p.getPC().get(num - 1);
														p.getPC().remove(num - 1);
														p.catchPokemon(new OwnedPokemon(op, poke));
														done = true;
														finished = true;
													} else {
														System.out.println();
														System.out.println("Giratina is already this forme.");
														System.out.println();
													}
													break;
												case "2":
													if (!op.getName().equals("GiratinaO")) {
														poke = pokedex.get(497);
														p.spendTier5(100);
														p.getPC().get(num - 1).addT5PointsInvested(100);
														op = p.getPC().get(num - 1);
														p.getPC().remove(num - 1);
														p.catchPokemon(new OwnedPokemon(op, poke));
														done = true;
														finished = true;
													} else {
														System.out.println();
														System.out.println("Giratina is already this forme.");
														System.out.println();
													}
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
										System.out.println("Changing this Pokemon's Forme costs 100 Tier 5 Points");
										System.out.println("You do not have enough Tier 5 Points to change this Pokemon's forme");
										System.out.println();
										done = true;
									}
								} else if (p.getPC().get(num - 1).getName().equals("ShayminL") || p.getPC().get(num - 1).getName().equals("ShayminS")) {
									num = p.getIndex(opArr.get(num - 1)) + 1;
									boolean enough = true;
									if (p.getTier5() < 100)
										enough = false;
									if (enough) {
										System.out.println();
										System.out.println("Changing Shaymin's forme costs 100 Tier 5 Points");
										System.out.println("Which forme would you like this Pokemon to have?");
										System.out.println("1) ShayminL");
										System.out.println("2) ShayminS");
										System.out.println("Enter \"0\" to go back to the main menu.");
										System.out.println();
										boolean finished = false;
										OwnedPokemon op = p.getPC().get(num - 1);
										Pokemon poke;
										while (!finished)
											if (input.hasNext()) {
												switch(temp) {
												case "1":
													if (!op.getName().equals("ShayminL")) {
														poke = pokedex.get(502);
														p.spendTier5(100);
														p.getPC().get(num - 1).addT5PointsInvested(100);
														op = p.getPC().get(num - 1);
														p.getPC().remove(num - 1);
														p.catchPokemon(new OwnedPokemon(op, poke));
														done = true;
														finished = true;
													} else {
														System.out.println();
														System.out.println("Shaymin is already this forme.");
														System.out.println();
													}
													break;
												case "2":
													if (!op.getName().equals("ShayminS")) {
														poke = pokedex.get(503);
														p.spendTier5(100);
														p.getPC().get(num - 1).addT5PointsInvested(100);
														op = p.getPC().get(num - 1);
														p.getPC().remove(num - 1);
														p.catchPokemon(new OwnedPokemon(op, poke));
														done = true;
														finished = true;
													} else {
														System.out.println();
														System.out.println("Shaymin is already this forme.");
														System.out.println();
													}
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
										System.out.println("Changing this Pokemon's Forme costs 100 Tier 5 Points");
										System.out.println("You do not have enough Tier 5 Points to change this Pokemon's forme");
										System.out.println();
										done = true;
									}
								} else if (p.getPC().get(num - 1).getName().equals("Darmanitan") || p.getPC().get(num - 1).getName().equals("DarmanitanZ")) {
									num = p.getIndex(opArr.get(num - 1)) + 1;
									boolean enough = true;
									if (p.getTier3() < 100)
										enough = false;
									if (enough) {
										System.out.println();
										System.out.println("Changing Darmanitan's forme costs 100 Tier 5 Points");
										System.out.println("Which forme would you like this Pokemon to have?");
										System.out.println("1) Darmanitan");
										System.out.println("2) DarmanitanZ");
										System.out.println("Enter \"0\" to go back to the main menu.");
										System.out.println();
										boolean finished = false;
										OwnedPokemon op = p.getPC().get(num - 1);
										Pokemon poke;
										while (!finished)
											if (input.hasNext()) {
												switch(temp) {
												case "1":
													if (!op.getName().equals("Darmanitan")) {
														poke = pokedex.get(566);
														p.spendTier3(100);
														p.getPC().get(num - 1).addT3PointsInvested(100);
														op = p.getPC().get(num - 1);
														p.getPC().remove(num - 1);
														p.catchPokemon(new OwnedPokemon(op, poke));
														done = true;
														finished = true;
													} else {
														System.out.println();
														System.out.println("Darmanitan is already this forme.");
														System.out.println();
													}
													break;
												case "2":
													if (!op.getName().equals("DarmanitanZ")) {
														poke = pokedex.get(567);
														p.spendTier3(100);
														p.getPC().get(num - 1).addT3PointsInvested(100);
														op = p.getPC().get(num - 1);
														p.getPC().remove(num - 1);
														p.catchPokemon(new OwnedPokemon(op, poke));
														done = true;
														finished = true;
													} else {
														System.out.println();
														System.out.println("Darmanitan is already this forme.");
														System.out.println();
													}
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
										System.out.println("Changing this Pokemon's Forme costs 100 Tier 5 Points");
										System.out.println("You do not have enough Tier 5 Points to change this Pokemon's forme");
										System.out.println();
										done = true;
									}
								} else {
									boolean enough = true;
									if (p.getTier5() < 100)
										enough = false;
									if (enough) {
										System.out.println();
										System.out.println("Changing Deoxys' forme costs 100 Tier 5 Points");
										System.out.println("Which forme would you like this Pokemon to have?");
										System.out.println("1) DeoxysN");
										System.out.println("2) DeoxysA");
										System.out.println("3) DeoxysD");
										System.out.println("4) DeoxysS");
										System.out.println("Enter \"0\" to go back to the main menu.");
										System.out.println();
										boolean finished = false;
										OwnedPokemon op = p.getPC().get(num - 1);
										Pokemon poke;
										while (!finished)
											if (input.hasNext()) {
												switch(temp) {
												case "1":
													if (!op.getName().equals("DeoxysN")) {
														poke = pokedex.get(385);
														p.spendTier5(100);
														p.getPC().get(num - 1).addT5PointsInvested(100);
														op = p.getPC().get(num - 1);
														p.getPC().remove(num - 1);
														p.catchPokemon(new OwnedPokemon(op, poke));
														done = true;
														finished = true;
													} else {
														System.out.println();
														System.out.println("Deoxys is already this forme.");
														System.out.println();
													}
													break;
												case "2":
													if (!op.getName().equals("DeoxysA")) {
														poke = pokedex.get(386);
														p.spendTier5(100);
														p.getPC().get(num - 1).addT5PointsInvested(100);
														op = p.getPC().get(num - 1);
														p.getPC().remove(num - 1);
														p.catchPokemon(new OwnedPokemon(op, poke));
														done = true;
														finished = true;
													} else {
														System.out.println();
														System.out.println("Deoxys is already this forme.");
														System.out.println();
													}
													break;
												case "3":
													if (!op.getName().equals("DeoxysD")) {
														poke = pokedex.get(387);
														p.spendTier5(100);
														p.getPC().get(num - 1).addT5PointsInvested(100);
														op = p.getPC().get(num - 1);
														p.getPC().remove(num - 1);
														p.catchPokemon(new OwnedPokemon(op, poke));
														done = true;
														finished = true;
													} else {
														System.out.println();
														System.out.println("Deoxys is already this forme.");
														System.out.println();
													}
													break;
												case "4":
													if (!op.getName().equals("DeoxysS")) {
														poke = pokedex.get(388);
														p.spendTier5(100);
														p.getPC().get(num - 1).addT5PointsInvested(100);
														op = p.getPC().get(num - 1);
														p.getPC().remove(num - 1);
														p.catchPokemon(new OwnedPokemon(op, poke));
														done = true;
														finished = true;
													} else {
														System.out.println();
														System.out.println("Deoxys is already this forme.");
														System.out.println();
													}
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
										System.out.println("Changing this Pokemon's Forme costs 100 Tier 5 Points");
										System.out.println("You do not have enough Tier 5 Points to change this Pokemon's forme");
										System.out.println();
										done = true;
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
	}

	private static void recycle(Player p, Scanner input) {
		boolean done = false;
		int startPCIndex = 0;
		int pageLimit = 25;
		int endPCIndex = pageLimit;
		boolean searched = false;
		int num = -1;
		String temp;
		while (!done) {
			if (searched) {
				recyclePokemonHelper(p, num, input);
				boolean finished = false;
				while (!finished) {
					System.out.println("Would you like to recycle another Pokemon?");
					System.out.println("1) Yes");
					System.out.println("2) No");
					System.out.println();
					if (input.hasNext())
						switch (input.nextLine()) {
						case "1":
							p.sortPC();
							System.out.println();
							searched = false;
							finished = true;
							break;
						case "2":
							p.sortPC();
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
				printOwnedPokemon(p, startPCIndex, endPCIndex);
				System.out.println("Choose a Pokemon to recycle.");
				System.out.println("You will receive points equal to one tenth of the Pokemon's IV percentage combined with half of the points invested into the Pokemon");
				System.out.println("Enter the number corresponding to a Pokemon in your PC or enter \"0\" to go back to the main menu.");
				System.out.println("To see the next " + pageLimit + " pokemon in your pc, enter \"next\" or to see the previous " + pageLimit + " pokemon in your pc, enter \"previous\"");
				System.out.println("If you would like to search for a specific Pokemon, enter \"search\".");
				System.out.println();
				if (input.hasNext()) {
					temp = input.nextLine();
					if (!isNumeric(temp)) {
						if (!temp.equals("search")) {
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
							boolean repeat = true;
							while (repeat) {
								System.out.println();
								System.out.println("Enter the name of the Pokemon you would like to search for or enter \"0\" to exit search mode.");
								System.out.println();
								if (input.hasNext()) {
									temp = input.nextLine();
									if (temp.equals("0")) {
										System.out.println();
										repeat = false;
									} else {
										ArrayList<OwnedPokemon> opArr = new ArrayList<>();
										for (OwnedPokemon op: p.getPC())
											if (op.getName().equals(temp))
												opArr.add(op);
										if (opArr.size() == 0) {
											System.out.println();
											System.out.println("There are no Pokemon with that name in your PC.");
										} else {
											startPCIndex = 0;
											endPCIndex = pageLimit;
											boolean searching = true;
											while (searching) {
												System.out.println();
												printSearchedPokemon(opArr, startPCIndex, endPCIndex);
												System.out.println("Enter the number corresponding to a Pokemon in your PC to view it or enter \"0\" to go back to the main menu.");
												System.out.println("To see the next " + pageLimit + " pokemon in your pc, enter \"next\" or to see the previous " + pageLimit + " pokemon in your pc, enter \"previous\"");
												System.out.println("If you would like to try a new search, \"0\".");
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
													} else if (Integer.parseInt(temp) < 0 || Integer.parseInt(temp) >= opArr.size() + 1) {
														System.out.println();
														System.out.println("Input does not match an available choice.");
														System.out.println();
													} else if (Integer.parseInt(temp) == 0)
														searching = false;
													else {
														searched = true;
														searching = false;
														repeat = false;
														num = p.getIndex(opArr.get(Integer.parseInt(temp) - 1)) + 1;
													}
												}
											}
										}
									}
								}
							}
						}
					} else {
						num = Integer.parseInt(temp);
						if (num < 0 || num >= p.getPC().size() + 1) {
							System.out.println();
							System.out.println("Input does not match an available choice.");
							System.out.println();
						} else {
							if (num != 0) {
								recyclePokemonHelper(p, num, input);
								boolean finished = false;
								while (!finished) {
									System.out.println("Would you like to recycle another Pokemon?");
									System.out.println("1) Yes");
									System.out.println("2) No");
									System.out.println();
									if (input.hasNext())
										switch (input.nextLine()) {
										case "1":
											p.sortPC();
											System.out.println();
											searched = false;
											finished = true;
											break;
										case "2":
											p.sortPC();
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
								done = true;
							}
						}
					}
				}
			}
		}
	}

	private static void recyclePokemonHelper(Player p, int num, Scanner input) {
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
			System.out.println("You will also get back half the points you invested into it.  Here's the points you'll get:");
			System.out.println("Tier 1 Points: " + p.getPC().get(num - 1).getT1PointsInvested());
			System.out.println("Tier 2 Points: " + p.getPC().get(num - 1).getT2PointsInvested());
			System.out.println("Tier 3 Points: " + p.getPC().get(num - 1).getT3PointsInvested());
			System.out.println("Tier 4 Points: " + p.getPC().get(num - 1).getT4PointsInvested());
			System.out.println("Tier 5 Points: " + p.getPC().get(num - 1).getT5PointsInvested());
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
					}
					if (typePoints.equals("Tier 2 Points")) {
						p.addTier2(numPoints);
					}
					if (typePoints.equals("Tier 3 Points")) {
						p.addTier3(numPoints);
					}
					if (typePoints.equals("Tier 4 Points")) {
						p.addTier4(numPoints);
					}
					if (typePoints.equals("Tier 5 Points")) {
						p.addTier5(numPoints);
					}
					p.getPC().get(num - 1).refundPoints(p);
					System.out.println("You now have: ");
					System.out.println(p.getTier1() + " Tier 1 Points.");
					System.out.println(p.getTier2() + " Tier 2 Points.");
					System.out.println(p.getTier3() + " Tier 3 Points.");
					System.out.println(p.getTier4() + " Tier 4 Points.");
					System.out.println(p.getTier5() + " Tier 5 Points.");
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
						System.out.println();
						System.out.println("Succesfully Converted Points.");
						System.out.println();
					} else {
						System.out.println();
						System.out.println("You do not have enough Tier 1 Points to make this conversion.");
						System.out.println();
					}
					break;
				case "2":
					if (p.getTier2() >= 100) {
						p.spendTier2(100);
						p.addTier3(10);
						System.out.println();
						System.out.println("Succesfully Converted Points.");
						System.out.println();
					} else {
						System.out.println();
						System.out.println("You do not have enough Tier 2 Points to make this conversion.");
						System.out.println();
					}
					break;
				case "3":
					if (p.getTier3() >= 100) {
						p.spendTier3(100);
						p.addTier4(10);
						System.out.println();
						System.out.println("Succesfully Converted Points.");
						System.out.println();
					} else {
						System.out.println();
						System.out.println("You do not have enough Tier 3 Points to make this conversion.");
						System.out.println();
					}
					break;
				case "4":
					if (p.getTier4() >= 100) {
						p.spendTier4(100);
						p.addTier5(10);
						System.out.println();
						System.out.println("Succesfully Converted Points.");
						System.out.println();
					} else {
						System.out.println();
						System.out.println("You do not have enough Tier 4 Points to make this conversion.");
						System.out.println();
					}
					break;
				case "5":
					if (p.getTier5() >= 10) {
						p.spendTier5(10);
						p.addTier4(100);
						System.out.println();
						System.out.println("Succesfully Converted Points.");
						System.out.println();
					} else {
						System.out.println();
						System.out.println("You do not have enough Tier 5 Points to make this conversion.");
						System.out.println();
					}
					break;
				case "6":
					if (p.getTier4() >= 10) {
						p.spendTier4(10);
						p.addTier3(100);
						System.out.println();
						System.out.println("Succesfully Converted Points.");
						System.out.println();
					} else {
						System.out.println();
						System.out.println("You do not have enough Tier 4 Points to make this conversion.");
						System.out.println();
					}
					break;
				case "7":
					if (p.getTier3() >= 10) {
						p.spendTier3(10);
						p.addTier2(100);
						System.out.println();
						System.out.println("Succesfully Converted Points.");
						System.out.println();
					} else {
						System.out.println();
						System.out.println("You do not have enough Tier 3 Points to make this conversion.");
						System.out.println();
					}
					break;
				case "8":
					if (p.getTier2() >= 10) {
						p.spendTier2(10);
						p.addTier1(100);
						System.out.println();
						System.out.println("Succesfully Converted Points.");
						System.out.println();
					} else {
						System.out.println();
						System.out.println("You do not have enough Tier 2 Points to make this conversion.");
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