package ������ó���ǽ�;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//�����м��̶�� �ܾ ��� ������ �˾ƺ���

public class PatternTest {

	public static void main(String[] args) {
String str = "�������� ���� �ܰ�� �����м��̴�. ���� �����м��� Ű���带 �����ϴ� ����� ��Ƴ��´�.";
		
		Pattern p = Pattern.compile("�����м�");
		Matcher m = p.matcher(str);
		
		int count = 0;
		String word = null;
		
		//find() => ������ ��ġ�ϸ� true/ ������ false
		while(m.find()) {
			//���ϰ� ��ġ�� �ؽ�Ʈ�� ��ȯ�ض� group()�� ��� �ؽ�Ʈ ��ü���� ���ϰ� ��ġ�� �ؽ�Ʈ�� ��ȯ
			word = m.group();
			count++;
		}
		
		System.out.println("�м���� : " + "������ġ");
		System.out.println(word+ " => " + count + "��");
	
	}

}
