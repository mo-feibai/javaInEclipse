package javaexer;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

import org.junit.jupiter.api.Test;

public class TreeSetExer {
	@Test
	public void test1() {
		TreeSet<Employee> treeSet = new TreeSet<>(new Comparator<Employee>() {

			@Override
			public int compare(Employee employee1, Employee employee2) {

				MyDate empBirthday1 = employee1.getBirthday();
				MyDate empBirthday2 = employee2.getBirthday();
				LocalDate date1 = LocalDate.of(empBirthday1.getYear(), empBirthday1.getMonth(), empBirthday1.getDay());
				LocalDate date2 = LocalDate.of(empBirthday2.getYear(), empBirthday2.getMonth(), empBirthday2.getDay());
				return -date1.compareTo(date2);

			}
		});
		treeSet.add(new Employee("jack", 12, new MyDate(2009, 12, 15)));
		treeSet.add(new Employee("tom", 10, new MyDate(2011, 5, 23)));
		treeSet.add(new Employee("lucy", 18, new MyDate(2004, 8, 19)));
		treeSet.add(new Employee("candy", 9, new MyDate(2012, 4, 3)));
		treeSet.add(new Employee("white", 9, new MyDate(2012, 4, 5)));
		treeSet.add(new Employee("bob", 20, new MyDate(2001, 10, 1)));
		treeSet.add(new Employee("judy", 20, new MyDate(2001, 1, 15)));
		Iterator<Employee> iterator = treeSet.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());

		}
	}
}
