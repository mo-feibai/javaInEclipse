package javaexer;

public class Employee implements Comparable<Employee> {
	private String name;
	private int age;
	private MyDate birthday;

	public Employee() {

	}

	public Employee(String name, int age, MyDate birthday) {
		super();
		this.name = name;
		this.age = age;
		this.birthday = birthday;
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

	public MyDate getBirthday() {
		return birthday;
	}

	public void setBirthday(MyDate birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "姓名：" + name + "\n 年龄：" + age + "\n 生日：" + birthday;
	}

	@Override
	public int compareTo(Employee employee) {
		return this.name.compareTo(employee.name);
	}

}
