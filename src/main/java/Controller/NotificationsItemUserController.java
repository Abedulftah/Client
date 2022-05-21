package Controller;

import il.ac.haifa.cs.sweng.OCSFSimpleChat.MsgObject;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

import static Controller.SignInController.user;
import static il.ac.haifa.cs.sweng.OCSFSimpleChat.SimpleClient.getClient;

public class NotificationsItemUserController {

    @FXML
    private Label dateLabel;

    @FXML
    private Label notificationLabel;

    @FXML
    private Label responseLabel;

    @FXML
    void handleRemoveButton() {
        try {
            getClient().sendToServer(new MsgObject("removeNotification",user));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setData(String notification, String response, String date) {
        this.notificationLabel.setText(notification);
        this.responseLabel.setText(response);
        this.dateLabel.setText(date);
    }
}
