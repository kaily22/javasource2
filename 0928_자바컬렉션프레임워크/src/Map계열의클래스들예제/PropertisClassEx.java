package Map�迭��Ŭ�����鿹��;

import java.util.Enumeration;
import java.util.Properties;

/*
 * Properties Ŭ������ �ַ� ������ MVC ����� �Խ��� ���� �� ���
 * ������ ȯ�� ���� ����(applicationContext.xml) ���� �� �ַ� ���
 * 
 */

public class PropertisClassEx {

	public static void main(String[] args) {
		//��ü ����
		Properties prop = new Properties();
		
		//��ü�� key�� value�� ����
		prop.setProperty("name", "����ȣ");
		prop.setProperty("email", "park345@naver.com");
		prop.setProperty("HP", "010-1234-1234");
		
		//��ü �������� Enumeration : ������
		Enumeration enu = prop.propertyNames();
		
		while(enu.hasMoreElements()) {
			String ele = (String) enu.nextElement();
			System.out.println(ele + " : " +prop.getProperty(ele));
		} 
	}
}
