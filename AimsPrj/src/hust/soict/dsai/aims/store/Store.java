package hust.soict.dsai.aims.store;

import java.util.ArrayList;
import java.util.Collections;

import hust.soict.dsai.aims.media.Media;

public class Store {
	private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    public void addMedia(Media stuff) {
            itemsInStore.add(stuff);
            System.out.println(stuff.getTitle() + "\" has been added to the store.");
        }
    public void removeMedia(Media stuff) {
        boolean found = false;
        for (int i = 0; i < itemsInStore.size(); i++) {
            if (itemsInStore.contains(stuff)) { 
                found = true;
                for (int j = i; j < itemsInStore.size() - 1; j++) {
                    itemsInStore.set(j,itemsInStore.get(j + 1));
                }
                itemsInStore.remove(itemsInStore.size() - 1);
                System.out.println(stuff.getTitle() + "\" has been removed from the store.");
                break;
            }
        }
        if (!found) {
            System.out.println("The stuff you want was not found in the store.");
        }
    }
   
    public Media searchbytitle(String title) {
		for (Media m: itemsInStore) {
			if (m.isMatch(title)) {
				return m;
			}
		}
		return null;
    }

    public void print() {
        System.out.println("**************** STORE ITEMS ****************");
        for (int i = 0; i < itemsInStore.size(); i++) {
            System.out.println((i + 1) + ". " + itemsInStore.get(i).toString());
        }
        System.out.println("*********************************************");
    }
    
    public void sortByCost() {
        Collections.sort(itemsInStore, Media.COMPARE_BY_COST_TITLE);
    }
    public void sortByTitle() {
        Collections.sort(itemsInStore, Media.COMPARE_BY_TITLE_COST);
    }
    public void printAllTitles() {
        for (Media m : itemsInStore) {
            System.out.println(m.getTitle());
        }
    }

}

