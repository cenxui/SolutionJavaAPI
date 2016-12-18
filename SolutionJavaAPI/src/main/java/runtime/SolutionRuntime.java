package runtime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SolutionRuntime {

	public static void main(String[] args) {
		Runtime runtime = Runtime.getRuntime();
		
		try {
			printResult(runtime.exec("echo \"Hello Word\" "));
			printResult(runtime.exec("pwd"));
			printResult(runtime.exec("ls"));
			printResult(runtime.exec("pwd"));
			printResult(runtime.exec("java -version"));

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("error");
		} finally {
			runtime.exit(0);
		}		
	}

	private static void printResult(Process process) throws IOException {
		printInputStream(process.getInputStream());
		printInputStream(process.getErrorStream());
	}

	private static void printInputStream(InputStream inputStream) throws IOException {		
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		String temp = null;
		for (;;) {
			temp = reader.readLine();
			if (temp == null) {
				break;
			}
			System.out.println(temp);
		}
	}
}
