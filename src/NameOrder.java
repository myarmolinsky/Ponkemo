import java.io.Serializable;
import java.util.Comparator;

public class NameOrder implements Comparator<OwnedPokemon>, Serializable {

	public int compare(OwnedPokemon o1, OwnedPokemon o2) {
		return o1.getName().compareTo(o2.getName());
	}

}
