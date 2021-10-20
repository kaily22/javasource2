package 자바상속예제;

import java.text.DecimalFormat;

public class Utils {
	/*
	 *  입력 받은 금액에  천 단위 마다 콤마 넣기 함수 구현
	 */
	//재사용성 뛰어남
	
	public static String toNumberFormat(long totalAmount) {
		
		DecimalFormat df = new DecimalFormat("#,###"); //객체 생성
		return df.format(totalAmount); // 넘겨받은 패턴으로 
		
	}
}
