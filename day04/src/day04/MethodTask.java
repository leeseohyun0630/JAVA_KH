package day04;

import java.util.Iterator;

public class MethodTask {

   public static void main(String[] args) {
      MethodTask m = new MethodTask();
      
      // 1~10 출력하는 메소드
      m.printOne2Ten();
      System.out.println();
      
      // 1~10 합 구해주는 메소드
      System.out.println(m.sumOne2Ten());
      System.out.println();
      
      // 1~n 합 구해주는 메소드
      System.out.println(m.sumOne2Num(10));
      System.out.println();
      
      // 두 정수의 나눗셈 결과를 구해주는 메소드
      System.out.println(m.divide2Integer(10, 3));
      System.out.println();
      
      // 어떤 문자열을 n번만큼 출력하는 메소드
      m.for2String("abc", 3);
      System.out.println();
      
      // n부터 m까지의 합을 구해주는 메소드(n, m보다 작다고 가정)
      System.out.println(m.sumN2M(1, 3));
      System.out.println();
      
      // 문자열을 전부 대문자로 바꿔주는 메소드(hEllo~123 -> HELLO~123)
      // A->65   a->97
      // Z->90   z->122
      System.out.println(m.changeToUpperCase("hEllo~123"));
      System.out.println();
      
      // 문자열을 거꾸로 바꿔주는 메소드(Hello -> olleH)
      System.out.println(m.change("Hello"));
      System.out.println();
      
      // 문자열이 숫자로 이루어져 있는지 검사하는 메소드(숫자가 아닌 것이 포함되어 있다면 false)
      System.out.println(m.stringIsNumber("0fklgj7"));
      System.out.println();
      
      
      // 문자열의 소문자는 대문자로, 대문자는 소문자로 바꿔주는 메소드(hEllo~123 -> HeLLO~123)
      System.out.println(m.changeAlphabet("hEllo~123"));
      System.out.println();
      
      // 정수를 한글로 바꿔주는 메소드(1024 -> 일공이사)
      System.out.println(m.integer2Korea(1024));
      System.out.println();
      
      
   }
   
   // 1~10 출력하는 메소드
   void printOne2Ten(){
      for(int i=1;i<=10;i++) {
         System.out.println(i);
      }
   }
   
   // 1~10 합 구해주는 메소드
   int sumOne2Ten() {
      int result = 0;
      for(int i=1;i<=10;i++) {
         result += i;
      }
      return result;
   }
   
   // 1~n 합 구해주는 메소드
   int sumOne2Num(int n) {
      int result = 0;
      for(int i=1;i<=n;i++) {
         result += i;
      }
      return result;
      
   }

   // 두 정수의 나눗셈 결과를 구해주는 메소드
   double divide2Integer(int n1, int n2) {
      double result =0.0;
      result = (double)(n1)/n2;
      
      return result;
   }
   
   // 어떤 문자열을 n번만큼 출력하는 메소드
   void for2String(String s, int n) {
      for(int i=0; i<n; i++) {
         System.out.println(s);
      }
   }
   
   // n부터 m까지의 합을 구해주는 메소드(n, m보다 작다고 가정)
   int sumN2M(int n, int m) {
      int result = 0;
      if(n<m) {
    	  for (int i = n; i<=m; i++) {
    		  result +=i;
    	  }
      }
//      // n과 m 중 둘중 어느 숫자가 클지 모를 때
//      else if(n>m) {
//    	  for (int i = m; i<=n; i++) {
//    		  result +=i;
//    	  }
//      }
//      else {
//    	  result = n;
//      }
      return result;
   }
   
   // 문자열을 전부 대문자로 바꿔주는 메소드(hEllo~123 -> HELLO~123)
   // A->65   a->97
   // Z->90   z->122
   
