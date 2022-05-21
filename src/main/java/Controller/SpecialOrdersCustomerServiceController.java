package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import il.ac.haifa.cs.sweng.OCSFSimpleChat.App;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class SpecialOrdersCustomerServiceController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label totalOrdersLabel;

    @FXML
    private VBox vbox;

    @FXML
    void handleHome() throws IOException {
        App.setRoot("primarySystemWorker", "/Image/mainPageIcon.png", "Lilac");
    }

    @FXML
    void initialize() {

    }
}
