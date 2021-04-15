package javacode03;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class FileUtilsTest {
	public static void main(String[] args) {

		File srcFile = new File("fileTest/美女.jpg");
		File destFile = new File("fileTest/美女5.jpg");
		
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
}
