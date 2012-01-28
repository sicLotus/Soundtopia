package music.util;

import java.util.ArrayList;
import java.util.List;

public class ListUtilities {

	private ListUtilities() {

	}

	public static <E> List<E> getEqualSongsInLists(List<E> a, List<E> b) {
		List<E> result = new ArrayList<E>();
		for (E sa : a) {
			for (E sb : b) {
				if (sa.equals(sb)) {
					result.add(sa);
				}
			}
		}
		return result;
	}
}
