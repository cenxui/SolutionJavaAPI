import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SolutionServer {

	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(80);
			Socket socket = server.accept();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
