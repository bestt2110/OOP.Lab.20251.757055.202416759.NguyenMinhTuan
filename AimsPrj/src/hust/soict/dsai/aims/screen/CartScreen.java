package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class CartScreen extends JFrame {

    private Cart cart;
    private Store store; 

    public CartScreen(Store store, Cart cart) {
        super();
        
        Platform.setImplicitExit(false);
        
        this.store = store;
        this.cart = cart;

        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);

        this.setTitle("Cart");
        this.setSize(1024, 1024);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Đóng Cart thì chỉ tắt Cart
        this.setLocationRelativeTo(null);
        
        this.setJMenuBar(createMenuBar());

        this.setVisible(true);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/dsai/aims/screen/cart.fxml"));
                    
                    CartScreenController controller = new CartScreenController(cart);
                    loader.setController(controller);

                    Parent root = loader.load();
                    fxPanel.setScene(new Scene(root));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menuOptions = new JMenu("Options");
        
        JMenuItem viewStore = new JMenuItem("View Store");
        viewStore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (StoreScreen.INSTANCE != null) {
                    StoreScreen.INSTANCE.setVisible(true);
                    StoreScreen.INSTANCE.refresh();
                } else {
                    new StoreScreen(store, cart);
                }
                dispose(); // Đóng màn hình Cart hiện tại
            }
        });

        menuOptions.add(viewStore);
        menuBar.add(menuOptions);
        return menuBar;
    }
}