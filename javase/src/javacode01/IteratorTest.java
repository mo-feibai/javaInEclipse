package javacode01;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.junit.jupiter.api.Test;

/*
 * 集合元素的遍历操作，使用Iterator接口
 */
public class IteratorTest {
	@Test
	public void test1() {
		Collection<Object> coll = new ArrayList<>();
		coll.add(123);
		coll.add(456);
		coll.add(new String("tom"));
		coll.add(false);
		coll.add(new Person("jack", 20));

		Iterator<Object> iterator = coll.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());

		}

	}

	@Test
	public void test2() {
		Collection<Object> coll = new ArrayList<>();
		coll.add(123);
		coll.add(456);
		coll.add(new String("tom"));
		coll.add(false);
		coll.add(new Person("jack", 20));

		Iterator<Object> iterator = coll.iterator();
		while (iterator.hasNext()) {
			Object next = iterator.next();
			if ("tom".equals(next)) {
				iterator.remove();
			}

		}
		System.out.println(coll.toString());
	}
	@Test
	public void test3() {
		Collection<Object> coll = new ArrayList<>();
		coll.add(123);
		coll.add(456);
		coll.add(new String("tom"));
		coll.add(false);
		coll.add(new Person("jack", 20));
		
		
		for(Object obj:coll) {
			System.out.println(obj);
		}
	}

}
