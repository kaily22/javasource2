package �������̽��ǽ�;

public class Television implements RemoteControl{
	
	//implements : �߻�޼ҵ� ������ �ؼ� ����ض�
	//������� ����
	private int volumn;
	
	
	@Override
	public void turnOn() {
		System.out.println("TV�� �մϴ�.");
	}
	
	@Override
	public void setVolume(int volumn) {
		if(volumn > RemoteControl.MAX_VOLUMN)
			this.volumn = RemoteControl.MAX_VOLUMN;
		else if(volumn < RemoteControl.MAX_VOLUMN)
			this.volumn = RemoteControl.MIN_VOLUMN;
		System.out.println("���� TV ���� : "+this.volumn);
	}

	
	@Override
	public void turnOff() {
		System.out.println("TV�� ���ϴ�.");
		
	}


}
