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

		if(msgObject.getMsg().startsWith("Catalog")){
			Platform.runLater(()->{
				try {
					App.setRoot("Catalog");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
		}
		else if(msgObject.getMsg().startsWith("Home")){
			Platform.runLater(()->{
				try {
					App.setRoot("primary");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
		}
		else if(msgObject.getMsg().startsWith("contactUs")){
			Platform.runLater(()->{
				try {
					App.setRoot("contactUs");
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
