package �ǽ�����1;

import java.util.Scanner;

public class ex3 {

	public static void main(String[] args) {
		
		System.out.print("������ �Է��Ͻÿ� >>");
		Scanner sc = new Scanner(System.in);
		
		int year = sc.nextInt();
		
		if(year % 4 ==0 || year% 400 == 0) {
			System.out.println("�����Դϴ�.");
		}else {
			System.out.println("����Դϴ�.");
		}
		
		
		
		

	}

}
