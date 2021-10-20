package 실습문제1;

import java.util.Scanner;

public class ex1 {

	public static void main(String[] args) {
		
		
		System.out.print("문자 한 자를 입력하세요: ");
		Scanner sc = new Scanner(System.in);
		char ex = sc.nextLine().charAt(0);
		
			if(ex >= 'A' && ex < 'Z') {
				System.out.println((char) (ex + ('a' - 'A')));
			}else if(ex >='a' && ex <= 'z'){
				System.out.println((char)(ex + 'a' + 'A'));
			}else {
				System.out.println("영문자가 아닙니다.");
			}
			
		}
}
