package Map계열의클래스들예제;

import java.util.Hashtable;
import java.util.Scanner;

public class HashTableClassEx {

	public static void main(String[] args) {
		String[] userID = {"Lee","Kim","Jang","Wang","Ha"};
		String[] password = {"L123","K456","J234","W896","H547"};
		
		//HashTable 객체 생성
		Hashtable<String, String> ht = new Hashtable<String, String>(userID.length);
		
		//객체 저장
		for(int i=0; i<userID.length; i++) {
			ht.put(userID[i], password[i]);
		}
		
		System.out.println(ht);
		
		//{Jang=J234, Ha=H547, Lee=L123, Wang=W896, Kim=K456}
		//순서 중요x : 키값으로 찾음 / 중괄호 사용 
		
		boolean FLAG = true;
		//변수 대문자로 : 스위치 변수(TRUE.FALSE)
		
		while(FLAG) { //무한루프
		   System.out.print("유저ID는 >>> ");
		   Scanner sc = new Scanner(System.in);
		   String user_key = sc.nextLine();
		   String pw_value = ht.get(user_key);
		   
		   if(pw_value != null) {
			   System.out.print("유저 PASSWORD는 >>> ");
			   String passwordInputValue = sc.nextLine();
			   
			   if(pw_value.equals(passwordInputValue)) {
				   System.out.println("인증 성공!!");
				   break;
			   }else {
				   System.out.println("인증 실패!!");
				   
			   }
		   }else {
			   System.out.println("등록되어 있지 않은  userID 입니다.");
		   }
		}
	}

}
