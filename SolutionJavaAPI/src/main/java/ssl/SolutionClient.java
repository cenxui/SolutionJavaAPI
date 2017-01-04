package ssl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class SolutionClient {

	public static void main(String[] args) {
		try {
		    SSLSocketFactory sslFact =
		      (SSLSocketFactory)SSLSocketFactory.getDefault();
		    SSLSocket s =
		      (SSLSocket)sslFact.createSocket("127.0.0.1", 12345);
		    s.startHandshake();

		    OutputStream out = s.getOutputStream();
		    InputStream in = s.getInputStream();

		    BufferedReader reader = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
		    
		    for (;;) {
		    	System.out.println(reader.readLine());
		    }
		    
		    
		
		}

		catch (IOException e) {
			e.printStackTrace();
		}
		        
	}

}
