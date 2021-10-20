package List계열의클래스들예제;

import java.util.ArrayList;
import java.util.List;


/*
 *  Vector, ArrayList 클래스는 
 *  모두 동적 배열 클래스이다.
 *  고정배열이 가지고 있는 문제점을 해결하기 위해서
 *  만들어진 클래스들이다.
 *  
 *  <차이점>
 *  Vector는 동기화가 보장
 *  ArrayList 동기화 x
 *  
 * */

public class ArrayListClassEx {

	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<Integer>();
		
		/* 객체 추가 /객체화 시킴  */
		list.add(new Integer(90)); //정수 90을 객체화 시킴! list.add(90) => 자동 박싱(자동으로 객체화 시켜버림)
		list.add(new Integer(85));
		list.add(new Integer(100));
		list.add(new Integer(70));
		list.add(new Integer(75));
		
		System.out.println(list);
		
		list.add(2, 60);
		System.out.println(list);
		
		/*객체 변경 */
		list.set(1,70);
		System.out.println(list);
		
		/*객체 삭제 */
		list.remove(3);
		System.out.println(list);
		
	}

}
