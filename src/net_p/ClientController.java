package net_p;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ClientController extends Application implements Initializable{
	
	@FXML TextField ipadress, port, window;
	@FXML Button login;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		String po = "";
		port.setText(po);
		try {
			
			ServerSocket server = new ServerSocket(7777);
			
			while(true) {
				System.out.println("연결대기");
				Socket client = server.accept();
				
				OutputStream os = client.getOutputStream();
				
				DataOutputStream dos = new DataOutputStream(os);
				
				dos.writeUTF("내가 보낸다");
				
				dos.close();
				os.close();
				client.close();
				
				System.out.println("전송완료");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String ip = "";
		ipadress.setText(ip);
		
		try {
			Socket socket = new Socket(ipadress.getText(), Integer.parseInt(port.getText()));
			
			
			
			InputStream is = socket.getInputStream();

			DataInputStream dis = new DataInputStream(is);
			login.setOnAction(ee -> {
				try {
					window.setText("서버 : "+dis.readUTF());
					dis.close();
					is.close();
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
				}
				
			});
			

	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Parent parent = FXMLLoader.load(getClass().getResource("server.fxml"));
		Scene scene = new Scene(parent);
		primaryStage.setScene(scene);
		primaryStage.show();
	}


	public static void main(String[] args) {
		launch(args);
		
		
	}

}
