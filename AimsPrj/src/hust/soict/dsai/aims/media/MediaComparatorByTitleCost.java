package hust.soict.dsai.aims.media;
import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator <Media> {

	@Override
	public int compare(Media o1, Media o2) {
		int result = o1.getTitle().compareTo(o2.getTitle());
        if (result == 0) {
            return Float.compare(o2.getCost(), o1.getCost());  // cost descending
        }
		return result;
	}
	
}
