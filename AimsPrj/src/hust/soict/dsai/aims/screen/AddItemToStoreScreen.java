package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.store.Store;
import javax.swing.*;
import java.awt.*;

public abstract class AddItemToStoreScreen extends JFrame {
    protected Store store;
    protected StoreScreen storeScreen; // <--- Thêm biến này

    // Cập nhật Constructor nhận thêm StoreScreen
    public AddItemToStoreScreen(Store store, StoreScreen storeScreen) {
        this.store = store;
        this.storeScreen = storeScreen; // <--- Lưu lại

        this.setLayout(new BorderLayout());
        this.add(createMenuBar(), BorderLayout.NORTH);
        this.setTitle("Add Item");
        this.setSize(400, 300);
        this.setVisible(true);
    }

    protected JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        JMenu smUpdateStore = new JMenu("Update Store");
        smUpdateStore.add(new JMenuItem("Add Book"));
        smUpdateStore.add(new JMenuItem("Add CD"));
        smUpdateStore.add(new JMenuItem("Add DVD"));

        menu.add(smUpdateStore);
        menu.add(new JMenuItem("View store"));

        JMenuBar bar = new JMenuBar();
        bar.add(menu);
        return bar;
    }
}
