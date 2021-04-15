package javaexer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
/**
 * 模拟存储柜的存取过程
 * @author 查超
 * @date 2021年4月7日下午9:23:38
 */
public class StoreBox {
	Scanner scanner = new Scanner(System.in);
	private static final int BOX_SIZE = 3; // 柜子的每行存储个数
	private static final String DEFAULT_STRING = "□-"; // 柜子为空时数组存储的默认字符串
	private ArrayList<String> emptyBox = new ArrayList<>(BOX_SIZE * BOX_SIZE); // 用于存储空柜子的位置

	// 程序入口
	public static void main(String[] args) {
		StoreBox box = new StoreBox();
		box.start();
	}

	/*
	 * 初始化用于存储信息的二维数组，并运行储物柜程序，显示主界面
	 */
	private void start() {

		for (int i = 0; i < BOX_SIZE; i++) {
			for (int j = 0; j < BOX_SIZE; j++) {
				Arrays.fill(box[i], DEFAULT_STRING);
				emptyBox.add(i + "/" + j);
			}
		}

		mainMenu();

	}

	/*
	 * 用于保存凭证 key String 凭证字符串 value Integer[] 储物柜的小格子的坐标x,y
	 */
	private HashMap<String, Integer[]> ticketMap = new HashMap<String, Integer[]>();

	// 作为储物柜的二维数组，x,y表示行列
	private String[][] box = new String[BOX_SIZE][BOX_SIZE];

	/*
	 * 显示主界面的方法
	 */
	private void mainMenu() {
		final int SAVE = 1; // 标识存
		final int TAKE = 2; // 标识取
		System.out.println("------------欢迎使用mofeibai储物柜------------------");
		print();
		System.out.print("请输入您想要进行的操作（1.存物  2.取物）：");
		switch (scanner.nextInt()) {
		case SAVE:
			if (emptyBox.isEmpty()) {
				System.out.println("储物柜已存满，请等待空位。。。");
				break;
			}
			save();
			break;
		case TAKE:
			take();
			break;
		default:
			System.out.println("输入错误！");
		}
		mainMenu();
	}

	/*
	 * 打印存储柜的方法
	 */
	public void print() {
		for (int i = 0; i < BOX_SIZE; i++) {
			System.out.println("+---+---+---+");
			for (int j = 0; j < BOX_SIZE; j++) {
				System.out.print("| " + box[i][j].split("-")[0] + " ");
			}
			System.out.println("|");
		}
		System.out.println("+---+---+---+");
	}

	/**
	 * 往存储柜中存入信息的方法
	 */
	public void save() {
		// 标识凭证的长度
		final int KEY_LENGTH = 6;
		// 从字符串中选取任意一个字符
		String chooseCharacter = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
		// 选取的字符放入字符数组中
		char[] keyChars = new char[KEY_LENGTH];

		for (int i = 0; i < KEY_LENGTH; i++) {
			keyChars[i] = chooseCharacter.charAt(new Random().nextInt(chooseCharacter.length()));
		}
		// 生成的凭证
		String boxKey = new String(keyChars);
		// 可用于存储信息的随机一个空柜子
		String saveBox = emptyBox.remove(new Random().nextInt(emptyBox.size()));
		System.out.println("请输入您想存入的信息：");
		// 用户输入的用于存储的信息
		String saveInfo = scanner.next();
		// 空柜子的位置
		int saveBoxLocX = Integer.valueOf(saveBox.split("/")[0]);
		int saveBoxLocY = Integer.valueOf(saveBox.split("/")[1]);
		// 将信息存入柜子并更改柜子的状态
		box[saveBoxLocX][saveBoxLocY] = "■-" + saveInfo;
		// 将凭证信息与位置信息关联
		ticketMap.put(boxKey, new Integer[] { saveBoxLocX, saveBoxLocY });

		System.out.println("您的凭证为：" + boxKey + ",请妥善保存。");
		System.out.println("存入成功，返回主页面。。。");
		mainMenu();
	}

	/**
	 * 从存储柜中取出信息的方法
	 */
	public void take() {
		// 用户输入的用于校验的凭证
		String checkingKey;
		// 是否退出取物过程，回到主界面
		boolean flag = true;
		while (true) {
			System.out.print("请输入您的用户凭证(输入\"exit\"退出)：");
			checkingKey = scanner.next();

			if ("exit".equals(checkingKey.toLowerCase())) {
				flag = false;
				break;
			}
			if (ticketMap.containsKey(checkingKey)) {
				break;
			}

			System.out.println("输入凭证无效，请重新输入(输入\"exit\"退出)！");
		}
		if (flag) {
			// 待取信息的位置
			Integer[] loc = ticketMap.get(checkingKey);

			System.out.println("您存入的信息为：" + box[loc[0]][loc[1]].split("-")[1]);
			// 更改取走信息的柜子状态为默认状态
			box[loc[0]][loc[1]] = DEFAULT_STRING;
			// 将取出信息的柜子加入空柜子集合中
			emptyBox.add(loc[0] + "/" + loc[1]);
			System.out.println("取出成功");
		}
		mainMenu();
	}

}
