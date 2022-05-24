package Controller;

import il.ac.haifa.cs.sweng.OCSFSimpleChat.MsgObject;
import javafx.fxml.FXML;

import java.io.IOException;

import static Controller.SignInController.user;
import static il.ac.haifa.cs.sweng.OCSFSimpleChat.SimpleClient.getClient;

public class PrimarySingleShopManagerController {

    @FXML
    void handleComplaintHistogram() throws IOException {
        String[] strings = user.getAccountType().split(" ");
        getClient().sendToServer(new MsgObject("Histogram Complaints", Integer.parseInt(strings[2])));

    }

    @FXML
    void handleLogoutButton() throws IOException {
        user.setSignedIn(false);
        getClient().sendToServer(new MsgObject("Home", user));
    }

    @FXML
    void handleOrdersHistogram() throws IOException {
        String[] strings = user.getAccountType().split(" ");
        getClient().sendToServer(new MsgObject("Histogram Orders", Integer.parseInt(strings[2])));
    }

    @FXML
    void handleProfitHistogram() throws IOException {
        String[] strings = user.getAccountType().split(" ");
        getClient().sendToServer(new MsgObject("Histogram Profit", Integer.parseInt(strings[2])));
    }
}