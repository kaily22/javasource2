package ��Ƽ�����忹��;

import java.awt.Toolkit;

/*
 * Toolkit ��ü ������
 * 
 * ToolkitŬ������ '�ý��� ����'�� ��� ������ �ý����� �ڿ��� ������ �� �ִ� Ŭ�����̴�.
 * 
 * �̱� ������ ���ø����̼�
 * (���� ������)
 * 
 */

public class BeepPrintEx01 {

	public static void main(String[] args) {
		
		//���� �޼ҵ� : Ŭ���� �̸����� �ٷ� ��� ����
		//Toolkit ��ü ������
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		
		for(int i=0; i<5; i++) {
			toolkit.beep();
			try {
				Thread.sleep(1000); //1�ʰ� �Ͻ� ����
			} catch (Exception e) {}
			
		}
		for(int i=0; i<5; i++) {
			System.out.println("��");
			try {
				Thread.sleep(1000); //1�ʰ� �Ͻ� ����
			} catch (Exception e) {}
		}
			
		}
	}

