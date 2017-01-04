package ssl;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class SolutionServer {

	public static void main(String[] args) {
		SSLServerSocket s;

		try {
		    SSLServerSocketFactory sslSrvFact =
		        (SSLServerSocketFactory)
		        SSLServerSocketFactory.getDefault();
		    s =(SSLServerSocket)sslSrvFact.createServerSocket(12345);

		    SSLSocket c = (SSLSocket)s.accept();

		    OutputStream out = c.getOutputStream();
		    InputStream in = c.getInputStream();

		    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out,StandardCharsets.UTF_8));
		    writer.write("Hello World");
		    writer.flush();
		    
		    System.out.println("Server suceed");
		}

		catch (IOException e) {
			e.printStackTrace();
		}
	}

}
