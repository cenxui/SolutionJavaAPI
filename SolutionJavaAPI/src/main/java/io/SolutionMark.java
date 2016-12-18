package io;

import static java.lang.System.*;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class SolutionMark {

	private static final int NUMBER = 10000000;

	public static void main(String[] args) {
//		ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(""));
//		DataInputStream dataInputStream;
//		ObjectInputStream objectInputStream2 = new ObjectInputStream(new BufferedInputStream(dataInputStream));
//	
//		DataInputStream dataInputStream2 = new DataInputStream(new BufferedInputStream(objectInputStream2));
//		   
//		new BufferedReader(new InputStreamReader(null, StandardCharsets.UTF_8));
		bufferStream();
	}

	private static void bufferfileStream() {
		long time = currentTimeMillis();
		File file = new File("/Users/cenxui/Downloads/test.txt");
		if (file.exists() == false) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		try (BufferedOutputStream bufferedOutputStream = 
				new BufferedOutputStream(new FileOutputStream(file))){
			for (int i = 0; i < NUMBER; i++) {
				bufferedOutputStream.write(i);
			}
			bufferedOutputStream.flush();
		} catch (Exception e) {
			// TODO: handle exception
		}
		out.println("buffer time : " + (currentTimeMillis() - time));
	}

	private static void bufferStream() {
		try (BufferedInputStream bufferedInputStream = 
				new BufferedInputStream(
						new FileInputStream("/Users/cenxui/Downloads/test.txt"))){		
			if (bufferedInputStream.markSupported()) {
				System.out.println("BufferStream mark support");
				ArrayList<Integer> list = new ArrayList<>();
				for (;;) {
					bufferedInputStream.mark(4);
					System.out.println("availible : " + bufferedInputStream.available());
					int val =  bufferedInputStream.read();
					System.out.println("value : " + val);
					if ((val& 10) == 7) {
						bufferedInputStream.reset();
					}
				}
				
			}else {
				System.out.println("BufferStream mark not support");
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void urlStream() {
		try {
			URL url = new URL("http://www.google.com");
			HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
			InputStream inputStream = urlConnection.getInputStream();
			if (inputStream.markSupported()) {
				System.out.println("mark support");
			}else {
				System.out.println("mark not support");
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void fiileStream() {
		long time = currentTimeMillis();
		File file = new File("/Users/cenxui/Downloads/test.txt");
		if (file.exists() == false)
			try {
				file.createNewFile();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		try (FileOutputStream fileOutputStream = new FileOutputStream(file)){
			for (int i = 0; i< NUMBER;i++)
			fileOutputStream.write(1);
			fileOutputStream.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("file write time" + (currentTimeMillis() - time));
		try (FileInputStream fileInputStream = new FileInputStream("/Users/cenxui/Downloads/test.txt")){
			if (fileInputStream.markSupported()) {
				System.out.println("mark support");
			}else {
				System.out.println("mark not support");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
