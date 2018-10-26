package nio_p;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileChannelWriteMain {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		FileChannel channel = FileChannel.open(
				Paths.get("ppp/ccc.txt"),
				StandardOpenOption.CREATE,
				StandardOpenOption.WRITE);
		//버퍼생성
		Charset charset = Charset.defaultCharset();
		ByteBuffer buf = charset.encode("아기상어 뚜루루 뚜루");
		
		//파일에 쓰기
		int cnt = channel.write(buf);
		System.out.println(cnt);
		
		buf = charset.encode("최강의 태양의 마테차");
		
		//파일에 쓰기2
		cnt = channel.write(buf);
		System.out.println(cnt);
		
		//파일에 쓰기3
		cnt = channel.write(buf);//한번 작성한 buffer의 내용은 다시 사용못함.
		System.out.println(cnt);
		
		
		//파일채널 닫기 꼭 닫아줘라 
		channel.close();

	}

}
