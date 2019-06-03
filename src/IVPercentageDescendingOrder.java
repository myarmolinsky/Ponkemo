import java.io.Serializable;
import java.util.Comparator;

public class IVPercentageDescendingOrder implements Comparator<OwnedPokemon>, Serializable {

	public int compare(OwnedPokemon o1, OwnedPokemon o2) {
		// for sorting Pokemon in order by descending IV percentage
		if (o1.getTotalIVPercentage() > o2.getTotalIVPercentage())
			return -1;
		if (o1.getTotalIVPercentage() < o2.getTotalIVPercentage())
			return 1;
		return 0;
	}

}
