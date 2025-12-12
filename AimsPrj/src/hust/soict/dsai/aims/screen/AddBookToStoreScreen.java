package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AddBookToStoreScreen extends AddItemToStoreScreen {

    public AddBookToStoreScreen(Store store, StoreScreen storeScreen) {
        super(store, storeScreen);

        JPanel form = new JPanel(new GridLayout(6, 2, 5, 5));

        JTextField tfTitle = new JTextField();
        JTextField tfCategory = new JTextField();
        JTextField tfCost = new JTextField();
        JTextField tfAuthorName = new JTextField();

        // Danh sách tác giả
        DefaultListModel<String> authorsModel = new DefaultListModel<>();
        JList<String> authorsList = new JList<>(authorsModel);
        JScrollPane authorScroll = new JScrollPane(authorsList);

        // Nút thêm tác giả
        JButton btnAddAuthor = new JButton("Add Author");
        btnAddAuthor.addActionListener(e -> {
            String author = tfAuthorName.getText().trim();
            if (!author.isEmpty()) {
                authorsModel.addElement(author);
                tfAuthorName.setText("");
            }
        });

        // Form input
        form.add(new JLabel("Title:"));
        form.add(tfTitle);

        form.add(new JLabel("Category:"));
        form.add(tfCategory);

        form.add(new JLabel("Cost:"));
        form.add(tfCost);

        form.add(new JLabel("Author name:"));
        form.add(tfAuthorName);

        form.add(new JLabel(" "));
        form.add(btnAddAuthor);

        form.add(new JLabel("Authors list:"));
        form.add(authorScroll);

        // Nút Add Book
        JButton btnAdd = new JButton("Add Book");
        btnAdd.addActionListener(e -> {
            try {
                String title = tfTitle.getText();
                String category = tfCategory.getText();
                float cost = Float.parseFloat(tfCost.getText());
                if (cost < 0) {
                    throw new IllegalArgumentException("Cost cannot be negative!");
                }
                ArrayList<String> authors = new ArrayList<>();
                for (int i = 0; i < authorsModel.size(); i++) {
                    authors.add(authorsModel.get(i));
                }

                Book book = new Book(title, category, authors, cost);
                store.addMedia(book);
                
                storeScreen.refresh();

                JOptionPane.showMessageDialog(this, "Book added!");

            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(this, "Error: Cost must be a valid number!", "Input Error", JOptionPane.ERROR_MESSAGE);
            } catch (IllegalArgumentException iae) {
                JOptionPane.showMessageDialog(this, "Error: " + iae.getMessage(), "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Gắn vào window
        this.add(form, BorderLayout.CENTER);
        this.add(btnAdd, BorderLayout.SOUTH);

        this.setTitle("Add Book");
    }
}
