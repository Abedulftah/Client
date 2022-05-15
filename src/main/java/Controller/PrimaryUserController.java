package Controller;

import il.ac.haifa.cs.sweng.OCSFSimpleChat.App;
import il.ac.haifa.cs.sweng.OCSFSimpleChat.MsgObject;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

import static il.ac.haifa.cs.sweng.OCSFSimpleChat.SimpleClient.getClient;

public class PrimaryUserController {

    @FXML
    private Label nameLabel;

    @FXML
    void handleCartButton() throws IOException {
        getClient().sendToServer(new MsgObject("cartUser"));
    }

    @FXML
    void handleCatalogueButton() throws IOException {
        getClient().sendToServer(new MsgObject("catalogueUser"));
    }

    @FXML
    void handleComplainButton() throws IOException {
        getClient().sendToServer(new MsgObject("complainUser"));
    }

    @FXML
    void handleLogoutButton() throws IOException {
        App.setRoot("primary", "/Image/mainPageIcon.png", "Lilac");
    }

    @FXML
    void handleMyOrdersButton() throws IOException {
        getClient().sendToServer(new MsgObject("myOrdersUser"));
    }

    @FXML
    void handleSpecialOrderButton() throws IOException {
        getClient().sendToServer(new MsgObject("specialOrderUser"));
    }

    @FXML
    void initialize() {
        nameLabel.setText(SignInController.userName);
    }
}
