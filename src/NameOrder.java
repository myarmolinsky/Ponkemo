import java.io.Serializable;
import java.util.Comparator;

public class NameOrder implements Comparator<OwnedPokemon>, Serializable {

	public int compare(OwnedPokemon o1, OwnedPokemon o2) {
		// for sorting Pokemon in order alphabetically by their real name
		return o1.getName().compareTo(o2.getName());
	}

}
