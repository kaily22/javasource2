package 스트링응용예제;

public class Member {
	
	
	public static int MALE = 0;
	public static int FEMALE = 1;
	
	
	private String name;
	private int gender;
	private int age;
	
	//생성자
	public Member(String name, int gender, int age) {
		
		this.name = name;
		this.gender = gender;
		this.age = age;
	}

	//getter 메소드만 구현 
	
	public String getName() {
		return name;
	}

	public int getGender() {
		return gender;
	}

	public int getAge() {
		return age;
	}
}
