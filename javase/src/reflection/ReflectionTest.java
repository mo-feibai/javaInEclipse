package reflection;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;

public class ReflectionTest {
	@Test
	void test1() throws Exception {
		Class<Person> classes = Person.class;
		System.out.println(classes);

		Person person = new Person();
		Class<? extends Person> classes2 = person.getClass();
		System.err.println(classes2);

		Class<?> forName = Class.forName("reflection.Person");
		System.out.println(forName);

		System.out.println(classes == classes2);
		System.out.println(classes == forName);

		ClassLoader classLoader = ReflectionTest.class.getClassLoader();
		Class<?> loadClass = classLoader.loadClass("reflection.Person");
		System.out.println(loadClass);
		System.out.println(classes == loadClass);
	}

	@Test
	void test2() throws Exception {
		Class<FilledPerson> filledPerson = FilledPerson.class;
		// 创建运行时类的对象
		FilledPerson newInstance = filledPerson.getConstructor().newInstance();
		// 获取指定的属性
		Field field = filledPerson.getDeclaredField("age");
		field.setAccessible(true);
		field.set(newInstance, 1001);
		int pid = (int) field.get(newInstance);
		System.out.println(pid);
	}

	@Test
	void test3() throws Exception {
		Class<FilledPerson> clazz = FilledPerson.class;
		FilledPerson person = clazz.getConstructor().newInstance();
		Method show = clazz.getDeclaredMethod("show", String.class);
		show.setAccessible(true);
		String nation = (String) show.invoke(person,"CHN");
		System.out.println(nation);
	}
}
