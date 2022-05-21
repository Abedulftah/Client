package Controller;

import il.ac.haifa.cs.sweng.OCSFSimpleChat.App;
import il.ac.haifa.cs.sweng.OCSFSimpleChat.ComplainRespond;
import il.ac.haifa.cs.sweng.OCSFSimpleChat.MsgObject;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static Controller.SignInController.user;
import static il.ac.haifa.cs.sweng.OCSFSimpleChat.SimpleClient.getClient;
import static il.ac.haifa.cs.sweng.OCSFSimpleChat.SimpleClient.msgObject;

public class NotificationsUserController {

    @FXML
    private Label totalOrdersLabel;

    @FXML
    private VBox vbox;

    @FXML
    void handleDeleteAllButton() {
        try {
            getClient().sendToServer(new MsgObject("removeAllNotification",user));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void handleHome() throws IOException {
        App.setRoot("primaryUser", "/Image/mainPageIcon.png", "Lilac");
    }

    @FXML
    void initialize() throws IOException {

        List<ComplainRespond> complainResponds = (List<ComplainRespond>) msgObject.getObject();

        int counter = 0;
        for (ComplainRespond complainRespond : complainResponds) {
            if(complainRespond.getEmail().equals(user.getEmail())) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(App.class.getResource("notificationsItemUser.fxml"));
                Node node = fxmlLoader.load();
                NotificationsItemUserController notificationsItemUserController = fxmlLoader.getController();
                notificationsItemUserController.setData("New Notification " + counter, complainRespond.getRespondMessage(), complainRespond.getDate());
                vbox.getChildren().add(node);
            }
        }
    }
}
