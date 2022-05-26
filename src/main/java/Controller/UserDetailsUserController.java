package Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import il.ac.haifa.cs.sweng.OCSFSimpleChat.App;
import il.ac.haifa.cs.sweng.OCSFSimpleChat.Catalog;
import il.ac.haifa.cs.sweng.OCSFSimpleChat.MsgObject;
import il.ac.haifa.cs.sweng.OCSFSimpleChat.Order;
import io.github.palexdev.materialfx.controls.MFXDatePicker;
import io.github.palexdev.materialfx.controls.MFXTextField;
import io.github.palexdev.materialfx.controls.legacy.MFXLegacyComboBox;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

import static Controller.SignInController.user;
import static Controller.SignInController.userName;
import static il.ac.haifa.cs.sweng.OCSFSimpleChat.SimpleClient.getClient;
import static il.ac.haifa.cs.sweng.OCSFSimpleChat.SimpleClient.msgObject;

public class UserDetailsUserController {

    @FXML
    private JFXButton backToCartButton;

    @FXML
    private MFXTextField city;

    @FXML
    private JFXButton confirmButton;

    @FXML
    private JFXCheckBox courier;

    @FXML
    private MFXTextField creditCardExpDate;

    @FXML
    private MFXTextField creditCardHolder;

    @FXML
    private MFXTextField creditCardNumber;

    @FXML
    private MFXTextField cvv;

    @FXML
    private MFXDatePicker datePicker;

    @FXML
    private Label deliveryErrorLabel;

    @FXML
    private JFXButton editMyAccountInformationButton;

    @FXML
    private Label finalPriceLabel;

    @FXML
    private MFXLegacyComboBox<String> hourPicker;

    @FXML
    private JFXCheckBox pickupFromBranch;

    @FXML
    private MFXTextField postOfficeBox;

    @FXML
    private MFXTextField street;

    @FXML
    private MFXTextField zip;

    private double originalPrice;

    @FXML
    void handleBackToCart() throws IOException {
        getClient().sendToServer(new MsgObject("cartUser"));
    }

    @FXML
    void handleConfirm() {

        // Check the notes below maybe you need to use some of them

        // String date = datePicker.getText();
        LocalDate date = datePicker.getValue();

        // city.setText(hourPicker.getValue());
        /*String.valueOf(date.getDayOfMonth());
        String.valueOf(date.getMonthValue());
        String.valueOf(date.getYear());*/

        if (datePicker.getText().equals("") || hourPicker.getValue().equals("") ||
                (!courier.isSelected() && !pickupFromBranch.isSelected())) {
            deliveryErrorLabel.setVisible(true);
            return;
        } else {
            Order order = new Order();
            //checked for digit for month what about day?
            if(date.getMonthValue() < 10)
                order.setDate(date.getYear() + "-0" + date.getMonthValue() + "-" + date.getDayOfMonth() + " " + hourPicker.getValue());
            else
                order.setDate(date.getYear() + "-" + date.getMonthValue() + "-" + date.getDayOfMonth() + " " + hourPicker.getValue());

            order.setShipping(courier.isSelected());
            msgObject.setObject(order);System.out.println(order.getDate());
            try {
                getClient().sendToServer(msgObject);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        confirmButton.setDisable(true);
        backToCartButton.setDisable(true);
        editMyAccountInformationButton.setDisable(true);
    }

    @FXML
    void handleCourier() {

        if (!courier.isSelected()) {
            pickupFromBranch.setDisable(false);
            finalPriceLabel.setText(String.valueOf(originalPrice));
        } else {

            pickupFromBranch.setDisable(true);
            finalPriceLabel.setText(String.valueOf(originalPrice + 10));
        }
    }

    @FXML
    void handleEditMyAccountInformation() {
        // Leave it for now, I'll make a page later
    }

    @FXML
    void handleHome() throws IOException {
        App.setRoot("primaryUser", "/Image/mainPageIcon.png", "Lilac");
    }

    @FXML
    void handlePickUpFromBranch() {

        if (!pickupFromBranch.isSelected()) {
            courier.setDisable(false);
        } else {
            courier.setDisable(true);
        }
        finalPriceLabel.setText(String.valueOf(originalPrice));
    }

    @FXML
    void initialize() {

        String number = "** **** **** ";
        number = user.getCreditCard().substring(0, 2) + number + user.getCreditCard().substring(user.getCreditCard().length() - 4);
        creditCardNumber.setText(number);
        creditCardHolder.setText(user.getHolderOfCard());
        creditCardExpDate.setText(user.getDate());
        cvv.setText(String.valueOf(user.getCvv()));
        city.setText(user.getCity());
        street.setText(user.getStreet());
        zip.setText(user.getZip());
        postOfficeBox.setText(user.getPob());
        for (int i = 9; i <= 19; i++) {
            hourPicker.getItems().add(i + ":00");
        }
        originalPrice = Double.parseDouble(finalPriceLabel.getText());
        double a = 0;
        for(Catalog catalog : msgObject.getCatalogList()){
            a += Double.parseDouble(catalog.getPrice()) + Double.parseDouble(catalog.getPrice());
        }
        finalPriceLabel.setText("" + a);
        originalPrice = a;
    }
}

