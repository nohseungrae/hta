package nio_p;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.StandardProtocolFamily;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class UDPSender {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			DatagramChannel channel =
					DatagramChannel.open(StandardProtocolFamily.INET);
			// IPV4 ��� -StandardProtocolFamily.INET

			
			// String ip = "192.168.0.255";
			/*Charset charset = Charset.defaultCharset();
			ByteBuffer buf = charset.encode("UDP�� �̿��Ͽ� ������ �����϶� �ǻ� �Ȱ��ƿ� ByteBuffer�� �ѹ��Դϴ�.");*/
			Path path = Paths.get("ppp/lion2.jpg");
			//��θ� ���� lion������ ������
			
			ByteBuffer buf = ByteBuffer.allocate(1024);
			//1024�� ���� �� �ִ� buf�� �����Ͽ� �� �뷮���� ��� ������ ���̴�.
			int size = (int)(Math.ceil(Files.size(path)/1024.0));
			//�� ������ 1024�� ������ ��� ����������ϴ��� �˾Ƴ��� size��ŭ�� for������ ���� ���̴�.
			System.out.println("data ���۽���");
			System.out.println(size);
			buf.putInt(size);
			buf.flip();
			channel.send(buf, new InetSocketAddress("172.30.1.42", 7777));
			
			FileChannel file = FileChannel.open(path, 
					StandardOpenOption.READ);
			//����ä���� �̿��Ͽ� lion�� ��θ� �����ְ� �װ��� �о�´�.
			
			
			for (int i = 0; i <size ; i++) {
				file.read(buf);
				buf.flip();
				int cnt = channel.send(buf, new InetSocketAddress("172.30.1.42", 7777));
				buf.clear();
	
			System.out.println("data ���ۿϷ� : " + cnt);
			}
			file.close();
			channel.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
