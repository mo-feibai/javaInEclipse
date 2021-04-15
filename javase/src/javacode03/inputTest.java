package javacode03;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

public class inputTest {
	@Test
	void test1() throws Exception {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Integer> arrayList = new ArrayList<>();
		int number;
		while (true) {
			System.out.print("请输入一个整数(以0结束):");
			number = scanner.nextInt();
			if (number == 0) {
				break;
			}
			arrayList.add(number);
		}
		System.out.println(arrayList);
		for(int i = arrayList.size()-1;i>=0;i--) {
			if (arrayList.get(i) % 3 == 0) {
				int delNum = arrayList.remove(i);
				System.out.println("删除"+ delNum);
			}
		}
		System.out.println(arrayList);
	}
}
