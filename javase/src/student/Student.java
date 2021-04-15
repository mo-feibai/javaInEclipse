package student;

/*
 *  以面向对象的思想，编写自定义类描述学生。设定学生类的属性包括：姓名，年龄，性别，学号；方法包括：学习
 *  要求：
 *   1、设置属性的私有访问权限，通过公有的get，set 方法实现对属性的访问
 *   2、设计构造函数实现对所有属性赋值
 *   3、学习方法通过输入参数，接收就读学校和所学专业，输出个人的学习信息
 *   4、编写测试类，测试学生类的对象及相关方法（测试数据信息自定)
 */
public class Student {
	private String name;
	private int age;
	private String gender;
	private String id;

	public Student() {
		super();
	}

	public Student(String name, int age, String gender, String id) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.id = id;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void study(String university, String major) {
		System.out.println("大家好,我叫" + name + "!今年" + age);
		System.out.println("我现在就读于" + university + "---" + major + "专业");
		System.out.println("我的学号是" + id);
		System.out.println("======================================================");
	}
}
