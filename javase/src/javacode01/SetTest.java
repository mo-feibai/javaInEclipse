package javacode01;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import org.junit.jupiter.api.Test;

public class SetTest {

	@Test
	public void test1() {
		Set<Object> set = new HashSet<Object>();
		set.add(123);
		set.add("set");
		set.add(new String("new set"));
		set.add(5.0);
		set.add(new Person("tom", 23));
		set.add(new User("bob", 23));
		set.add(new User("bob", 23));
		Iterator<Object> iterator = set.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

	}

	@Test
	public void test2() {
		Set<Object> set = new LinkedHashSet<Object>();
		set.add(123);
		set.add("set");
		set.add(new String("new set"));
		set.add(5.0);
		set.add(new Person("tom", 23));
		set.add(new User("bob", 23));
		set.add(new User("bob", 23));
		Iterator<Object> iterator = set.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

	@Test
	public void test3() {
		Set<Object> set = new TreeSet<Object>();
//		set.add(123);
//		set.add(111);
//		set.add(145);
//		set.add(113);
//		set.add(31);
//		set.add(13);
//		set.add(991);
		set.add(new User("tom", 12));
		set.add(new User("tom", 11));
		set.add(new User("jack", 142));
		set.add(new User("lucy", 52));
		set.add(new User("bob", 15));
		set.add(new User("bob", 12));
		Iterator<Object> iterator = set.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

	@Test
	public void test4() {
		Set<Object> set = new TreeSet<Object>(new Comparator<Object>() {
			// 先按年龄从小到大排序，如果相同再按姓名从小到大排序
			@Override
			public int compare(Object o1, Object o2) {
				if (o1 instanceof User && o2 instanceof User) {
					User user1 = (User) o1;
					User user2 = (User) o2;
					int ageCompare = Integer.compare(user1.age, user2.age);
					if (ageCompare == 0) {
						return user1.compareTo(user2);
					}
					return ageCompare;
				}
				throw new RuntimeException("传入数据类型错误！");
			}
		});
		set.add(new User("tom", 12));
		set.add(new User("tom", 11));
		set.add(new User("jack", 142));
		set.add(new User("lucy", 52));
		set.add(new User("bob", 15));
		set.add(new User("bob", 12));
		Iterator<Object> iterator = set.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
