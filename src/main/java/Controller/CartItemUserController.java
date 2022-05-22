package Controller;

import il.ac.haifa.cs.sweng.OCSFSimpleChat.App;
import il.ac.haifa.cs.sweng.OCSFSimpleChat.Catalog;
import il.ac.haifa.cs.sweng.OCSFSimpleChat.MsgObject;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static il.ac.haifa.cs.sweng.OCSFSimpleChat.SimpleClient.getClient;
import static il.ac.haifa.cs.sweng.OCSFSimpleChat.SimpleClient.msgObject;

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
        Random random = new Random();

        System.out.println(msgObject.getCatalogList().isEmpty());

        for(Catalog catalog1 : msgObject.getCatalogList()){
            if(catalog1.getPrivilege() == 2 &&  catalog.getPrivilege() == 1
            && catalog1.getUser() != null && catalog1.getName().equals(catalog.getName())
            && catalog1.getUser().getEmail().equals(catalog.getUser().getEmail())){
                double a = Double.parseDouble(catalog1.getPrice()) + Double.parseDouble(catalog.getPrice());
                catalog1.setPrice("" + a);
                catalog1.setDate(String.valueOf(java.time.LocalDate.of(2022,5,22 + random.nextInt(7))));
                List<Catalog> catalogList2 = new ArrayList<>();
                catalogList2.add(catalog);

                msgObject.getCatalogList().remove(catalog);

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
        catalog.setDate(String.valueOf(java.time.LocalDate.of(2022,5,21 + random.nextInt(7))));
        MsgObject msgObject =  new MsgObject("cartToOrder");
        msgObject.getCatalogList().add(catalog);

        try {
            getClient().sendToServer(msgObject);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    @FXML
    void handleRemoveButton() {
        // Remove the current item from the cart database
        MsgObject msgObject =  new MsgObject("removeFromCart");
        msgObject.getCatalogList().add(catalog);
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
            this.quantityLabel.setText("" + catalog.getLeft());
    }
}
