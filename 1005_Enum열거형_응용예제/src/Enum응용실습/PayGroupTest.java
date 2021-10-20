package Enum응용실습;

import java.util.Scanner;

public class PayGroupTest {
	
	//전역변수 선언(상수로)
	private static final Object EMPTY = null;

	public static void main(String[] args) {
		//열겨헝 값을 얻어올 때 : values()
		for(PayGroup type : PayGroup.values()) {
			
			System.out.print("결제 종류 : ");
			System.out.println(type.getTitle());
			
		}
		System.out.println();
		
		for(PayGroup type : PayGroup.values()) {
			System.out.println(type.getPayList());
		}
		
		System.out.println();
		
		System.out.println("결제 수단을 입력하세요 >>> ");
		Scanner in = new Scanner(System.in);
	
		String payment_means = in.next();
		
		PayGroup pay = PayGroup.findByPayCode(payment_means);
		
		if(pay.equals(EMPTY)) {
			System.out.println("결제 종류 : " +pay.getTitle());
		}else {
			System.out.println("결제 종류 : " +pay.getTitle());
		} 
		
		
		
		
		
	}

}
