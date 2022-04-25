package il.ac.haifa.cs.sweng.OCSFSimpleChat;

import javafx.application.Application;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    public static final String CURRENCY = "$";
    private static Scene scene;
    private static SimpleClient client;

    @Override
    public void start(Stage stage) throws Exception {
        client = SimpleClient.getClient();
        client.openConnection();
        scene = new Scene(loadFXML("primary"), 1280, 720);
        stage.setScene(scene);
        //stage.setFullScreen(true);
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args){
        launch();
        try {
            client.closeConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        client.connectionClosed();
    }
}

