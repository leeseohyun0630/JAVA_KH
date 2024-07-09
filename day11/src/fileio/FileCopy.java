package fileio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCopy {
	public static void main(String[] args) throws Exception {
		InputStream is = new FileInputStream("copy.png");
		System.out.println("InputStream 오픈");
		
		OutputStream os = new FileOutputStream("src/copy2.png");
		System.out.println("OutputStream 오픈");
		
		int data;
		while((data = is.read()) != -1) {
			os.write(data);
		}
		
		is.close();
		os.close();
	}
}
