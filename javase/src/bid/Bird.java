package bid;

public class Bird {
	private String name;
	private String color;

	public Bird() {
		super();
	}

	public Bird(String name, String color) {
		super();
		this.name = name;
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void fly() {
		System.out.println("我是" + name + ",我会飞");
	}

	public void eat() {
		System.out.println("我是" + name + ",我吃的不是饭,是寂寞");
	}

}
