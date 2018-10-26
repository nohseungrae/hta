package nio_p;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.StandardProtocolFamily;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.charset.Charset;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
public class Sendd {
	
	public Send() {
		super();
		DatagramChannel channel = 
				DatagramChannel.open(StandardProtocolFamily.INET);
		channel.bind(new InetSocketAddress(7777));
		System.out.println("수신대기");
		while (true) {
			ByteBuffer buf = ByteBuffer.allocate(100);
			SocketAddress addr = channel.receive(buf);

			buf.flip();
			Charset charset = Charset.defaultCharset();
			String data = charset.decode(buf).toString();

			System.out.println(addr.toString() + ":" + data);
		}
	}

	
}

public class UDPGUI extends Application implements Initializable{
	
	@FXML TextField portinput;
	@FXML Button serveron,serveroff;
	@FXML TextArea view;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Parent parent = FXMLLoader.load(getClass().getResource("udpgui.fxml"));
		Scene scene = new Scene(parent);
		primaryStage.setScene(scene);
		primaryStage.show();

	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		launch(args);


	}
}