   String changeToUpperCase(String s) {
      String result = "";

//      for(int i=0;i<s.length();i++) {
//         if((s.charAt(i)<=122)&&(s.charAt(i)>=90)) {
//            result += (char)(s.charAt(i)-32);
//         }
//         else {
//            result += s.charAt(i);
//         }
//      }
//      return result;      
      for(int i=0;i<s.length();i++) {
         char ch = s.charAt(i);
         if((ch>='a')&&(ch<='z')) {
            result += (char)(ch-32);
         }
         else {
            result += ch;
         }
      }
      return result;
   }
   
   // 문자열을 거꾸로 바꿔주는 메소드(Hello -> olleH)
   String change(String s) {
      String result ="";
      for (int i = 0; i < s.length(); i++) {
    	  result = s.charAt(i) + result;
      }
      
      return result;
   }
   
   
   // 문자열이 숫자로 이루어져 있는지 검사하는 메소드(숫자가 아닌 것이 포함되어 있다면 false)
   // is~~(has~~) : ~~이면(~~를 가지고 있다면) 참 / 아니라면 거짓을 리턴하는 메소드(return 타입이 boolean)
   // 받아오는 문자열을 하나씩 비교
   // 숫자인 경우 continue
   // 아닌 경우 false값 반환
   
   boolean stringIsNumber(String s) {
      int len = s.length();
      for (int i = 0; i < len; i++) {
    	  if(s.charAt(i)>'9'||s.charAt(i)<'0') {
    		  return false;
    	  }
      }         
   return true;
   }
   
   // 문자열의 소문자는 대문자로, 대문자는 소문자로 바꿔주는 메소드(hEllo~123 -> HELLO~123)
   // A->65   a->97
   // Z->90   z->122
   String changeAlphabet(String s) {
      String result = "";
//      for(int i=0;i<s.length();i++) {
//         if((s.charAt(i)<=97)&&(s.charAt(i)>=65)) {
//            result += (char)(s.charAt(i)+32);
//         }
//         else if((s.charAt(i)<=122)&&(s.charAt(i)>=90)) {
//            result += (char)(s.charAt(i)-32);
//         }
//         else {
//            result += s.charAt(i);
//         }
//      }
//      
//      return result;
      for(int i=0;i<s.length();i++) {
         char ch = s.charAt(i);
         if((ch>='a')&&(ch<='z')) {
            result += (char)(ch-32);
         }
         else if((ch>='A')&&(ch<='Z')) {
            result += (char)(ch+32);
         }
         else {
            result += ch;
         }
      }
      return result;
   }
   
   // 정수를 한글로 바꿔주는 메소드(1024 -> 일공이사)
   // 공일이삼사오육칠팔구
   String integer2Korea(int n) {
	  String number = "공일이삼사오육칠팔구";
	  
	  String result ="";
      String num_S = n+"";
      
      int[] num_I =new int[num_S.length()];
      
      for (int i = 0; i < num_I.length; i++) {
         num_I[i] += num_S.charAt(i)- '0';					// 문자를 정수로 바꿈 '1'=49
      }														// '1'이 1이 되려면 48(아스키코드'0')를 빼줘야함
      
      for(int i=0; i<num_I.length;i++) {
         result += number.charAt(num_I[i]);
//         if(num.charAt(i)=='1') {
//            result += "일";
//         }
//         else if(num.charAt(i)=='2') {
//            result += "이";
//         }
//         else if(num.charAt(i)=='3') {
//            result += "삼";
//         }
//         else if(num.charAt(i)=='4') {
//            result += "사";
//         }
//         else if(num.charAt(i)=='5') {
//            result += "오";
//         }
//         else if(num.charAt(i)=='6') {
//            result += "육";
//         }
//         else if(num.charAt(i)=='7') {
//            result += "칠";
//         }
//         else if(num.charAt(i)=='8') {
//            result += "팔";
//         }
//         else if(num.charAt(i)=='9') {
//            result += "구";
//         }
//         else if(num.charAt(i)=='0') {
//            result += "공";
//         }
//         else {
//            result += num.charAt(i);
//         }
      }
      return result;
   }
   
   
   
   
   
   
   
   
   
   
   
   
   
}
