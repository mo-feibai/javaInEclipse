package stream;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.jupiter.api.Test;

public class BufferedStreamTest {
	@Test
	void BuffedStreamTest() {
		File srcFile = new File("D:\\Pictures\\桌面壁纸\\wallhaven-4doeqo.jpg");
		File destFile = new File("fileTest/美女2.jpg");

		FileInputStream inputStream;
		FileOutputStream outputStream;
		BufferedInputStream bufferedInputStream = null;
		BufferedOutputStream bufferedOutputStream = null;
		try {
			inputStream = new FileInputStream(srcFile);
			outputStream = new FileOutputStream(destFile);

			bufferedInputStream = new BufferedInputStream(inputStream);
			bufferedOutputStream = new BufferedOutputStream(outputStream);

			byte[] byteBuffer = new byte[10];
			int length;
			while ((length = bufferedInputStream.read(byteBuffer)) != -1) {
				bufferedOutputStream.write(byteBuffer, 0, length);
			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			try {
				bufferedInputStream.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
			try {
				bufferedOutputStream.close();
			} catch (IOException e) {

				e.printStackTrace();
			}

		}

	}

	@Test
	void BufferedWriterReaderTest() {
		File srcFile = new File("D:\\Desktop\\Java\\1_课件\\第2部分：Java高级编程\\尚硅谷_宋红康_第13章_IO流\\dbcp.txt");
		File destFile = new File("fileTest/" + srcFile.getName());

		BufferedReader bufferedReader = null;
		BufferedWriter bufferedWriter = null;
		try {
			FileReader reader = new FileReader(srcFile);
			FileWriter writer = new FileWriter(destFile);

			bufferedReader = new BufferedReader(reader);
			bufferedWriter = new BufferedWriter(writer);
//			方式一：
//			char[] charBuffer = new char[1024];
//			int length;
//			while ((length = bufferedReader.read(charBuffer)) != -1) {
//				bufferedWriter.write(charBuffer, 0, length);
//			}

			String line;
			while ((line = bufferedReader.readLine()) != null) {
				// bufferedWriter.write(line + "\n");
				bufferedWriter.write(line);
				bufferedWriter.newLine();
			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} finally {

			try {
				bufferedReader.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
			try {
				bufferedWriter.close();
			} catch (IOException e) {

				e.printStackTrace();
			}

		}

	}
}
