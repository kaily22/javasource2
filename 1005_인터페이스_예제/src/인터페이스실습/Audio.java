package �������̽��ǽ�;

public class Audio implements RemoteControl{
	
	//�������
	private int volumn;

	@Override
	public void turnOn() {
		System.out.println("������� ŵ�ϴ�.");
		
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
		System.out.println("������� ���ϴ�.");
	}

}
