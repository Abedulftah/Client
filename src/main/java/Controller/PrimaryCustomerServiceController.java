package Controller;


import il.ac.haifa.cs.sweng.OCSFSimpleChat.MsgObject;

import javafx.fxml.FXML;

import java.io.IOException;

import static Controller.SignInController.user;
import static il.ac.haifa.cs.sweng.OCSFSimpleChat.SimpleClient.getClient;


public class PrimaryCustomerServiceController {

    @FXML
    void handleLogoutButton() throws IOException {
        user.setSignedIn(false);
        getClient().sendToServer(new MsgObject("Home", user));
        //App.setRoot("primary", "/Image/mainPageIcon.png", "Lilac");
    }

    @FXML
    void handleShowComplaints() throws IOException {
        getClient().sendToServer(new MsgObject("complaintsCustomerService"));
    }

    @FXML
    void handleSpecialOrders() throws IOException {
        getClient().sendToServer(new MsgObject("specialOrdersCustomerService"));
    }

}
