package day03;

public class ArTest2 {

	public static void main(String[] args) {
		int data1 = 10;
		int data2 = data1;				// 10이라는 값이 넣어짐
		data2 += 5;
		System.out.println(data1);		// 주소값이 다르므로 각자 값이 다름

		int[] arData1 = {10, 20, 30};
		int[] arData2 = arData1;		// arData1의 (주소)값을 받음
		arData2[1] = 2000;
		System.out.println(arData1[1]);	// arData1과 arData2의 주소값이 같으므로 대입한 값으로 값이 변함
		
	}

}
