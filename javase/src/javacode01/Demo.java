package javacode01;

import java.util.Arrays;

public class Demo {

	public static void main(String[] args) {
		String[] a = {"����", "���", "С�ӱ�", "����", "����","����", "���", "С�ӱ�", "����", "����"};

		for(int i = 0; i < a.length; i++) {
		   if(a[i].equals("����")) {
		   a[i] = "����";
		}
		   System.out.println(Arrays.toString(a));
		}

	}
}
