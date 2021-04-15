package javacode01;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.jupiter.api.Test;

/**
 * System/Math/BigInteger 和 BigDecimal类的测试
 * @author mofeibai
 *
 */
public class OtherClassTest {
		@Test
		public void test1() {
			System.out.println(System.getProperty("java.version"));
			System.out.println(System.getProperty("java.home"));
			System.out.println(System.getProperty("os.name"));
			System.out.println(System.getProperty("os.version"));
			System.out.println(System.getProperty("user.name"));
			System.out.println(System.getProperty("user.home"));
			System.out.println(System.getProperty("user.dir"));
		}
		@Test
		public void test2() {
			BigDecimal bd = new BigDecimal(12314);
			BigDecimal bd2 = new BigDecimal(234);
			System.out.println(bd.divide(bd2, 3, RoundingMode.HALF_UP));
		}
	}
