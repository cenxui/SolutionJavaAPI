package path;

import static java.lang.System.out;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;;


public class SolutionPath {

	public static void main(String[] args) throws IOException {
		
		Path path = Paths.get(".").normalize();
		out.println(path.getFileName());
		
		int count = 0;
		for (int i = 0; i< path.getNameCount();i++) {
			count++;
		}
		
		out.println(count);
		
//		Path P = Paths.get("/LL.txt");
//		System.out.println(path.resolve("txt"));
		
		
//		if (Files.isDirectory(path) && Files.isSymbolicLink(path)) {
//			Files.createDirectories(path.resolve("joey"));
//		}
	}

	private static void path3() throws IOException {
		Path path1 = Paths.get("./goat.txt").normalize();
		Files.createFile(path1);
		out.println(path1);
		Path path2 = Paths.get("mule.png");
		Files.copy(path1, path2, StandardCopyOption.COPY_ATTRIBUTES);
	}

	private static void path2() {
		Path path1 = Paths.get("/pets/../cat.txt");
		Path path2 = Paths.get("./dog.txt");
		
		out.println(path1.resolve(path2));
		out.print(path2.resolve(path1));
	}

	private static void path1() throws IOException {
		Path path = Paths.get("/Users/Cenxui/../SolutionJavaAPI/");
		out.println("absolutely path : " + path.toAbsolutePath());
		out.println("real path : " + path.toRealPath());
		out.println("file name : " + path.getFileName() );
		out.println("parent : " + path.getParent());
		out.println("root : " + path.getRoot());
		out.println("is absoutely path : " + path.isAbsolute());
		
		Path path2 = Paths.get("../..");
		out.println("absolutely path : " + path2.toAbsolutePath());
		out.println("real path : " + path2.toRealPath());
		out.println("" + path2.relativize(path));
	}

	private static void attribute(Path path) {
		try {
			BasicFileAttributes attribute = Files.readAttributes(path, BasicFileAttributes.class);
			if (attribute.size()>0 && attribute.creationTime().toMillis()>0) {
//				attribute.setTime
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
