package 금액에콤마넣기;

import java.util.Scanner;

public class DecimalFormatEx {

	public static void main(String[] args) {
		String amount;
		
		System.out.print("결제 금액을 입력하세요 >>> ");
		Scanner in = new Scanner(System.in);
		
		long totalamount = in.nextLong();
		
		//추가
		amount = Utils.toNumberFormat(totalamount);
		
		System.out.println("결제 금액 : " +amount);
		
	}
}
