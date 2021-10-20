package 인터페이스실습;

public class Television implements RemoteControl{
	
	//implements : 추상메소드 재정의 해서 사용해라
	//멤버변수 선언
	private int volumn;
	
	
	@Override
	public void turnOn() {
		System.out.println("TV를 켭니다.");
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
		System.out.println("TV를 끕니다.");
		
	}


}
