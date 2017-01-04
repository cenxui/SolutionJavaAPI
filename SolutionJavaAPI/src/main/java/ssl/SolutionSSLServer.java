package ssl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.security.KeyStore;
import java.security.KeyStoreException;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;

public class SolutionSSLServer {

	public static void main(String[] args) {

		
		try {
		    
		    KeyStore ks = KeyStore.getInstance("JKS");
		    ks.load(new FileInputStream("/Users/cenxui/Documents/key/keystore.jks"), "authorisation".toCharArray());

		    KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
		    kmf.init(ks, "authorisation".toCharArray());

		    TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509"); 
		    tmf.init(ks);

		    SSLContext sc = SSLContext.getInstance("TLS"); 
		    TrustManager[] trustManagers = tmf.getTrustManagers(); 
		    sc.init(kmf.getKeyManagers(), trustManagers, null); 

		    SSLServerSocketFactory ssf = sc.getServerSocketFactory(); 
		    SSLServerSocket s = (SSLServerSocket) ssf.createServerSocket(10000);
		    SSLSocket c = (SSLSocket) s.accept();
		    
		   
		    BufferedWriter writer = new BufferedWriter(
					new OutputStreamWriter(c.getOutputStream(), StandardCharsets.UTF_8));
		    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
		    writer.write("Hello World");
		    writer.flush();
//		    
//		    for(;;) { 	
//		    	writer.write(reader.readLine());
//				writer.flush();
//		    }
	
		} catch (Exception e) {
			e.printStackTrace();
		} 

	}

}
