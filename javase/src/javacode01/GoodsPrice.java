package javacode01;

import java.util.Scanner;

/*
 * 2. 张浩从超市购买了10件商品,编写一个程序,用于接收每件商品的价格,计算应付的总金额并输出.
 */
public class GoodsPrice {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		double[] prices = new double[10];
		System.out.println("请输入10件商品的价格：");
		for (int i = 0; i < 10; i++) {
			prices[i] = scanner.nextDouble();
		}
		double sumPrice = 0;
		for (int i = 0; i < 10; i++) {
			System.out.println("第" + (i + 1) + "件商品的价格为：" + prices[i]);
			sumPrice += prices[i];
		}
		double priceSum = Double.parseDouble(String.format("%.2f", sumPrice));
		System.out.println("商品总价为：" + priceSum);
	}

}
