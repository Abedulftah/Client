package Controller;

import il.ac.haifa.cs.sweng.OCSFSimpleChat.App;
import il.ac.haifa.cs.sweng.OCSFSimpleChat.MsgObject;
import javafx.fxml.FXML;

import java.io.IOException;

import static il.ac.haifa.cs.sweng.OCSFSimpleChat.SimpleClient.getClient;

public class PrimaryCustomerServiceController {

    @FXML
    void handleLogoutButton() throws IOException {
        App.setRoot("primary", "/Image/mainPageIcon.png", "Lilac");
    }

    @FXML
    void handleShowComplaints() throws IOException {
        getClient().sendToServer(new MsgObject("complaintsCustomerService"));
    }

    @FXML
    void handleSpecialOrders() throws IOException {
        App.setRoot("specialOrdersCustomerService", "/Image/specialOrderIcon.png", "Special Order");
        //getClient().sendToServer(new MsgObject("specialOrdersCustomerService"));
    }

}
