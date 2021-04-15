package javacode01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

import org.junit.jupiter.api.Test;

public class CollectionTest {
	@Test
	public void test1() {
		Collection<Object> coll = new ArrayList<>();
		coll.add(123);
		coll.add(456);
		coll.add(new String("tom"));
		coll.add(false);
		coll.add(new Person("jack", 20));

		boolean contains = coll.contains(123);
		System.out.println(contains);
		System.out.println(coll.contains(new String("tom")));
		System.out.println(coll.contains(new Person("jack", 20)));

		Collection<Object> coll1 = Arrays.asList(123, 456);
		boolean all = coll.containsAll(coll1);
		System.out.println(all);
		int size = coll.size();
		System.out.println(size);
		coll.clear();
		System.out.println(coll.size());
		System.out.println(coll.isEmpty());
	}

	@Test
	public void test2() {
		Collection<Object> coll = new ArrayList<>();
		coll.add(123);
		coll.add(456);
		coll.add(new String("tom"));
		coll.add(false);
		coll.add(new Person("jack", 20));
		boolean remove = coll.remove(123);
		System.out.println(remove);
		System.out.println(coll.size());
//		coll.remove(new Person("jack", 20));
		System.out.println(coll.size());
		Collection<Object> coll1 = Arrays.asList(456,false);
//		coll.removeAll(coll1);
		System.out.println(coll);
//		boolean retainAll = coll.retainAll(coll1);
//		System.out.println(retainAll);
//		System.out.println(coll);

	}
	@Test
	public void test3() {
		
	}
}
