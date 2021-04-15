package stream;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


import org.junit.jupiter.api.Test;

public class OtherStreamTest {
	/*
	 * 从键盘输入字符串，要求将读取到的整行字符串转成大写输出。然后继续进行输入操作，直至当输入“e”或者“exit”时，退出程序。
	 */
	@Test
	void standardStream() {
		InputStreamReader inputStreamReader = new InputStreamReader(System.in);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

		String line;
		try {
			while ((line = bufferedReader.readLine()) != null) {
				if ("e".equals(line) || "exit".equals(line)) {
					break;
				}
				System.out.println(line.toUpperCase());
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
