package day04;

import java.util.Iterator;
import java.util.Scanner;

public class NestedFor {
	public static void main(String[] args) {
//		int[][] arr1 = {
//				{10,20,30},
//				{40,50,60}
//		};
//		System.out.println(arr1[0][0]);
//		System.out.println(arr1[0][1]);
//		System.out.println(arr1[0][2]);
//		System.out.println(arr1[1][0]);
//		System.out.println(arr1[1][1]);
//		System.out.println(arr1[1][2]);
//		System.out.println("====================");
//		
//		for (int i = 0; i < 6; i++) {
//			System.out.println(arr1[i/3][i%3]);
//		}
//		
//		for (int i = 0; i < arr1.length; i++) {
//			for (int j = 0; j < arr1[i].length; j++) {
//				System.out.println(arr1[i][j]);
//			}
//		}
//		
//		System.out.println("====================");
//		for (int i = 1; i <=9 ; i++) {
//			System.out.printf("%d × %d = %d \n", 2, i, 2*i);
//		}
//		
//		for (int i = 1; i <=9; i++) {
//			System.out.println("========="+i+"단===========");
//			for (int j = 1; j <=9; j++) {
//				System.out.printf("%d × %d = %d \n", i, j, i*j);
//			}
//		}
//		int[][] arr2 = new int[3][];
//		arr2[0] = new int[5];
//		arr2[1] = new int[3];
//		arr2[2] = new int[2];
//		
//		for (int i = 0; i < arr2.length; i++) {
//			for (int j = 0; j < arr2[i].length; j++) {
//				System.out.println(arr2[i][j]);
//			}
//		}
//
//		for (int i = 0; i < 5; i++) {
//			for (int j = 0; j < 5; j++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
//		System.out.println("===================");
//
//		for (int i = 1; i <= 5; i++) {
//			for (int j = 0; j < i; j++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
//		System.out.println("===================");
//
//		for (int i = 5; i > 0; i--) {
//			for (int j = 0; j < i; j++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
//		System.out.println("===================");
//
//		for (int i = 1; i <=5 ; i++) {
//			for (int j = 0; j <= 5-i; j++) {
//				System.out.print(" ");
//			}
//			for (int j = 0; j <(2*i-1); j++) {
//				System.out.print("*");
//			}
//
//			System.out.println();
//		}
//		System.out.println("===================");
//
//		for (int i = 5; i >0 ; i--) {
//			System.out.print(" ");
//			for (int j = 5-i; j >0; j--) {
//				System.out.print(" ");
//			}
//			for (int j =(2*i-1); j >0; j--) {
//				System.out.print("*");
//			}
//
//			System.out.println();
//		}
		
		Scanner sc = new Scanner(System.in);
		System.out.print("학생 수 입력 : ");
		int studentNum = sc.nextInt();
		System.out.print("과목 수 입력 : ");
		int subjectNum = sc.nextInt();
		
		int[][] subjectSum = new int[studentNum][subjectNum];
		String[] subjectInfo = new String[subjectNum];
		
		sc.nextLine();
		
		for (int i = 0; i < subjectInfo.length; i++) {
			System.out.print("과목명 입력 : ");
			subjectInfo[i] = sc.nextLine();
		}
		System.out.println("======================");
//		for (int i = 0; i < subjectInfo.length; i++) {
//			System.out.println(subjectInfo[i]);
//		}
//		
//		System.out.println("======================");
		
		int total = 0;
		for (int i = 0; i < subjectSum[i].length; i++) {
			for (int j = 0; j < subjectSum.length; j++) {
				System.out.print((j+1)+"번 학생의 과목 "+subjectInfo[i]+"의 점수 입력 : ");
				subjectSum[j][i] = sc.nextInt();
			}
		}
		
//		for (int i = 0; i < subjectSum.length; i++) {
//			for (int j = 0; j < subjectSum[i].length; j++) {
//				System.out.print(subjectSum[i][j]);
//			}
//			System.out.println();
//		}
		for (int i = 0; i < subjectSum.length; i++) {
			for (int j = 0; j < subjectSum[i].length; j++) {
				total += subjectSum[i][j];
			}
		}
		double avg = (double)total/(double)(studentNum*subjectNum);

		System.out.println("총 점수 : "+total);
		System.out.printf("전체 평균 점수 : %.2f \n",avg);
		int avg_s = 0;
		
		for (int i = 0; i < subjectSum[i].length; i++) {
			avg_s += subjectSum[i][0];
			System.out.println(avg_s);
		}
		
		// 이 아래 포문이 문제임.
		
		for (int i = 0; i < subjectSum[i].length; i++) {
			for (int j = 0; j < subjectInfo.length; j++) {
				avg_s += subjectSum[0][i];
			}
			System.out.println(avg_s);
			System.out.println(subjectInfo[i]+" 과목의 평균 : "+ (double)(avg_s)/(double)(studentNum));
			
		}
		
		
	}
}
