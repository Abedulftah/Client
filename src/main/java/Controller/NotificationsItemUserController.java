package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class NotificationsItemUserController {

    @FXML
    private Label dateLabel;

    @FXML
    private Label notificationLabel;

    @FXML
    private Label responseLabel;

    @FXML
    void handleRemoveButton() {

    }

    public void setData(String notification, String response, String date) {
        this.notificationLabel.setText(notification);
        this.responseLabel.setText(response);
        this.dateLabel.setText(date);
    }
}
