package Enum응용실습;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * 
 * Arrays 클래스의 주요 메소드
 * public static <T> List<T> asList(T... a)
 *  => 기능 : 전달 받은 배열을 고정 크기의 List로 변환하여 반환해주는 메소드
 *  가독성 향상
 * 
 */

public enum PayGroup {
	
	 CASH("현금", Arrays.asList("계좌이체","무통장입금","현장결제","토스")),
	 CARD("카드", Arrays.asList("페이코","신용카드","카카오페이","배민페이")),
	 ETC("기타", Arrays.asList("포인트","쿠폰")),
	 EMPTY("결제종류없음", Collections.EMPTY_LIST);
	
	 private String title;
	 private List<String> payList;
	 
	 //생성자
	 PayGroup(String title, List<String> payList){
		 this.title = title;
		 this.payList = payList;
	 }
	 
	 public static PayGroup findByPayCode(String code) {
		 //자바 람다식, 스트림 파이프 라인 연결
		 return Arrays.stream(PayGroup.values())
				      .filter(payGroup -> payGroup.hasPayCode(code))
				      .findAny()
				      .orElse(EMPTY);
		 
	 }	
	 
	 //사용자 정의 메소드 구현
	 public boolean hasPayCode(String code) {
		 return payList.stream().anyMatch(pay -> pay.equals(code));
	 }

	public String getTitle() {
		return title;
	}

	public List<String> getPayList() {
		return payList;
	}	 

}
