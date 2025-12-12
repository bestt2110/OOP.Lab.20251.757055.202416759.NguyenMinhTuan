package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException; // Import Exception
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.screen.StoreScreen;
import hust.soict.dsai.aims.store.Store;

import javax.swing.JOptionPane; // Dùng để hiện dialog theo yêu cầu
import javax.swing.SwingUtilities;
import java.util.ArrayList;

public class Aims {
    public static void main(String[] args) {
        // 1. Khởi tạo Store và Cart
        Store store = new Store();
        Cart cart = new Cart();

        // 2. Tạo dữ liệu mẫu
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        store.addMedia(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        store.addMedia(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 18.99f);
        store.addMedia(dvd3);
        
        ArrayList<Track> tracks = new ArrayList<Track>();
        CompactDisc cdError = new CompactDisc("Error CD", "Music", "Nobody", tracks, 10.0f);
        cdError.addTrack(new Track("Bad Track", 0)); 
        store.addMedia(cdError);

        System.out.println("---- BẮT ĐẦU TEST EXCEPTION (CONSOLE) ----");
        try {
            System.out.println("Đang thử play CD bị lỗi...");
            cdError.play(); 
        } catch (PlayerException e) {
            System.out.println("Đã bắt được lỗi: " + e.getMessage());
            
            System.out.println("toString(): " + e.toString());
            
            e.printStackTrace();
            
            JOptionPane.showMessageDialog(null, e.getMessage(), "Lỗi khi Play (Test)", JOptionPane.ERROR_MESSAGE);
        }
        System.out.println("---- KẾT THÚC TEST EXCEPTION ----");
        try {
             SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new StoreScreen(store, cart);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}