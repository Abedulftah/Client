package Controller;

import il.ac.haifa.cs.sweng.OCSFSimpleChat.App;
import il.ac.haifa.cs.sweng.OCSFSimpleChat.MsgObject;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.io.IOException;

import static Controller.OrderItemUserController.numberOfItems;
import static il.ac.haifa.cs.sweng.OCSFSimpleChat.SimpleClient.getClient;

public class DetailedOrderUserController {

    @FXML
    private Label totalOrdersLabel;

    @FXML
    private VBox vbox;

    @FXML
    void handleBackToOrders() throws IOException {
        getClient().sendToServer(new MsgObject("myOrdersUser"));
    }

    @FXML
    void handleHome() throws IOException {
        App.setRoot("primaryUser", "/Image/mainPageIcon.png", "Lilac");
    }

    @FXML
    void initialize() {

        totalOrdersLabel.setText("Total Orders: " + numberOfItems);
    }
}
