package �ǽ�����Ǯ��;

import java.io.IOException;
import java.util.Scanner;

public class CaseChanger {

	public static void main(String[] args) throws IOException {
		
		char alpha;
		
		System.out.print("���ڸ� �Է��ϼ��� >>>> ");
//		Scanner in = new Scanner(System.in);
//		alpha = in.next().charAt(0);
		
		//read() : IOException ó���� ���ֱ�
		alpha = (char) System.in.read();
		
		if(alpha >= 'a' && alpha <= 'z' ) {
			//ASCII �ڵ尪 : 'a' : 97 / 'A' : 65
			alpha = (char)(alpha-32);
		}else if(alpha >= 'A' && alpha <= 'Z') {
			alpha = (char)(alpha+32);
		}else {
			System.out.println("�����ڰ� �ƴմϴ�.");
			System.exit(0); //���α׷� ��������
		}
		
		System.out.println(alpha);
		System.exit(0); //���α׷� ��������
	}

}
