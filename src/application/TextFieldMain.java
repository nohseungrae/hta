package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class TextFieldMain extends Application {
	Label timer_lb = new Label();
	class Timer extends Thread{
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			for (int i = 0; i < 10; i++) {
				try {
					sleep(1000);
					//System.out.println(i);
					timer_lb.setText(i+"");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}
	
	

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

		VBox vBox = new VBox();
		vBox.setPrefWidth(700);
		vBox.setPrefHeight(400);
		vBox.setAlignment(Pos.CENTER);
		Scene scene = new Scene(vBox);
		
		TextField tf1 =new TextField("���� ��������");
		TextField tf2 =new TextField("���� �Ʒ�������");
		vBox.getChildren().add(timer_lb);
		vBox.getChildren().add(tf1);
		vBox.getChildren().add(tf2);
		
		/*tf1.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(
					ObservableValue<? extends String> observable, 
					String oldValue, 
					String newValue) {
				// TODO Auto-generated method stub
				System.out.println("���� ���� ����");
			}
		});
		
		tf1.textProperty().addListener((
				ObservableValue<? extends String> observable, 
				String oldValue, 
				String newValue)-> {
			// TODO Auto-generated method stub
			System.out.println(newValue);
			tf2.setText(newValue);
		});*/
		
		tf2.textProperty().bind(tf1.textProperty());
		
		primaryStage.setScene(scene);
		primaryStage.show();
	//	new Timer().start();
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
		
		
	}

}
