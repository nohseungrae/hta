package page;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SubController implements Initializable{

	
	
	@FXML Button subBtn;
	
	String data;
	
	@FXML Label label;
	
	@FXML TextField msg;

	
	public void subClose() {
		
			
		///기존 layout
		AnchorPane root=  (AnchorPane)subBtn.getScene().getRoot();	
		          //기존 Parent 인 AnchorPane(layout)을 가져옴
		
		
		///기존 layout 에서 subLayout 제거
		root.getChildren().remove(index);
	
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		System.out.println(resources.getObject("hi"));
		data = resources.getObject("data").toString();
		
		System.out.println(data);
		
		label.setText("From Main :"+data);
		
	}

}
