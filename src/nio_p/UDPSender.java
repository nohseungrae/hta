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
			// IPV4 사용 -StandardProtocolFamily.INET

			
			// String ip = "192.168.0.255";
			/*Charset charset = Charset.defaultCharset();
			ByteBuffer buf = charset.encode("UDP를 이용하여 파일을 전송하라 실상 똑같아요 ByteBuffer는 한방입니다.");*/
			Path path = Paths.get("ppp/lion2.jpg");
			//경로를 통해 lion파일을 가져옴
			
			ByteBuffer buf = ByteBuffer.allocate(1024);
			//1024를 담을 수 있는 buf를 생성하여 그 용량까지 계속 전송할 것이다.
			int size = (int)(Math.ceil(Files.size(path)/1024.0));
			//그 파일을 1024로 나누면 몇번 전송해줘야하는지 알아내어 size만큼을 for문으로 돌릴 것이다.
			System.out.println("data 전송시작");
			System.out.println(size);
			buf.putInt(size);
			buf.flip();
			channel.send(buf, new InetSocketAddress("172.30.1.42", 7777));
			
			FileChannel file = FileChannel.open(path, 
					StandardOpenOption.READ);
			//파일채널을 이용하여 lion의 경로를 열어주고 그것을 읽어온다.
			
			
			for (int i = 0; i <size ; i++) {
				file.read(buf);
				buf.flip();
				int cnt = channel.send(buf, new InetSocketAddress("172.30.1.42", 7777));
				buf.clear();
	
			System.out.println("data 전송완료 : " + cnt);
			}
			file.close();
			channel.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
