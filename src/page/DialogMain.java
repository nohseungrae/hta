package page;



import java.io.File;
import java.util.Optional;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class DialogMain extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Alert info = new Alert(AlertType.INFORMATION);
		info.setTitle("�˸�â");
		info.setHeaderText("�˸�â ����");
		info.setContentText("�˸�â ����");
		info.show();
		
		
		Alert error = new Alert(AlertType.ERROR);
		error.setTitle("����â");
		error.setHeaderText("����â ����");
		error.setContentText("����â ����");
		error.show();
		
		Alert waring = new Alert(AlertType.WARNING);
		waring.setTitle("���â");
		waring.setHeaderText("���â ����");
		waring.setContentText("���â ����");
		waring.show();
		
		
		Alert custom = new Alert(AlertType.WARNING);
		custom.setTitle("customâ");
		custom.setHeaderText("custom ����");
		custom.setContentText("custom ����");
		
		Label label = new Label("��ü�� ��� ����");
		TextArea textArea = new TextArea("��� ��� ���볻�� �����");
		textArea.setEditable(false);
		textArea.setWrapText(true);
		
		textArea.setMaxHeight(Double.MAX_VALUE);
		textArea.setMaxWidth(Double.MAX_VALUE);
		
		GridPane.setVgrow(textArea, Priority.ALWAYS);
		GridPane.setHgrow(textArea, Priority.ALWAYS);
		
		GridPane gridPane = new GridPane();
		gridPane.setMaxWidth(Double.MAX_VALUE);
		gridPane.add(label, 0,0);
		gridPane.add(textArea, 0,1);
		
		custom.getDialogPane().setExpandableContent(gridPane);
		
		custom.show();
		
		
		Alert confirm = new Alert(AlertType.CONFIRMATION);
		confirm.setTitle("����â");
		confirm.setHeaderText("����â ����");
		confirm.setContentText("����â ����");
		
		
		Optional<ButtonType>res = confirm.showAndWait();
		//System.out.println(res.get());
		if(res.get()==ButtonType.OK) {
			System.out.println("Ȯ�� Ŭ����");
			
		}else {
			System.out.println("��� Ŭ����");
			
			
		}
		
		//confirm.show();  show() ���� �� �� , �ΰ� ����
		
		
		
		TextInputDialog textD = new TextInputDialog();
		textD.setTitle("�Է�â");
		textD.setHeaderText("�Է�â ����");
		textD.setContentText("�Է�:");
		Optional<String>res2 = textD.showAndWait();
		res2.ifPresent(str->System.out.println("�Է�â ����:"+str));
		
		
		
		//���ϼ���
		FileChooser fc = new FileChooser();
		fc.getExtensionFilters().addAll(
				new FileChooser.ExtensionFilter("img", "*.jpg","*.png","*.gif","*.bmp"));
		
								////���� ������Ʈ�� ��ġ�� ����̺갡 root�� ex) E:\
		fc.setInitialDirectory(new File("\\javapro\\guiProj\\ppp"));
		File res3=fc.showOpenDialog(primaryStage);
		
		if(res3!=null) {
			System.out.println(res3.getName());
		}

		
		//��������
		DirectoryChooser dc = new DirectoryChooser();
		
		////���� ������Ʈ�� ��ġ�� ����̺갡 root�� ex) E:\
		dc.setInitialDirectory(new File("\\javapro\\guiProj\\ppp"));
		File res4=fc.showOpenDialog(primaryStage);
		
		if(res4!=null) {
		System.out.println(res4.getPath());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
