package �ֹι�ȣ�κ�����������;

import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

public class JuminCheckEx {
	public static void main(String[] args) {
		// �غ�ܰ� : �ʿ� ����, �迭�� �ʱ�ȭ

		String juminNum;
		int sum = 0; // ���� ������ 0���� �ʱ�ȭ
		int[] weight = { 2, 3, 4, 5, 6, 7, 0, 8, 9, 2, 3, 4, 5 }; // ����ġ �迭("-"�� 0����) �ʱ�ȭ
		int temp, result;

		// �Է� �ܰ�
		System.out.print("�ֹι�ȣ �Է� >>>>>> ");
		Scanner scan = new Scanner(System.in);
		juminNum = scan.next(); // ���ڿ��� �Է¹��� => '-' �����Ͽ� �Է�

		/*
		 * �Է� ���� �ֹι�ȣ�� ��ȿ�� �˻� => ���� ǥ����(regex) ���� ����
		 * 
		 */

		// �ֹι�ȣ ����ǥ����
		String regex = "^[0-9]{6}-[1234][0-9]{6}$";

		// �ֹι�ȣ�� regex�� matches�� ��ȯ Ÿ�� boolean

//		1. boolean check = Pattern.matches(regex, juminNum);

		// 2��° : String Ŭ�������� matches �޼ҵ�
		boolean check = juminNum.matches(regex);

		if (check == false) {
			System.out.println("�Էµ� �ֹι�ȣ�� ���� ǥ���� ��Ŀ� ���� �ʽ��ϴ�.");
			return;
		}
		System.out.println("�Էµ� �ֹι�ȣ�� ���� ǥ���� ��Ŀ�  ������!");

		// ��ȿ�� �˻� 1�ܰ� => sum ���ϱ�

		for (int i = 0; i < 13; i++) {
			// �ѹ��ڸ� ��������
			if (juminNum.charAt(i) == '-')
				continue;
			sum += (juminNum.charAt(i) - 48) * weight[i];
		}
//	   System.out.println(sum);

		// 2�ܰ� -> temp ���� �� �ڸ��� ��찡 �ִ�.
		temp = 11 - (sum % 11);

		// 3�ܰ� ���� => temp ���� ���ڸ��� �ֹι�ȣ�� ����ؼ�...
		result = temp % 10;

		// �ֹι�ȣ ���� ���� üũ
		if (result == juminNum.charAt(13) - 48) {
			System.out.println("�Էµ� �ֹι�ȣ�� �����Դϴ�.");

			// "����" ����
//		   1. ���� �ý������κ��� �⵵ ���� => 2021 
//		   2. �ֹι�ȣ �� �ڸ��� ������Ͽ��� �⵵ ���ڸ��� ������(substring) => '97' -> ���������� ��ȯ
//		   3. �ֹι�ȣ �� �ڸ��� ù��° �ڸ�(1,2,3,4) => 1,2�� 19xx�� �����ֱ� 97+1900 3,4, 20xx�� ���ϱ�
//		   4.  2021-1997 = ���� ����

			// [��Ʈ] Calendar Ŭ���� ����
			Calendar cal = Calendar.getInstance(Locale.KOREA);
			int year = cal.get(Calendar.YEAR); // 2021 ����

			int yy = Integer.parseInt(juminNum.substring(0, 2));

			if (juminNum.charAt(7) - 48 < 3) { // 1,2�� ���
				yy = yy + 1900; // 97+1900 = 1997
			} else {
				yy = yy + 2000;
			}
			int age = year - yy + 1; // �� ����
			System.out.println(age);

			// ���� ����
			if ((juminNum.charAt(7) - 48) % 2 == 0) {
				System.out.println("���� : ����");
			} else {
				System.out.println("���� : ����");
			}

			// ��������
//		 int location = Integer.parseInt(juminNum.substring(8)) 

			String[][] localCode = { {"����", "00", "08" }, { "�λ�", "09", "12" }, 
					               { "��õ", "13", "15" }, { "���", "16", "25" }, 
					               { "����", "26", "34" }, { "���", "35", "39" }, 
					               { "����", "40", "40" }, { "�泲", "41", "43"}, 
					               { "�泲", "45", "47" }, {"����", "44", "44" }, 
					               { "����", "96", "96" }, { "����", "48", "54" }, 
					               { "����", "55", "64" }, { "����", "65", "66" }, 
					               { "�뱸", "67", "70" }, { "���", "71", "80" }, 
					               {"�泲", "81", "84"  },  { "�泲", "86", "90" }, 
					               { "���", "85", "85" }, { "����", "91", "95" }};

			String localeString = juminNum.substring(8,10);
			int locale = Integer.parseInt(localeString);

			String birthPlace = null;

			for (int j = 0; j < localCode.length; j++) {
				if (locale >= Integer.parseInt(localCode[j][1]) && locale <= Integer.parseInt(localCode[j][2])) {
					birthPlace = localCode[j][0];
				}
			}
			
			System.out.println("������� : " + birthPlace);
			
			
			//�������
			System.out.println("�������  : " +yy + "/" +juminNum.substring(2,4)+"/"+juminNum.substring(4,6));
			
			
			//��(����⵵ % 12 == 0 : ������)
			String ddi = null;
			String[] gangi = {"������","��","��","����","��","��","��","�䳢","��","��","��","��"};
			ddi = gangi[yy%12];
			System.out.println(ddi);
			
		} else {
			System.out.println("�Էµ� �ֹι�ȣ�� Ʋ�� ��ȣ�Դϴ�.");
		}
	}
}