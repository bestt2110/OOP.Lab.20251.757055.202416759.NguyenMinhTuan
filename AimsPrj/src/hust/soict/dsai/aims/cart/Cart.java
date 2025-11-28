package hust.soict.dsai.aims.cart;

import java.util.ArrayList;
import java.util.Collections;

import hust.soict.dsai.aims.media.Media;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	public String name(Media stuff) {
		return stuff.getTitle();
	}
	
	public void addMedia(Media ... mediaList) {
	    if (itemsOrdered.size() + mediaList.length < MAX_NUMBERS_ORDERED) {
	    	for (Media stuff: mediaList) {
	    		itemsOrdered.add(stuff);  
		        System.out.println("The disc " + name(stuff) + "has been added.");
	    	}
	    } else {
	        System.out.println("The cart is almost full!");
	    	}
	}
	
	public void removeMedia(Media ... mediaList) {
		for (Media stuff: mediaList) {
		    for (int i = 0; i < itemsOrdered.size(); i++) {
		        if (itemsOrdered.contains(stuff)) {
		            for (int j = i; j < itemsOrdered.size() - 1; j++) {
		                itemsOrdered.set(j, itemsOrdered.get(j + 1));
		            }
		            itemsOrdered.remove(itemsOrdered.size());
			        System.out.println(name(stuff) + "has been removed.");
		            return;
		        }
		    }
		    System.out.println("Media not found in the cart.");
	}
	}
	
	public float totalCost() {
		float total = 0;
		for (int i = 0; i < itemsOrdered.size(); i++) {
			float price = itemsOrdered.get(i).getCost();
			total += price;
		}
		return total;
	}
	public void print() {
		System.out.println("***********************CART***********************");
		for (int i=0; i < itemsOrdered.size(); i++) {
			System.out.println((i+1)+". "+ itemsOrdered.get(i));
		}
		System.out.println("***********************************************");
	}
	public void searchbyID(int id) {
		boolean found = false;
		for (int i=0; i < itemsOrdered.size(); i++) {
			if (itemsOrdered.get(i).isMatch(id)) {
				System.out.println("Matches found");	
				System.out.println(itemsOrdered.get(i));
				found = true;
			}
		}
		if (!found) {
			System.out.println("No match is found");			
			}
	}
	public Media searchbytitle(String title) {
		for (Media m: itemsOrdered) {
			if (m.isMatch(title)) {
				return m;
			}
		}
		return null;
    }
	
	public void sortByTitle() {
	    Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
	}
	public void sortByCost() {
	    Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
	}
	
	public void filterByTitle(String keyword) {
		boolean found = false;
	    for (Media m : itemsOrdered) {
	        if (m.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
	            System.out.println(m.toString());
	        }
	    }
	    if (!found) {
	    	System.out.println("No media found with title " + keyword);
	    }
	}
	public void filterById(int id) {
        boolean found = false;
        for (Media m : itemsOrdered) {
            if (m.getId() == id) {
                System.out.println(m.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No media found with id " + id);
        }
    }

	public void clear() {
        itemsOrdered.clear();
	}
}
