package Phone�߻�Ŭ��������;

public class PhoneTest {
	
	public static void main(String[] args) {
		
		System.out.println("<<����Ʈ�� �׽�Ʈ>>");
		Phone phone1 = new SmartPhone("����1","������","010-1111-1111");
		System.out.println(phone1.Info());
		phone1.use();
		System.out.println();
		
		System.out.println("<<<�ڷ��� �׽�Ʈ>>>");
		Phone phone2 = new TelePhone("����2","�Ϲ� ��","010-1234-1234");
		System.out.println(phone2.Info());
		phone2.use();
		
	}

}
