package Controller;

import il.ac.haifa.cs.sweng.OCSFSimpleChat.MsgObject;
import javafx.fxml.FXML;

import java.io.IOException;

import static Controller.SignInController.user;
import static il.ac.haifa.cs.sweng.OCSFSimpleChat.SimpleClient.getClient;

public class PrimarySingleShopManagerController {

    @FXML
    void handleLogoutButton() throws IOException {
        user.setSignedIn(false);
        getClient().sendToServer(new MsgObject("Home", user));
    }

    @FXML
    void handleShowHistogram() {

    }

}
