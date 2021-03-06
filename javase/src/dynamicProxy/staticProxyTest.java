package dynamicProxy;

/**
 * 静态代理举例 特点：代理类与被代理类在编译期间已经确定
 * 
 * @author mofeibai
 * @date 2021年4月15日下午10:56:34
 */
public class staticProxyTest {
	public static void main(String[] args) {
		XinJiangClothFactory xinJiangClothFactory = new XinJiangClothFactory();
		ProxyClothFactory proxyClothFactory = new ProxyClothFactory(xinJiangClothFactory);
		proxyClothFactory.produceCloth();
	}

}

interface ClothFactory {
	void produceCloth();
}

//代理类
class ProxyClothFactory implements ClothFactory {
	// 用被代理类对象实例化
	private ClothFactory factory;

	ProxyClothFactory(ClothFactory factory) {
		super();
		this.factory = factory;
	}

	@Override
	public void produceCloth() {
		System.out.println("代理工厂做一些准备工作");

		factory.produceCloth();

		System.out.println("代理工厂做一些后续的收尾工作");
	}

}

//被代理类
class XinJiangClothFactory implements ClothFactory {

	@Override
	public void produceCloth() {
		System.out.println("新疆棉花好啊");
	}

}
