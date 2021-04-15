package javacode02;


import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class GenericTest1 {
	@Test
	void test1() throws Exception {
		Order<String> order = new Order<>("orderAA",1001,"order:AA");
		System.out.println(order.toString());
		subOrder<Integer> subOrder = new subOrder<>();
		subOrder.setOrderT(132);
	}
	
	
	@Test
	void testName() throws Exception {
		ArrayList<String> arrayList = null;
		ArrayList<Integer> arrayList2 = null;
//		arrayList = arrayList2;
	}
	
	@Test
	void test2() throws Exception {
		Order<String> order = new Order<>();
		Integer[] arr = new Integer[]{32,254,1234,1};
		List<Integer> copyFromArrayToList = order.copyFromArrayToList(arr);
		System.out.println(copyFromArrayToList);
		
	
	}
	@Test
	void test3() throws Exception {
		List<Object> list1 = null;
		List<String> list2 = null;
		
		List<?> list = null;
		list = list1;
		list = list2;  
		
		
		
		
	}
}
