package bid;

/*
 * 企鹅类：
 *   属性包括：名字，颜色
 *   方法包括：飞，吃，游泳
 */
public class Penguin extends Bird {

	public Penguin() {
		super();
	}

	public Penguin(String name, String color) {
		super(name, color);
	}

	@Override
	public void fly() {
		System.out.println("我是" + getName() + ",我太胖了,所以不会飞");
	}

	@Override
	public void eat() {
		System.out.println("我喜欢吃鱼.");
	}

	public void swim() {
		System.out.println("虽然我很胖,但我比鱼游得快");
	}

}
