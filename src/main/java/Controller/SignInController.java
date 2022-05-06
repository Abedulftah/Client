package Controller;

import il.ac.haifa.cs.sweng.OCSFSimpleChat.MsgObject;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import il.ac.haifa.cs.sweng.OCSFSimpleChat.App;

import java.io.IOException;

import static il.ac.haifa.cs.sweng.OCSFSimpleChat.SimpleClient.getClient;

// In handleSignInButton check what's written

public class SignInController {

    @FXML
    private Label errorMessageLabel;

    @FXML
    void handleContactUs() throws IOException {
        getClient().sendToServer(new MsgObject("contactUs"));
    }

    @FXML
    void handleExitSignIn() {
        System.exit(0);
    }

    @FXML
    void handleHomeSignIn() throws IOException {
        App.setRoot("primary", "/Image/mainPageIcon.png", "Lilac");
    }

    @FXML
    void handleSignInButton() {

        // if the user name is found in the data base and the password is matching with it then
        // App.setRoot("primary", "/Image/mainPageIcon.png", "Lilac");
        // else
        // errorMessage.setVisible(true);
    }

    @FXML
    void handleSignUpButton() throws IOException {
        App.setRoot("SignUp", "/Image/signUpIcon.png", "Sign Up");
    }

    @FXML
    void initialize() {

        errorMessageLabel.setVisible(false);
    }
}