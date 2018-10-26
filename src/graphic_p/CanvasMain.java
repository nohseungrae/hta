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
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

public class CanvasMain extends Application implements Initializable{
	
	@FXML Canvas canvas;
	GraphicsContext gc;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		gc = canvas.getGraphicsContext2D();
		gc.setFill(Color.RED);
		gc.fillRect(50, 10, 200, 50);
		gc.setStroke(Color.BLUE);
		gc.strokeOval(50, 70, 100, 100);
		gc.setStroke(Color.YELLOW);
		gc.strokeRect(100, 20, 130, 70);
		
		gc.setFill(Color.AQUA);
		gc.fillRoundRect(50, 180, 200, 200, 100, 500);
		
		gc.setFill(Color.PINK);
		gc.fillArc(400, 20, 100, 100, 0, 90, ArcType.CHORD);
		gc.fillArc(500, 20, 100, 100, 10, 90, ArcType.CHORD);
		gc.fillArc(600, 20, 100, 100, 20, 90, ArcType.CHORD);
		gc.fillArc(700, 20, 100, 100, 30, 90, ArcType.CHORD);
		gc.fillArc(400, 120, 100, 100, 20, 90, ArcType.OPEN);
		gc.fillArc(400, 220, 100, 100, 30, 90, ArcType.ROUND);
		
		gc.fillArc(400, 320, 100, 100, 45, 90, ArcType.ROUND);
		
		gc.fillPolygon(new double[] {450,570,650,520}, 
						new double[] {470,400,560,540}, 4);
		gc.strokePolygon(new double[] {450,570,650,520}, 
				new double[] {470,400,560,540}, 4);
		
		Image img = new Image("file:ppp/È¸¿ø.png",500,500,true,true);
		gc.drawImage(img, 50, 500);
}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Parent root = FXMLLoader.load(getClass().getResource("canvas.fxml"));
		
		Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		
		launch(args);
	}
//X : 450 570 650 520 
//Y : 470 400 560 540


}
