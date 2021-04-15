package stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import org.junit.jupiter.api.Test;

public class InputStreamReaderTest {
	@Test
	void test1() {
		InputStreamReader inputStreamReader = null;
		try {
			FileInputStream inputStream = new FileInputStream("fileTest/dbcp.txt");
			inputStreamReader = new InputStreamReader(inputStream, "UTF-8");

			char[] cbuffer = new char[100];
			int length;
			while ((length = inputStreamReader.read(cbuffer)) != -1) {
				for (int i = 0; i < length; i++) {
					System.out.print(cbuffer[i]);
				}
			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			try {
				inputStreamReader.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

	}

	@Test
	void test2() {
		InputStreamReader inputStreamReader = null;
		OutputStreamWriter outputStreamWriter = null;
		try {
			FileInputStream inputStream = new FileInputStream("fileTest/dbcp.txt");
			FileOutputStream outputStream = new FileOutputStream("fileTest/dbcp_gbk.txt");
			inputStreamReader = new InputStreamReader(inputStream, "utf-8");
			outputStreamWriter = new OutputStreamWriter(outputStream, "gbk");

			char[] cbuffer = new char[10];
			int length;
			while ((length = inputStreamReader.read(cbuffer)) != -1) {
				outputStreamWriter.write(cbuffer, 0, length);
			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			try {
				inputStreamReader.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
			try {
				outputStreamWriter.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
	}
}
