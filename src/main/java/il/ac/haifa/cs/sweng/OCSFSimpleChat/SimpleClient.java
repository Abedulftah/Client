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
	
//	public static void main(String[] args) throws IOException {
//		if (args.length != 2) {
//			System.out.println("Required arguments: <host> <port>");
//		} else {
//			String host = args[0];
//			int port = Integer.parseInt(args[1]);
//
//			SimpleClient chatClient = new SimpleClient(host, port);
//			chatClient.openConnection();
//		}
//	}
}
