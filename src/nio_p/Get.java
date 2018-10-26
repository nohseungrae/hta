package nio_p;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class Get {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
			
			Path path = Paths.get("nnn/");
			
			DirectoryStream<Path> ds = Files.newDirectoryStream(path);
			

			for (Path path2 : ds) {
				System.out.println(path2);
				path2.getFileName();
				
			}
			
			
			
/*			AsynchronousFileChannel channel = AsynchronousFileChannel.open(
					path, StandardOpenOption.READ);
			
			ByteBuffer buf = ByteBuffer.allocate((int)channel.size());
			
			Charset charset = Charset.defaultCharset();
			
			
			String data = charset.decode(buf).toString();
			

			System.out.println(data);*/


			

	}

}
