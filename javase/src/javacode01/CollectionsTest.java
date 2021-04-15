package javacode01;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Test;

public class CollectionsTest {
	@Test
	void test1() throws Exception {
		List<Object> list = new ArrayList<>();
		list.add("judy");
		list.add(123);
		list.add(67.00);
		list.add(new String("abc"));
		list.add(new Person("sandy", 12));
		
		Collections.reverse(list);
		System.out.println(list);
		System.out.println("----------------------------------");
		Collections.shuffle(list);
		System.out.println(list);
		System.out.println("----------------------------------");
//		Collections.shuffle(list, new Random());
		Collections.swap(list, 3, 4);
		System.out.println(list);
		
		
	}
	
	@Test
	void test2() throws Exception {
		List<Object> list = new ArrayList<>();
		list.add("judy");
		list.add(123);
		list.add(67.00);
		list.add(new String("abc"));
		list.add(new Person("sandy", 12));
		List<Object> list2 = Arrays.asList(new Object[list.size()]);
		System.out.println(list2);
		Collections.copy(list2, list);
		System.out.println(list2);
	}
}
