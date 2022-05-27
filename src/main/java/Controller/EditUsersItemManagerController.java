package Controller;

import com.jfoenix.controls.JFXButton;
import il.ac.haifa.cs.sweng.OCSFSimpleChat.App;
import il.ac.haifa.cs.sweng.OCSFSimpleChat.MsgObject;
import il.ac.haifa.cs.sweng.OCSFSimpleChat.SignUp;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;

import java.io.IOException;

import static il.ac.haifa.cs.sweng.OCSFSimpleChat.SimpleClient.getClient;
import static Controller.EditUsersManagerController.addFlag;

public class EditUsersItemManagerController {

    @FXML
    private Label accountType;

    @FXML
    private JFXButton bannedButton;

    @FXML
    private Label email;

    @FXML
    private Label password;

    public static SignUp signUp;

    private SignUp sign;

    @FXML
    void handleBannedButton() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Ban Confirmation");
        alert.setHeaderText("Are you sure you want to ban this user?");
        ButtonType confirmButton = new ButtonType("Confirm", ButtonBar.ButtonData.YES);
        ButtonType cancelButton = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(confirmButton, cancelButton);

        alert.showAndWait().ifPresent(type -> {
            if (type == confirmButton) {
                sign.setBanned(!sign.isBanned());
                try {
                    getClient().sendToServer(new MsgObject("addUser", sign));
                    //getClient().sendToServer(new MsgObject("editUsersManager", sign));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    @FXML
    void handleEditButton() throws IOException {
        addFlag = false;
        signUp = sign;
        getClient().sendToServer(new MsgObject("editUserManager"));
    }

    @FXML
    void handleRemoveButton() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete Confirmation");
        alert.setHeaderText("Are you sure you want to delete this user? This operation is irreversible");
        ButtonType confirmButton = new ButtonType("Confirm", ButtonBar.ButtonData.YES);
        ButtonType cancelButton = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(confirmButton, cancelButton);

        alert.showAndWait().ifPresent(type -> {
            if (type == confirmButton) {
                try {
                    getClient().sendToServer(new MsgObject("removeUserManager", sign));
                    getClient().sendToServer(new MsgObject("editUsersManager", sign));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    public void setData(SignUp signUp) {
        this.sign = signUp;
        email.setText(signUp.getEmail());
        password.setText(signUp.getPassword());
        accountType.setText(signUp.getAccountType());
        if (!signUp.isBanned()) {
            bannedButton.setText("Ban");
        } else {
            bannedButton.setText("Unban");
        }
    }
}
