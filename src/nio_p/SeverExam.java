package nio_p;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URL;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
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

public class SeverExam extends Application implements Initializable{

		@FXML Button serveron;
		@FXML TextField portinput;
		
		@Override
		public void initialize(URL location, ResourceBundle resources) {
			// TODO Auto-generated method stub
			
			String port = "";
			portinput.setText(port);
			serveron.setOnAction(ee->{
				ServerSocketChannel server =null;
				try {
					System.out.println("뭐냐");
					server = ServerSocketChannel.open();
					server.configureBlocking(true);
					server.bind(new InetSocketAddress(Integer.parseInt(portinput.getText())));
					
					System.out.println("서버대기");
					
					SocketChannel client = server.accept();
					
					new TCPSingleSender(client).start();
					new TCPSingleReciever(client).start();
					
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					try {
						server.close();//에러발생시 서버 닫기
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			
		}
		@Override
		public void start(Stage primaryStage) throws Exception {
			// TODO Auto-generated method stub
			Parent parent = FXMLLoader.load(getClass().getResource("tcp.fxml"));
			Scene scene = new Scene(parent);
			primaryStage.setScene(scene);
			primaryStage.show();
		}
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			
			launch(args);
			
			
			
		}

	}
	

