package Map�迭��Ŭ�����鿹��;

import java.util.Hashtable;
import java.util.Scanner;

public class HashTableClassEx {

	public static void main(String[] args) {
		String[] userID = {"Lee","Kim","Jang","Wang","Ha"};
		String[] password = {"L123","K456","J234","W896","H547"};
		
		//HashTable ��ü ����
		Hashtable<String, String> ht = new Hashtable<String, String>(userID.length);
		
		//��ü ����
		for(int i=0; i<userID.length; i++) {
			ht.put(userID[i], password[i]);
		}
		
		System.out.println(ht);
		
		//{Jang=J234, Ha=H547, Lee=L123, Wang=W896, Kim=K456}
		//���� �߿�x : Ű������ ã�� / �߰�ȣ ��� 
		
		boolean FLAG = true;
		//���� �빮�ڷ� : ����ġ ����(TRUE.FALSE)
		
		while(FLAG) { //���ѷ���
		   System.out.print("����ID�� >>> ");
		   Scanner sc = new Scanner(System.in);
		   String user_key = sc.nextLine();
		   String pw_value = ht.get(user_key);
		   
		   if(pw_value != null) {
			   System.out.print("���� PASSWORD�� >>> ");
			   String passwordInputValue = sc.nextLine();
			   
			   if(pw_value.equals(passwordInputValue)) {
				   System.out.println("���� ����!!");
				   break;
			   }else {
				   System.out.println("���� ����!!");
				   
			   }
		   }else {
			   System.out.println("��ϵǾ� ���� ����  userID �Դϴ�.");
		   }
		}
	}

}
