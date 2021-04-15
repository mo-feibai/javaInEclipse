package act;

public class Person {
	private String name;
	private String gender;
	private int age;

	public Person() {
		super();
	}

	public Person(String name, String gender, int age) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void introduce() {
		System.out.println("我就是一个普通老百姓。");
		System.out.println("===================================================");
	}
}
