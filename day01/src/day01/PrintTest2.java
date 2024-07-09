package day01;

public class PrintTest2 {
// Ctrl + space bar : 자동완성
	public static void main(String[] args) {
		System.out.print(10);
		System.out.print('\n');
		System.out.println();
		System.out.print(20);
		System.out.print('\n');
		
		
		System.out.print("\'Hello\'");
		System.out.print('\n');
		System.out.print("\"이서현\"");
		System.out.print('\n');
		System.out.println("줄바꿈이 되는 println()");
		
		System.out.println(5+3);
		System.out.println("파이 : "+3.14);
		
		int i = 1;
		int sum = 0;
		sum = i+i;
		
		System.out.println(1+" + "+1+" = "+2);
		System.out.printf("%d+%d=%d", i, i, sum);
		System.out.print('\n');
	}
}
