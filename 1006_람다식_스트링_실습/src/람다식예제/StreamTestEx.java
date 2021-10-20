package ���ٽĿ���;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class StreamTestEx {

	public static void main(String[] args) {
		
		/*
		 * 
		 * �ڹ� 7 ���������� List<Integer> �÷��ǿ��� ��Ҹ� ����������
		 * ó���ϱ� ���� Iterator �ܺ� �ݺ��ڸ� ����ؿԴ�.
		 * 
		 */
//		
//		List<Integer> list = (List)Arrays.asList(10,20,30,40,50);
//		Iterator<Integer> iterator = list.iterator();
//		
//		while(iterator.hasNext()) {
//			
//			//��ȯŸ��
//			Integer value = iterator.next();
//			System.out.print(value+" ");
//		}
		
		/*
		 * 
		 * �ڹ� 8�� ���ٽİ� ��Ʈ��(���� �ݺ���)�� �����Ͽ� �ڵ�
		 * [���] Stream ���� �ݺ��ڴ� �÷��� ���ο��� ��ҵ��� �ݺ���Ű��,
		 * �����ڴ� ��Ҵ� ó���ؾ� �� �ڵ常 �����ϴ� �ڵ� ������ ���Ѵ�.
		 * 
		 */
		
		List<Integer> list = (List)Arrays.asList(10,20,30,40,50);
		Stream<Integer> stream = list.stream();
		
		stream.forEach(value -> System.out.print(value+ " "));
		
	}

}
