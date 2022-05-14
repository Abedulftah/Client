package Controller;

import il.ac.haifa.cs.sweng.OCSFSimpleChat.App;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Duration;

import java.io.IOException;

// See what's written at the very beginning of void initialize()
// See what's written at the end of handleSendMessageButton

public class ComplainUserController {

    private String style;

    @FXML
    private Label charactersLeftLabel;

    @FXML
    private TextField emailTB;

    @FXML
    private Label messageErrorLabel;

    @FXML
    private TextArea messageTB;

    @FXML
    private TextField nameTB;

    @FXML
    private TextField phoneTB;

    @FXML
    void handleHome() throws IOException {
        App.setRoot("primaryUser", "/Image/mainPageIcon.png", "Lilac");
    }

    @FXML
    void handleMessageTBKeyPressed() {

        messageTB.setStyle(style);
        messageErrorLabel.setVisible(false);
        if (850 - messageTB.getText().replaceAll("\\n", "").length() > 100) {
            charactersLeftLabel.setTextFill(Color.web("green"));
        } else {
            charactersLeftLabel.setTextFill(Color.web("red"));
        }
        charactersLeftLabel.setText("Characters Left: " + (850 - messageTB.getText().replaceAll("\\n", "").length()));
    }

    @FXML
    void handleMessageTBKeyReleased() {
        handleMessageTBKeyPressed();
    }

    @FXML
    void handleSendMessageButton() {

        if (messageTB.getText().replaceAll("\\n", "").length() < 30) {
            messageErrorLabel.setVisible(true);
            messageTB.setStyle("-fx-border-color: red");
        } else {
            messageTB.setEditable(false);
            messageTB.setStyle("-fx-text-fill: #9b9d9e");
            messageTB.setFont(Font.font("Cambria", FontWeight.BOLD, 18));
            messageErrorLabel.setTextFill(Color.web("#008000"));
            messageErrorLabel.setText("MESSAGE WAS SENT SUCCESSFULLY");
            messageErrorLabel.setVisible(true);
            PauseTransition pause = new PauseTransition(Duration.seconds(3));
            pause.setOnFinished(e -> messageErrorLabel.setVisible(false));
            pause.play();
        }

        // Save this data in the complaint database
        /* nameTB.getText();
        emailTB.getText();
        phoneTB.getText();
        messageTB.getText(); */
    }

    public static void setTextAreaLimit(TextArea textArea, int length) {
        textArea.setOnKeyTyped(event -> {
            String string = textArea.getText().replaceAll("\\n", "");
            if (string.length() > length) {
                textArea.setText(string.substring(0, length));
                textArea.positionCaret(string.length());
            }
        });
    }

    @FXML
    void initialize() {

        style = messageTB.getStyle();
        messageErrorLabel.setVisible(false);

        nameTB.setText(SignInController.userName);
        emailTB.setText("mhmd.shahin@outlook.com"); // Initialize to user's email
        phoneTB.setText("0547404179"); // Initialize to user's phone

        nameTB.setStyle("-fx-text-fill: #9b9d9e");
        emailTB.setStyle("-fx-text-fill: #9b9d9e");
        phoneTB.setStyle("-fx-text-fill: #9b9d9e");
        nameTB.setFont(Font.font("Cambria", FontWeight.BOLD, 18));
        emailTB.setFont(Font.font("Cambria", FontWeight.BOLD, 18));
        phoneTB.setFont(Font.font("Cambria", FontWeight.BOLD, 18));

        setTextAreaLimit(messageTB, 850);
    }
}