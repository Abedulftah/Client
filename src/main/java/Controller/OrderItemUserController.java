package Controller;

import il.ac.haifa.cs.sweng.OCSFSimpleChat.App;
import il.ac.haifa.cs.sweng.OCSFSimpleChat.Catalog;
import il.ac.haifa.cs.sweng.OCSFSimpleChat.MsgObject;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

import static il.ac.haifa.cs.sweng.OCSFSimpleChat.SimpleClient.getClient;

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

    public static int numberOfItems = 0; //////////////////////////// Remove the initialization

    @FXML
    void handleBoxClicked() {

        // sizeLabel and descriptionLabel named as this to refrain from having errors
        // sizeLabel represents 'Number of items in this order'
        // descriptionLabel represents 'Location'

        // Leave this as it is, it has a use in the page where you show the order details
        // numberOfItems = Integer.parseInt(sizeLabel.getText());

        // App.setRoot("detailedOrderUser", "/Image/myOrdersIcon.png", "Orders");
    }

    @FXML
    void handleCancelOrderButton() {
        //we should send a notification to the client about the refund that he deserve

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete Confirmation");
        alert.setHeaderText("Are you sure you want to delete this product?");
        alert.setContentText("Deleting a product means you'll never be able to retrieve it again unless you add it manually");
        ButtonType confirmButton = new ButtonType("Confirm", ButtonBar.ButtonData.YES);
        ButtonType cancelButton = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(confirmButton, cancelButton);

        alert.showAndWait().ifPresent(type -> {
            if (type == confirmButton) {
                MsgObject msgObject =  new MsgObject("removeFromOrder");
                msgObject.getCatalogList().add(catalog);
                msgObject.setObject("");
                //we need to set an object that saves the date, so we can send it to customer worker to check what refund the client should get
                //and to save the object as complain or whatever
                try {
                    getClient().sendToServer(msgObject);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });


    }

    public void setData(Catalog catalog) {
        this.catalog = catalog;
        this.descriptionLabel.setText(catalog.getItemDetails());
        this.nameLabel.setText(catalog.getName());
        this.priceLabel.setText(App.CURRENCY + catalog.getPrice());
        this.sizeLabel.setText(catalog.getSize());
        this.dateLabel.setText(catalog.getDate());
    }
}
