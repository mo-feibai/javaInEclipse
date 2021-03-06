package stream;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import org.junit.jupiter.api.Test;

public class RandomAccessFileTest {
	@Test
	void test1() {
		RandomAccessFile randomAccessFile = null;
		try {
			randomAccessFile = new RandomAccessFile("fileTest/hello.txt", "rw");
			randomAccessFile.seek(new File("fileTest/hello.txt").length());
			randomAccessFile.write("学习新思想，争做新青年".getBytes());
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			try {
				randomAccessFile.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
	}

	@Test
	void test2() {
		File file = new File("fileTest/hello.txt");
		RandomAccessFile randomAccessFile = null;
		int startLoc = 3;
		String insertStr = "xyz";
		try {
			randomAccessFile = new RandomAccessFile(file, "rw");
			randomAccessFile.seek(startLoc);
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//			StringBuilder builder = new StringBuilder((int) file.length());
			int length;
			byte[] byteBuffer = new byte[40];
			while ((length = randomAccessFile.read(byteBuffer)) != -1) {
//				builder.append(new String(byteBuffer, 0, length));
				byteArrayOutputStream.write(byteBuffer, 0, length);
			}
			randomAccessFile.seek(startLoc);
			randomAccessFile.write(insertStr.getBytes());
//			randomAccessFile.write(builder.toString().getBytes());
			randomAccessFile.write(byteArrayOutputStream.toByteArray());
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			try {
				randomAccessFile.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
	}
}
