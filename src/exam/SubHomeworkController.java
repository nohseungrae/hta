package exam;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.ResourceBundle;

import ddd.MainController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SubHomeworkController implements Initializable {
	
	@FXML AnchorPane sub;
	@FXML RadioButton first,second,third,fourth;
	@FXML Button next;
	Sub1HomeworkController bbb;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		//bbb = (Sub1HomeworkController)resources.getObject("bbb");
	}
	
	public void sub1Go() throws IOException {
		Stage par = (Stage)next.getScene().getWindow();
		
		
		Parent parent = FXMLLoader.load(getClass().getResource("sub1homework.fxml"),
				new ResourceBundle() {
					@Override
					protected Object handleGetObject(String key) {
						// TODO Auto-generated method stub
						return null;
					}
					
					@Override
					public Enumeration<String> getKeys() {
						// TODO Auto-generated method stub
						return null;
					}
				});
		Scene scene = new Scene(parent);
		par.setScene(scene);
		
		

	}
	

}
