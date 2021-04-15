package javacode01;

import java.io.FileInputStream;
import java.util.Properties;

import org.junit.jupiter.api.Test;

public class PropertiesTest {
	@Test
	void testName() throws Exception {
		Properties properties = new Properties();
		FileInputStream fls = new FileInputStream("jdbc.properties");
		properties.load(fls);

		String name = properties.getProperty("name");
		String password = properties.getProperty("password");
		System.out.println("name = " + name + ",password = " + password);
	}
}
