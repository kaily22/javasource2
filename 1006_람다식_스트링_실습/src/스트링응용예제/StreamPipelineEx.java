package 스트링응용예제;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class StreamPipelineEx {

	public static void main(String[] args) {
		
		List<Member> list = (List)Arrays.asList(new Member("박태호",Member.MALE,30),
				                                new Member("김연경",Member.FEMALE,29),
				                                new Member("손유일",Member.MALE,32),
				                                new Member("안재흥",Member.MALE,27));
		
		
		//[1방법] 외부 반복자를 적용하여 해결
		//꼭 iterator가 아니더라도 index를 이용하는 for문 그리고 Iterator를 이용하는 while문
		
//		int count = 0;
//		double sum = 0;
//		
//		//값 가져올 땐 get(i)
//		for(int i=0; i<list.size(); i++) {
//			if(list.get(i).getGender() == Member.MALE) {
//				sum += list.get(i).getAge();
//				count++;
//			}
//		}
//		
//		double ageAvg =  sum/count;
//		System.out.println("남자 회원의 평균 나이 : " +ageAvg); //30,32,27
//
//		
		
		//[2방법] 내부 반복자를 적용하여 해결
		//컬랙션으로부터 스트림 얻어옴
		double ageAvg = list.stream() // 오리지널 스트림
				            .filter(m -> m.getGender() == Member.MALE) //중간처리스트림
				            .mapToInt(Member::getAge) //중간 처리 스트림(Member 객체를 age값으로 매핑)
				            .average().getAsDouble(); //최종 처리 스트림
		
		System.out.println("남자 회원의 평균 나이 : " +Math.ceil(ageAvg));
	}

}
