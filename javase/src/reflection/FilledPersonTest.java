package reflection;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class FilledPersonTest {
	@Test
	void test1() throws Exception {
		Class<FilledPerson> clazz = FilledPerson.class;

		// 获取属性结构
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			System.out.println(field);
		}
	}

	// 权限修饰符 数据类型 变量名
	@Test
	void test2() throws Exception {
		Class<FilledPerson> clazz = FilledPerson.class;

		Field[] declaredFields = clazz.getDeclaredFields();
		for (Field field : declaredFields) {
			System.out.println(field);
			// 权限修饰符
			System.out.println(Modifier.toString(field.getModifiers()));
			// 数据类型
			System.out.println(field.getType().getName());
			// 变量名
			System.out.println(field.getName());
			System.err.println();
		}
	}

	@Test
	public void methodTest() throws Exception {
		Class<FilledPerson> clazz = FilledPerson.class;
		Method[] methods = clazz.getDeclaredMethods();
		for (Method method : methods) {
			System.out.println(method);
			// 获取方法声明的注解
			Annotation[] annotations = method.getAnnotations();
			for (Annotation annotation : annotations) {
				System.out.println(annotation);
			}
			// 获取方法的权限修饰符
			System.out.println(Modifier.toString(method.getModifiers()));
			// 获取方法的返回值类型
			System.out.println(method.getReturnType().getName());
			// 获取方法名
			System.out.println(method.getName());
			// 获取方法形参列表
			Parameter[] parameters = method.getParameters();
			System.out.println(Arrays.toString(parameters));
			// 异常
			Class<?>[] exceptionTypes = method.getExceptionTypes();
			for (int i = 0; i < exceptionTypes.length; i++) {
				System.out.print(exceptionTypes[i].getName() + "\t");
			}
			System.out.println();
		}
	}

	// 获取构造器结构
	@Test
	void test3() throws Exception {
		Class<FilledPerson> clazz = FilledPerson.class;
		Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
		for (Constructor<?> constructor : declaredConstructors) {
			System.out.println(constructor);
		}
	}

	// 获取运行时类的父类
	@Test
	void test4() throws Exception {
		Class<FilledPerson> clazz = FilledPerson.class;
		Class<? super FilledPerson> superclass = clazz.getSuperclass();
		System.out.println(superclass.getName());
	}

	// 获取运行时类的带泛型的父类
	@Test
	void test5() throws Exception {
		Class<FilledPerson> clazz = FilledPerson.class;
		Type genericSuperclass = clazz.getGenericSuperclass();
		ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
		System.out.println(Arrays.toString(parameterizedType.getActualTypeArguments()));
	}

	// 获取运行时类实现的接口
	@Test
	void test6() throws Exception {
		Class<FilledPerson> clazz = FilledPerson.class;
		Class<?>[] interfaces = clazz.getInterfaces();
		for (Class<?> class1 : interfaces) {
			System.out.println(class1.getName());
		}

		// 获取运行时类的父类实现的接口
		Class<? super FilledPerson> superclass = clazz.getSuperclass();
		Class<?>[] interfaces2 = superclass.getInterfaces();
		for (Class<?> class1 : interfaces2) {
			System.out.println(class1.getName());
		}

	}

	// 获取运行时类所在的包
	@Test
	void test7() throws Exception {
		Class<FilledPerson> clazz = FilledPerson.class;

		Package package1 = clazz.getPackage();
		System.out.println(package1.getName());
		String packageName = clazz.getPackageName();
		System.out.println(packageName);

//		Package[] packages = Package.getPackages();
//		for (Package package2 : packages) {
//			System.out.println(package2.getName());
//		}
	}
	
	//获取运行时类声明的注解
	@Test
	void test8() throws Exception {
		Class<FilledPerson> clazz = FilledPerson.class;
		Annotation[] annotations = clazz.getAnnotations();
		for (Annotation annotation : annotations) {
			System.out.println(annotation);
		}
	}
}
