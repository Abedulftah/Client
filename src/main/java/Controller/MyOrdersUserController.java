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

// See what's written in initialize

public class MyOrdersUserController {

    @FXML
    private Label totalOrdersLabel;

    @FXML
    private VBox vbox;

    private final List<Catalog> catalogList = msgObject.getCatalogList();

    @FXML
    void handleHome() throws IOException {
        App.setRoot("primaryUser", "/Image/mainPageIcon.png", "Lilac");
    }

    @FXML
    void initialize() throws IOException {

        //Node[] nodes = new Node[catalogList.size()];
        /*for (int i = 0; i < nodes.length; i++) {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(App.class.getResource("orderItemUser.fxml"));
            nodes[i] = fxmlLoader.load();
            OrderItemUserController orderItemUserController = fxmlLoader.getController();
            String item = "item" + i;
            orderItemUserController.setData(item, item, item, item);
            vbox.getChildren().add(nodes[i]);
        }*/

        // You must replace what appears down below with the real orders from the orders database
        // You've created

        for (Catalog catalog : catalogList) {

            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(App.class.getResource("orderItemUser.fxml"));
            Node node = fxmlLoader.load();
            OrderItemUserController orderItemUserController = fxmlLoader.getController();
            orderItemUserController.setData(catalog);
            vbox.getChildren().add(node);
        }

        totalOrdersLabel.setText("Total Orders: " + catalogList.size());
    }
}
