package Controller;

import il.ac.haifa.cs.sweng.OCSFSimpleChat.MsgObject;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

import java.io.IOException;

import static il.ac.haifa.cs.sweng.OCSFSimpleChat.SimpleClient.getClient;

public class PrimaryController {

    @FXML
    private Button buttonCatalog;

    @FXML
    private Button buttonContactUs;

    @FXML
    private Button buttonSignIn;

    @FXML
    private Button buttonSignUp;

    @FXML
    private Pane pnlCustomer;

    @FXML
    void SignUpHandle() throws IOException {
        getClient().sendToServer(new MsgObject("signUpAccountType"));
    }

    @FXML
    void catalogHandle() throws IOException {
        getClient().sendToServer(new MsgObject("Catalog"));
    }

    @FXML
    void contactUsHandle() throws IOException {
        getClient().sendToServer(new MsgObject("contactUs"));
    }

    @FXML
    void signInHandle() throws IOException {
        getClient().sendToServer(new MsgObject("signIn"));
    }

    @FXML
    void initialize() {

    }
}
