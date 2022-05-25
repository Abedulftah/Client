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
    void handleComplaintComparison() throws IOException {
        String numberOfShops = comparisonFirstShopComplaintCB.getValue() + " ";
        numberOfShops = numberOfShops + comparisonSecondShopComplaintCB.getValue();
        getClient().sendToServer(new MsgObject("compareHist Complaints", numberOfShops));

    }

    @FXML
    void handleComplaintHistogram() throws IOException {
        getClient().sendToServer(new MsgObject("Histogram Complaints", singleShopComplaintCB.getValue()));
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
    void handleOrdersComparison() throws IOException {
        String numberOfShops = comparisonFirstShopOrdersCB.getValue() + " ";
        numberOfShops = numberOfShops + comparisonSecondShopOrdersCB.getValue();
        getClient().sendToServer(new MsgObject("compareHist Orders", numberOfShops));
    }

    @FXML
    void handleOrdersHistogram() throws IOException {
        getClient().sendToServer(new MsgObject("Histogram Orders", singleShopOrdersCB.getValue()));
    }

    @FXML
    void handleProfitComparison() throws IOException {
        String numberOfShops = comparisonFirstShopProfitCB.getValue() + " ";
        numberOfShops = numberOfShops + comparisonSecondShopProfitCB.getValue();
        getClient().sendToServer(new MsgObject("compareHist Profit", numberOfShops));
    }

    @FXML
    void handleProfitHistogram() throws IOException {
        getClient().sendToServer(new MsgObject("Histogram Profit", singleShopProfitCB.getValue()));
    }

    @FXML
    void handleShowComplaints() throws IOException {
        //when we click on the home button it will redirect us to the main page of customer service worker
        getClient().sendToServer(new MsgObject("complaintsCustomerService"));
    }

    @FXML
    void handleShowSpecialOrders() throws IOException {
        //when we click on the home button it will redirect us to the main page of customer service worker
        getClient().sendToServer(new MsgObject("specialOrdersCustomerService"));

    }

    @FXML
    void handleShowUsers() {
        //getUsersInformation
        //will enable the manager to edit the details
    }

    @FXML
    void initialize() {

        List<Integer> shopList = new ArrayList<>();
        for (int i = 1; i <= 11; i++) shopList.add(i);
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