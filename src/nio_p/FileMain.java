package nio_p;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileMain {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Path pp = Paths.get("ppp");
		
		System.out.println(pp);
		System.out.println(Files.isDirectory(pp));
		System.out.println(Files.isRegularFile(pp));
		
		DirectoryStream<Path> ds = Files.newDirectoryStream(pp);
		for (Path path : ds) {

			System.out.print(
					"이름 : " + path + "\n수정된시간 : " + Files.getLastModifiedTime(path).toString().substring(0, 19));
			if(path.endsWith("")) {
			System.out.print("<DIR>");
			}
			System.out.println("\n사이즈 : " + Files.size(path) + "바이트");
			System.out.println();

		}
		
		
		System.out.println("----------------------");
		
		pp = Paths.get("ppp/라이언.jpg");
		System.out.println(pp);
		System.out.println(Files.isDirectory(pp));
		System.out.println(Files.isRegularFile(pp));
		System.out.println(Files.getLastModifiedTime(pp));
		System.out.println(Files.size(pp));
		System.out.println(Files.getOwner(pp));
		System.out.println(Files.isHidden(pp));
		System.out.println(Files.isReadable(pp));
		System.out.println(Files.isWritable(pp));
		System.out.println("파일명:"+pp.getFileName());
		System.out.println("현재디렉토리명:"+pp.getParent().getFileName());
		System.out.println("디렉토리 경로수:"+pp.getNameCount());
		
		System.out.println();
		
		for (int i = 0; i < pp.getNameCount(); i++) {
			System.out.println(pp.getName(i));
		}
	}

}
