package exam;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Timer;

import application.Alert1;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Arc;
import javafx.stage.Stage;
import javafx.util.Duration;

public class HomeworkController implements Initializable {
	
	@FXML AnchorPane main;
	@FXML Arc watch;
	@FXML Button start, giveup, touch;
	Alert alert;
	Timer timer;
	
	class Timer extends Service<Void>{

		@Override
		protected Task<Void> createTask() {
			
			Task<Void> task = new Task<Void>() {
				int i = 0;

				@Override
				protected Void call() throws Exception {
					while (true) {
						i++;
					//	Platform.runLater(() -> init());

						updateMessage(i + "");

						Thread.sleep(30);

					}
				}
				
			};
			
			return task;
		}
		
	}
	public void start() {
		timer = new Timer();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		touch.setOnAction(ee -> {
			
			touch.setText("니 인생 잘 간다 ㅎ");
			RotateTransition transition = new RotateTransition();
			transition.setFromAngle(0);
			transition.setToAngle(360);
			transition.setCycleCount(100);
			transition.setNode(watch);
			transition.setDuration(new Duration(300));
			// transition.setAutoReverse(true);
			transition.play();
		});
		
		giveup.setOnAction(ee ->{
			alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Dangerous!!!");
			alert.setHeaderText("정말 나가시겠습니까?");
			Optional<ButtonType>res = alert.showAndWait();
			if(res.get()==ButtonType.OK) {
				System.out.println("GOODBYE");
				Stage temp = (Stage)main.getScene().getWindow();
				temp.close();
			}else {
				System.out.println("아직!!");
			}
		});
	}
	

	public void subGo() throws IOException /* throws IOException */ {

		// AnchorPane par = (AnchorPane) start.getScene().getRoot();
		Stage par = (Stage) start.getScene().getWindow();
		Parent sub = FXMLLoader.load(getClass().getResource("subhomework.fxml"));
		Scene scene = new Scene(sub);
		par.setScene(scene);
	}
	

}


/*class NumberGo extends Service<Void>{

	@Override
	protected Task<Void> createTask() {
		// TODO Auto-generated method stub
		
		Task<Void> task = new Task<Void>() {

			@Override
			protected Void call() throws Exception {
				// TODO Auto-generated method stub
				
				int i =0;
				
				while(true) {
					if(chk) {
						i++;
						System.out.println("들어온다");
						//label.setText(i+"");  직접 gui 객체 변경 불가!!!!
						
						updateMessage(i+"");  ///Task 내부 메소드로 가지고 나감
					}
					Thread.sleep(1000);
					
					if(!reChk)
						break;//cancel,restart 쓰면 빼자
					
					
				}
				return null;
			}
		};*/
