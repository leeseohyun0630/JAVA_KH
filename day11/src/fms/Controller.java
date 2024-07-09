package fms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Controller {
	public final static String DATABASE = "db.txt";
	
	void insert(Model model) {
		try {
			FileWriter fw = new FileWriter(DATABASE, true);
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.write(model.data+"\r\n");
			bw.close();
		} catch (IOException e) { }
	}
	
	void modify(String data1, String data2) {
		try {
			FileReader fr = new FileReader(DATABASE);
			BufferedReader br = new BufferedReader(fr);
			
			String result = "";
			while(true) {
				String line = br.readLine();
				if(line == null) {
					break;
				}
				if(line.equals(data1)) {
					result += data2+"\r\n";
				}
				else {
					result += line+"\r\n";
				}
			}
			FileWriter fw = new FileWriter(DATABASE);
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.write(result);
			bw.close();
		} catch (FileNotFoundException e) {	
		} catch (IOException e) {
		}
	}
	
	void delete(String data) {
		try {
			FileReader fr = new FileReader(DATABASE);
			BufferedReader br = new BufferedReader(fr);
			
			String result = "";
			while(true) {
				String line = br.readLine();
				if(line == null) {
					break;
				}
				if(line.equals(data)) {
					
				}
				else {
					result += line+"\r\n";
				}
			}
			FileWriter fw = new FileWriter(DATABASE);
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.write(result);
			bw.close();
		} catch (FileNotFoundException e) {	
		} catch (IOException e) {
		}
	}

	void check() {
		try {
			FileReader fr = new FileReader(DATABASE);
			BufferedReader br = new BufferedReader(fr);
			
			while(true) {
				String line = br.readLine();
				if(line==null) {
					break;
				}
				System.out.println(line);
			}
		} catch (Exception e) {}
	}
	
}
