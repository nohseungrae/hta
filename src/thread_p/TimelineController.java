package thread_p;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.shape.Arc;
import javafx.util.Duration;

public class TimelineController implements Initializable {

	@FXML Arc arc;
	@FXML Button btn1, btn2;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

		btn1.setOnAction(ee->{
			ScaleTransition transition = new ScaleTransition();
			transition.setFromY(1);
			transition.setToX(1.5);
			transition.setNode(arc);

			transition.setDelay(new Duration(500));
			transition.setDuration(new Duration(1000));
			transition.setAutoReverse(true);
			transition.setCycleCount(-1);
			transition.play();
			
			Timeline tl = new Timeline();
			

			KeyFrame y_0 = new KeyFrame(
					new Duration(0), 
					new KeyValue(arc.layoutYProperty(), 50)
					);

			KeyFrame y_1 = new KeyFrame(
					new Duration(300), 
					new KeyValue(arc.layoutYProperty(), 100)
					);
			
			KeyFrame y_2 = new KeyFrame(
					new Duration(500), 
					new KeyValue(arc.layoutYProperty(), 150)
					);
			
			
			KeyFrame y_3 = new KeyFrame(
					new Duration(1000), 
					new KeyValue(arc.layoutYProperty(), 400)
					);
			KeyFrame s_0 = new KeyFrame(
					new Duration(1000), 
					new KeyValue(transition.byXProperty(), 400)
					);
			//add순서와 keyframe 순서는 상관없음.
			//tl.getKeyFrames().add(x_0);
	
			tl.getKeyFrames().add(y_0);
			tl.getKeyFrames().add(y_1);
			tl.getKeyFrames().add(y_2);
			tl.getKeyFrames().add(y_3);
			
			tl.setCycleCount(-1);
			tl.setAutoReverse(true);
			
			tl.play();
			
		});
	}

}
