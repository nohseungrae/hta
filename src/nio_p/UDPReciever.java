package nio_p;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.StandardProtocolFamily;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class UDPReciever {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			DatagramChannel channel =
					DatagramChannel.open(StandardProtocolFamily.INET);
			
			channel.bind(new InetSocketAddress(7777));
			System.out.println("수신대기");
			
			Path path = Paths.get("ppp/lion2.jpg");
			ByteBuffer buf = ByteBuffer.allocate(1024);
			int size = buf.getInt();
			channel.receive(buf);
			FileChannel file = FileChannel.open(path,
					StandardOpenOption.CREATE,
					StandardOpenOption.WRITE
					);
			
			
			System.out.println(size);//???????????????0만skdha
			buf.flip();
			buf.clear();
			for (int i = 0; i < size; i++) {
				SocketAddress addr = channel.receive(buf);
				int cnt = channel.read(buf);
				/*Charset charset = Charset.defaultCharset();
				String data = charset.decode(buf).toString();*/
				buf.flip();
				channel.write(buf);
				buf.clear();
				System.out.println(addr.toString()+":"+file.size());
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
