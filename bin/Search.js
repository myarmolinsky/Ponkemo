import React, { Component } from 'react'

class Search extends Component {
    makePokemon = (name, type1, type2, hp, atk, def, spa, spd, spe, spawnRate, eggGroup, genderRatio, evoTree, evoStage, evoLevel) => {
        var pokemon = {
            name,
            type1,
            type2,
            baseHealth: hp,
            baseAttack: atk,
            baseDefense: def,
            baseSpecialAttack: spa,
            baseSpecialDefense: spd,
            baseSpeed: spe,
            spawnRate,
            eggGroup,
            genderRatio,
            evolutionTree: evoTree,
            evolutionStage: evoStage,
            evolutionLevel: evoLevel
        };
        return pokemon;
    };

    makePokedex = () => {
        var pokedex;
        pokedex = [this.makePokemon("Bulbasaur", "Grass", "Poison", 45, 49, 49, 65, 65, 45, 27, ["Monster", "Grass"], 87.5, ["Bulbasaur", "Ivysaur", "Venusaur"], 0, 16),
        this.makePokemon("Ivysaur", "Grass", "Poison", 60, 62, 63, 80, 80, 60, 27, ["Monster", "Grass"], 87.5, ["Bulbasaur", "Ivysaur", "Venusaur"], 1, 32),
        this.makePokemon("Venusaur", "Grass", "Poison", 80, 82, 83, 100, 100, 80, 27, ["Monster", "Grass"], 87.5, ["Bulbasaur", "Ivysaur", "Venusaur"], 2, 0),
        this.makePokemon("Charmander", "Fire", null, 39, 52, 43, 60, 50, 65, 27, ["Monster", "Dragon"], 87.5, ["Charmander", "Charmeleon", "Charizard"], 0, 16),
        this.makePokemon("Charmeleon", "Fire", null, 58, 64, 58, 80, 65, 80, 27, ["Monster", "Dragon"], 87.5, ["Charmander", "Charmeleon", "Charizard"], 1, 36),
        this.makePokemon("Charizard", "Fire", "Flying", 78, 84, 78, 109, 85, 100, 27, ["Monster", "Dragon"], 87.5, ["Charmander", "Charmeleon", "Charizard"], 2, 0),
        this.makePokemon("Squirtle", "Water", null, 44, 48, 65, 50, 64, 43, 27, ["Monster", "Water 1"], 87.5, ["Squirtle", "Wartortle", "Blastoise"], 0, 16),
        this.makePokemon("Wartortle", "Water", null, 59, 63, 80, 65, 80, 58, 27, ["Monster", "Water 1"], 87.5, ["Squirtle", "Wartortle", "Blastoise"], 1, 36),
        this.makePokemon("Blastoise", "Water", null, 79, 83, 100, 85, 105, 78, 27, ["Monster", "Water 1"], 87.5, ["Squirtle", "Wartortle", "Blastoise"], 2, 0),
        this.makePokemon("Caterpie", "Bug", null, 45, 30, 35, 20, 20, 45, 0, ["Bug"], 50, ["Caterpie", "Metapod", "Butterfree"], 0, 7),
        this.makePokemon("Metapod", "Bug", null, 50, 20, 55, 25, 25, 30, 17, ["Bug"], 50, ["Caterpie", "Metapod", "Butterfree"], 1, 10),
        this.makePokemon("Butterfree", "Bug", "Flying", 60, 45, 50, 90, 80, 70, 27, ["Bug"], 50, ["Caterpie", "Metapod", "Butterfree"], 2, 0),
        this.makePokemon("Weedle", "Bug", "Poison", 40, 35, 30, 20, 20, 50, 0, ["Bug"], 50, ["Weedle", "Kakuna", "Beedrill"], 0, 7),
        this.makePokemon("Kakuna", "Bug", "Poison", 45, 25, 50, 25, 25, 35, 17, ["Bug"], 50, ["Weedle", "Kakuna", "Beedrill"], 1, 10),
        this.makePokemon("Beedrill", "Bug", "Poison", 65, 90, 40, 45, 80, 75, 27, ["Bug"], 50, ["Weedle", "Kakuna", "Beedrill"], 2, 0),
        this.makePokemon("Pidgey", "Normal", "Flying", 40, 45, 40, 35, 35, 56, 0, ["Flying"], 50, ["Pidgey", "Pidgeotto", "Pidgeot"], 0, 18),
        this.makePokemon("Pidgeotto", "Normal", "Flying", 63, 60, 55, 50, 50, 71, 17, ["Flying"], 50, ["Pidgey", "Pidgeotto", "Pidgeot"], 1, 36),
        this.makePokemon("Pidgeot", "Normal", "Flying", 83, 80, 75, 70, 70, 101, 27, ["Flying"], 50, ["Pidgey", "Pidgeotto", "Pidgeot"], 2, 0),
        this.makePokemon("Rattata", "Normal", null, 30, 56, 35, 25, 35, 72, 0, ["Field"], 50, ["Rattata", "Raticate"], 0, 20),
        this.makePokemon("Raticate", "Normal", null, 55, 81, 60, 50, 70, 97, 15, ["Field"], 50, ["Rattata", "Raticate"], 1, 0),
        this.makePokemon("Spearow", "Normal", "Flying", 40, 60, 30, 31, 31, 70, 0, ["Flying"], 50, ["Spearow", "Fearow"], 0, 20),
        this.makePokemon("Fearow", "Normal", "Flying", 65, 90, 65, 61, 61, 100, 19, ["Flying"], 50, ["Spearow", "Fearow"], 1, 0),
        this.makePokemon("Ekans", "Poison", null, 35, 60, 44, 40, 54, 55, 0, ["Field", "Dragon"], 50, ["Ekans", "Arbok"], 0, 22),
        this.makePokemon("Arbok", "Poison", null, 60, 95, 69, 65, 79, 80, 19, ["Field", "Dragon"], 50, ["Ekans", "Arbok"], 1, 0),
        this.makePokemon("Pikachu", "Electric", null, 35, 55, 40, 50, 50, 90, 6, ["Field", "Fairy"], 50, ["Pichu", "Pikachu", "Raichu"], 1, -1),
        this.makePokemon("Raichu", "Electric", null, 60, 90, 55, 90, 80, 110, 21, ["Field", "Fairy"], 50, ["Pichu", "Pikachu", "Raichu"], 2, 0),
        this.makePokemon("Sandshrew", "Ground", null, 50, 75, 85, 20, 30, 40, 0, ["Field"], 50, ["Sandshrew", "Sandslash"], 0, 22),
        this.makePokemon("Sandslash", "Ground", null, 75, 100, 110, 45, 55, 65, 19, ["Field"], 50, ["Sandshrew", "Sandslash"], 1, 0),
        this.makePokemon("NidoranF", "Poison", null, 55, 47, 52, 40, 40, 41, 1, ["Monster", "Field"], 0, ["NidoranF", "Nidorina", "Nidoqueen"], 0, 16),
        this.makePokemon("Nidorina", "Poison", null, 70, 62, 67, 55, 55, 56, 17, ["Monster", "Water 1"], 0, ["NidoranF", "Nidorina", "Nidoqueen"], 1, -1),
        this.makePokemon("Nidoqueen", "Poison", "Ground", 90, 82, 87, 75, 85, 76, 27, ["Monster", "Water 1"], 0, ["NidoranF", "Nidorina", "Nidoqueen"], 2, 0),
        this.makePokemon("NidoranM", "Poison", null, 46, 57, 40, 40, 40, 50, 1, ["Monster", "Water 1"], 100, ["NidoranM", "Nidorino", "Nidoking"], 0, 16),
        this.makePokemon("Nidorino", "Poison", null, 61, 72, 57, 55, 55, 65, 17, ["Monster", "Water 1"], 100, ["NidoranM", "Nidorino", "Nidoking"], 1, -1),
        this.makePokemon("Nidoking", "Poison", "Ground", 81, 102, 77, 85, 75, 85, 27, ["Monster", "Water 1"], 100, ["NidoranM", "Nidorino", "Nidoking"], 2, 0),
        this.makePokemon("Clefairy", "Fairy", null, 70, 45, 48, 60, 65, 35, 11, ["Fairy"], 25, ["Cleffa", "Clefairy", "Clefable"], 1, -1),
        this.makePokemon("Clefable", "Fairy", null, 95, 70, 73, 95, 90, 60, 30, ["Fairy"], 25, ["Cleffa", "Clefairy", "Clefable"], 2, 0),
        this.makePokemon("Vulpix", "Fire", null, 39, 41, 40, 50, 65, 65, 6, ["Field"], 25, ["Vulpix", "Ninetales"], 0, -1),
        this.makePokemon("Ninetales", "Fire", null, 73, 76, 75, 81, 100, 100, 21, ["Field"], 25, ["Vulpix", "Ninetales"], 1, 0),
        this.makePokemon("Jigglypuff", "Normal", "Fairy", 115, 45, 20, 45, 25, 20, 8, ["Fairy"], 25, ["Igglybuff", "Jigglypuff", "Wigglytuff"], 1, -1),
        this.makePokemon("Wigglytuff", "Normal", "Fairy", 140, 70, 45, 85, 50, 45, 26, ["Fairy"], 25, ["Igglybuff", "Jigglypuff", "Wigglytuff"], 2, 0),
        this.makePokemon("Zubat", "Poison", "Flying", 40, 45, 35, 30, 40, 55, 0, ["Flying"], 50, ["Zubat", "Golbat", "Crobat"], 0, 22),
        this.makePokemon("Golbat", "Poison", "Flying", 75, 80, 70, 65, 75, 90, 19, ["Flying"], 50, ["Zubat", "Golbat", "Crobat"], 1, -1),
        this.makePokemon("Oddish", "Grass", "Poison", 45, 50, 55, 75, 65, 30, 0, ["Grass"], 50, ["Oddish", "Gloom", "Vileplume", "Bellossom"], 0, 21),
        this.makePokemon("Gloom", "Grass", "Poison", 60, 65, 70, 85, 75, 40, 17, ["Grass"], 50, ["Oddish", "Gloom", "Vileplume", "Bellossom"], 1, -1),
        this.makePokemon("Vileplume", "Grass", "Poison", 75, 80, 85, 110, 90, 50, 27, ["Grass"], 50, ["Oddish", "Gloom", "Vileplume", "Bellossom"], 2, 0),
        this.makePokemon("Paras", "Bug", "Grass", 35, 70, 55, 45, 55, 25, 6, ["Bug", "Grass"], 50, ["Paras", "Parasect"], 0, 24),
        this.makePokemon("Parasect", "Bug", "Grass", 60, 95, 80, 60, 80, 30, 21, ["Bug", "Grass"], 50, ["Paras", "Parasect"], 1, 0),
        this.makePokemon("Venonat", "Bug", "Poison", 60, 55, 50, 40, 55, 45, 6, ["Bug"], 50, ["Venonat", "Venomoth"], 0, 31),
        this.makePokemon("Venomoth", "Bug", "Poison", 70, 65, 60, 90, 75, 90, 21, ["Bug"], 50, ["Venonat", "Venomoth"], 1, 0),
        this.makePokemon("Diglett", "Ground", null, 10, 55, 25, 35, 45, 95, 0, ["Field"], 50, ["Diglett", "Dugtrio"], 0, 26),
        this.makePokemon("Dugtrio", "Ground", null, 35, 100, 50, 50, 70, 120, 26, ["Field"], 50, ["Diglett", "Dugtrio"], 1, 0),
        this.makePokemon("Meowth", "Normal", null, 40, 45, 35, 40, 40, 90, 0, ["Field"], 50, ["Meowth", "Persian"], 0, 28),
        this.makePokemon("Persian", "Normal", null, 65, 70, 60, 65, 65, 115, 19, ["Field"], 50, ["Meowth", "Persian"], 1, 0),
        this.makePokemon("Psyduck", "Water", null, 50, 52, 48, 65, 50, 55, 6, ["Field", "Water 1"], 50, ["Psyduck", "Golduck"], 0, 33),
        this.makePokemon("Golduck", "Water", null, 80, 82, 78, 95, 80, 85, 21, ["Field", "Water 1"], 50, ["Psyduck", "Golduck"], 1, 0),
        this.makePokemon("Mankey", "Fighting", null, 40, 80, 35, 35, 45, 70, 6, ["Field"], 50, ["Mankey", "Primeape"], 0, 28),
        this.makePokemon("Primeape", "Fighting", null, 65, 100, 60, 60, 70, 95, 21, ["Field"], 50, ["Mankey", "Primeape"], 1, 0),
        this.makePokemon("Growlithe", "Fire", null, 55, 70, 45, 70, 50, 60, 6, ["Field"], 75, ["Growlithe", "Arcanine"], 0, -1),
        this.makePokemon("Arcanine", "Fire", null, 90, 110, 80, 100, 80, 95, 21, ["Field"], 75, ["Growlithe", "Arcanine"], 1, 0),
        this.makePokemon("Poliwag", "Water", null, 40, 50, 40, 40, 40, 90, 0, ["Water 1"], 50, ["Poliwag", "Poliwhirl", "Poliwrath", "Politoed"], 0, 25),
        this.makePokemon("Poliwhirl", "Water", null, 65, 65, 65, 50, 50, 90, 17, ["Water 1"], 50, ["Poliwag", "Poliwhirl", "Poliwrath", "Politoed"], 1, -1),
        this.makePokemon("Poliwrath", "Water", "Fighting", 90, 95, 95, 70, 90, 70, 27, ["Water 1"], 50, ["Poliwag", "Poliwhirl", "Poliwrath", "Politoed"], 2, 0),
        this.makePokemon("Abra", "Psychic", null, 25, 20, 15, 105, 55, 90, 5, ["Human-Like"], 75, ["Abra", "Kadabra", "Alakazam"], 0, 16),
        this.makePokemon("Kadabra", "Psychic", null, 40, 35, 30, 120, 70, 105, 18, ["Human-Like"], 75, ["Abra", "Kadabra", "Alakazam"], 1, -1),
        this.makePokemon("Alakazam", "Psychic", null, 55, 50, 45, 135, 95, 120, 26, ["Human-Like"], 75, ["Abra", "Kadabra", "Alakazam"], 2, 0),
        this.makePokemon("Machop", "Fighting", null, 70, 80, 50, 35, 35, 35, 7, ["Human-Like"], 75, ["Machop", "Machoke", "Machamp"], 0, 28),
        this.makePokemon("Machoke", "Fighting", null, 80, 100, 70, 50, 60, 45, 19, ["Human-Like"], 75, ["Machop", "Machoke", "Machamp"], 1, -1),
        this.makePokemon("Machamp", "Fighting", null, 90, 130, 80, 65, 85, 55, 27, ["Human-Like"], 75, ["Machop", "Machoke", "Machamp"], 2, 0),
        this.makePokemon("Bellsprout", "Grass", "Poison", 50, 75, 35, 70, 30, 40, 0, ["Grass"], 50, ["Bellsprout", "Weepinbell", "Victreebel"], 0, 21),
        this.makePokemon("Weepinbell", "Grass", "Poison", 65, 90, 50, 85, 45, 55, 17, ["Grass"], 50, ["Bellsprout", "Weepinbell", "Victreebel"], 1, -1),
        this.makePokemon("Victreebel", "Grass", "Poison", 80, 105, 65, 100, 70, 70, 27, ["Grass"], 50, ["Bellsprout", "Weepinbell", "Victreebel"], 2, 0),
        this.makePokemon("Tentacool", "Water", "Poison", 40, 40, 35, 50, 100, 70, 6, ["Water 3"], 50, ["Tentacool", "Tentacruel"], 0, 30),
        this.makePokemon("Tentacruel", "Water", "Poison", 80, 70, 65, 80, 120, 100, 24, ["Water 3"], 50, ["Tentacool", "Tentacruel"], 1, 0),
        this.makePokemon("Geodude", "Rock", "Ground", 40, 80, 100, 30, 30, 20, 0, ["Mineral"], 50, ["Geodude", "Graveler", "Golem"], 0, 25),
        this.makePokemon("Graveler", "Rock", "Ground", 55, 95, 115, 45, 45, 35, 17, ["Mineral"], 50, ["Geodude", "Graveler", "Golem"], 1, -1),
        this.makePokemon("Golem", "Rock", "Ground", 80, 120, 130, 55, 65, 45, 27, ["Mineral"], 50, ["Geodude", "Graveler", "Golem"], 2, 0),
        this.makePokemon("Ponyta", "Fire", null, 50, 85, 55, 65, 65, 90, 6, ["Field"], 50, ["Ponyta", "Rapidash"], 0, 40),
        this.makePokemon("Rapidash", "Fire", null, 65, 100, 70, 80, 80, 105, 24, ["Field"], 50, ["Ponyta", "Rapidash"], 1, 0),
        this.makePokemon("Slowpoke", "Water", "Psychic", 90, 65, 65, 40, 40, 15, 6, ["Monster", "Water 1"], 50, ["Slowpoke", "Slowbro", "Slowking"], 0, 37),
        this.makePokemon("Slowbro", "Water", "Psychic", 95, 75, 110, 100, 80, 30, 21, ["Monster", "Water 1"], 50, ["Slowpoke", "Slowbro"], 1, 0),
        this.makePokemon("Magnemite", "Electric", "Steel", 25, 35, 70, 95, 55, 45, 6, ["Mineral"], -1, ["Magnemite", "Magneton", "Magnezone"], 0, 30),
        this.makePokemon("Magneton", "Electric", "Steel", 50, 60, 95, 120, 70, 70, 24, ["Mineral"], -1, ["Magnemite", "Magneton", "Magnezone"], 1, -1),
        this.makePokemon("Farfetch'd", "Normal", "Flying", 52, 90, 55, 58, 62, 60, 27, ["Field", "Flying"], 50, ["Farfetch'd"], 0, 0),
        this.makePokemon("Doduo", "Normal", "Flying", 35, 85, 45, 35, 35, 75, 6, ["Flying"], 50, ["Doduo", "Dodrio"], 0, 31),
        this.makePokemon("Dodrio", "Normal", "Flying", 60, 110, 70, 60, 60, 110, 27, ["Flying"], 50, ["Doduo", "Dodrio"], 1, 0),
        this.makePokemon("Seel", "Water", null, 65, 45, 55, 45, 70, 45, 6, ["Field", "Water 1"], 50, ["Seel", "Dewgong"], 0, 34),
        this.makePokemon("Dewgong", "Water", "Ice", 90, 70, 80, 70, 95, 70, 21, ["Field", "Water 1"], 50, ["Seel", "Dewgong"], 1, 0),
        this.makePokemon("Grimer", "Poison", null, 80, 80, 50, 40, 50, 25, 6, ["Amorphous"], 50, ["Grimer", "Muk"], 0, 38),
        this.makePokemon("Muk", "Poison", null, 105, 106, 75, 65, 100, 50, 21, ["Amorphous"], 50, ["Grimer", "Muk"], 1, 0),
        this.makePokemon("Shellder", "Water", null, 30, 65, 100, 45, 25, 40, 6, ["Water 3"], 50, ["Shellder", "Cloyster"], 0, -1),
        this.makePokemon("Cloyster", "Water", "Ice", 50, 95, 180, 85, 45, 70, 24, ["Water 3"], 50, ["Shellder", "Cloyster"], 0, 0),
        this.makePokemon("Gastly", "Ghost", "Poison", 30, 35, 30, 100, 35, 80, 6, ["Amorphous"], 50, ["Gastly", "Haunter", "Gengar"], 0, 25),
        this.makePokemon("Haunter", "Ghost", "Poison", 45, 50, 45, 115, 55, 95, 19, ["Amorphous"], 50, ["Gastly", "Haunter", "Gengar"], 1, -1),
        this.makePokemon("Gengar", "Ghost", "Poison", 60, 65, 60, 130, 75, 110, 27, ["Amorphous"], 50, ["Gastly", "Haunter", "Gengar"], 2, 0),
        this.makePokemon("Onix", "Rock", "Ground", 35, 45, 160, 30, 45, 70, 27, ["Mineral"], 50, ["Onix", "Steelix"], 0, -1),
        this.makePokemon("Drowzee", "Psychic", null, 60, 48, 45, 43, 90, 42, 6, ["Human-Like"], 50, ["Drowzee", "Hypno"], 0, 26),
        this.makePokemon("Hypno", "Psychic", null, 85, 73, 70, 73, 115, 67, 21, ["Human-Like"], 50, ["Drowzee", "Hypno"], 1, 0),
        this.makePokemon("Krabby", "Water", null, 30, 105, 90, 25, 25, 50, 2, ["Water 3"], 50, ["Krabby", "Kingler"], 0, 28),
        this.makePokemon("Kingler", "Water", null, 55, 130, 115, 50, 50, 75, 24, ["Water 3"], 50, ["Krabby", "Kingler"], 1, 0),
        this.makePokemon("Voltorb", "Electric", null, 40, 30, 50, 55, 55, 100, 6, ["Mineral"], -1, ["Voltorb", "Electrode"], 0, 30),
        this.makePokemon("Electrode", "Electric", null, 60, 50, 70, 80, 80, 150, 24, ["Mineral"], -1, ["Voltorb", "Electrode"], 1, 0),
        this.makePokemon("Exeggcute", "Grass", "Psychic", 60, 40, 80, 60, 45, 40, 19, ["Grass"], 50, ["Exeggcute", "Exeggutor"], 0, -1),
        this.makePokemon("Exeggutor", "Grass", "Psychic", 95, 95, 85, 125, 75, 55, 27, ["Grass"], 50, ["Exeggcute", "Exeggutor"], 1, 0),
        this.makePokemon("Cubone", "Ground", null, 50, 50, 95, 40, 50, 35, 6, ["Monster"], 50, ["Cubone", "Marowak"], 0, 28),
        this.makePokemon("Marowak", "Ground", null, 60, 80, 110, 50, 80, 45, 21, ["Monster"], 50, ["Cubone", "Marowak"], 1, 0),
        this.makePokemon("Hitmonlee", "Fighting", null, 50, 120, 53, 35, 110, 87, 27, ["Human-Like"], 100, ["Tyrogue", "Hitmonlee"], 1, 0),
        this.makePokemon("Hitmonchan", "Fighting", null, 50, 105, 79, 35, 110, 76, 27, ["Human-Like"], 100, ["Tyrogue", "Hitmonchan"], 1, 0),
        this.makePokemon("Lickitung", "Normal", null, 90, 55, 75, 60, 75, 30, 27, ["Monster"], 50, ["Lickitung", "Lickilicky"], 0, 0),
        this.makePokemon("Koffing", "Poison", null, 40, 65, 95, 60, 45, 35, 6, ["Amorphous"], 50, ["Koffing", "Weezing"], 0, 35),
        this.makePokemon("Weezing", "Poison", null, 65, 90, 120, 85, 70, 60, 24, ["Amorphous"], 50, ["Koffing", "Weezing"], 1, 0),
        this.makePokemon("Rhyhorn", "Ground", "Rock", 80, 85, 95, 30, 30, 25, 17, ["Field", "Monster"], 50, ["Rhyhorn", "Rhydon", "Rhyperior"], 0, 42),
        this.makePokemon("Rhydon", "Ground", "Rock", 105, 130, 120, 45, 45, 40, 24, ["Field", "Monster"], 50, ["Rhyhorn", "Rhydon", "Rhyperior"], 1, -1),
        this.makePokemon("Chansey", "Normal", null, 250, 5, 5, 35, 105, 50, 29, ["Fairy"], 0, ["Happiny", "Chansey", "Blissey"], 1, -1),
        this.makePokemon("Tangela", "Grass", null, 65, 55, 115, 100, 40, 60, 27, ["Grass"], 50, ["Tangela", "Tangrowth"], 0, -1),
        this.makePokemon("Kangaskhan", "Normal", null, 105, 95, 80, 40, 80, 90, 27, ["Monster"], 0, ["Kangaskhan"], 0, 0),
        this.makePokemon("Horsea", "Water", null, 30, 40, 70, 70, 25, 60, 2, ["Water 1", "Dragon"], 50, ["Horsea", "Seadra", "Kingdra"], 0, 32),
        this.makePokemon("Seadra", "Water", null, 55, 65, 95, 95, 45, 85, 21, ["Water 1", "Dragon"], 50, ["Horsea", "Seadra", "Kingdra"], 1, -1),
        this.makePokemon("Goldeen", "Water", null, 45, 67, 60, 35, 50, 63, 2, ["Water 2"], 50, ["Goldeen", "Seaking"], 0, 33),
        this.makePokemon("Seaking", "Water", null, 80, 92, 65, 65, 80, 68, 24, ["Water 2"], 50, ["Goldeen", "Seaking"], 1, 0),
        this.makePokemon("Staryu", "Water", null, 30, 45, 55, 70, 55, 85, 2, ["Water 3"], -1, ["Staryu", "Starmie"], 0, -1),
        this.makePokemon("Starmie", "Water", "Psychic", 60, 75, 85, 100, 85, 115, 24, ["Water 3"], -1, ["Staryu", "Starmie"], 1, 0),
        this.makePokemon("Mr. Mime", "Psychic", "Fairy", 40, 45, 65, 100, 120, 95, 27, ["Human-Like"], 50, ["Mime Jr.", "Mr. Mime"], 1, 0),
        this.makePokemon("Scyther", "Bug", "Flying", 70, 110, 80, 55, 80, 105, 27, ["Bug"], 50, ["Scyther", "Scizor"], 0, -1),
        this.makePokemon("Jynx", "Ice", "Psychic", 65, 50, 35, 115, 95, 95, 27, ["Human-Like"], 0, ["Smoochum", "Jynx"], 1, 0),
        this.makePokemon("Electabuzz", "Electric", null, 65, 83, 57, 95, 85, 105, 27, ["Human-Like"], 75, ["Elekid", "Electabuzz", "Electivire"], 1, -1),
        this.makePokemon("Magmar", "Fire", null, 65, 95, 57, 100, 85, 93, 27, ["Human-Like"], 75, ["Magby", "Magmar", "Magmortar"], 1, -1),
        this.makePokemon("Pinsir", "Bug", null, 65, 125, 100, 55, 70, 85, 27, ["Bug"], 50, ["Pinsir"], 0, 0),
        this.makePokemon("Tauros", "Normal", null, 75, 100, 95, 40, 70, 110, 27, ["Field"], 100, ["Tauros"], 0, 0),
        this.makePokemon("Magikarp", "Water", null, 20, 10, 55, 15, 20, 80, 0, ["Water 2", "Dragon"], 50, ["Magikarp", "Gyarados"], 0, 20),
        this.makePokemon("Gyarados", "Water", "Flying", 95, 125, 79, 60, 100, 81, 27, ["Water 2", "Dragon"], 50, ["Magikarp", "Gyarados"], 1, 0),
        this.makePokemon("Lapras", "Water", "Ice", 130, 85, 80, 85, 95, 60, 27, ["Water 1", "Monster"], 50, ["Lapras"], 0, 0),
        this.makePokemon("Ditto", "Normal", null, 48, 48, 48, 48, 48, 48, 28, ["Ditto"], -1, ["Ditto"], 0, 0),
        this.makePokemon("Eevee", "Normal", null, 55, 55, 50, 45, 65, 55, 27, ["Field"], 87.5, ["Eevee", "Vaporeon", "Jolteon", "Flareon", "Espeon", "Umbreon", "Leafeon", "Glaceon", "Sylveon"], 0, -1),
        this.makePokemon("Vaporeon", "Water", null, 130, 65, 60, 110, 95, 65, 27, ["Field"], 87.5, ["Eevee", "Vaporeon"], 1, 0),
        this.makePokemon("Jolteon", "Electric", null, 65, 65, 60, 110, 95, 130, 27, ["Field"], 87.5, ["Eevee", "Jolteon"], 1, 0),
        this.makePokemon("Flareon", "Fire", null, 65, 130, 60, 95, 110, 65, 27, ["Field"], 87.5, ["Eevee", "Flareon"], 1, 0),
        this.makePokemon("Porygon", "Normal", null, 65, 60, 70, 85, 75, 40, 27, ["Mineral"], -1, ["Porygon", "Porygon2", "Porygon-Z"], 0, -1),
        this.makePokemon("Omanyte", "Rock", "Water", 35, 40, 100, 90, 55, 35, 27, ["Water 1", "Water 3"], 87.5, ["Omanyte", "Omastar"], 0, 40),
        this.makePokemon("Omastar", "Rock", "Water", 70, 60, 125, 115, 70, 55, 27, ["Water 1", "Water 3"], 87.5, ["Omanyte", "Omastar"], 1, 0),
        this.makePokemon("Kabuto", "Rock", "Water", 30, 80, 90, 55, 45, 55, 27, ["Water 1", "Water 3"], 87.5, ["Kabuto", "Kabutops"], 0, 40),
        this.makePokemon("Kabutops", "Rock", "Water", 60, 115, 105, 65, 70, 80, 27, ["Water 1", "Water 3"], 87.5, ["Kabuto", "Kabutops"], 1, 0),
        this.makePokemon("Aerodactyl", "Rock", "Flying", 80, 105, 65, 60, 75, 130, 27, ["Flying"], 87.5, ["Aerodactyl"], 0, 0),
        this.makePokemon("Snorlax", "Normal", null, 160, 110, 65, 65, 110, 30, 30, ["Monster"], 87.5, ["Munchlax", "Snorlax"], 1, 0),
        this.makePokemon("Articuno", "Ice", "Flying", 90, 85, 100, 95, 125, 85, 32, ["Undiscovered"], -1, ["Articuno"], 0, 0),
        this.makePokemon("Zapdos", "Electric", "Flying", 90, 90, 85, 125, 90, 100, 32, ["Undiscovered"], -1, ["Zapdos"], 0, 0),
        this.makePokemon("Moltres", "Fire", "Flying", 90, 100, 90, 125, 85, 90, 32, ["Undiscovered"], -1, ["Moltres"], 0, 0),
        this.makePokemon("Dratini", "Dragon", null, 41, 64, 45, 50, 50, 50, 27, ["Water 1", "Dragon"], 50, ["Dratini", "Dragonair", "Dragonite"], 0, 30),
        this.makePokemon("Dragonair", "Dragon", null, 61, 84, 65, 70, 70, 70, 27, ["Water 1", "Dragon"], 50, ["Dratini", "Dragonair", "Dragonite"], 1, 55),
        this.makePokemon("Dragonite", "Dragon", "Flying", 91, 134, 95, 100, 100, 80, 27, ["Water 1", "Dragon"], 50, ["Dratini", "Dragonair", "Dragonite"], 2, 0),
        this.makePokemon("Mewtwo", "Psychic", null, 106, 110, 90, 154, 90, 130, 32, ["Undiscovered"], -1, ["Mewtwo"], 0, 0),
        this.makePokemon("Mew", "Psychic", null, 100, 100, 100, 100, 100, 100, 27, ["Undiscovered"], -1, ["Mew"], 0, 0),
        this.makePokemon("Chikorita", "Grass", null, 45, 49, 65, 49, 65, 45, 27, ["Monster", "Grass"], 87.5, ["Chikorita", "Bayleef", "Meganium"], 0, 16),
        this.makePokemon("Bayleef", "Grass", null, 60, 62, 80, 63, 80, 60, 27, ["Monster", "Grass"], 87.5, ["Chikorita", "Bayleef", "Meganium"], 1, 32),
        this.makePokemon("Meganium", "Grass", null, 80, 82, 100, 83, 100, 80, 27, ["Monster", "Grass"], 87.5, ["Chikorita", "Bayleef", "Meganium"], 2, 0),
        this.makePokemon("Cyndaquil", "Fire", null, 39, 52, 43, 60, 50, 65, 27, ["Field"], 87.5, ["Cynaquil", "Quilava", "Typhlosion"], 0, 14),
        this.makePokemon("Quilava", "Fire", null, 58, 64, 58, 80, 65, 80, 27, ["Field"], 87.5, ["Cynaquil", "Quilava", "Typhlosion"], 1, 36),
        this.makePokemon("Typhlosion", "Fire", null, 78, 84, 78, 109, 85, 100, 27, ["Field"], 87.5, ["Cynaquil", "Quilava", "Typhlosion"], 2, 0),
        this.makePokemon("Totodile", "Water", null, 50, 65, 64, 44, 48, 43, 27, ["Monster", "Water 1"], 87.5, ["Totodile", "Croconaw", "Feraligatr"], 0, 18),
        this.makePokemon("Croconaw", "Water", null, 65, 80, 80, 59, 63, 58, 27, ["Monster", "Water 1"], 87.5, ["Totodile", "Croconaw", "Feraligatr"], 1, 30),
        this.makePokemon("Feraligatr", "Water", null, 85, 105, 100, 79, 83, 78, 27, ["Monster", "Water 1"], 87.5, ["Totodile", "Croconaw", "Feraligatr"], 2, 0),
        this.makePokemon("Sentret", "Normal", null, 35, 46, 34, 35, 45, 20, 0, ["Field"], 50, ["Sentret", "Furret"], 0, 15),
        this.makePokemon("Furret", "Normal", null, 85, 76, 64, 45, 55, 90, 19, ["Field"], 50, ["Sentret", "Furret"], 1, 0),
        this.makePokemon("Hoothoot", "Normal", "Flying", 60, 30, 30, 36, 56, 50, 0, ["Flying"], 50, ["Hoothoot", "Noctowl"], 0, 20),
        this.makePokemon("Noctowl", "Normal", "Flying", 100, 50, 50, 86, 96, 70, 19, ["Flying"], 50, ["Hoothoot", "Noctowl"], 1, 0),
        this.makePokemon("Ledyba", "Bug", "Flying", 40, 20, 30, 40, 80, 55, 0, ["Bug"], 50, ["Ledyba", "Ledian"], 0, 18),
        this.makePokemon("Ledian", "Bug", "Flying", 55, 35, 50, 55, 110, 85, 19, ["Bug"], 50, ["Ledyba", "Ledian"], 1, 0),
        this.makePokemon("Spinarak", "Bug", "Poison", 40, 60, 40, 40, 40, 30, 0, ["Bug"], 50, ["Spinarak", "Ariados"], 0, 22),
        this.makePokemon("Ariados", "Bug", "Poison", 70, 90, 70, 60, 70, 40, 19, ["Bug"], 50, ["Spinarak", "Ariados"], 1, 0),
        this.makePokemon("Crobat", "Poison", "Flying", 85, 90, 80, 70, 80, 130, 19, ["Flying"], 50, ["Zubat", "Golbat", "Crobat"], 2, 0),
        this.makePokemon("Chinchou", "Water", "Electric", 75, 38, 38, 56, 56, 67, 6, ["Water 2"], 50, ["Chinchou", "Lanturn"], 0, 27),
        this.makePokemon("Lanturn", "Water", "Electric", 125, 58, 58, 76, 76, 67, 21, ["Water 2"], 50, ["Chinchou", "Lanturn"], 1, 0),
        this.makePokemon("Pichu", "Electric", null, 20, 40, 15, 35, 35, 60, 6, ["Field", "Fairy"], 50, ["Pichu", "Pikachu", "Raichu"], 0, -1),
        this.makePokemon("Cleffa", "Fairy", null, 50, 25, 28, 45, 55, 15, 11, ["Fairy"], 25, ["Cleffa", "Clefairy", "Clefable"], 0, -1),
        this.makePokemon("Igglybuff", "Normal", "Fairy", 90, 30, 15, 40, 20, 15, 8, ["Fairy"], 25, ["Igglybuff", "Jigglypuff", "Wigglytuff"], 0, -1),
        this.makePokemon("Togepi", "Fairy", null, 35, 20, 65, 40, 65, 20, 6, ["Flying", "Fairy"], 87.5, ["Togepi", "Togetic", "Togekiss"], 0, -1),
        this.makePokemon("Togetic", "Fairy", "Flying", 55, 40, 85, 80, 105, 40, 21, ["Flying", "Fairy"], 87.5, ["Togepi", "Togetic", "Togekiss"], 1, -1),
        this.makePokemon("Natu", "Psychic", "Flying", 40, 50, 45, 70, 45, 70, 6, ["Flying"], 50, ["Natu", "Xatu"], 0, 25),
        this.makePokemon("Xatu", "Psychic", "Flying", 65, 75, 70, 95, 70, 95, 21, ["Flying"], 50, ["Natu", "Xatu"], 1, 0),
        this.makePokemon("Mareep", "Electric", null, 55, 40, 40, 65, 45, 35, 1, ["Monster", "Field"], 50, ["Mareep", "Flaaffy", "Ampharos"], 0, 15),
        this.makePokemon("Flaaffy", "Electric", null, 70, 55, 55, 80, 60, 45, 17, ["Monster", "Field"], 50, ["Mareep", "Flaaffy", "Ampharos"], 1, 30),
        this.makePokemon("Ampharos", "Electric", null, 90, 75, 85, 115, 90, 55, 27, ["Monster", "Field"], 50, ["Mareep", "Flaaffy", "Ampharos"], 2, 0),
        this.makePokemon("Bellossom", "Grass", null, 75, 80, 95, 90, 100, 50, 27, ["Grass"], 50, ["Oddish", "Gloom", "Vileplume", "Bellossom"], 2, 0),
        this.makePokemon("Marill", "Water", "Fairy", 70, 20, 50, 20, 50, 40, 6, ["Water 1", "Fairy"], 50, ["Azurill", "Marill", "Azumarill"], 1, 18),
        this.makePokemon("Azumarill", "Water", "Fairy", 100, 50, 80, 60, 80, 50, 21, ["Water 1", "Fairy"], 50, ["Azurill", "Marill", "Azumarill"], 2, 0),
        this.makePokemon("Sudowoodo", "Rock", null, 70, 100, 115, 30, 65, 30, 23, ["Mineral"], 50, ["Bonsly", "Sudowoodo"], 1, 0),
        this.makePokemon("Politoed", "Water", null, 90, 75, 75, 90, 100, 70, 27, ["Water 1"], 50, ["Poliwag", "Poliwhirl", "Poliwrath", "Politoed"], 2, 0),
        this.makePokemon("Hoppip", "Grass", "Flying", 35, 35, 40, 35, 55, 50, 0, ["Fairy", "Grass"], 50, ["Hoppip", "Skiploom", "Jumpluff"], 0, 18),
        this.makePokemon("Skiploom", "Grass", "Flying", 55, 45, 50, 45, 65, 80, 17, ["Fairy", "Grass"], 50, ["Hoppip", "Skiploom", "Jumpluff"], 1, 27),
        this.makePokemon("Jumpluff", "Grass", "Flying", 75, 55, 70, 55, 95, 110, 27, ["Fairy", "Grass"], 50, ["Hoppip", "Skiploom", "Jumpluff"], 2, 0),
        this.makePokemon("Aipom", "Normal", null, 55, 70, 55, 40, 55, 85, 27, ["Field"], 50, ["Aipom", "Ambipom"], 0, -1),
        this.makePokemon("Sunkern", "Grass", null, 30, 30, 30, 30, 30, 30, 1, ["Grass"], 50, ["Sunkern", "Sunflora"], 0, -1),
        this.makePokemon("Sunflora", "Grass", null, 75, 75, 55, 105, 85, 30, 17, ["Grass"], 50, ["Sunkern", "Sunflora"], 1, 0),
        this.makePokemon("Yanma", "Bug", "Flying", 65, 65, 45, 75, 45, 95, 21, ["Bug"], 50, ["Yanma", "Yanmega"], 0, -1),
        this.makePokemon("Wooper", "Water", "Ground", 55, 45, 45, 25, 25, 15, 0, ["Water 1", "Field"], 50, ["Wooper", "Quagsire"], 0, 20),
        this.makePokemon("Quagsire", "Water", "Ground", 95, 85, 85, 65, 65, 35, 19, ["Water 1", "Field"], 50, ["Wooper", "Quagsire"], 1, 0),
        this.makePokemon("Espeon", "Psychic", null, 65, 65, 60, 130, 95, 110, 27, ["Field"], 87.5, ["Eevee", "Espeon"], 1, 0),
        this.makePokemon("Umbreon", "Dark", null, 95, 65, 110, 60, 130, 65, 27, ["Field"], 87.5, ["Eevee", "Umbreon"], 1, 0),
        this.makePokemon("Murkrow", "Dark", "Flying", 60, 85, 42, 85, 42, 91, 29, ["Flying"], 50, ["Murkrow", "Honchkrow"], 0, -1),
        this.makePokemon("Slowking", "Water", "Psychic", 95, 75, 80, 100, 110, 30, 22, ["Monster", "Water 1"], 50, ["Slowpoke", "Slowking"], 1, 0),
        this.makePokemon("Misdreavus", "Ghost", null, 60, 60, 60, 85, 85, 85, 27, ["Amorphous"], 50, ["Misdreavus", "Mismagius"], 0, -1),
        this.makePokemon("Unown", "Psychic", null, 48, 72, 48, 72, 48, 48, 2, ["Unown"], -1, ["Unown"], 0, 0),
        this.makePokemon("Wobbuffet", "Psychic", null, 190, 33, 58, 33, 58, 33, 27, ["Amorphous"], 50, ["Wynaut", "Wobbuffet"], 1, 0),
        this.makePokemon("Girafarig", "Normal", "Psychic", 70, 80, 65, 90, 65, 85, 24, ["Field"], 50, ["Girafarig"], 0, 0),
        this.makePokemon("Pineco", "Bug", null, 50, 65, 90, 35, 35, 15, 6, ["Bug"], 50, ["Pineco", "Forretress"], 0, 31),
        this.makePokemon("Forretress", "Bug", "Steel", 75, 90, 140, 60, 60, 40, 21, ["Bug"], 50, ["Pineco", "Forretress"], 1, 0),
        this.makePokemon("Dunsparce", "Normal", null, 100, 70, 70, 65, 65, 45, 6, ["Field"], 50, ["Dunsparce"], 0, 0),
        this.makePokemon("Gligar", "Ground", "Flying", 65, 75, 105, 35, 65, 85, 24, ["Bug"], 50, ["Gligar", "Gliscor"], 0, -1),
        this.makePokemon("Steelix", "Steel", "Ground", 75, 85, 200, 55, 65, 30, 30, ["Mineral"], 50, ["Onix", "Steelix"], 1, 0),
        this.makePokemon("Snubbull", "Fairy", null, 60, 80, 50, 40, 40, 30, 6, ["Field", "Fairy"], 25, ["Snubbull", "Granbull"], 0, 23),
        this.makePokemon("Granbull", "Fairy", null, 90, 120, 75, 60, 60, 45, 21, ["Field", "Fairy"], 25, ["Snubbull", "Granbull"], 1, 0),
        this.makePokemon("Qwilfish", "Water", "Poison", 65, 95, 85, 55, 55, 85, 27, ["Water 2"], 50, ["Qwilfish"], 0, 0),
        this.makePokemon("Scizor", "Bug", "Steel", 70, 130, 100, 55, 80, 65, 30, ["Bug"], 50, ["Scyther", "Scizor"], 1, 0),
        this.makePokemon("Shuckle", "Bug", "Rock", 20, 10, 230, 10, 230, 5, 6, ["Bug"], 50, ["Shuckle"], 0, 0),
        this.makePokemon("Heracross", "Bug", "Fighting", 80, 125, 75, 40, 95, 85, 27, ["Bug"], 50, ["Heracross"], 0, 0),
        this.makePokemon("Sneasel", "Dark", "Ice", 55, 95, 55, 35, 75, 115, 24, ["Field"], 50, ["Sneasel", "Weavile"], 0, -1),
        this.makePokemon("Teddiursa", "Normal", null, 60, 80, 50, 50, 50, 40, 17, ["Field"], 50, ["Teddiursa", "Ursaring"], 0, 30),
        this.makePokemon("Ursaring", "Normal", null, 90, 130, 75, 75, 75, 55, 24, ["Field"], 50, ["Teddiursa", "Ursaring"], 1, 0),
        this.makePokemon("Slugma", "Fire", null, 40, 40, 40, 70, 40, 20, 6, ["Amorphous"], 50, ["Slugma", "Magcargo"], 0, 38),
        this.makePokemon("Magcargo", "Fire", "Rock", 60, 50, 120, 90, 80, 30, 21, ["Amorphous"], 50, ["Slugma", "Magcargo"], 1, 0),
        this.makePokemon("Swinub", "Ice", "Ground", 50, 50, 40, 30, 30, 50, 2, ["Field"], 50, ["Swinub", "Piloswine", "Mamoswine"], 0, 33),
        this.makePokemon("Piloswine", "Ice", "Ground", 100, 100, 80, 60, 60, 50, 21, ["Field"], 50, ["Swinub", "Piloswine", "Mamoswine"], 1, -1),
        this.makePokemon("Corsola", "Water", "Rock", 65, 55, 95, 65, 95, 35, 24, ["Water 1", "Water 3"], 25, ["Corsola"], 0, 0),
        this.makePokemon("Remoraid", "Water", null, 35, 65, 35, 65, 35, 65, 6, ["Water 1", "Water 2"], 50, ["Remoraid", "Octillery"], 0, 25),
        this.makePokemon("Octillery", "Water", null, 75, 105, 75, 105, 75, 45, 21, ["Water 1", "Water 2"], 50, ["Remoraid", "Octillery"], 1, 0),
        this.makePokemon("Delibird", "Ice", "Flying", 45, 55, 45, 65, 45, 75, 27, ["Water 1", "Field"], 50, ["Delibird"], 0, 0),
        this.makePokemon("Mantine", "Water", "Flying", 85, 40, 70, 80, 140, 70, 30, ["Water 1"], 50, ["Mantyke", "Mantine"], 1, 0),
        this.makePokemon("Skarmory", "Steel", "Flying", 65, 80, 140, 40, 70, 70, 30, ["Flying"], 50, ["Skarmory"], 0, 0),
        this.makePokemon("Houndour", "Dark", "Fire", 45, 60, 30, 80, 50, 65, 17, ["Field"], 50, ["Houndour", "Houndoom"], 0, 24),
        this.makePokemon("Houndoom", "Dark", "Fire", 75, 90, 50, 110, 80, 95, 27, ["Field"], 50, ["Houndour", "Houndoom"], 1, 0),
        this.makePokemon("Kingdra", "Water", "Dragon", 75, 95, 95, 95, 95, 85, 27, ["Water 1", "Dragon"], 50, ["Horsea", "Seadra", "Kingdra"], 2, 0),
        this.makePokemon("Phanpy", "Ground", null, 90, 60, 60, 40, 40, 40, 17, ["Field"], 50, ["Phanpy", "Donphan"], 0, 25),
        this.makePokemon("Donphan", "Ground", null, 90, 120, 120, 60, 60, 50, 24, ["Field"], 50, ["Phanpy", "Donphan"], 1, 0),
        this.makePokemon("Porygon2", "Normal", null, 85, 80, 90, 105, 95, 60, 27, ["Mineral"], -1, ["Porygon", "Porygon2", "Porygon-Z"], 1, -1),
        this.makePokemon("Stantler", "Normal", null, 73, 95, 62, 85, 65, 85, 27, ["Field"], 50, ["Stantler"], 0, 0),
        this.makePokemon("Smeargle", "Normal", null, 55, 20, 35, 20, 45, 75, 27, ["Field"], 50, ["Smeargle"], 0, 0),
        this.makePokemon("Tyrogue", "Fighting", null, 35, 35, 35, 35, 35, 35, 21, ["Human-Like"], 100, ["Tyrogue", "Hitmonlee", "Hitmonchan", "Hitmontop"], 0, 20),
        this.makePokemon("Hitmontop", "Fighting", null, 50, 95, 95, 35, 110, 70, 27, ["Human-Like"], 100, ["Tyrogue", "Hitmontop"], 1, 0),
        this.makePokemon("Smoochum", "Ice", "Psychic", 45, 30, 10, 85, 65, 65, 27, ["Human-Like"], 0, ["Smoochum", "Jynx"], 0, 30),
        this.makePokemon("Elekid", "Electric", null, 45, 63, 37, 65, 55, 95, 27, ["Human-Like"], 75, ["Elekid", "Electabuzz", "Electivire"], 0, 30),
        this.makePokemon("Magby", "Fire", null, 45, 75, 37, 70, 55, 83, 27, ["Human-Like"], 75, ["Magby", "Magmar", "Magmortar"], 0, 30),
        this.makePokemon("Miltank", "Normal", null, 95, 80, 105, 40, 70, 100, 27, ["Field"], 0, ["Miltank"], 0, 0),
        this.makePokemon("Blissey", "Normal", null, 255, 10, 10, 75, 135, 55, 29, ["Fairy"], 0, ["Happiny", "Chansey", "Blissey"], 2, 0),
        this.makePokemon("Raikou", "Electric", null, 90, 85, 75, 115, 100, 115, 32, ["Undiscovered"], -1, ["Raikou"], 0, 0),
        this.makePokemon("Entei", "Fire", null, 115, 115, 85, 90, 75, 100, 32, ["Undiscovered"], -1, ["Entei"], 0, 0),
        this.makePokemon("Suicune", "Water", null, 100, 75, 115, 90, 115, 85, 32, ["Undiscovered"], -1, ["Suicune"], 0, 0),
        this.makePokemon("Larvitar", "Rock", "Ground", 50, 64, 50, 45, 50, 41, 27, ["Monster"], 50, ["Larvitar", "Pupitar", "Tyranitar"], 0, 30),
        this.makePokemon("Pupitar", "Rock", "Ground", 70, 84, 70, 65, 70, 51, 27, ["Monster"], 50, ["Larvitar", "Pupitar", "Tyranitar"], 1, 55),
        this.makePokemon("Tyranitar", "Rock", "Dark", 100, 134, 110, 95, 100, 61, 27, ["Monster"], 50, ["Larvitar", "Pupitar", "Tyranitar"], 2, 0),
        this.makePokemon("Lugia", "Psychic", "Flying", 106, 90, 130, 90, 154, 110, 32, ["Undiscovered"], -1, ["Lugia"], 0, 0),
        this.makePokemon("Ho-Oh", "Fire", "Flying", 106, 130, 90, 110, 154, 90, 32, ["Undiscovered"], -1, ["Ho-Oh"], 0, 0),
        this.makePokemon("Celebi", "Psychic", "Grass", 100, 100, 100, 100, 100, 100, 32, ["Undiscovered"], -1, ["Celebi"], 0, 0),
        this.makePokemon("Treecko", "Grass", null, 40, 45, 35, 65, 55, 70, 27, ["Monster", "Dragon"], 87.5, ["Treecko", "Grovyle", "Sceptile"], 0, 16),
        this.makePokemon("Grovyle", "Grass", null, 50, 65, 45, 85, 65, 95, 27, ["Monster", "Dragon"], 87.5, ["Treecko", "Grovyle", "Sceptile"], 1, 36),
        this.makePokemon("Sceptile", "Grass", null, 70, 85, 65, 105, 85, 120, 27, ["Monster", "Dragon"], 87.5, ["Treecko", "Grovyle", "Sceptile"], 2, 0),
        this.makePokemon("Torchic", "Fire", null, 45, 60, 40, 70, 50, 45, 27, ["Field"], 87.5, ["Torchic", "Combusken", "Blaziken"], 0, 16),
        this.makePokemon("Combusken", "Fire", "Fighting", 60, 85, 60, 85, 60, 55, 27, ["Field"], 87.5, ["Torchic", "Combusken", "Blaziken"], 1, 36),
        this.makePokemon("Blaziken", "Fire", "Fighting", 80, 120, 70, 110, 70, 80, 27, ["Field"], 87.5, ["Torchic", "Combusken", "Blaziken"], 2, 0),
        this.makePokemon("Mudkip", "Water", null, 50, 70, 50, 50, 50, 40, 27, ["Monster", "Water 1"], 87.5, ["Mudkip", "Marshtomp", "Swampert"], 0, 16),
        this.makePokemon("Marshtomp", "Water", "Ground", 70, 85, 70, 60, 70, 50, 27, ["Monster", "Water 1"], 87.5, ["Mudkip", "Marshtomp", "Swampert"], 1, 36),
        this.makePokemon("Swampert", "Water", "Ground", 100, 110, 90, 85, 90, 60, 27, ["Monster", "Water 1"], 87.5, ["Mudkip", "Marshtomp", "Swampert"], 2, 0),
        this.makePokemon("Poochyena", "Dark", null, 35, 55, 35, 30, 30, 35, 0, ["Field"], 50, ["Poochyena", "Mightyena"], 0, 18),
        this.makePokemon("Mightyena", "Dark", null, 70, 90, 70, 60, 60, 70, 15, ["Field"], 50, ["Poochyena", "Mightyena"], 1, 0),
        this.makePokemon("Zigzagoon", "Normal", null, 38, 30, 41, 30, 41, 60, 0, ["Field"], 50, ["Zigzagoon", "Linoone"], 0, 20),
        this.makePokemon("Linoone", "Normal", null, 78, 70, 61, 50, 61, 100, 19, ["Field"], 50, ["Zigzagoon", "Linoone"], 1, 0),
        this.makePokemon("Wurmple", "Bug", null, 45, 45, 35, 20, 30, 20, 0, ["Bug"], 50, ["Wurmple", "Silcoon", "Beautifly", "Cascoon", "Dustox"], 0, 7),
        this.makePokemon("Silcoon", "Bug", null, 50, 35, 55, 25, 25, 15, 17, ["Bug"], 50, ["Wurmple", "Silcoon", "Beautifly"], 1, 10),
        this.makePokemon("Beautifly", "Bug", "Flying", 60, 70, 50, 100, 50, 65, 27, ["Bug"], 50, ["Wurmple", "Silcoon", "Beautifly"], 2, 0),
        this.makePokemon("Cascoon", "Bug", null, 50, 35, 55, 25, 25, 15, 17, ["Bug"], 50, ["Wurmple", "Cascoon", "Dustox"], 1, 10),
        this.makePokemon("Dustox", "Bug", "Poison", 60, 50, 70, 50, 90, 65, 27, ["Bug"], 50, ["Wurmple", "Cascoon", "Dustox"], 2, 0),
        this.makePokemon("Lotad", "Water", "Grass", 40, 30, 30, 40, 50, 30, 0, ["Water 1", "Grass"], 50, ["Lotad", "Lombre", "Ludicolo"], 0, 14),
        this.makePokemon("Lombre", "Water", "Grass", 60, 50, 50, 60, 70, 50, 17, ["Water 1", "Grass"], 50, ["Lotad", "Lombre", "Ludicolo"], 1, -1),
        this.makePokemon("Ludicolo", "Water", "Grass", 80, 70, 70, 90, 100, 70, 27, ["Water 1", "Grass"], 50, ["Lotad", "Lombre", "Ludicolo"], 2, 0),
        this.makePokemon("Seedot", "Grass", null, 40, 40, 50, 30, 30, 30, 0, ["Field", "Grass"], 50, ["Seedot", "Nuzleaf", "Shiftry"], 0, 14),
        this.makePokemon("Nuzleaf", "Grass", "Dark", 70, 70, 40, 60, 40, 60, 17, ["Field", "Grass"], 50, ["Seedot", "Nuzleaf", "Shiftry"], 1, -1),
        this.makePokemon("Shiftry", "Grass", "Dark", 90, 100, 60, 90, 60, 80, 27, ["Field", "Grass"], 50, ["Seedot", "Nuzleaf", "Shiftry"], 2, 0),
        this.makePokemon("Taillow", "Normal", "Flying", 40, 55, 30, 30, 30, 85, 5, ["Flying"], 50, ["Taillow", "Swellow"], 0, 22),
        this.makePokemon("Swellow", "Normal", "Flying", 60, 85, 60, 75, 50, 125, 27, ["Flying"], 50, ["Taillow", "Swellow"], 1, 0),
        this.makePokemon("Wingull", "Water", "Flying", 40, 30, 30, 55, 30, 85, 6, ["Water 1", "Flying"], 50, ["Wingull", "Pelipper"], 0, 25),
        this.makePokemon("Pelipper", "Water", "Flying", 60, 50, 100, 95, 70, 65, 27, ["Water 1", "Flying"], 50, ["Wingull", "Pelipper"], 1, 0),
        this.makePokemon("Ralts", "Psychic", "Fairy", 28, 25, 25, 45, 35, 40, 1, ["Amorphous"], 50, ["Ralts", "Kirlia", "Gardevoir", "Gallade"], 0, 20),
        this.makePokemon("Kirlia", "Psychic", "Fairy", 38, 35, 35, 65, 55, 50, 17, ["Amorphous"], 50, ["Ralts", "Kirlia", "Gardevoir", "Gallade"], 1, 30),
        this.makePokemon("Gardevoir", "Psychic", "Fairy", 68, 65, 65, 125, 115, 80, 27, ["Amorphous"], 50, ["Ralts", "Kirlia", "Gardevoir"], 2, 0),
        this.makePokemon("Surskit", "Bug", "Water", 40, 30, 32, 50, 52, 65, 5, ["Water 1", "Bug"], 50, ["Surskit", "Masquerain"], 0, 22),
        this.makePokemon("Masquerain", "Bug", "Flying", 70, 60, 62, 100, 82, 80, 21, ["Water 1", "Bug"], 50, ["Surskit", "Masquerain"], 1, 0),
        this.makePokemon("Shroomish", "Grass", null, 60, 40, 60, 40, 60, 35, 0, ["Fairy", "Grass"], 50, ["Shroomish", "Breloom"], 0, 23),
        this.makePokemon("Breloom", "Grass", "Fighting", 60, 130, 80, 60, 60, 70, 19, ["Fairy", "Grass"], 50, ["Shroomish", "Breloom"], 1, 0),
        this.makePokemon("Slakoth", "Normal", null, 60, 60, 60, 35, 35, 30, 0, ["Field"], 50, ["Slakoth", "Vigoroth", "Slaking"], 0, 18),
        this.makePokemon("Vigoroth", "Normal", null, 80, 80, 80, 55, 55, 90, 17, ["Field"], 50, ["Slakoth", "Vigoroth", "Slaking"], 1, 36),
        this.makePokemon("Slaking", "Normal", null, 150, 160, 100, 95, 65, 100, 27, ["Field"], 50, ["Slakoth", "Vigoroth", "Slaking"], 2, 0),
        this.makePokemon("Nincada", "Bug", "Ground", 31, 45, 90, 30, 30, 40, 0, ["Bug"], 50, ["Nincada", "Ninjask", "Shedinja"], 0, 20),
        this.makePokemon("Ninjask", "Bug", "Flying", 61, 90, 45, 50, 50, 160, 17, ["Bug"], 50, ["Nincada", "Ninjask"], 1, 0),
        this.makePokemon("Shedinja", "Bug", "Ghost", 1, 90, 45, 30, 30, 40, 27, ["Mineral"], -1, ["Nincada", "Shedinja"], 1, 0),
        this.makePokemon("Whismur", "Normal", null, 64, 51, 23, 51, 23, 28, 6, ["Monster", "Field"], 50, ["Whismur", "Loudred", "Exploud"], 0, 20),
        this.makePokemon("Loudred", "Normal", null, 84, 71, 43, 71, 43, 48, 17, ["Monster", "Field"], 50, ["Whismur", "Loudred", "Exploud"], 1, 40),
        this.makePokemon("Exploud", "Normal", null, 104, 91, 63, 91, 73, 68, 27, ["Monster", "Field"], 50, ["Whismur", "Loudred", "Exploud"], 2, 0),
        this.makePokemon("Makuhita", "Fighting", null, 72, 60, 30, 20, 30, 25, 5, ["Human-Like"], 75, ["Makuhita", "Hariyama"], 0, 24),
        this.makePokemon("Hariyama", "Fighting", null, 144, 120, 60, 40, 60, 50, 7, ["Human-Like"], 75, ["Makuhita", "Hariyama"], 1, 0),
        this.makePokemon("Azurill", "Normal", "Fairy", 50, 20, 40, 20, 40, 20, 11, ["Water 1", "Fairy"], 25, ["Azurill", "Marill", "Azumarill"], 0, -1),
        this.makePokemon("Nosepass", "Rock", null, 30, 45, 135, 45, 90, 30, 0, ["Mineral"], 50, ["Nosepass", "Probopass"], 0, -1),
        this.makePokemon("Skitty", "Normal", null, 50, 45, 45, 35, 35, 50, 0, ["Field", "Fairy"], 25, ["Skitty", "Delcatty"], 0, -1),
        this.makePokemon("Delcatty", "Normal", null, 70, 65, 65, 55, 55, 90, 24, ["Field", "Fairy"], 25, ["Skitty", "Delcatty"], 1, 0),
        this.makePokemon("Sableye", "Dark", "Ghost", 50, 75, 75, 65, 65, 50, 27, ["Human-Like"], 50, ["Sableye"], 0, 0),
        this.makePokemon("Mawile", "Steel", "Fairy", 50, 85, 85, 55, 55, 50, 27, ["Field", "Fairy"], 50, ["Mawile"], 0, 0),
        this.makePokemon("Aron", "Steel", "Rock", 50, 70, 100, 40, 40, 30, 7, ["Monster"], 50, ["Aron", "Lairon", "Aggron"], 0, 32),
        this.makePokemon("Lairon", "Steel", "Rock", 60, 90, 140, 50, 50, 40, 19, ["Monster"], 50, ["Aron", "Lairon", "Aggron"], 1, 42),
        this.makePokemon("Aggron", "Steel", "Rock", 70, 110, 180, 60, 60, 50, 27, ["Monster"], 50, ["Aron", "Lairon", "Aggron"], 2, 0),
        this.makePokemon("Meditite", "Fighting", "Psychic", 30, 40, 55, 40, 55, 60, 7, ["Human-Like"], 50, ["Meditite", "Medicham"], 0, 37),
        this.makePokemon("Medicham", "Fighting", "Psychic", 60, 60, 75, 60, 75, 80, 19, ["Human-Like"], 50, ["Meditite", "Medicham"], 1, 0),
        this.makePokemon("Electrike", "Electric", null, 40, 45, 40, 65, 40, 65, 17, ["Field"], 50, ["Electrike", "Manectric"], 0, 26),
        this.makePokemon("Manectric", "Electric", null, 70, 75, 60, 105, 60, 105, 27, ["Field"], 50, ["Electrike", "Manectric"], 1, 0),
        this.makePokemon("Plusle", "Electric", null, 60, 50, 40, 85, 75, 95, 5, ["Fairy"], 50, ["Plusle"], 0, 0),
        this.makePokemon("Minun", "Electric", null, 60, 40, 50, 75, 85, 95, 5, ["Fairy"], 50, ["Minun"], 0, 0),
        this.makePokemon("Volbeat", "Bug", null, 65, 73, 75, 47, 85, 85, 11, ["Bug", "Human-Like"], 100, ["Volbeat"], 0, 0),
        this.makePokemon("Illumise", "Bug", null, 65, 47, 75, 73, 85, 85, 11, ["Bug", "Human-Like"], 0, ["Illumise"], 0, 0),
        this.makePokemon("Roselia", "Grass", "Poison", 50, 60, 45, 100, 80, 65, 11, ["Fairy", "Grass"], 50, ["Budew", "Roselia", "Roserade"], 1, -1),
        this.makePokemon("Gulpin", "Poison", null, 70, 43, 53, 43, 53, 40, 2, ["Amorphous"], 50, ["Gulpin", "Swalot"], 0, 26),
        this.makePokemon("Swalot", "Poison", null, 100, 73, 83, 73, 83, 55, 21, ["Amorphous"], 50, ["Gulpin", "Swalot"], 1, 0),
        this.makePokemon("Carvanha", "Water", "Dark", 45, 90, 20, 65, 20, 65, 2, ["Water 2"], 50, ["Carvanha", "Sharpedo"], 0, 30),
        this.makePokemon("Sharpedo", "Water", "Dark", 70, 120, 40, 95, 40, 95, 24, ["Water 2"], 50, ["Carvanha", "Sharpedo"], 1, 0),
        this.makePokemon("Wailmer", "Water", null, 130, 70, 35, 70, 35, 60, 16, ["Field", "Water 2"], 50, ["Wailmer", "Wailord"], 0, 40),
        this.makePokemon("Wailord", "Water", null, 170, 90, 45, 90, 45, 60, 24, ["Field", "Water 2"], 50, ["Wailmer", "Wailord"], 1, 0),
        this.makePokemon("Numel", "Fire", "Ground", 60, 60, 40, 65, 45, 35, 0, ["Field"], 50, ["Numel", "Camerupt"], 0, 33),
        this.makePokemon("Camerupt", "Fire", "Ground", 70, 100, 70, 105, 75, 40, 11, ["Field"], 50, ["Numel", "Camerupt"], 1, 0),
        this.makePokemon("Torkoal", "Fire", null, 70, 85, 140, 85, 70, 20, 19, ["Field"], 50, ["Torkoal"], 0, 0),
        this.makePokemon("Spoink", "Psychic", null, 60, 25, 35, 70, 80, 60, 0, ["Field"], 50, ["Spoink", "Grumpig"], 0, 32),
        this.makePokemon("Grumpig", "Psychic", null, 80, 45, 65, 90, 110, 80, 24, ["Field"], 50, ["Spoink", "Grumpig"], 1, 0),
        this.makePokemon("Spinda", "Normal", null, 60, 60, 60, 60, 60, 60, 0, ["Field", "Human-Like"], 50, ["Spinda"], 0, 0),
        this.makePokemon("Trapinch", "Ground", null, 45, 100, 45, 45, 45, 10, 0, ["Bug"], 50, ["Trapinch", "Vibrava", "Flygon"], 0, 35),
        this.makePokemon("Vibrava", "Ground", "Dragon", 50, 70, 50, 50, 50, 70, 17, ["Bug"], 50, ["Trapinch", "Vibrava", "Flygon"], 1, 45),
        this.makePokemon("Flygon", "Ground", "Dragon", 80, 100, 80, 80, 80, 100, 27, ["Bug"], 50, ["Trapinch", "Vibrava", "Flygon"], 2, 0),
        this.makePokemon("Cacnea", "Grass", null, 50, 85, 40, 85, 40, 35, 6, ["Grass", "Human-Like"], 50, ["Cacnea", "Cacturne"], 0, 32),
        this.makePokemon("Cacturne", "Grass", "Dark", 70, 115, 60, 115, 60, 55, 24, ["Grass", "Human-Like"], 50, ["Cacnea", "Cacturne"], 1, 0),
        this.makePokemon("Swablu", "Normal", "Flying", 45, 40, 60, 40, 75, 50, 0, ["Flying", "Dragon"], 50, ["Swablu", "Altaria"], 0, 35),
        this.makePokemon("Altaria", "Dragon", "Flying", 75, 70, 90, 70, 105, 80, 27, ["Flying", "Dragon"], 50, ["Swablu", "Altaria"], 1, 0),
        this.makePokemon("Zangoose", "Normal", null, 73, 115, 60, 60, 60, 90, 19, ["Field"], 50, ["Zangoose"], 0, 0),
        this.makePokemon("Seviper", "Poison", null, 73, 100, 60, 100, 60, 65, 19, ["Field", "Dragon"], 50, ["Seviper"], 0, 0),
        this.makePokemon("Lunatone", "Rock", "Psychic", 90, 55, 65, 95, 85, 70, 27, ["Mineral"], -1, ["Lunatone"], 0, 0),
        this.makePokemon("Solrock", "Rock", "Psychic", 90, 95, 85, 55, 65, 70, 27, ["Mineral"], -1, ["Solrock"], 0, 0),
        this.makePokemon("Barboach", "Water", "Ground", 50, 48, 43, 46, 41, 60, 6, ["Water 2"], 50, ["Barboach", "Whiscash"], 0, 30),
        this.makePokemon("Whiscash", "Water", "Ground", 110, 78, 73, 76, 71, 60, 21, ["Water 2"], 50, ["Barboach", "Whiscash"], 1, 0),
        this.makePokemon("Corphish", "Water", null, 43, 80, 65, 50, 35, 35, 4, ["Water 1", "Water 3"], 50, ["Corphish", "Crawdaunt"], 0, 30),
        this.makePokemon("Crawdaunt", "Water", "Dark", 63, 120, 85, 90, 55, 55, 10, ["Water 1", "Water 3"], 50, ["Corphish", "Crawdaunt"], 1, 0),
        this.makePokemon("Baltoy", "Ground", "Psychic", 40, 40, 55, 40, 70, 55, 0, ["Mineral"], -1, ["Baltoy", "Claydol"], 0, 36),
        this.makePokemon("Claydol", "Ground", "Psychic", 60, 70, 105, 70, 120, 75, 19, ["Mineral"], -1, ["Baltoy", "Claydol"], 1, 0),
        this.makePokemon("Lileep", "Rock", "Grass", 66, 41, 77, 61, 87, 23, 27, ["Water 3"], 87.5, ["Lileep", "Cradily"], 0, 40),
        this.makePokemon("Cradily", "Rock", "Grass", 86, 81, 97, 81, 107, 43, 27, ["Water 3"], 87.5, ["Lileep", "Cradily"], 1, 0),
        this.makePokemon("Anorith", "Rock", "Bug", 45, 95, 50, 40, 50, 75, 27, ["Water 3"], 87.5, ["Anorith", "Armaldo"], 0, 40),
        this.makePokemon("Armaldo", "Rock", "Bug", 75, 125, 100, 70, 80, 45, 27, ["Water 3"], 87.5, ["Anorith", "Armaldo"], 1, 0),
        this.makePokemon("Feebas", "Water", null, 20, 15, 20, 10, 55, 80, 0, ["Water 1", "Dragon"], 50, ["Feebas", "Milotic"], 0, -1),
        this.makePokemon("Milotic", "Water", null, 95, 60, 79, 100, 125, 81, 24, ["Water 1", "Dragon"], 50, ["Feebas", "Milotic"], 1, 0),
        this.makePokemon("Castform", "Normal", null, 70, 70, 70, 70, 70, 70, 27, ["Fairy", "Amorphous"], 50, ["Castform"], 0, 0),
        this.makePokemon("Kecleon", "Normal", null, 60, 90, 70, 60, 120, 40, 5, ["Field"], 50, ["Kecleon"], 0, 0),
        this.makePokemon("Shuppet", "Ghost", null, 44, 75, 35, 63, 33, 45, 2, ["Amorphous"], 50, ["Shuppet", "Banette"], 0, 37),
        this.makePokemon("Banette", "Ghost", null, 64, 115, 65, 83, 63, 65, 27, ["Amorphous"], 50, ["Shuppet", "Banette"], 1, 0),
        this.makePokemon("Duskull", "Ghost", null, 20, 40, 90, 30, 90, 25, 6, ["Amorphous"], 50, ["Duskull", "Dusclops", "Dusknoir"], 0, 37),
        this.makePokemon("Dusclops", "Ghost", null, 40, 70, 130, 60, 130, 25, 19, ["Amorphous"], 50, ["Duskull", "Dusclops", "Dusknoir"], 1, -1),
        this.makePokemon("Tropius", "Grass", "Flying", 99, 68, 83, 72, 87, 51, 5, ["Monster", "Grass"], 50, ["Tropius"], 0, 0),
        this.makePokemon("Chimecho", "Psychic", null, 65, 50, 70, 95, 80, 65, 27, ["Amorphous"], 50, ["Chingling", "Chimecho"], 1, 0),
        this.makePokemon("Absol", "Dark", null, 65, 130, 60, 75, 60, 75, 29, ["Field"], 50, ["Absol"], 0, 0),
        this.makePokemon("Wynaut", "Psychic", null, 95, 23, 48, 23, 48, 23, 16, ["Amorphous"], 50, ["Wynaut", "Wobbuffet"], 0, 15),
        this.makePokemon("Snorunt", "Ice", null, 50, 50, 50, 50, 50, 50, 6, ["Fairy", "Mineral"], 50, ["Snorunt", "Glalie", "Froslass"], 0, 42),
        this.makePokemon("Glalie", "Ice", null, 80, 80, 80, 80, 80, 80, 21, ["Fairy", "Mineral"], 50, ["Snorunt", "Glalie"], 1, 0),
        this.makePokemon("Spheal", "Ice", "Water", 70, 40, 50, 55, 50, 25, 0, ["Water 1", "Field"], 50, ["Spheal", "Sealeo", "Walrein"], 0, 32),
        this.makePokemon("Sealeo", "Ice", "Water", 90, 60, 70, 75, 70, 45, 17, ["Water 1", "Field"], 50, ["Spheal", "Sealeo", "Walrein"], 1, 44),
        this.makePokemon("Walrein", "Ice", "Water", 110, 80, 90, 95, 90, 65, 27, ["Water 1", "Field"], 50, ["Spheal", "Sealeo", "Walrein"], 2, 0),
        this.makePokemon("Clamperl", "Water", null, 35, 64, 85, 74, 55, 32, 0, ["Water 1"], 50, ["Clamperl", "Huntail", "Gorebyss"], 0, -1),
        this.makePokemon("Huntail", "Water", null, 55, 104, 105, 94, 75, 52, 24, ["Water 1"], 50, ["Clamperl", "Huntail", "Gorebyss"], 1, 0),
        this.makePokemon("Gorebyss", "Water", null, 55, 84, 105, 114, 75, 52, 24, ["Water 1"], 50, ["Clamperl", "Huntail", "Gorebyss"], 1, 0),
        this.makePokemon("Relicanth", "Water", "Rock", 100, 90, 130, 45, 65, 55, 30, ["Water 1", "Water 2"], 87.5, ["Relicanth"], 0, 0),
        this.makePokemon("Luvdisc", "Water", null, 43, 30, 55, 40, 65, 97, 2, ["Water 2"], 25, ["Luvdisc"], 0, 0),
        this.makePokemon("Bagon", "Dragon", null, 45, 75, 60, 40, 30, 50, 27, ["Dragon"], 50, ["Bagon", "Shelgon", "Salamence"], 0, 30),
        this.makePokemon("Shelgon", "Dragon", null, 65, 95, 100, 60, 50, 50, 27, ["Dragon"], 50, ["Bagon", "Shelgon", "Salamence"], 1, 50),
        this.makePokemon("Salamence", "Dragon", "Flying", 95, 135, 80, 110, 80, 100, 27, ["Dragon"], 50, ["Bagon", "Shelgon", "Salamence"], 2, 0),
        this.makePokemon("Beldum", "Steel", "Psychic", 40, 55, 80, 35, 60, 30, 32, ["Mineral"], -1, ["Beldum", "Metang", "Metagross"], 0, 20),
        this.makePokemon("Metang", "Steel", "Psychic", 60, 75, 100, 55, 80, 50, 32, ["Mineral"], -1, ["Beldum", "Metang", "Metagross"], 1, 45),
        this.makePokemon("Metagross", "Steel", "Psychic", 80, 135, 130, 95, 90, 70, 32, ["Mineral"], -1, ["Beldum", "Metang", "Metagross"], 2, 0),
        this.makePokemon("Regirock", "Rock", null, 80, 100, 200, 50, 100, 50, 32, ["Undiscovered"], -1, ["Regirock"], 0, 0),
        this.makePokemon("Regice", "Ice", null, 80, 50, 100, 100, 200, 50, 32, ["Undiscovered"], -1, ["Regice"], 0, 0),
        this.makePokemon("Registeel", "Steel", null, 80, 75, 150, 75, 150, 50, 32, ["Undiscovered"], -1, ["Registeel"], 0, 0),
        this.makePokemon("Latias", "Dragon", "Psychic", 80, 80, 90, 110, 130, 110, 32, ["Undiscovered"], 0, ["Latias"], 0, 0),
        this.makePokemon("Latios", "Dragon", "Psychic", 80, 90, 80, 130, 110, 110, 32, ["Undiscovered"], 100, ["Latios"], 0, 0),
        this.makePokemon("Kyogre", "Water", null, 100, 100, 90, 150, 140, 90, 32, ["Undiscovered"], -1, ["Kyogre"], 0, 0),
        this.makePokemon("Groudon", "Ground", null, 100, 150, 140, 100, 90, 90, 32, ["Undiscovered"], -1, ["Groudon"], 0, 0),
        this.makePokemon("Rayquaza", "Dragon", "Flying", 105, 150, 90, 150, 90, 95, 27, ["Undiscovered"], -1, ["Rayquaza"], 0, 0),
        this.makePokemon("Jirachi", "Steel", "Psychic", 100, 100, 100, 100, 100, 100, 32, ["Undiscovered"], -1, ["Jirachi"], 0, 0),
        this.makePokemon("DeoxysN", "Psychic", null, 50, 150, 50, 150, 50, 150, 32, ["Undiscovered"], -1, ["DeoxysN"], 0, 0), // 385:386
        this.makePokemon("DeoxysA", "Psychic", null, 50, 180, 20, 180, 20, 150, 32, ["Undiscovered"], -1, ["DeoxysA"], 0, 0), // 386:386
        this.makePokemon("DeoxysD", "Psychic", null, 50, 70, 160, 70, 160, 90, 32, ["Undiscovered"], -1, ["DeoxysD"], 0, 0), // 387:386
        this.makePokemon("DeoxysS", "Psychic", null, 50, 95, 90, 95, 90, 180, 32, ["Undiscovered"], -1, ["DeoxysS"], 0, 0), // 388:386
        this.makePokemon("Turtwig", "Grass", null, 55, 68, 64, 45, 55, 31, 27, ["Monster", "Grass"], 87.5, ["Turtwig", "Grotle", "Torterra"], 0, 18),
        this.makePokemon("Grotle", "Grass", null, 75, 89, 85, 55, 65, 36, 27, ["Monster", "Grass"], 87.5, ["Turtwig", "Grotle", "Torterra"], 1, 32),
        this.makePokemon("Torterra", "Grass", "Ground", 95, 109, 105, 75, 85, 56, 27, ["Monster", "Grass"], 87.5, ["Turtwig", "Grotle", "Torterra"], 2, 0),
        this.makePokemon("Chimchar", "Fire", null, 44, 58, 44, 58, 44, 61, 27, ["Field", "Human-Like"], 87.5, ["Chimchar", "Monferno", "Infernape"], 0, 14),
        this.makePokemon("Monferno", "Fire", "Fighting", 64, 78, 52, 78, 52, 81, 27, ["Field", "Human-Like"], 87.5, ["Chimchar", "Monferno", "Infernape"], 1, 36),
        this.makePokemon("Infernape", "Fire", "Fighting", 76, 104, 71, 104, 71, 108, 27, ["Field", "Human-Like"], 87.5, ["Chimchar", "Monferno", "Infernape"], 2, 0),
        this.makePokemon("Piplup", "Water", null, 53, 51, 53, 61, 56, 40, 27, ["Water 1", "Field"], 87.5, ["Piplup", "Prinplup", "Empoleon"], 0, 16),
        this.makePokemon("Prinplup", "Water", null, 64, 66, 68, 81, 76, 50, 27, ["Water 1", "Field"], 87.5, ["Piplup", "Prinplup", "Empoleon"], 1, 36),
        this.makePokemon("Empoleon", "Water", "Steel", 84, 86, 88, 111, 101, 60, 27, ["Water 1", "Field"], 87.5, ["Piplup", "Prinplup", "Empoleon"], 2, 0),
        this.makePokemon("Starly", "Normal", "Flying", 40, 55, 30, 30, 30, 60, 0, ["Flying"], 50, ["Starly", "Staravia", "Staraptor"], 0, 14),
        this.makePokemon("Staravia", "Normal", "Flying", 55, 75, 50, 40, 40, 80, 17, ["Flying"], 50, ["Starly", "Staravia", "Staraptor"], 1, 34),
        this.makePokemon("Staraptor", "Normal", "Flying", 85, 120, 70, 50, 60, 100, 27, ["Flying"], 50, ["Starly", "Staravia", "Staraptor"], 2, 0),
        this.makePokemon("Bidoof", "Normal", null, 59, 45, 40, 35, 40, 31, 0, ["Water 1", "Field"], 50, ["Bidoof", "Bibarel"], 0, 15),
        this.makePokemon("Bibarel", "Normal", "Water", 79, 85, 60, 55, 60, 71, 15, ["Water 1", "Field"], 50, ["Bidoof", "Bibarel"], 1, 0),
        this.makePokemon("Kricketot", "Bug", null, 37, 25, 41, 25, 41, 25, 0, ["Bug"], 50, ["Kricketot", "Kricketune"], 0, 10),
        this.makePokemon("Kricketune", "Bug", null, 77, 85, 51, 55, 51, 65, 27, ["Bug"], 50, ["Kricketot", "Kricketune"], 1, 0),
        this.makePokemon("Shinx", "Electric", null, 45, 65, 34, 40, 34, 45, 1, ["Field"], 50, ["Shinx", "Luxio", "Luxray"], 0, 15),
        this.makePokemon("Luxio", "Electric", null, 60, 85, 49, 60, 49, 60, 17, ["Field"], 50, ["Shinx", "Luxio", "Luxray"], 1, 30),
        this.makePokemon("Luxray", "Electric", null, 80, 120, 79, 95, 79, 70, 27, ["Field"], 50, ["Shinx", "Luxio", "Luxray"], 2, 0),
        this.makePokemon("Budew", "Grass", "Poison", 40, 30, 35, 50, 70, 55, 0, ["Fairy", "Grass"], 50, ["Budew", "Roselia", "Roserade"], 0, -1),
        this.makePokemon("Roserade", "Grass", "Poison", 60, 70, 65, 125, 105, 90, 21, ["Fairy", "Grass"], 50, ["Budew", "Roselia", "Roserade"], 2, 0),
        this.makePokemon("Cranidos", "Rock", null, 67, 125, 40, 30, 30, 58, 27, ["Monster"], 87.5, ["Cranidos", "Rampardos"], 0, 30),
        this.makePokemon("Rampardos", "Rock", null, 97, 165, 60, 65, 50, 58, 27, ["Monster"], 87.5, ["Cranidos", "Rampardos"], 1, 0),
        this.makePokemon("Shieldon", "Rock", "Steel", 30, 42, 118, 42, 88, 30, 27, ["Monster"], 87.5, ["Shieldon", "Bastiodon"], 0, 30),
        this.makePokemon("Bastiodon", "Rock", "Steel", 60, 52, 168, 47, 138, 30, 27, ["Monster"], 87.5, ["Shieldon", "Bastiodon"], 1, 0),
        this.makePokemon("Burmy", "Bug", null, 40, 29, 45, 29, 45, 36, 17, ["Bug"], 50, ["Burmy", "WormadamP", "WormadamS", "WormadamT", "Mothim"], 0, 20),
        this.makePokemon("WormadamP", "Bug", "Grass", 60, 59, 85, 79, 105, 36, 27, ["Bug"], 0, ["Burmy", "WormadamP"], 1, 0), // 415:413
        this.makePokemon("WormadamS", "Bug", "Ground", 60, 79, 105, 59, 85, 36, 27, ["Bug"], 0, ["Burmy", "WormadamS"], 1, 0), // 416:413
        this.makePokemon("WormadamT", "Bug", "Steel", 60, 69, 95, 69, 95, 36, 27, ["Bug"], 0, ["Burmy", "WormadamT"], 1, 0), // 417:413
        this.makePokemon("Mothim", "Bug", "Flying", 70, 94, 50, 94, 50, 66, 27, ["Bug"], 100, ["Burmy", "Mothim"], 1, 0),
        this.makePokemon("Combee", "Bug", "Flying", 30, 30, 42, 30, 42, 70, 17, ["Bug"], 87.5, ["Combee", "Vespiquen"], 0, 21),
        this.makePokemon("Vespiquen", "Bug", "Flying", 70, 80, 102, 80, 102, 40, 27, ["Bug"], 0, ["Combee", "Vespiquen"], 1, 0),
        this.makePokemon("Pachirisu", "Electric", null, 60, 45, 70, 45, 90, 95, 5, ["Field", "Fairy"], 50, ["Pachirisu"], 0, 0),
        this.makePokemon("Buizel", "Water", null, 55, 65, 35, 60, 30, 85, 6, ["Water 1", "Field"], 50, ["Buizel", "Floatzel"], 0, 26),
        this.makePokemon("Floatzel", "Water", null, 85, 105, 55, 85, 50, 115, 21, ["Water 1", "Field"], 50, ["Buizel", "Floatzel"], 1, 0),
        this.makePokemon("Cherubi", "Grass", null, 45, 35, 45, 62, 53, 35, 6, ["Fairy", "Grass"], 50, ["Cherubi", "Cherrim"], 0, 25),
        this.makePokemon("Cherrim", "Grass", null, 70, 60, 70, 87, 78, 85, 21, ["Fairy", "Grass"], 50, ["Cherubi", "Cherrim"], 1, 0),
        this.makePokemon("Shellos", "Water", null, 76, 48, 48, 57, 62, 34, 6, ["Water 1", "Amorphous"], 50, ["Shellos", "Gastrodon"], 0, 30),
        this.makePokemon("Gastrodon", "Water", "Ground", 111, 83, 68, 92, 82, 39, 21, ["Water 1", "Amorphous"], 50, ["Shellos", "Gastrodon"], 1, 0),
        this.makePokemon("Ambipom", "Normal", null, 75, 100, 66, 60, 66, 115, 27, ["Field"], 50, ["Aipom", "Ambipom"], 1, 0),
        this.makePokemon("Drifloon", "Ghost", "Flying", 90, 50, 34, 60, 44, 70, 16, ["Amorphous"], 50, ["Drifloon", "Drifblim"], 0, 28),
        this.makePokemon("Drifblim", "Ghost", "Flying", 150, 80, 44, 90, 54, 80, 24, ["Amorphous"], 50, ["Drifloon", "Drifblim"], 1, 0),
        this.makePokemon("Buneary", "Normal", null, 55, 66, 44, 44, 56, 85, 6, ["Field", "Human-Like"], 50, ["Buneary", "Lopunny"], 0, -1),
        this.makePokemon("Lopunny", "Normal", null, 65, 76, 84, 54, 96, 105, 24, ["Field", "Human-Like"], 50, ["Buneary", "Lopunny"], 1, 0),
        this.makePokemon("Mismagius", "Ghost", null, 60, 60, 60, 105, 105, 105, 27, ["Amorphous"], 50, ["Misdreavus", "Mismagius"], 1, 0),
        this.makePokemon("Honchkrow", "Dark", "Flying", 100, 125, 52, 105, 52, 71, 29, ["Flying"], 50, ["Murkrow", "Honchkrow"], 1, 0),
        this.makePokemon("Glameow", "Normal", null, 49, 55, 42, 42, 37, 85, 6, ["Field"], 25, ["Glameow", "Purugly"], 0, 38),
        this.makePokemon("Purugly", "Normal", null, 71, 82, 64, 64, 59, 112, 21, ["Field"], 25, ["Glameow", "Purugly"], 1, 0),
        this.makePokemon("Chingling", "Psychic", null, 45, 30, 50, 65, 50, 45, 17, ["Amorphous"], 50, ["Chingling", "Chimecho"], 0, -1),
        this.makePokemon("Stunky", "Poison", "Dark", 63, 63, 47, 41, 41, 74, 2, ["Field"], 50, ["Stunky", "Skuntank"], 0, 34),
        this.makePokemon("Skuntank", "Poison", "Dark", 103, 93, 67, 71, 61, 84, 24, ["Field"], 50, ["Stunky", "Skuntank"], 1, 0),
        this.makePokemon("Bronzor", "Steel", "Psychic", 57, 24, 86, 24, 86, 23, 0, ["Mineral"], -1, ["Bronzor", "Bronzong"], 0, 33),
        this.makePokemon("Bronzong", "Steel", "Psychic", 67, 89, 116, 79, 116, 33, 19, ["Mineral"], -1, ["Bronzor", "Bronzong"], 1, 0),
        this.makePokemon("Bonsly", "Rock", null, 50, 80, 95, 10, 45, 10, 0, ["Mineral"], 50, ["Bonsly", "Sudowoodo"], 0, -1),
        this.makePokemon("Mime Jr.", "Psychic", "Fairy", 20, 25, 45, 70, 90, 60, 12, ["Human-Like"], 50, ["Mime Jr.", "Mr. Mime"], 0, -1),
        this.makePokemon("Happiny", "Normal", null, 100, 5, 5, 15, 65, 30, 14, ["Fairy"], 0, ["Happiny", "Chansey", "Blissey"], 0, -1),
        this.makePokemon("Chatot", "Normal", "Flying", 76, 65, 45, 92, 42, 91, 29, ["Flying"], 50, ["Chatot"], 0, 0),
        this.makePokemon("Spiritomb", "Ghost", "Dark", 50, 92, 108, 92, 108, 35, 18, ["Amorphous"], 50, ["Spiritomb"], 0, 0),
        this.makePokemon("Gible", "Dragon", "Ground", 58, 70, 45, 40, 45, 42, 27, ["Monster", "Dragon"], 50, ["Gible", "Gabite", "Garchomp"], 0, 24),
        this.makePokemon("Gabite", "Dragon", "Ground", 68, 90, 65, 50, 55, 82, 27, ["Monster", "Dragon"], 50, ["Gible", "Gabite", "Garchomp"], 1, 48),
        this.makePokemon("Garchomp", "Dragon", "Ground", 108, 130, 95, 80, 85, 102, 27, ["Monster", "Dragon"], 50, ["Gible", "Gabite", "Garchomp"], 2, 0),
        this.makePokemon("Munchlax", "Normal", null, 135, 85, 40, 40, 85, 5, 26, ["Monster"], 87.5, ["Munchlax", "Snorlax"], 0, -1),
        this.makePokemon("Riolu", "Fighting", null, 40, 70, 40, 35, 40, 60, 21, ["Field", "Human-Like"], 87.5, ["Riolu", "Lucario"], 0, -1),
        this.makePokemon("Lucario", "Fighting", "Steel", 70, 110, 70, 115, 70, 90, 27, ["Field", "Human-Like"], 87.5, ["Riolu", "Lucario"], 1, 0),
        this.makePokemon("Hippopotas", "Ground", null, 68, 72, 78, 38, 42, 32, 13, ["Field"], 50, ["Hippopotas", "Hippowdon"], 0, 34),
        this.makePokemon("Hippowdon", "Ground", null, 108, 112, 118, 68, 72, 47, 24, ["Field"], 50, ["Hippopotas", "Hippowdon"], 1, 0),
        this.makePokemon("Skorupi", "Poison", "Bug", 40, 50, 90, 30, 55, 65, 17, ["Bug", "Water 3"], 50, ["Skorupi", "Drapion"], 0, 40),
        this.makePokemon("Drapion", "Poison", "Dark", 70, 90, 110, 60, 75, 95, 27, ["Bug", "Water 3"], 50, ["Skorupi", "Drapion"], 1, 0),
        this.makePokemon("Croagunk", "Poison", "Fighting", 48, 61, 40, 61, 40, 50, 13, ["Human-Like"], 50, ["Croagunk", "Toxicroak"], 0, 37),
        this.makePokemon("Toxicroak", "Poison", "Fighting", 83, 106, 65, 86, 65, 85, 21, ["Human-Like"], 50, ["Croagunk", "Toxicroak"], 1, 0),
        this.makePokemon("Carnivine", "Grass", null, 74, 100, 72, 90, 72, 46, 5, ["Grass"], 50, ["Carnivine"], 0, 0),
        this.makePokemon("Finneon", "Water", null, 49, 49, 56, 49, 61, 66, 6, ["Water 2"], 50, ["Finneon", "Lumineon"], 0, 31),
        this.makePokemon("Lumineon", "Water", null, 69, 69, 76, 69, 86, 91, 21, ["Water 2"], 50, ["Finneon", "Lumineon"], 1, 0),
        this.makePokemon("Mantyke", "Water", "Flying", 45, 20, 50, 60, 120, 50, 30, ["Water 1"], 50, ["Mantyke", "Mantine"], 0, -1),
        this.makePokemon("Snover", "Grass", "Ice", 60, 62, 50, 62, 60, 40, 17, ["Monster", "Grass"], 50, ["Snover", "Abomasnow"], 0, 40),
        this.makePokemon("Abomasnow", "Grass", "Ice", 90, 92, 75, 92, 85, 60, 24, ["Monster", "Grass"], 50, ["Snover", "Abomasnow"], 1, 0),
        this.makePokemon("Weavile", "Dark", "Ice", 70, 120, 65, 45, 85, 125, 27, ["Field"], 50, ["Sneasel", "Weavile"], 1, 0),
        this.makePokemon("Magnezone", "Electric", "Steel", 70, 70, 115, 130, 90, 60, 29, ["Mineral"], -1, ["Magnemite", "Magneton", "Magnezone"], 2, 0),
        this.makePokemon("Lickilicky", "Normal", null, 110, 85, 95, 80, 95, 50, 29, ["Monster"], 50, ["Lickitung", "Lickilicky"], 1, 0),
        this.makePokemon("Rhyperior", "Ground", "Rock", 115, 140, 130, 55, 55, 40, 29, ["Monster", "Field"], 50, ["Rhyhorn", "Rhydon", "Rhyperior"], 2, 0),
        this.makePokemon("Tangrowth", "Grass", null, 100, 100, 125, 110, 50, 50, 29, ["Grass"], 50, ["Tangela", "Tangrowth"], 1, 0),
        this.makePokemon("Electivire", "Electric", null, 75, 123, 67, 95, 85, 95, 29, ["Human-Like"], 75, ["Elekid", "Electabuzz", "Electivire"], 2, 0),
        this.makePokemon("Magmortar", "Fire", null, 75, 95, 67, 125, 95, 83, 29, ["Human-Like"], 75, ["Magby", "Magmar", "Magmortar"], 2, 0),
        this.makePokemon("Togekiss", "Fairy", "Flying", 85, 50, 95, 120, 115, 80, 29, ["Flying", "Fairy"], 87.5, ["Togepi", "Togetic", "Togekiss"], 2, 0),
        this.makePokemon("Yanmega", "Bug", "Flying", 86, 76, 86, 116, 56, 95, 29, ["Bug"], 50, ["Yanma", "Yanmega"], 1, 0),
        this.makePokemon("Leafeon", "Grass", null, 65, 110, 130, 60, 65, 95, 27, ["Field"], 87.5, ["Eevee", "Leafeon"], 1, 0),
        this.makePokemon("Glaceon", "Ice", null, 65, 60, 110, 130, 95, 65, 27, ["Field"], 87.5, ["Eevee", "Glaceon"], 1, 0),
        this.makePokemon("Gliscor", "Ground", "Flying", 75, 97, 125, 45, 75, 95, 29, ["Bug"], 50, ["Gligar", "Gliscor"], 1, 0),
        this.makePokemon("Mamoswine", "Ice", "Ground", 110, 130, 80, 70, 60, 80, 26, ["Field"], 50, ["Swinub", "Piloswine", "Mamoswine"], 2, 0),
        this.makePokemon("Porygon-Z", "Normal", null, 85, 80, 70, 135, 75, 90, 29, ["Mineral"], -1, ["Porygon", "Porygon2", "Porygon-Z"], 2, 0),
        this.makePokemon("Gallade", "Psychic", "Fighting", 68, 125, 65, 65, 115, 80, 27, ["Amorphous"], 100, ["Ralts", "Kirlia", "Gallade"], 2, 0),
        this.makePokemon("Probopass", "Rock", "Steel", 60, 55, 145, 75, 150, 40, 24, ["Mineral"], -1, ["Nosepass", "Probopass"], 1, 0),
        this.makePokemon("Dusknoir", "Ghost", null, 45, 100, 135, 65, 135, 45, 27, ["Amorphous"], 50, ["Duskull", "Dusclops", "Dusknoir"], 2, 0),
        this.makePokemon("Froslass", "Ice", "Ghost", 70, 80, 70, 80, 70, 110, 21, ["Fairy", "Mineral"], 0, ["Snorunt", "Froslass"], 1, 0),
        this.makePokemon("Rotom", "Electric", "Ghost", 50, 50, 77, 95, 77, 91, 27, ["Amorphous"], -1, ["Rotom"], 0, 0), // 483:479
        this.makePokemon("RotomH", "Electric", "Fire", 50, 65, 107, 105, 107, 86, 27, ["Amorphous"], -1, ["RotomH"], 0, 0), // 484:479
        this.makePokemon("RotomW", "Electric", "Water", 50, 65, 107, 105, 107, 86, 27, ["Amorphous"], -1, ["RotomW"], 0, 0), // 485:479
        this.makePokemon("RotomFr", "Electric", "Ice", 50, 65, 107, 105, 107, 86, 27, ["Amorphous"], -1, ["RotomFr"], 0, 0), // 486:479
        this.makePokemon("RotomFa", "Electric", "Flying", 50, 65, 107, 105, 107, 86, 27, ["Amorphous"], -1, ["RotomFa"], 0, 0), // 487:479
        this.makePokemon("RotomM", "Electric", "Grass", 50, 65, 107, 105, 107, 86, 27, ["Amorphous"], -1, ["RotomM"], 0, 0), // 488:479
        this.makePokemon("Uxie", "Psychic", null, 75, 75, 130, 75, 130, 95, 32, ["Undiscovered"], -1, ["Uxie"], 0, 0),
        this.makePokemon("Mesprit", "Psychic", null, 80, 105, 105, 105, 105, 80, 32, ["Undiscovered"], -1, ["Mesprit"], 0, 0),
        this.makePokemon("Azelf", "Psychic", null, 75, 120, 70, 125, 70, 115, 32, ["Undiscovered"], -1, ["Azelf"], 0, 0),
        this.makePokemon("Dialga", "Steel", "Dragon", 100, 120, 120, 150, 100, 90, 32, ["Undiscovered"], -1, ["Dialga"], 0, 0),
        this.makePokemon("Palkia", "Water", "Dragon", 90, 120, 100, 150, 120, 100, 32, ["Undiscovered"], -1, ["Palkia"], 0, 0),
        this.makePokemon("Heatran", "Fire", "Steel", 91, 90, 106, 130, 106, 77, 32, ["Undiscovered"], 50, ["Heatran"], 0, 0),
        this.makePokemon("Regigigas", "Normal", null, 110, 160, 110, 80, 110, 100, 32, ["Undiscovered"], -1, ["Regigigas"], 0, 0),
        this.makePokemon("GiratinaA", "Ghost", "Dragon", 150, 100, 120, 100, 120, 90, 32, ["Undiscovered"], -1, ["GiratinaA"], 0, 0), // 496:487
        this.makePokemon("GiratinaO", "Ghost", "Dragon", 150, 120, 100, 120, 100, 90, 32, ["Undiscovered"], -1, ["GiratinaO"], 0, 0), // 497:487
        this.makePokemon("Cresselia", "Psychic", null, 120, 70, 120, 75, 130, 85, 32, ["Undiscovered"], 0, ["Cresselia"], 0, 0),
        this.makePokemon("Phione", "Water", null, 80, 80, 80, 80, 80, 80, 29, ["Water 1", "Fairy"], -1, ["Phione"], 0, 0),
        this.makePokemon("Manaphy", "Water", null, 100, 100, 100, 100, 100, 100, 32, ["Water 1", "Fairy"], -1, ["Manaphy"], 0, 0),
        this.makePokemon("Darkrai", "Dark", null, 70, 90, 90, 135, 90, 125, 32, ["Undiscovered"], -1, ["Darkrai"], 0, 0),
        this.makePokemon("ShayminL", "Grass", null, 100, 100, 100, 100, 100, 100, 27, ["Undiscovered"], -1, ["ShayminL"], 0, 0), // 502:492
        this.makePokemon("ShayminS", "Grass", "Flying", 100, 103, 75, 120, 75, 127, 27, ["Undiscovered"], -1, ["ShayminS"], 0, 0), // 503:492
        this.makePokemon("Arceus", "Normal", null, 120, 120, 120, 120, 120, 120, 32, ["Undiscovered"], -1, ["Arceus"], 0, 0),
        this.makePokemon("Victini", "Psychic", "Fire", 100, 100, 100, 100, 100, 100, 32, ["Undiscovered"], -1, ["Victini"], 0, 0),
        this.makePokemon("Snivy", "Grass", null, 45, 45, 55, 45, 55, 63, 27, ["Field", "Grass"], 87.5, ["Snivy", "Servine", "Serperior"], 0, 17),
        this.makePokemon("Servine", "Grass", null, 60, 60, 75, 60, 75, 83, 27, ["Field", "Grass"], 87.5, ["Snivy", "Servine", "Serperior"], 1, 36),
        this.makePokemon("Serperior", "Grass", null, 75, 75, 95, 75, 95, 113, 27, ["Field", "Grass"], 87.5, ["Snivy", "Servine", "Serperior"], 2, 0),
        this.makePokemon("Tepig", "Fire", null, 65, 63, 45, 45, 45, 45, 27, ["Field"], 87.5, ["Tepig", "Pignite", "Emboar"], 0, 17),
        this.makePokemon("Pignite", "Fire", "Fighting", 90, 93, 55, 70, 55, 55, 27, ["Field"], 87.5, ["Tepig", "Pignite", "Emboar"], 1, 36),
        this.makePokemon("Emboar", "Fire", "Fighting", 110, 123, 65, 100, 65, 65, 27, ["Field"], 87.5, ["Tepig", "Pignite", "Emboar"], 2, 0),
        this.makePokemon("Oshawott", "Water", null, 55, 55, 45, 63, 45, 45, 27, ["Field"], 87.5, ["Oshawott", "Dewott", "Samurott"], 0, 17),
        this.makePokemon("Dewott", "Water", null, 75, 75, 60, 83, 60, 60, 27, ["Field"], 87.5, ["Oshawott", "Dewott", "Samurott"], 1, 36),
        this.makePokemon("Samurott", "Water", null, 95, 100, 85, 108, 70, 70, 27, ["Field"], 87.5, ["Oshawott", "Dewott", "Samurott"], 2, 0),
        this.makePokemon("Patrat", "Normal", null, 45, 55, 39, 35, 39, 42, 0, ["Field"], 50, ["Patrat", "Watchog"], 0, 20),
        this.makePokemon("Watchog", "Normal", null, 60, 85, 69, 60, 69, 77, 0, ["Field"], 50, ["Patrat", "Watchog"], 1, 0),
        this.makePokemon("Lillipup", "Normal", null, 45, 60, 45, 25, 45, 55, 0, ["Field"], 50, ["Lillipup", "Herdier", "Stoutland"], 0, 16),
        this.makePokemon("Herdier", "Normal", null, 65, 80, 65, 35, 65, 60, 17, ["Field"], 50, ["Lillipup", "Herdier", "Stoutland"], 1, 32),
        this.makePokemon("Stoutland", "Normal", null, 85, 110, 90, 45, 90, 80, 27, ["Field"], 50, ["Lillipup", "Herdier", "Stoutland"], 2, 0),
        this.makePokemon("Purrloin", "Dark", null, 41, 50, 37, 50, 37, 66, 0, ["Field"], 50, ["Purrloin", "Liepard"], 0, 20),
        this.makePokemon("Liepard", "Dark", null, 64, 88, 50, 88, 50, 106, 19, ["Field"], 50, ["Purrloin", "Liepard"], 1, 0),
        this.makePokemon("Pansage", "Grass", null, 50, 53, 48, 53, 48, 64, 6, ["Field"], 87.5, ["Pansage", "Simisage"], 0, -1),
        this.makePokemon("Simisage", "Grass", null, 75, 98, 63, 98, 63, 101, 21, ["Field"], 87.5, ["Pansage", "Simisage"], 1, 0),
        this.makePokemon("Pansear", "Fire", null, 50, 53, 48, 53, 48, 64, 6, ["Field"], 87.5, ["Pansear", "Simisear"], 0, -1),
        this.makePokemon("Simisear", "Fire", null, 75, 98, 63, 98, 63, 101, 21, ["Field"], 87.5, ["Pansear", "Simisear"], 1, 0),
        this.makePokemon("Panpour", "Water", null, 50, 53, 48, 53, 48, 64, 6, ["Field"], 87.5, ["Panpour", "Simipour"], 0, -1),
        this.makePokemon("Simipour", "Water", null, 75, 98, 63, 98, 63, 101, 21, ["Field"], 87.5, ["Panpour", "Simipour"], 1, 0),
        this.makePokemon("Munna", "Psychic", null, 76, 25, 45, 67, 55, 24, 6, ["Field"], 50, ["Munna", "Musharna"], 0, -1),
        this.makePokemon("Musharna", "Psychic", null, 116, 55, 85, 107, 95, 29, 21, ["Field"], 50, ["Munna", "Musharna"], 1, 0),
        this.makePokemon("Pidove", "Normal", "Flying", 50, 55, 50, 36, 30, 43, 0, ["Flying"], 50, ["Pidove", "Tranquill", "Unfezant"], 0, 21),
        this.makePokemon("Tranquill", "Normal", "Flying", 62, 77, 62, 50, 42, 65, 17, ["Flying"], 50, ["Pidove", "Tranquill", "Unfezant"], 1, 32),
        this.makePokemon("Unfezant", "Normal", "Flying", 80, 115, 80, 65, 55, 93, 27, ["Flying"], 50, ["Pidove", "Tranquill", "Unfezant"], 2, 0),
        this.makePokemon("Blitzle", "Electric", null, 45, 60, 32, 50, 32, 76, 6, ["Field"], 50, ["Blitzle", "Zebstrika"], 0, 27),
        this.makePokemon("Zebstrika", "Electric", null, 75, 100, 63, 80, 63, 116, 21, ["Field"], 50, ["Blitzle", "Zebstrika"], 1, 0),
        this.makePokemon("Roggenrola", "Rock", null, 55, 75, 85, 25, 25, 15, 0, ["Mineral"], 50, ["Roggenrola", "Boldore", "Gigalith"], 0, 25),
        this.makePokemon("Boldore", "Rock", null, 70, 105, 105, 50, 40, 20, 17, ["Mineral"], 50, ["Roggenrola", "Boldore", "Gigalith"], 1, -1),
        this.makePokemon("Gigalith", "Rock", null, 85, 135, 130, 60, 80, 25, 27, ["Mineral"], 50, ["Roggenrola", "Boldore", "Gigalith"], 2, 0),
        this.makePokemon("Woobat", "Psychic", "Flying", 65, 45, 43, 55, 43, 72, 6, ["Field", "Flying"], 50, ["Woobat", "Swoobat"], 0, -1),
        this.makePokemon("Swoobat", "Psychic", "Flying", 67, 57, 55, 77, 55, 114, 27, ["Field", "Flying"], 50, ["Woobat", "Swoobat"], 1, 0),
        this.makePokemon("Drilbur", "Ground", null, 60, 85, 40, 30, 45, 68, 17, ["Field"], 50, ["Drilbur", "Excadrill"], 0, 31),
        this.makePokemon("Excadrill", "Ground", "Steel", 110, 135, 60, 50, 65, 88, 24, ["Field"], 50, ["Drilbur", "Excadrill"], 1, 0),
        this.makePokemon("Audino", "Normal", null, 103, 60, 86, 60, 86, 50, 0, ["Fairy"], 50, ["Audino"], 0, 0),
        this.makePokemon("Timburr", "Fighting", null, 75, 80, 55, 25, 35, 35, 7, ["Human-Like"], 75, ["Timburr", "Gurdurr", "Conkeldurr"], 0, 25),
        this.makePokemon("Gurdurr", "Fighting", null, 85, 105, 85, 40, 50, 40, 19, ["Human-Like"], 75, ["Timburr", "Gurdurr", "Conkeldurr"], 1, -1),
        this.makePokemon("Conkeldurr", "Fighting", null, 105, 140, 95, 55, 65, 45, 27, ["Human-Like"], 75, ["Timburr", "Gurdurr", "Conkeldurr"], 2, 0),
        this.makePokemon("Tympole", "Water", null, 50, 50, 40, 50, 40, 60, 0, ["Water 1"], 50, ["Tympole", "Palpitoad", "Seismitoad"], 0, 25),
        this.makePokemon("Palpitoad", "Water", "Ground", 75, 65, 55, 65, 55, 69, 17, ["Water 1"], 50, ["Tympole", "Palpitoad", "Seismitoad"], 1, 36),
        this.makePokemon("Seismitoad", "Water", "Ground", 105, 95, 75, 85, 75, 74, 27, ["Water 1"], 50, ["Tympole", "Palpitoad", "Seismitoad"], 2, 0),
        this.makePokemon("Throh", "Fighting", null, 120, 100, 85, 30, 85, 45, 27, ["Human-Like"], 100, ["Throh"], 0, 0),
        this.makePokemon("Sawk", "Fighting", null, 75, 125, 75, 30, 75, 85, 27, ["Human-Like"], 100, ["Sawk"], 0, 0),
        this.makePokemon("Sewaddle", "Bug", "Grass", 45, 53, 70, 40, 60, 42, 0, ["Bug"], 50, ["Sewaddle", "Swadloon", "Leavanny"], 0, 20),
        this.makePokemon("Swadloon", "Bug", "Grass", 55, 63, 90, 50, 80, 42, 17, ["Bug"], 50, ["Sewaddle", "Swadloon", "Leavanny"], 1, -1),
        this.makePokemon("Leavanny", "Bug", "Grass", 75, 103, 80, 70, 80, 92, 27, ["Bug"], 50, ["Sewaddle", "Swadloon", "Leavanny"], 2, 0),
        this.makePokemon("Venipede", "Bug", "Poison", 30, 45, 59, 30, 39, 57, 0, ["Bug"], 50, ["Venipede", "Whirlipede", "Scolipede"], 0, 22),
        this.makePokemon("Whirlipede", "Bug", "Poison", 40, 55, 99, 40, 79, 47, 17, ["Bug"], 50, ["Venipede", "Whirlipede", "Scolipede"], 1, 30),
        this.makePokemon("Scolipede", "Bug", "Poison", 60, 100, 89, 55, 69, 112, 27, ["Bug"], 50, ["Venipede", "Whirlipede", "Scolipede"], 2, 0),
        this.makePokemon("Cottonee", "Grass", "Fairy", 40, 27, 60, 37, 50, 66, 6, ["Grass", "Fairy"], 50, ["Cottonee", "Whimsicott"], 0, -1),
        this.makePokemon("Whimsicott", "Grass", "Fairy", 60, 67, 85, 77, 75, 116, 21, ["Grass", "Fairy"], 50, ["Cottonee", "Whimsicott"], 1, 0),
        this.makePokemon("Petilil", "Grass", null, 45, 35, 50, 70, 50, 30, 6, ["Grass"], 0, ["Petilil", "Lilligant"], 0, -1),
        this.makePokemon("Lilligant", "Grass", null, 70, 60, 75, 110, 75, 90, 21, ["Grass"], 0, ["Petilil", "Lilligant"], 1, 0),
        this.makePokemon("Basculin", "Water", null, 70, 92, 65, 80, 55, 98, 30, ["Water 2"], 50, ["Basculin"], 0, 0),
        this.makePokemon("Sandile", "Ground", "Dark", 50, 72, 35, 35, 35, 65, 7, ["Field"], 50, ["Sandile", "Krokorok", "Krookodile"], 0, 29),
        this.makePokemon("Krokorok", "Ground", "Dark", 60, 82, 45, 45, 45, 74, 19, ["Field"], 50, ["Sandile", "Krokorok", "Krookodile"], 1, 40),
        this.makePokemon("Krookodile", "Ground", "Dark", 95, 117, 80, 65, 70, 92, 27, ["Field"], 50, ["Sandile", "Krokorok", "Krookodile"], 2, 0),
        this.makePokemon("Darumaka", "Fire", null, 70, 90, 45, 15, 45, 50, 17, ["Field"], 50, ["Darumaka", "Darmanitan", "DarmanitanZ"], 0, 35),
        this.makePokemon("Darmanitan", "Fire", null, 105, 140, 55, 30, 55, 95, 24, ["Field"], 50, ["Darumaka", "Darmanitan"], 1, 0), // 566:555
        this.makePokemon("DarmanitanZ", "Fire", "Psychic", 105, 30, 105, 140, 105, 55, 24, ["Field"], 50, ["Darumaka", "DarmanitanZ"], 1, 0), // 567:555
        this.makePokemon("Maractus", "Grass", null, 75, 86, 67, 106, 67, 60, 0, ["Grass"], 50, ["Maractus"], 0, 0),
        this.makePokemon("Dwebble", "Bug", "Rock", 50, 65, 85, 35, 35, 55, 6, ["Bug", "Mineral"], 50, ["Dwebble", "Crustle"], 0, 34),
        this.makePokemon("Crustle", "Bug", "Rock", 70, 105, 125, 65, 75, 45, 21, ["Bug", "Mineral"], 50, ["Dwebble", "Crustle"], 1, 0),
        this.makePokemon("Scraggy", "Dark", "Fighting", 50, 75, 70, 35, 70, 48, 7, ["Field", "Dragon"], 50, ["Scraggy", "Scrafty"], 0, 39),
        this.makePokemon("Scrafty", "Dark", "Fighting", 65, 90, 115, 45, 115, 58, 19, ["Field", "Dragon"], 50, ["Scraggy", "Scrafty"], 1, 0),
        this.makePokemon("Sigilyph", "Psychic", "Flying", 72, 58, 80, 103, 80, 97, 27, ["Flying"], 50, ["Sigilyph"], 0, 0),
        this.makePokemon("Yamask", "Ghost", null, 38, 30, 85, 55, 65, 30, 6, ["Mineral", "Amorphous"], 50, ["Yamask", "Cofagrigus"], 0, 34),
        this.makePokemon("Cofagrigus", "Ghost", null, 58, 50, 145, 95, 105, 30, 19, ["Mineral", "Amorphous"], 50, ["Yamask", "Cofagrigus"], 1, 0),
        this.makePokemon("Tirtouga", "Water", "Rock", 54, 78, 103, 53, 45, 22, 27, ["Water 1", "Water 3"], 87.5, ["Tirtouga", "Carracosta"], 0, 37),
        this.makePokemon("Carracosta", "Water", "Rock", 74, 108, 133, 83, 65, 32, 27, ["Water 1", "Water 3"], 87.5, ["Tirtouga", "Carracosta"], 1, 0),
        this.makePokemon("Archen", "Rock", "Flying", 55, 112, 45, 74, 45, 70, 27, ["Flying", "Water 3"], 87.5, ["Archen", "Archeops"], 0, 37),
        this.makePokemon("Archeops", "Rock", "Flying", 75, 140, 65, 112, 65, 110, 27, ["Flying", "Water 3"], 87.5, ["Archen", "Archeops"], 1, 0),
        this.makePokemon("Trubbish", "Poison", null, 50, 50, 62, 40, 62, 65, 6, ["Mineral"], 50, ["Trubbish", "Garbodor"], 0, 36),
        this.makePokemon("Garbodor", "Poison", null, 80, 95, 82, 60, 82, 75, 24, ["Mineral"], 50, ["Trubbish", "Garbodor"], 1, 0),
        this.makePokemon("Zorua", "Dark", null, 40, 65, 40, 80, 40, 65, 21, ["Field"], 87.5, ["Zorua", "Zoroark"], 0, 30),
        this.makePokemon("Zoroark", "Dark", null, 60, 105, 60, 120, 60, 105, 27, ["Field"], 87.5, ["Zorua", "Zoroark"], 1, 0),
        this.makePokemon("Minccino", "Normal", null, 55, 50, 40, 40, 40, 75, 0, ["Field"], 25, ["Minccino", "Cinccino"], 0, -1),
        this.makePokemon("Cinccino", "Normal", null, 75, 95, 60, 65, 60, 115, 24, ["Field"], 25, ["Minccino", "Cinccino"], 1, 0),
        this.makePokemon("Gothita", "Psychic", null, 45, 30, 50, 55, 65, 45, 5, ["Human-Like"], 25, ["Gothita", "Gothorita", "Gothitelle"], 0, 32),
        this.makePokemon("Gothorita", "Psychic", null, 60, 45, 70, 75, 85, 55, 18, ["Human-Like"], 25, ["Gothita", "Gothorita", "Gothitelle"], 1, 41),
        this.makePokemon("Gothitelle", "Psychic", null, 70, 55, 95, 95, 110, 95, 26, ["Human-Like"], 25, ["Gothita", "Gothorita", "Gothitelle"], 2, 0),
        this.makePokemon("Solosis", "Psychic", null, 45, 30, 45, 105, 50, 20, 5, ["Amorphous"], 50, ["Solosis", "Duosion", "Reuniclus"], 0, 32),
        this.makePokemon("Duosion", "Psychic", null, 65, 40, 50, 125, 60, 30, 18, ["Amorphous"], 50, ["Solosis", "Duosion", "Reuniclus"], 1, 41),
        this.makePokemon("Reuniclus", "Psychic", null, 110, 65, 75, 125, 85, 30, 26, ["Amorphous"], 50, ["Solosis", "Duosion", "Reuniclus"], 2, 0),
        this.makePokemon("Ducklett", "Water", "Flying", 62, 44, 50, 44, 50, 55, 6, ["Water 1", "Flying"], 50, ["Ducklett", "Swanna"], 0, 35),
        this.makePokemon("Swanna", "Water", "Flying", 75, 87, 63, 87, 63, 98, 27, ["Water 1", "Flying"], 50, ["Ducklett", "Swanna"], 1, 0),
        this.makePokemon("Vanillite", "Ice", null, 36, 50, 50, 65, 60, 44, 0, ["Mineral"], 50, ["Vanillite", "Vanillish", "Vanilluxe"], 0, 35),
        this.makePokemon("Vanillish", "Ice", null, 51, 65, 65, 80, 75, 59, 17, ["Mineral"], 50, ["Vanillite", "Vanillish", "Vanilluxe"], 1, 47),
        this.makePokemon("Vanilluxe", "Ice", null, 71, 95, 85, 110, 95, 79, 27, ["Mineral"], 50, ["Vanillite", "Vanillish", "Vanilluxe"], 2, 0),
        this.makePokemon("Deerling", "Normal", "Grass", 60, 60, 50, 40, 50, 75, 6, ["Field"], 50, ["Deerling", "Sawsbuck"], 0, 34),
        this.makePokemon("Sawsbuck", "Normal", "Grass", 80, 100, 70, 60, 70, 95, 21, ["Field"], 50, ["Deerling", "Sawsbuck"], 1, 0),
        this.makePokemon("Emolga", "Electric", "Flying", 55, 75, 60, 75, 60, 103, 5, ["Field"], 50, ["Emolga"], 0, 0),
        this.makePokemon("Karrablast", "Bug", null, 50, 75, 45, 40, 45, 60, 5, ["Bug"], 50, ["Karrablast", "Escavalier"], 0, -1),
        this.makePokemon("Escavalier", "Bug", "Steel", 70, 135, 105, 60, 105, 20, 21, ["Bug"], 50, ["Karrablast", "Escavalier"], 1, 0),
        this.makePokemon("Foongus", "Grass", "Poison", 69, 55, 45, 55, 55, 15, 6, ["Grass"], 50, ["Foongus", "Amoonguss"], 0, 39),
        this.makePokemon("Amoonguss", "Grass", "Poison", 114, 85, 70, 85, 80, 30, 21, ["Grass"], 50, ["Foongus", "Amoonguss"], 1, 0),
        this.makePokemon("Frillish", "Water", "Ghost", 55, 40, 50, 65, 85, 40, 6, ["Amorphous"], 50, ["Frillish", "Jellicent"], 0, 40),
        this.makePokemon("Jellicent", "Water", "Ghost", 100, 60, 70, 85, 105, 60, 24, ["Amorphous"], 50, ["Frillish", "Jellicent"], 1, 0),
        this.makePokemon("Alomomola", "Water", null, 165, 75, 80, 40, 45, 65, 21, ["Water 1", "Water 2"], 50, ["Alomomola"], 0, 0),
        this.makePokemon("Joltik", "Bug", "Electric", 50, 47, 50, 57, 50, 65, 6, ["Bug"], 50, ["Joltik", "Galvantula"], 0, 36),
        this.makePokemon("Galvantula", "Bug", "Electric", 70, 77, 60, 97, 60, 108, 21, ["Bug"], 50, ["Joltik", "Galvantula"], 1, 0),
        this.makePokemon("Ferroseed", "Grass", "Steel", 44, 50, 91, 24, 86, 10, 0, ["Grass", "Mineral"], 50, ["Ferroseed", "Ferrothorn"], 0, 40),
        this.makePokemon("Ferrothorn", "Grass", "Steel", 74, 94, 131, 54, 116, 20, 19, ["Grass", "Mineral"], 50, ["Ferroseed", "Ferrothorn"], 1, 0),
        this.makePokemon("Klink", "Steel", null, 40, 55, 70, 45, 60, 30, 14, ["Mineral"], -1, ["Klink", "Klang", "Klinklang"], 0, 38),
        this.makePokemon("Klang", "Steel", null, 60, 80, 95, 70, 85, 50, 24, ["Mineral"], -1, ["Klink", "Klang", "Klinklang"], 1, 49),
        this.makePokemon("Klinklang", "Steel", null, 60, 100, 115, 70, 85, 90, 29, ["Mineral"], -1, ["Klink", "Klang", "Klinklang"], 2, 0),
        this.makePokemon("Tynamo", "Electric", null, 35, 55, 40, 45, 40, 60, 6, ["Amorphous"], 50, ["Tynamo", "Eelektrik", "Eelektross"], 0, 39),
        this.makePokemon("Eelektrik", "Electric", null, 65, 85, 70, 75, 70, 40, 24, ["Amorphous"], 50, ["Tynamo", "Eelektrik", "Eelektross"], 1, -1),
        this.makePokemon("Eelektross", "Electric", null, 85, 115, 80, 105, 80, 50, 29, ["Amorphous"], 50, ["Tynamo", "Eelektrik", "Eelektross"], 2, 0),
        this.makePokemon("Elgyem", "Psychic", null, 55, 55, 55, 85, 55, 30, 0, ["Human-Like"], 50, ["Elgyem", "Beheeyem"], 0, 42),
        this.makePokemon("Beheeyem", "Psychic", null, 75, 75, 75, 125, 95, 40, 19, ["Human-Like"], 50, ["Elgyem", "Beheeyem"], 1, 0),
        this.makePokemon("Litwick", "Ghost", "Fire", 50, 30, 55, 65, 55, 20, 6, ["Amorphous"], 50, ["Litwick", "Lampent", "Chandelure"], 0, 41),
        this.makePokemon("Lampent", "Ghost", "Fire", 60, 40, 60, 95, 60, 55, 19, ["Amorphous"], 50, ["Litwick", "Lampent", "Chandelure"], 1, -1),
        this.makePokemon("Chandelure", "Ghost", "Fire", 60, 55, 90, 145, 90, 80, 27, ["Amorphous"], 50, ["Litwick", "Lampent", "Chandelure"], 2, 0),
        this.makePokemon("Axew", "Dragon", null, 46, 87, 60, 30, 40, 57, 21, ["Monster", "Dragon"], 50, ["Axew", "Fraxure", "Haxorus"], 0, 38),
        this.makePokemon("Fraxure", "Dragon", null, 66, 117, 70, 40, 50, 67, 24, ["Monster", "Dragon"], 50, ["Axew", "Fraxure", "Haxorus"], 1, 48),
        this.makePokemon("Haxorus", "Dragon", null, 76, 147, 90, 60, 70, 97, 27, ["Monster", "Dragon"], 50, ["Axew", "Fraxure", "Haxorus"], 2, 0),
        this.makePokemon("Cubchoo", "Ice", null, 55, 70, 40, 60, 40, 40, 17, ["Field"], 50, ["Cubchoo", "Beartic"], 0, 37),
        this.makePokemon("Beartic", "Ice", null, 95, 103, 80, 70, 80, 50, 24, ["Field"], 50, ["Cubchoo", "Beartic"], 1, 0),
        this.makePokemon("Cryogonal", "Ice", null, 80, 50, 50, 95, 135, 105, 30, ["Mineral"], -1, ["Cryogonal"], 0, 0),
        this.makePokemon("Shelmet", "Bug", null, 50, 40, 85, 40, 65, 25, 5, ["Bug"], 50, ["Shelmet", "Accelgor"], 0, -1),
        this.makePokemon("Accelgor", "Bug", null, 80, 70, 40, 100, 60, 145, 21, ["Bug"], 50, ["Shelmet", "Accelgor"], 1, 0),
        this.makePokemon("Stunfisk", "Ground", "Electric", 109, 66, 84, 81, 99, 32, 21, ["Water 1", "Amorphous"], 50, ["Stunfisk"], 0, 0),
        this.makePokemon("Mienfoo", "Fighting", null, 45, 85, 50, 55, 50, 65, 7, ["Field", "Human-Like"], 50, ["Mienfoo", "Mienshao"], 0, 50),
        this.makePokemon("Mienshao", "Fighting", null, 65, 125, 60, 95, 60, 105, 27, ["Field", "Human-Like"], 50, ["Mienfoo", "Mienshao"], 1, 0),
        this.makePokemon("Druddigon", "Dragon", null, 77, 120, 90, 60, 90, 48, 27, ["Dragon", "Monster"], 50, ["Druddigon"], 0, 0),
        this.makePokemon("Golett", "Ground", "Ghost", 59, 74, 50, 35, 50, 35, 6, ["Mineral"], -1, ["Golett", "Golurk"], 0, 43),
        this.makePokemon("Golurk", "Ground", "Ghost", 89, 124, 80, 55, 80, 55, 19, ["Mineral"], -1, ["Golett", "Golurk"], 1, 0),
        this.makePokemon("Pawniard", "Dark", "Steel", 45, 85, 70, 40, 40, 60, 17, ["Human-Like"], 50, ["Pawniard", "Bisharp"], 0, 52),
        this.makePokemon("Bisharp", "Dark", "Steel", 65, 125, 100, 60, 70, 70, 27, ["Human-Like"], 50, ["Pawniard", "Bisharp"], 1, 0),
        this.makePokemon("Bouffalant", "Normal", null, 95, 110, 95, 40, 95, 55, 27, ["Field"], 50, ["Bouffalant"], 0, 0),
        this.makePokemon("Rufflet", "Normal", "Flying", 70, 83, 50, 37, 50, 60, 6, ["Flying"], 100, ["Rufflet", "Braviary"], 0, 54),
        this.makePokemon("Braviary", "Normal", "Flying", 100, 123, 75, 57, 75, 80, 24, ["Flying"], 100, ["Rufflet", "Braviary"], 1, 0),
        this.makePokemon("Vullaby", "Dark", "Flying", 70, 55, 75, 45, 65, 60, 6, ["Flying"], 0, ["Vullaby", "Mandibuzz"], 0, 54),
        this.makePokemon("Mandibuzz", "Dark", "Flying", 110, 65, 105, 55, 95, 80, 24, ["Flying"], 0, ["Vullaby", "Mandibuzz"], 1, 0),
        this.makePokemon("Heatmor", "Fire", null, 85, 97, 66, 105, 66, 65, 19, ["Field"], 50, ["Heatmor"], 0, 0),
        this.makePokemon("Durant", "Bug", "Steel", 58, 109, 112, 48, 48, 109, 19, ["Bug"], 50, ["Durant"], 0, 0),
        this.makePokemon("Deino", "Dark", "Dragon", 52, 65, 50, 45, 50, 38, 27, ["Dragon"], 50, ["Deino", "Zweilous", "Hydreigon"], 0, 50),
        this.makePokemon("Zweilous", "Dark", "Dragon", 72, 85, 70, 65, 70, 58, 27, ["Dragon"], 50, ["Deino", "Zweilous", "Hydreigon"], 1, 64),
        this.makePokemon("Hydreigon", "Dark", "Dragon", 92, 105, 90, 125, 90, 98, 27, ["Dragon"], 50, ["Deino", "Zweilous", "Hydreigon"], 2, 0),
        this.makePokemon("Larvesta", "Bug", "Fire", 55, 85, 55, 50, 55, 60, 27, ["Bug"], 50, ["Larvesta", "Volcarona"], 0, 59),
        this.makePokemon("Volcarona", "Bug", "Fire", 85, 60, 65, 135, 105, 100, 31, ["Bug"], 50, ["Larvesta", "Volcarona"], 1, 0),
        this.makePokemon("Cobalion", "Steel", "Fighting", 91, 90, 129, 90, 72, 108, 32, ["Undiscovered"], -1, ["Cobalion"], 0, 0),
        this.makePokemon("Terrakion", "Rock", "Fighting", 91, 129, 90, 72, 90, 108, 32, ["Undiscovered"], -1, ["Terrakion"], 0, 0),
        this.makePokemon("Virizion", "Grass", "Fighting", 91, 90, 72, 90, 129, 108, 32, ["Undiscovered"], -1, ["Virizion"], 0, 0),
        this.makePokemon("TornadusI", "Flying", null, 79, 115, 70, 125, 80, 111, 32, ["Undiscovered"], 100, ["TornadusI"], 0, 0), // 653:641
        this.makePokemon("TornadusT", "Flying", null, 79, 100, 80, 110, 90, 121, 32, ["Undiscovered"], 100, ["TornadusT"], 0, 0), // 654:641
        this.makePokemon("ThundurusI", "Electric", "Flying", 79, 115, 70, 125, 80, 111, 32, ["Undiscovered"], 100, ["ThundurusI"], 0, 0), // 655:642
        this.makePokemon("ThundurusT", "Electric", "Flying", 79, 105, 70, 145, 80, 101, 32, ["Undiscovered"], 100, ["ThundurusT"], 0, 0), // 656:642
        this.makePokemon("Reshiram", "Dragon", "Fire", 100, 120, 100, 150, 120, 90, 32, ["Undiscovered"], -1, ["Reshiram"], 0, 0),
        this.makePokemon("Zekrom", "Dragon", "Electric", 100, 150, 120, 120, 100, 90, 32, ["Undiscovered"], -1, ["Zekrom"], 0, 0),
        this.makePokemon("LandorusI", "Ground", "Flying", 89, 125, 90, 115, 80, 101, 32, ["Undiscovered"], 100, ["LandorusI"], 0, 0), // 659:645
        this.makePokemon("LandorusT", "Ground", "Flying", 89, 145, 90, 105, 80, 91, 32, ["Undiscovered"], 100, ["LandorusT"], 0, 0), // 660:645
        this.makePokemon("Kyurem", "Dragon", "Ice", 125, 130, 90, 130, 90, 95, 32, ["Undiscovered"], -1, ["Kyurem"], 0, 0), // 661:646
        this.makePokemon("KyuremW", "Dragon", "Ice", 125, 120, 90, 170, 100, 95, 32, ["Undiscovered"], -1, ["KyuremW"], 0, 0), // 662:646
        this.makePokemon("KyuremB", "Dragon", "Ice", 125, 170, 100, 120, 90, 95, 32, ["Undiscovered"], -1, ["KyuremB"], 0, 0), // 663:646
        this.makePokemon("Keldeo", "Water", "Fighting", 91, 72, 90, 129, 90, 108, 32, ["Undiscovered"], -1, ["Keldeo"], 0, 0),
        this.makePokemon("MeloettaA", "Normal", "Psychic", 100, 77, 77, 128, 128, 90, 32, ["Undiscovered"], -1, ["MeloettaA"], 0, 0), // 665:648
        this.makePokemon("MeloettaP", "Normal", "Fighting", 100, 128, 90, 77, 77, 128, 32, ["Undiscovered"], -1, ["MeloettaP"], 0, 0), // 666:648
        this.makePokemon("Genesect", "Bug", "Steel", 71, 120, 95, 120, 95, 99, 32, ["Undiscovered"], -1, ["Genesect"], 0, 0),
        this.makePokemon("Chespin", "Grass", null, 56, 61, 65, 48, 45, 38, 27, ["Field"], 87.5, ["Chespin", "Quilladin", "Chestnaught"], 0, 16),
        this.makePokemon("Quilladin", "Grass", null, 61, 78, 95, 56, 58, 57, 27, ["Field"], 87.5, ["Chespin", "Quilladin", "Chestnaught"], 1, 36),
        this.makePokemon("Chestnaught", "Grass", "Fighting", 88, 107, 122, 74, 75, 64, 27, ["Field"], 87.5, ["Chespin", "Quilladin", "Chestnaught"], 2, 0),
        this.makePokemon("Fennekin", "Fire", null, 40, 45, 40, 62, 60, 60, 27, ["Field"], 87.5, ["Fennekin", "Braixen", "Delphox"], 0, 16),
        this.makePokemon("Braixen", "Fire", null, 59, 59, 58, 90, 70, 73, 27, ["Field"], 87.5, ["Fennekin", "Braixen", "Delphox"], 1, 36),
        this.makePokemon("Delphox", "Fire", "Psychic", 75, 69, 72, 114, 100, 104, 27, ["Field"], 87.5, ["Fennekin", "Braixen", "Delphox"], 2, 0),
        this.makePokemon("Froakie", "Water", null, 41, 56, 40, 62, 44, 71, 27, ["Water 1"], 87.5, ["Froakie", "Frogadier", "Greninja", "GreninjaA"], 0, 16),
        this.makePokemon("Frogadier", "Water", null, 54, 63, 52, 83, 56, 97, 27, ["Water 1"], 87.5, ["Froakie", "Frogadier", "Greninja"], 1, 36),
        this.makePokemon("Greninja", "Water", "Dark", 72, 95, 67, 103, 71, 122, 27, ["Water 1"], 87.5, ["Froakie", "Frogadier", "Greninja"], 2, 0), // 676:658
        this.makePokemon("GreninjaA", "Water", "Dark", 72, 145, 67, 153, 71, 132, 27, ["Water 1"], 87.5, ["Froakie", "Frogadier", "GreninjaA"], 2, 0), // 677:658
        this.makePokemon("Bunnelby", "Normal", null, 38, 36, 38, 32, 36, 57, 0, ["Field"], 50, ["Bunnelby", "Diggerby"], 0, 20),
        this.makePokemon("Diggersby", "Normal", "Ground", 85, 56, 77, 50, 77, 78, 15, ["Field"], 50, ["Bunnelby", "Diggerby"], 1, 0),
        this.makePokemon("Fletchling", "Normal", "Flying", 45, 50, 43, 40, 38, 62, 0, ["Flying"], 50, ["Fletchling", "Fletchinder", "Talonflame"], 0, 17),
        this.makePokemon("Fletchinder", "Fire", "Flying", 62, 73, 55, 56, 52, 84, 17, ["Flying"], 50, ["Fletchling", "Fletchinder", "Talonflame"], 1, 35),
        this.makePokemon("Talonflame", "Fire", "Flying", 78, 81, 71, 74, 69, 126, 27, ["Flying"], 50, ["Fletchling", "Fletchinder", "Talonflame"], 2, 0),
        this.makePokemon("Scatterbug", "Bug", null, 38, 35, 40, 27, 25, 35, 0, ["Bug"], 50, ["Scatterbug", "Spewpa", "Vivillon"], 0, 9),
        this.makePokemon("Spewpa", "Bug", null, 45, 22, 60, 27, 30, 29, 17, ["Bug"], 50, ["Scatterbug", "Spewpa", "Vivillon"], 1, 12),
        this.makePokemon("Vivillon", "Bug", "Flying", 80, 52, 50, 90, 50, 89, 27, ["Bug"], 50, ["Scatterbug", "Spewpa", "Vivillon"], 2, 0),
        this.makePokemon("Litleo", "Fire", "Normal", 62, 50, 58, 73, 54, 72, 3, ["Field"], 12.5, ["Litleo", "Pyroar"], 0, 35),
        this.makePokemon("Pyroar", "Fire", "Normal", 86, 68, 72, 109, 66, 106, 23, ["Field"], 12.5, ["Litleo", "Pyroar"], 1, 0),
        this.makePokemon("Flabebe", "Fairy", null, 44, 38, 39, 61, 79, 42, 2, ["Fairy"], 0, ["Flabebe", "Floette", "Florges"], 0, 19),
        this.makePokemon("Floette", "Fairy", null, 54, 45, 47, 75, 98, 52, 17, ["Fairy"], 0, ["Flabebe", "Floette", "Florges"], 1, -1),
        this.makePokemon("Florges", "Fairy", null, 78, 65, 68, 112, 154, 75, 27, ["Fairy"], 0, ["Flabebe", "Floette", "Florges"], 2, 0),
        this.makePokemon("Skiddo", "Grass", null, 66, 65, 48, 62, 57, 52, 5, ["Field"], 50, ["Skiddo", "Gogoat"], 0, 32),
        this.makePokemon("Gogoat", "Grass", null, 123, 100, 62, 97, 81, 68, 27, ["Field"], 50, ["Skiddo", "Gogoat"], 1, 0),
        this.makePokemon("Pancham", "Fighting", null, 67, 82, 62, 46, 48, 43, 3, ["Field", "Human-Like"], 50, ["Pancham", "Pangoro"], 0, 32),
        this.makePokemon("Pangoro", "Fighting", "Dark", 95, 124, 78, 69, 71, 58, 23, ["Field", "Human-Like"], 50, ["Pancham", "Pangoro"], 1, 0),
        this.makePokemon("Furfrou", "Normal", null, 75, 80, 60, 65, 90, 102, 9, ["Field"], 50, ["Furfrou"], 0, 0),
        this.makePokemon("Espurr", "Psychic", null, 62, 48, 54, 63, 60, 68, 6, ["Field"], 50, ["Espurr", "Meowstic"], 0, 25),
        this.makePokemon("Meowstic", "Psychic", null, 74, 48, 76, 83, 81, 104, 21, ["Field"], 50, ["Espurr", "Meowstic"], 1, 0),
        this.makePokemon("Honedge", "Steel", "Ghost", 45, 80, 100, 35, 37, 28, 7, ["Mineral"], 50, ["Honedge", "Doublade", "AegislashSh", "AegislashSw"], 0, 35),
        this.makePokemon("Doublade", "Steel", "Ghost", 59, 110, 150, 45, 49, 35, 19, ["Mineral"], 50, ["Honedge", "Doublade", "AegislashSw"], 1, -1),
        this.makePokemon("AegislashSh", "Steel", "Ghost", 60, 50, 150, 50, 150, 60, 27, ["Mineral"], 50, ["Honedge", "Doublade", "AegislashSh"], 2, 0), // 700:681
        this.makePokemon("AegislashSw", "Steel", "Ghost", 60, 150, 50, 150, 50, 60, 27, ["Mineral"], 50, ["Honedge", "Doublade", "AegislashSw"], 2, 0), // 701:681
        this.makePokemon("Spritzee", "Fairy", null, 78, 52, 60, 63, 65, 23, 5, ["Fairy"], 50, ["Spritzee", "Aromatisse"], 0, -1),
        this.makePokemon("Aromatisse", "Fairy", null, 101, 72, 72, 99, 89, 29, 13, ["Fairy"], 50, ["Spritzee", "Aromatisse"], 1, 0),
        this.makePokemon("Swirlix", "Fairy", null, 62, 48, 66, 59, 57, 49, 5, ["Fairy"], 50, ["Swirlix", "Slurpuff"], 0, -1),
        this.makePokemon("Slurpuff", "Fairy", null, 82, 80, 86, 85, 75, 72, 13, ["Fairy"], 50, ["Swirlix", "Slurpuff"], 1, 0),
        this.makePokemon("Inkay", "Dark", "Psychic", 53, 54, 53, 37, 46, 45, 6, ["Water 1", "Water 2"], 50, ["Inkay", "Malamar"], 0, 30),
        this.makePokemon("Malamar", "Dark", "Psychic", 86, 92, 88, 68, 75, 73, 20, ["Water 1", "Water 2"], 50, ["Inkay", "Malamar"], 1, 0),
        this.makePokemon("Binacle", "Rock", "Water", 42, 52, 67, 39, 56, 50, 17, ["Water 3"], 50, ["Binacle", "Barbaracle"], 0, 39),
        this.makePokemon("Barbaracle", "Rock", "Water", 72, 105, 115, 54, 86, 68, 27, ["Water 3"], 50, ["Binacle", "Barbaracle"], 1, 0),
        this.makePokemon("Skrelp", "Poison", "Water", 50, 60, 60, 60, 60, 30, 2, ["Water 1", "Dragon"], 50, ["Skrelp", "Dragalage"], 0, 48),
        this.makePokemon("Dragalage", "Poison", "Dragon", 65, 75, 90, 97, 123, 44, 25, ["Water 1", "Dragon"], 50, ["Skrelp", "Dragalage"], 1, 0),
        this.makePokemon("Clauncher", "Water", null, 50, 53, 62, 58, 63, 44, 2, ["Water 1", "Water 3"], 50, ["Clauncher", "Clawitzer"], 0, 37),
        this.makePokemon("Clawitzer", "Water", null, 71, 73, 88, 120, 89, 59, 25, ["Water 1", "Water 3"], 50, ["Clauncher", "Clawitzer"], 1, 0),
        this.makePokemon("Helioptile", "Electric", "Normal", 44, 38, 33, 61, 43, 70, 6, ["Monster", "Dragon"], 50, ["Helioptile", "Heliolisk"], 0, -1),
        this.makePokemon("Heliolisk", "Electric", "Normal", 62, 55, 52, 109, 94, 109, 21, ["Monster", "Dragon"], 50, ["Helioptile", "Heliolisk"], 1, 0),
        this.makePokemon("Tyrunt", "Rock", "Dragon", 58, 89, 77, 45, 45, 48, 27, ["Monster", "Dragon"], 87.5, ["Tyrunt", "Tyrantrum"], 0, 39),
        this.makePokemon("Tyrantrum", "Rock", "Dragon", 82, 121, 119, 69, 59, 71, 27, ["Monster", "Dragon"], 87.5, ["Tyrunt", "Tyrantrum"], 1, 0),
        this.makePokemon("Amaura", "Rock", "Ice", 77, 59, 50, 67, 63, 46, 27, ["Monster"], 87.5, ["Amaura", "Aurorus"], 0, 39),
        this.makePokemon("Aurorus", "Rock", "Ice", 123, 77, 72, 99, 92, 58, 27, ["Monster"], 87.5, ["Amaura", "Aurorus"], 1, 0),
        this.makePokemon("Sylveon", "Fairy", null, 95, 65, 65, 110, 130, 60, 27, ["Field"], 87.5, ["Eevee", "Sylveon"], 1, 0),
        this.makePokemon("Hawlucha", "Fighting", "Flying", 78, 92, 75, 74, 63, 118, 18, ["Human-Like"], 50, ["Hawlucha"], 0, 0),
        this.makePokemon("Dedenne", "Electric", "Fairy", 67, 58, 57, 81, 67, 101, 7, ["Field", "Fairy"], 50, ["Dedenne"], 0, 0),
        this.makePokemon("Carbink", "Rock", "Fairy", 50, 50, 150, 50, 150, 50, 24, ["Fairy", "Mineral"], -1, ["Carbink"], 0, 0),
        this.makePokemon("Goomy", "Dragon", null, 45, 50, 35, 55, 75, 40, 27, ["Dragon"], 50, ["Goomy", "Sliggoo", "Goodra"], 0, 40),
        this.makePokemon("Sliggoo", "Dragon", null, 68, 75, 53, 83, 113, 60, 27, ["Dragon"], 50, ["Goomy", "Sliggoo", "Goodra"], 1, 50),
        this.makePokemon("Goodra", "Dragon", null, 90, 100, 70, 110, 150, 80, 27, ["Dragon"], 50, ["Goomy", "Sliggoo", "Goodra"], 2, 0),
        this.makePokemon("Klefki", "Steel", "Fairy", 57, 80, 91, 80, 87, 75, 21, ["Mineral"], 50, ["Klefki"], 0, 0),
        this.makePokemon("Phantump", "Ghost", "Grass", 43, 70, 48, 50, 60, 38, 17, ["Grass", "Amorphous"], 50, ["Phantump", "Trevenant"], 0, -1),
        this.makePokemon("Trevenant", "Ghost", "Grass", 85, 110, 76, 65, 82, 56, 24, ["Grass", "Amorphous"], 50, ["Phantump", "Trevenant"], 1, 0),
        this.makePokemon("PumpkabooS", "Ghost", "Grass", 44, 66, 70, 44, 55, 56, 17, ["Amorphous"], 50, ["PumpkabooS", "GourgeistS"], 0, -1), // 730:710
        this.makePokemon("PumpkabooA", "Ghost", "Grass", 49, 66, 70, 44, 55, 51, 17, ["Amorphous"], 50, ["PumpkabooA", "GourgeistA"], 0, -1), // 731:710
        this.makePokemon("PumpkabooL", "Ghost", "Grass", 54, 66, 70, 44, 55, 46, 17, ["Amorphous"], 50, ["PumpkabooL", "GourgeistL"], 0, -1), // 732:710
        this.makePokemon("PumpkabooSS", "Ghost", "Grass", 59, 66, 70, 44, 55, 41, 17, ["Amorphous"], 50, ["PumpkabooSS", "GourgeistSS"], 0, -1), // 733:710
        this.makePokemon("GourgeistS", "Ghost", "Grass", 55, 85, 122, 58, 75, 99, 24, ["Amorphous"], 50, ["PumpkabooS", "GourgeistS"], 1, 0), // 734:711
        this.makePokemon("GourgeistA", "Ghost", "Grass", 65, 90, 122, 58, 75, 84, 24, ["Amorphous"], 50, ["PumpkabooA", "GourgeistA"], 1, 0), // 735:711
        this.makePokemon("GourgeistL", "Ghost", "Grass", 75, 95, 122, 58, 75, 69, 24, ["Amorphous"], 50, ["PumpkabooL", "GourgeistL"], 1, 0), // 736:711
        this.makePokemon("GourgeistSS", "Ghost", "Grass", 85, 100, 122, 58, 75, 54, 24, ["Amorphous"], 50, ["PumpkabooSS", "GourgeistSS"], 1, 0), // 737:711
        this.makePokemon("Bergmite", "Ice", null, 55, 69, 85, 32, 35, 28, 6, ["Monster"], 50, ["Bergmite", "Avalugg"], 0, 37),
        this.makePokemon("Avalugg", "Ice", null, 95, 117, 184, 44, 46, 28, 25, ["Monster"], 50, ["Bergmite", "Avalugg"], 1, 0),
        this.makePokemon("Noibat", "Flying", "Dragon", 40, 30, 35, 45, 40, 55, 6, ["Flying"], 50, ["Noibat", "Noivern"], 0, 48),
        this.makePokemon("Noivern", "Flying", "Dragon", 85, 70, 80, 97, 80, 123, 27, ["Flying"], 50, ["Noibat", "Noivern"], 1, 0),
        this.makePokemon("Xerneas", "Fairy", null, 126, 131, 95, 131, 98, 99, 27, ["Undiscovered"], -1, ["Xerneas"], 0, 0),
        this.makePokemon("Yveltal", "Dark", "Flying", 126, 131, 95, 131, 98, 99, 27, ["Undiscovered"], -1, ["Yveltal"], 0, 0),
        this.makePokemon("Zygarde10%", "Dragon", "Ground", 54, 100, 71, 61, 85, 115, 32, ["Undiscovered"], -1, ["Zygarde10%"], 0, 0), // 744:718
        this.makePokemon("Zygarde50%", "Dragon", "Ground", 108, 100, 121, 81, 95, 95, 32, ["Undiscovered"], -1, ["Zygarde50%"], 0, 0), // 745:718
        this.makePokemon("ZygardeC", "Dragon", "Ground", 216, 100, 121, 91, 95, 85, 32, ["Undiscovered"], -1, ["ZygardeC"], 0, 0), // 746:718
        this.makePokemon("Diancie", "Rock", "Fairy", 50, 100, 150, 100, 150, 50, 32, ["Undiscovered"], -1, ["Diancie"], 0, 0),
        this.makePokemon("HoopaC", "Psychic", "Ghost", 80, 110, 60, 150, 130, 70, 32, ["Undiscovered"], -1, ["HoopaC"], 0, 0), // 748:720
        this.makePokemon("HoopaU", "Psychic", "Dark", 80, 160, 60, 170, 130, 80, 32, ["Undiscovered"], -1, ["HoopaU"], 0, 0), // 749:720
        this.makePokemon("Volcanion", "Fire", "Water", 80, 110, 120, 130, 90, 70, 32, ["Undiscovered"], -1, ["Volcanion"], 0, 0),
        this.makePokemon("Rowlet", "Grass", "Flying", 68, 55, 55, 50, 50, 42, 27, ["Flying"], 87.5, ["Rowlet", "Dartrix", "Decidueye"], 0, 17),
        this.makePokemon("Dartrix", "Grass", "Flying", 78, 75, 75, 70, 70, 52, 27, ["Flying"], 87.5, ["Rowlet", "Dartrix", "Decidueye"], 1, 34),
        this.makePokemon("Decidueye", "Grass", "Ghost", 78, 107, 75, 100, 100, 70, 27, ["Flying"], 87.5, ["Rowlet", "Dartrix", "Decidueye"], 2, 0),
        this.makePokemon("Litten", "Fire", null, 45, 65, 40, 60, 40, 70, 27, ["Field"], 87.5, ["Litten", "Torracat", "Incineroar"], 0, 17),
        this.makePokemon("Torracat", "Fire", null, 65, 85, 50, 80, 50, 90, 27, ["Field"], 87.5, ["Litten", "Torracat", "Incineroar"], 1, 34),
        this.makePokemon("Incineroar", "Fire", "Dark", 95, 115, 90, 80, 90, 60, 27, ["Field"], 87.5, ["Litten", "Torracat", "Incineroar"], 2, 0),
        this.makePokemon("Popplio", "Water", null, 50, 54, 54, 66, 56, 40, 27, ["Water 1", "Field"], 87.5, ["Popplio", "Brionne", "Primarina"], 0, 17),
        this.makePokemon("Brionne", "Water", null, 60, 69, 69, 91, 81, 50, 27, ["Water 1", "Field"], 87.5, ["Popplio", "Brionne", "Primarina"], 1, 34),
        this.makePokemon("Primarina", "Water", "Fairy", 80, 74, 74, 126, 116, 80, 27, ["Water 1", "Field"], 87.5, ["Popplio", "Brionne", "Primarina"], 2, 0),
        this.makePokemon("Pikipek", "Normal", "Flying", 35, 75, 30, 30, 30, 65, 0, ["Flying"], 50, ["Pikipek", "Trumbeak", "Toucannon"], 0, 14),
        this.makePokemon("Trumbeak", "Normal", "Flying", 55, 85, 50, 40, 50, 75, 17, ["Flying"], 50, ["Pikipek", "Trumbeak", "Toucannon"], 1, 28),
        this.makePokemon("Toucannon", "Normal", "Flying", 80, 120, 75, 75, 75, 60, 27, ["Flying"], 50, ["Pikipek", "Trumbeak", "Toucannon"], 2, 0),
        this.makePokemon("Yungoos", "Normal", null, 48, 70, 30, 30, 30, 45, 0, ["Field"], 50, ["Yungoos", "Gumshoos"], 0, 20),
        this.makePokemon("Gumshoos", "Normal", null, 88, 110, 60, 55, 60, 45, 15, ["Field"], 50, ["Yungoos", "Gumshoos"], 1, 0),
        this.makePokemon("Grubbin", "Bug", null, 47, 62, 45, 55, 45, 46, 0, ["Bug"], 50, ["Grubbin", "Charjabug", "Vikavolt"], 0, 20),
        this.makePokemon("Charjabug", "Bug", "Electric", 57, 82, 95, 55, 75, 36, 17, ["Bug"], 50, ["Grubbin", "Charjabug", "Vikavolt"], 1, -1),
        this.makePokemon("Vikavolt", "Bug", "Electric", 77, 70, 90, 145, 75, 43, 27, ["Bug"], 50, ["Grubbin", "Charjabug", "Vikavolt"], 2, 0),
        this.makePokemon("Crabrawler", "Fighting", null, 47, 82, 57, 42, 47, 63, 2, ["Water 3"], 50, ["Crabrawler", "Crabominable"], 0, -1),
        this.makePokemon("Crabominable", "Fighting", "Ice", 97, 132, 77, 62, 67, 43, 24, ["Water 3"], 50, ["Crabrawler", "Crabominable"], 1, 0),
        this.makePokemon("OricorioB", "Fire", "Flying", 75, 70, 70, 98, 70, 93, 27, ["Flying"], 25, ["OricorioB"], 0, 0), // 770:741
        this.makePokemon("OricorioPP", "Electric", "Flying", 75, 70, 70, 98, 70, 93, 27, ["Flying"], 25, ["OricorioPP"], 0, 0), // 771:741
        this.makePokemon("OricorioP", "Psychic", "Flying", 75, 70, 70, 98, 70, 93, 27, ["Flying"], 25, ["OricorioP"], 0, 0), // 772:741
        this.makePokemon("OricorioS", "Ghost", "Flying", 75, 70, 70, 98, 70, 93, 27, ["Flying"], 25, ["OricorioS"], 0, 0), // 773:741
        this.makePokemon("Cutiefly", "Bug", "Fairy", 40, 45, 40, 55, 40, 84, 6, ["Bug", "Fairy"], 50, ["Cutiefly", "Ribombee"], 0, 25),
        this.makePokemon("Ribombee", "Bug", "Fairy", 60, 55, 60, 95, 70, 124, 21, ["Bug", "Fairy"], 50, ["Cutiefly", "Ribombee"], 1, 0),
        this.makePokemon("Rockruff", "Rock", null, 45, 65, 40, 30, 40, 60, 6, ["Field"], 50, ["Rockruff", "LycanrocMD"], 0, 25),
        this.makePokemon("LycanrocMD", "Rock", null, 75, 115, 65, 55, 65, 112, 19, ["Field"], 50, ["Rockruff", "LycanrocMD"], 1, 0), // 777:745
        this.makePokemon("LycanrocMN", "Rock", null, 85, 115, 75, 55, 75, 82, 19, ["Field"], 50, ["Rockruff", "LycanrocMN"], 1, 0), // 778:745
        this.makePokemon("LycanrocD", "Rock", null, 75, 117, 65, 55, 65, 110, 19, ["Field"], 50, ["Rockruff", "LycanrocD"], 1, 0), // 779:745
        this.makePokemon("WishiwashiSolo", "Water", null, 45, 20, 20, 25, 25, 40, 24, ["Water 2"], 50, ["WishiwashiSolo"], 0, 0), // 780:746
        this.makePokemon("WishiwashiSchool", "Water", null, 45, 140, 130, 140, 135, 30, 24, ["Water 2"], 50, ["WishiwashiSchool"], 0, 0), // 781:746
        this.makePokemon("Mareanie", "Poison", "Water", 50, 53, 62, 43, 52, 45, 6, ["Water 1"], 50, ["Mareanie", "Toxapex"], 0, 38),
        this.makePokemon("Toxapex", "Poison", "Water", 50, 63, 152, 53, 142, 35, 21, ["Water 1"], 50, ["Mareanie", "Toxapex"], 1, 0),
        this.makePokemon("Mudbray", "Ground", null, 70, 100, 70, 45, 55, 45, 6, ["Field"], 50, ["Mudbray", "Mudsdale"], 0, 30),
        this.makePokemon("Mudsdale", "Ground", null, 100, 125, 100, 55, 85, 35, 24, ["Field"], 50, ["Mudbray", "Mudsdale"], 1, 0),
        this.makePokemon("Dewpider", "Water", "Bug", 38, 40, 52, 40, 72, 27, 5, ["Water 1", "Bug"], 50, ["Dewpider", "Araquanid"], 0, 22),
        this.makePokemon("Araquanid", "Water", "Bug", 68, 70, 92, 50, 132, 42, 18, ["Water 1", "Bug"], 50, ["Dewpider", "Araquanid"], 1, 0),
        this.makePokemon("Fomantis", "Grass", null, 40, 55, 35, 50, 35, 35, 6, ["Grass"], 50, ["Fomantis", "Lurantis"], 0, 34),
        this.makePokemon("Lurantis", "Grass", null, 70, 105, 90, 80, 90, 45, 21, ["Grass"], 50, ["Fomantis", "Lurantis"], 1, 0),
        this.makePokemon("Morelull", "Grass", "Fairy", 40, 35, 55, 65, 75, 15, 6, ["Grass"], 50, ["Morelull", "Shiinotic"], 0, 24),
        this.makePokemon("Shiinotic", "Grass", "Fairy", 60, 45, 80, 90, 100, 30, 21, ["Grass"], 50, ["Morelull", "Shiinotic"], 1, 0),
        this.makePokemon("Salandit", "Poison", "Fire", 48, 44, 40, 71, 40, 77, 17, ["Monster", "Dragon"], 87.5, ["Salandit", "Salazzle"], 0, 33),
        this.makePokemon("Salazzle", "Poison", "Fire", 68, 64, 60, 111, 60, 117, 27, ["Monster", "Dragon"], 87.5, ["Salandit", "Salazzle"], 1, 0),
        this.makePokemon("Stufful", "Normal", "Fighting", 70, 75, 50, 45, 50, 50, 13, ["Field"], 50, ["Stufful", "Bewear"], 0, 27),
        this.makePokemon("Bewear", "Normal", "Fighting", 120, 125, 80, 55, 60, 60, 22, ["Field"], 50, ["Stufful", "Bewear"], 1, 0),
        this.makePokemon("Bounsweet", "Grass", null, 42, 30, 38, 30, 38, 32, 1, ["Grass"], 0, ["Bounsweet", "Steenee", "Tsareena"], 0, 18),
        this.makePokemon("Steenee", "Grass", null, 52, 40, 48, 40, 48, 62, 17, ["Grass"], 0, ["Bounsweet", "Steenee", "Tsareena"], 1, -1),
        this.makePokemon("Tsareena", "Grass", null, 72, 120, 98, 50, 98, 72, 27, ["Grass"], 0, ["Bounsweet", "Steenee", "Tsareena"], 2, 0),
        this.makePokemon("Comfey", "Fairy", null, 51, 52, 90, 82, 110, 100, 24, ["Grass"], 25, ["Comfey"], 0, 0),
        this.makePokemon("Oranguru", "Normal", "Psychic", 90, 60, 80, 90, 110, 60, 27, ["Field"], 50, ["Oranguru"], 0, 0),
        this.makePokemon("Passimian", "Fighting", null, 100, 120, 90, 40, 60, 80, 27, ["Field"], 50, ["Passimian"], 0, 0),
        this.makePokemon("Wimpod", "Bug", "Water", 25, 35, 40, 20, 30, 80, 19, ["Bug", "Water 3"], 50, ["Wimpod", "Golisopod"], 0, 30),
        this.makePokemon("Golisopod", "Bug", "Water", 75, 125, 140, 60, 90, 40, 27, ["Bug", "Water 3"], 50, ["Wimpod", "Golisopod"], 1, 0),
        this.makePokemon("Sandygast", "Ghost", "Ground", 55, 55, 80, 70, 45, 15, 13, ["Amorphous"], 50, ["Sandygast", "Palossand"], 0, 42),
        this.makePokemon("Palossand", "Ghost", "Ground", 85, 75, 110, 100, 75, 35, 24, ["Amorphous"], 50, ["Sandygast", "Palossand"], 1, 0),
        this.makePokemon("Pyukumuku", "Water", null, 55, 60, 130, 30, 130, 5, 24, ["Water 1"], 50, ["Pyukumuku"], 0, 0),
        this.makePokemon("Type: Null", "Normal", null, 95, 95, 95, 95, 95, 59, 32, ["Undiscovered"], -1, ["Type: Null", "Silvally"], 0, -1),
        this.makePokemon("Silvally", "Normal", null, 95, 95, 95, 95, 95, 95, 32, ["Undiscovered"], -1, ["Type: Null", "Silvally"], 1, 0),
        this.makePokemon("MiniorM", "Rock", "Flying", 60, 60, 100, 60, 100, 60, 29, ["Mineral"], -1, ["MiniorM"], 0, 0),
        this.makePokemon("MiniorC", "Rock", "Flying", 60, 100, 60, 100, 60, 120, 29, ["Mineral"], -1, ["MiniorC"], 0, 0),
        this.makePokemon("Komala", "Normal", null, 65, 115, 65, 75, 95, 65, 27, ["Field"], 50, ["Komala"], 0, 0),
        this.makePokemon("Turtonator", "Fire", "Dragon", 60, 78, 135, 91, 85, 36, 22, ["Monster", "Dragon"], 50, ["Turtonator"], 0, 0),
        this.makePokemon("Togedemaru", "Electric", "Steel", 65, 98, 63, 40, 73, 96, 7, ["Field", "Fairy"], 50, ["Togedemaru"], 0, 0),
        this.makePokemon("Mimikyu", "Ghost", "Fairy", 55, 90, 80, 50, 105, 96, 27, ["Amorphous"], 50, ["Mimikyu"], 0, 0),
        this.makePokemon("Bruxish", "Water", "Psychic", 68, 105, 70, 70, 70, 92, 20, ["Water 2"], 50, ["Bruxish"], 0, 0),
        this.makePokemon("Drampa", "Normal", "Dragon", 78, 60, 85, 135, 91, 36, 22, ["Monster", "Dragon"], 50, ["Drampa"], 0, 0),
        this.makePokemon("Dhelmise", "Ghost", "Grass", 70, 131, 100, 86, 90, 40, 30, ["Mineral"], -1, ["Dhelmise"], 0, 0),
        this.makePokemon("Jangmo-o", "Dragon", null, 45, 55, 65, 45, 45, 45, 27, ["Dragon"], 50, ["Jangmo-o", "Hakamo-o", "Kommo-o"], 0, 35),
        this.makePokemon("Hakamo-o", "Dragon", "Fighting", 55, 75, 90, 65, 70, 65, 27, ["Dragon"], 50, ["Jangmo-o", "Hakamo-o", "Kommo-o"], 1, 45),
        this.makePokemon("Kommo-o", "Dragon", "Fighting", 75, 110, 125, 100, 105, 85, 27, ["Dragon"], 50, ["Jangmo-o", "Hakamo-o", "Kommo-o"], 2, 0),
        this.makePokemon("Tapu Koko", "Electric", "Fairy", 70, 115, 85, 95, 75, 130, 32, ["Undiscovered"], -1, ["Tapu Koko"], 0, 0),
        this.makePokemon("Tapu Lele", "Psychic", "Fairy", 70, 85, 75, 130, 115, 95, 32, ["Undiscovered"], -1, ["Tapu Lele"], 0, 0),
        this.makePokemon("Tapu Bulu", "Grass", "Fairy", 70, 130, 115, 85, 95, 75, 32, ["Undiscovered"], -1, ["Tapu Bulu"], 0, 0),
        this.makePokemon("Tapu Fini", "Water", "Fairy", 70, 75, 115, 95, 130, 85, 32, ["Undiscovered"], -1, ["Tapu Fini"], 0, 0),
        this.makePokemon("Cosmog", "Psychic", null, 43, 29, 31, 29, 31, 37, 27, ["Undiscovered"], -1, ["Cosmog", "Cosmoem", "Solgaleo", "Lunala"], 0, 43),
        this.makePokemon("Cosmoem", "Psychic", null, 43, 29, 131, 29, 131, 27, 27, ["Undiscovered"], -1, ["Cosmog", "Cosmoem", "Solgaleo", "Lunala"], 1, 53),
        this.makePokemon("Solgaleo", "Psychic", "Steel", 137, 137, 107, 113, 89, 97, 27, ["Undiscovered"], -1, ["Cosmog", "Cosmoem", "Solgaleo"], 2, 0),
        this.makePokemon("Lunala", "Psychic", "Ghost", 137, 113, 89, 137, 107, 97, 27, ["Undiscovered"], -1, ["Cosmog", "Cosmoem", "Solgaleo"], 2, 0),
        this.makePokemon("Nihilego", "Rock", "Poison", 109, 53, 47, 127, 131, 103, 27, ["Undiscovered"], -1, ["Nihilego"], 0, 0),
        this.makePokemon("Buzzwole", "Bug", "Fighting", 107, 139, 139, 53, 53, 79, 27, ["Undiscovered"], -1, ["Buzzwole"], 0, 0),
        this.makePokemon("Pheromosa", "Bug", "Fighting", 71, 137, 37, 137, 37, 151, 27, ["Undiscovered"], -1, ["Pheromosa"], 0, 0),
        this.makePokemon("Xurkitree", "Electric", null, 83, 89, 71, 173, 71, 83, 27, ["Undiscovered"], -1, ["Xurkitree"], 0, 0),
        this.makePokemon("Celesteela", "Steel", "Flying", 97, 101, 103, 107, 101, 61, 27, ["Undiscovered"], -1, ["Celesteela"], 0, 0),
        this.makePokemon("Kartana", "Grass", "Steel", 59, 181, 131, 59, 31, 109, 27, ["Undiscovered"], -1, ["Kartana"], 0, 0),
        this.makePokemon("Guzzlord", "Dark", "Dragon", 223, 101, 53, 97, 53, 43, 27, ["Undiscovered"], -1, ["Guzzlord"], 0, 0),
        this.makePokemon("Necrozma", "Psychic", null, 97, 107, 101, 127, 89, 79, 32, ["Undiscovered"], -1, ["Necrozma"], 0, 0), // 835:800
        this.makePokemon("NecrozmaDM", "Psychic", "Steel", 97, 157, 127, 113, 109, 77, 32, ["Undiscovered"], -1, ["NecrozmaDM"], 0, 0), // 836:800
        this.makePokemon("NecrozmaDW", "Psychic", "Ghost", 97, 113, 109, 157, 127, 77, 32, ["Undiscovered"], -1, ["NecrozmaDW"], 0, 0), // 837:800
        this.makePokemon("NecrozmaU", "Psychic", "Dragon", 97, 167, 97, 167, 97, 129, 32, ["Undiscovered"], -1, ["NecrozmaU"], 0, 0), // 838:800
        this.makePokemon("Magearna", "Steel", "Fairy", 80, 95, 115, 130, 115, 65, 32, ["Undiscovered"], -1, ["Magearna"], 0, 0),
        this.makePokemon("Marshadow", "Fighting", "Ghost", 90, 125, 80, 90, 90, 125, 32, ["Undiscovered"], -1, ["Marshadow"], 0, 0),
        this.makePokemon("Poipole", "Poison", null, 67, 73, 67, 73, 67, 73, 27, ["Undiscovered"], -1, ["Poipole", "Naganadel"], 0, -1),
        this.makePokemon("Naganadel", "Poison", "Dragon", 73, 73, 73, 127, 73, 121, 27, ["Undiscovered"], -1, ["Poipole", "Naganadel"], 1, 0),
        this.makePokemon("Stakataka", "Rock", "Steel", 61, 131, 211, 53, 101, 13, 29, ["Undiscovered"], -1, ["Stakataka"], 0, 0),
        this.makePokemon("Blacephalon", "Fire", "Ghost", 53, 127, 53, 151, 79, 107, 29, ["Undiscovered"], -1, ["Blacephalon"], 0, 0),
        this.makePokemon("Zeraora", "Electric", null, 88, 112, 75, 102, 80, 143, 32, ["Undiscovered"], -1, ["Zeraora"], 0, 0),
        this.makePokemon("Meltan", "Steel", null, 46, 65, 65, 55, 35, 34, 32, ["Undiscovered"], -1, ["Meltan", "Melmetal"], 0, -1),
        this.makePokemon("Melmetal", "Steel", null, 135, 143, 143, 80, 65, 34, 32, ["Undiscovered"], -1, ["Meltan", "Melmetal"], 1, 0)];
        return pokedex;
    }

