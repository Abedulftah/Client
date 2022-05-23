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
    private JFXComboBox<Integer> comparisonFirstShopComplaintCB;

    @FXML
    private JFXComboBox<Integer> comparisonFirstShopOrdersCB;

    @FXML
    private JFXComboBox<Integer> comparisonFirstShopProfitCB;

    @FXML
    private JFXComboBox<Integer> comparisonSecondShopComplaintCB;

    @FXML
    private JFXComboBox<Integer> comparisonSecondShopOrdersCB;

    @FXML
    private JFXComboBox<Integer> comparisonSecondShopProfitCB;

    @FXML
    private JFXComboBox<Integer> singleShopComplaintCB;

    @FXML
    private JFXComboBox<Integer> singleShopOrdersCB;

    @FXML
    private JFXComboBox<Integer> singleShopProfitCB;

    @FXML
    void handleComplaintComparison() {

    }

    @FXML
    void handleComplaintHistogram() {

    }

    @FXML
    void handleEditCatalogue() {

    }

    @FXML
    void handleLogoutButton() throws IOException {
        user.setSignedIn(false);
        getClient().sendToServer(new MsgObject("Home", user));
    }

    @FXML
    void handleOrdersComparison() {

    }

    @FXML
    void handleOrdersHistogram() {

    }

    @FXML
    void handleProfitComparison() {

    }

    @FXML
    void handleProfitHistogram() {

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
    void initialize() {

        List<Integer> shopList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) shopList.add(i);
        singleShopComplaintCB.getItems().addAll(shopList);
        singleShopProfitCB.getItems().addAll(shopList);
        singleShopOrdersCB.getItems().addAll(shopList);
        comparisonFirstShopComplaintCB.getItems().addAll(shopList);
        comparisonSecondShopComplaintCB.getItems().addAll(shopList);
        comparisonFirstShopProfitCB.getItems().addAll(shopList);
        comparisonSecondShopProfitCB.getItems().addAll(shopList);
        comparisonFirstShopOrdersCB.getItems().addAll(shopList);
        comparisonSecondShopOrdersCB.getItems().addAll(shopList);
    }
}
