package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert.AlertType;

public class CartScreenController {

    private Cart cart;

    @FXML private TableView<Media> tblMedia;
    @FXML private TableColumn<Media, String> colMediaTitle;
    @FXML private TableColumn<Media, String> colMediaCategory;
    @FXML private TableColumn<Media, Float> colMediaCost;
    @FXML private Button btnPlay;
    @FXML private Button btnRemove;
    @FXML private TextField tfFilter;
    @FXML private RadioButton radioBtnFilterId;
    @FXML private RadioButton radioBtnFilterTitle;
    @FXML private Label lblTotalCost;
    @FXML private Button btnPlaceOrder;

    private ToggleGroup filterGroup = new ToggleGroup();

    public CartScreenController(Cart cart) {
        super();
        this.cart = cart;
    }

    @FXML
    private void initialize() {
        // cell factories
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
        tblMedia.setItems(cart.getItemsOrdered());

        // hide buttons initially
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        radioBtnFilterId.setToggleGroup(filterGroup);
        radioBtnFilterTitle.setToggleGroup(filterGroup);
        radioBtnFilterId.setSelected(true); // default

        tblMedia.getSelectionModel().selectedItemProperty().addListener(
        		new ChangeListener<Media>() {
        			
        			@Override
        			public void changed(ObservableValue<? extends Media> observable, Media oldValue, 
        					Media newValue) {
        				System.out.println("DEBUG: Đã chọn media: " + (newValue != null ? newValue.getTitle() : "null"));
        				if (newValue!=null) {
        					updateButtonBar(newValue);
        				}
        			}
        });

        tfFilter.textProperty().addListener(new ChangeListener<String>() {
			
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, 
					String newValue) {
				if (newValue!=null) {
					showFilteredMedia(newValue);
				}
			}
        });

        cart.addListChangeListener((ListChangeListener.Change<? extends Media> change) -> {
            Platform.runLater(() -> {
                updateTotalCost();
                // if no item selected, hide buttons
                if (cart.getItemsOrdered().isEmpty()) {
                    btnPlay.setVisible(false);
                    btnRemove.setVisible(false);
                }
            });
        });
        updateTotalCost();
    }

    // update play/remove visibility depending on selected media
    void updateButtonBar(Media media) {
        btnRemove.setVisible(true);
        btnPlay.setVisible(media instanceof Playable);
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
        try {
            Media media = tblMedia.getSelectionModel().getSelectedItem();

            if (media != null) {
                cart.removeMedia(media); 
                
                updateTotalCost();
                
                btnRemove.setVisible(false);
                btnPlay.setVisible(false);
            } else {
                System.out.println("Chưa chọn sản phẩm nào để xóa!");
            }
        } catch (Exception e) {
            e.printStackTrace(); 
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Lỗi khi xóa");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void btnPlayPressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media instanceof Playable) {
            try {
                ((Playable) media).play();
                
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Playing");
                alert.setHeaderText("Playing Media");
                alert.setContentText("Media is playing... Check console for details.");
                alert.showAndWait();

            } catch (PlayerException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Illegal DVD Length");
                alert.setHeaderText("ERROR: Media cannot be played");
                alert.setContentText(e.getMessage()); // Lấy nội dung lỗi từ PlayerException
                alert.showAndWait();
            }
        }
    }

    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {
        if (cart.getItemsOrdered().isEmpty()) {
            Alert alert = new Alert(AlertType.INFORMATION, "Cart is empty.");
            alert.showAndWait();
            return;
        }

        Alert confirm = new Alert(AlertType.CONFIRMATION, "Place order? This will clear the cart.", ButtonType.YES, ButtonType.NO);
        confirm.setHeaderText(null);
        confirm.showAndWait().ifPresent(response -> {
            if (response == ButtonType.YES) {
                cart.clear();
                updateTotalCost();
                Alert info = new Alert(AlertType.INFORMATION, "Order placed successfully!");
                info.setHeaderText(null);
                info.showAndWait();
            }
        });
    }

    // filter implementation
    private void showFilteredMedia(String filter) {
        if (filter == null || filter.isEmpty()) {
            tblMedia.setItems(cart.getItemsOrdered());
            return;
        }

        String keyword = filter.toLowerCase();

        if (radioBtnFilterId.isSelected()) {
            tblMedia.setItems(
                cart.getItemsOrdered().filtered(
                    item -> Integer.toString(item.getId()).contains(keyword)
                )
            );
        } else {
            tblMedia.setItems(
                cart.getItemsOrdered().filtered(
                    item -> item.getTitle().toLowerCase().contains(keyword)
                )
            );
        }
    }

    // update total label
    private void updateTotalCost() {
        float total = cart.totalCost();
        lblTotalCost.setText(String.format("%.2f $", total));
    }
}
