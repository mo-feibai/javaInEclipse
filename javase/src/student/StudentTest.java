package student;

public class StudentTest {
	public static void main(String[] args) {
		Student student1 = new Student("阿宝", 25, "男", "S23401");
		student1.study("清华大学", "原子物理专业");
		Student student2 = new Student("郭美美", 23, "女", "Y12302");
		student2.study("清华大学", "原子物理专业");
	}
}
