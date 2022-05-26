package Controller;

import il.ac.haifa.cs.sweng.OCSFSimpleChat.App;
import il.ac.haifa.cs.sweng.OCSFSimpleChat.Catalog;
import il.ac.haifa.cs.sweng.OCSFSimpleChat.MsgObject;
import il.ac.haifa.cs.sweng.OCSFSimpleChat.Order;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

import static il.ac.haifa.cs.sweng.OCSFSimpleChat.SimpleClient.getClient;


import static Controller.OrderItemUserController.numberOfItems;

public class DetailedOrderItemUserController {

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

    private Catalog catalog;

    @FXML
    void handleRemoveButton() throws IOException {

        // Don't forget that if the last item was removed then you have to remove the whole order
        // I didn't add a remove all button in DetailedOrderUserController in purpose since if the user tend
        // To remove everything he must remove the order from the main page
        // refunding the price of the specific item
        --numberOfItems;
        if(numberOfItems == 0)
            getClient().sendToServer(new MsgObject("removeItemAndOrder", catalog));
        else
            getClient().sendToServer(new MsgObject("removeItem", catalog));


    }
    public void setData(Catalog catalog) {
        this.catalog = catalog;
        this.descriptionLabel.setText(catalog.getItemDetails());
        this.nameLabel.setText(catalog.getName());
        this.priceLabel.setText(App.CURRENCY + catalog.getPrice());
        this.sizeLabel.setText(catalog.getSize());
        this.quantityLabel.setText("" + catalog.getLeft());
    }
}
