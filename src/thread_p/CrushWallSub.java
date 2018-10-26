package thread_p;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import thread_p.ThreadAniController.Timer;

public class CrushWallSub implements Initializable {
	
	@FXML AnchorPane game;
	@FXML Pane bottom,ball,wall;
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Timer timer = new Timer();
		timer.setDaemon(true);
		timer.start();
		
		game.addEventHandler(KeyEvent.KEY_PRESSED,new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent key) {
				// TODO Auto-generated method stub
				System.out.println(key.getCode());
				double yy;
				if(key.getCode()==KeyCode.RIGHT) {
					yy= bottom.getLayoutX()+20;
					
					bottom.setLayoutX(yy);
				}
				if(key.getCode()==KeyCode.LEFT) {
					yy = bottom.getLayoutX()-20;
					
					bottom.setLayoutX(yy);
				}
			}
			
		});
	}

	class Timer extends Thread {
		@Override
		public void run() {
			while (true) {
				try {
					Platform.runLater(() -> init());

					sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		int disX = 3;
		int disY = 3;

		void init() {
			double xx = ball.getLayoutX()+disX;
			double yy = ball.getLayoutY()-disY;
			if(game.getPrefWidth()<xx+ball.getPrefWidth()||xx<0) {
				disX*=-1;
			}
			if(yy<0) {
				disY*=-1;
			}
			
			ball.setLayoutX(xx);
			ball.setLayoutY(yy);
			
			if (bottom.getLayoutX() < ball.getLayoutX() + ball.getPrefWidth()
					&& bottom.getLayoutX() + bottom.getPrefWidth() > ball.getLayoutX()
					&& bottom.getLayoutY() < ball.getLayoutY() + ball.getPrefHeight()
					&& bottom.getLayoutY() + bottom.getPrefHeight() > ball.getLayoutY())
			{
				disY *= -1;
			}
			if(yy>game.getPrefHeight()) {
				
			}
			//(game.getPrefHeight()<yy+ball.getPrefHeight()||

		}
	}

}