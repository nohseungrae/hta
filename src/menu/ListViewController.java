package menu;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;

public class ListViewController implements Initializable{
	
	@FXML Label label2;
	@FXML Button btn;
	@FXML Button btn1;
	@FXML ListView<String> list;
	@FXML ListView<String> list1;
	
	ObservableList<String> items;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		//list.setItems(FXCollections.observableArrayList());
		//새로 할 경우 --->생략하면 기존정보에 추가
		list.getItems().add("냉면");
		list.getItems().add("칭따오");
		list.getItems().add("마파두부");
		
		/////////////////////////////////////// Single 처리
		
		/*list.setOnMouseClicked(mm->{
			Object obj = list.getSelectionModel().getSelectedItem();
			label2.setText(obj.toString());
		});*/
		
		/*list.getSelectionModel().selectedItemProperty().addListener(
				(observable, 
				oldValue, 
				newValue)->{

					label2.setText(oldValue+"->"+newValue);
				});*/
		
		
		/////////////////////////////////////// Multiple 처리
		list.getSelectionModel()
		.setSelectionMode(SelectionMode.MULTIPLE);// 여러개를 동시에 선택하고 싶을 때 사용
		list.setOnMouseClicked(mm -> {
			
			items = list.getSelectionModel().getSelectedItems();
		
			for (String str : items) {
				System.out.println(str);
				// list.getItems().remove(str);
			}
		});
		list1.setOnMouseClicked(mm -> {

			items = list1.getSelectionModel().getSelectedItems();

			for (String str : items) {
				System.out.println(str);
				
			}
		});
		
		btn.setOnAction(ee -> {
			if(items==null) {
				System.out.println("선택해주세요!");
				return;
			}

			if (list!=null) {
				for (String str : items) {
					
					list.getItems().remove(str);
					list1.getItems().add(str);
				}
			}
		});
		btn1.setOnAction(ee ->{
			
			if (list1.getItems() != null) {

				for (String str : items) {
					list1.getItems().remove(str);
					list.getItems().add(str);
				}
			}
		});
			
			
		
		

	}
}
