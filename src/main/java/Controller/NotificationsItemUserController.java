package Controller;

import il.ac.haifa.cs.sweng.OCSFSimpleChat.MsgObject;
import il.ac.haifa.cs.sweng.OCSFSimpleChat.Notifications;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;

import java.io.IOException;
import java.util.List;

import static il.ac.haifa.cs.sweng.OCSFSimpleChat.SimpleClient.getClient;
import static il.ac.haifa.cs.sweng.OCSFSimpleChat.SimpleClient.msgObject;

public class NotificationsItemUserController {

    @FXML
    private Label dateLabel;

    @FXML
    private Label emailLabel;

    @FXML
    private Label notificationLabel;

    @FXML
    private Label responseLabel;

    private Notifications notification;

    @FXML
    void handleRemoveButton() throws IOException {

        getClient().sendToServer(new MsgObject("deleteNotification", notification.getId()));
        getClient().sendToServer(new MsgObject("notificationsUser"));
    }

    public void setData(Notifications notification) {
        this.notification = notification;
        this.emailLabel.setText(notification.getEmail());
        this.notificationLabel.setText(notification.getNotification());
        this.responseLabel.setText(notification.getResponse());
        this.dateLabel.setText(notification.getDate());
    }
}
