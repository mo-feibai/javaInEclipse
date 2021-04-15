package bid;

/*
 * 请使用面向对象的思想，设计自定义类描述麻雀和企鹅的信息
	要求：
	1、分析麻雀和企鹅的公共成员，提取出父类---鸟类
	2、利用继承机制，实现麻雀类和企鹅类
	3、利用封装机制，设置属性的私有访问权限，通过公有的get，
	set 方法实现对属性的访问
	4、编写测试类，分别测试鸟类，麻雀类和企鹅类的对象及相关
	方法（测试数据信息自定）
	5、定义名为 bid 的包存放鸟类、麻雀类、企鹅类和测试类
 */
public class Test {
	public static void main(String[] args) {
		Bird bird = new Bird("鸟", "黑色");
		bird.eat();
		bird.fly();
		System.out.println("=======================================");
		Spadger spadger = new Spadger("麻雀嘟嘟", "白色");
		spadger.fly();
		spadger.eat();
		System.out.println("=======================================");
		Penguin penguin = new Penguin("企鹅QQ", "红色");
		penguin.fly();
		penguin.eat();
		penguin.swim();
	}
}
