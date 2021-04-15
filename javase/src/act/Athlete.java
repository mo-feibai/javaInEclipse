package act;

public class Athlete extends Person {
	private String project; // 项目
	private String bestPerformance; // 历史最好成绩

	public Athlete() {
		super();
	}

	public Athlete(String name, String gender, int age, String project, String bestPerformance) {
		super(name, gender, age);
		this.project = project;
		this.bestPerformance = bestPerformance;
	}
	
	@Override
	public void introduce() {
		System.out.println("大家好，我是" + getName());
		System.out.println("今年" + getAge());
		System.out.println("我擅长的运动项目是：" + project);
		System.out.println("历史最好成绩是：" + bestPerformance);
		System.out.println("===================================================");
	}

}
