package javacode02;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class GenericTest {
	@Test
	void test() throws Exception {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		arrayList.add(13);
		arrayList.add(34);
		arrayList.add(123);
		
		for(Integer score : arrayList) {
			System.out.println(score);
		}
	}
}
