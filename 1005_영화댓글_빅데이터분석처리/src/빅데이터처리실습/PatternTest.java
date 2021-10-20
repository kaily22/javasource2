package 빅데이터처리실습;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//예측분석이라는 단어가 몇번 들어가는지 알아보기

public class PatternTest {

	public static void main(String[] args) {
String str = "빅데이터의 다음 단계는 예측분석이다. 이제 예측분석의 키워드를 이해하는 기업만 살아남는다.";
		
		Pattern p = Pattern.compile("예측분석");
		Matcher m = p.matcher(str);
		
		int count = 0;
		String word = null;
		
		//find() => 패턴이 일치하면 true/ 없으면 false
		while(m.find()) {
			//패턴과 일치된 텍스트를 반환해라 group()는 대상 텍스트 전체에서 패턴과 일치된 텍스트를 반환
			word = m.group();
			count++;
		}
		
		System.out.println("분석결과 : " + "패턴일치");
		System.out.println(word+ " => " + count + "개");
	
	}

}
