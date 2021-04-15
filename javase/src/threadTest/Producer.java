package threadTest;

//生产者
//生产者线程类
public class Producer extends Thread {
	private String name;//生产者名称
	private ProductPool pool;//存放的仓库
	public Producer(String name, ProductPool pool) {
		this.name = name;
		this.pool = pool;
	}
	@Override
	public void run() {
		// 需要做的事件:生产商品
		while(true){//一直在工作
			// 核心代码, 要保证线程安全
			synchronized (pool) {
				if(pool.isFull()){
					// 已满, 通知消费者 消费, 并休眠
					pool.notifyAll();
					try {
						pool.wait();
					} catch (InterruptedException e) {
						//e.printStackTrace();
					}
					System.out.println("生产者[" + this.name + "]被唤醒");
				}else{
					// 仓库未满,存入
					pool.put();
					System.out.println("生产者[" + this.name + "]生产一个商品,存量: "+pool.getNum());
				}
			}
			// 每生产一个商品休息一下
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
