package 변수와자료형;


/*
 * 중요 예제
 * 
 * */

public class URLPath {
	public static void main(String[] args) {
		
		String url = "http://localhost:8080/Model2_Board/login.do";
		
		int lastPosition = url.lastIndexOf("/"); //마지막 문자열 찾기 위해서
		
		String filePath = url.substring(lastPosition); //위치까지 찾아내기
		System.out.println(filePath); //34가 출력
	}
}
