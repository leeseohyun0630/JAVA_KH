package day03;

import java.util.Iterator;
import java.util.Scanner;

public class ArTask {

	public static void main(String[] args) {

//		// 5칸 배열 생성 후 1부터 5까지 넣어준 후 각 방에 있는 값들 순서대로 출력
//		int[] arr1 = new int[5];
//		for(int i=0; i<arr1.length;i++) {
//			arr1[i]=i+1;
//		}
//		for(int i=0; i<arr1.length;i++) {
//			System.out.println(arr1[i]);
//		}
//		System.out.println("===============================");
//		
//		// 5칸 배열 생성 후 10, 7, 4, 1, -2 넣어준 후 각 방에 있는 값들 순서대로 출력
//		int[] arr2 = new int[5];
//		for(int i=0; i<arr1.length;i++) {
//			arr2[i]=10-3*i;
//		}
//		for(int i=0; i<arr2.length;i++) {
//			System.out.println(arr2[i]);
//		}
//		System.out.println("===============================");
//		
//		// 사용자에게 정수 3개 입력받아서 순서대로 출력 후 합도 출력
//		int[] arr3 = new int[3];
//		int arr3_sum = 0;
//		Scanner sc = new Scanner(System.in);
//		
//		for(int i=0; i<arr3.length;i++) {
//			System.out.print("정수 입력 : ");
//			arr3[i] = sc.nextInt();
//			arr3_sum += arr3[i];
//		}
//		for(int i=0; i<arr3.length;i++) {
//			System.out.println(arr3[i]);
//		}
//		System.out.println("3개의 정수의 합 : "+arr3_sum);
//		System.out.println("===============================");
//		
//		// 1, 100, 7, 35, 22, 78, 17, 89, 3, 9 반복문 사용해서 출력
//		int[] arr4 = {1, 100, 7, 35, 22, 78, 17, 89, 3, 9};
//		for(int i=0; i<arr4.length;i++) {
//			System.out.println(arr4[i]);
//		}
//		System.out.println("===============================");
		
//		// 20칸 빈 배열 생성 후 홀수번째 방은 -2, -4, -6, -8, ..
//		// 짝수번째 방은 1, 3, 5, 7,.. 넣고 출력
//		int[] arr5 = new int[20];
//		for (int i = 0; i < arr5.length; i++) {
//			if(i%2==0) {
//				arr5[i] = i+1;
//			}
//			else {
//				arr5[i] = -(i+1);
//			}
//		}
//		for (int i = 0; i < arr5.length; i++) {
//			System.out.println(arr5[i]);
//		}
//		System.out.println("===============================");
		
//		// 20칸 빈 배열 생성 후 홀수번째 방은 -1, -4, -7, -10, ..
//		// 짝수번째 방은 2, 7, 12, 17, ...
//		int[] arr6 = new int[20];
//		for (int i = 0; i < arr6.length; i++) {
//			if(i%2==0) {
//				arr6[i] = (int)((double)(5*i/2)+2);
//			}
//			else {
//				arr6[i] = (int)((double)(-(3*i/2)+1/2));
//			}
//		}
//		for (int i = 0; i < arr6.length; i++) {
//			System.out.println(arr6[i]);
//		}
//		System.out.println("===============================");
		
		// 사용자에게 국어, 수학, 영어 점수 입력받은 후 전체 점수 출력
		System.out.print("과목의 수를 입력 : ");
		Scanner sc = new Scanner(System.in);
	      
	    int num = Integer.parseInt(sc.nextLine());
	    
	    String[] arrSubject = new String[num];
	    for (int i = 0; i < arrSubject.length; i++) {
	       System.out.print((i+1)+"번째 과목 이름 입력 : ");
	       arrSubject[i] = sc.nextLine();
	    }
        int[] arrScore = new int[arrSubject.length];
	      
	    int sum = 0;
	    for (int i = 0; i < arrScore.length; i++) {
	       System.out.print(arrSubject[i]+" 과목의 점수 입력 : ");
	       arrScore[i] = Integer.parseInt(sc.nextLine());
	       sum += arrScore[i];
	    }
	    System.out.println();
	      
	    for (int i = 0; i < arrScore.length; i++) {
	       System.out.println(arrSubject[i]+" 과목의 점수 : " +arrScore[i]+"점");
	    }
	    double avg = sum/3.0;
	     
	    System.out.println();
	    System.out.println("총점은 "+sum+"점입니다.");
	    System.out.printf("평균은 %.2f점입니다.", avg);

		
	}

}
