package ����ý��۱���;

import java.util.Scanner;

public class Reserve {

	public static void main(String[] args) {
		
		
		//SeatType �迭 �����
		SeatType[] aSeatType = new SeatType[4];
		aSeatType[0] = new SeatType('R', 5); //�ְ�޼�(�ξ⼮)
		aSeatType[1] = new SeatType('S', 7); //��޼�(Superior)
		aSeatType[2] = new SeatType('A', 10); //A ��޼�
		aSeatType[3] = new SeatType('B', 15); //B ��޼�
		
		int choice = 0;
		
		while(choice!=4) {
			int type;
			System.out.println("===========���θ޴�===========");
			System.out.println("���� �� �ϳ��� �޴��� �����ϼ���!!");
			System.out.println("============================");
			
			System.out.println("1. ����");
			System.out.println("2. ��ȸ");
			System.out.println("3. ���");
			System.out.println("4. ����");
			
			System.out.print("�����ϼ��� : ");
			
			Scanner sc = new Scanner(System.in);
			choice = sc.nextInt();
			
			switch(choice) {
			case 1: //����
				
				System.out.println("<�¼� ����>");
				System.out.println("1.R��(5��)");
				System.out.println("2.S��(7��)");
				System.out.println("3.A��(10��)");
				System.out.println("4.B��(15��)");
				System.out.print("�����ϼ��� : ");
				
				
				type = sc.nextInt();
				
				if(type < 1 || type > 4) {
					System.out.println("������ �߸��� �¼� Ÿ���Դϴ�.");
					break;
				}				
				aSeatType[type-1].seatReserve();
				break;
				
			case 2: //��ȸ
				for(int i=0; i<aSeatType.length; i++) {
					aSeatType[i].show();
				}
				
				System.out.println("��ȸ�� �Ϸ��Ͽ����ϴ�.");
				break;
				
			case 3: //���
				
				System.out.println("<�¼� ����>");
				System.out.println("1.R��(5��)");
				System.out.println("2.S��(7��)");
				System.out.println("3.A��(10��)");
				System.out.println("4.B��(15��)");
				System.out.println("�����ϼ��� : ");
				type = sc.nextInt();
				
				if(type < 1 || type > 4) {
					System.out.println("��ҽ� �߸��� Ÿ���Դϴ�.");
					break;
				}
				
				aSeatType[type-1].cancle();
				break;
				
			case 4 : //����
				break;
				default:
					System.out.println("�޴��� �߸� �Է��߽��ϴ�.");
			}
			
		}		

	}

}
