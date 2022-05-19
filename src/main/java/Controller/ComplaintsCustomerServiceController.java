package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import il.ac.haifa.cs.sweng.OCSFSimpleChat.App;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class ComplaintsCustomerServiceController {

    @FXML
    private Label totalOrdersLabel;

    @FXML
    private VBox vbox;

    public static Node[] nodes = new Node[10];

    @FXML
    void handleHome(MouseEvent event) throws IOException {
        App.setRoot("primaryCustomerService", "/Image/mainPageIcon.png", "Lilac");
    }

    @FXML
    void initialize() throws IOException {

        int counter = 0;
        for (Node node : nodes) {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(App.class.getResource("complaintsItemCustomerService.fxml"));
            node = fxmlLoader.load();
            vbox.getChildren().add(node);
        }
    }
}
