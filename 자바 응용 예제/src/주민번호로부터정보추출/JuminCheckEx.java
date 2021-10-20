package 주민번호로부터정보추출;

import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

public class JuminCheckEx {
	public static void main(String[] args) {
		// 준비단계 : 필요 변수, 배열의 초기화

		String juminNum;
		int sum = 0; // 누계 변수는 0으로 초기화
		int[] weight = { 2, 3, 4, 5, 6, 7, 0, 8, 9, 2, 3, 4, 5 }; // 가중치 배열("-"은 0으로) 초기화
		int temp, result;

		// 입력 단계
		System.out.print("주민번호 입력 >>>>>> ");
		Scanner scan = new Scanner(System.in);
		juminNum = scan.next(); // 문자열로 입력받음 => '-' 포함하여 입력

		/*
		 * 입력 받은 주민번호를 유효성 검사 => 정규 표현식(regex) 패턴 적용
		 * 
		 */

		// 주민번호 정규표현식
		String regex = "^[0-9]{6}-[1234][0-9]{6}$";

		// 주민번호를 regex로 matches로 반환 타입 boolean

//		1. boolean check = Pattern.matches(regex, juminNum);

		// 2번째 : String 클래스에서 matches 메소드
		boolean check = juminNum.matches(regex);

		if (check == false) {
			System.out.println("입력된 주민번호는 정규 표현식 행식에 맞지 않습니다.");
			return;
		}
		System.out.println("입력된 주민번호는 정규 표현식 행식에  적합함!");

		// 유효성 검사 1단계 => sum 구하기

		for (int i = 0; i < 13; i++) {
			// 한문자만 가져오기
			if (juminNum.charAt(i) == '-')
				continue;
			sum += (juminNum.charAt(i) - 48) * weight[i];
		}
//	   System.out.println(sum);

		// 2단계 -> temp 값이 두 자리인 경우가 있다.
		temp = 11 - (sum % 11);

		// 3단계 공식 => temp 값이 두자리인 주민번호를 대비해서...
		result = temp % 10;

		// 주민번호 정상 유무 체크
		if (result == juminNum.charAt(13) - 48) {
			System.out.println("입력된 주민번호가 정상입니다.");

			// "나이" 추출
//		   1. 현재 시스템으로부터 년도 얻어내기 => 2021 
//		   2. 주민번호 앞 자리의 생년월일에서 년도 두자리만 얻어오기(substring) => '97' -> 정수값으로 변환
//		   3. 주민번호 뒤 자리의 첫번째 자리(1,2,3,4) => 1,2면 19xx대 더해주기 97+1900 3,4, 20xx대 더하기
//		   4.  2021-1997 = 나이 추출

			// [힌트] Calendar 클래스 적용
			Calendar cal = Calendar.getInstance(Locale.KOREA);
			int year = cal.get(Calendar.YEAR); // 2021 얻어옴

			int yy = Integer.parseInt(juminNum.substring(0, 2));

			if (juminNum.charAt(7) - 48 < 3) { // 1,2인 경우
				yy = yy + 1900; // 97+1900 = 1997
			} else {
				yy = yy + 2000;
			}
			int age = year - yy + 1; // 본 나이
			System.out.println(age);

			// 성별 추출
			if ((juminNum.charAt(7) - 48) % 2 == 0) {
				System.out.println("성별 : 여자");
			} else {
				System.out.println("성별 : 남자");
			}

			// 지역추출
//		 int location = Integer.parseInt(juminNum.substring(8)) 

			String[][] localCode = { {"서울", "00", "08" }, { "부산", "09", "12" }, 
					               { "인천", "13", "15" }, { "경기", "16", "25" }, 
					               { "강원", "26", "34" }, { "충북", "35", "39" }, 
					               { "대전", "40", "40" }, { "충남", "41", "43"}, 
					               { "충남", "45", "47" }, {"세종", "44", "44" }, 
					               { "세종", "96", "96" }, { "전북", "48", "54" }, 
					               { "전남", "55", "64" }, { "광주", "65", "66" }, 
					               { "대구", "67", "70" }, { "경북", "71", "80" }, 
					               {"경남", "81", "84"  },  { "경남", "86", "90" }, 
					               { "울산", "85", "85" }, { "제주", "91", "95" }};

			String localeString = juminNum.substring(8,10);
			int locale = Integer.parseInt(localeString);

			String birthPlace = null;

			for (int j = 0; j < localCode.length; j++) {
				if (locale >= Integer.parseInt(localCode[j][1]) && locale <= Integer.parseInt(localCode[j][2])) {
					birthPlace = localCode[j][0];
				}
			}
			
			System.out.println("출신지역 : " + birthPlace);
			
			
			//생년월일
			System.out.println("생년월일  : " +yy + "/" +juminNum.substring(2,4)+"/"+juminNum.substring(4,6));
			
			
			//띠(출생년도 % 12 == 0 : 원숭이)
			String ddi = null;
			String[] gangi = {"원숭이","닭","개","돼지","쥐","소","범","토끼","용","뱀","말","양"};
			ddi = gangi[yy%12];
			System.out.println(ddi);
			
		} else {
			System.out.println("입력된 주민번호가 틀린 번호입니다.");
		}
	}
}