package Controller;

import il.ac.haifa.cs.sweng.OCSFSimpleChat.App;
import il.ac.haifa.cs.sweng.OCSFSimpleChat.Catalog;
import il.ac.haifa.cs.sweng.OCSFSimpleChat.MsgObject;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;

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

    @FXML
    void handleCancelOrderButton() {
        //we should send a notification to the client about the refund that he deserve
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

    public void setData(Catalog catalog) {
        this.catalog = catalog;
        this.descriptionLabel.setText(catalog.getItemDetails());
        this.nameLabel.setText(catalog.getName());
        this.priceLabel.setText(App.CURRENCY + catalog.getPrice());
        this.sizeLabel.setText(catalog.getSize());
        this.dateLabel.setText(catalog.getDate());
    }
}
