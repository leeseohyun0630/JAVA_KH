package day03;

public class Continue {

	public static void main(String[] args) {
		for (int i = 0; i <= 15; i++) {
			if(i==10) {
				continue;
			}
			System.out.println(i);
		}
		for (int i = 0; i <= 15; i++) {
			if(i==10) {
			}
			else {
				System.out.println(i);
			}
		}
	}

}
