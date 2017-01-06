package ssl;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.KeyStore;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManagerFactory;

public class SolutionSSLClient {

	public static void main(String[] args) {
		

		try {
		    KeyStore ks = KeyStore.getInstance("JKS");
		    ks.load(new FileInputStream("/Users/cenxui/Documents/key/ssl/clientkeystore.jks"), "support".toCharArray());

			KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
		    kmf.init(ks, "support".toCharArray());
		    
		    KeyStore ts = KeyStore.getInstance("JKS");
		    ts.load(new FileInputStream("/Users/cenxui/Documents/key/ssl/clienttruststore.jks"), "support".toCharArray());
		    
		    TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509"); 
		    
		    tmf.init(ts);

		    SSLContext sc = SSLContext.getInstance("TLS"); 
		    
		    sc.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);

		    SSLSocket socket = (SSLSocket) sc.getSocketFactory().createSocket("127.0.0.1", 10000);
			
			InputStream in = socket.getInputStream();
			
			OutputStream ou = socket.getOutputStream();
			
			System.out.println("Client ready");
			
			ou.write("Hello Client".getBytes());
			
			ou.flush();
			
			for (;;) {
				int r = in.read();
				if (r != -1 ) {
					System.out.print((char)r);
				}

			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

}
