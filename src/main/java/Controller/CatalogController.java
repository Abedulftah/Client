package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import il.ac.haifa.cs.sweng.OCSFSimpleChat.Catalog;
import il.ac.haifa.cs.sweng.OCSFSimpleChat.MsgObject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import il.ac.haifa.cs.sweng.OCSFSimpleChat.App;
import il.ac.haifa.cs.sweng.OCSFSimpleChat.MyListener;

import static il.ac.haifa.cs.sweng.OCSFSimpleChat.SimpleClient.getClient;
import static il.ac.haifa.cs.sweng.OCSFSimpleChat.SimpleClient.msgObject;

public class CatalogController implements Initializable {

    @FXML
    private VBox chosenItem;

    @FXML
    private Button chosenItemChangePriceButton;

    @FXML
    private TextField chosenItemChangePriceTB;

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
    private ImageView currentPageIcon;

    @FXML
    private Label currentPageName;

    @FXML
    private GridPane gridPane;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private Button searchItemButton;

    @FXML
    private Label errorLabel;

    @FXML
    private TextField searchItemTB;

    private final List<Catalog> flowerList = msgObject.getCatalogList();

    private MyListener myListener;


    private void setChosenItem(Catalog catalog) {
        chosenItemName.setText(catalog.getName());
        chosenItemPrice.setText(App.CURRENCY + catalog.getPrice());
        chosenItemDetails.setText(catalog.getItemDetails());
        chosenItemSize.setText(catalog.getSize());
        Image image = new Image(catalog.getImage().getUrl());
        chosenItemImage.setImage(image);
        chosenItem.setStyle("-fx-background-color: #" + catalog.getColor() + ";\n" +
                "    -fx-background-radius: 30;");
    }

    @FXML
    void handleExitCatalog(ActionEvent event) {
        System.exit(0);
    }


    @FXML
    void textChanged() {
        pressSearch();
    }

    @FXML
    void priceTB() {
        sendRequestButton();
    }

    @FXML
    void sendRequestButton() {

        String name = chosenItemName.getText();
        String text = chosenItemChangePriceTB.getText();
        try {
            double price = Double.parseDouble(text);
            errorLabel.setTextFill(Color.web("#43bd13"));
            errorLabel.setText("The request was sent successfully");

            //chosenItemPrice.setText(App.CURRENCY + price);

            for(Catalog c : flowerList){
                if(c.getName().equals(name)){
                    c.setPrice(price);
                }
            }

            MsgObject msg = new MsgObject("edit");
            msg.setCatalogList(flowerList);
            getClient().sendToServer(msg);
        } catch (Exception e) {
            errorLabel.setTextFill(Color.web("#ff0000"));
            errorLabel.setText("The price must be numeric, Try again");
            //e.printStackTrace();
        }
    }

    @FXML
    void pressSearch() {
        gridPane.getChildren().clear();
        String text = searchItemTB.getText();
        if (text.equals("")) {
            loadGridPane();
            return;
        }
        myListener = new MyListener() {
            @Override
            public void onClickListener(Catalog catalog) {
                setChosenItem(catalog);
            }
        };
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
    void handleHomeCatalog(MouseEvent mouseEvent) throws IOException {
        App.setRoot("primary");
    }

    private void loadGridPane() {
        myListener = new MyListener() {
            @Override
            public void onClickListener(Catalog catalog) {
                setChosenItem(catalog);
            }
        };
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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        errorLabel.setText("");
        if (flowerList.size() > 0) setChosenItem(flowerList.get(0));
        loadGridPane();
    }
}
