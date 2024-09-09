package model;

import java.io.FileWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

public class testMain {
	public static void main(String[] args) throws Exception {
		
		Food f = new Food("밥", 100);
		
		System.out.println(f.toString());
		
		f.fileSave("apple");
		
		
		FileWriter fw = null;
		
		fw = new FileWriter("test.txt",true);
		fw.write(97);
		fw.write(65);
		fw.write(100);
		
		fw.close();
	}
}

