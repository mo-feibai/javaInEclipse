package javacode03.gobang;

import java.util.Arrays;
import java.util.Scanner;

public class GoBangStart {
	public static void main(String[] args) {
		GoBang chess = GoBang.getInstance();
		chess.play();
	}
}

/**
 * 五子棋
 * 
 * @author mofeibai
 * @date 2021年4月3日下午4:06:30
 */
class GoBang {
	/**
	 * 棋盘的大小
	 */
	private static final int BOARD_SIZE = 9;
	/**
	 * 没有棋子时棋盘默认布局
	 */
	private static final String DEFAULT_STRING = "+ ";
	/**
	 * 白棋
	 */
	private static final String WHITE_CHESS = "⚫";
	/**
	 * 黑棋
	 */
	private static final String BLACK_CHESS = "⚪";

	String[][] chess = new String[BOARD_SIZE][BOARD_SIZE];
	Scanner scanner = new Scanner(System.in);

	private GoBang() {
	}

	/**
	 * 获取实例的方法
	 * 
	 * @return 获取一个五子棋类的实例
	 */
	public static GoBang getInstance() {
		return new GoBang();
	}

	/**
	 * 启动五子棋游戏的方法
	 */
	void play() {
		initArray();
		printChessBox();
		doChess();
	}

	/**
	 * 初始化二维数组的方法
	 */
	private void initArray() {
		for (int i = 0; i < BOARD_SIZE; i++) {
			for (int j = 0; j < BOARD_SIZE; j++) {
				Arrays.fill(chess[i], DEFAULT_STRING);
			}
		}
	}

	/**
	 * 打印棋盘的方法
	 */
	private void printChessBox() {
		String input;
		for (int i = 0; i < BOARD_SIZE; i++) {
			for (int j = 0; j < BOARD_SIZE; j++) {

				input = (j != BOARD_SIZE - 1) ? chess[i][j] + "----" : chess[i][j];
				System.out.print(input);

			}
			System.out.println(" " + i);
			if (i != BOARD_SIZE - 1) {
				for (int j = 0; j < chess[i].length; j++) {
					System.out.print("|     ");
				}

			} else {
				for (int j = 0; j < chess[i].length; j++) {
					System.out.print(j + "     ");
				}
			}
			System.out.println();
		}

	}

	/**
	 * 下棋的方法
	 */
	private void doChess() {
		// 棋子的数量，用于判断哪方下棋和判断是否占满棋盘
		int count = 0;

		while (true) {
			if (count == BOARD_SIZE * BOARD_SIZE) {
				System.out.println("棋盘已满，游戏结束！");
				break;
			}
			if (count % 2 == 0) {
				System.out.print("请白方落子(行/列)：");
			} else {
				System.out.print("请黑方落子(行/列)：");
			}
			// 存取玩家输入的下棋的位置
			String chessLocs[];
			// 获取玩家下棋的坐标
			int x, y;

			chessLocs = scanner.next().split("/");
			if (chessLocs.length != 2) {
				System.out.println("请按格式输入");
				continue;
			}
			x = Integer.valueOf(chessLocs[0]);
			y = Integer.valueOf(chessLocs[1]);
			if (x >= BOARD_SIZE || x < 0 || y >= BOARD_SIZE || y < 0) {
				System.out.println("输入错误，超出棋盘范围！");
				continue;
			}
			if (!chess[x][y].equals(DEFAULT_STRING)) {
				System.out.println("该位置已经落子！");
				continue;
			} else {
				chess[x][y] = count % 2 == 0 ? WHITE_CHESS : BLACK_CHESS;
				printChessBox();
				if (isWin(x, y)) {
					System.out.println(chess[x][y] + "赢得胜利！");
					break;
				}
				count++;
			}
		}
	}

	/**
	 * 判断该步结束后是否产生输赢结果
	 * 
	 * @param chessx 玩家下棋的x坐标
	 * @param chessy 玩家下棋的y坐标
	 * @return 返回输赢的boolean值
	 */
	private boolean isWin(int chessx, int chessy) {
		return chessCount(chessx, chessy, -1, 1, 0, 0) >= 5 || chessCount(chessx, chessy, 0, 0, -1, 1) >= 5
				|| chessCount(chessx, chessy, -1, 1, 1, -1) >= 5 || chessCount(chessx, chessy, -1, 1, -1, 1) >= 5;

	}

	/**
	 * 计算该步结束后棋子连成线的个数<br>
	 * 规定：以该步下的棋子为原点，向下向右为正，向左向上为负;<br>
	 * 比如：chessCount(chessx, chessy, -1, 1, 0, 0)即表示在x轴上向左向右每次一格比较，即比较水平方向上棋子连线个数
	 * 
	 * @param chessx 该步下的棋子的x坐标
	 * @param chessy 该步下的棋子的y坐标
	 * @param xlstep 计算个数时每次往左一格x坐标变动
	 * @param xrstep 计算个数时每次往右一格x坐标变动
	 * @param ylstep 计算个数时每次往左一格y坐标变动
	 * @param yrstep 计算个数时每次往左一格y坐标变动
	 * @return 棋子连成线的个数
	 */
	private int chessCount(int chessx, int chessy, int xlstep, int xrstep, int ylstep, int yrstep) {
		int chessCount = -1; // -1是因为往左往右都和原棋子比较了一次，多了一次去掉
		// 这四个变量分别控制向左向右向上向下移动坐标
		int xl = chessx, xr = chessx, yl = chessy, yr = chessy;
		while (xl >= 0 && yl >= 0 && yl < BOARD_SIZE) {
			if (chess[chessx][chessy].equals(chess[xl][yl])) {
				xl += xlstep;
				yl += ylstep;
				chessCount++;
			} else {
				break;
			}
		}
		while (xr < BOARD_SIZE && yr >= 0 && yr < BOARD_SIZE) {
			if (chess[chessx][chessy].equals(chess[xr][yr])) {

				xr += xrstep;
				yr += yrstep;
				chessCount++;
			} else {
				break;
			}
		}
		return chessCount;
	}

}
