package fileio;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class FileDownload {
	public static void main(String[] args) throws Exception{
		String path = "https://cdn.imweb.me/upload/S20221129c3c04fdc67a8b/09e904cb8f26f.png";
		
		URL url = new URL(path);
		System.out.println("URL 오픈");
		
		InputStream is = url.openStream();
		System.out.println("InputStream 오픈");
		
		OutputStream os = new FileOutputStream("copy.png");
		System.out.println("OutputStream 오픈");
		
		while(true) {
			int data = is.read();
			if(data == -1) {
				break;
			}
			os.write(data);
		}
		
		is.close();
		os.close();
		
	}
}
