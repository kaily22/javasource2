package �ݾ׿��޸��ֱ�;

import java.util.Scanner;

public class DecimalFormatEx {

	public static void main(String[] args) {
		String amount;
		
		System.out.print("���� �ݾ��� �Է��ϼ��� >>> ");
		Scanner in = new Scanner(System.in);
		
		long totalamount = in.nextLong();
		
		//�߰�
		amount = Utils.toNumberFormat(totalamount);
		
		System.out.println("���� �ݾ� : " +amount);
		
	}
}
