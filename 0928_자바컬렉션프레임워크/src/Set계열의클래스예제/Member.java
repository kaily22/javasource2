package Set계열의클래스예제;


/*개발자가 어떤 클래스를 구현할 때 컴파일 시 최상위 클래스인 
 * Object 클래스로부터 상속을 받게 된다.
 * */

public class Member extends Object { //컴파일할때 이미  object의 상속을 받는다.
	
	//인스턴스 변수(객체 변수)선언 
	private String name; //이름
	private int age; //나이
	private String juminNum; //주민번호
	
	//생성자
	public Member(String name, int age, String juminNum) {
		this.name=name; //인스턴스, 매개변수 이름 같을 때 인스턴스 앞에다가 this를 붙인다/다르면 x 
		this.age = age;
		this.juminNum = juminNum;
	}

	@Override //재정의
	public int hashCode() { //재정의 //정수타입 3가지 필드값에 대한 해시값을 얻어서 return
		return name.hashCode() + age + juminNum.hashCode();
	}
	
	@Override //재정의(Object클래스꺼) -> 자식이 상속받아서 재정의해서 사용
	public boolean equals(Object obj) { //equals메소드로 넘겨준다.
		//참조변수  instanceof 타입(클래스명)
		if(obj instanceof Member) { 
			Member member = (Member)obj; 
			return member.name.equals(name) && (member.age == age) && member.juminNum.equals(juminNum);
	}else {
		return false;
	}
//	return super.equals(obj);
 }
}

