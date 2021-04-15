package threadTest;

//测试
public class ProducerTest {
	public static void main(String[] args) {
		ProductPool pool = new ProductPool();
		Producer p1 = new Producer("tom", pool);
		Producer p2 = new Producer("JERRY", pool);
		
		Consumer c1 = new Consumer("miki", pool);
		Consumer c2 = new Consumer("MIQI", pool);
		
		p1.start();
		p2.start();
		c1.start();
		c2.start();
		// 生产者与消费者交替生产与消费, 永不停止.
	}
}
