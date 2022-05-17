package Controller;

import il.ac.haifa.cs.sweng.OCSFSimpleChat.App;
import il.ac.haifa.cs.sweng.OCSFSimpleChat.Catalog;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.List;

import static il.ac.haifa.cs.sweng.OCSFSimpleChat.SimpleClient.msgObject;

// See what's written in handleBuyAllButton and initialize

public class CartUserController {

    @FXML
    private Label totalOrdersLabel;

    @FXML
    private VBox vbox;

    private final List<Catalog> catalogList = msgObject.getCatalogList();

    @FXML
    void handleBuyAllButton() {
        // User will be redirected to a page to confirm his details, when he pays move all items
        // From the Cart database to orders database of the current user
    }

    @FXML
    void handleHome() throws IOException {
        App.setRoot("primaryUser", "/Image/mainPageIcon.png", "Lilac");
    }

    @FXML
    void initialize() throws IOException {

        // Add items in the Cart database you already created

        for (Catalog catalog : catalogList) {

            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(App.class.getResource("cartItemUser.fxml"));
            Node node = fxmlLoader.load();
            CartItemUserController cartItemUserController = fxmlLoader.getController();
            cartItemUserController.setData(catalog);
            vbox.getChildren().add(node);
        }

        totalOrdersLabel.setText("Total Orders: " + catalogList.size());
    }
}
