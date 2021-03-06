	package reflection;

@MyAnnotation(value = "hi")
public class FilledPerson extends Creature<String> implements Comparable<String>, MyInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4777726694176138208L;
	private String name;
	int age;
	public int id;

	public FilledPerson() {
		super();
	}

	@MyAnnotation(value = "abc")
	private FilledPerson(String name) {
		this.name = name;
	}

	FilledPerson(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public void info() {
		System.out.println("我是一个人");
	}

	@Override
	public int compareTo(String o) {
		return 0;
	}

	@MyAnnotation
	private String show(String nation) {
		System.out.println("我的国籍是" + nation);
		return nation;
	}

	public String display(String interests, int age) throws NullPointerException, ClassCastException {
		return interests + "_" + age;
	}

}
