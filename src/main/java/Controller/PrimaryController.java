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
        assert buttonCatalog != null : "fx:id=\"buttonCatalog\" was not injected: check your FXML file 'MainPage.fxml'.";
        assert buttonContactUs != null : "fx:id=\"buttonContactUs\" was not injected: check your FXML file 'MainPage.fxml'.";
        assert buttonSignIn != null : "fx:id=\"buttonSignIn\" was not injected: check your FXML file 'MainPage.fxml'.";
        assert buttonSignUp != null : "fx:id=\"buttonSignUp\" was not injected: check your FXML file 'MainPage.fxml'.";
        assert pnlCustomer != null : "fx:id=\"pnlCustomer\" was not injected: check your FXML file 'MainPage.fxml'.";

    }
}
