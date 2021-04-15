package javacode01;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.jupiter.api.Test;

public class CompareTest {
	/*
	 * Comparableʹ�þ���
	 */
	@Test
	public void test1() {
		String[] arr = new String[] { "MM", "AA", "KK", "BB", "ZZ", "FF" };
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
	}

	@Test
	public void test2() {
		Goods[] arr = new Goods[6];
		arr[0] = new Goods("lianxiang", 21.45);
		arr[1] = new Goods("xiaomi", 24.24);
		arr[2] = new Goods("daier", 45.24);
		arr[3] = new Goods("jingdong", 73.48);
		arr[4] = new Goods("weiruan", 73.48);
		arr[5] = new Goods("meizu", 73.48);

		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
	}

	@SuppressWarnings("unchecked")
	@Test
	public void test3() {
		String[] arr = new String[] { "MM", "AA", "KK", "BB", "ZZ", "FF" };
		// 按照字符串从大到小的顺序排序
		Arrays.sort(arr, new Comparator() {

			@Override
			public int compare(Object o1, Object o2) {
				if (o1 instanceof String && o2 instanceof String) {
					String s1 = (String) o1;
					String s2 = (String) o2;
					return -s1.compareTo(s2);
				}
				throw new RuntimeException("输入的类型不一致");
			}

		});
		System.out.println(Arrays.toString(arr));
	}

	@Test
	public void test4() {
		Goods[] arr = new Goods[7];
		arr[0] = new Goods("lianxiang",21.45);
		arr[1] = new Goods("xiaomi", 24.24);
		arr[2] = new Goods("daier", 45.24);
		arr[3] = new Goods("jingdong", 73.48);
		arr[4] = new Goods("weiruan", 73.48);
		arr[5] = new Goods("meizu", 73.48);
		arr[6] = new Goods("meizu", 34.24);
		
		Arrays.sort(arr,new Comparator<Object>() {
			//先按照产品名称从低到高，再按照价格从高到低
			@Override
			public int compare(Object o1, Object o2) {
				if(o1 instanceof Goods && o2 instanceof Goods) {
					Goods s1 = (Goods) o1;
					Goods s2 = (Goods) o2;
					if(s1.getName().equals(s2.getName())) {
						return -Double.compare(s1.getPrice(), s2.getPrice());
					}else {
						return s1.getName().compareTo(s2.getName());
					}
				}
				throw new RuntimeException("数据类型不一致");
			}
			
		});
		System.out.println(Arrays.toString(arr));
	}

}
