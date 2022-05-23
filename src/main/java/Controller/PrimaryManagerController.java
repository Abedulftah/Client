package Controller;

import com.jfoenix.controls.JFXComboBox;
import il.ac.haifa.cs.sweng.OCSFSimpleChat.MsgObject;
import javafx.fxml.FXML;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static Controller.SignInController.user;
import static il.ac.haifa.cs.sweng.OCSFSimpleChat.SimpleClient.getClient;

public class PrimaryManagerController {

    @FXML
    private JFXComboBox<Integer> comparisonFirstShopCB;

    @FXML
    private JFXComboBox<Integer> comparisonSecondShopCB;

    @FXML
    private JFXComboBox<Integer> singleShopCB;

    @FXML
    void handleEditCatalogue() {

    }

    @FXML
    void handleHistogramComparison() {

    }

    @FXML
    void handleLogoutButton() throws IOException {
        user.setSignedIn(false);
        getClient().sendToServer(new MsgObject("Home", user));
    }

    @FXML
    void handleShowComplaints() {

    }

    @FXML
    void handleShowSpecialOrders() {

    }

    @FXML
    void handleShowUsers() {

    }

    @FXML
    void handleSingleHistogram() {

    }

    @FXML
    void initialize() {

        List<Integer> shopList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) shopList.add(i);
        singleShopCB.getItems().addAll(shopList);
        comparisonFirstShopCB.getItems().addAll(shopList);
        comparisonSecondShopCB.getItems().addAll(shopList);
    }
}
