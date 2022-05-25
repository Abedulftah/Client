package Controller;

import il.ac.haifa.cs.sweng.OCSFSimpleChat.App;
import il.ac.haifa.cs.sweng.OCSFSimpleChat.MsgObject;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;

import static Controller.SignInController.user;
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
    void handleEditAccount() throws IOException {
        getClient().sendToServer(new MsgObject("editAccountInformation"));
    }

    @FXML
    void handleLogoutButton() throws IOException {
        user.setSignedIn(false);
        getClient().sendToServer(new MsgObject("Home", user));
        //App.setRoot("primary", "/Image/mainPageIcon.png", "Lilac");
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
        nameLabel.setText(user.getUsername());
        switch (SignInController.rank) {

            case "elite":
                userImage.setImage(new Image(getClass().getResourceAsStream("/Image/elitePlan.png")));
                break;

            case "gold":
                userImage.setImage(new Image(getClass().getResourceAsStream("/Image/goldPlan.png")));
                break;

            default:
                userImage.setImage(new Image(getClass().getResourceAsStream("/Image/basicPlan.png")));
                break;
        }
    }
}
