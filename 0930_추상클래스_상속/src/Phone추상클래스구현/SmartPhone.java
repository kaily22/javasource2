package Phone추상클래스구현;

public class SmartPhone extends Phone{

	

	public SmartPhone(String userName, String phoneName, String number) {
		super(userName, phoneName, number);
	}

	@Override
	public void function() {
		System.out.println("인터넷을 검색한다.");
	}


}
