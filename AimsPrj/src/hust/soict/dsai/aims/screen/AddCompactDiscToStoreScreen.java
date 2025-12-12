package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {

    public AddCompactDiscToStoreScreen(Store store, StoreScreen storeScreen) {
        super(store, storeScreen);

        JPanel form = new JPanel(new GridLayout(7, 2, 5, 5));

        JTextField tfTitle = new JTextField();
        JTextField tfCategory = new JTextField();
        JTextField tfDirector = new JTextField();
        JTextField tfArtist = new JTextField();
        JTextField tfCost = new JTextField();

        JTextField tfTrackTitle = new JTextField();
        JTextField tfTrackLength = new JTextField();

        DefaultListModel<Track> trackModel = new DefaultListModel<>();
        JList<Track> trackList = new JList<>(trackModel);
        JScrollPane trackScroll = new JScrollPane(trackList);

        JButton btnAddTrack = new JButton("Add Track");
        btnAddTrack.addActionListener(e -> {
            try {
                String tTitle = tfTrackTitle.getText().trim();
                int tLength = Integer.parseInt(tfTrackLength.getText().trim());

                if (!tTitle.isEmpty() && tLength > 0) {
                    trackModel.addElement(new Track(tTitle, tLength));
                    tfTrackTitle.setText("");
                    tfTrackLength.setText("");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid track length!");
            }
        });

        form.add(new JLabel("Title:"));
        form.add(tfTitle);

        form.add(new JLabel("Category:"));
        form.add(tfCategory);

        form.add(new JLabel("Director:"));
        form.add(tfDirector);

        form.add(new JLabel("Artist:"));
        form.add(tfArtist);

        form.add(new JLabel("Cost:"));
        form.add(tfCost);

        form.add(new JLabel("Track Title:"));
        form.add(tfTrackTitle);

        form.add(new JLabel("Track Length:"));
        form.add(tfTrackLength);

        form.add(new JLabel(""));
        form.add(btnAddTrack);

        form.add(new JLabel("Tracks:"));
        form.add(trackScroll);

        JButton btnAdd = new JButton("Add CD");
        btnAdd.addActionListener(e -> {
            try {
                String title = tfTitle.getText();
                String category = tfCategory.getText();
                String director = tfDirector.getText();
                String artist = tfArtist.getText();
                float cost = Float.parseFloat(tfCost.getText());
                if (cost < 0) {
                    throw new IllegalArgumentException("Cost cannot be negative!");
                }
                
                ArrayList<Track> tracks = new ArrayList<>();
                int totalLength = 0;

                for (int i = 0; i < trackModel.size(); i++) {
                    Track t = trackModel.get(i);
                    if (t.getLength() < 0) {
                        throw new IllegalArgumentException("Length cannot be negative!");
                    }
                    tracks.add(t);
                    totalLength += t.getLength();
                }

                CompactDisc cd = new CompactDisc(
                        title,
                        category,
                        director,
                        artist,
                        tracks,
                        totalLength,
                        cost
                );

                store.addMedia(cd);
                
                storeScreen.refresh();

                JOptionPane.showMessageDialog(this, "CD added!");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        });

        this.add(form, BorderLayout.CENTER);
        this.add(btnAdd, BorderLayout.SOUTH);
        this.setTitle("Add Compact Disc");
    }
}
