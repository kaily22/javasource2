package �ڹٻ�ӿ���;

import java.text.DecimalFormat;

public class Utils {
	/*
	 *  �Է� ���� �ݾ׿�  õ ���� ���� �޸� �ֱ� �Լ� ����
	 */
	//���뼺 �پ
	
	public static String toNumberFormat(long totalAmount) {
		
		DecimalFormat df = new DecimalFormat("#,###"); //��ü ����
		return df.format(totalAmount); // �Ѱܹ��� �������� 
		
	}
}
