package Controller;

import il.ac.haifa.cs.sweng.OCSFSimpleChat.App;
import il.ac.haifa.cs.sweng.OCSFSimpleChat.Complain;
import il.ac.haifa.cs.sweng.OCSFSimpleChat.SignUp;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.List;

import static il.ac.haifa.cs.sweng.OCSFSimpleChat.SimpleClient.msgObject;

public class ComplaintsCustomerServiceController {

    @FXML
    private Label totalOrdersLabel;

    @FXML
    private VBox vbox;

    private List<Complain> complainList = (List<Complain>) msgObject.getObject();

    @FXML
    void handleHome() throws IOException {
        App.setRoot("primaryCustomerService", "/Image/mainPageIcon.png", "Lilac");
    }

    @FXML
    void initialize() throws IOException {

        for (Complain complain : complainList) {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(App.class.getResource("complaintsItemCustomerService.fxml"));
            Node node = fxmlLoader.load();
            ComplaintsItemCustomerServiceController complaintsItemCustomerServiceController = fxmlLoader.getController();
            complaintsItemCustomerServiceController.setData(complain);
            vbox.getChildren().add(node);
        }

        totalOrdersLabel.setText("Total Complaints: " + complainList.size());
    }
}
