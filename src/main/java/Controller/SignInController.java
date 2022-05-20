package Controller;

import il.ac.haifa.cs.sweng.OCSFSimpleChat.MsgObject;
import il.ac.haifa.cs.sweng.OCSFSimpleChat.SignUp;
import io.github.palexdev.materialfx.controls.MFXPasswordField;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import il.ac.haifa.cs.sweng.OCSFSimpleChat.App;

import java.io.IOException;
import java.util.List;

import static il.ac.haifa.cs.sweng.OCSFSimpleChat.SimpleClient.getClient;
import static il.ac.haifa.cs.sweng.OCSFSimpleChat.SimpleClient.msgObject;

// In handleSignInButton check what's written

public class SignInController {

    public static String userName;

    public static SignUp user;

    public static String rank;

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
    void handleSignInButton() throws IOException {

        userName = userNameTB.getText();
        boolean find = false;

        List<SignUp> signup = (List<SignUp>) msgObject.getObject();

        if (!signup.isEmpty()) {
            for (SignUp usr : signup) {
                if ((usr.getEmail().equals(userName) && usr.getPassword().equals(passwordTB.getText())) ||
                usr.getUsername().equals(userName) && usr.getPassword().equals(passwordTB.getText())) {
                    user = usr;
                    find = true;
                    userName = usr.getUsername();
                    rank = usr.getAccountType();
                    break;
                }
            }
        }
        //getClient().sendToServer(new MsgObject("CheckValidUser", str));

        // if the user name is found in the data base and the password is matching with it then
        // App.setRoot("primary", "/Image/mainPageIcon.png", "Lilac");
        if(!find)
            errorMessageLabel.setVisible(true);
        else {

            switch (user.getAccountType()) {

                case "system worker":
                    App.setRoot("primarySystemWorker", "/Image/mainPageIcon.png", "Lilac");
                    break;

                case "customer service":
                    App.setRoot("primaryCustomerService", "/Image/mainPageIcon.png", "Lilac");
                    break;

                case "system manager":
                    /////
                    break;

                case "shop manager":
                    ////
                    break;

                default:
                    getClient().sendToServer(new MsgObject("primaryUser"));

            }
        }
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
    void handlePasswordEnter() throws IOException {
        handleSignInButton();
    }

    @FXML
    void initialize() {

        errorMessageLabel.setVisible(false);
    }
}