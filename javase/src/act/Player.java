package act;

import reflection.compenent.Compenent;

@Compenent
public class Player extends Person {
	private String graduatedUniversity;
	private String masterpiece;

	public Player() {
		super();
	}

	public Player(String name, String gender, int age, String graduatedUniversity, String masterpiece) {
		super(name, gender, age);
		this.graduatedUniversity = graduatedUniversity;
		this.masterpiece = masterpiece;
	}

	@Override
	public void introduce() {
		System.out.println("大家好，我是" + getName());
		System.out.println("今年" + getAge());
		System.out.println("我毕业于：" + graduatedUniversity);
		System.out.println("代表作有：" + masterpiece);
		System.out.println("===================================================");
	}

}
