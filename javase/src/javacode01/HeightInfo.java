package javacode01;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/*
 * 1.	某班举行男篮候选人的选拔赛,第一关就是比身高,如何选出身高的前5名呢?
 * 		编程实现:录入班级学生的身高,输出前5名的身高数.

 */
public class HeightInfo {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("请输入班级人数：");
		int number = scanner.nextInt();	
		Integer[] heights = new Integer[number];
		System.out.println("请依次输入身高（cm）：");
		for (int i = 0; i < number; i++) {
			System.out.println("第" + (i + 1) + "人身高：");
			heights[i] = scanner.nextInt();
		}
		Arrays.sort(heights,Collections.reverseOrder());
		if (number <= 5) {
			for (int i = 0; i < number; i++) {
				System.out.println("第" + (i + 1) + "名的身高为：" + heights[i] + "cm");
			}
		} else {
			for (int i = 0; i < 5; i++) {
				System.out.println("第" + (i + 1) + "名的身高为：" + heights[i] + "cm");
			}
		}
	}
}
