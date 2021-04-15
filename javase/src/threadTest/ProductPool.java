package threadTest;

//缓冲区
//缓冲区, 存放商品的仓库
public class ProductPool {
	private int num;// 当前存放的商品数量
	private static final int MAX_NUM = 20;// 存放数量的最大值

	/**
	 * 存入1个商品
	 */
	public void put() {
		num++;
	}

	/**
	 * 取出1个商品
	 */
	public void get() {
		num--;
	}

	/**
	 * 当前存放的商品数量
	 * 
	 * @return num
	 */
	public int getNum() {
		return num;
	}

	/**
	 * 是否为空
	 * 
	 * @return true为空
	 */
	public boolean isEmpty() {
		return this.num == 0;
	}

	/**
	 * 是否已满
	 * 
	 * @return true为满
	 */
	public boolean isFull() {
		return this.num == MAX_NUM;
	}
}
