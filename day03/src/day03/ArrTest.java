package day03;

public class ArrTest {

	public static void main(String[] args) {
		// 선언 방법 1
		int[][] arr1 = {
				{10, 20, 30},		//0행	0번방, 1번방, 2번방(열)
				{40, 50, 60}		//1행	0번방, 1번방, 2번방(열)
		};
		
		// 선언 방법 2
		int[][] arr2 = new int[3][5];
		for (int i = 0; i < arr2.length; i++) {
			for (int j = 0; j < arr2[i].length; j++) {
				arr2[i][j] = i+j;
			}
		}
		
		for (int i = 0; i < arr2.length; i++) {
			for (int j = 0; j < arr2[i].length; j++) {
				System.out.println(arr2[i][j]);
			}
		}
		
		System.out.println(arr1);
		System.out.println(arr2);
		
		// 행의 개수만 지정한 채 선언
		int[][] arr3 = new int[3][];
		// null : 주소값의 초기값, 비어있다, 연결되지 않았다 라는 뜻
		// 행의 개수만 지정한 채 배열을 선언하면 한 번 접근해서 찾아갔을 때 연결되어 있는 공간들(소배열들)이 존재하지 않음
		// 그렇게 때문에 null 값을 담고 있음. 2차원 배열을 제대로 사용하려면 소배열을 만들어서 연결을 해줘야함.
		for (int i = 0; i < arr3.length; i++) {
			System.out.println(arr3[i]);
		}
		arr3[0] = new int[5];
		arr3[1] = new int[7];
		arr3[2] = new int[3];
		
		System.out.println("행의 개수 :" +arr3.length);		// 2차원배열명.length : 행의 개수
		System.out.println("0행의 열수 :" +arr3[0].length);		// 2차원배열명[행번호].length : 각 행의 열의 개수
		System.out.println("1행의 열수 :" +arr3[1].length);		
		System.out.println("2행의 열수 :" +arr3[2].length);		
	}
	

}
