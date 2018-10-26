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
import javafx.scene.shape.Arc;

public class ThreadAniController implements Initializable {
	
	@FXML AnchorPane totalP;
	@FXML Pane pp,user;
	@FXML Arc pArc;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		Timer timer = new Timer();
		timer.setDaemon(true);
		timer.start();
		
		
		
		///focustraversable="true" node가 focus를 인지하지 않고 관통시키는 것
		/// keyEvent 의 주체가 되지 않도록 설정
		////이벤트 등록 --->키입력 이벤트(KEY_PRESSED, KEY_RELEASED, KEY_TYPED)
		totalP.addEventHandler(KeyEvent.KEY_PRESSED,
				new EventHandler<KeyEvent>() {

					@Override
					public void handle(KeyEvent key) {
						// TODO Auto-generated method stub
						//System.out.println(key.getCode());
						double yy;
						if (key.getCode() == KeyCode.DOWN) {
							yy = user.getLayoutY() + 10;

							if (totalP.getPrefHeight() < yy + user.getPrefHeight())

								yy = totalP.getPrefHeight() - user.getPrefHeight();
							
							user.setLayoutY(yy);
						}
						if (key.getCode() == KeyCode.UP) {
							yy = user.getLayoutY() - 10;

							if (yy<0) 

								yy = 0;
							
							user.setLayoutY(yy);
						}
						if (key.getCode() == KeyCode.RIGHT) {
							yy = user.getLayoutX() + 10;

							if (totalP.getPrefWidth() < yy + user.getPrefWidth())

								yy = totalP.getPrefWidth() - user.getPrefWidth();
							
							user.setLayoutX(yy);
						}
						if (key.getCode() == KeyCode.LEFT) {
							yy = user.getLayoutX() - 10;

							if (yy<0) 

								yy = 0;
							
							user.setLayoutX(yy);
						}
					}

				});
	}
	
	class Timer extends Thread{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true) {
				try {
					Platform.runLater(()->init());
					
					sleep(30);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	int disX = 5;
	int disY = 5;
	int length = 3;
	int angle = 1;
			
	void init() {
		
		double xx = pp.getLayoutX()+disX;
		double yy = pp.getLayoutY()+disY;
		if ((totalP.getPrefWidth() < xx + pp.getPrefWidth())||xx<0) {
			disX *= -1;
			
		}
		if ((totalP.getPrefHeight() < yy + pp.getPrefHeight())||yy<0) {
			disY *= -1;
		}
		
		pp.setLayoutX(xx);
		pp.setLayoutY(yy);
		if(pArc.getLength()<330) {
		pArc.setLength(pArc.getLength()+length);}
		if(pArc.getStartAngle()>0) {
		pArc.setStartAngle(pArc.getStartAngle()-angle);}
		
		
	}

}
