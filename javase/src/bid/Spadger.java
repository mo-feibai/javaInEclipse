package bid;

/*
 * 麻雀类：
 *   属性包括：名字，颜色
 *   方法包括：飞，吃
 */
public class Spadger extends Bird {

	public Spadger() {
		super();
	}

	public Spadger(String name, String color) {
		super(name, color);
	}

	@Override
	public void fly() {
		System.out.println("我是" + getName() + ",我动作敏捷,飞得比火箭快");
	}

	@Override
	public void eat() {
		System.out.println("我不仅吃种子,也吃害虫");
	}

}
