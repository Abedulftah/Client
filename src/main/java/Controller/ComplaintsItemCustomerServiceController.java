package Controller;

import il.ac.haifa.cs.sweng.OCSFSimpleChat.Complain;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ComplaintsItemCustomerServiceController {

    @FXML
    private Label contentLabel;

    @FXML
    private Label emailLabel;

    private Complain complain;

    @FXML
    void handleRefuseButton() {

    }

    @FXML
    void handleRespondButton() {

    }

    public void setData(Complain complain) {

        this.complain = complain;
        this.emailLabel.setText(complain.getEmail());
        this.contentLabel.setText(complain.getMessage());
    }

}
