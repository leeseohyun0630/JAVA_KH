package obj;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.print.attribute.standard.DateTimeAtCompleted;

public class DataTest {
	public static void main(String[] args) {
		Date obj1 = new Date();
		// System.out.println(obj1.getMonth()+1);
		
		// 지역을 상징하는 고유한 정보를 가지고 있는 객체
		ZoneId zone = ZoneId.systemDefault();
		//			시간 정보를 가진 객체를 토대로 	지역에서	지역 연월일 정보 받기
		LocalDate id = obj1.toInstant().atZone(zone).toLocalDate();
		
		System.out.println(id);
		System.out.println(id.getYear());
		System.out.println(id.getMonth());
		System.out.println(id.getDayOfMonth());
		
		LocalDateTime idt = obj1.toInstant().atZone(zone).toLocalDateTime();
		
		System.out.println(idt);
		System.out.println(idt.getHour());
		System.out.println(idt.getMinute());
		System.out.println(idt.getSecond());
		System.out.println();
		
		// 만약 자바에서만 시간 정보를 추출해서 사용하고자 할 경우에 간단하게 객체화
		// 현재 순간
		LocalDateTime now = LocalDateTime.now();
		System.out.println(now);
		
		// 지정된 순간
		LocalDateTime ind_day = LocalDateTime.of(1945, 8, 15, 12,20,11);
		System.out.println(ind_day);
		
		// 시간 정보 포매팅(서식화 하기)
		// 1945/08/15 12:20:11
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		String time = ind_day.format(formatter);
		System.out.println(ind_day.format(formatter));
		System.out.println(time);
		
		
		
		
		
		
	}
}