    makeOwnedPokemon = (pokemon) => {
        var shiny, gender, natureArr;
        if (Math.round(Math.random() * 4096) === 0)
            shiny = true;
        else
            shiny = false;
        if (pokemon.genderRatio < 0)
            gender = "Genderless";
        else {
            if (((Math.round(Math.random() * 1000 + 1)) / 10) <= pokemon.genderRatio)
                gender = "Male";
            else
                gender = "Female";
        }
        natureArr = ["Hardy", "Lonely", "Brave", "Adamant", "Naughty", "Bold", "Docile", "Relaxed", "Impish", "Lax", "Timid", "Hasty", "Serious", "Jolly", "Naive", "Modest", "Mild", "Quiet", "Bashful", "Rash", "Calm", "Gentle", "Sassy", "Careful", "Quirky"]
        var ownedPokemon = {
            pokemon: pokemon,
            nickname: pokemon.name,
            level: Math.round(Math.random() * 20) + 1,
            shiny: shiny,
            gender: gender,
            healthIV: Math.round(Math.random() * 32),
            attackIV: Math.round(Math.random() * 32),
            defenseIV: Math.round(Math.random() * 32),
            specialAttackIV: Math.round(Math.random() * 32),
            specialDefenseIV: Math.round(Math.random() * 32),
            speedIV: Math.round(Math.random() * 32),
            healthEV: 0,
            attackEV: 0,
            defenseEV: 0,
            specialAttackEV: 0,
            specialDefenseEV: 0,
            speedEV: 0,
            healthStat: 0,
            attackStat: 0,
            defenseStat: 0,
            specialAttackStat: 0,
            specialDefenseStat: 0,
            speedStat: 0,
            nature: natureArr[Math.floor(Math.random() * 25)],
            favorite: false,
            evoLock: false,
            t1PointsInvested: 0,
            t2PointsInvested: 0,
            t3PointsInvested: 0,
            t4PointsInvested: 0,
            t5PointsInvested: 0,
            calculateStats: function () {
                if (this.pokemon.name === "Shedinja") {
                    this.healthStat = 1;
                } else {
                    this.healthStat = Math.round(((2 * this.pokemon.baseHealth + this.healthIV + (this.healthEV / 4)) * this.level) / 100) + this.level + 10;
                }
                switch (this.nature) {
                    case "Hardy":
                    case "Docile":
                    case "Serious":
                    case "Bashful":
                    case "Quirky":
                        this.attackStat = Math.round(((2 * this.pokemon.baseAttack + this.attackIV + (this.attackEV / 4)) * this.level) / 100) + 5;
                        this.defenseStat = Math.round(((2 * this.pokemon.baseDefense + this.defenseIV + (this.defenseEV / 4)) * this.level) / 100) + 5;
                        this.specialAttackStat = Math.round(((2 * this.pokemon.baseSpecialAttack + this.specialAttackIV + (this.specialAttackEV / 4)) * this.level) / 100) + 5;
                        this.specialDefenseStat = Math.round(((2 * this.pokemon.baseSpecialDefense + this.specialDefenseIV + (this.specialDefenseEV / 4)) * this.level) / 100) + 5;
                        this.speedStat = Math.round(((2 * this.pokemon.baseSpeed + this.speedIV + (this.speedEV / 4)) * this.level) / 100) + 5;
                        break;
                    case "Lonely":
                        this.attackStat = Math.round((((((2 * this.pokemon.baseAttack + this.attackIV + (this.attackEV / 4)) * this.level) / 100) + 5) * 1.1));
                        this.defenseStat = Math.round((((((2 * this.pokemon.baseDefense + this.defenseIV + (this.defenseEV / 4)) * this.level) / 100) + 5) * .9));
                        this.specialAttackStat = Math.round(((2 * this.pokemon.baseSpecialAttack + this.specialAttackIV + (this.specialAttackEV / 4)) * this.level) / 100) + 5;
                        this.specialDefenseStat = Math.round(((2 * this.pokemon.baseSpecialDefense + this.specialDefenseIV + (this.specialDefenseEV / 4)) * this.level) / 100) + 5;
                        this.speedStat = Math.round(((2 * this.pokemon.baseSpeed + this.speedIV + (this.speedEV / 4)) * this.level) / 100) + 5;
                        break;
                    case "Brave":
                        this.attackStat = Math.round((((((2 * this.pokemon.baseAttack + this.attackIV + (this.attackEV / 4)) * this.level) / 100) + 5) * 1.1));
                        this.defenseStat = Math.round(((2 * this.pokemon.baseDefense + this.defenseIV + (this.defenseEV / 4)) * this.level) / 100) + 5;
                        this.specialAttackStat = Math.round(((2 * this.pokemon.baseSpecialAttack + this.specialAttackIV + (this.specialAttackEV / 4)) * this.level) / 100) + 5;
                        this.specialDefenseStat = Math.round(((2 * this.pokemon.baseSpecialDefense + this.specialDefenseIV + (this.specialDefenseEV / 4)) * this.level) / 100) + 5;
                        this.speedStat = Math.round((((((2 * this.pokemon.baseSpeed + this.speedIV + (this.speedEV / 4)) * this.level) / 100) + 5) * .9));
                        break;
                    case "Adamant":
                        this.attackStat = Math.round((((((2 * this.pokemon.baseAttack + this.attackIV + (this.attackEV / 4)) * this.level) / 100) + 5) * 1.1));
                        this.defenseStat = Math.round(((2 * this.pokemon.baseDefense + this.defenseIV + (this.defenseEV / 4)) * this.level) / 100) + 5;
                        this.specialAttackStat = Math.round((((((2 * this.pokemon.baseSpecialAttack + this.specialAttackIV + (this.specialAttackEV / 4)) * this.level) / 100) + 5) * .9));
                        this.specialDefenseStat = Math.round(((2 * this.pokemon.baseSpecialDefense + this.specialDefenseIV + (this.specialDefenseEV / 4)) * this.level) / 100) + 5;
                        this.speedStat = Math.round(((2 * this.pokemon.baseSpeed + this.speedIV + (this.speedEV / 4)) * this.level) / 100) + 5;
                        break;
                    case "Naughty":
                        this.attackStat = Math.round((((((2 * this.pokemon.baseAttack + this.attackIV + (this.attackEV / 4)) * this.level) / 100) + 5) * 1.1));
                        this.defenseStat = Math.round(((2 * this.pokemon.baseDefense + this.defenseIV + (this.defenseEV / 4)) * this.level) / 100) + 5;
                        this.specialAttackStat = Math.round(((2 * this.pokemon.baseSpecialAttack + this.specialAttackIV + (this.specialAttackEV / 4)) * this.level) / 100) + 5;
                        this.specialDefenseStat = Math.round((((((2 * this.pokemon.baseSpecialDefense + this.specialDefenseIV + (this.specialDefenseEV / 4)) * this.level) / 100) + 5) * .9));
                        this.speedStat = Math.round(((2 * this.pokemon.baseSpeed + this.speedIV + (this.speedEV / 4)) * this.level) / 100) + 5;
                        break;
                    case "Bold":
                        this.attackStat = Math.round((((((2 * this.pokemon.baseAttack + this.attackIV + (this.attackEV / 4)) * this.level) / 100) + 5) * .9));
                        this.defenseStat = Math.round((((((2 * this.pokemon.baseDefense + this.defenseIV + (this.defenseEV / 4)) * this.level) / 100) + 5) * 1.1));
                        this.specialAttackStat = Math.round(((2 * this.pokemon.baseSpecialAttack + this.specialAttackIV + (this.specialAttackEV / 4)) * this.level) / 100) + 5;
                        this.specialDefenseStat = Math.round(((2 * this.pokemon.baseSpecialDefense + this.specialDefenseIV + (this.specialDefenseEV / 4)) * this.level) / 100) + 5;
                        this.speedStat = Math.round(((2 * this.pokemon.baseSpeed + this.speedIV + (this.speedEV / 4)) * this.level) / 100) + 5;
                        break;
                    case "Relaxed":
                        this.attackStat = Math.round(((2 * this.pokemon.baseAttack + this.attackIV + (this.attackEV / 4)) * this.level) / 100) + 5;
                        this.defenseStat = Math.round((((((2 * this.pokemon.baseDefense + this.defenseIV + (this.defenseEV / 4)) * this.level) / 100) + 5) * 1.1));
                        this.specialAttackStat = Math.round(((2 * this.pokemon.baseSpecialAttack + this.specialAttackIV + (this.specialAttackEV / 4)) * this.level) / 100) + 5;
                        this.specialDefenseStat = Math.round(((2 * this.pokemon.baseSpecialDefense + this.specialDefenseIV + (this.specialDefenseEV / 4)) * this.level) / 100) + 5;
                        this.speedStat = Math.round((((((2 * this.pokemon.baseSpeed + this.speedIV + (this.speedEV / 4)) * this.level) / 100) + 5) * .9));
                        break;
                    case "Impish":
                        this.attackStat = Math.round(((2 * this.pokemon.baseAttack + this.attackIV + (this.attackEV / 4)) * this.level) / 100) + 5;
                        this.defenseStat = Math.round((((((2 * this.pokemon.baseDefense + this.defenseIV + (this.defenseEV / 4)) * this.level) / 100) + 5) * 1.1));
                        this.specialAttackStat = Math.round((((((2 * this.pokemon.baseSpecialAttack + this.specialAttackIV + (this.specialAttackEV / 4)) * this.level) / 100) + 5) * .9));
                        this.specialDefenseStat = Math.round(((2 * this.pokemon.baseSpecialDefense + this.specialDefenseIV + (this.specialDefenseEV / 4)) * this.level) / 100) + 5;
                        this.speedStat = Math.round(((2 * this.pokemon.baseSpeed + this.speedIV + (this.speedEV / 4)) * this.level) / 100) + 5;
                        break;
                    case "Lax":
                        this.attackStat = Math.round(((2 * this.pokemon.baseAttack + this.attackIV + (this.attackEV / 4)) * this.level) / 100) + 5;
                        this.defenseStat = Math.round((((((2 * this.pokemon.baseDefense + this.defenseIV + (this.defenseEV / 4)) * this.level) / 100) + 5) * 1.1));
                        this.specialAttackStat = Math.round(((2 * this.pokemon.baseSpecialAttack + this.specialAttackIV + (this.specialAttackEV / 4)) * this.level) / 100) + 5;
                        this.specialDefenseStat = Math.round((((((2 * this.pokemon.baseSpecialDefense + this.specialDefenseIV + (this.specialDefenseEV / 4)) * this.level) / 100) + 5) * .9));
                        this.speedStat = Math.round(((2 * this.pokemon.baseSpeed + this.speedIV + (this.speedEV / 4)) * this.level) / 100) + 5;
                        break;
                    case "Timid":
                        this.attackStat = Math.round((((((2 * this.pokemon.baseAttack + this.attackIV + (this.attackEV / 4)) * this.level) / 100) + 5) * .9));
                        this.defenseStat = Math.round(((2 * this.pokemon.baseDefense + this.defenseIV + (this.defenseEV / 4)) * this.level) / 100) + 5;
                        this.specialAttackStat = Math.round(((2 * this.pokemon.baseSpecialAttack + this.specialAttackIV + (this.specialAttackEV / 4)) * this.level) / 100) + 5;
                        this.specialDefenseStat = Math.round(((2 * this.pokemon.baseSpecialDefense + this.specialDefenseIV + (this.specialDefenseEV / 4)) * this.level) / 100) + 5;
                        this.speedStat = Math.round((((((2 * this.pokemon.baseSpeed + this.speedIV + (this.speedEV / 4)) * this.level) / 100) + 5) * 1.1));
                        break;
                    case "Hasty":
                        this.attackStat = Math.round(((2 * this.pokemon.baseAttack + this.attackIV + (this.attackEV / 4)) * this.level) / 100) + 5;
                        this.defenseStat = Math.round((((((2 * this.pokemon.baseDefense + this.defenseIV + (this.defenseEV / 4)) * this.level) / 100) + 5) * .9));
                        this.specialAttackStat = Math.round(((2 * this.pokemon.baseSpecialAttack + this.specialAttackIV + (this.specialAttackEV / 4)) * this.level) / 100) + 5;
                        this.specialDefenseStat = Math.round(((2 * this.pokemon.baseSpecialDefense + this.specialDefenseIV + (this.specialDefenseEV / 4)) * this.level) / 100) + 5;
                        this.speedStat = Math.round((((((2 * this.pokemon.baseSpeed + this.speedIV + (this.speedEV / 4)) * this.level) / 100) + 5) * 1.1));
                        break;
                    case "Jolly":
                        this.attackStat = Math.round(((2 * this.pokemon.baseAttack + this.attackIV + (this.attackEV / 4)) * this.level) / 100) + 5;
                        this.defenseStat = Math.round(((2 * this.pokemon.baseDefense + this.defenseIV + (this.defenseEV / 4)) * this.level) / 100) + 5;
                        this.specialAttackStat = Math.round((((((2 * this.pokemon.baseSpecialAttack + this.specialAttackIV + (this.specialAttackEV / 4)) * this.level) / 100) + 5) * .9));
                        this.specialDefenseStat = Math.round(((2 * this.pokemon.baseSpecialDefense + this.specialDefenseIV + (this.specialDefenseEV / 4)) * this.level) / 100) + 5;
                        this.speedStat = Math.round((((((2 * this.pokemon.baseSpeed + this.speedIV + (this.speedEV / 4)) * this.level) / 100) + 5) * 1.1));
                        break;
                    case "Naive":
                        this.attackStat = Math.round(((2 * this.pokemon.baseAttack + this.attackIV + (this.attackEV / 4)) * this.level) / 100) + 5;
                        this.defenseStat = Math.round(((2 * this.pokemon.baseDefense + this.defenseIV + (this.defenseEV / 4)) * this.level) / 100) + 5;
                        this.specialAttackStat = Math.round(((2 * this.pokemon.baseSpecialAttack + this.specialAttackIV + (this.specialAttackEV / 4)) * this.level) / 100) + 5;
                        this.specialDefenseStat = Math.round((((((2 * this.pokemon.baseSpecialDefense + this.specialDefenseIV + (this.specialDefenseEV / 4)) * this.level) / 100) + 5) * .9));
                        this.speedStat = Math.round((((((2 * this.pokemon.baseSpeed + this.speedIV + (this.speedEV / 4)) * this.level) / 100) + 5) * 1.1));
                        break;
                    case "Modest":
                        this.attackStat = Math.round((((((2 * this.pokemon.baseAttack + this.attackIV + (this.attackEV / 4)) * this.level) / 100) + 5) * .9));
                        this.defenseStat = Math.round(((2 * this.pokemon.baseDefense + this.defenseIV + (this.defenseEV / 4)) * this.level) / 100) + 5;
                        this.specialAttackStat = Math.round((((((2 * this.pokemon.baseSpecialAttack + this.specialAttackIV + (this.specialAttackEV / 4)) * this.level) / 100) + 5) * 1.1));
                        this.specialDefenseStat = Math.round(((2 * this.pokemon.baseSpecialDefense + this.specialDefenseIV + (this.specialDefenseEV / 4)) * this.level) / 100) + 5;
                        this.speedStat = Math.round(((2 * this.pokemon.baseSpeed + this.speedIV + (this.speedEV / 4)) * this.level) / 100) + 5;
                        break;
                    case "Mild":
                        this.attackStat = Math.round(((2 * this.pokemon.baseAttack + this.attackIV + (this.attackEV / 4)) * this.level) / 100) + 5;
                        this.defenseStat = Math.round((((((2 * this.pokemon.baseDefense + this.defenseIV + (this.defenseEV / 4)) * this.level) / 100) + 5) * .9));
                        this.specialAttackStat = Math.round((((((2 * this.pokemon.baseSpecialAttack + this.specialAttackIV + (this.specialAttackEV / 4)) * this.level) / 100) + 5) * 1.1));
                        this.specialDefenseStat = Math.round(((2 * this.pokemon.baseSpecialDefense + this.specialDefenseIV + (this.specialDefenseEV / 4)) * this.level) / 100) + 5;
                        this.speedStat = Math.round(((2 * this.pokemon.baseSpeed + this.speedIV + (this.speedEV / 4)) * this.level) / 100) + 5;
                        break;
                    case "Quiet":
                        this.attackStat = Math.round(((2 * this.pokemon.baseAttack + this.attackIV + (this.attackEV / 4)) * this.level) / 100) + 5;
                        this.defenseStat = Math.round(((2 * this.pokemon.baseDefense + this.defenseIV + (this.defenseEV / 4)) * this.level) / 100) + 5;
                        this.specialAttackStat = Math.round((((((2 * this.pokemon.baseSpecialAttack + this.specialAttackIV + (this.specialAttackEV / 4)) * this.level) / 100) + 5) * 1.1));
                        this.specialDefenseStat = Math.round(((2 * this.pokemon.baseSpecialDefense + this.specialDefenseIV + (this.specialDefenseEV / 4)) * this.level) / 100) + 5;
                        this.speedStat = Math.round((((((2 * this.pokemon.baseSpeed + this.speedIV + (this.speedEV / 4)) * this.level) / 100) + 5) * .9));
                        break;
                    case "Rash":
                        this.attackStat = Math.round(((2 * this.pokemon.baseAttack + this.attackIV + (this.attackEV / 4)) * this.level) / 100) + 5;
                        this.defenseStat = Math.round(((2 * this.pokemon.baseDefense + this.defenseIV + (this.defenseEV / 4)) * this.level) / 100) + 5;
                        this.specialAttackStat = Math.round((((((2 * this.pokemon.baseSpecialAttack + this.specialAttackIV + (this.specialAttackEV / 4)) * this.level) / 100) + 5) * 1.1));
                        this.specialDefenseStat = Math.round((((((2 * this.pokemon.baseSpecialDefense + this.specialDefenseIV + (this.specialDefenseEV / 4)) * this.level) / 100) + 5) * .9));
                        this.speedStat = Math.round(((2 * this.pokemon.baseSpeed + this.speedIV + (this.speedEV / 4)) * this.level) / 100) + 5;
                        break;
                    case "Calm":
                        this.attackStat = Math.round((((((2 * this.pokemon.baseAttack + this.attackIV + (this.attackEV / 4)) * this.level) / 100) + 5) * .9));
                        this.defenseStat = Math.round(((2 * this.pokemon.baseDefense + this.defenseIV + (this.defenseEV / 4)) * this.level) / 100) + 5;
                        this.specialAttackStat = Math.round(((2 * this.pokemon.baseSpecialAttack + this.specialAttackIV + (this.specialAttackEV / 4)) * this.level) / 100) + 5;
                        this.specialDefenseStat = Math.round((((((2 * this.pokemon.baseSpecialDefense + this.specialDefenseIV + (this.specialDefenseEV / 4)) * this.level) / 100) + 5) * 1.1));
                        this.speedStat = Math.round(((2 * this.pokemon.baseSpeed + this.speedIV + (this.speedEV / 4)) * this.level) / 100) + 5;
                        break;
                    case "Gentle":
                        this.attackStat = Math.round(((2 * this.pokemon.baseAttack + this.attackIV + (this.attackEV / 4)) * this.level) / 100) + 5;
                        this.defenseStat = Math.round((((((2 * this.pokemon.baseDefense + this.defenseIV + (this.defenseEV / 4)) * this.level) / 100) + 5) * .9));
                        this.specialAttackStat = Math.round(((2 * this.pokemon.baseSpecialAttack + this.specialAttackIV + (this.specialAttackEV / 4)) * this.level) / 100) + 5;
                        this.specialDefenseStat = Math.round((((((2 * this.pokemon.baseSpecialDefense + this.specialDefenseIV + (this.specialDefenseEV / 4)) * this.level) / 100) + 5) * 1.1));
                        this.speedStat = Math.round(((2 * this.pokemon.baseSpeed + this.speedIV + (this.speedEV / 4)) * this.level) / 100) + 5;
                        break;
                    case "Sassy":
                        this.attackStat = Math.round(((2 * this.pokemon.baseAttack + this.attackIV + (this.attackEV / 4)) * this.level) / 100) + 5;
                        this.defenseStat = Math.round(((2 * this.pokemon.baseDefense + this.defenseIV + (this.defenseEV / 4)) * this.level) / 100) + 5;
                        this.specialAttackStat = Math.round(((2 * this.pokemon.baseSpecialAttack + this.specialAttackIV + (this.specialAttackEV / 4)) * this.level) / 100) + 5;
                        this.specialDefenseStat = Math.round((((((2 * this.pokemon.baseSpecialDefense + this.specialDefenseIV + (this.specialDefenseEV / 4)) * this.level) / 100) + 5) * 1.1));
                        this.speedStat = Math.round((((((2 * this.pokemon.baseSpeed + this.speedIV + (this.speedEV / 4)) * this.level) / 100) + 5) * .9));
                        break;
                    case "Careful":
                        this.attackStat = Math.round(((2 * this.pokemon.baseAttack + this.attackIV + (this.attackEV / 4)) * this.level) / 100) + 5;
                        this.defenseStat = Math.round(((2 * this.pokemon.baseDefense + this.defenseIV + (this.defenseEV / 4)) * this.level) / 100) + 5;
                        this.specialAttackStat = Math.round((((((2 * this.pokemon.baseSpecialAttack + this.specialAttackIV + (this.specialAttackEV / 4)) * this.level) / 100) + 5) * .9));
                        this.specialDefenseStat = Math.round((((((2 * this.pokemon.baseSpecialDefense + this.specialDefenseIV + (this.specialDefenseEV / 4)) * this.level) / 100) + 5) * 1.1));
                        this.speedStat = Math.round(((2 * this.pokemon.baseSpeed + this.speedIV + (this.speedEV / 4)) * this.level) / 100) + 5;
                        break;
                }
            }
        }
        return ownedPokemon;
    }

