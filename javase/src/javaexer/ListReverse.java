package javaexer;

/**
 * 请从键盘随机输入10个整数保存到List中，并按倒序、从大 到小的顺序显示出来
 * @author mofeibai
 * @date 2021年3月29日下午11:54:05
 */

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

public class ListReverse {
	@Test
	void listReverse() throws Exception {
		final int TIMES = 10;
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		List<Object> list = new ArrayList<>();
		for (int i = 1; i <= TIMES; i++) {
			System.out.println("请输入第" + i + "个整数：");
			list.add(scanner.nextInt());
		}
		System.out.println(list);
		Collections.reverse(list);
		System.out.println(list);
		Collections.sort(list, Collections.reverseOrder());
		System.out.println(list);
		
	}
}
