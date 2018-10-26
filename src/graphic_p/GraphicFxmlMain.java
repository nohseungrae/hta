package graphic_p;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class GraphicFxmlMain extends Application implements Initializable {

	@FXML Rectangle rec;
	@FXML Circle cir;
	@FXML Arc packman;
	@FXML Button btnrec;
	@FXML Button packbtn;
	boolean chk = false;
	int maxAngle = 45;
	int oneAngle = 3;
	@Override

	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		btnrec.setOnAction(ee->{
			rec.setRotate(rec.getRotate()+45);			
		});
		
		/*packbtn.setOnAction(ee->{
			
			if(chk==false) {
					packman.setStartAngle(packman.getStartAngle()-15);
					packman.setLength(packman.getLength()+30);
					if(packman.getLength()==360) {
						chk=true;
					}
			}else {
				packman.setStartAngle(packman.getStartAngle()+15);
				packman.setLength(packman.getLength()-30);
				if(packman.getLength()==270) {
					chk=false;
				}
			}
		});*/
		packbtn.setOnAction(ee->{
			double startAngle = packman.getStartAngle();
			
			startAngle+=oneAngle;
			
			if(startAngle>=maxAngle || startAngle<0) {
				oneAngle*=-1;
				
				if(startAngle>=maxAngle)
					startAngle=maxAngle;
				else if(startAngle<0)
					startAngle=0;
			}
			
			packman.setStartAngle(startAngle);
			
			packman.setLength(359-(startAngle*2));
		});
		
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Parent root = 
				FXMLLoader.load(getClass().getResource("graphicFxml.fxml"));
		
		Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);
		
		primaryStage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}


}
