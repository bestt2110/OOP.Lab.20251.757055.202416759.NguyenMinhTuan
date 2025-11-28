package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;

import java.util.Scanner;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
    }
    
    public static void filterMenu() {
        System.out.println("Options: ");
        System.out.println("1. Filter by id");
        System.out.println("2. Filter by title");
        System.out.println("0. Back");
    }
    
    public static void sortMenu() {
        System.out.println("Options: ");
        System.out.println("1. Sort by title");
        System.out.println("2. Sort by cost");
        System.out.println("0. Back");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    // View store
                    store.print();
                    storeMenu();
                    int storeChoice = scanner.nextInt();
                    scanner.nextLine();
                    if (storeChoice == 1) {
                        System.out.print("Enter media title: ");
                        String title = scanner.nextLine();
                        Media m = store.searchbytitle(title);
                        if (m != null) {
                            System.out.println(m.toString());
                            mediaDetailsMenu();
                            int detailChoice = scanner.nextInt();
                            scanner.nextLine();
                            if (detailChoice == 1) cart.addMedia(m);
                            else if (detailChoice == 2 && m instanceof Playable) {
                                ((Playable) m).play();
                            }
                        } else {
                            System.out.println("Media not found!");
                        }
                    } else if (storeChoice == 2) {
                        System.out.print("Enter media title to add from below: ");
                        store.printAllTitles();
                        String title = scanner.nextLine();
                        Media m = store.searchbytitle(title);
                        if (m != null) cart.addMedia(m);
                    } else if (storeChoice == 3) {
                        System.out.print("Enter media title to play: ");
                        String title = scanner.nextLine();
                        Media m = store.searchbytitle(title);
                        if (m instanceof Playable) ((Playable) m).play();
                    } else if (storeChoice == 4) {
                        cart.print();
                    }
                    break;
                case 2:
                    // Update store
                    System.out.println("1. Add media");
                    System.out.println("2. Remove media");
                    int updateChoice = scanner.nextInt();
                    scanner.nextLine();
                    if (updateChoice == 1) {
                        //Example of adding Media 
                        store.addMedia(new DigitalVideoDisc("Inception", "Sci-Fi", "Nolan", 148, 20f));
                    } else if (updateChoice == 2) {
                        System.out.print("Enter media title to remove from below: ");
                        store.printAllTitles();
                        String title = scanner.nextLine();
                        Media m = store.searchbytitle(title);
                        if (m != null) store.removeMedia(m);
                    }
                    break;
                case 3:
                    // See current cart
                    cart.print();
                    cartMenu();
                    int cartChoice = scanner.nextInt();
                    scanner.nextLine();
                    if (cartChoice == 1) {
                        System.out.print("Filter by (id/title): ");
                        int filterChoice = scanner.nextInt();
                        scanner.nextLine();
                        if (filterChoice == 1) {
                        	System.out.print("Type ID: ");
                        	int id = Integer.parseInt(scanner.nextLine());
                        	cart.filterById(id);
                        } else if (filterChoice == 2) {
                        	System.out.print("Type keyword: ");
                        	String keyword = scanner.nextLine();
                        	cart.filterByTitle(keyword);
                        }
                    } else if (cartChoice == 2) {
                        System.out.print("Sort by (title/cost): ");
                        int sortChoice = scanner.nextInt();
                        scanner.nextLine();
                        if (sortChoice == 1) {
                        	cart.sortByTitle();
                        } else if (sortChoice == 2) {
                        	cart.sortByTitle();
                        }
                    } else if (cartChoice == 3) {
                        System.out.print("Enter media title to remove: ");
                        String title = scanner.nextLine();
                        Media m = cart.searchbytitle(title);
                        if (m != null) cart.removeMedia(m);
                    } else if (cartChoice == 4) {
                        System.out.print("Enter media title to play: ");
                        String title = scanner.nextLine();
                        Media m = cart.searchbytitle(title);
                        if (m instanceof Playable) ((Playable) m).play();
                    } else if (cartChoice == 5) {
                        System.out.println("Order placed!");
                        cart.clear();
                    }
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 0);
        scanner.close();
    }
}