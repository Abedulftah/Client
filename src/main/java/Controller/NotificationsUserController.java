package Controller;

import il.ac.haifa.cs.sweng.OCSFSimpleChat.App;
import il.ac.haifa.cs.sweng.OCSFSimpleChat.MsgObject;
import il.ac.haifa.cs.sweng.OCSFSimpleChat.Notifications;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static il.ac.haifa.cs.sweng.OCSFSimpleChat.SimpleClient.getClient;
import static il.ac.haifa.cs.sweng.OCSFSimpleChat.SimpleClient.msgObject;

public class NotificationsUserController {

    @FXML
    private Label totalOrdersLabel;

    @FXML
    private VBox vbox;

    private List<Notifications> notificationsList = msgObject.getNotificationsList();

    @FXML
    void handleDeleteAllButton() throws IOException, SQLException, ClassNotFoundException {

        /*Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dataBaseConnection", "root", "234120");
        String query = "DELETE FROM notifications";
        Statement statement = connection.createStatement();
        statement.execute(query);*/
        getClient().sendToServer(new MsgObject("deleteAllNotifications"));
        getClient().sendToServer(new MsgObject("notificationsUser"));
    }

    @FXML
    void handleHome() throws IOException {
        App.setRoot("primaryUser", "/Image/mainPageIcon.png", "Lilac");
    }

    @FXML
    void initialize() throws IOException {

        for (Notifications notification : notificationsList) {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(App.class.getResource("notificationsItemUser.fxml"));
            Node node = fxmlLoader.load();
            NotificationsItemUserController notificationsItemUserController = fxmlLoader.getController();
            notificationsItemUserController.setData(notification);
            vbox.getChildren().add(node);
        }
    }
}
