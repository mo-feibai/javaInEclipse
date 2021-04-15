package javaexer;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.jupiter.api.Test;

public class PersonSortTest {
	@Test
	public void test() {
		Person[] person = new Person[5];
		person[0] = new Person("tom", 12);
		person[1] = new Person("jack", 11);
		person[2] = new Person("lucy", 15);
		person[3] = new Person("judy", 4);
		person[4] = new Person("sandy", 22);

		Arrays.sort(person);
		System.out.println(Arrays.toString(person));
	}

	@Test
	public void test2() {
		Person[] person = new Person[5];
		person[0] = new Person("tom", 12);
		person[1] = new Person("jack", 11);
		person[2] = new Person("lucy", 15);
		person[3] = new Person("judy", 4);
		person[4] = new Person("sandy", 22);

		Arrays.sort(person, new Comparator<Object>() {

			@Override
			public int compare(Object o1, Object o2) {
				if (o1 instanceof Person && o2 instanceof Person) {
					Person person1 = (Person) o1;
					Person person2 = (Person) o2;
					return -Integer.compare(person1.getAge(), person2.getAge());
				}
				throw new RuntimeException("输入数据类型错误");
			}

		});
		System.out.println(Arrays.toString(person));
	}
}
