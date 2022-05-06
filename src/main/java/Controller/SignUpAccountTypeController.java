package Controller;

import com.jfoenix.controls.JFXComboBox;
import com.sun.scenario.effect.Effect;
import io.github.palexdev.materialfx.controls.MFXComboBox;
import javafx.fxml.FXML;
import javafx.scene.effect.Bloom;
import javafx.scene.image.ImageView;

public class SignUpAccountTypeController {

    public static String accountType;

    @FXML
    private ImageView basicMemberShip;

    @FXML
    private ImageView basicXImage;

    @FXML
    private MFXComboBox<Integer> chooseShopCB;

    @FXML
    private ImageView eliteMemberShip;

    @FXML
    private ImageView goldMemberShip;

    @FXML
    void handleBasicMemberShip() {

        chooseShopCB.setVisible(true);
        basicXImage.setVisible(false);
        accountType = "basic";
        basicMemberShip.setEffect(new Bloom());
        goldMemberShip.setEffect(null);
        eliteMemberShip.setEffect(null);
    }

    @FXML
    void handleChooseShopCB() {

        chooseShopCB.show();
    }

    @FXML
    void handleEliteMemberShip() {

        chooseShopCB.setVisible(false);
        basicXImage.setVisible(true);
        accountType = "elite";
        basicMemberShip.setEffect(null);
        goldMemberShip.setEffect(null);
        eliteMemberShip.setEffect(new Bloom());
    }

    @FXML
    void handleGoldMemberShip() {

        chooseShopCB.setVisible(false);
        basicXImage.setVisible(true);
        accountType = "gold";
        basicMemberShip.setEffect(null);
        goldMemberShip.setEffect(new Bloom());
        eliteMemberShip.setEffect(null);
    }

    @FXML
    void handleHomeButton() {

    }

    @FXML
    void handleNextPage() {

    }

    @FXML
    void initialize() {

        chooseShopCB.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        chooseShopCB.setVisible(false);
    }
}