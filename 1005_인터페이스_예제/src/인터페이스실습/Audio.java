package 인터페이스실습;

public class Audio implements RemoteControl{
	
	//멤버변수
	private int volumn;

	@Override
	public void turnOn() {
		System.out.println("오디오를 킵니다.");
		
	}

	
	@Override
	public void setVolume(int volumn) {
		if(volumn > RemoteControl.MAX_VOLUMN)
			this.volumn = RemoteControl.MAX_VOLUMN;
		else if(volumn < RemoteControl.MAX_VOLUMN)
			this.volumn = RemoteControl.MIN_VOLUMN;
		System.out.println("현재 TV 볼륨 : "+this.volumn);
		
	}
	@Override
	public void turnOff() {
		System.out.println("오디오를 끕니다.");
	}

}
