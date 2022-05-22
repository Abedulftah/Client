package Controller;

import il.ac.haifa.cs.sweng.OCSFSimpleChat.App;
import il.ac.haifa.cs.sweng.OCSFSimpleChat.MsgObject;
import il.ac.haifa.cs.sweng.OCSFSimpleChat.SignUp;
import javafx.fxml.FXML;

import java.io.IOException;

import static Controller.SignInController.user;
import static il.ac.haifa.cs.sweng.OCSFSimpleChat.SimpleClient.getClient;
import static il.ac.haifa.cs.sweng.OCSFSimpleChat.SimpleClient.msgObject;

public class PrimarySystemWorkerController {

    @FXML
    void handleEditCatalogueButton() throws IOException {
        getClient().sendToServer(new MsgObject("catalogueSystemWorker"));
    }

    @FXML
    void handleLogoutButton() throws IOException {
        user.setSignedIn(false);
        getClient().sendToServer(new MsgObject("Home", user));
        //App.setRoot("primary", "/Image/mainPageIcon.png", "Lilac");
    }
}
