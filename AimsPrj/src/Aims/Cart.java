package Aims;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = 
			new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered = 0;
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
	    if (qtyOrdered < MAX_NUMBERS_ORDERED) {
	        itemsOrdered[qtyOrdered] = disc; 
	        qtyOrdered++;    
	        System.out.println("The disc " + name(disc) + "has been added.");
	    } else {
	        System.out.println("The cart is almost full!");
	    }
	}
	public int getQtyOrdered() {
		return qtyOrdered;
	}
	public String name(DigitalVideoDisc disc) {
		return disc.getTitle();
	}
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
	    for (int i = 0; i < qtyOrdered; i++) {
	        if (itemsOrdered[i] == disc) {
	            // shift remaining items left
	            for (int j = i; j < qtyOrdered - 1; j++) {
	                itemsOrdered[j] = itemsOrdered[j + 1];
	            }
	            itemsOrdered[qtyOrdered - 1] = null; // clear last slot
	            qtyOrdered--; // decrease count
		        System.out.println("The disc " + name(disc) + "has been removed.");
	            return;
	        }
	    }
	    System.out.println("Disc not found in the cart.");
	}
	public float totalCost() {
		float total = 0;
		for (int i = 0; i < qtyOrdered; i++) {
			float price = itemsOrdered[i].getCost();
			total += price;
		}
		return total;
	}
	/*public void addDigitalVideoDisc(DigitalVideoDisc ... dvdList) {
	    if (qtyOrdered + dvdList.length < MAX_NUMBERS_ORDERED) {
	    	for (DigitalVideoDisc disc: dvdList) {
	    		itemsOrdered[qtyOrdered] = disc; 
		        qtyOrdered++;    
		        System.out.println("The disc " + name(disc) + "has been added.");
	    	}
	    } else {
	        System.out.println("The cart is almost full!");
	    }
	}*/
	public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList) {
	    if (qtyOrdered + dvdList.length < MAX_NUMBERS_ORDERED) {
	    	for (DigitalVideoDisc disc: dvdList) {
	    		itemsOrdered[qtyOrdered] = disc; 
		        qtyOrdered++;    
		        System.out.println("The disc " + name(disc) + "has been added.");
	    	}
	    } else {
	        System.out.println("The cart is almost full!");
	    }
	}
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
	    if (qtyOrdered < MAX_NUMBERS_ORDERED) {
	        itemsOrdered[qtyOrdered] = dvd1; 
	        qtyOrdered++;    
	        System.out.println("The disc " + name(dvd1) + "has been added.");
	        itemsOrdered[qtyOrdered] = dvd2; 
	        qtyOrdered++;    
	        System.out.println("The disc " + name(dvd2) + "has been added.");
	    } else {
	        System.out.println("The cart is almost full!");
	    }
	}
	public void print() {
		System.out.println("***********************CART***********************");
		for (int i=0; i < qtyOrdered; i++) {
			System.out.println((i+1)+". "+ itemsOrdered[i]);
		}
		System.out.println("***********************************************");
	}
	public void seachbyID(int id) {
		for (int i=0; i < qtyOrdered; i++) {
			if (itemsOrdered[i].isMatch(id)) {
				System.out.println("Matches found");	
				System.out.println(itemsOrdered[i]);
			}
			else {
				System.out.println("No match is found");			}
		}
	}
	public void seachbytitle(int title) {
		for (int i=0; i < qtyOrdered; i++) {
			if (itemsOrdered[i].isMatch(title)) {
				System.out.println("Matches found");	
				System.out.println(itemsOrdered[i]);
			}
			else {
				System.out.println("No match is found");			}
		}
	}
}
