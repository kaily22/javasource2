package �ǽ�����Ǯ��;

import java.util.Scanner;

public class ChangeMoney {

	public static void main(String[] args) {
		
		int[] arrayMoney = {50000,10000,5000,1000,500,100,50,10,1};
		String[] str = {"��������","������","��õ����","õ����","�����","���","���ʿ�","�ʿ�","�Ͽ�"};
		//ȭ����� �迭 ���� -> �迭 ���� : �ڵ����� 0 �ʱ�ȭ
		int[] result = new int[9];
		
		System.out.print("�ݾ��� �Է��ϼ��� : ");
		
		Scanner in = new Scanner(System.in);
		int Money = in.nextInt(); //�Է¹��� ���ڿ��� ������ ��ȯ�ؼ� �Է¹ޱ�
		
		
		//ó���� ����� �ѹ��� ó������
		for(int i=0; i<arrayMoney.length;i++) {
			
			int num = Money/arrayMoney[i]; //���� ����
			int remainder = Money%arrayMoney[i]; // ������ ��
			
			//�������� �ٽ� Money�� �Ҵ��ؼ� �ݺ��ϰ�
			Money = remainder;
			
			//�����̸�
			if(num>0 && i < 4) {
				System.out.println(str[i] + "" + num + "��");
				
			}else if(num > 0 && i >=4) {
				System.out.println(str[i] + "" + num + "��");
			}
		}
	}
}
