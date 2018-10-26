package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.stage.Stage;

public class ControlMain extends Application implements Initializable{

	@FXML CheckBox checkBox;//fxml에서 CheckBox를 가져온다
	@FXML RadioButton genM;
	@FXML RadioButton genF;
	@FXML ComboBox<String> email;
	@FXML Slider zoom;
	//FXCollections dd;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		//CheckBox----------------------------------------------------------
		checkBox.setSelected(false);
		checkBox.setOnAction(ee->{
			CheckBox box = (CheckBox) ee.getSource();
			
			System.out.println("체크박스:"+checkBox.isSelected()+","+box.getText());
		});
		//RadioButton-----------------------------------------------------
		EventHandler handler = ee->{
			RadioButton rb = (RadioButton)ee.getSource();
					System.out.println("성별:"+rb.getText());
		};
		genM.setOnAction(handler);
		genF.setOnAction(handler);
		
		genM.setSelected(true);
		genF.setSelected(false);
		genM.setOnAction(ee->{
			System.out.println("남자체크:"+genM.isSelected());
			System.out.println("여자체크:"+genF.isSelected());
		});
		genF.setSelected(true);
		genM.setSelected(false);
		genF.setOnAction(ee->{
			System.out.println("여자체크:"+genF.isSelected());
			System.out.println("남자체크:"+genM.isSelected());
		});

		//----------------------------------------------------------
		ObservableList<String> emaildata = 
				FXCollections.observableArrayList("구글","네이버","다음","줌");
		email.setItems(emaildata);
		email.setValue(emaildata.get(1));

		
		/*email.setOnAction(ee -> {
			System.out.println("email 이벤트 : "+email.getValue());
		});*/
		
/*		email.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
		 
			@Override
			public void changed(
					ObservableValue<? extends String> observable,
					String oldValue,
					String newValue) {
				// TODO Auto-generated method stub
				System.out.println(oldValue+"->"+newValue);
			}
		});*/
		//매개변수 // 메소드 코드??
		//()    ->    {}
		
		email.getSelectionModel().selectedItemProperty().addListener(
				(observable, oldValue, newValue) -> 
		System.out.println(oldValue + "->" + newValue)
		);
		
		
		
		/*email.getSelectionModel().selectedItemProperty().addListener((
					observable,oldValue,newValue)->{
				System.out.println(oldValue+"->"+newValue);
			});*/
		//----------------------------------------------------------
		zoom.valueProperty().addListener((
				observable,oldValue,newValue)->{
				System.out.println(oldValue+"->"+newValue);
				});
		
	}
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Parent parent = FXMLLoader.load(getClass().getResource("control.fxml"));
		Scene scene = new Scene(parent);

		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	
}
