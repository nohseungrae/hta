package application;


import javax.net.ssl.ExtendedSSLSession;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class BtnMain extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		VBox vbox = new VBox();
		vbox.setPrefWidth(700);
		vbox.setPrefHeight(400);
		vbox.setAlignment(Pos.CENTER);
		
		Button button = new Button("눌러봐");
		
		/*Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("알림창");
		alert.setContentText("java Fx이지롱");
		alert.setHeaderText("메시지");*/
		//alert.show();
		
		
		button.setOnAction(ee->{//리스너
		System.out.println("눌렀습니다");
		//alert.show();
		});
	
		/*button.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				System.out.println("눌렀습니다.");
			}
		});*/
		
		vbox.getChildren().add(button);
		
		Label lb = new Label("라벨이당");
		Font font = new Font(50);
		lb.setFont(font);
		Slider slider = new Slider();
		vbox.getChildren().add(lb);
		vbox.getChildren().add(slider);
		
		slider.valueProperty().addListener(
				(ObservableValue<? extends Number> observable, 
				Number oldValue, 
				Number newValue)->{
					lb.setText(newValue+"");
					lb.setFont(new Font(newValue.doubleValue()));
					//System.out.println(newValue);
					
				});
			/*@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				// TODO Auto-generated method stub
				System.out.println(newValue);
			}
		});*/
		
		Scene scene = new Scene(vbox);
		
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		launch(args);

	}

}
