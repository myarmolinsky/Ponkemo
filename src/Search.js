import React, { Component } from 'react'
import pokedex from './Pokedex'

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
        var playerDex = [];
        var spawnRateCounter = Array(25).fill(0);
        var str = "";

        return (
            <div>
                <button onClick={() => { str = this.search(pokedex, playerDex, spawnRateCounter) }}>Search</button>
                <div id="output">{str}</div>
            </div >
        )
    }
}

export default Search