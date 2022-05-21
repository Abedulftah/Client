package Controller;

import il.ac.haifa.cs.sweng.OCSFSimpleChat.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

public class SpecialOrderItemCustomerServiceController {

    @FXML
    private Label contentLabel;

    @FXML
    private Label emailLabel;

    @FXML
    void handleAcceptButton() {

    }

    @FXML
    void handleRefuseButton() {

    }

    @FXML
    void handleRespondButton() throws IOException {
        App.setRoot("respondToSpecialOrderCustomerService", "/Image/specialOrderIcon.png", "Special Order");
    }
}
