package Phone�߻�Ŭ��������;

public class TelePhone extends Phone{

	public TelePhone(String userName, String phoneName, String number) {
		super(userName, phoneName, number);
	}

	@Override
	public void function() {
		System.out.println("�ڵ� ������ �Ѵ�.");
	}

}
