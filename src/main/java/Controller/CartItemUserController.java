package Controller;

import il.ac.haifa.cs.sweng.OCSFSimpleChat.App;
import il.ac.haifa.cs.sweng.OCSFSimpleChat.Catalog;
import il.ac.haifa.cs.sweng.OCSFSimpleChat.MsgObject;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import static il.ac.haifa.cs.sweng.OCSFSimpleChat.SimpleClient.getClient;
import static il.ac.haifa.cs.sweng.OCSFSimpleChat.SimpleClient.msgObject;

public class CartItemUserController {

    private Catalog catalog;

    @FXML
    private Label descriptionLabel;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Label nameLabel;

    @FXML
    private Label priceLabel;

    @FXML
    private Label quantityLabel;

    @FXML
    private Label sizeLabel;

    private String style;

    private int counter = 0;

    @FXML
    void handleBuyButton() {
        //we need to make a new instance of shop that will count the order and the value of it0

        // User will be redirected to pay for this specific item, when he pays move the item from
        // will pop an alert to say to confirmable the detials of the account if not then will pop another alert to say to change his details in the main page
        // cart database to orders database for the current user
        Random random = new Random();
        Date date = new Date();

        for(Catalog catalog1 : msgObject.getCatalogList()){
            if(catalog1.getPrivilege() == 2 &&  catalog.getPrivilege() == 1
            && catalog1.getUser() != null && catalog1.getName().equals(catalog.getName())
            && catalog1.getUser().getEmail().equals(catalog.getUser().getEmail())){
                double a = Double.parseDouble(catalog1.getPrice()) + Double.parseDouble(catalog.getPrice());
                catalog1.setPrice("" + a);
                catalog1.setDate(String.valueOf(java.time.LocalDate.of(2022,5,23 + random.nextInt(7))) + " " + (date.getHours() + random.nextInt(3)) + ":00");
                System.out.println(catalog1.getDate());
                List<Catalog> catalogList2 = new ArrayList<>();
                catalogList2.add(catalog);

                msgObject.getCatalogList().remove(catalog);
                msgObject.getCatalogList().add(catalog1);

                MsgObject msgObject1 = new MsgObject("cartToOrder", catalogList2);
                msgObject1.setCatalogList(msgObject.getCatalogList());

                try {
                    getClient().sendToServer(msgObject1);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                return;
            }
        }

        catalog.setPrivilege(2);
        catalog.setDate(String.valueOf(java.time.LocalDate.of(2022,5,23 + random.nextInt(7))) + " " + (date.getHours() + random.nextInt(3)) + ":00");
        MsgObject msgObject =  new MsgObject("cartToOrder");
        msgObject.getCatalogList().add(catalog);

        try {
            getClient().sendToServer(msgObject);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    @FXML
    void handleBoxClicked() {

        // If (counter % 2 == 0) then the item is chosen so insert it to a list of items you need to buy
        // See the list 'specifiedItemsList' I created at CartUserController and add to it

        if (counter % 2 == 0) {
            anchorPane.setStyle("-fx-background-color: #80b380");
            // Insert to a list of items that you wanna buy
        } else {
            anchorPane.setStyle(style);
            // Remove from the list of items that you wanna buy
        }
        counter++;
    }

    @FXML
    void handleRemoveButton() {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete Confirmation");
        alert.setHeaderText("Confirm that you are willing to remove this product from cart");
        ButtonType confirmButton = new ButtonType("Confirm", ButtonBar.ButtonData.YES);
        ButtonType cancelButton = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(confirmButton, cancelButton);

        alert.showAndWait().ifPresent(type -> {
            if (type == confirmButton) {
                MsgObject msgObject =  new MsgObject("removeFromCart");
                msgObject.getCatalogList().add(catalog);
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
            this.quantityLabel.setText("" + catalog.getLeft());
    }

    @FXML
    void initialize() {
        style = anchorPane.getStyle();
    }
}
