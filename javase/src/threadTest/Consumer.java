package threadTest;

// 消费者
//消费者线程
public class Consumer extends Thread {
	private String name;// 消费者名称
	private ProductPool pool;// 取出的仓库

	public Consumer(String name, ProductPool pool) {
		this.name = name;
		this.pool = pool;
	}

	@Override
	public void run() {
		// 需要做的事件:消费商品
		while (true) {// 一直在消费
			// 核心代码, 要保证线程安全
			synchronized (pool) {
				if (pool.isEmpty()) {
					// 空, 通知生产者 生产, 并休眠
					pool.notifyAll();
					try {
						pool.wait();
					} catch (InterruptedException e) {
						// e.printStackTrace();
					}
					System.out.println("消费者[" + this.name + "]被唤醒");
				} else {
					// 不空, 消费
					pool.get();
					System.out.println("消费者[" + this.name + "]消费一个商品,存量: " + pool.getNum());
				}
			}
			// 每消费一个商品休息一下
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}