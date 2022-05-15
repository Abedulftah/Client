package Controller;

import il.ac.haifa.cs.sweng.OCSFSimpleChat.App;
import il.ac.haifa.cs.sweng.OCSFSimpleChat.Catalog;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.Random;

public class CartItemUserController {

    private Catalog catalog;

    @FXML
    private Label descriptionLabel;

    @FXML
    private Label nameLabel;

    @FXML
    private Label priceLabel;

    @FXML
    private Label quantityLabel;

    @FXML
    private Label sizeLabel;

    @FXML
    void handleBuyButton() {
        // User will be redirected to pay for this specific item, when he pays move the item from
        // cart database to orders database for the current user
    }

    @FXML
    void handleRemoveButton() {
        // Remove the current item from the cart database
    }

    public void setData(Catalog catalog) {
        this.catalog = catalog;
        this.descriptionLabel.setText(catalog.getItemDetails());
        this.nameLabel.setText(catalog.getName());
        this.priceLabel.setText(App.CURRENCY + catalog.getPrice());
        this.sizeLabel.setText(catalog.getSize());

        // Change the quality accordingly, don't leave it like this, this was just for test
        this.quantityLabel.setText(String.valueOf(new Random().nextInt(10) + 1));
    }
}
