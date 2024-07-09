package day05;

import java.util.Iterator;
import java.util.Scanner;

public class School {
	public static void main(String[] args) {
//		CRUD
//		1. 학생 추가
//		2. 학생 목록
//		3. 학생 삭제
//		4. 학생 수정
//		5. 성적 입력
//		6. 석차 보기
//		7. 나가기
		Scanner sc = new Scanner(System.in);
		
		String name = "";
		int ban = 0;
		int bun = 0;
		boolean flag = false;
		
		
		// 등록된 학생들의 정보를 객체화 해서 저장할 배열, 정보(데이터)를 객체단위로 저장
		// 배열의 각 방 하나하나가 Student 타입의 객체(name, ban, bun)
		Student[] list = new Student[1000];
		
		// 현재까지 등록된 학생의 수 == 새로 등록될 학생 객체가 들어갈 방(인덱스) 번호
		int studCnt = 0;
		while(true) {
			System.out.println("1. 학생 추가\n2. 학생 목록\n3. 학생 삭제\n4. 학생 수정"
					+ "\n5. 성적 입력\n6. 석차 보기\n7. 나가기");
			int choice = sc.nextInt();
			if(choice == 7) {
				// 종료
				System.out.println("안녕히 가세요.");
				break;
			}
			switch(choice) {
			case 1:
				System.out.println("이름 입력 : ");
				name = sc.next();
				System.out.println("반 입력 : ");
				ban = sc.nextInt();
				System.out.println("번호 입력 : ");
				bun = sc.nextInt();
				
				// 여기까지 왔으면 학생을 등록하기 위한 모든 정보를 입력 받았으므로
				// 각 이름, 반, 번호를 저장해준다.
				// 이름, 반, 번호를 따로 저장하면 각각 정보들마다 배열이 필요
				// 하나의 객체로 포장하여 저장을 해준다.
				// 학생 객체를 새로 생성해서(new Student(name, ban, bun) )
				// 모든 학생 객체들을 저장해주는 list 배열에 담아준다 (list[] = )
				// 새로 등록되는 학생이 들어갈 방 번호는 현재 학생수인 studCnt와 일치
				// 새롭게 학생이 등록되었기 때문에 저장 후에는 studCnt를 하나 증가시켜준다.
				
				// 매 우 중 요 -> 혼자 생각 못했음.
				list[studCnt] = new Student(name, ban, bun);
				studCnt++;
				
				break;
			case 2:
				for (int i = 0; i < studCnt; i++) {
					Student temp = list[i];
					String data = String.format("%s(%d반 %d번) - 총점 : %d점",temp.name,temp.ban,temp.bun,temp.tot);
					//System.out.println("이름 : "+list_stud[i].name+" "+list_stud[i].ban+"반 "+list_stud[i].bun+"번");
					System.out.println(data);
				}
				break;
			case 3:
				System.out.println("반 입력 : ");
				ban = sc.nextInt();
				System.out.println("번호 입력 : ");
				bun = sc.nextInt();
				
				flag = false;
				for (int i = 0; i < studCnt; i++) {
					Student temp = list[i];
					if(temp.ban == ban) {
						if(temp.bun == bun) {
							flag = true;
							for (int j = i; j < studCnt-1; j++) {
								list[j] = list[j+1];
							}
							list[studCnt-1] = null;
							studCnt--;
							break;
						}
					}
				}
				if(flag == true) {
					System.out.println("학생 수정 성공!");
				}
				else {
					System.out.println("일치하는 학생을 찾을 수 없습니다!");
				}
				break;
				
			case 4:
				System.out.println("반 입력 : ");
				ban = sc.nextInt();
				System.out.println("번호 입력 : ");
				bun = sc.nextInt();
				
				flag = false;
				for (int i = 0; i < studCnt; i++) {
					Student temp = list[i];
					if(temp.ban == ban) {
						if(temp.bun == bun) {
							flag = true;
							System.out.print("새로운 이름 : ");
							temp.name = sc.next();
							break;
						}
					}
				}
				if(flag == true) {
					System.out.println("학생 수정 성공!");
				}
				else {
					System.out.println("일치하는 학생을 찾을 수 없습니다!");
				}
				break;

			case 5:
				System.out.println("반 입력 : ");
				ban = sc.nextInt();
				System.out.println("번호 입력 : ");
				bun = sc.nextInt();
				
				flag = false;
				for (int i = 0; i < studCnt; i++) {
					Student temp = list[i];
					if(ban == temp.ban) {
						if(bun == temp.bun) {
							flag = true;
							System.out.println("국어 점수 입력 : ");
							temp.kor = sc.nextInt();
							System.out.println("영어 점수 입력 : ");
							temp.eng = sc.nextInt();
							System.out.println("수학 점수 입력 : ");
							temp.math = sc.nextInt();
							
							temp.tot = temp.kor+temp.eng+temp.math;
							break;
						}
					}
				}
				if(flag == true) {
					System.out.println("성적 입력 성공!");
				}
				else {
					System.out.println("일치하는 학생을 찾을 수 없습니다!");
				}
				break;
			case 6:

				for (int i = 0; i < studCnt; i++) {
					Student temp1 = list[i];
					for (int j = 0; j <studCnt; j++) {
						Student temp2 = list[j];
						if(temp1.tot<temp2.tot) {
							Student temp3 = temp1;
							temp1 = temp2;
							temp2 = temp3;
						}
					}
					String data = String.format("%s(%d반 %d번) - 총점 : %d점",temp1.name,temp1.ban,temp1.bun,temp1.tot);
					System.out.println(data);
				}

				break;
			default:
				System.out.println("잘못된 번호를 입력하셨습니다.");
				break;
			}
		}
	}
}

class Student{
	String name;
	int ban;
	int bun;
	
	int kor;
	int eng;
	int math;
	int tot;
	public Student(String name, int ban, int bun) {
		this.name = name;
		this.ban = ban;
		this.bun = bun;
		
	}
}
