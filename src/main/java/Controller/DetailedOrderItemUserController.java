package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DetailedOrderItemUserController {

    @FXML
    private Label descriptionLabel;

    @FXML
    private Label nameLabel;

    @FXML
    private Label priceLabel;

    @FXML
    private Label quantityLabel;

    @FXML
    private Label sizeLabel;

    @FXML
    void handleRemoveButton() {

        // Don't forget that if the last item was removed then you have to remove the whole order
        // I didn't add a remove all button in DetailedOrderUserController in purpose since if the user tend
        // To remove everything he must remove the order from the main page
    }
}
