package exam;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

public class Sub1HomeworkController implements Initializable {
	
	@FXML RadioButton first,second,third,fourth;
	@FXML Button before,next;
	Sub1HomeworkController me;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}
	public void backgo() throws IOException {
		Stage par = (Stage) before.getScene().getWindow();
		Parent sub = FXMLLoader.load(getClass().getResource("subhomework.fxml"));
		Scene scene = new Scene(sub);
		par.setScene(scene);
	}
	
	public void sub2Go() throws IOException {
		Stage par = (Stage)next.getScene().getWindow();
		Parent sub = FXMLLoader.load(getClass().getResource("result.fxml"));
		Scene scene = new Scene(sub);
		par.setScene(scene);
		
	}

}
