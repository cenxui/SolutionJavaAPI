package ssl;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.KeyStore;

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
		    ks.load(new FileInputStream("/Users/cenxui/Documents/key/ssl/serverkeystore.jks"), "support".toCharArray());

		    KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
		    kmf.init(ks, "support".toCharArray());

		    KeyStore ts = KeyStore.getInstance("JKS");
		    ts.load(new FileInputStream("/Users/cenxui/Documents/key/ssl/servertruststore.jks"), "support".toCharArray());
		    
		    TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509"); 
		    tmf.init(ts);
		 
		    SSLContext sc = SSLContext.getInstance("TLS"); 
		    TrustManager[] trustManagers = tmf.getTrustManagers(); 
		    sc.init(kmf.getKeyManagers(), trustManagers, null); 

		    SSLServerSocketFactory ssf = sc.getServerSocketFactory(); 
		    SSLServerSocket s = (SSLServerSocket) ssf.createServerSocket(10000);
		    SSLSocket c = (SSLSocket) s.accept();
		    
		    InputStream in = c.getInputStream();
		    OutputStream ou = c.getOutputStream();
		    
		    ou.write("Hello World".getBytes());
		    
		    for(;;) { 	
				int r = in.read();
				if (r != -1) {
					System.out.print((char)r);
				}
				
		    }
		} catch (Exception e) {
			e.printStackTrace();
		} 

	}

}
