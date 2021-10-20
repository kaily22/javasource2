package Set계열의클래스예제;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class LottoGenerate {

	public static void main(String[] args) {
		
//		Set set = new HashSet<Integer>();
		Set set = new TreeSet();
		
		for(int i=0; set.size() < 6; i++) {
			Random random = new Random();
			int number = random.nextInt(45)+1; //1~45
			set.add(new Integer(number));
		}
		
//		List list = new ArrayList(set);
//		Collections.sort(list);
		System.out.println("<<로또 번호 보여주기>>");
		System.out.println(set);
	}
}