    search = (pokedex, playerDex, spawnRateCounter) => {
        let num = Math.floor(Math.random() * pokedex.length);
        while (spawnRateCounter[pokedex[num].spawnRate] !== pokedex[num].spawnRate) {
            spawnRateCounter[pokedex[num].spawnRate] = spawnRateCounter[pokedex[num].spawnRate] + 1;
            num = Math.floor(Math.random() * pokedex.length);
        }
        spawnRateCounter[pokedex[num].spawnRate] = 0;
        playerDex.push(this.makeOwnedPokemon(pokedex[num]));
        playerDex[playerDex.length - 1].calculateStats();

        let str = "";

        const aplle = playerDex.sort((o1, o2) => (o1.attackStat - o2.attackStat));

        aplle.forEach(
            function (element) {
                str += element.nickname + ": " + element.attackStat;
                str += "<br>";
            });

        str = str.substring(0, str.length - 4);

        return str;
    }

    render() {
        var pokedex = this.makePokedex;
        var playerDex = [];
        var spawnRateCounter = Array(25).fill(0);

        return (
            <div>
                <button onClick={document.getElementById("output").innerHTML = this.search(pokedex, playerDex, spawnRateCounter)}>Search</button>
                <div id="output"></div>
            </div>
        )
    }
}

export default Search