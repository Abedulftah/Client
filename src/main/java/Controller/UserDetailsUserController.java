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

import java.io.IOException;
import java.time.LocalDate;
import java.util.Calendar;

import static Controller.SignInController.user;
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
    private MFXTextField deliveryReceiverName;

    @FXML
    private MFXTextField deliveryReceiverPhone;

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
        LocalDate localDate = LocalDate.now();
        Calendar calendar = Calendar.getInstance();

        // city.setText(hourPicker.getValue());
        /*String.valueOf(date.getDayOfMonth());
        String.valueOf(date.getMonthValue());
        String.valueOf(date.getYear());*/

        String hour = hourPicker.getValue().substring(0, 2);
        int currentHour = calendar.get(Calendar.HOUR_OF_DAY) + 1;

        if (datePicker.getText().equals("") || hourPicker.getValue().equals("") ||
                (!courier.isSelected() && !pickupFromBranch.isSelected()) ||
                deliveryReceiverName.getText().equals("") || deliveryReceiverPhone.getText().equals("")) {
            deliveryErrorLabel.setText("Please fill the requested fields");
            deliveryErrorLabel.setVisible(true);
            return;
        } else if (date.getYear() < localDate.getYear() ||
                date.getMonthValue() < localDate.getMonthValue() ||
                (date.getMonthValue() == localDate.getMonthValue() && date.getDayOfMonth() < localDate.getDayOfMonth())) {
            deliveryErrorLabel.setText("Please select valid values for each field");
            deliveryErrorLabel.setVisible(true);
            return;
        } else if (Integer.parseInt(hour) < currentHour
                && date.getYear() == localDate.getYear() && date.getMonthValue() == localDate.getMonthValue()
                && date.getDayOfMonth() == localDate.getDayOfMonth()) {
            deliveryErrorLabel.setText("Please select valid hour");
            deliveryErrorLabel.setVisible(true);
            return;
        } else {
            Order order = new Order();
            if (date.getMonthValue() < 10)
                order.setDate(date.getYear() + "-0" + date.getMonthValue() + "-" + date.getDayOfMonth() + " " + hourPicker.getValue());
            else
                order.setDate(date.getYear() + "-" + date.getMonthValue() + "-" + date.getDayOfMonth() + " " + hourPicker.getValue());

            order.setShipping(courier.isSelected());
            order.setName(deliveryReceiverName.getText());
            order.setPhone(deliveryReceiverPhone.getText());
            msgObject.setObject(order);
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
    void handleEditMyAccountInformation() throws IOException {
        // Leave it for now, I'll make a page later
        getClient().sendToServer(new MsgObject("editAccountInformation"));
    }

    @FXML
    void handleHome() throws IOException {
        App.setRoot("primaryUser", "/Image/mainPageIcon.png", "Lilac");
    }

    @FXML
    void handlePickUpFromBranch() {

        courier.setDisable(pickupFromBranch.isSelected());
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
        for (int i = 10; i <= 19; i++) {
            hourPicker.getItems().add(i + ":00");
        }
        originalPrice = Double.parseDouble(finalPriceLabel.getText());
        double a = 0;
        for (Catalog catalog : msgObject.getCatalogList()) {
            a += Double.parseDouble(catalog.getPrice()) + Double.parseDouble(catalog.getPrice());
        }
        finalPriceLabel.setText("" + a);
        originalPrice = a;
    }
}

