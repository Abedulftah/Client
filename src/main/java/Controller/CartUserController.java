package Controller;

import il.ac.haifa.cs.sweng.OCSFSimpleChat.App;
import il.ac.haifa.cs.sweng.OCSFSimpleChat.Catalog;
import il.ac.haifa.cs.sweng.OCSFSimpleChat.MsgObject;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import static Controller.SignInController.user;
import static il.ac.haifa.cs.sweng.OCSFSimpleChat.SimpleClient.getClient;
import static il.ac.haifa.cs.sweng.OCSFSimpleChat.SimpleClient.msgObject;

// See what's written in handleBuyAllButton and initialize

public class CartUserController {

    @FXML
    private Label totalOrdersLabel;

    @FXML
    private VBox vbox;

    private List<Catalog> catalogList = new ArrayList<>();

    @FXML
    void handleBuyAllButton() {
        //we need to make a list of new instances of shop to take care of all orders

        // User will be redirected to a page to confirm his details, when he pays move all items
        // From the Cart database to orders database of the current user
        //we need to check if there is the same item in the order, so we can just update the price/quantity

        Random random = new Random();
        Date date = new Date();

        List<Catalog> catalogs = new ArrayList<>();

        for(Catalog catalog : msgObject.getCatalogList()){
            for(Catalog catalog1 : msgObject.getCatalogList()){
                if(catalog.getPrivilege() == 1 && catalog1.getPrivilege() == 2
                && catalog.getName().equals(catalog1.getName())
                && catalog.getUser() != null && catalog1.getUser() != null
                && catalog.getUser().getEmail().equals(catalog1.getUser().getEmail())){
                    double a = Double.parseDouble(catalog.getPrice()) + Double.parseDouble(catalog.getPrice());
                    catalog1.setDate(String.valueOf(java.time.LocalDate.of(2022,5,23 + random.nextInt(7))) + " " + (date.getHours() + random.nextInt(3)) + ":00");
                    catalog1.setPrice("" + a);
                    catalogList.add(catalog1);
                    catalogs.add(catalog);
                }
            }
        }

        for(Catalog catalog : catalogs){
            msgObject.getCatalogList().remove(catalog);
        }

        if(!msgObject.getCatalogList().isEmpty()) {
            for (Catalog catalog : msgObject.getCatalogList()) {
                if (catalog.getPrivilege() == 1 && catalog.getUser() != null && catalog.getUser().getEmail().equals(user.getEmail())) {
                    catalog.setPrivilege(2);
                    catalog.setDate(String.valueOf(java.time.LocalDate.of(2022,5,23 + random.nextInt(7))) + " " + (date.getHours() + random.nextInt(3)) + ":00");
                    catalogList.add(catalog);
                }
            }
        }
        try {
            MsgObject msgObject1 = new MsgObject("cartToOrder");
            msgObject1.setCatalogList(catalogList);
            msgObject1.setObject(catalogs);
            getClient().sendToServer(msgObject1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void handleHome() throws IOException {
        App.setRoot("primaryUser", "/Image/mainPageIcon.png", "Lilac");
    }

    @FXML
    void initialize() throws IOException {

        // Add items in the Cart database you already created

        List<Catalog> catalogList1 = new ArrayList<>();

        for(Catalog catalog : msgObject.getCatalogList()){
            if(catalog.getPrivilege() == 1 && catalog.getUser().getEmail().equals(user.getEmail())){
                catalogList1.add(catalog);
            }
        }

        if (!catalogList1.isEmpty()) {
            for (Catalog catalog : catalogList1) {

                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(App.class.getResource("cartItemUser.fxml"));
                Node node = fxmlLoader.load();
                CartItemUserController cartItemUserController = fxmlLoader.getController();
                cartItemUserController.setData(catalog);
                vbox.getChildren().add(node);

            }
        }
        //catalogList = catalogList1;
        totalOrdersLabel.setText("Total products: " + catalogList1.size());
    }
}