package reflection;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class NewInstanceTest {
	@Test
	void test1() throws Exception {
		Class< Person> clazz = Person.class;
		@SuppressWarnings("deprecation")
		Person newInstance = clazz.newInstance();
		System.out.println(newInstance);
	}
}
