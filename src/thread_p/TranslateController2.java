package thread_p;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.shape.Arc;
import javafx.util.Duration;

public class TranslateController2 implements Initializable {

	@FXML Arc rotateArc,scaleArc,fillArc,storkeArc,fadeArc;
	@FXML Button rotate,scale,fill,storke,fade;
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		rotate.setOnAction(ee->{
			RotateTransition transition = new RotateTransition();
			transition.setFromAngle(180);
			transition.setToAngle(359);
			transition.setNode(rotateArc);
			transition.setDuration(new Duration(1000));
			transition.setAutoReverse(true);
			transition.play();
		});
		
		scale.setOnAction(ee->{
			ScaleTransition transition = new ScaleTransition();
			transition.setFromX(1);
			transition.setToX(2);
			transition.setFromY(2);
			transition.setToY(0.5);
			transition.setNode(scaleArc);
			transition.setDuration(new Duration(1000));
			transition.setAutoReverse(true);
			transition.play();
		});
	}

}
