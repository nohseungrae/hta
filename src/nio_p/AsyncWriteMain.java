package nio_p;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.EnumSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class AttachGoGo{
	Path path;
	AsynchronousFileChannel channel;
	
	public AttachGoGo(Path path, AsynchronousFileChannel channel) {
		super();
		this.path = path;
		this.channel = channel;
	}
	
	
}

public class AsyncWriteMain {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		
		ExecutorService executorService = Executors.newFixedThreadPool(
				Runtime.getRuntime().availableProcessors());
		
		System.out.println(executorService);
		
		for (int i = 0; i <10; i++) {
				
			
			
			Path  pp = Paths.get("nnn/aaa_"+i+".txt");
			
			Charset chSet = Charset.defaultCharset();
			
			ByteBuffer buf = chSet.encode("�ð�Ž��� ����");
			
			AsynchronousFileChannel channel = 
					AsynchronousFileChannel.open(pp,
							
							StandardOpenOption.CREATE,
							StandardOpenOption.WRITE
					);
			
			
			//completionHandler�� �۵���Ű������ Path�� channel�� ����� ���� ó���� Ŭ������ ����
			AttachGoGo gogo = new AttachGoGo(pp, channel);
			
			
			////������� �۵�  ---> Ư���۾��� ��ġ�� ���� �ڵ����� completed �� �����
			//channel.write(buf, 0);
			CompletionHandler<Integer, AttachGoGo> completionHandler = 
					
					new CompletionHandler<Integer, AttachGoGo>() {

						@Override   ///channel.write()��������� ����
						public void completed(Integer result, AttachGoGo attachment) {
							// TODO Auto-generated method stub
							//���� �ۼ��� log ����
							/// Thread.currentThread().getName() �������� �����尡 ����� �񵿱� ������ ó����
							System.out.println(Thread.currentThread().getName()+"->"+attachment.path.getFileName()+":"+result+" byte");
							
							try {
								attachment.channel.close();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
						}

						@Override   //channel.write() ó�����н� ����
						public void failed(Throwable exc, AttachGoGo attachment) {
							// TODO Auto-generated method stub
							
						}
					};
			
			///channel �� �ۼ��� ���� :gogo, write()������ ���ó��:completionHandler
			channel.write(buf, 0, gogo, completionHandler);
			
			
			///channel.close(); �����۵��Ǿ����� completionHandler��  completed()���� �ݱ���
					
		}
	}

}
