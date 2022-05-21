package Controller;

import il.ac.haifa.cs.sweng.OCSFSimpleChat.CustomerWorkerRespond;
import il.ac.haifa.cs.sweng.OCSFSimpleChat.MsgObject;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

import static il.ac.haifa.cs.sweng.OCSFSimpleChat.SimpleClient.getClient;

public class NotificationsItemUserController {

    private CustomerWorkerRespond complainRespond;
    @FXML
    private Label dateLabel;

    @FXML
    private Label notificationLabel;

    @FXML
    private Label responseLabel;

    @FXML
    void handleRemoveButton() {
        try {
            getClient().sendToServer(new MsgObject("removeNotification", complainRespond));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setData(CustomerWorkerRespond complainRespond, String notification, String response, String date) {
        this.complainRespond = complainRespond;
        this.notificationLabel.setText(notification);
        this.responseLabel.setText(response);
        this.dateLabel.setText(date);
    }
}
