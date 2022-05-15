package il.ac.haifa.cs.sweng.OCSFSimpleChat;

import java.io.IOException;

import javafx.application.Platform;


import il.ac.haifa.cs.sweng.OCSFSimpleChat.ocsf.client.AbstractClient;

public class SimpleClient extends AbstractClient {
    public static MsgObject msgObject;
    private static SimpleClient client;


    public SimpleClient(String host, int port) {
        super(host, port);
    }


    @Override
    protected void handleMessageFromServer(Object msg) {

        msgObject = (MsgObject) msg;

        if (msgObject.getMsg().equals("Catalog")) {
            Platform.runLater(() -> {
                try {
                    App.setRoot("Catalog", "/Image/catalogIcon.png", "Catalogue");
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            });
        } else if (msgObject.getMsg().equals("Home")) {
            Platform.runLater(() -> {
                try {
                    App.setRoot("primary", "/Image/mainPageIcon.png", "Lilac");
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            });
        } else if (msgObject.getMsg().equals("contactUs")) {
            Platform.runLater(() -> {
                try {
                    App.setRoot("contactUs", "/Image/contactUsIcon.png", "Contact Us");
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            });
        } else if (msgObject.getMsg().equals("signIn")) {
            Platform.runLater(() -> {
                try {
                    App.setRoot("SignIn", "/Image/loginIcon.png", "Sign In");
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            });
        } else if (msgObject.getMsg().equals("signUp")) {
            Platform.runLater(() -> {
                try {
                    App.setRoot("SignUp", "/Image/signUpIcon.png", "Sign Up");
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            });
        } else if (msgObject.getMsg().equals("signUpAccountType")) {
            Platform.runLater(() -> {
                try {
                    App.setRoot("SignUpAccountType", "/Image/signUpIcon.png", "Sign Up");
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            });
        } else if (msgObject.getMsg().equals("cartUser")) {
            Platform.runLater(() -> {
                try {
                    App.setRoot("cartUser", "/Image/cartIcon.png", "Cart");
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            });
        } else if (msgObject.getMsg().equals("catalogueUser")) {
            Platform.runLater(() -> {
                try {
                    App.setRoot("catalogueUser", "/Image/catalogIcon.png", "Catalogue");
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            });
        } else if (msgObject.getMsg().equals("complainUser")) {
            Platform.runLater(() -> {
                try {
                    App.setRoot("complainUser", "/Image/complaintIcon.png", "Complain");
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            });
        } else if (msgObject.getMsg().equals("myOrdersUser")) {
            Platform.runLater(() -> {
                try {
                    App.setRoot("myOrdersUser", "/Image/myOrdersIcon.png", "My Orders");
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            });
        } else if (msgObject.getMsg().equals("specialOrderUser")) {
            Platform.runLater(() -> {
                try {
                    App.setRoot("specialOrderUser", "/Image/specialOrderIcon.png", "Special Order");
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            });
        } else if (msgObject.getMsg().equals("primaryUser")) {
            Platform.runLater(() -> {
                try {
                    App.setRoot("primaryUser", "/Image/mainPageIcon.png", "Lilac");
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            });
        }
    }

    @Override
    protected void connectionClosed() {

        // TODO Auto-generated method stub
        super.connectionClosed();

    }

    public static SimpleClient getClient() {
        if (client == null) {
            client = new SimpleClient("localhost", 3000);
        }

        return client;
    }

}
