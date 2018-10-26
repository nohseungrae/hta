package nio_p;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.StandardProtocolFamily;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.MembershipKey;
import java.nio.charset.Charset;

public class MulticastSender {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			DatagramChannel channel = DatagramChannel.open();
			channel.bind(null);
			NetworkInterface inter = NetworkInterface.getByName("eth1");
			
			channel.setOption(StandardSocketOptions.IP_MULTICAST_IF, inter);
			
			Charset charset = Charset.defaultCharset();
			ByteBuffer buf = charset.encode("우리 그룹이에요");
			
			InetSocketAddress group = new InetSocketAddress("239.1.1.1", 7777);
			
			channel.send(buf, group);
			buf.flip();
		
			System.out.println("송신성공");
						
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
