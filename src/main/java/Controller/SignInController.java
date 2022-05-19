package Controller;

import il.ac.haifa.cs.sweng.OCSFSimpleChat.MsgObject;
import io.github.palexdev.materialfx.controls.MFXPasswordField;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import il.ac.haifa.cs.sweng.OCSFSimpleChat.App;

import java.io.IOException;

import static il.ac.haifa.cs.sweng.OCSFSimpleChat.SimpleClient.getClient;

// In handleSignInButton check what's written

public class SignInController {

    public static String userName;

    @FXML
    private Label errorMessageLabel;

    @FXML
    private MFXPasswordField passwordTB;

    @FXML
    private MFXTextField userNameTB;

    @FXML
    void handleContactUs() throws IOException {
        getClient().sendToServer(new MsgObject("contactUs"));
    }

    @FXML
    void handleHomeSignIn() throws IOException {
        App.setRoot("primary", "/Image/mainPageIcon.png", "Lilac");
    }

    @FXML
    void handlePasswordEnter() throws IOException {
        handleSignInButton();
    }

    @FXML
    void handleSignInButton() throws IOException {

        userName = userNameTB.getText();
        if (userName.equals("123")) {
            App.setRoot("primarySystemWorker", "/Image/mainPageIcon.png", "Lilac");
            return;
        }
        getClient().sendToServer(new MsgObject("primaryUser"));

        // if the user name is found in the data base and the password is matching with it then
        // App.setRoot("primary", "/Image/mainPageIcon.png", "Lilac");
        // else
        // errorMessage.setVisible(true);
    }

    @FXML
    void handleSignUpButton() throws IOException {
        getClient().sendToServer(new MsgObject("signUpAccountType"));
    }

    @FXML
    void handleUserNameEnter() throws IOException {
        handleSignInButton();
    }

    @FXML
    void initialize() {

        errorMessageLabel.setVisible(false);
    }
}