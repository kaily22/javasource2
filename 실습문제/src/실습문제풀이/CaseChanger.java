package 실습문제풀이;

import java.io.IOException;
import java.util.Scanner;

public class CaseChanger {

	public static void main(String[] args) throws IOException {
		
		char alpha;
		
		System.out.print("문자를 입력하세요 >>>> ");
//		Scanner in = new Scanner(System.in);
//		alpha = in.next().charAt(0);
		
		//read() : IOException 처리를 해주기
		alpha = (char) System.in.read();
		
		if(alpha >= 'a' && alpha <= 'z' ) {
			//ASCII 코드값 : 'a' : 97 / 'A' : 65
			alpha = (char)(alpha-32);
		}else if(alpha >= 'A' && alpha <= 'Z') {
			alpha = (char)(alpha+32);
		}else {
			System.out.println("영문자가 아닙니다.");
			System.exit(0); //프로그램 정상종료
		}
		
		System.out.println(alpha);
		System.exit(0); //프로그램 정상종료
	}

}
