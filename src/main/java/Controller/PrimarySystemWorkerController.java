package Controller;

import il.ac.haifa.cs.sweng.OCSFSimpleChat.App;
import il.ac.haifa.cs.sweng.OCSFSimpleChat.MsgObject;
import javafx.fxml.FXML;

import java.io.IOException;

import static il.ac.haifa.cs.sweng.OCSFSimpleChat.SimpleClient.getClient;

public class PrimarySystemWorkerController {

    @FXML
    void handleEditCatalogueButton() throws IOException {
        getClient().sendToServer(new MsgObject("catalogueSystemWorker"));
    }

    @FXML
    void handleLogoutButton() throws IOException {
        App.setRoot("primary", "/Image/mainPageIcon.png", "Lilac");
    }

}
