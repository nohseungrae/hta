package thread_p;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.animation.FillTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.StrokeTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.util.Duration;

public class TranslateController implements Initializable {
	
	@FXML Arc arc;
	@FXML Button start, pause, stop, touch;
	@FXML Arc rotatearc,scalearc,fillarc,strokearc,fadearc;
	@FXML Button rotate,scale,fill,stroke,fade;
	
	TranslateTransition transition;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		transition = new TranslateTransition();
		transition.setFromX(100);
		transition.setFromY(100);
		transition.setToX(400);//X도착위치
		transition.setToY(400);
		transition.setDuration(new Duration(3000));//진행시간
		
		transition.setCycleCount(5);//반복횟수
		transition.setAutoReverse(true);
		transition.setNode(arc);
		transition.play();
		
		pause.setOnAction(ee->{
			transition.pause();
			System.out.println(transition.getStatus());
		});
		start.setOnAction(ee->{
			transition.play();
			System.out.println(transition.getStatus());
		});
		stop.setOnAction(ee->{
			transition.stop();
			System.out.println(transition.getStatus());
		});
		touch.setOnAction(ee->{
			if(transition.getStatus().toString()=="RUNNING") {
				transition.pause();
			}else if(transition.getStatus().toString()=="PAUSED") {
				transition.play();
			}
		});
		
		
		rotate.setOnAction(ee->{
			RotateTransition transition = new RotateTransition();
			transition.setFromAngle(0);
			transition.setToAngle(359);
			transition.setNode(rotatearc);
			transition.setDuration(new Duration(1000));
			transition.setAutoReverse(true);
			transition.setCycleCount(-1);
			transition.play();
		});
		
		
		scale.setOnAction(ee->{
			ScaleTransition transition = new ScaleTransition();
			transition.setFromX(1);
			transition.setToX(2);
			transition.setFromY(2);
			transition.setToY(0.5);
			transition.setNode(scalearc);
			transition.setDuration(new Duration(1000));
			transition.setAutoReverse(true);
			transition.setCycleCount(-1);
			transition.play();
		});
		
		fill.setOnAction(ee->{
			FillTransition transition = new FillTransition();
			transition.setFromValue(new Color(1, 0, 0, 1));
			transition.setToValue(new Color(0, 0, 1, 1));
			//transition.setNode(fillarc);
			transition.setShape(fillarc);
			transition.setDuration(new Duration(1000));
			transition.setAutoReverse(true);
			transition.play();
		});
		
		stroke.setOnAction(ee->{
			StrokeTransition transition = new StrokeTransition();
			transition.setFromValue(new Color(1, 0, 0, 1));
			transition.setToValue(new Color(0, 0, 1, 1));
			//transition.setNode(fillarc);
			transition.setShape(strokearc);
			transition.setDuration(new Duration(1000));
			transition.setAutoReverse(true);
			transition.play();
		});
		
		fade.setOnAction(ee->{
			FadeTransition transition = new FadeTransition();
			transition.setFromValue(1);
			transition.setToValue(0.3);
			//transition.setNode(fillarc);
			transition.setNode(fadearc);
			transition.setDuration(new Duration(1000));
			transition.setAutoReverse(true);
			transition.play();
		});

	
	}

}
