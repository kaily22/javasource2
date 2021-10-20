package this½Ç½À;

public class SupersonicAirplaneEx {

	public static void main(String[] args) {
		
		
		SupersonicAirplane sa = new SupersonicAirplane();
		
		sa.takOff();
		sa.fly();
		sa.flyMode = SupersonicAirplane.SUPERSONICAirplane;
		sa.fly();
		
		sa.flyMode = SupersonicAirplane.NORMAL;
		sa.fly();
		sa.land();
		
	}

}
