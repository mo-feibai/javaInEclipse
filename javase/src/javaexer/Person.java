package javaexer;

import javacode01.MyAnnotation;

@MyAnnotation
public class Person implements Comparable<Object> {
	private String name;
	private int age;

	public Person() {
		super();
	}

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	@Override
	public int compareTo(Object o) {
		if (o instanceof Person) {
			Person person = (Person) o;
			return this.name.compareTo(person.name);
		}
		throw new RuntimeException("输入的数据类型错误");
	}

}
