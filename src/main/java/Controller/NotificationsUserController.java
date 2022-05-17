package Controller;

import il.ac.haifa.cs.sweng.OCSFSimpleChat.App;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NotificationsUserController {

    @FXML
    private Label totalOrdersLabel;

    @FXML
    private VBox vbox;

    @FXML
    void handleDeleteAllButton() {

    }

    @FXML
    void handleHome() throws IOException {
        App.setRoot("primaryUser", "/Image/mainPageIcon.png", "Lilac");
    }

    @FXML
    void initialize() throws IOException {

        int counter = 0;
        Node[] nodes = new Node[10];
        for (Node node : nodes) {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(App.class.getResource("notificationsItemUser.fxml"));
            node = fxmlLoader.load();
            NotificationsItemUserController notificationsItemUserController = fxmlLoader.getController();
            notificationsItemUserController.setData("New Notification " + counter, "You got full refund " + counter++, new Date().toString());
            vbox.getChildren().add(node);
        }
    }
}
