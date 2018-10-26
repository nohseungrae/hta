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
		//���� �� ��� --->�����ϸ� ���������� �߰�
		list.getItems().add("�ø�");
		list.getItems().add("Ī����");
		list.getItems().add("���ĵκ�");
		
		/////////////////////////////////////// Single ó��
		
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
		
		
		/////////////////////////////////////// Multiple ó��
		list.getSelectionModel()
		.setSelectionMode(SelectionMode.MULTIPLE);// �������� ���ÿ� �����ϰ� ���� �� ���
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
				System.out.println("�������ּ���!");
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
