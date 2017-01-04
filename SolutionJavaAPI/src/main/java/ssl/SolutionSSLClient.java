package ssl;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;

public class SolutionSSLClient {

	public static void main(String[] args) {
		URL url;
		System.setProperty("javax.net.ssl.trustStore","/Users/cenxui/Documents/key/keystore.jks");
		try {
			url = new URL("https://localhost:10000");
			
			HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
	
			KeyStore ks = KeyStore.getInstance("JKS");
		    ks.load(new FileInputStream("/Users/cenxui/Documents/key/keystore.jks"), "authorisation".toCharArray());

		    TrustManagerFactory tmf = 
		    		  TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
		    		tmf.init(ks);
		    		SSLContext ctx = SSLContext.getInstance("TLS");
		    		ctx.init(null, tmf.getTrustManagers(), null);
		    SSLSocketFactory sslFactory = ctx.getSocketFactory();

		   
		
			
			httpsURLConnection.setSSLSocketFactory(sslFactory);
			
//	

//			SSLSocketFactory socketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
			
//			httpsURLConnection.setSSLSocketFactory(socketFactory);
			
			BufferedReader reader = 
					new BufferedReader(
							new InputStreamReader(httpsURLConnection.getInputStream(), StandardCharsets.UTF_8));
			
			for (;;) {
				System.out.println(reader.readLine());
			}
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (KeyStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CertificateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (KeyManagementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
