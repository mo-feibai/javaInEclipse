package javacode01;

import java.lang.Thread.State;

import org.junit.jupiter.api.Test;

/**
 * 
 * 测试Season类
 * 
 * @author mofeibai
 *
 */

public class SeasonTest {
	@Test
	public static void test() {
		Season season = Season.SPRING;
		System.out.println(season.toString());
	}

	@Test
	public void test2() {
		SeasonEnum seasonEnum = SeasonEnum.AUTUMN;
		System.out.println(seasonEnum);
		System.out.println(SeasonEnum.class.getSuperclass());

		SeasonEnum[] values = SeasonEnum.values();
		for (SeasonEnum value : values) {
			System.out.println(value);

		}
		// 查看线程的状态
		State[] states = Thread.State.values();
		for (Thread.State state : states) {
			System.out.println(state);
		}
	}

	@Test
	public void test3() {
		SeasonEnum winter = SeasonEnum.valueOf("WINTER");
		State state = Thread.State.valueOf("BLOCKED");
		System.out.println(state);
		System.out.println(winter);
	}

	@Test
	public void test4() {
//		SeasonEnum.SUMMER.show();
//		SeasonEnum.SPRING.show();
//		SeasonEnum.AUTUMN.show();
//		SeasonEnum.WINTER.show();
		SeasonEnum[] seasons = SeasonEnum.values();
		for (SeasonEnum season : seasons) {
			season.show();
		}
	}

}
