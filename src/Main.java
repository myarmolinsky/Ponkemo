import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		ArrayList<Pokemon> pokedex = new ArrayList<>();
		fillPossibilities(pokedex);
		// fill pokedex with all pokemon
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
				//if the file exists, set the player object to the one read from the file
				// if the file does not exist, just keep the preinitialized new player object
				// set finished to true when done
				finished = true;
				try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("saves.ser"));){
					p = (Player) ois.readObject();
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
				p.addTier1(600);
		while(!finished) {
			// while not finished, prompt user what action they would like to take.  User is not finished until they quit
			System.out.println("Input the number corresponding to your choice:");
			System.out.println("1) Search for Pokemon");
			System.out.println("2) View/Edit Owned Pokemon");
			System.out.println("3) Sort PC");
			System.out.println("4) Breed Pokemon");
			System.out.println("5) Train Pokemon");
			System.out.println("6) Recycle Pokemon");
			System.out.println("7) View Player Data");
			System.out.println("8) Save");
			System.out.println("9) Save Quit");
			System.out.println("10) Quit");
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
				printPlayerData(p);
				break;
			case "8":
				System.out.println();
				System.out.println("Saving ...");
				System.out.println();
				save(p);
				break;
			case "9":
				finished = true;
				System.out.println();
				System.out.println("Saving and Quitting ...");
				save(p);
				break;
			case "10":
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
		pokedex.add(new Pokemon("Pikachu", "Electric", null, 35, 55, 40, 50, 50, 90, 6, new String[] {"Field", "Fairy"}, 50, new String[] {"Pikachu", "Raichu"}, 0, -1));
		pokedex.add(new Pokemon("Raichu", "Electric", null, 60, 90, 55, 90, 80, 110, 21, new String[] {"Field", "Fairy"}, 50, new String[] {"Pikachu", "Raichu"}, 1, 0));
		pokedex.add(new Pokemon("Sandshrew", "Ground", null, 50, 75, 85, 20, 30, 40, 0, new String[] {"Field"}, 50, new String[] {"Sandshrew", "Sandslash"}, 0, 22));
		pokedex.add(new Pokemon("Sandslash", "Ground", null, 75, 100, 110, 45, 55, 65, 19, new String[] {"Field"}, 50, new String[] {"Sandshrew", "Sandslash"}, 1, 0));
		pokedex.add(new Pokemon("NidoranF", "Poison", null, 55, 47, 52, 40, 40, 41, 1, new String[] {"Monster", "Field"}, 0, new String[] {"NidoranF", "Nidorina", "Nidoqueen"}, 0, 16));
		pokedex.add(new Pokemon("Nidorina", "Poison", null, 70, 62, 67, 55, 55, 56, 17, new String[] {"Monster", "Water 1"}, 0, new String[] {"NidoranF", "Nidorina", "Nidoqueen"}, 1, -1));
		pokedex.add(new Pokemon("Nidoqueen", "Poison", "Ground", 90, 82, 87, 75, 85, 76, 27, new String[] {"Monster", "Water 1"}, 0, new String[] {"NidoranF", "Nidorina", "Nidoqueen"}, 2, 0));
		pokedex.add(new Pokemon("NidoranM", "Poison", null, 46, 57, 40, 40, 40, 50, 1, new String[] {"Monster", "Water 1"}, 100, new String[] {"NidoranM", "Nidorino", "Nidoking"}, 0, 16));
		pokedex.add(new Pokemon("Nidorino", "Poison", null, 61, 72, 57, 55, 55, 65, 17, new String[] {"Monster", "Water 1"}, 100, new String[] {"NidoranM", "Nidorino", "Nidoking"}, 1, -1));
		pokedex.add(new Pokemon("Nidoking", "Poison", "Ground", 81, 102, 77, 85, 75, 85, 27, new String[] {"Monster", "Water 1"}, 100, new String[] {"NidoranM", "Nidorino", "Nidoking"}, 2, 0));
		pokedex.add(new Pokemon("Clefairy", "Fairy", null, 70, 45, 48, 60, 65, 35, 11, new String[] {"Fairy"}, 25, new String[] {"Clefairy", "Clefable"}, 0, -1));
		pokedex.add(new Pokemon("Clefable", "Fairy", null, 95, 70, 73, 95, 90, 60, 30, new String[] {"Fairy"}, 25, new String[] {"Clefairy", "Clefable"}, 1, 0));
		pokedex.add(new Pokemon("Vulpix", "Fire", null, 39, 41, 40, 50, 65, 65, 6, new String[] {"Field"}, 25, new String[] {"Vulpix", "Ninetales"}, 0, -1));
		pokedex.add(new Pokemon("Ninetales", "Fire", null, 73, 76, 75, 81, 100, 100, 21, new String[] {"Field"}, 25, new String[] {"Vulpix", "Ninetales"}, 1, 0));
		pokedex.add(new Pokemon("Jigglypuff", "Normal", "Fairy", 115, 45, 20, 45, 25, 20, 8, new String[] {"Fairy"}, 25, new String[] {"Jigglypuff", "Wigglytuff"}, 0, -1));
		pokedex.add(new Pokemon("Wigglytuff", "Normal", "Fairy", 140, 70, 45, 85, 50, 45, 26, new String[] {"Fairy"}, 25, new String[] {"Jigglypuff", "Wigglytuff"}, 1, 0));
		pokedex.add(new Pokemon("Zubat", "Poison", "Flying", 40, 45, 35, 30, 40, 55, 0, new String[] {"Flying"}, 50, new String[] {"Zubat", "Golbat"}, 0, 22));
		pokedex.add(new Pokemon("Golbat", "Poison", "Flying", 75, 80, 70, 65, 75, 90, 19, new String[] {"Flying"}, 50, new String[] {"Zubat", "Golbat"}, 1, 0));
		pokedex.add(new Pokemon("Oddish", "Grass", "Poison", 45, 50, 55, 75, 65, 30, 0, new String[] {"Grass"}, 50, new String[] {"Oddish", "Gloom", "Vileplume"}, 0, 21));
		pokedex.add(new Pokemon("Gloom", "Grass", "Poison", 60, 65, 70, 85, 75, 40, 17, new String[] {"Grass"}, 50, new String[] {"Oddish", "Gloom", "Vileplume"}, 1, -1));
		pokedex.add(new Pokemon("Vileplume", "Grass", "Poison", 75, 80, 85, 110, 90, 50, 27, new String[] {"Grass"}, 50, new String[] {"Oddish", "Gloom", "Vileplume"}, 2, 0));
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
		pokedex.add(new Pokemon("Poliwag", "Water", null, 40, 50, 40, 40, 40, 90, 0, new String[] {"Water 1"}, 50, new String[] {"Poliwag", "Poliwhirl", "Poliwrath"}, 0, 25));
		pokedex.add(new Pokemon("Poliwhirl", "Water", null, 65, 65, 65, 50, 50, 90, 17, new String[] {"Water 1"}, 50, new String[] {"Poliwag", "Poliwhirl", "Poliwrath"}, 1, -1));
		pokedex.add(new Pokemon("Poliwrath", "Water", "Fighting", 90, 95, 95, 70, 90, 70, 27, new String[] {"Water 1"}, 50, new String[] {"Poliwag", "Poliwhirl", "Poliwrath"}, 3, 0));
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
		pokedex.add(new Pokemon("Slowpoke", "Water", "Psychic", 90, 65, 65, 40, 40, 15, 6, new String[] {"Monster", "Water 1"}, 50, new String[] {"Slowpoke", "Slowbro"}, 0, 37));
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
		pokedex.add(new Pokemon("Onix", "Rock", "Ground", 35, 45, 160, 30, 45, 70, 27, new String[] {"Mineral"}, 50, new String[] {"Onix"}, 0, 0));
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
		pokedex.add(new Pokemon("Hitmonlee", "Fighting", null, 50, 120, 53, 35, 110, 87, 27, new String[] {"Human-Like"}, 100, new String[] {"Hitmonlee"}, 0, 0));
		pokedex.add(new Pokemon("Hitmonchan", "Fighting", null, 50, 105, 79, 35, 110, 76, 27, new String[] {"Human-Like"}, 100, new String[] {"Hitmonchan"}, 0, 0));
		pokedex.add(new Pokemon("Lickitung", "Normal", null, 90, 55, 75, 60, 75, 30, 27, new String[] {"Monster"}, 50, new String[] {"Lickitung"}, 0, 0));
		pokedex.add(new Pokemon("Koffing", "Poison", null, 40, 65, 95, 60, 45, 35, 6, new String[] {"Amorphous"}, 50, new String[] {"Koffing", "Weezing"}, 0, 35));
		pokedex.add(new Pokemon("Weezing", "Poison", null, 65, 90, 120, 85, 70, 60, 24, new String[] {"Amorphous"}, 50, new String[] {"Koffing", "Weezing"}, 1, 0));
		pokedex.add(new Pokemon("Rhyhorn", "Ground", "Rock", 80, 85, 95, 30, 30, 25, 17, new String[] {"Field", "Monster"}, 50, new String[] {"Rhyhorn", "Rhydon"}, 0, 42));
		pokedex.add(new Pokemon("Rhydon", "Ground", "Rock", 105, 130, 120, 45, 45, 40, 24, new String[] {"Field", "Monster"}, 50, new String[] {"Rhyhorn", "Rhydon"}, 1, 0));
		pokedex.add(new Pokemon("Chansey", "Normal", null, 250, 5, 5, 35, 105, 50, 29, new String[] {"Fairy"}, 0, new String[] {"Chansey"}, 0, 0));
		pokedex.add(new Pokemon("Tangela", "Grass", null, 65, 55, 115, 100, 40, 60, 27, new String[] {"Grass"}, 50, new String[] {"Tangela"}, 0, 0));
		pokedex.add(new Pokemon("Kangaskhan", "Normal", null, 105, 95, 80, 40, 80, 90, 27, new String[] {"Monster"}, 0, new String[] {"Kangaskhan"}, 0, 0));
		pokedex.add(new Pokemon("Horsea", "Water", null, 30, 40, 70, 70, 25, 60, 2, new String[] {"Water 1", "Dragon"}, 50, new String[] {"Horsea", "Seadra"}, 0, 32));
		pokedex.add(new Pokemon("Seadra", "Water", null, 55, 65, 95, 95, 45, 85, 21, new String[] {"Water 1", "Dragon"}, 50, new String[] {"Horsea", "Seadra"}, 1, 0));
		pokedex.add(new Pokemon("Goldeen", "Water", null, 45, 67, 60, 35, 50, 63, 2, new String[] {"Water 2"}, 50, new String[] {"Goldeen", "Seaking"}, 0, 33));
		pokedex.add(new Pokemon("Seaking", "Water", null, 80, 92, 65, 65, 80, 68, 24, new String[] {"Water 2"}, 50, new String[] {"Goldeen", "Seaking"}, 1, 0));
		pokedex.add(new Pokemon("Staryu", "Water", null, 30, 45, 55, 70, 55, 85, 2, new String[] {"Water 3"}, -1, new String[] {"Staryu", "Starmie"}, 0, -1));
		pokedex.add(new Pokemon("Starmie", "Water", "Psychic", 60, 75, 85, 100, 85, 115, 24, new String[] {"Water 3"}, -1, new String[] {"Staryu", "Starmie"}, 1, 0));
		pokedex.add(new Pokemon("Mr. Mime", "Psychic", "Fairy", 40, 45, 65, 100, 120, 95, 27, new String[] {"Human-Like"}, 50, new String[] {"Mr. Mime"}, 0, 0));
		pokedex.add(new Pokemon("Scyther", "Bug", "Flying", 70, 110, 80, 55, 80, 105, 27, new String[] {"Bug"}, 50, new String[] {"Scyther"}, 0, 0));
		pokedex.add(new Pokemon("Jynx", "Ice", "Psychic", 65, 50, 35, 115, 95, 95, 27, new String[] {"Human-Like"}, 0, new String[] {"Jynx"}, 0, 0));
		pokedex.add(new Pokemon("Electabuzz", "Electric", null, 65, 83, 57, 95, 85, 105, 27, new String[] {"Human-Like"}, 75, new String[] {"Electabuzz"}, 0, 0));
		pokedex.add(new Pokemon("Magmar", "Fire", null, 65, 95, 57, 100, 85, 93, 27, new String[] {"Human-Like"}, 75, new String[] {"Magmar"}, 0, 0));
		pokedex.add(new Pokemon("Pinsir", "Bug", null, 65, 125, 100, 55, 70, 85, 27, new String[] {"Bug"}, 50, new String[] {"Pinsir"}, 0, 0));
		pokedex.add(new Pokemon("Tauros", "Normal", null, 75, 100, 95, 40, 70, 110, 27, new String[] {"Field"}, 100, new String[] {"Tauros"}, 0, 0));
		pokedex.add(new Pokemon("Magikarp", "Water", null, 20, 10, 55, 15, 20, 80, 0, new String[] {"Water 2", "Dragon"}, 50, new String[] {"Magikarp", "Gyarados"}, 0, 20));
		pokedex.add(new Pokemon("Gyarados", "Water", "Flying", 95, 125, 79, 60, 100, 81, 27, new String[] {"Water 2", "Dragon"}, 50, new String[] {"Magikarp", "Gyarados"}, 1, 0));
		pokedex.add(new Pokemon("Lapras", "Water", "Ice", 130, 85, 80, 85, 95, 60, 27, new String[] {"Water 1", "Monster"}, 50, new String[] {"Lapras"}, 0, 0));
		pokedex.add(new Pokemon("Ditto", "Normal", null, 48, 48, 48, 48, 48, 48, 28, new String[] {"Ditto"}, -1, new String[] {"Ditto"}, 0, 0));
		pokedex.add(new Pokemon("Eevee", "Normal", null, 55, 55, 50, 45, 65, 55, 27, new String[] {"Field"}, 87.5, new String[] {"Eevee", "Vaporeon", "Jolteon", "Flareon"}, 0, -1));
		pokedex.add(new Pokemon("Vaporeon", "Water", null, 130, 65, 60, 110, 95, 65, 27, new String[] {"Field"}, 87.5, new String[] {"Eevee", "Vaporeon"}, 1, 0));
		pokedex.add(new Pokemon("Jolteon", "Electric", null, 65, 65, 60, 110, 95, 130, 27, new String[] {"Field"}, 87.5, new String[] {"Eevee", "Jolteon"}, 1, 0));
		pokedex.add(new Pokemon("Flareon", "Fire", null, 65, 130, 60, 95, 110, 65, 27, new String[] {"Field"}, 87.5, new String[] {"Eevee", "Flareon"}, 1, 0));
		pokedex.add(new Pokemon("Porygon", "Normal", null, 65, 60, 70, 85, 75, 40, 27, new String[] {"Mineral"}, -1, new String[] {"Porygon"}, 0, 0));
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
				p.catchPokemon(new OwnedPokemon(pokedex.get(rand)));
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
						while (!repeat) {
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
											repeat = true;
										}
									}
									System.out.println();
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
						repeat = false;
						while (!repeat) {
							System.out.println("Would you like to toggle this Pokemon's \"Favorite\" status?");
							System.out.println("1) Yes");
							System.out.println("2) No");
							System.out.println();
							if (input.hasNext())
								switch (input.nextLine()) {
								case "1":
									System.out.println();
									p.getPC().get(num - 1).toggleFavorite();
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
						repeat = false;
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
			System.out.println("Enter the number corresponding to the first Pokemon you would like to breed, or enter \"0\" to go back to the previos menu.");
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
							System.out.println("Enter the number corresponding to the second Pokemon you would like to breed, or enter \"0\" to go back to the main menu.");
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
									OwnedPokemon oldOne = new OwnedPokemon(p.getPC().get(num - 1));
									OwnedPokemon oldTwo = new OwnedPokemon(p.getPC().get(numTwo - 1));
									boolean breedable = false;
									boolean validEggGroup = false;
									// first check if the egg group is valid.  if at least 1 egg group from pokemon 1 matches an egg group from pokemon 2, then the egg group is valid
									for (int i = 0; i < oldOne.getEggGroup().length; i++)
										for (int j = 0; j < oldTwo.getEggGroup().length; j++)
											if (oldOne.getEggGroup()[i].equals(oldTwo.getEggGroup()[j]))
												validEggGroup = true;
									if (validEggGroup) {
										if ((oldOne.getGender().equals("Male") && oldTwo.getGender().equals("Female"))
												|| (oldOne.getGender().equals("Female") && oldTwo.getGender().equals("Male"))
												|| (oldOne.getGender().equals("Genderless") && oldTwo.getGender().equals("Genderless")))
											// check if the pokemons' genders are correct for breeding (Female and Male, Male and Female, Genderless and Genderless)
											breedable = true;
										if (oldOne.getEggGroup()[0].equals("Undiscovered")
												&& !oldTwo.getName().equals(oldOne.getName()))
											// if the egg group for pokemon 1 is Undiscovered and the two pokemon don't share the same name, they cannot breed
											breedable = false;
									}
									// if either pokemon are a Ditto, they are allowed to breed
									if (oldOne.getEggGroup()[0].equals("Ditto"))
										breedable = true;
									if (p.getPC().get(numTwo - 1).getEggGroup()[0].equals("Ditto"))
										breedable = true;
									if (breedable) {
										//  figure out what the baby pokemon should be
										//  if one parent is a ditto, the baby pokemon is the first stage of the other parent
										//  if the parents are genderless, one of them are chosen randomly and the baby pokemon is the first stage of that parent
										Pokemon pokemon;
										if (oldOne.getEggGroup()[0].equals("Ditto")) {
											pokemon = getBabyPokemon(pokedex, oldTwo);
											p.catchPokemon(createBabyPokemon(p, num, numTwo, oldOne, oldTwo, pokemon));
										} else if (oldTwo.getEggGroup()[0].equals("Ditto")) {
											pokemon = getBabyPokemon(pokedex, oldOne);
											p.catchPokemon(createBabyPokemon(p, num, numTwo, oldOne, oldTwo, pokemon));
										} else if (oldOne.getGender().equals("Genderless")) {
											int choose = new Random().nextInt(2);
											if (choose == 0) {
												pokemon = getBabyPokemon(pokedex, oldOne);
												p.catchPokemon(createBabyPokemon(p, num, numTwo, oldOne, oldTwo, pokemon));
											} else {
												pokemon = getBabyPokemon(pokedex, oldTwo);
												p.catchPokemon(createBabyPokemon(p, num, numTwo, oldOne, oldTwo, pokemon));
											}
										} else if (oldOne.getGender().equals("Female"))
											// special case: if one of the parents is a NidoranF, Nidorina, or Nidoqueen, the baby has a 50-50 chance of being a NidoranF or NidoranM
											if (oldOne.getName().equals("NidoranF") || oldOne.getName().equals("Nidorina") || oldOne.getName().equals("Nidoqueen") || oldTwo.getName().equals("NidoranF") || oldTwo.getName().equals("Nidorina") || oldTwo.getName().equals("Nidoqueen")) {
												int rand = new Random().nextInt(2);
												if (rand == 0) {
													pokemon = pokedex.get(28);
													p.catchPokemon(createBabyPokemon(p, num, numTwo, oldOne, oldTwo, pokemon));
												} else {
													pokemon = pokedex.get(31);
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
										if (num < numTwo) {
											p.getPC().remove(numTwo - 1);
											p.getPC().remove(num - 1);
										} else {
											p.getPC().remove(num - 1);
											p.getPC().remove(numTwo - 1);
										}
										System.out.println();
										System.out.println("Congratulations on your newly bred Pokemon!");
										System.out.println();
										done = true;
										finished = true;
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
		return new OwnedPokemon(pokemon, healthIV, attackIV, defenseIV, specialAttackIV, specialDefenseIV, speedIV);
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
						if (num != 0)
							if (p.getPC().get(num - 1).getLevel() < 100) {
								String typePoints = chooseTypePoints(p, num);
								System.out.println();
								System.out.println("Each level-up has a point-cost equal to the Pokemon's current level.");
								boolean finished = false;
								while (!finished) {
									System.out.println("A level-up for this " + p.getPC().get(num - 1).getName() + " will cost you " + p.getPC().get(num - 1).getLevel() + " " + typePoints);
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
														break;
													case "Tier 2 Points":
														p.spendTier2(p.getPC().get(num - 1).getLevel());
														break;
													case "Tier 3 Points":
														p.spendTier3(p.getPC().get(num - 1).getLevel());
														break;
													case "Tier 4 Points":
														p.spendTier4(p.getPC().get(num - 1).getLevel());
														break;
													case "Tier 5 Points":
														p.spendTier5(p.getPC().get(num - 1).getLevel());
														break;
													}
													p.getPC().get(num - 1).levelUp();
													System.out.println("Your " + p.getPC().get(num - 1).getName() + " is now level " + p.getPC().get(num - 1).getLevel());
													if (p.getPC().get(num - 1).getLevel() > p.getPC().get(num - 1).getPokemon().getEvolutionLevel() && p.getPC().get(num - 1).getPokemon().getEvolutionLevel() != 0 && p.getPC().get(num - 1).getPokemon().getEvolutionLevel() != -1) {
														// if the pokemon's evolution level is reached, add its evolution with everything exactly the same as the original to the PC and remove the old one
														Pokemon poke = p.getPC().get(num - 1).getPokemon();
														for (int i = 0; i < pokedex.size(); i++) {
															if (pokedex.get(i).getName().equals(p.getPC().get(num - 1).getPokemon().getEvolutionTree()[p.getPC().get(num - 1).getPokemon().getEvolutionStage() + 1]))
																poke = pokedex.get(i);
														}
														p.catchPokemon(new OwnedPokemon(p.getPC().get(num - 1), poke));
														String oldName = p.getPC().get(num - 1).getName();
														p.getPC().remove(num - 1);
														System.out.println("Congratulations, your " + oldName + " has evolved into a " + poke.getName() + "!");
													}
													// re-sort pc because levels changed and pokemon position could have changed if it evolved
													p.sortPC();
													System.out.println();
												} else {
													System.out.println();
													System.out.println("This Pokemon is already level 100.  Make a different choice.");
													System.out.println();
													finished = true;
													done = true;
												}
											else {
												System.out.println();
												System.out.println("Leveling up this " + p.getPC().get(num - 1).getName() + " costs " + p.getPC().get(num - 1).getLevel() + " " + typePoints);
												System.out.println("You do not have enough " + typePoints + " to level up this Pokemon");
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
						else
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
								String typePoints = chooseTypePoints(p, num);
								System.out.println();
								boolean finished = false;
								while (!finished) {
									System.out.println("Evolving this Pokemon will cost you 100 " + typePoints);
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
												if (p.getPC().get(num - 1).getPokemon().getName().equals("Eevee")){
													System.out.println();
													boolean repeat = false;
													while (!repeat) {
														System.out.println("What would you like to evolve you Eevee into?");
														System.out.println("1) Vaporeon");
														System.out.println("2) Jolteon");
														System.out.println("3) Flareon");
														System.out.println("Enter \"0\" to go back to the main menu.");
														System.out.println();
														Pokemon poke = p.getPC().get(num - 1).getPokemon();
														if (input.hasNext())
															switch (input.nextLine()) {
															case "1":
																System.out.println();
																p.spendTier4(100);
																poke = new Pokemon("Vaporeon", "Water", null, 130, 65, 60, 110, 95, 65, 27, new String[] {"Field"}, 87.5, new String[] {"Eevee", "Vaporeon"}, 1, 0);
																p.catchPokemon(new OwnedPokemon(p.getPC().get(num - 1), poke));
																p.getPC().remove(num - 1);
																System.out.println("Congratulations, your Eevee has evolved into a Vaporeon!");
																done = true;
																finished = true;
																repeat = true;
																break;
															case "2":
																System.out.println();
																p.spendTier4(100);
																poke = new Pokemon("Jolteon", "Electric", null, 65, 65, 60, 110, 95, 130, 27, new String[] {"Field"}, 87.5, new String[] {"Eevee", "Jolteon"}, 1, 0);
																p.catchPokemon(new OwnedPokemon(p.getPC().get(num - 1), poke));
																p.getPC().remove(num - 1);
																System.out.println("Congratulations, your Eevee has evolved into a Jolteon!");
																done = true;
																finished = true;
																repeat = true;
																break;
															case "3":
																System.out.println();
																p.spendTier4(100);
																poke = new Pokemon("Flareon", "Fire", null, 65, 130, 60, 95, 110, 65, 27, new String[] {"Field"}, 87.5, new String[] {"Eevee", "Flareon"}, 1, 0);
																p.catchPokemon(new OwnedPokemon(p.getPC().get(num - 1), poke));
																p.getPC().remove(num - 1);
																System.out.println("Congratulations, your Eevee has evolved into a Flareon!");
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
													System.out.println();
													switch (typePoints) {
													case "Tier 1 Points":
														p.spendTier1(100);
														break;
													case "Tier 2 Points":
														p.spendTier2(100);
														break;
													case "Tier 3 Points":
														p.spendTier3(100);
														break;
													case "Tier 4 Points":
														p.spendTier4(100);
														break;
													case "Tier 5 Points":
														p.spendTier5(100);
														break;
													}
													Pokemon poke = p.getPC().get(num - 1).getPokemon();
													for (int i = 0; i < pokedex.size(); i++) {
														if (pokedex.get(i).getName().equals(p.getPC().get(num - 1).getPokemon().getEvolutionTree()[p.getPC().get(num - 1).getPokemon().getEvolutionStage() + 1]))
															poke = pokedex.get(i);
													}
													p.catchPokemon(new OwnedPokemon(p.getPC().get(num - 1), poke));
													String oldName = p.getPC().get(num - 1).getName();
													p.getPC().remove(num - 1);
													System.out.println("Congratulations, your " + oldName + " has evolved into a " + p.getPC().get(p.getPC().size() - 1).getName() + "!");
													System.out.println();
													finished = true;
												}
											} else {
												System.out.println();
												System.out.println("Evolving this Pokemon costs 100 " + typePoints);
												System.out.println("You do not have enough " + typePoints + " to evolve this Pokemon");
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
					} else
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
		System.out.println("You can invest a maximum of 252 points into one stat, and a maximum of 508 points into one Pokemon.");
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
							break;
						case "Tier 2 Points":
							p.spendTier2(tempNum);
							break;
						case "Tier 3 Points":
							p.spendTier3(tempNum);
							break;
						case "Tier 4 Points":
							p.spendTier4(tempNum);
							break;
						case "Tier 5 Points":
							p.spendTier5(tempNum);
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
					} else
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
				break;
			case "Tier 2 Points":
				p.spendTier2(100);
				break;
			case "Tier 3 Points":
				p.spendTier3(100);
				break;
			case "Tier 4 Points":
				p.spendTier4(100);
				break;
			case "Tier 5 Points":
				p.spendTier5(100);
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

	private static void save(Player p) throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("saves.ser"));
		oos.writeObject(p);
		oos.flush();
	}

	private static int roundProperlyRecyclePoints(double d) {
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