package Phone추상클래스구현;

public class TelePhone extends Phone{

	public TelePhone(String userName, String phoneName, String number) {
		super(userName, phoneName, number);
	}

	@Override
	public void function() {
		System.out.println("자동 응답을 한다.");
	}

}
