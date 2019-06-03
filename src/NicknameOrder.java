import java.io.Serializable;
import java.util.Comparator;

public class NicknameOrder implements Comparator<OwnedPokemon>, Serializable {

	public int compare(OwnedPokemon o1, OwnedPokemon o2) {
		// for sorting Pokemon in order alphabetically by their nickname
		return o1.getNickname().compareTo(o2.getNickname());
	}

}
