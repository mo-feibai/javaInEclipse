package javacode01;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.Test;

public class ListTest {

	@Test
	public void test1() {
		ArrayList<Object> arrayList = new ArrayList<>();
		arrayList.add(123);
		arrayList.add("aaa");
		arrayList.add(424);
		arrayList.add(new Person("tom", 12));
		arrayList.add(123);
		arrayList.add(new String("jack"));
		for (Object obj : arrayList) {
			System.out.println(obj);
		}
		System.out.println("==================================");
//		arrayList.add(3, "dd");
		Collection<Object> coll = new ArrayList<>();
//		coll.add(1234);
//		coll.add("asd");
//		arrayList.addAll(2,  coll);
//		System.out.println("获取"+arrayList.get(1));
//		System.out.println(arrayList.indexOf(42411));
//		System.out.println(arrayList.lastIndexOf(123));
//		System.out.println(arrayList.remove(4));
//		arrayList.set(0,"华语");
		List<Object> subList = arrayList.subList(1, 4);
		System.out.println(subList);
		for (Object obj : arrayList) {
			System.out.println(obj);
		}

	}
}
