package javaexer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * 利用HashSet去除重复的数字
 * 
 * @author mofeibai
 *
 */
public class DuplicateList {
	public void duplicateList(List<Object> list) {
		HashSet<Object> hashSet = new HashSet<Object>();
		if (hashSet.addAll(list)) {
			System.out.println("筛选成功");
			Iterator<Object> iterator = hashSet.iterator();
			while (iterator.hasNext()) {
				System.out.println(iterator.next());

			}
		} else {
			System.out.println("筛选失败");
		}
	}

	@Test
	public void test() {
		List<Object> list = new ArrayList<Object>();
		list.add(123);
		list.add(123);
		list.add(456);
		list.add(456);
		list.add("chee");
		list.add("chea");
		duplicateList(list);
	}
}
