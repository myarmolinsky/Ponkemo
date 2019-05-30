import java.io.Serializable;
import java.util.Comparator;

public class LevelOrder implements Comparator<OwnedPokemon>, Serializable {

	public int compare(OwnedPokemon o1, OwnedPokemon o2) {
		return o2.getLevel() - o1.getLevel();
	}

}
