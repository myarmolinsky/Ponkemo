import java.io.Serializable;
import java.util.Comparator;

public class NicknameOrder implements Comparator<OwnedPokemon>, Serializable {

	public int compare(OwnedPokemon o1, OwnedPokemon o2) {
		return o1.getNickname().compareTo(o2.getNickname());
	}

}
