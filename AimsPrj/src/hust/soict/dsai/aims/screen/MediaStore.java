package hust.soict.dsai.aims.screen;

import javax.naming.LimitExceededException;
import javax.swing.*;

import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.cart.*;

import java.awt.*;
import java.awt.event.*;

public class MediaStore extends JPanel {
    private Media media;
    private Cart cart;
    private Store store; // 1. Thêm biến Store

    // 2. Cập nhật Constructor để nhận thêm Store
    public MediaStore(Media media, Cart cart, Store store) {
        this.media = media;
        this.cart = cart;
        this.store = store; // Lưu biến store

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel(media.getCost() + " $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        // ----- Add to Cart -----
        JButton btnAdd = new JButton("Add to cart");
        btnAdd.addActionListener(e -> {
            try {
				cart.addMedia(media);
			} catch (LimitExceededException e1) {
				e1.printStackTrace();
			}
            JOptionPane.showMessageDialog(this, media.getTitle() + " has been added to cart");
        });
        container.add(btnAdd);

        // ----- Play button -----
        if (media instanceof Playable) {
            JButton btnPlay = new JButton("Play");
            btnPlay.addActionListener(e -> {
                JDialog dialog = new JDialog();
                dialog.setTitle("Playing");
                dialog.setSize(250, 120);

                JLabel infoLabel = new JLabel("Playing: " + media.getTitle(), SwingConstants.CENTER);
                dialog.add(infoLabel);

                dialog.setLocationRelativeTo(null);
                dialog.setVisible(true);
            });
            container.add(btnPlay);
        }
        
        JButton btnDelete = new JButton("Delete");
        btnDelete.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(this, 
                "Do you want to delete '" + media.getTitle() + "' from the Store?", 
                "Confirm Delete", JOptionPane.YES_NO_OPTION);
            
            if (confirm == JOptionPane.YES_OPTION) {
                store.removeMedia(media);
                
                if (StoreScreen.INSTANCE != null) {
                    StoreScreen.INSTANCE.refresh();
                }
                
                JOptionPane.showMessageDialog(this, "Deleted successfully!");
            }
        });
        container.add(btnDelete);
        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}