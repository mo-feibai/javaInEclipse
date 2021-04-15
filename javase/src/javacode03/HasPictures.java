package javacode03;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.Test;

public class HasPictures {
	@Test
	void hasPictures() throws Exception {
		File file = new File("D:\\Pictures\\桌面壁纸");
		String[] picList = file.list();
		String regex = ".*?\\.jpg";
		int count = 0;
		for (String pic : picList) {
			if (pic.matches(regex)) {
				System.out.println(pic);
				count++;
			}
		}
		System.out.println("一共有" + count + "张图片");
	}

	@Test
	void fileName() throws Exception {
		File file = new File("D:\\Download");
		String mark = "";
		getFile(file, mark);

	}

	void getFile(File file, String mark) {

		File[] fileList = file.listFiles();
		for (int i = 0; i < fileList.length; i++) {
			if (fileList[i].isDirectory()) {
				getFile(fileList[i], mark + "." + (i + 1));
			} else {
				System.out.println(mark + fileList[i]);
			}
		}
	}

}
