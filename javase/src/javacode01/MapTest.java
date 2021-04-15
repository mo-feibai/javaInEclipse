package javacode01;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class MapTest {
	@Test
	public void test1() {
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("name", "jack");
		map.put("name", "bob");
		map.put("age", 12);
		map.put("age", 15);
		map.put("hiredate", LocalDate.of(2011, 05, 23));
		System.out.println(map);

		Map<Object, Object> map1 = new HashMap<Object, Object>();
		map1.put("sex", "男");
		map1.put("salary", 20000.00);

		map.putAll(map1);
		System.out.println(map);

//		map.remove("age");
//		System.out.println(map);

		map.remove("age", 15);
		boolean remove = map.remove("age", 12);
		System.out.println(remove);
		System.out.println(map);

		map.clear();
		System.out.println(map.size());
	}

	@Test
	void test2() throws Exception {
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("name", "jack");
		map.put("name", "bob");
		map.put("age", 12);
		map.put("age", 15);
		map.put("sale", 15);
		map.put("hiredate", LocalDate.of(2011, 05, 23));
		System.out.println(map.get("age"));
		System.out.println(map.get("sum"));
		System.out.println(map.containsKey("hiredate"));
		System.out.println(map.containsKey(11));
		System.out.println(map.containsValue(15));
		System.out.println(map.containsValue(12));
		Map<Object, Object> map1 = new HashMap<Object, Object>();
		map1.put("name", "jack");
		map1.put("name", "bob");
		map1.put("age", 12);
		map1.put("age", 15);
		map1.put("sale", 15);
		map1.put("hiredate", LocalDate.of(2011, 05, 23));
		System.out.println(map.equals(map1));
	}

	@Test
	void test3() throws Exception {
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("name", "jack");
		map.put("name", "bob");
		map.put("age", 12);
		map.put("age", 15);
		map.put("sale", 15);
		map.put("hiredate", LocalDate.of(2011, 05, 23));
		Set<Object> keySet = map.keySet();
		Iterator<Object> iterator = keySet.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		System.out.println("---------------------------------------");
		Collection<Object> values = map.values();
		Iterator<Object> iterator2 = values.iterator();
		while (iterator2.hasNext()) {
			System.out.println(iterator2.next());
		}
		System.out.println("---------------------------------------");
		Set<Entry<Object, Object>> entrySet = map.entrySet();
		Iterator<Entry<Object, Object>> iterator3 = entrySet.iterator();
		while (iterator3.hasNext()) {
			Entry<Object, Object> entry = iterator3.next();
			System.out.println();
			System.out.println(entry.getKey() + "---" + entry.getValue());
		}
		System.out.println("--------------------------------------");
		Set<Object> keySet2 = map.keySet();
		Iterator<Object> iterator4 = keySet2.iterator();
		while (iterator4.hasNext()) {
			Object key = iterator4.next();
			Object value = map.get(key);
			System.out.println(key + "---" + value);
		}

	}
}
