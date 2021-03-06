package dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理模式 解决的问题： 1. 如何根据加载到内存中的被代理类，动态创建一个代理类及其对象 2.
 * 当通过代理类对象调用方法时，如何动态调用被代理类的同名方法
 * 
 * @author mofeibai
 * @date 2021年4月15日下午11:07:12
 */
public class DynamicProxyTest {
	public static void main(String[] args) {
		// 代理类的对象
		Human proxyInstance = (Human) proxyFactory.getProxyInstance(new SuperMan());
		// 当通过代理类的对象调用方法时，会自动调用被代理类中同名的方法
		String belief = proxyInstance.getBelief();
		System.out.println(belief);
		proxyInstance.eat("麻辣香锅和牛肉");
		
		System.out.println("-------------------------------------");
		ClothFactory proxyInstance2 = (ClothFactory) proxyFactory.getProxyInstance(new XinJiangClothFactory());
		proxyInstance2.produceCloth();

	}
}

interface Human {
	String getBelief();

	void eat(String food);
}

//被代理类
class SuperMan implements Human {

	@Override
	public String getBelief() {

		return "I believe I can fly.";
	}

	@Override
	public void eat(String food) {
		System.out.println("我喜欢吃" + food);
	}

}

//生产代理类的工厂
class proxyFactory {
	// 调用此方法返回一个代理类的对象（问题一）
	public static Object getProxyInstance(Object obj) { // obj:被代理类的对象
		MyInvocationHandler myInvocationHandler = new MyInvocationHandler();
		myInvocationHandler.bind(obj);
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(),
				myInvocationHandler);
	}
}

class MyInvocationHandler implements InvocationHandler {
	// 赋值时，也需要使用被代理类的对象实例化
	private Object obj;

	// 当通过代理类的对象调用方法a时，就会自动调用如下方法：invoke()
	// 将被代理类要执行的方法a的功能声明在invoke()中
	public void bind(Object obj) {
		this.obj = obj;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// method即为代理类对象调用的方法，此方法也就作为被代理类对象对象要调用的方法
		// obj:被代理类的对象
		Object value = method.invoke(obj, args);
		// 上述方法的返回值就作为当前类中invoke()的返回值
		return value;
	}

}
