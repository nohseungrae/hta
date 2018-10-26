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
		
			
		///���� layout
		AnchorPane root=  (AnchorPane)subBtn.getScene().getRoot();	
		          //���� Parent �� AnchorPane(layout)�� ������
		
		
		///���� layout ���� subLayout ����
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
