package application;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javax.rmi.ssl.SslRMIClientSocketFactory;
import javafx.application.Application;
import javafx.beans.Observable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

class Member{
	String name,id,pass,email,birth,gender;

	public Member() {
		super();
	}

	public Member(String name, String id, String pass, String email, String birth, String gender) {
		super();
		this.name = name;
		this.id = id;
		this.pass = pass;
		this.email = email;
		this.birth = birth;
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Member [name=" + name + ", id=" + id + ", pass=" + pass + ", email=" + email + ", birth=" + birth
				+ ", gender=" + gender + "]";
	}
	
	
}

public class Entrance extends Application implements Initializable {
	
	@FXML Label nozum;
	@FXML Button idconfirm;
	@FXML CheckBox check;
	@FXML Alert alert;
	@FXML RadioButton man;
	@FXML RadioButton woman;
	@FXML ComboBox<String> email;
	@FXML ComboBox<String> phone;
	@FXML ComboBox<String> year;
	@FXML ComboBox<String> month;
	@FXML ComboBox<String> day;
	@FXML String input;
	@FXML Button reg;
	@FXML TextField idid;
	@FXML TextField nana;

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		Alert1 aaa = new Alert1();
			aaa.setUserAgentStylesheet(STYLESHEET_CASPIAN);
		//idconfirm.setPickOnBounds(false);
		//ObservableList<ComboBox<String>> emaildata = FXCollections.observableArrayList(email);
		/*email.setItems(emaildata);
		email.setValue(emaildata.get(0));*/
		SimpleDateFormat sdy = new SimpleDateFormat("yyyy");
		SimpleDateFormat sdm = new SimpleDateFormat("M");
		SimpleDateFormat sdg = new SimpleDateFormat("d");
		
		Date today = new Date();
		
		List<String> yyy = new ArrayList<>();
		for (int i = 80; i < 119; i++) {
			today.setYear(i);
			yyy.add(sdy.format(today));
		}
		ObservableList<String> handy = 
				FXCollections.observableArrayList(yyy);
		System.out.println(handy);
		year.setItems(handy);
		List<String> mmm = new ArrayList<>();
		for (int i = 0; i < 12; i++) {
			today.setMonth(i);
			mmm.add(sdm.format(today));
		}
		ObservableList<String> handm = 
				FXCollections.observableArrayList(mmm);
		System.out.println(handm);
		month.setItems(handm);
		List<String> ddd = new ArrayList<>();
		for (int i = 1; i < 32; i++) {
			today.setDate(i);
			ddd.add(sdg.format(today));
		}
		ObservableList<String> handd = 
				FXCollections.observableArrayList(ddd);
		System.out.println(handd);
		day.setItems(handd);
		year.setOnAction(ee->System.out.println(year.getValue()+"년"));
		month.setOnAction(ee->System.out.println(month.getValue()+"월"));
		day.setOnAction(ee->System.out.println(day.getValue()+"일"));
		//input.setOnAction(ee->System.out.println(input.getAlignment()));
		
		
		
		
		
		email.setOnAction(ee->{
			if(email.getValue()==input) {
				System.out.println(email.getOnMouseEntered());
			}
		System.out.println("이메일 선택 : "+email.getValue());
		});
		
		phone.setOnAction(ee->System.out.println("통신번호 선택 : "+phone.getValue()));
		Member infor = new Member();
		
		reg.setOnAction(ee -> {
			infor.id = idid.getText();
			infor.name = nana.getText();
			aaa.kkk = infor;
			try {
			aaa.start(new Stage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}});
		
	/*	for (int i = 0; i < 12; i++) {
			today.setMonth(i);
			
			System.out.println(today.getMonth());
			ObservableList<String> hand = 
					FXCollections.observableArrayList();
			month.setOnAction((EventHandler<ActionEvent>) month);
		}
		*/
		

		
		
		
		
		EventHandler handler = ee->{
			RadioButton rb = (RadioButton) ee.getSource();
			System.out.println("성별 확인"+rb.getText());
		};
		man.setOnAction(handler);
		woman.setOnAction(handler);
		
		man.setSelected(true);
		woman.setSelected(false);
		man.setOnAction(ee->{
			System.out.println("남자체크:"+man.isSelected());
			System.out.println("여자체크:"+woman.isSelected());
		});
		woman.setSelected(true);
		man.setSelected(false);
		woman.setOnAction(ee->{
			System.out.println("여자체크:"+woman.isSelected());
			System.out.println("남자체크:"+man.isSelected());
		});
		
		alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("중복확인");
		alert.setContentText("중복이야!!!!\n"+"www.nozum.co.kr");
		alert.setHeaderText("알림 메시지");
		idconfirm.setOnAction(ee->{
			/*try {
				Parent alert = FXMLLoader.load(getClass().getResource("alertExam.fxml"));
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			
			System.out.println("중복이요");
			alert.show();
		});
		
		
		check.setSelected(true);
		check.setOnAction(ee->{
			CheckBox box = (CheckBox) ee.getSource();
			System.out.println("체크:"+check.isSelected()+","+box.getText());
		});
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		//VBox vbox = new VBox();
		//Scene scene = new Scene(vbox);
		//idconfirm.setOnAction(ee->System.out.println("중복이요"));
		Parent parent = FXMLLoader.load(getClass().getResource("entrance.fxml"));
		Scene scene = new Scene(parent);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
		
		

	}








	

	

}
