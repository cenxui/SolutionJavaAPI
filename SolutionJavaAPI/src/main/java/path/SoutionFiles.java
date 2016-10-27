package path;

import static java.lang.System.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
		
		try {
			out.println("is hidden : " + Files.isHidden(Paths.get("/Users/Cenxui/")));
			out.println("is readable : " + Files.isReadable(Paths.get("/Users/Cenxui/")));
			out.println("is executable : " + Files.isExecutable(Paths.get("/Users/Cenxui/")));
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
