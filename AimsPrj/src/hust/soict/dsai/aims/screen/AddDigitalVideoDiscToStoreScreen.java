package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {

    public AddDigitalVideoDiscToStoreScreen(Store store, StoreScreen storeScreen) {
        super(store, storeScreen);

        JPanel form = new JPanel(new GridLayout(5, 2));

        JTextField tfTitle = new JTextField();
        JTextField tfCategory = new JTextField();
        JTextField tfCost = new JTextField();
        JTextField tfLength = new JTextField();
        JTextField tfDirector = new JTextField();

        form.add(new JLabel("Title:"));
        form.add(tfTitle);

        form.add(new JLabel("Category:"));
        form.add(tfCategory);

        form.add(new JLabel("Cost:"));
        form.add(tfCost);

        form.add(new JLabel("Length:"));
        form.add(tfLength);

        form.add(new JLabel("Director:"));
        form.add(tfDirector);

        JButton btnAdd = new JButton("Add");
        btnAdd.addActionListener(e -> {
            try {
                String title = tfTitle.getText();
                String category = tfCategory.getText();
                String director = tfDirector.getText();

                if (tfCost.getText().isEmpty()) throw new IllegalArgumentException("Cost cannot be empty!");
                float cost = Float.parseFloat(tfCost.getText());
                if (cost < 0) {
                    throw new IllegalArgumentException("Cost cannot be negative!");
                }

                if (tfLength.getText().isEmpty()) throw new IllegalArgumentException("Length cannot be empty!");
                int length = Integer.parseInt(tfLength.getText());
                if (length <= 0) {
                    throw new IllegalArgumentException("Length must be positive!");
                }

                DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
                store.addMedia(dvd);
                
                if (StoreScreen.INSTANCE != null) {
                    StoreScreen.INSTANCE.refresh();
                }

                JOptionPane.showMessageDialog(this, "DVD added successfully!");
                
                tfTitle.setText(""); tfCost.setText("");

            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(this, "Error: Cost and Length must be valid numbers!", "Input Error", JOptionPane.ERROR_MESSAGE);
            } catch (IllegalArgumentException iae) {
                JOptionPane.showMessageDialog(this, "Error: " + iae.getMessage(), "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        this.add(form, BorderLayout.CENTER);
        this.add(btnAdd, BorderLayout.SOUTH);
    	}
    }