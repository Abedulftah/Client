package Controller;

import il.ac.haifa.cs.sweng.OCSFSimpleChat.App;
import il.ac.haifa.cs.sweng.OCSFSimpleChat.Catalog;
import il.ac.haifa.cs.sweng.OCSFSimpleChat.MsgObject;
import il.ac.haifa.cs.sweng.OCSFSimpleChat.MyListener;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static il.ac.haifa.cs.sweng.OCSFSimpleChat.SimpleClient.getClient;
import static il.ac.haifa.cs.sweng.OCSFSimpleChat.SimpleClient.msgObject;

// Check what's written in handleAddToCart

public class CatalogueUserController {

    private boolean flag = false;

    @FXML
    private VBox chosenItem;

    @FXML
    private Label chosenItemDetails;

    @FXML
    private ImageView chosenItemImage;

    @FXML
    private Label chosenItemName;

    @FXML
    private Label chosenItemPrice;

    @FXML
    private Label chosenItemSize;

    @FXML
    private GridPane gridPane;

    @FXML
    private TextField searchItemTB;

    @FXML
    private ImageView quantityImage;

    @FXML
    private Label quantityLabel;

    @FXML
    private MFXTextField quantityTB;

    private final List<Catalog> flowerList = msgObject.getCatalogList();

    private MyListener myListener;

    @FXML
    void handleAddToCart() {

        handleQuantityTBKeyPressed();
        if (!flag) return;
        chosenItemName.getText();
        chosenItemPrice.getText();
        chosenItemSize.getText();
        chosenItemDetails.getText();
        quantityTB.getText();

        // Add these items to cart database along with the quantity
    }

    @FXML
    void handleQuantityQuestionMarkEnter() {
        quantityLabel.setVisible(true);
    }

    @FXML
    void handleQuantityQuestionMarkExit() {
        quantityLabel.setVisible(false);
    }

    @FXML
    void handleQuantityTBKeyPressed() {

        String text = quantityTB.getText();
        String regularExpressionPattern = "^(0|[1-9][0-9]*)$";
        Pattern pattern = Pattern.compile(regularExpressionPattern);
        Matcher matcher = pattern.matcher(text);
        if (!matcher.matches() || text.equals("0")) {
            flag = false;
            quantityImage.setImage(new Image(getClass().getResourceAsStream("/Image/remove.png")));
        } else {
            flag = true;
            quantityImage.setImage(new Image(getClass().getResourceAsStream("/Image/accept.png")));
        }
        quantityImage.setVisible(true);
    }

    @FXML
    void handleQuantityTBKeyReleased() {
        handleQuantityTBKeyPressed();
    }

    @FXML
    void handleVisitCart() throws IOException {
        getClient().sendToServer(new MsgObject("cartUser"));
    }

    private void setChosenItem(Catalog catalog) {
        chosenItemName.setText(catalog.getName());
        chosenItemPrice.setText("Price: " + App.CURRENCY + catalog.getPrice());
        chosenItemDetails.setText(catalog.getItemDetails());
        chosenItemSize.setText(catalog.getSize());
        Image image = new Image(catalog.getImgUrl());
        chosenItemImage.setImage(image);
        chosenItem.setStyle("-fx-background-color: #" + catalog.getColor() + ";\n" +
                "    -fx-background-radius: 30;");
    }

    @FXML
    void searchItemTBKeyPressed() {

        gridPane.getChildren().clear();
        String text = searchItemTB.getText();
        if (text.equals("")) {
            loadGridPane();
            return;
        }
        myListener = this::setChosenItem;
        int column = 0;
        int row = 1;

        for (Catalog value : flowerList) {
            try {
                if (value.getName().toUpperCase().contains(text.toUpperCase())) {
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("/il/ac/haifa/cs/sweng/OCSFSimpleChat/Item.fxml"));

                    AnchorPane anchorPane = fxmlLoader.load();

                    ItemController itemController = fxmlLoader.getController();
                    itemController.setData(value, myListener);

                    if (column == 3) {
                        column = 0;
                        row++;
                    }

                    gridPane.add(anchorPane, column++, row);
                    gridPane.setMinWidth(Region.USE_COMPUTED_SIZE);
                    gridPane.setPrefWidth(Region.USE_COMPUTED_SIZE);
                    gridPane.setMaxWidth(Region.USE_PREF_SIZE);

                    gridPane.setMinHeight(Region.USE_COMPUTED_SIZE);
                    gridPane.setPrefHeight(Region.USE_COMPUTED_SIZE);
                    gridPane.setMaxHeight(Region.USE_PREF_SIZE);

                    GridPane.setMargin(anchorPane, new Insets(10));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void searchItemTBKeyReleased() {

        searchItemTBKeyPressed();
    }

    @FXML
    void handleHomeCatalog() throws IOException {
        App.setRoot("primaryUser", "/Image/mainPageIcon.png", "Lilac");
    }

    private void loadGridPane() {
        myListener = this::setChosenItem;
        int column = 0;
        int row = 1;

        for (Catalog value : flowerList) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/il/ac/haifa/cs/sweng/OCSFSimpleChat/Item.fxml"));

                AnchorPane anchorPane = fxmlLoader.load();

                ItemController itemController = fxmlLoader.getController();
                itemController.setData(value, myListener);

                if (column == 3) {
                    column = 0;
                    row++;
                }

                gridPane.add(anchorPane, column++, row);
                gridPane.setMinWidth(Region.USE_COMPUTED_SIZE);
                gridPane.setPrefWidth(Region.USE_COMPUTED_SIZE);
                gridPane.setMaxWidth(Region.USE_PREF_SIZE);

                gridPane.setMinHeight(Region.USE_COMPUTED_SIZE);
                gridPane.setPrefHeight(Region.USE_COMPUTED_SIZE);
                gridPane.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void initialize() {

        if (flowerList.size() > 0) setChosenItem(flowerList.get(0));
        loadGridPane();
    }
}
