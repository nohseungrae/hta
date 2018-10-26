package graphic_p;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Icon extends Application implements Initializable{

	@FXML Canvas canvas;
	GraphicsContext gc;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		gc = canvas.getGraphicsContext2D();
		//Image img = new Image("file:ppp/¶óÀÌ¾ð.jpg");
		//gc.drawImage(img, 170, 100);
		
	
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		Parent parent = FXMLLoader.load(getClass().getResource("icon.fxml"));
		
		Scene scene = new Scene(parent);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		launch(args);

	}




}
