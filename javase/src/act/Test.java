package act;

/*
 * 请使用面向对象的思想，设计自定义类描述演员和运动员的信息
 * 演员类：
 * 	属性包括：姓名，年龄，性别，毕业院校，代表作
 * 	方法包括：自我介绍
 * 运动员类：
 * 	属性包括：姓名，年龄，性别，运动项目，历史最好成绩
 * 	法包括：自我介绍
 * 分析演员和运动员的公共成员，提取出父类---人类
 * 2、利用继承机制，实现演员类和运动员类
 * 3、利用封装机制，设置属性的私有访问权限，通过公有的get，set 方法实现对属性的访问
 * 4、编写测试类，分别测试人类，演员类和运动员类的对象及相关方法（测试数据信息自定）
 * 5、定义名为 act 的包存放人类、演员类、运动员类和测试类

 */
public class Test {
	public static void main(String[] args) {
		Person person = new Person();
		person.introduce();
		Player player = new Player("鱼梦", "女", 25, "北京电影学院", "《最好的我们》");
		player.introduce();
		Athlete athlete = new Athlete("李某", "男", 21, "调高", "2.25米");
		athlete.introduce();
	}

}
