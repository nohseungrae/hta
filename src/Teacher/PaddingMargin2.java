package Teacher;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class PaddingMargin2 extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

		HBox hbox = new HBox();
		hbox.setPadding(new Insets(50,10,100,200));
		
		
		Button btn = new Button();
		Button btn1 = new Button();
		btn1.setPrefSize(100, 100);
		btn.setPrefSize(100, 100);
		hbox.setMargin(btn1, new Insets(10,10,10,10));		
		hbox.setMargin(btn, new Insets(20,20,20,20));
		hbox.getChildren().add(btn);
		hbox.getChildren().add(btn1);
		
		Scene scene = new Scene(hbox);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
