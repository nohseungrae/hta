package nio_p;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

class SingleSender extends Thread {
	
	SocketChannel socket;
	
	public SingleSender(SocketChannel client) {
		this.socket = socket;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
	}
}

class SingleReciever extends Thread{
	
	SocketChannel socket;

	public SingleReciever(SocketChannel client) {
		// TODO Auto-generated constructor stub
		this.socket = socket;
	}
	@Override
	public void run() {
		ByteBuffer buf = ByteBuffer.allocate(100);
		
		super.run();
	}
	
}

public class H1023Server {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		ServerSocketChannel server = ServerSocketChannel.open();//서버소켓채널을 열겠다.
		
		server.configureBlocking(true);//true 블로킹모드,false 넌블로킹모드
		server.bind(new InetSocketAddress(7777));//포트7777 주소를 가진 것을 만들겠다

		SocketChannel client = server.accept();//

		new SingleSender(client).start();
		new SingleReciever(client).start();

	}

}
