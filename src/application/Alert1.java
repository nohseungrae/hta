package application;

import java.net.URL;
import java.util.Enumeration;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class Alert1 extends Application implements Initializable {

	@FXML Label messageLabel;
	
	Member kkk;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		kkk = (Member)resources.getObject("");
		messageLabel.setText(kkk.id+"\n"+kkk.name);
		
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Parent parent = FXMLLoader.load(getClass().getResource("alertExam.fxml"),new ResourceBundle() {
			
			@Override
			protected Object handleGetObject(String key) {
				
				return kkk;
			}
			
			@Override
			public Enumeration<String> getKeys() {
				// TODO Auto-generated method stub
				return null;
			}
		});
		
		Scene scene = new Scene(parent);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	void print(String[] args) {
		launch(args);
	}

	

}
