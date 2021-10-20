package Enum����ǽ�;

import java.util.Scanner;

public class PayGroupTest {
	
	//�������� ����(�����)
	private static final Object EMPTY = null;

	public static void main(String[] args) {
		//������ ���� ���� �� : values()
		for(PayGroup type : PayGroup.values()) {
			
			System.out.print("���� ���� : ");
			System.out.println(type.getTitle());
			
		}
		System.out.println();
		
		for(PayGroup type : PayGroup.values()) {
			System.out.println(type.getPayList());
		}
		
		System.out.println();
		
		System.out.println("���� ������ �Է��ϼ��� >>> ");
		Scanner in = new Scanner(System.in);
	
		String payment_means = in.next();
		
		PayGroup pay = PayGroup.findByPayCode(payment_means);
		
		if(pay.equals(EMPTY)) {
			System.out.println("���� ���� : " +pay.getTitle());
		}else {
			System.out.println("���� ���� : " +pay.getTitle());
		} 
		
		
		
		
		
	}

}
