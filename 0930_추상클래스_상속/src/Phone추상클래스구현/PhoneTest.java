package Phone추상클래스구현;

public class PhoneTest {
	
	public static void main(String[] args) {
		
		System.out.println("<<스마트폰 테스트>>");
		Phone phone1 = new SmartPhone("유저1","아이폰","010-1111-1111");
		System.out.println(phone1.Info());
		phone1.use();
		System.out.println();
		
		System.out.println("<<<텔레폰 테스트>>>");
		Phone phone2 = new TelePhone("유저2","일반 폰","010-1234-1234");
		System.out.println(phone2.Info());
		phone2.use();
		
	}

}
