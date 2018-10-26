package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Calculator extends Application implements Initializable{
	@FXML Button num0;
	@FXML Button num1;
	@FXML Button num2;
	@FXML Button num3;
	@FXML Button num4;
	@FXML Button num5;
	@FXML Button num6;
	@FXML Button num7;
	@FXML Button num8;
	@FXML Button num9;
	@FXML Button plus;
	@FXML Button minor;
	@FXML Button result;
	@FXML Label window;
	@FXML TextField cal;
	
	String ddd = "";
	int aaa,bbb;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		ArrayList<String> btn =new ArrayList<>();
		
		num0.setOnAction(ee -> {
			ddd += "0";
			window.setText(ddd);
		});
		num1.setOnAction(ee -> {
			ddd += "1";
			window.setText(ddd);
		});
		num2.setOnAction(ee -> {
			ddd += "2";
			window.setText(ddd);
		});
		num3.setOnAction(ee -> {
			ddd += "3";
			window.setText(ddd);
		});
		num4.setOnAction(ee -> {
			ddd += "4";
			window.setText(ddd);
		});
		num5.setOnAction(ee -> {
			ddd += "5";
			window.setText(ddd);
		});
		num6.setOnAction(ee -> {
			ddd += "6";
			window.setText(ddd);
		});
		num7.setOnAction(ee -> {
			ddd += "7";
			window.setText(ddd);
		});
		num8.setOnAction(ee -> {
			ddd += "8";
			window.setText(ddd);
		});
		num9.setOnAction(ee -> {
			ddd += "9";
			window.setText(ddd);
		});
		plus.setOnAction(ee->{
			cal.setText(ddd+"+");
			aaa=Integer.parseInt(ddd);
			ddd="";
			window.setText(ddd);
		});
		minor.setOnAction(ee->{
			cal.setText(ddd+"-");
			aaa=Integer.parseInt(ddd);
			ddd="";
			window.setText(ddd);
		});
		result.setOnAction(ee->{
			System.out.println(ddd);
			cal.setText(ddd);
			bbb=Integer.parseInt(ddd);
/*			switch (aaa) {
			case aaa:
				
				break;

			default:
				break;
			}*/
			cal.setText(aaa+"+"+bbb);
			window.setText(aaa+bbb+"");
		});
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Parent parent =FXMLLoader.load(getClass().getResource("Calculator.fxml"));		
		Scene scene = new Scene(parent);
		primaryStage.setScene(scene);
		primaryStage.show();
				
	}

	public static void main(String[] args) {
		launch(args);
	}

}
