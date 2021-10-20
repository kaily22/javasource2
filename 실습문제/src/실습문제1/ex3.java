package 실습문제1;

import java.util.Scanner;

public class ex3 {

	public static void main(String[] args) {
		
		System.out.print("연도를 입력하시오 >>");
		Scanner sc = new Scanner(System.in);
		
		int year = sc.nextInt();
		
		if(year % 4 ==0 || year% 400 == 0) {
			System.out.println("윤년입니다.");
		}else {
			System.out.println("평년입니다.");
		}
		
		
		
		

	}

}
