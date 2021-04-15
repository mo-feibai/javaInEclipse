package stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.jupiter.api.Test;

public class PicTest {
	@Test
	void picEncrypt() {
		File srcFile = new File("fileTest/美女.jpg");
		File encryFile = new File("fileTest/" + srcFile.getName().split("\\.")[0] + "_encrypt");

		FileInputStream inputStream = null;
		FileOutputStream outputStream = null;
		try {
			inputStream = new FileInputStream(srcFile);
			outputStream = new FileOutputStream(encryFile);

			int buffer = 0;
			while ((buffer = inputStream.read()) != -1) {
				outputStream.write(buffer ^ 5);
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

	@Test
	void picDecrypt() {
		File srcFile = new File("fileTest/美女_encrypt");
		File encryFile = new File("fileTest/" + srcFile.getName().split("_")[0] + "1.jpg");

		FileInputStream inputStream = null;
		FileOutputStream outputStream = null;
		try {
			inputStream = new FileInputStream(srcFile);
			outputStream = new FileOutputStream(encryFile);

			int buffer = 0;
			while ((buffer = inputStream.read()) != -1) {
				outputStream.write(buffer ^ 5); // A^B^B = A
			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} finally {

			try {
				inputStream.close();
			} catch (IOException e1) {

				e1.printStackTrace();
			}
			try {
				outputStream.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

	}
}
