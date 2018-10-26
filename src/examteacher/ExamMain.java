package examteacher;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ExamMain extends Application {

	ArrayList<Exam>data = new ArrayList<>();
	
	
	
	public ExamMain() throws IOException {
		FileChannel channel = FileChannel.open(
				Paths.get("ppp/exam.txt"),
				StandardOpenOption.CREATE,
				StandardOpenOption.WRITE);
		
		Charset charset = Charset.defaultCharset();
		ByteBuffer buf = charset.encode(
				"����, 1�� �ѱ۷� �θ���_��, 2�� �ѱ۷� �θ���_��, 3�� �ѱ۷� �θ���_�Ϳ��, 4�� �ѱ۷� �θ���_��");
		channel.write(buf);
		
		channel.close();
		
		
		channel = FileChannel.open(
				Paths.get("ppp/exam.txt"),
				StandardOpenOption.READ);
		
		buf = ByteBuffer.allocate(100);
		int cnt = 0;
		String da = "";
		charset = Charset.defaultCharset();
		while(true) {
			cnt = channel.read(buf);
			if(cnt==-1)
				break;
			buf.flip();
			
			da+=charset.decode(buf);
			System.out.println(da);
			buf.clear();
			
		}
		channel.close();
		
		data.add(new Exam("����", 
				"1�� �ѱ۷� �θ���_��",
				"2�� �ѱ۷� �θ���_��",
				"3�� �ѱ۷� �θ���_�Ϳ��",
				"4�� �ѱ۷� �θ���_��"));
		
		data.add(new Exam("����", 
				"1�� �����?_one",
				"2�� �����?_cuty",
				"3�� �����?_three",
				"4�� �����?_four"
				));
		data.add(new Exam("����", 
				"1+1��?_2",
				"2+2��?_4",
				"3+3��?_6",
				"4+4��?_�Ϳ��"
				));
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		
		
		Parent root = FXMLLoader.load(
				getClass().getResource("exam.fxml"),
				new ResourceBundle() {
					
					@Override
					protected Object handleGetObject(String key) {
						// TODO Auto-generated method stub
						
						HashMap<String, Object>map = new HashMap<>();
						map.put("data", data);
						map.put("no", 0);
						return map.get(key);
					}
					
					@Override
					public Enumeration<String> getKeys() {
						// TODO Auto-generated method stub
						return null;
					}
				});
		
		Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);
		
		primaryStage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
