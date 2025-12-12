package hust.soict.dsai.aims.cart;

import java.util.Collections;

import javax.naming.LimitExceededException;

import hust.soict.dsai.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

public class Cart {
    
    private final int MAX_NUMBER_ORDERED = 20;
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

    public void addMedia(Media media) throws LimitExceededException {
    	if (itemsOrdered.size() < MAX_NUMBER_ORDERED) {
            itemsOrdered.add(media);
            System.out.println("Added: " + media.getTitle());
    	}
    	else {
    		throw new LimitExceededException("ERROR: Cart is full");
    	}
    }

    public void removeMedia(Media media) {
        // Xóa trực tiếp đối tượng, KHÔNG dùng index để tránh lỗi IndexOutOfBounds
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println("Removed: " + media.getTitle());
        } else {
            System.out.println("Media not found in cart.");
        }
    }

    // Trả về đúng danh sách ObservableList để Controller dùng
    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    public float totalCost() {
        float total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }
    
    // Hàm làm sạch giỏ hàng (dùng cho nút Place Order)
    public void clear1() {
        itemsOrdered.clear();
        System.out.println("Cart has been cleared.");
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

	public void addListChangeListener(ListChangeListener<? super Media> listener) {
        itemsOrdered.addListener(listener);
    }
}
