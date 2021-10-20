package ����ý��۱���;

import java.util.Scanner;

public class SeatType {
	
	
	private char type;
	
	//�¼��� ������ ���� ����� �ٸ� => �迭�� �����
	private Seat[] aSeat;  //�������� => ��������� �����ϰڴ�.
	
	//������ �����
	public SeatType(char type, int number) { //���ڰ�(��������� ���;���) :�¼�����, �¼��� ����
		
		this.type = type;
		
		//�迭 ��ü ����(�Ѱܹ��� ������ŭ �����)
		
		aSeat = new Seat[number];	
		for(int i=0; i<aSeat.length; i++) {
			aSeat[i] = new Seat();
		}
	}
	
	//����� ���� �޼ҵ� ����(�¼� ���� ����)
	public boolean seatReserve() {
		
		Scanner sc = new Scanner(System.in);
		int seatNum;
		String name;
		show();
		
		System.out.print("�̸�  : ");
		name = sc.next();
		
		System.out.print("��ȣ : ");
		seatNum = sc.nextInt();
		
		if(seatNum < 1 || seatNum > aSeat.length) {
			System.out.println("�߸��� �¼���ȣ�Դϴ�.");
			return false;
		}
		
		if(aSeat[seatNum-1].isOccupied()){
			System.out.println("�̹� ����� �¼��Դϴ�.");
			return false;
		}
		
		aSeat[seatNum-1].reserveName(name);
		return true;
	}	
	
	public void show() {
		System.out.print(type+"�� ���� ");
		
		for(int i=0; i<aSeat.length; i++) {
			
			//�¼��� ���� �Ǿ��ִ��� �ƴ��� 
			if(aSeat[i].isOccupied()) {
				System.out.print(aSeat[i].getName());
			}else 
				System.out.print("---");
				System.out.print(" ");
			}
		System.out.println();
		}
	
	public boolean cancle() {

		Scanner sc = new Scanner(System.in);
		show();
		System.out.print("�̸� : "); //����� ������ �̸� �Է�
		String name = sc.next();
		
		if(name != null) {
			
			for(int i=0; i<aSeat.length; i++) {
				if(aSeat[i].match(name)) {
					aSeat[i].cancel(); //�̸��� null�� �ٲ��� -> cancel �޼ҵ� ��������
					return true;
				}
			}
		System.out.println("����� ������ �̸��� ã�� �� �����ϴ�.");
		}
		
		return false;
	}

}
