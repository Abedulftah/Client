package Controller;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import il.ac.haifa.cs.sweng.OCSFSimpleChat.App;
import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextArea;

import java.io.IOException;

public class SpecialOrderUserController {

    @FXML
    private JFXCheckBox alstroemeriaCB;

    @FXML
    private TextArea anotherFlowerTA;

    @FXML
    private JFXComboBox<String> blessingMessage;

    @FXML
    private JFXComboBox<String> boxOfChocolate;

    @FXML
    private JFXCheckBox carnationsCB;

    @FXML
    private JFXComboBox<String> chooseContainer;

    @FXML
    private ColorPicker colorPicker;

    @FXML
    private JFXCheckBox daisiesCB;

    @FXML
    private JFXComboBox<String> desiredPrice;

    @FXML
    private JFXCheckBox gerberaCB;

    @FXML
    private JFXCheckBox greenFoliageCB;

    @FXML
    private JFXCheckBox lavenderCB;

    @FXML
    private JFXCheckBox liliesCB;

    @FXML
    private JFXCheckBox lisianthusCB;

    @FXML
    private JFXCheckBox longStemmedRosesCB;

    @FXML
    private JFXCheckBox monteCasinoCB;

    @FXML
    private JFXComboBox<Integer> numberOfFlowers;

    @FXML
    private JFXCheckBox rosesCB;

    @FXML
    private JFXCheckBox seasonalFlowersCB;

    @FXML
    private JFXComboBox<String> teddyBear;

    @FXML
    void handleHome() throws IOException {
        App.setRoot("primaryUser", "/Image/mainPageIcon.png", "Lilac");
    }

    @FXML
    void handlePlaceOrderButton() {

    }

    @FXML
    void initialize() {

        chooseContainer.getItems().addAll("Glass Bowl", "Basket", "Wicker Basket", "Glass Vase", "Vase");
        for (int i = 0; i <= 30; i++) {
            numberOfFlowers.getItems().add(i);
        }
        boxOfChocolate.getItems().addAll("Yes", "No");
        teddyBear.getItems().addAll("Yes", "No");
        blessingMessage.getItems().addAll("Yes", "No");
        desiredPrice.getItems().addAll("$30 - $40", "$40 - $50", "$50 - $60", "$60 - $70", "$70 - $80", "$80 - $90", "$90 - $100", "$100 - $110", "$110 - $120");
    }
}