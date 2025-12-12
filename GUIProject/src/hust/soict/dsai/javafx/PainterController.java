package hust.soict.dsai.javafx; 

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;

    @FXML
    private RadioButton eraser; // ID của nút Tẩy

    @FXML
    private RadioButton pen;    // ID của nút Bút

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        if (event.getX() < 0 || event.getY() < 0 || 
            event.getX() > drawingAreaPane.getWidth() || 
            event.getY() > drawingAreaPane.getHeight()) {
            return; 
        }
        Color inkColor = Color.BLACK;
        if (eraser.isSelected()) {
            inkColor = Color.WHITE;
        }

        double size = eraser.isSelected() ? 10 : 4; 
        
        Circle newCircle = new Circle(event.getX(), event.getY(), size, inkColor);
        drawingAreaPane.getChildren().add(newCircle);
    }
}