package ���ó�������Ѷ��ٽĿ���;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class LambdaEx {

	public static void main(String[] args) {
		
			List<Customer> list = (List)Arrays.asList(new Customer("����ȣ",1500), new Customer("����ö",700));
			
			/*
			 * [�߿�] �÷������κ��� ��Ʈ�� ��� => List �÷����� ���������� ���ؼ�
			 * 
			 */
			Stream<Customer> stream = list.stream();
			stream.forEach(s -> {
				String name = s.getName();
				int score = s.getPoint_score();
				
				System.out.println(name + "=> " + "����Ʈ ����" +score+ "��");
				
			});
			
		}
		
	}

