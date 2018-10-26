package page;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PageMain extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		FXMLLoader loader = new FXMLLoader(getClass().getResource("main.fxml"));
		Parent parent = loader.load();
		
		MainController controller = loader.getController();
		//controller.setPrimaryStage(primaryStage);
		Scene scene = new Scene(parent);
		
		primaryStage.setScene(scene);
		primaryStage.show();	
	}	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);

	}

	

}
