package Controller;

import il.ac.haifa.cs.sweng.OCSFSimpleChat.App;
import il.ac.haifa.cs.sweng.OCSFSimpleChat.MsgObject;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

import java.io.IOException;

import static Controller.SignInController.user;
import static Controller.SignInController.userName;
import static il.ac.haifa.cs.sweng.OCSFSimpleChat.SimpleClient.getClient;

public class UserDetailsUserController {

    @FXML
    private MFXTextField city;

    @FXML
    private MFXTextField creditCardExpDate;

    @FXML
    private MFXTextField creditCardHolder;

    @FXML
    private MFXTextField creditCardNumber;

    @FXML
    private MFXTextField cvv;

    @FXML
    private MFXTextField postOfficeBox;

    @FXML
    private MFXTextField street;

    @FXML
    private MFXTextField zip;

    @FXML
    void handleBackToCart() throws IOException {
        getClient().sendToServer(new MsgObject("cartUser"));
    }

    @FXML
    void handleHome() throws IOException {
        App.setRoot("primaryUser", "/Image/mainPageIcon.png", "Lilac");
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
    }
}
