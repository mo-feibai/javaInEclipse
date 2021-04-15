package stream;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.jupiter.api.Test;

public class FileReaderWriter {
	@Test
	void test() {
		FileReader reader = null;
		try {
			File file = new File("fileTest/hello.txt");
			reader = new FileReader(file);
			int read;
			while ((read = reader.read()) != -1) {
				System.out.print((char) read);
			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} finally {

			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
	}

	// 使用read()的重载方法
	@Test
	void test1() {
		FileReader reader = null;
		try {
			File file = new File("fileTest/hello.txt");
			reader = new FileReader(file);
			char[] cbuffer = new char[5];
			int length;
			while ((length = reader.read(cbuffer)) != -1) {
				for (int i = 0; i < length; i++) {
					System.out.print(cbuffer[i]);
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
		}
	}

	@Test
	void writeTest() {
		FileWriter writer = null;
		try {
			File file = new File("fileTest/world.txt");
			writer = new FileWriter(file);
			writer.write("I have a dream!\n");
			writer.write("You need a dream,too!");
		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (IOException e) {

				e.printStackTrace();
			}

		}
	}

	@Test
	void ReadWriteTest() {
		File readFile = new File("fileTest/world.txt");
		File writeFile = new File("fileTest/hi.txt");
		FileReader reader = null;
		FileWriter writer = null;
		try {
			reader = new FileReader(readFile);
			writer = new FileWriter(writeFile);
			char[] readTool = new char[6];
			int length;
			while ((length = reader.read(readTool)) != -1) {

				writer.write(readTool, 0, length);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} finally {

			try {
				if (reader != null) {
					reader.close();

				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (reader != null) {
					writer.close();

				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	@Test
	void picCopy() {
		File srcFile = new File("fileTest/test.jpg");
		File descFile = new File("fileTest/美女.jpg");

		FileInputStream inputStream = null;
		FileOutputStream outputStream = null;
		try {
			inputStream = new FileInputStream(srcFile);
			outputStream = new FileOutputStream(descFile);

			byte[] byteBuffer = new byte[10];
			int length;
			while ((length = inputStream.read(byteBuffer)) != -1) {
				outputStream.write(byteBuffer, 0, length);
			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} finally {

			try {
				inputStream.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
			try {
				outputStream.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
	}
}
