package Controller;

import il.ac.haifa.cs.sweng.OCSFSimpleChat.App;
import il.ac.haifa.cs.sweng.OCSFSimpleChat.MsgObject;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;

import static il.ac.haifa.cs.sweng.OCSFSimpleChat.SimpleClient.getClient;

public class PrimaryUserController {

    @FXML
    private Label nameLabel;

    @FXML
    private ImageView userImage;

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
    void handleNotificationsButton() throws IOException {
        getClient().sendToServer(new MsgObject("notificationsUser"));
    }

    @FXML
    void handleSpecialOrderButton() throws IOException {
        getClient().sendToServer(new MsgObject("specialOrderUser"));
    }

    @FXML
    void initialize() {
        nameLabel.setText(SignInController.userName);
        switch (SignInController.rank) {

            case "elite":
                userImage.setImage(new Image(getClass().getResourceAsStream("/Image/elitePlan.png")));
                break;

            case "gold":
                userImage.setImage(new Image(getClass().getResourceAsStream("/Image/goldPlan.png")));
                break;

            case "basic":
                userImage.setImage(new Image(getClass().getResourceAsStream("/Image/basicPlan.png")));
                break;
        }
    }
}
