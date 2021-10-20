package List계열의클래스들예제;

import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class VectorClassEx {
	public static void main(String[] args) {
		
		String[] name = {"김진명","최인호 ","조정례","김홍선","박경리"};
		
		//Vector 객체 생성. 생성자 오버로딩
//		List<String> list = new Vector<String>(); //기본이 10개의 가변 배열을 생성
		
		//처음 4개의 공간 만들고 부족하면 3개씩 증가(백터에 생성만 해둔 상태)
		//List<E>(제네릭) list = new Vector<E>(); //일반적인 경우
		List<String> list = new Vector<String>(4, 3);
		
		//Vector 클래스의 메소드 활용
		System.out.println("벡터에 저장된 요소의 개수: " +list.size());
		System.out.println("벡터의 용량은 : " +((Vector<String>)list).capacity()); //4가 출력
		
		/* 객체 추가*/
		for(int i=0; i<name.length;i++) {
			list.add(name[i]); //객체 추가 -> 마지막에 추가
		}
		
		System.out.println("벡터에 저장된 요소의 개수: " +list.size()); //5가 출력
		System.out.println("벡터의 용량은 : " +((Vector<String>)list).capacity()); //7이 출력
		
		
		System.out.println(list);
		//[김진명,최인호,조정례,김홍선,박경리]
		
		list.add(2, "공지영"); //원하는 인덱스에 추가
		System.out.println(list);

		/* 객체 검색 / get() 메소드 / contains() 메소드 */
		
		System.out.println(list.get(1));
		//최인호
		
		// contains() -> true/false반환
		
		boolean contains_result = list.contains("김홍선");
		System.out.println(contains_result); //true
		
		boolean contains_result2 = list.contains("홍길동");
		System.out.println(contains_result2); //true
		
		System.out.println(list.size());
		
		/* 객체 변경  set() 메소드  */
		//공지영이라는 객체를 이문일로 변경하고자 한다.
		list.set(2, "이문열");
		System.out.println(list);
				
		/* 객체 삭제*/
		list.remove(3);
		System.out.println(list);
		
		list.remove("김홍선");
		System.out.println(list);

		System.out.println(); 

		/* 객체 정렬 => 오름 차순  */
		Collections.sort(list);
		System.out.println("[객체 오름차순 정렬] : " +list);

		System.out.println();
		
		/* 내림차순 */
		Collections.sort(list, Collections.reverseOrder());
		System.out.println("[객체 오름차순 정렬] : " +list);
	}

}
