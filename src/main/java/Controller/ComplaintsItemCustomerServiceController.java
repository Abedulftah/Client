package Controller;

import il.ac.haifa.cs.sweng.OCSFSimpleChat.Complain;
import il.ac.haifa.cs.sweng.OCSFSimpleChat.ComplainRespond;
import il.ac.haifa.cs.sweng.OCSFSimpleChat.MsgObject;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

import static Controller.SignInController.user;
import static il.ac.haifa.cs.sweng.OCSFSimpleChat.SimpleClient.getClient;

public class ComplaintsItemCustomerServiceController {

    @FXML
    private Label contentLabel;

    @FXML
    private Label emailLabel;

    private Complain complain;

    @FXML
    void handleRefuseButton() {
        ComplainRespond complainRespond = new ComplainRespond(user.getUsername(), complain.getName(), complain.getEmail(), complain.getPhone(), complain.getMessage(), "Sorry, that we did not fill your demands, we will do our best to make it better.\n We did not see that you deserve refund.");
        try {
            getClient().sendToServer(new MsgObject("messageRespond",complainRespond));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
