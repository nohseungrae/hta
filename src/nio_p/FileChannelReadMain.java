package nio_p;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileChannelReadMain {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		FileChannel channel = FileChannel.open(
				Paths.get("ppp/ccc.txt"), StandardOpenOption.READ);
		//������ �� ������ ũ�⸦ �𸣹Ƿ� ����� buffer ũ�� Ȯ��
		ByteBuffer buf = ByteBuffer.allocate(100);
		
		Charset charset = Charset.defaultCharset();
		
		String data = "";
		int cnt = 0;
		while (true) {
			cnt = channel.read(buf);
			
			System.out.println(cnt);
			
			if(cnt==-1) // -1�� ���� �Ǹ� channel���� ������ data�� �������̶�� ��.
				break;
			buf.flip();
			
			data+=charset.decode(buf);
			
			buf.clear();

		}
		
		channel.close();
		
		System.out.println(data);

	}

}
