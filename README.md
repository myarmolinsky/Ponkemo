# Ponkemo

This program is my own take on the Pokemon franchise.  While I love the Pokemon franchise, I could never seem to find all the features I enjoy in any of the games, be it a game from the main series or a spinoff game or a fanmade game or mod.  So I have decided to try to implement everything I would look for in a Pokemon game into this project.

Implemented Features:
-
- Menu: An easy to navigate menu which just requires the user to input a number corresponding to their choice
- Catch Pokemon: Every Pokemon has a rarity.  Choosing to catch a Pokemon generates a random number and adds it to its corresponding index in an array.  Upon the idnex reaching its maximum (the number at the index equals the index), the user will receive a Pokemon of that rarity.  The rarer Pokemon require higher numbers to be rolled.
- Nicknaming Pokemon: Nickname your Pokemon whatever you like!  Simply go into your PC and choose the Pokemon you would like to edit.
- View your PC: Open up your PC and look at all the Pokemon you have caught.  Choose any Pokemon in your PC and see all of its important information, including its IVs, its egg group, and whether it is shiny or not.
- Sort your PC: Sort your PC in order by the Pokemon's real name, nickname, level, or IVs.
- Breeding your Pokemon: Choose two Pokemon in your pc who are able to breed together (matching egg group and opposite genders (or both Pokemon are genderless)).  You can also breed legendaries!  When you breed two Pokemon, you lose both of them, but the baby Pokemon that is born from them is guaranteed to have the best of both parents' IVs.
- Recycle Pokemon: Pokemon are separated into 5 tiers depending on their rarity.  You can choose any Pokemon in your PC to recycle and you will get points of the Pokemon's rarity equivalent to one tenth of the Pokemon's IV percentage.  You will also get a partial refund of any points you invested into the Pokemonin training it.
- Train Pokemon: Choose a Pokemon in your PC and train it.  You can choose to level it up or to invest in its EVs.  Both actions costs you points of the same Tier as the Pokemon.  The Pokemon's stats change relative to its level, EV distribution, and IV distribution just like in the actual games.
- Convert Tier Points: Turn many points of a lower tier and turn them into a point of a higher tier, or turn a point of a higher tier into many points of a lower tier.
- View Player Data: See how many Pokemon you own and how many points of each tier you have.
- Save the game: You can locally save the game by choosing the "Save" or "Save Quit" options.  This way, you can keep playing on the same profile next time you decide to play.  The save file gets saved to the same directory as the jar file, so it is recommended that you put the jar file into its own directory.  If you are unhappy with the progress you have made or feel like you have made a mistake, you can quit the game without saving too.

To play:
-
To play the game, clone the repository into your editor and run it.  Once you have the repository cloned, you can also export it as a .jar file.  You can also find the jar file included in the repository when you clone it.  To run the jar file, follow these steps:
1. Open your console
2. cd into the folder with the jar file
3. Type "java -jar filename.jar" and press enter
4. Enjoy!

I stopped working on the project after implementing every Pokemon and all of the above features, although I would like to add a front-end and to deploy the project as a website with multiplayer aspects including trading and battling.  I expect to come back to this project in the future and implement those features, as well as any others I can think of to improve the game.
