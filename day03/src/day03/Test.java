package day03;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[5];
		
		while(true) {
			System.out.println("1. 데이터 추가\n2. 데이터 삭제\n3. 데이터 전체 보기");
			System.out.println("사용하실 서비스 번호 입력 : ");
			int num = sc.nextInt();
			if(num==1) {
				System.out.println("데이터 추가하는 곳입니다.");
				System.out.println("5개의 데이터를 입력해주세요.");
				for (int i = 0; i < arr.length; i++) {
					arr[i]= sc.nextInt();
				}
				System.out.println("데이터 추가 되어 처음 화면으로 돌아갑니다.");
			}
			else if(num==2){
				System.out.println("데이터 삭제하는 곳입니다.");
				System.out.println("삭제할 n번째의 수를 입력해주세요.");
				int arr_num = sc.nextInt();
				if(arr_num==1) {
					System.out.println("첫번째 값은 지울 수 없습니다.");
					System.out.println("처음 화면으로 돌아갑니다.");
				}
				else if(arr_num>4) {
					System.out.println("범위를 넘어섰습니다.");
					System.out.println("처음 화면으로 돌아갑니다.");
				}
				else {
					System.out.println("===============================");
					for (int i = (arr_num-1); i < arr.length; i++) {
						arr[arr_num]= arr[arr_num+1];
					}
					arr[arr.length-1] = 0;
					System.out.println("데이터 삭제 되어 처음 화면으로 돌아갑니다.");
				}
				
			}
			else if(num==3) {
				System.out.println("전체 데이터 보는 곳입니다.");
				for(int i=0; i<arr.length;i++) {
					System.out.println(arr[i]);
				}
				System.out.println("처음 화면으로 돌아갑니다.");
			}
			else {
				System.out.println("잘못된 번호를 입력하셨습니다.");
			}
			
		}
	}

}
