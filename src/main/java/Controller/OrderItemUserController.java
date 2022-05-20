package Controller;

import il.ac.haifa.cs.sweng.OCSFSimpleChat.App;
import il.ac.haifa.cs.sweng.OCSFSimpleChat.Catalog;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;

public class OrderItemUserController extends Node {

    private Catalog catalog;

    @FXML
    private Label dateLabel;

    @FXML
    private Label descriptionLabel;

    @FXML
    private Label nameLabel;

    @FXML
    private Label priceLabel;

    @FXML
    private Label sizeLabel;

    @FXML
    void handleCancelOrderButton() {

    }

    public void setData(Catalog catalog) {
        this.catalog = catalog;
        this.descriptionLabel.setText(catalog.getItemDetails());
        this.nameLabel.setText(catalog.getName());
        this.priceLabel.setText(App.CURRENCY + catalog.getPrice());
        this.sizeLabel.setText(catalog.getSize());
    }
}
