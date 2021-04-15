package javaexer;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * 请把学生名与考试分数录入到集合中，并按分数显示前三名成绩学员的名字。
 * 
 * @author mofeibai
 * @date 2021年3月30日上午12:14:47
 */
public class ScoresSort {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		TreeSet<Student> set = new TreeSet<>(new Comparator<Object>() {

			@Override
			public int compare(Object o1, Object o2) {
				if (o1 instanceof Student && o2 instanceof Student) {
					Student stu1 = (Student) o1;
					Student stu2 = (Student) o2;
					return -Double.compare(stu1.getScore(), stu2.getScore());
				}
				throw new RuntimeException("传入数据类型不符合！");
			}
		});
		String name;
		double scores;
		while (true) {
			System.out.println("请分别输入学生姓名和成绩,以0 0结束:");
			Student student = new Student();
			name = scanner.next();
			scores = scanner.nextDouble();
			if (name.equals("0") && scores == 0.0) {
				break;
			}
			student.setName(name);
			student.setScore(scores);
			set.add(student);
		}
		int count = 0;
		for (Student student : set) {
			if (count == 3) {
				break;
			}
			count++;
			System.out.println("第" + count + "名学生的名字为：" + student.getName() + "成绩为：" + student.getScore());
		}

	}
}
