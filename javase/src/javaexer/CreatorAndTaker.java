package javaexer;

import java.util.ArrayList;
import java.util.List;

public class CreatorAndTaker {

	public static void main(String[] args) {
		// 创建一个公共的包裹
		MyPackage myPackage = new MyPackage();
		// 创建3个 Creater 制作物品
		Creater creater1 = new Creater("制造者1", myPackage);
		Creater creater2 = new Creater("制造者2", myPackage);
		Creater creater3 = new Creater("制造者3", myPackage);

		creater1.start();
		creater2.start();
		creater3.start();
		// 创建4个 Taker 取出物品
		Taker taker1 = new Taker("拿取者1", myPackage);
		Taker taker2 = new Taker("拿取者2", myPackage);
		Taker taker3 = new Taker("拿取者3", myPackage);
		Taker taker4 = new Taker("拿取者4", myPackage);

		taker1.start();
		taker2.start();
		taker3.start();
		taker4.start();

	}

}

// 存储物品的包
class MyPackage {

	/**
	 * 物品存放处
	 */
	public static List<Object> list = new ArrayList<Object>();
	/**
	 * 最大存储的物品数量
	 */
	public static final int MAX = 20;

	/**
	 * 存入一个物品
	 */
	public static void save(Object obj) {
		list.add(obj);
	}

	/**
	 * 取出一个物品(每次取出最后一个)
	 */
	public static Object take() {
		return list.remove(list.size() - 1);
	}

	/**
	 * 获取包裹存的物品的数量
	 */
	public static int objNums() {
		return list.size();
	}

	/**
	 * 判断包裹是否为空
	 */
	public static boolean isEmpty() {
		return list.size() == 0;
	}

	/**
	 * 判断包裹是否为满
	 */
	public static boolean isFull() {
		return list.size() == MAX;

	}

	/**
	 * 包裹为空的标志
	 */
	public static boolean emptyFlag = true;
	/**
	 * 包裹为满的标志
	 */
	public static boolean fullFlag = false;
}

// 制作者
class Creater extends Thread {
	// 创造者的名称
	private String name;
	// 存储物品的包
	private MyPackage p;

	Creater(String name, MyPackage p) {
		super();
		this.name = name;
		this.p = p;
	}

	@Override
	public void run() {
		// 制作物品, 直到存储物品的包满了时停止制作
		// 每制作一个物品, 并输出当前 存储物品的包 中已有物品数量
		while (true) {
			synchronized (p) {
				if (MyPackage.fullFlag) {
					break;
				}
				if (MyPackage.isFull()) {
					System.out.println("包裹已满，停止制作，可以取出。");
					MyPackage.fullFlag = true;
					p.notifyAll();

				} else {
					System.out.println(this.name + "正在制作中。。。");
					MyPackage.save(new Object());
					MyPackage.emptyFlag = false;
					System.out.println("包裹中有" + MyPackage.objNums() + "个物品。");
				}

			}
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
	}
}

// 取出者
class Taker extends Thread {
	// 拿取者的名称
	private String name;
	// 存储物品的包
	private MyPackage p;

	Taker(String name, MyPackage p) {
		super();
		this.name = name;
		this.p = p;
	}

	@Override
	public void run() {
		// 1.当存储物品的包满了时,开始执行取出物品操作
		// 2.取出物品, 直到存储物品的包空了时停止操作
		// 每取出一个物品, 并输出当前 存储物品的包中剩余物品数量

		while (true) {
			synchronized (p) {
				if (!MyPackage.fullFlag) {
					try {
						p.wait();
					} catch (InterruptedException e) {

						e.printStackTrace();
					}
				}
				if (MyPackage.emptyFlag) {
					break;
				}
				if (MyPackage.isEmpty()) {
					MyPackage.emptyFlag = true;
					System.out.println("包裹已空，退出操作。");
				} else {

					System.out.println(this.name + "正在拿出。。。");
					MyPackage.take();
					System.out.println("包裹中有" + MyPackage.objNums() + "个物品。");
				}
			}
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
	}

}
