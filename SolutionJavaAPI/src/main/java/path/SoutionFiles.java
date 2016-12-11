package path;

import static java.lang.System.*;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFileAttributeView;
import java.nio.file.attribute.PosixFileAttributes;
import java.util.stream.Collectors;

public class SoutionFiles {
	public static void main(String[] arg) {
//		try {
//			Files.copy(Paths.get("/Users/Cenxui/"), Paths.get("/Users/Cenxui"));
//			
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//		try {
//			Files.move(Paths.get(""), Paths.get(""));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		files1();
//
//		Path path = Paths.get("./");
//		Files.find(path, 0, (p,a) -> a.isSymbolicLink()).map(p -> p.toString()).collect(Collectors.toList()).forEach(System.out::println);
	}

	private static void files1() {
		try {
			Path path = Paths.get("/Users/Cenxui/");
			out.println("is hidden : " + Files.isHidden(path));
			out.println("is readable : " + Files.isReadable(path));
			out.println("is executable : " + Files.isExecutable(path));
			out.println("is symbolic link : " + Files.isSymbolicLink(path));
			out.println("last modify time" + Files.getLastModifiedTime(path));
			out.println("get owner : " + Files.getOwner(path));
			
			PosixFileAttributeView view = Files.getFileAttributeView(path, PosixFileAttributeView.class);
			out.println("read attribute view : " + view.readAttributes().fileKey());
			out.println("read attributes" + Files.readAttributes(path, PosixFileAttributes.class).creationTime());
			
	
			
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void list(Path path) {
		try {
			Files.list(path)
			.filter(p -> Files.isDirectory(p))
			.map(p-> p.toAbsolutePath())
			.forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void walk(Path path) {
		System.out.println(Files.isExecutable(path));
		
		try {
			Files.walk(path).filter(p ->p.toString().endsWith(".java"))
			.forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
