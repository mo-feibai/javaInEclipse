package javacode01;

import java.util.Arrays;

public class Demo {

	public static void main(String[] args) {
		String[] a = {"我们", "你好", "小河边", "我们", "读书","我们", "你好", "小河边", "我们", "读书"};

		for(int i = 0; i < a.length; i++) {
		   if(a[i].equals("我们")) {
		   a[i] = "他们";
		}
		   System.out.println(Arrays.toString(a));
		}

	}
}
