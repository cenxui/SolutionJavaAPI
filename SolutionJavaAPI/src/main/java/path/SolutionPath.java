package path;

import static java.lang.System.out;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.nio.file.attribute.BasicFileAttributes;;


public class SolutionPath {

	public static void main(String[] args) throws IOException {
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
		
		
		
//		Path P = Paths.get("/LL.txt");
//		System.out.println(path.resolve("txt"));
		
		
//		if (Files.isDirectory(path) && Files.isSymbolicLink(path)) {
//			Files.createDirectories(path.resolve("joey"));
//		}
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
