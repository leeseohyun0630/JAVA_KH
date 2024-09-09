package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyMethod {

	public void getDate() {
		String test2 = "2024-07-17 12:22:11";
		String checkin = "";
		checkin = checkin + test2.charAt(2)+test2.charAt(3)+test2.charAt(5)+test2.charAt(6)+test2.charAt(8)+test2.charAt(9);
		int inNum = Integer.parseInt(checkin);
		
		int num1 = 240701;
		int num2 = 240705;
		
		int num3 = 240703;
		int num4 = 240706;
		
		String dateFormatType = "yyyy-MM-dd";
		String strDate = "2024-07-12";
		String endDate = "2024-07-22";
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormatType);
		Date from;
		Date to;
		try {
			from = simpleDateFormat.parse(strDate);
			to = simpleDateFormat.parse(endDate);
			
			long diff = to.getTime() - from.getTime();
			long re = diff/86400000L;
			System.out.println(re);
		} catch (ParseException e) {
		}
		
	}

}

