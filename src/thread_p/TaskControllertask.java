package thread_p;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class TaskControllertask implements Initializable {
	
	@FXML Label label;
	@FXML Button restart, suspend;
	
	NumberGo numberGo;
	
	boolean chk = true, reChk = false;

	HashMap<Boolean, String>chkMap, restartMap;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

		chkMap = new HashMap<>();
		chkMap.put(true, "||");
		chkMap.put(false, "��");
		
		restartMap = new HashMap<>();
		restartMap.put(true, "��");
		restartMap.put(false, "restart");
		
		/*numberGo = new NumberGo();
		numberGo.start();*/
		restartGO();
		
		
		restart.setOnAction(ee->restartGO());
		/*restart.setOnAction(ee->{
			reChk = !reChk;
			restart.setText(restartMap.get(reChk));
			
			if(reChk) {
				numberGo = new NumberGo();
				numberGo.start();
			}
		});*/
		
		suspend.setOnAction(ee->{
			chk = !chk;
			suspend.setText(chkMap.get(chk));
		});
		
		
	/*	restart.setOnAction(ee->{
			
			///reChk ::: > true -> ������
			if(reChk) {
				numberGo.cancel();	// ���߱� , ���θ޼ҵ�
			}else {
				numberGo.restart();	// �ٽý���, ���θ޼ҵ�
			}
			
			reChk = !reChk;
			restart.setText(restartMap.get(reChk));
			
			
		});
		
		suspend.setOnAction(ee->{
			chk = !chk;
			suspend.setText(chkMap.get(chk));
		});
		*/
		
		
	}
	
	
	void restartGO() {
		reChk = !reChk;
		restart.setText(restartMap.get(reChk));
		
		if(reChk) {
			numberGo = new NumberGo();
			numberGo.start();
		}
	}
	

	
	class NumberGo extends Service<Void>{

		@Override
		protected Task<Void> createTask() {
			// TODO Auto-generated method stub
			
			Task<Void> task = new Task<Void>() {

				@Override
				protected Void call() throws Exception {
					// TODO Auto-generated method stub
					
					int i =0;
					
					while(true) {
						if(chk) {
							i++;
							System.out.println("���´�");
							//label.setText(i+"");  ���� gui ��ü ���� �Ұ�!!!!
							
							updateMessage(i+"");  ///Task ���� �޼ҵ�� ������ ����
						}
						Thread.sleep(1000);
						
						if(!reChk)
							break;//cancel,restart ���� ����
						
						
					}
					return null;
				}
			};
			
			label.textProperty().bind(task.messageProperty());
			///label �� task�� �����ش�
			
			return task;
		}
		
	}

}
