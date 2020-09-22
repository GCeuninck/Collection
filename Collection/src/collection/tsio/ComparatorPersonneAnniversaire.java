package collection.tsio;

import java.util.Comparator;

public class ComparatorPersonneAnniversaire implements Comparator<Personne>{

	@Override
	public int compare(Personne p1, Personne p2) {
		return p1.getAnniversaire().getTime().compareTo(p2.getAnniversaire().getTime());
	}


}
