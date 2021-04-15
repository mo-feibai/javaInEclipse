package stream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class CharacterTimesTest {
//统计文本中字符出现的次数
	@Test
	void characterTimes() {
		File srcFile = new File("fileTest/dbcp.txt");
		HashMap<Character, Integer> result = new HashMap<>();
		FileReader reader = null;
		FileWriter writer = null;
		int prebuffer;
		char buffer;
		try {
			reader = new FileReader(srcFile);
			writer = new FileWriter("fileTest/characterTimesResults.txt");

			while ((prebuffer = reader.read()) != -1) {
				buffer = (char) prebuffer;
				result.put(buffer, (result.get(buffer) == null) ? 1 : (result.get(buffer) + 1));
			}
			writer.write("统计的文本名称为：" + srcFile.getName() + "\n");
			Set<Entry<Character, Integer>> entrySet = result.entrySet();
			Iterator<Entry<Character, Integer>> iterator = entrySet.iterator();
			while (iterator.hasNext()) {
				Entry<Character, Integer> entry = iterator.next();
				switch (entry.getKey()) {
				case ' ':
					writer.write("空格=" + entry.getValue() + "\n");
					break;
				case '\t':// \t表示tab 键字符
					writer.write("tab键=" + entry.getValue() + "\n");
					break;
				case '\r'://
					writer.write("回车=" + entry.getValue() + "\n");
					break;
				case '\n'://
					writer.write("换行=" + entry.getValue() + "\n");
					break;
				default:
					writer.write(entry.getKey() + "=" + entry.getValue() + "\n");
					break;
				}

			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} finally {

			try {
				reader.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
			try {
				writer.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

	}
}
